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
package org.neuro4j.studio.core.buildpath;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class Neuro4jContainerInitializer extends ClasspathContainerInitializer
{
    private static final IStatus NOT_SUPPORTED = new Status(4, "org.neuro4j.workflow", 1, new String(), null);
    private static final IStatus READ_ONLY = new Status(4, "org.neuro4j.workflow", 2, new String(), null);

    private static final String NEURO4J = "3.1.1";

    @Override
    public void initialize(IPath containerPath, IJavaProject project)
            throws CoreException
    {
        if (isValidJUnitContainerPath(containerPath)) {
            Neuro4jContainer container = getNewContainer(containerPath);
            JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project }, new IClasspathContainer[] { container }, null);
        }
    }

    private static Neuro4jContainer getNewContainer(IPath containerPath)
    {
        IClasspathEntry entry = null;
        IClasspathEntry entry2 = null;
        String version = containerPath.segment(1);
        if ((NEURO4J.equals(version))) {
            entry = BuildPathSupport.getNeuro4jCoreLibraryEntry();
            entry2 = BuildPathSupport.getNeuro4jLogicLibraryEntry();
        }
        IClasspathEntry[] entries;

        if (entry == null) {
            entries = new IClasspathEntry[0];
        }
        else
        {
            if (entry2 == null)
                entries = new IClasspathEntry[] { entry };
            else
                entries = new IClasspathEntry[] { entry, entry2 };
        }
        return new Neuro4jContainer(containerPath, entries);
    }

    private static boolean isValidJUnitContainerPath(IPath path)
    {
        return (path != null) && (path.segmentCount() == 2) && ("org.neuro4j.studio.core.NEURO4J_CONTAINER".equals(path.segment(0)));
    }

    @Override
    public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project)
    {
        return true;
    }

    @Override
    public IStatus getAccessRulesStatus(IPath containerPath, IJavaProject project)
    {
        return NOT_SUPPORTED;
    }

    @Override
    public IStatus getSourceAttachmentStatus(IPath containerPath, IJavaProject project)
    {
        return READ_ONLY;
    }

    @Override
    public IStatus getAttributeStatus(IPath containerPath, IJavaProject project, String attributeKey)
    {
        if (attributeKey.equals("javadoc_location")) {
            return Status.OK_STATUS;
        }
        return NOT_SUPPORTED;
    }

    @Override
    public void requestClasspathContainerUpdate(IPath containerPath, IJavaProject project, IClasspathContainer containerSuggestion)
            throws CoreException
    {
        IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.neuro4j.workflow");

        IClasspathEntry[] entries = containerSuggestion.getClasspathEntries();
        if ((entries.length >= 1) && (isValidJUnitContainerPath(containerPath))) {
            String version = containerPath.segment(1);

            for (int i = 0; i < entries.length; i++) {
                IClasspathEntry entry = entries[i];
                String preferenceKey = getPreferenceKey(entry, version);

                IClasspathAttribute[] extraAttributes = entry.getExtraAttributes();
                if (extraAttributes.length == 0)
                {
                    String defaultValue = DefaultScope.INSTANCE.getNode("org.neuro4j.workflow").get(preferenceKey, "");
                    if (!defaultValue.equals(preferences.get(preferenceKey, defaultValue))) {
                        preferences.put(preferenceKey, defaultValue);
                    }

                }
                else
                {
                    for (int j = 0; j < extraAttributes.length; j++) {
                        IClasspathAttribute attrib = extraAttributes[j];
                        if (attrib.getName().equals("javadoc_location")) {
                            if (preferenceKey == null)
                                break;
                            preferences.put(preferenceKey, attrib.getValue());

                            break;
                        }
                    }
                }
            }
            rebindClasspathEntries(project.getJavaModel(), containerPath);
        }
    }

    private String getPreferenceKey(IClasspathEntry entry, String version) {
        if (NEURO4J.equals(version))
            return "org.neuro4j.workflow.javadoclocation";

        return null;
    }

    private static void rebindClasspathEntries(IJavaModel model, IPath containerPath) throws JavaModelException {
        ArrayList affectedProjects = new ArrayList();

        IJavaProject[] projects = model.getJavaProjects();
        for (int i = 0; i < projects.length; i++) {
            IJavaProject project = projects[i];
            IClasspathEntry[] entries = project.getRawClasspath();
            for (int k = 0; k < entries.length; k++) {
                IClasspathEntry curr = entries[k];
                if ((curr.getEntryKind() == 5) && (containerPath.equals(curr.getPath()))) {
                    affectedProjects.add(project);
                }
            }
        }
        if (!affectedProjects.isEmpty()) {
            IJavaProject[] affected = (IJavaProject[]) affectedProjects.toArray(new IJavaProject[affectedProjects.size()]);
            IClasspathContainer[] containers = new IClasspathContainer[affected.length];
            for (int i = 0; i < containers.length; i++) {
                containers[i] = getNewContainer(containerPath);
            }
            JavaCore.setClasspathContainer(containerPath, affected, containers, null);
        }
    }

    @Override
    public String getDescription(IPath containerPath, IJavaProject project)
    {
        if (isValidJUnitContainerPath(containerPath)) {
            String version = containerPath.segment(1);
            if ((NEURO4J.equals(version)))
                return WizardMessages.Neuro4jContainerInitializer_description_initializer_neuro4j08;
        }
        return WizardMessages.Neuro4jContainerInitializer_description_initializer_unresolved;
    }

    public Object getComparisonID(IPath containerPath, IJavaProject project)
    {
        return containerPath;
    }

    private static class Neuro4jContainer
            implements IClasspathContainer
    {
        private final IClasspathEntry[] fEntries;
        private final IPath fPath;

        public Neuro4jContainer(IPath path, IClasspathEntry[] entries)
        {
            this.fPath = path;
            this.fEntries = entries;
        }

        public IClasspathEntry[] getClasspathEntries() {
            return this.fEntries;
        }

        public String getDescription() {
            return WizardMessages.Neuro4jContainerInitializer_description_neuro4j08;
        }

        public int getKind() {
            return 1;
        }

        public IPath getPath() {
            return this.fPath;
        }
    }
}