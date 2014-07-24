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
package org.neuro4j.studio.flow.convert.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.gmf.runtime.notation.impl.RelativeBendpointsImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;

import org.neuro4j.studio.core.util.FlowUtils;
import org.neuro4j.studio.core.util.PropetiesConstants;
import org.neuro4j.studio.flow.convert.ECore2EnfinityConverter;

public class ECore2EnfinityConverterImpl implements ECore2EnfinityConverter {

    Neuro4jFactory neuro4jFactory = null;
    Neuro4jPackage neuro4jPackage = null;
    XMLResource resource;

    public ECore2EnfinityConverterImpl()
    {
        neuro4jFactory = Neuro4jFactory.eINSTANCE;
        neuro4jPackage = Neuro4jPackage.eINSTANCE;
    }

//    @Override
//    public WorkflowNode convert(EObject eCore) {
//    	NodeXML entity = new NodeXML();
//        return entity;
//    }

    @Override
    public NodeXML convert(ActionNode node, ShapeImpl shape, FlowXML workflow) {

    	NodeXML entity = new NodeXML(node.getId(),node.getName(), workflow);
    	
        // setUUID(entity, node);
        // entity.setName(node.getName());
//        setEntityJsConsoleNodeType(entity, node);
        setCoordinates(entity, shape);
        setBlockClass(entity, node);
        processRelations(entity, node);
        node.setNodeSpecificProperties(entity);
        return entity;
    }

//    protected void setEntityJsConsoleNodeType(NodeXML entity, ActionNode node)
//    {
//        entity.addParameter(PropetiesConstants.N4J_CONSOLE_NODE_TYPE, "N4J_CONSOLE_NODE_TYPE");
//    }


    public void setCoordinates(NodeXML node, ShapeImpl shape)
    {
        BoundsImpl bounds = (BoundsImpl) shape.getLayoutConstraint();
        node.setX(bounds.getX());
        node.setY(bounds.getY());

    }

    protected void setBlockClass(NodeXML entity, ActionNode node)
    {
      //  entity.addParameter(PropetiesConstants.SWF_BLOCK_CLASS, getClassName(node));
        entity.setType(node.getNodeType().toString());
    }

    public String getClassName(ActionNode node) {
        return node.getLogicImplementationClassName();
    }

    public void setResource(XMLResource resource) {
        this.resource = resource;
    }

    private void processRelations(NodeXML entity, ActionNode node)
    {
        EList<OperatorOutput> relations = node.getOutput();
        for (OperatorOutput output : relations)
        {
        	TransitionXML transition = new TransitionXML(null);
            transition.setUuid(output.getId());
            transition.setName(output.getName());
            transition.setFromNode(entity.getUuid());
            if (output.getTarget() == null)
            {
                continue;
            }
            transition.setToNode(output.getTarget().getId());
            
            processCoordinates(output, transition);
            entity.registerExit(transition);
        }

    }

    private void processCoordinates(OperatorOutput output, TransitionXML relation)
    {
        Edge edge = output.getEdge();
        RelativeBendpointsImpl bendpoints = (RelativeBendpointsImpl) edge.getBendpoints();
        List<RelativeBendpoint> points = bendpoints.getPoints();

        String pointsStr = FlowUtils.parseCoordinatesToString(points);
        if (pointsStr != null && !"".equals(pointsStr.trim()))
        {
            relation.setPoints(pointsStr);
        }

    }

}
