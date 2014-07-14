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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;

public class FlowFromJarsLoader {

    private static FlowFromJarsLoader instance = new FlowFromJarsLoader();
    private static Map<String, List<String>> itemsFromJars = new HashMap<String, List<String>>();

    private FlowFromJarsLoader()
    {
        // loadFromJars();
    }

    public static FlowFromJarsLoader getInstance()
    {
        return instance;
    }

    public static WorkspaceUpdater getUpdater()
    {
        return new MapWorkspaceUpdater(itemsFromJars);
    }

    public synchronized List<String> getFlows(String project)
    {
        if (itemsFromJars.containsKey(project))
        {
            return itemsFromJars.get(project);
        } else {
            IJavaProject pr = ClassloaderHelper.getJavaProject(project);
            loadFromJars(pr);
            return itemsFromJars.get(project);
        }

    }

    private synchronized void loadFromJars(IJavaProject project)
    {

        List<IPath> urls = ClassloaderHelper.getClasspathAsIPathArray(project);
        List<String> l = new LinkedList<String>();
        for (IPath iPath : urls)
        {
            JarFile file = null;
            try {
                file = new JarFile(iPath.toOSString());
            } catch (IOException e) {
                // e.printStackTrace();
                continue;
            }
            Enumeration<JarEntry> en = file.entries();
            while (en.hasMoreElements())
            {
                JarEntry e = en.nextElement();
                if (e.getName().endsWith(".n4j"))
                {
                    List<String> list = null;
                    try {
                        list = convertToList(file.getInputStream(e), e.getName());
                        if (list != null && !list.isEmpty())
                        {
                            l.addAll(list);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }

            }

        }

        if (l == null) {
            l = Collections.EMPTY_LIST;
        }

        itemsFromJars.put(project.getProject().getName(), l);

    }

    protected List<String> convertToList(InputStream f, String packageName) {
        List<String> startNodes = new ArrayList<String>();

        String packageName1 = packageName.replace("/", ".").replace(".n4j", "") + "-";
        for (String eid : getNetwork(f, packageName)) {
            startNodes.add(packageName1 + eid);
        }

        return startNodes;
    }

    private List<String> getNetwork(InputStream iResource, String name) {
        List<String> list = Collections.emptyList();
        if (null != iResource) {
            list = FlowUtils.getStartNodeList(iResource, name);
        }

        return list;
    }
}
