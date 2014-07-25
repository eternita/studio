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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.PlatformUI;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.format.f4j.FlowConverter;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;
import org.neuro4j.studio.core.impl.EndNodeImpl;
import org.neuro4j.studio.core.util.PropetiesConstants;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.common.WorkflowEngine;


public class CallNodeResolver {

    ResourceSearchEngine dialog = new ResourceSearchEngine(PlatformUI.getWorkbench().getDisplay().getActiveShell());

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    private static CallNodeResolver instance = new CallNodeResolver();

    private CallNodeResolver() {

    }

    public static CallNodeResolver getInstance()
    {
        return instance;
    }

    public List<IFile> findFileByName(String name) {

        try {
            List<IFile> files = dialog.findFiles(name);

            return files;
        } catch (CoreException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getEndNodeList(String flowName) {

        String[] fArr = null;
        try {
            fArr = WorkflowEngine.parseFlowName(flowName);
        } catch (FlowExecutionException e1) {
            e1.printStackTrace();
            return Collections.emptyList();
        }
        String fileName = fArr[0] + ".n4j";

        List<String> endNodeNames = map.get(flowName);

        if (endNodeNames != null)
        {
            return endNodeNames;
        }

        List<IFile> files = findFileByName(fileName);
        if (files.size() > 0)
        {
            // IFile file = getCandidate(files);
            for (IFile file : files)
            {
            	if (!file.getProjectRelativePath().toString().endsWith(fileName))
            	{
            		continue;
            	}
                try {
                    endNodeNames = getEndNodeListForStartNode(file.getContents(), fArr[0], fArr[1]);
                    if (!endNodeNames.isEmpty())
                    {
                        List<String> n = map.get(flowName);
                        if (n != null)
                        {
                            n.addAll(endNodeNames);
                        } else {
                            map.put(flowName, endNodeNames);
                        }

                         
                    } else {
                    	endNodeNames.add("NEXT");
                    }
                    return endNodeNames;
                } catch (CoreException e) {
                    e.printStackTrace();
                }
            }

            return map.get(flowName);
        }

        return Collections.emptyList();
    }

    /**
     * Return end nodes which can be reached from startNodeName
     * 
     * @param is
     * @param startNodeName
     * @return
     */
    public List<String> getEndNodeListForStartNode(InputStream is, String flow, String startNodeName)
    {
        List<String> endNodes = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();

        try {
        	
        	FlowXML wflow = FlowConverter.xml2workflow(is, flow);
        	
        	NodeXML startNode = wflow.getNodeByName(startNodeName);        	
            findEndNodes(startNode, visited, endNodes, wflow);
            return endNodes;        
        } catch (FlowInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return Collections.EMPTY_LIST;
    }

    private void findEndNodes(NodeXML node, Set<String> visited, List<String> endNodes, FlowXML wflow)
    {

        for (TransitionXML transition : node.getRelations())
        {
            String targetUuid = transition.toNode();
            if (visited.contains(targetUuid)) {
                return;
            }
            visited.add(targetUuid);
            NodeXML nodeXml = wflow.getById(targetUuid);
            if (isEndNode(nodeXml))
            {
                endNodes.add(nodeXml.getName());
                continue;
            }

            findEndNodes(nodeXml, visited, endNodes, wflow);
        }

    }

    private boolean isEndNode(NodeXML node)
    {
        if (NodeType.END.name().equalsIgnoreCase(node.type()))
        {
            return true;
        }
        return false;
    }

    // TODO:
    public void removeFromCache(org.eclipse.emf.common.util.URI uri)
    {
        String path = uri.devicePath();
        Set<String> keys = map.keySet();

        for (String key : keys)
        {
            if (path.endsWith(key)) {
                map.remove(key);
            }

        }
    }

}
