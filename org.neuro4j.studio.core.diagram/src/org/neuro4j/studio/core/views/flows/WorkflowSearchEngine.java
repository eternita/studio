/*
 * Copyright (c) 2013-2014, Neuro4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.neuro4j.studio.core.views.flows;

import java.util.List;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.FlowUtils;

public class WorkflowSearchEngine {

    private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

    public Object load(final List<ListEntry> workflows) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        // Get all projects in the workspace
        IProject[] projects = root.getProjects();
        // Loop over all projects
        for (IProject project : projects) {
            try {
                if (project.isNatureEnabled(JDT_NATURE)) {
                    analyzeProject(project, workflows);
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void analyzeProject(IProject project, List<ListEntry> flows) throws JavaModelException {
        IJavaProject javaProject = JavaCore.create(project);
        javaProject.getNonJavaResources();
        IPackageFragment[] packages = javaProject.getPackageFragments();
        for (IPackageFragment mypackage : packages) {
            if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                if (mypackage.isDefaultPackage())
                {
                    Folder f = (Folder) mypackage.getResource();
                    try {
                        IResource[] res = f.members();
                        for (IResource r : res)
                        {
                            if (r instanceof IFile)
                            {
                                IFile file = (IFile) r;
                                processFile(file, null, flows);
                            }
                        }
                    } catch (CoreException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    for (Object unit : mypackage.getNonJavaResources()) {

                        if (unit instanceof IFile)
                        {
                            IFile file = (IFile) unit;
                            processFile(file, mypackage, flows);
                        }

                    }
                }

            }

        }
    }

    private void processFile(IFile file, IPackageFragment mypackage, List<ListEntry> flows)
    {

        if (file.getFileExtension().equals("n4j"))
        {
            ListEntry entry = createEntryByFlow(file, mypackage);
            flows.add(entry);
        }
    }

    private ListEntry createEntryByFlow(IFile file, IPackageFragment mypackage)
    {
        ListEntry entry = new ListEntry(file);
        StringBuffer str = new StringBuffer();
        if (mypackage != null)
        {
            str.append(mypackage.getElementName());
            str.append(".");
        }
        str.append(file.getName());
        str.delete(str.length() - 4, str.length());

        entry.setMessage(str.toString());

        entry.setPluginId(file.getProject().getName());

        try {
            List<String> list = FlowUtils.getStartNodeList(file.getContents(), str.toString());
            for (String start : list)
            {
                ListEntry e = new ListEntry(file);
                e.setMessage(start);
                entry.addChild(e);
            }

        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entry;
    }

}