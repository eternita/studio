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
package org.neuro4j.studio.core.util.search;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;
import org.neuro4j.studio.core.util.MapWorkspaceUpdater;
import org.neuro4j.studio.core.util.ParameterDefinitionLoader;
import org.neuro4j.studio.core.util.WorkspaceUpdater;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.TriggerBlock;
import org.neuro4j.workflow.node.CustomBlock;

public class LogicClassNameLoader {

    private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

    private static LogicClassNameLoader instance = new LogicClassNameLoader();

    private static final IType[] EMPTY_ARRAY = new IType[0];
    private static final String LOGIC_BASE_CLASS = CustomBlock.class.getCanonicalName();
    private static final String TRIGGER_BASE_CLASS = TriggerBlock.class.getCanonicalName();

    private Map<String, List<ListEntry>> classes = new HashMap<String, List<ListEntry>>();

    private LogicClassNameLoader()
    {
        super();

    }

    public static LogicClassNameLoader getInstance()
    {
        return instance;
    }

    private synchronized void load(String projectName) {
        loadClassses(projectName);

    }

    public synchronized List<ListEntry> getClasses(String projectName)
    {
        if (!classes.containsKey(projectName))
        {
            load(projectName);
        }
        return classes.get(projectName);
    }

    /**
     * Returns classes which extend import org.neuro4j.workflow.def.CustomBlock
     * 
     * @return
     * @throws JavaModelException
     */
    private void loadClassses(String projectName) {

        Set<IType> triggers = new HashSet<IType>();

        IJavaProject javaProject = ClassloaderHelper.getJavaProject(projectName);
        List<ListEntry> classList = new LinkedList<ListEntry>();

        IType[] types = null;
        try {
            types = getAllSubtypes(javaProject, new NullProgressMonitor(), LOGIC_BASE_CLASS);
        } catch (JavaModelException e) {
            e.printStackTrace();

        }

        try {
            IType[] triggersClasses = getAllSubtypes(javaProject, new NullProgressMonitor(), TRIGGER_BASE_CLASS);
            triggers.addAll(Arrays.asList(triggersClasses));
        } catch (JavaModelException e) {
            e.printStackTrace();

        }

        for (IType t : types) {
            ListEntry entry = getEntry(t, projectName);
            if (entry != null)
            {
                if (triggers.contains(t))
                {
                    entry.setType(ListEntryType.TRIGGER_BLOCK);
                }
                classList.add(entry);
            }

        }

        classes.put(projectName, classList);

    }

    private IType[] getAllSubtypes(IJavaProject project, IProgressMonitor pm, String className) throws JavaModelException {
        if (project == null)
        {
            return EMPTY_ARRAY;
        }
        IType parentType = project.findType(className);
        if (parentType == null)
        {
            return EMPTY_ARRAY;
        }
        ITypeHierarchy h = parentType.newTypeHierarchy(project, pm);
        return h.getAllSubtypes(parentType);
    }

    private String getClassName(IType type)
    {
        return type.getFullyQualifiedName();
    }

    private ListEntry getEntry(IType type, String project)
    {
        ListEntry entry = new ListEntry(ListEntryType.CUSTOM_BLOCK);
        if (type.getCompilationUnit() != null)
        {
            IFile file = (IFile) type.getCompilationUnit().getResource();
            entry.setResource(file);
            entry.setfDate(new Date(file.getLocalTimeStamp()));

            entry.setPluginId(project);
        } else {
            IPath path = type.getPath();
            entry.setPluginId(path.lastSegment());
            entry.setfDate(new Date(path.toFile().lastModified()));
        }

        // TODO: do not add abstract classes
        try {
            if (type.getFlags() >= 1024) {
                return null;
            }
        } catch (JavaModelException e) {
            e.printStackTrace();
        }

        String className = getClassName(type);
        entry.setMessage(className);

        Map<String, ParameterDefinition> output = ParameterDefinitionLoader.getInstance().getParameterDefinition(project, className, "output");

        if (output != null && !output.isEmpty())
        {
            ListEntry outputEntry = new ListEntry(ListEntryType.CHILD);

            outputEntry.setMessage("output");

            processChildEntry(outputEntry, output);
            entry.addChild(outputEntry);
        }

        Map<String, ParameterDefinition> input = ParameterDefinitionLoader.getInstance().getParameterDefinition(project, className, "input");
        if (input != null && !input.isEmpty())
        {
            ListEntry inputEntry = new ListEntry(ListEntryType.CHILD);
            inputEntry.setMessage("input");

            processChildEntry(inputEntry, input);
            entry.addChild(inputEntry);
        }

        return entry;
    }

    private void processChildEntry(ListEntry entry, Map<String, ParameterDefinition> map)
    {
        for (ParameterDefinition paramDef : map.values())
        {
            ListEntry e = new ListEntry(ListEntryType.CHILD);
            e.setMessage(paramDef.name() + " : " + paramDef.type());
            entry.addChild(e);
        }
    }

    public static WorkspaceUpdater getUpdater()
    {
        return new MapWorkspaceUpdater(instance.classes) {
            public void update(IResource iResource, int action) {
                if (iResource != null && iResource.getFileExtension() != null && iResource.getName()!= null && (iResource.getFileExtension().equals("classpath") || iResource.getName().equals("pom.xml") || iResource.getFileExtension().equals("class")))
                {
                    instance.classes.remove(iResource.getProject().getName());
                }

            }

        };
    }

    public Object loadAllBlocksInWorkspace(final List<ListEntry> blocks) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        // Get all projects in the workspace
        IProject[] projects = root.getProjects();
        // Loop over all projects
        for (IProject project : projects) {
            try {
                if (project.isNatureEnabled(JDT_NATURE)) {
                    analyzeProject(project, blocks);
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }   
        return null;
    }

    private void analyzeProject(IProject project, List<ListEntry> blocks) {

        List<ListEntry> list = getClasses(project.getName());
        blocks.addAll(list);

    }

}