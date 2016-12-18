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

import java.io.File;
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
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.format.f4j.FlowConverter;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.WorkflowEngine;
import org.neuro4j.workflow.node.FlowParameter;


public class CallNodeResolver {

    ResourceSearchEngine searchEngine = new ResourceSearchEngine();

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
            List<IFile> files = searchEngine.findFiles(name);

            return files;
        } catch (CoreException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getEndNodeList(String flowName) {
    	
    	String fileName = null;
    	FlowParameter fp = null;
        try {
            
            fp = FlowParameter.parse(flowName);
            fileName = fp.getFlowName().replace(".", File.separator) + ".n4j";
            
        } catch (FlowExecutionException e1) {
            e1.printStackTrace();
            return Collections.emptyList();
        }


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
                    endNodeNames = getEndNodeListForStartNode(file.getContents(), fp.getFlowName().replace(".", File.pathSeparator), fp.getStartNode());
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
        } catch (FlowExecutionException e) {
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
        path = path.substring(0, path.length() - ".n4j".length());
        Set<String> keys = map.keySet();
        for (String key : keys)
        {
            try {

                FlowParameter parameter = FlowParameter.parse(key);
                if (path.endsWith(parameter.getFlowName().replace(".", File.separator))) {
                    map.remove(key);
                }
                
            } catch (FlowExecutionException e1) {
                 continue;
            }
            

        }
    }

}
