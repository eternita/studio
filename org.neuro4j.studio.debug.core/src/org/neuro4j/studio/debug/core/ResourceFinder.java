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
package org.neuro4j.studio.debug.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.neuro4j.studio.core.ActionNode;

public class ResourceFinder {

    public static final String UNKNOWN = "unknown";
    
    Pattern pattern = Pattern.compile("<node uuid=\"(.*)\" name=\"(.*)\" x=");

    private static ResourceFinder instance = new ResourceFinder();

    private static final String NAME_PATERN = "name=\"";

    Map<String, IFile> resources = new HashMap<String, IFile>();

    // keeps nodeName and uuid relation
    Map<String, String> nodes = new HashMap<String, String>();

    private ResourceFinder()
    {

    }

    public static ResourceFinder getInstance() {
        return instance;
    }

    public String getFlowNameByUuid(String uuid)
    {
        IFile file = findFileWithUUID(uuid);

        if (file != null)
        {
            String flowName = file.getName().replace(".n4j", "");
            return flowName;
        }

        return UNKNOWN;
    }

    public IFile findFileWithUUID(final String uuid)
    {
        if (resources.containsKey(uuid))
        {
            return resources.get(uuid);
        }

        IContainer container = ResourcesPlugin.getWorkspace().getRoot();
        ResourceProxyVisitor visitor = null;
        try {

            visitor = new ResourceProxyVisitor(uuid);
            container.accept(visitor,
                    IResource.FILE);

        } catch (CoreException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        if (visitor != null)
        {
            if (visitor.getFile() != null)
            {
                registerFileWithUUId(visitor.getFile(), uuid);

            }
        }

        return resources.get(uuid);
    }

    /**
     * TODO:
     * 
     * @param uuid
     * @return
     */
    public String getNodeNameByUUid(final String uuid)
    {

        return nodes.get(uuid);

    }

    public void registerFileWithUUId(IFile resourcePath, String uuid)
    {
        resources.put(uuid, resourcePath);
    }

    public void registerNode(IFile resource, ActionNode node)
    {
        registerFileWithUUId(resource, node.getId());
        registerNodeName(node.getName(), node.getId());

    }

    private void registerNodeName(String nodeName, String uuid)
    {
        nodes.put(uuid, nodeName);
    }

    private class ResourceProxyVisitor implements IResourceProxyVisitor {

        String uuid = null;

        File file;

        public ResourceProxyVisitor(String uuid)
                throws CoreException {
            super();
            this.uuid = uuid;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse
         * .core.resources.IResourceProxy)
         */
        public boolean visit(IResourceProxy proxy) throws CoreException {

            IResource resource = proxy.requestResource();

            if (resource.getName().endsWith(".n4j"))
            {
                File file = (File) resource;
                if (!isValidFilePath(file))
                {
                    return true;
                }
                if (isContains(file, uuid))
                {
                    this.file = file;
                    // return false;
                    IStatus status = new Status(IStatus.OK, "exportToFile", IStatus.OK, //$NON-NLS-1$
                    "file founded", null);
                    throw new CoreException(status);

                }

            }
            if (resource.getType() == IResource.FILE) {
                return false;
            }

            return true;
        }

        /**
         * TODO:
         * 
         * @param file
         * @return
         */
        private boolean isValidFilePath(File file)
        {
            boolean valid = true;
            if (file.getFullPath().toOSString().contains("classes"))
            {
                return false;
            }
            return valid;
        }

        private boolean isContains(File file, String uuid)
        {
            boolean exist = false;
            
            InputStream stream = null;
            java.util.Scanner s = null;
            try {
                stream = file.getContents();
                s = new java.util.Scanner(stream);
                while (s.hasNext())
                {
                    String str = s.nextLine();

                    Matcher matcher = pattern.matcher(str);
                    
                    while(matcher.find())
                    {
                        String id = matcher.group(1);
                        registerNodeName(matcher.group(2), id);
                        resources.put(id, file);
                        if (id.equals(uuid))
                        {
                            exist = true;
                        }                       
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeStream(stream);
                
                if (s != null)
                {
                    s.close();    
                }
                
            }

            return exist;
        }

//        private void processNodeName(String str, String uuid) {
//            str = str.trim();
//            int index = str.trim().indexOf(NAME_PATERN);
//            if (index > 0)
//            {
//                int i2 = str.indexOf("\"", index + NAME_PATERN.length());
//
//                String name = str.substring(index + NAME_PATERN.length(), i2);
//                registerNodeName(name, uuid);
//            }
//
//        }

        private void closeStream(InputStream stream) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public File getFile()
        {
            return file;
        }

    }

}
