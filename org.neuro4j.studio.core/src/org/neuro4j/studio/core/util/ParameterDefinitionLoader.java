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
package org.neuro4j.studio.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionImpl;
import org.neuro4j.workflow.common.ParameterDefinitionList;

public class ParameterDefinitionLoader {

    private static final ParameterDefinition[] EMPTY = new ParameterDefinition[] { };

    private Map<String, Map<String, ParameterDefinition>> map = new HashMap<String, Map<String, ParameterDefinition>>();

    private static ParameterDefinitionLoader instance = new ParameterDefinitionLoader();

    private ParameterDefinitionLoader() {

    }

    public static ParameterDefinitionLoader getInstance() {
        return instance;
    }

    public Map<String, ParameterDefinition> getParameterDefinition(
            String className, String type) {
        Map<String, ParameterDefinition> localMap = map.get(type + className);
        if (localMap != null) {
            return localMap;
        }

        localMap = getParameterDefinitionFromClass(className, type);
        if (localMap != null) {
            map.put(type + className, localMap);
        }
        if (localMap == null) {
            // try from sources
            localMap = getParameterDefinitionFromSource(className, type);

        }

        return localMap;
    }

    private Map<String, ParameterDefinition> getParameterDefinitionFromClass(
            String className, String type) {
        Map<String, ParameterDefinition> parameters = null;

        Class<?> aClass = null;
        try {
            aClass = ClassloaderHelper.getClazz(ClassloaderHelper.getActiveProjectName(), className);
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
        if (aClass == null)
        {
            return null;
        }
        // if (CustomBlock.class.isAssignableFrom(aClass)) {

        ParameterDefinitionList list = (ParameterDefinitionList) getParameterDefinitionListAnnotation(aClass);

        if (list != null) {
            ParameterDefinition[] pdList = null;
            if (type.equals("output")) {
                pdList = list.output();
            } else {
                pdList = list.input();
            }
            parameters = new HashMap<String, ParameterDefinition>();
            for (ParameterDefinition pd : pdList) {
                parameters.put(pd.name(), pd);
            }
        }

        // }

        return parameters;
    }

    private ParameterDefinitionList getParameterDefinitionListAnnotation(Class<?> aClass)
    {

        Annotation[] ans = aClass.getAnnotations();

        for (Annotation an : ans)
        {
            if (an.annotationType().toString().endsWith("ParameterDefinitionList"))
            {

                final Object obj = aClass.getAnnotation(an.annotationType());

                ParameterDefinitionList list = new ParameterDefinitionList() {

                    @Override
                    public Class<? extends Annotation> annotationType() {

                        return org.neuro4j.workflow.common.ParameterDefinitionList.class;
                    }

                    @Override
                    public ParameterDefinition[] input() {

                        Object[] parameterDefArray = null;
                        try {
                            parameterDefArray = (Object[]) MethodUtils.invokeExactMethod(obj, "input", null);
                            if (parameterDefArray == null)
                            {
                                return EMPTY;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return EMPTY;
                        }

                        List<ParameterDefinition> list = new ArrayList<ParameterDefinition>(5);
                        for (Object ob : parameterDefArray)
                        {
                            try {
                                ParameterDefinition pd1 = getParameterDefinition(ob);
                                list.add(pd1);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return EMPTY;
                            }
                        }

                        return list.toArray(new ParameterDefinition[list.size()]);
                    }

                    @Override
                    public ParameterDefinition[] output() {
                        Object[] parameterDefArray = null;
                        try {
                            parameterDefArray = (Object[]) MethodUtils.invokeExactMethod(obj, "output", null);
                            if (parameterDefArray == null)
                            {
                                return EMPTY;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return EMPTY;
                        }

                        List<ParameterDefinition> list = new ArrayList<ParameterDefinition>(5);
                        for (Object ob : parameterDefArray)
                        {
                            try {
                                ParameterDefinition pd1 = getParameterDefinition(ob);
                                list.add(pd1);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return EMPTY;
                            }
                        }

                        return list.toArray(new ParameterDefinition[list.size()]);
                    }

                };

                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return list;
            }
        }

        return null;
    }

    private final ParameterDefinition getParameterDefinition(Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        final String name = (String) MethodUtils.invokeExactMethod(obj, "name", null);

        if (name == null || "".equals(name.trim()))
        {
            return null;
        }

        final String type = (String) MethodUtils.invokeExactMethod(obj, "type", null);
        final Boolean isOptional = (Boolean) MethodUtils.invokeExactMethod(obj, "isOptional", null);

        ParameterDefinition pd = new ParameterDefinition() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return org.neuro4j.workflow.common.ParameterDefinition.class;
            }

            @Override
            public String type() {
                return type;
            }

            @Override
            public String name() {
                return name;
            }

            @Override
            public boolean isOptional() {
                return isOptional;
            }
        };

        return pd;
    }

    private Map<String, ParameterDefinition> getParameterDefinitionFromSource(
            String className, String inOut) {

        Map<String, ParameterDefinition> definitions = new HashMap<String, ParameterDefinition>();

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IProject[] projects = root.getProjects();
        for (IProject project : projects) {
            
             processClassInProject(project, className, inOut, definitions);

        }

        return definitions;
    }
    
    private void processClassInProject(IProject project, String className, String inOut, Map<String, ParameterDefinition> definitions)
    {
        
        IJavaProject javaProject = JavaCore.create(project);
        IType parentType = null;
        try {
            parentType = javaProject.findType(className);
            if (parentType != null) {
                IAnnotation an = parentType
                        .getAnnotation("ParameterDefinitionList");
                IMemberValuePair[] members = an.getMemberValuePairs();
                if (members != null && members.length >= 1) {
                    for (IMemberValuePair para : members) {
                        if (!para.getMemberName().equals(inOut)) {
                            continue;
                        }
                        Object[] obj = (Object[]) para.getValue();
                       
                        for (Object ob : obj) {
                            Map<String, String> variableMap = new HashMap<String, String>();
                            IAnnotation parameterDefinitionAnnotation = (IAnnotation) ob;
                            IMemberValuePair[] parameterDefinitionPara = parameterDefinitionAnnotation
                                    .getMemberValuePairs();
                            String name = null;
                            String type = null;
                            Boolean optional = Boolean.TRUE;
                            parse(parentType.getCompilationUnit()
                                    .getSource().toCharArray(), variableMap);
                            for (IMemberValuePair p : parameterDefinitionPara) {

                                String memberName = p.getMemberName();
                                if ("name".equals(memberName)) {
                                    name = (String) p.getValue();
                                    String nameFromMap = variableMap
                                            .get(name);
                                    if (nameFromMap != null) {
                                        name = nameFromMap;
                                    }
                                } else if ("type".equals(memberName)) {
                                    type = (String) p.getValue();
                                } else if ("isOptional".equals(memberName)) {
                                    optional = (Boolean) p.getValue();
                                }
                            }
                            ParameterDefinition ioParameter = new ParameterDefinitionImpl(
                                    name, type, optional);
                            definitions
                                    .put(ioParameter.name(), ioParameter);
                        }
                        return;
                    }

                }

            }

        } catch (JavaModelException e1) {
            Neuro4jCorePlugin.logErrorMessage(e1.toString(), null);

        }
        return;
    }

    public WorkspaceUpdater getUpdater()
    {

        return new MapWorkspaceUpdater(map){
            public void update(IResource iResource,  int action) {
                switch (action) {
                    case IResourceDelta.REMOVED:
                        if (iResource != null)
                        {
                            map.clear();
                        }
                        break;

                    default:
                        break;
                }

            }  
        };
    }

    public static void parse(char[] str, final Map<String, String> mapping) {
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        parser.setSource(str);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        cu.accept(new ASTVisitor() {

            public boolean visit(VariableDeclarationFragment var) {

                String varName = var.getName().toString();
                if (varName.startsWith("IN_") || varName.startsWith("OUT_")) {
                    mapping.put(var.getName().toString(), var.getInitializer()
                            .toString().replace("\"", ""));
                }

                return false;
            }

        });
    }
}
