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
package org.neuro4j.studio.flow.format.n4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.workflow.Workflow;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.common.SWFParametersConstants;
import org.neuro4j.workflow.enums.DecisionCompTypes;
import org.neuro4j.workflow.enums.DecisionOperators;
import org.neuro4j.workflow.xml.CallNode;
import org.neuro4j.workflow.xml.CustomNode;
import org.neuro4j.workflow.xml.DecisionNode;
import org.neuro4j.workflow.xml.LoopNode;
import org.neuro4j.workflow.xml.SwitchNode;
import org.neuro4j.workflow.xml.ViewNode;
import org.neuro4j.workflow.xml.WorkflowNode;

public class NetworkConverter {

    public static String network2xml(Workflow network) {
        if (null == network)
            return null;

        NetworkXML net = new NetworkXML(network);

        StringWriter writer = new StringWriter();
        try {
            JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(net, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return writer.toString();
    }

    public static void network2xmlstream(Workflow network, OutputStream out) {
        if (null == network)
            return;

        NetworkXML net = new NetworkXML(network);

        try {
            JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(net, out);
        } catch (JAXBException e) {
            e.printStackTrace();
            return;
        }
        return;
    }

    // /**
    // *
    // * @param xml
    // * @return
    // */
    public static Workflow xml2network(String xml) throws ConvertationException {
        if (null == xml)
            return null;

        NetworkXML net = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

            Unmarshaller um = ctx.createUnmarshaller();
            net = (NetworkXML) um.unmarshal(new StringReader(xml));
            if (null == net)
                return null;

            return netXML2net(net, "123");

        } catch (JAXBException e) {
            throw new ConvertationException("Can't convert string to network "
                    + xml, e);
        }
    }

    /**
     * In case of exception input stream are closed by JAXB
     * 
     * @param xml
     * @return
     */
    public static Workflow xml2workflow(InputStream xml, String flow)
            throws ConvertationException {
        if (null == xml)
            return null;

        NetworkXML net = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

            Unmarshaller um = ctx.createUnmarshaller();
            net = (NetworkXML) um.unmarshal(xml);
            if (null == net)
                return null;

            return netXML2net(net, flow);

        } catch (JAXBException e) {
            throw new ConvertationException("Can't convert stream to workflow",
                    e);
        }
    }

    private static String getFlowPackage(String flow)
    {
        String flowPackage = "default";
        int index = flow.lastIndexOf("/");
        if (index > 0)
        {
            flowPackage = flow.substring(0, index);
        }
        return flowPackage;
    }

    private static Workflow netXML2net(NetworkXML net, String flow) {

        Workflow network = new Workflow(flow, getFlowPackage(flow));

        for (EntityXML e : net.getEntities()) {

            Map<String, String> parameters = new HashMap<String, String>();

            for (PropertyXML rep : e.getRepresentations())
                if (rep.getValue() != null && !rep.getValue().trim().equals(""))
                {
                    parameters.put(rep.getKey(), rep.getValue());
                }

            if (parameters.get(SWFConstants.SWF_BLOCK_CLASS) != null) {
                WorkflowNode entity;
                try {
                    entity = createNode(network, e, parameters);
                    entity.registerNodeInWorkflow();
                } catch (FlowInitializationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        }

        for (WorkflowNode entity : network.getNodes()) {

            if (null != entity) {
                EntityXML e = net.getById(entity.getUuid());

                for (RelationTailXML rp : e.getRelations()) {
                    EntityXML entityXML = net.getById(rp.getUuid());
                    if (entityXML == null)
                    {
                        continue;
                    }
                    XmlTransition transition = new XmlTransition(network);
                    transition.setUuid(entityXML.getUuid());
                    transition.setName(entityXML.getName());
                    transition.setFromNode(entity);
                    List<PropertyXML> representation = entityXML
                            .getRepresentations();
                    for (PropertyXML propertyXML : representation) {
                        if (SWFConstants.EndUUID.equals(propertyXML.getKey())) {
                            String targetUuid = propertyXML.getValue();
                            WorkflowNode toNode = network.getById(targetUuid);
                            if (null != toNode)
                                transition.setToNode(toNode);
                            entity.registerExit(transition);
                        } else if (SWFConstants.POINTS.equals(propertyXML.getKey())) {
                            String points = propertyXML.getValue();
                            if (points != null)
                            {
                                transition.setCoordinates(points);
                            }

                        }
                    }

                }
            }
        }

        return network;
    }

    private static WorkflowNode createNode(Workflow workflow, EntityXML e, Map<String, String> parameters) throws FlowInitializationException
    {
        String blockClass = parameters.get(SWFConstants.SWF_BLOCK_CLASS);

        WorkflowNode node = null;

        // if (blockClass.equals(StartBlock.class.getCanonicalName())) {
        // node = createStartNode(workflow, e, parameters);
        // }
        // } else if (blockClass.equals(CallBlock.class.getCanonicalName())) {
        // node = createCallNode(workflow, e, parameters);
        // } else if (blockClass.equals(DecisionBlock.class.getCanonicalName())) {
        // node = createDecisionNode(workflow, e, parameters);
        // } else if (blockClass.equals(LoopBlock.class.getCanonicalName())) {
        // node = createLoopNode(workflow, e, parameters);
        // } else if (blockClass.equals(SetViewTemplate.class.getCanonicalName())) {
        // node = createViewNode(workflow, e, parameters);
        // } else if (blockClass.equals(SwitchBlock.class.getCanonicalName())) {
        // node = createSwitchNode(workflow, e, parameters);
        // }
        //
        String className = parameters.get("SWF_CUSTOM_CLASS");

        if (className == null) {
            className = parameters.get(SWFConstants.SWF_BLOCK_CLASS);
        }

        if (className == null) {
            throw new FlowInitializationException("Executable node is unknown");
        }

        if (node == null) {
            node = new WorkflowNode(e.getName(), e.getUuid(), workflow);
            Set<String> keys = parameters.keySet();
            for (String key : keys)
            {
                node.addParameter(key, parameters.get(key));
            }
        }

        node.setExecutableClass(className);

        return node;
    }

    private static WorkflowNode createCallNode(Workflow workflow, EntityXML e, Map<String, String> parameters) {
        CallNode node = new CallNode(e.getName(), e.getUuid(), workflow);
        node.setCallFlow(parameters.get(SWFParametersConstants.CAll_NODE_FLOW_NAME));
        node.setDynamicFlownName(parameters.get(SWFParametersConstants.CAll_NODE_DYNAMIC_FLOW_NAME));
        return node;
    }

    private static WorkflowNode createSwitchNode(Workflow workflow, EntityXML e, Map<String, String> parameters) {
        SwitchNode node = new SwitchNode(e.getName(), e.getUuid(), workflow);

        String relationName = parameters.get(SWFParametersConstants.SWITCH_NODE_ACTION_NAME);
        if (relationName == null)
        {
            relationName = SWFParametersConstants.SWITCH_NODE_DEFAULT_PARAMETER_VALUE;
        }

        node.setRelationName(relationName);

        return node;
    }

    private static WorkflowNode createViewNode(Workflow workflow, EntityXML e, Map<String, String> parameters) {
        ViewNode node = new ViewNode(e.getName(), e.getUuid(), workflow);

        node.setStaticTemplateName(parameters.get(SWFParametersConstants.VIEW_NODE_TEMPLATE_NAME));
        node.setDynamicTemplateName(parameters.get(SWFParametersConstants.VIEW_NODE_TEMPLATE_DYNAMIC_NAME));

        String renderType = parameters.get(SWFParametersConstants.VIEW_NODE_RENDER_TYPE);
        if (renderType == null)
        {
            renderType = "jsp";
        }

        node.setRenderType(renderType);

        return node;
    }

    private static WorkflowNode createDecisionNode(Workflow workflow,
            EntityXML e, Map<String, String> parameters) {
        DecisionNode node = new DecisionNode(e.getName(), e.getUuid(), workflow);
        String sOperator = parameters
                .get(SWFParametersConstants.DECISION_NODE_OPERATOR);

        if (sOperator != null) {
            node.setOperator(DecisionOperators.valueOf(sOperator));
        }

        String sCompType = parameters
                .get(SWFParametersConstants.DECISION_NODE_COMP_TYPE);

        if (sCompType != null) {
            node.setCompTypes(DecisionCompTypes.valueOf(sCompType));
        } else {
            node.setCompTypes(DecisionCompTypes.context);
        }

        node.setDecisionKey(parameters
                .get(SWFParametersConstants.DECISION_NODE_DECISION_KEY));

        node.setComparisonKey(parameters
                .get(SWFParametersConstants.DECISION_NODE_COMP_KEY));

        return node;
    }

    private static WorkflowNode createLoopNode(Workflow workflow, EntityXML e, Map<String, String> parameters) {
        LoopNode node = new LoopNode(e.getName(), e.getUuid(), workflow);

        node.setIteratorKey(parameters.get(SWFParametersConstants.LOOP_NODE_ITERATOR));
        node.setElementKey(parameters.get(SWFParametersConstants.LOOP_NODE_ELEMENT));
        return node;
    }

    private static WorkflowNode createCustomNode(Workflow workflow, EntityXML e, Map<String, String> parameters) {
        CustomNode node = new CustomNode(e.getName(), e.getUuid(), workflow);
        Set<String> keys = parameters.keySet();
        for (String key : keys)
        {
            if (key.startsWith(SWFParametersConstants.CUSTOM_BLOCK_PARAMETER_PREFIX) && key.endsWith(":" + SWFParametersConstants.CUSTOM_BLOCK_INPUT_PARAMETER_PREFIX))
            {
                node.addParameter(key, parameters.get(key));
            }
            if (key.startsWith(SWFParametersConstants.CUSTOM_BLOCK_PARAMETER_PREFIX) && key.endsWith(":" + SWFParametersConstants.CUSTOM_BLOCK_OUTPUT_PARAMETER_PREFIX))
            {
                node.addOutParameter(key, parameters.get(key));
            }

        }

        return node;
    }

}
