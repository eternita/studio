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
import org.eclipse.emf.ecore.EObject;
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
import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.studio.core.util.FlowUtils;
import org.neuro4j.studio.core.util.PropetiesConstants;
import org.neuro4j.studio.flow.convert.ECore2EnfinityConverter;
import org.neuro4j.workflow.node.WorkflowNode;

public class ECore2EnfinityConverterImpl implements ECore2EnfinityConverter {

    Neuro4jFactory neuro4jFactory = null;
    Neuro4jPackage neuro4jPackage = null;
    XMLResource resource;

    public ECore2EnfinityConverterImpl()
    {
        neuro4jFactory = Neuro4jFactory.eINSTANCE;
        neuro4jPackage = Neuro4jPackage.eINSTANCE;
    }

    @Override
    public WorkflowNode convert(EObject eCore) {
        WorkflowNode entity = new WorkflowNode();
        return entity;
    }

    @Override
    public WorkflowNode convert(ActionNode node, ShapeImpl shape) {

        WorkflowNode entity = new WorkflowNode(node.getName(), node.getId(), null);
        // setUUID(entity, node);
        // entity.setName(node.getName());
        setEntityJsConsoleNodeType(entity, node);
        setCoordinates(entity, shape);
        setBlockClass(entity, node);
        processRelations(entity, node);
        node.setNodeSpecificProperties(entity);
        return entity;
    }

    protected void setEntityJsConsoleNodeType(WorkflowNode entity, ActionNode node)
    {
        entity.addParameter(PropetiesConstants.N4J_CONSOLE_NODE_TYPE, "N4J_CONSOLE_NODE_TYPE");
    }

    // protected void setUUID(WorkflowNode entity, ActionNode node)
    // {
    // if (node.getId() != null)
    // {
    // entity.setUuid(node.getId());
    // }
    //
    // }

    public void setCoordinates(WorkflowNode entity, ShapeImpl node)
    {
        BoundsImpl bounds = (BoundsImpl) node.getLayoutConstraint();
        entity.addParameter(PropetiesConstants.LOCATION_X, bounds.getX() + "");
        entity.addParameter(PropetiesConstants.LOCATION_Y, bounds.getY() + "");

    }

    protected void setBlockClass(WorkflowNode entity, ActionNode node)
    {
        entity.addParameter(PropetiesConstants.SWF_BLOCK_CLASS, getClassName(node));
    }

    public String getClassName(ActionNode node) {
        return node.getLogicImplementationClassName();
    }

    public void setResource(XMLResource resource) {
        this.resource = resource;
    }

    private void processRelations(WorkflowNode entity, ActionNode node)
    {
        EList<OperatorOutput> relations = node.getOutput();
        for (OperatorOutput output : relations)
        {
            // WorkflowNode relation = new WorkflowNode(output.getName(), output.getId(), null, new BlockDescriptor());

            XmlTransition transition = new XmlTransition(null);
            transition.setUuid(output.getId());
            transition.setName(output.getName());
            transition.setFromNode(entity);
            transition.setFromUuid(entity.getUuid());
            // relation.setUuid(output.getId());
            // relation.setProperty("StartUUID", entity.getUuid());
            if (output.getTarget() == null)
            {
                continue;
            }
            transition.setToUuid(output.getTarget().getId());
            // relation.setProperty("EndUUID", output.getTarget().getId());
            // relation.addConnected(entity);
            // relation.addConnected(output.getTarget().getId());
            processCoordinates(output, transition);
            entity.registerExit(transition);
        }

    }

    private void processCoordinates(OperatorOutput output, XmlTransition relation)
    {
        Edge edge = output.getEdge();
        RelativeBendpointsImpl bendpoints = (RelativeBendpointsImpl) edge.getBendpoints();
        List<RelativeBendpoint> points = bendpoints.getPoints();

        String pointsStr = FlowUtils.parseCoordinatesToString(points);
        if (pointsStr != null && !"".equals(pointsStr.trim()))
        {
            relation.setCoordinates(pointsStr);
            // OperatorOutput.POINTS_KEY
        }

    }

}
