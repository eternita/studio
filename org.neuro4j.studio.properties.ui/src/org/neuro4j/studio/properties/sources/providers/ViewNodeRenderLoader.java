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
package org.neuro4j.studio.properties.sources.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.core.util.MapWorkspaceUpdater;
import org.neuro4j.web.logic.render.ViewNodeRenderEngineDefinition;

public class ViewNodeRenderLoader {

    private static final IType[] EMPTY_ARRAY = new IType[0];
    private static final String LOGIC_BASE_CLASS = ViewNodeRenderEngineDefinition.class.getCanonicalName();
    private static List<DefaultViewNodeRenderEngineDefinition> DEFAULT_RENDER_LIST = new LinkedList<DefaultViewNodeRenderEngineDefinition>();

    private Map<String, List<DefaultViewNodeRenderEngineDefinition>> renders = new HashMap<String, List<DefaultViewNodeRenderEngineDefinition>>();

    public static final DefaultViewNodeRenderEngineDefinition DEFAULT_RENDER = new DefaultViewNodeRenderEngineDefinition("jsp", "jsp", "*/WEB-INF/*");

    private static ViewNodeRenderLoader instance = new ViewNodeRenderLoader();

    private ViewNodeRenderLoader()
    {
        Neuro4jDiagramEditorPlugin.getInstance().addListToObserver(new MapWorkspaceUpdater(renders) {

            @Override
            public void update(IResource iResource, int action) {
                switch (action) {
                    case IResourceDelta.CHANGED:
                        if (iResource != null && (iResource.getFileExtension().equals("classpath") || iResource.getName().equals("pom.xml")))
                        {
                            if (iResource != null)
                            {
                                renders.remove(iResource.getProject().getName());
                            }
                        }
                        break;

                    default:
                        break;
                }

            }

        });
        DEFAULT_RENDER_LIST.add(DEFAULT_RENDER);
    }

    public static ViewNodeRenderLoader getInstance() {
        return instance;
    }

    private void load(String projectName)
    {
        IJavaProject project = ClassloaderHelper.getJavaProject(projectName);

        List<DefaultViewNodeRenderEngineDefinition> list = new LinkedList<DefaultViewNodeRenderEngineDefinition>();

        Set<String> names = getAllClasses(project);
        for (String name : names)
        {
            DefaultViewNodeRenderEngineDefinition inst = createNewInstance(project, name);
            if (inst != null)
            {
                list.add(inst);
            }
        }

        renders.put(project.getProject().getName(), list);

    }

    public List<DefaultViewNodeRenderEngineDefinition> getRender(String project)
    {
        if (renders.get(project) == null)
        {
            load(project);
        }
        return renders.get(project);
    }

    private Set<String> getAllClasses(IJavaProject originProject) {

        Set<String> classList = new HashSet<String>();

        IType[] types = null;
        try {
            types = getAllSubtypes(originProject, new NullProgressMonitor());
        } catch (JavaModelException e) {
            System.err.print(e.getMessage());
            return classList;
        }
        for (IType t : types) {
            classList.add(getClassName(t));
        }
        return classList;
    }

    private IType[] getAllSubtypes(IJavaProject project, IProgressMonitor pm) throws JavaModelException {

        IType parentType = project.findType(LOGIC_BASE_CLASS);

        if (parentType == null)
        {
            System.err.print(LOGIC_BASE_CLASS + " not found in classpath. Please add neuro4j-web-core.jar to your classpath.");
            return EMPTY_ARRAY;
        }
        ITypeHierarchy h = parentType.newTypeHierarchy(project, pm);
        return h.getAllSubtypes(parentType);
    }

    private String getClassName(IType type)
    {
        return type.getFullyQualifiedName();
    }

    private DefaultViewNodeRenderEngineDefinition createNewInstance(IJavaProject project, String clazzName) {

        DefaultViewNodeRenderEngineDefinition definition = null;

        Object beanInstance = null;
        try {
            beanInstance = ClassloaderHelper.getInstance(project, clazzName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (beanInstance == null)
        {
            return null;
        }
        try {
            String fileExt = BeanUtils.getProperty(beanInstance, "fileExt");
            String name = BeanUtils.getProperty(beanInstance, "name");
            String pathFilter = BeanUtils.getProperty(beanInstance, "pathFilter");
            definition = new DefaultViewNodeRenderEngineDefinition(name, fileExt, pathFilter);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return definition;

    }

    public String[] getRenderNames(String project) {
        if (renders.get(project) == null)
        {
            load(project);

        }
        if (renders.get(project).isEmpty())
        {
            renders.put(project, DEFAULT_RENDER_LIST);
        }

        String[] names = new String[renders.get(project).size()];
        int i = 0;
        for (ViewNodeRenderEngineDefinition engine : renders.get(project))
        {
            names[i++] = engine.getName();
        }
        return names;
    }

    public DefaultViewNodeRenderEngineDefinition getRenderDefinitionByName(String project, String name) {
        if (renders.get(project) == null)
        {
            load(project);

        }
        if (renders.get(project).isEmpty())
        {
            renders.put(project, DEFAULT_RENDER_LIST);
        }

        for (DefaultViewNodeRenderEngineDefinition engine : renders.get(project))
        {
            if (engine.getName().equals(name)) {
                return engine;
            }
        }

        return DEFAULT_RENDER;

    }

}
