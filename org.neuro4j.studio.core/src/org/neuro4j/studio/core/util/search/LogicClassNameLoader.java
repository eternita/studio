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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;
import org.neuro4j.studio.core.util.MapWorkspaceUpdater;
import org.neuro4j.studio.core.util.ParameterDefinitionLoader;
import org.neuro4j.studio.core.util.WorkspaceUpdater;
import org.neuro4j.workflow.common.ParameterDefinition;

public class LogicClassNameLoader {

    private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

    private static LogicClassNameLoader instance = new LogicClassNameLoader();

    private static final IType[] EMPTY_ARRAY = new IType[0];
    private static final String LOGIC_BASE_CLASS = "org.neuro4j.workflow.node.CustomBlock";

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

    public List<ListEntry> getClasses(String projectName)
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

        IJavaProject javaProject = ClassloaderHelper.getJavaProject(projectName);
        List<ListEntry> classList = new LinkedList<ListEntry>();

        IType[] types = null;
        try {
            types = getAllSubtypes(javaProject, new NullProgressMonitor());
        } catch (JavaModelException e) {
            e.printStackTrace();

        }
        for (IType t : types) {
            t.getPath();

            classList.add(getEntry(t, projectName));
        }

        if (!classList.isEmpty())
        {
            classes.put(projectName, classList);
        }

    }

    private IType[] getAllSubtypes(IJavaProject project, IProgressMonitor pm) throws JavaModelException {
        if (project == null)
        {
            return EMPTY_ARRAY;
        }
        IType parentType = project.findType(LOGIC_BASE_CLASS);
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
        ListEntry entry = new ListEntry();
        entry.setType(ListEntryType.CUSTOM_BLOCK);
        String className = getClassName(type);
        entry.setMessage(className);
        entry.setPluginId(project);
        entry.setfDate(new Date(0));

        Map<String, ParameterDefinition> output = ParameterDefinitionLoader.getInstance().getParameterDefinition(className, "output");

        if (output != null && !output.isEmpty())
        {
            ListEntry outputEntry = new ListEntry();

            outputEntry.setMessage("output");
            entry.setType(ListEntryType.CHILD);
            outputEntry.setfDate(new Date(0));
            processChildEntry(outputEntry, output);
            entry.addChild(outputEntry);
        }

        Map<String, ParameterDefinition> input = ParameterDefinitionLoader.getInstance().getParameterDefinition(className, "input");
        if (input != null && !input.isEmpty())
        {
            ListEntry inputEntry = new ListEntry();
            entry.setType(ListEntryType.CHILD);
            inputEntry.setMessage("input");

            inputEntry.setfDate(new Date(0));
            processChildEntry(inputEntry, input);
            entry.addChild(inputEntry);
        }

        return entry;
    }

    private void processChildEntry(ListEntry entry, Map<String, ParameterDefinition> map)
    {
        for (ParameterDefinition paramDef : map.values())
        {
            ListEntry e = new ListEntry();
            e.setType(ListEntryType.CHILD);
            e.setMessage(paramDef.name() + " : " + paramDef.type());
            entry.addChild(e);
        }
    }

    public static WorkspaceUpdater getUpdater()
    {
        return new MapWorkspaceUpdater(instance.classes);
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