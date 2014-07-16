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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.undo.WorkspaceUndoMonitor;
import org.neuro4j.studio.core.XmlWorkflow;
import org.neuro4j.studio.core.format.n4j.ConvertationException;
import org.neuro4j.studio.core.format.n4j.NetworkConverter;
import org.neuro4j.studio.core.impl.EndNodeImpl;
import org.neuro4j.studio.core.util.PropetiesConstants;
import org.neuro4j.workflow.Workflow;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.common.WorkflowEngine;
import org.neuro4j.workflow.loader.WorkflowLoader;
import org.neuro4j.workflow.node.StartNode;
import org.neuro4j.workflow.node.Transition;
import org.neuro4j.workflow.node.WorkflowNode;


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

        List<String> endNodeNames = map.get(fileName);

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
                try {
                    endNodeNames = getEndNodeListForStartNode(file.getContents(), fArr[0], fArr[1]);
                    if (!endNodeNames.isEmpty())
                    {
                        List<String> n = map.get(fileName);
                        if (n != null)
                        {
                            n.addAll(endNodeNames);
                        } else {
                            map.put(fileName, endNodeNames);
                        }

                        // return endNodeNames;
                    }

                } catch (CoreException e) {
                    e.printStackTrace();
                }
            }

            return map.get(fileName);
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
        Set<WorkflowNode> visited = new HashSet<WorkflowNode>();

        try {
           // Workflow wflow = WorkflowLoader.loadFlowFromFS(is, flow);
        	XmlWorkflow wflow = NetworkConverter.xml2workflow(is, flow);
        	
        	WorkflowNode startNode = wflow.getNodeByName(startNodeName);
        	
            findEndNodes(startNode, visited, endNodes);
            return endNodes;
        } catch (ConvertationException e) {

            e.printStackTrace();
        }

        return Collections.EMPTY_LIST;
    }

    private void findEndNodes(WorkflowNode node, Set<WorkflowNode> visited, List<String> endNodes)
    {

        for (Transition transition : node.getExits())
        {
            WorkflowNode n = transition.getToNode();
            if (visited.contains(n)) {
                return;
            }
            visited.add(n);
            if (isEndNode(n))
            {
                endNodes.add(n.getName());
                continue;
            }

            findEndNodes(n, visited, endNodes);
        }

    }

    private boolean isEndNode(WorkflowNode node)
    {
        if (EndNodeImpl.IMPL_CLASS.equals(node.getParameter(PropetiesConstants.SWF_BLOCK_CLASS)))
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
