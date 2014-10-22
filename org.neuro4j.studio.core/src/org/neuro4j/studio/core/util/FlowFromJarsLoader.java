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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;

public class FlowFromJarsLoader {

    private static FlowFromJarsLoader instance = new FlowFromJarsLoader();
    private static Map<String, List<ListEntry>> itemsFromJars = new HashMap<String, List<ListEntry>>();

    private FlowFromJarsLoader()
    {
    }

    public static FlowFromJarsLoader getInstance()
    {
        return instance;
    }

    public static WorkspaceUpdater getUpdater()
    {
        return new MapWorkspaceUpdater(itemsFromJars);
    }

    public synchronized List<ListEntry> getFlows(String project)
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
    
    public List<ListEntry> getAllFlows()
    {
        List<ListEntry> list = new ArrayList<ListEntry>();
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
        for (IProject project: projects){
            List<ListEntry> l =  getFlows(project.getName());
            list.addAll(l);
        }
        
        return list;
    }

    private synchronized void loadFromJars(IJavaProject project)
    {

        List<IPath> urls = ClassloaderHelper.getClasspathAsIPathArray(project);
        List<ListEntry> l = new LinkedList<ListEntry>();
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
                  Date lastModDate =   new Date(iPath.toFile().lastModified());
                    try {
                        ListEntry entry =  convertToList(file.getInputStream(e), e.getName(), lastModDate);
                        if (entry == null)
                        {
                            continue;
                        }
                        entry.setPluginId(iPath.lastSegment());
                        entry.setfDate(lastModDate);
                        
                        l.add(entry);
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

    protected ListEntry convertToList(InputStream f, String packageName, Date lastModDate) {
        ListEntry entry = new ListEntry();
        entry.setType(ListEntryType.FLOW);
        String packageName1 = packageName.replace("/", ".").replace(".n4j", "");
        
        entry.setMessage(packageName1);
        
        for (String eid : getStartNodes(f, packageName)) {
            ListEntry child = new ListEntry();
            child.setType(ListEntryType.CHILD);
            child.setMessage(eid);
            child.setfDate(lastModDate);
            entry.addChild(child);
        }
        if(!entry.hasChildren()){
            return null;
        }
        return entry;
    }

    private List<String> getStartNodes(InputStream iResource, String name) {
        List<String> list = Collections.emptyList();
        if (null != iResource) {
            list = FlowUtils.getStartNodeList(iResource, name);
        }

        return list;
    }
}
