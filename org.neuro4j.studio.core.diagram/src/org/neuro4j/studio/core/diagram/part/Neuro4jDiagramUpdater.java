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
package org.neuro4j.studio.core.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.FollowByRelationNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeFalseOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeMainInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeTrueOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeJoinNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeErrorOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeMainInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLogicNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLoopNodeLoopInputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLoopNodeLoopOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLoopNodeMainInputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.MapperNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput3EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput4EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput5EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput10EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput3EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput4EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput5EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput6EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput8EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput9EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeRelationEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeStartNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class Neuro4jDiagramUpdater {

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getSemanticChildren(View view) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case NetworkEditPart.VISUAL_ID:
                return getNetwork_1000SemanticChildren(view);
            case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
                return getDecisionNodeDecisionNodeMainInput_7006SemanticChildren(view);
            case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
                return getDecisionNodeDecisionNodeFalseOutputCompartment_7007SemanticChildren(view);
            case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
                return getDecisionNodeDecisionNodeTrueOutputCompartment_7008SemanticChildren(view);
            case LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID:
                return getLoopNodeLoopNodeLoopInputCompartment_7004SemanticChildren(view);
            case LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID:
                return getLoopNodeLoopNodeMainInputCompartment_7005SemanticChildren(view);
            case LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                return getLoopNodeLoopNodeLoopOutputCompartment_7009SemanticChildren(view);
            case LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID:
                return getLoopNodeLoopNodeMainOutputCompartment_7010SemanticChildren(view);
            case LogicNodeLogicNodeMainInputEditPart.VISUAL_ID:
                return getLogicNodeLogicNodeMainInput_7012SemanticChildren(view);
            case LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                return getLogicNodeLogicNodeMainOutputCompartment_7013SemanticChildren(view);
            case LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID:
                return getLogicNodeLogicNodeErrorOutputCompartment_7014SemanticChildren(view);
            case JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID:
                return getJoinNodeJoinNodeMainOutputCompartment_7002SemanticChildren(view);
            case StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID:
                return getStartNodeStartNodeMainOutputCompartment_7001SemanticChildren(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated NOT
     */
    public static List<Neuro4jNodeDescriptor> getNetwork_1000SemanticChildren(
            View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        Network modelElement = (Network) view.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        for (Iterator<?> it = modelElement.getRootAction().iterator(); it
                .hasNext();) {
            Node childElement = (Node) it.next();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == DecisionNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == FollowByRelationNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CallNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EndNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == MapperNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == OperatorOutputEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LogicNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == OperatorInputEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == JoinNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StandardNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StandardNodeRelationEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StartNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ViewNodeEditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getDecisionNodeDecisionNodeMainInput_7006SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        DecisionNode modelElement = (DecisionNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorInput childElement = modelElement.getMainInput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorInput2EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getDecisionNodeDecisionNodeFalseOutputCompartment_7007SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        DecisionNode modelElement = (DecisionNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainFalseOutput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput2EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getDecisionNodeDecisionNodeTrueOutputCompartment_7008SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        DecisionNode modelElement = (DecisionNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainTrueOutput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput3EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLoopNodeLoopNodeLoopInputCompartment_7004SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LoopNode modelElement = (LoopNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorInput childElement = modelElement.getLoopInput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorInput3EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLoopNodeLoopNodeMainInputCompartment_7005SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LoopNode modelElement = (LoopNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorInput childElement = modelElement.getMainInput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorInput4EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLoopNodeLoopNodeLoopOutputCompartment_7009SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LoopNode modelElement = (LoopNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainExit();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput5EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLoopNodeLoopNodeMainOutputCompartment_7010SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LoopNode modelElement = (LoopNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainExit();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput4EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLogicNodeLogicNodeMainInput_7012SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LogicNode modelElement = (LogicNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInput().iterator(); it.hasNext();) {
            OperatorInput childElement = (OperatorInput) it.next();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorInput5EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLogicNodeLogicNodeMainOutputCompartment_7013SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LogicNode modelElement = (LogicNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainOutput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput6EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getLogicNodeLogicNodeErrorOutputCompartment_7014SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        LogicNode modelElement = (LogicNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        for (Iterator<?> it = modelElement.getOutput().iterator(); it.hasNext();) {
            OperatorOutput childElement = (OperatorOutput) it.next();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput7EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getJoinNodeJoinNodeMainOutputCompartment_7002SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        JoinNode modelElement = (JoinNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        {
            OperatorOutput childElement = modelElement.getMainOutput();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput8EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jNodeDescriptor> getStartNodeStartNodeMainOutputCompartment_7001SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        StartNode modelElement = (StartNode) containerView.getElement();
        LinkedList<Neuro4jNodeDescriptor> result = new LinkedList<Neuro4jNodeDescriptor>();
        for (Iterator<?> it = modelElement.getOutput().iterator(); it.hasNext();) {
            OperatorOutput childElement = (OperatorOutput) it.next();
            int visualID = Neuro4jVisualIDRegistry.getNodeVisualID(view,
                    childElement);
            if (visualID == OperatorOutput9EditPart.VISUAL_ID) {
                result.add(new Neuro4jNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getContainedLinks(View view) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case NetworkEditPart.VISUAL_ID:
                return getNetwork_1000ContainedLinks(view);
            case DecisionNodeEditPart.VISUAL_ID:
                return getDecisionNode_2007ContainedLinks(view);
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return getFollowByRelationNode_2011ContainedLinks(view);
            case LoopNodeEditPart.VISUAL_ID:
                return getLoopNode_2006ContainedLinks(view);
            case CallNodeEditPart.VISUAL_ID:
                return getCallNode_2008ContainedLinks(view);
            case EndNodeEditPart.VISUAL_ID:
                return getEndNode_2005ContainedLinks(view);
            case MapperNodeEditPart.VISUAL_ID:
                return getMapperNode_2010ContainedLinks(view);
            case OperatorOutputEditPart.VISUAL_ID:
                return getOperatorOutput_2016ContainedLinks(view);
            case LogicNodeEditPart.VISUAL_ID:
                return getLogicNode_2017ContainedLinks(view);
            case OperatorInputEditPart.VISUAL_ID:
                return getOperatorInput_2013ContainedLinks(view);
            case JoinNodeEditPart.VISUAL_ID:
                return getJoinNode_2002ContainedLinks(view);
            case StartNodeEditPart.VISUAL_ID:
                return getStartNode_2004ContainedLinks(view);
            case ViewNodeEditPart.VISUAL_ID:
                return getViewNode_2018ContainedLinks(view);
            case OperatorInput2EditPart.VISUAL_ID:
                return getOperatorInput_3005ContainedLinks(view);
            case OperatorOutput2EditPart.VISUAL_ID:
                return getOperatorOutput_3001ContainedLinks(view);
            case OperatorOutput3EditPart.VISUAL_ID:
                return getOperatorOutput_3002ContainedLinks(view);
            case OperatorInput3EditPart.VISUAL_ID:
                return getOperatorInput_3006ContainedLinks(view);
            case OperatorInput4EditPart.VISUAL_ID:
                return getOperatorInput_3007ContainedLinks(view);
            case OperatorOutput4EditPart.VISUAL_ID:
                return getOperatorOutput_3003ContainedLinks(view);
            case OperatorOutput5EditPart.VISUAL_ID:
                return getOperatorOutput_3004ContainedLinks(view);
            case OperatorInput5EditPart.VISUAL_ID:
                return getOperatorInput_3008ContainedLinks(view);
            case OperatorOutput6EditPart.VISUAL_ID:
                return getOperatorOutput_3010ContainedLinks(view);
            case OperatorOutput7EditPart.VISUAL_ID:
                return getOperatorOutput_3011ContainedLinks(view);
            case OperatorOutput8EditPart.VISUAL_ID:
                return getOperatorOutput_3012ContainedLinks(view);
            case OperatorOutput9EditPart.VISUAL_ID:
                return getOperatorOutput_3013ContainedLinks(view);
            case OperatorInput7EditPart.VISUAL_ID:
                return getOperatorInput_4009ContainedLinks(view);
            case OperatorOutput10EditPart.VISUAL_ID:
                return getOperatorOutput_4008ContainedLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getIncomingLinks(View view) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case DecisionNodeEditPart.VISUAL_ID:
                return getDecisionNode_2007IncomingLinks(view);
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return getFollowByRelationNode_2011IncomingLinks(view);
            case LoopNodeEditPart.VISUAL_ID:
                return getLoopNode_2006IncomingLinks(view);
            case CallNodeEditPart.VISUAL_ID:
                return getCallNode_2008IncomingLinks(view);
            case EndNodeEditPart.VISUAL_ID:
                return getEndNode_2005IncomingLinks(view);
            case MapperNodeEditPart.VISUAL_ID:
                return getMapperNode_2010IncomingLinks(view);
            case OperatorOutputEditPart.VISUAL_ID:
                return getOperatorOutput_2016IncomingLinks(view);
            case LogicNodeEditPart.VISUAL_ID:
                return getLogicNode_2017IncomingLinks(view);
            case OperatorInputEditPart.VISUAL_ID:
                return getOperatorInput_2013IncomingLinks(view);
            case JoinNodeEditPart.VISUAL_ID:
                return getJoinNode_2002IncomingLinks(view);
            case StartNodeEditPart.VISUAL_ID:
                return getStartNode_2004IncomingLinks(view);
            case ViewNodeEditPart.VISUAL_ID:
                return getViewNode_2018IncomingLinks(view);
            case OperatorInput2EditPart.VISUAL_ID:
                return getOperatorInput_3005IncomingLinks(view);
            case OperatorOutput2EditPart.VISUAL_ID:
                return getOperatorOutput_3001IncomingLinks(view);
            case OperatorOutput3EditPart.VISUAL_ID:
                return getOperatorOutput_3002IncomingLinks(view);
            case OperatorInput3EditPart.VISUAL_ID:
                return getOperatorInput_3006IncomingLinks(view);
            case OperatorInput4EditPart.VISUAL_ID:
                return getOperatorInput_3007IncomingLinks(view);
            case OperatorOutput4EditPart.VISUAL_ID:
                return getOperatorOutput_3003IncomingLinks(view);
            case OperatorOutput5EditPart.VISUAL_ID:
                return getOperatorOutput_3004IncomingLinks(view);
            case OperatorInput5EditPart.VISUAL_ID:
                return getOperatorInput_3008IncomingLinks(view);
            case OperatorOutput6EditPart.VISUAL_ID:
                return getOperatorOutput_3010IncomingLinks(view);
            case OperatorOutput7EditPart.VISUAL_ID:
                return getOperatorOutput_3011IncomingLinks(view);
            case OperatorOutput8EditPart.VISUAL_ID:
                return getOperatorOutput_3012IncomingLinks(view);
            case OperatorOutput9EditPart.VISUAL_ID:
                return getOperatorOutput_3013IncomingLinks(view);
            case OperatorInput7EditPart.VISUAL_ID:
                return getOperatorInput_4009IncomingLinks(view);
            case OperatorOutput10EditPart.VISUAL_ID:
                return getOperatorOutput_4008IncomingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOutgoingLinks(View view) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case DecisionNodeEditPart.VISUAL_ID:
                return getDecisionNode_2007OutgoingLinks(view);
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return getFollowByRelationNode_2011OutgoingLinks(view);
            case LoopNodeEditPart.VISUAL_ID:
                return getLoopNode_2006OutgoingLinks(view);
            case CallNodeEditPart.VISUAL_ID:
                return getCallNode_2008OutgoingLinks(view);
            case EndNodeEditPart.VISUAL_ID:
                return getEndNode_2005OutgoingLinks(view);
            case MapperNodeEditPart.VISUAL_ID:
                return getMapperNode_2010OutgoingLinks(view);
            case OperatorOutputEditPart.VISUAL_ID:
                return getOperatorOutput_2016OutgoingLinks(view);
            case LogicNodeEditPart.VISUAL_ID:
                return getLogicNode_2017OutgoingLinks(view);
            case OperatorInputEditPart.VISUAL_ID:
                return getOperatorInput_2013OutgoingLinks(view);
            case JoinNodeEditPart.VISUAL_ID:
                return getJoinNode_2002OutgoingLinks(view);
            case StartNodeEditPart.VISUAL_ID:
                return getStartNode_2004OutgoingLinks(view);
            case ViewNodeEditPart.VISUAL_ID:
                return getViewNode_2018OutgoingLinks(view);
            case OperatorInput2EditPart.VISUAL_ID:
                return getOperatorInput_3005OutgoingLinks(view);
            case OperatorOutput2EditPart.VISUAL_ID:
                return getOperatorOutput_3001OutgoingLinks(view);
            case OperatorOutput3EditPart.VISUAL_ID:
                return getOperatorOutput_3002OutgoingLinks(view);
            case OperatorInput3EditPart.VISUAL_ID:
                return getOperatorInput_3006OutgoingLinks(view);
            case OperatorInput4EditPart.VISUAL_ID:
                return getOperatorInput_3007OutgoingLinks(view);
            case OperatorOutput4EditPart.VISUAL_ID:
                return getOperatorOutput_3003OutgoingLinks(view);
            case OperatorOutput5EditPart.VISUAL_ID:
                return getOperatorOutput_3004OutgoingLinks(view);
            case OperatorInput5EditPart.VISUAL_ID:
                return getOperatorInput_3008OutgoingLinks(view);
            case OperatorOutput6EditPart.VISUAL_ID:
                return getOperatorOutput_3010OutgoingLinks(view);
            case OperatorOutput7EditPart.VISUAL_ID:
                return getOperatorOutput_3011OutgoingLinks(view);
            case OperatorOutput8EditPart.VISUAL_ID:
                return getOperatorOutput_3012OutgoingLinks(view);
            case OperatorOutput9EditPart.VISUAL_ID:
                return getOperatorOutput_3013OutgoingLinks(view);
            case OperatorInput7EditPart.VISUAL_ID:
                return getOperatorInput_4009OutgoingLinks(view);
            case OperatorOutput10EditPart.VISUAL_ID:
                return getOperatorOutput_4008OutgoingLinks(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getNetwork_1000ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getMapperNode_2010ContainedLinks(
            View view) {
        MapperNode modelElement = (MapperNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_2016ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLogicNode_2017ContainedLinks(
            View view) {
        LogicNode modelElement = (LogicNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getJoinNode_2002ContainedLinks(
            View view) {
        JoinNode modelElement = (JoinNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getStandardNode_2002ContainedLinks(
            View view) {
        StandardNode modelElement = (StandardNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getFollowByRelationNode_2011ContainedLinks(
            View view) {
        FollowByRelationNode modelElement = (FollowByRelationNode) view
                .getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getStartNode_2004ContainedLinks(
            View view) {
        StartNode modelElement = (StartNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getViewNode_2018ContainedLinks(
            View view) {
        ViewNode modelElement = (ViewNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3005ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3001ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3002ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3006ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3007ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3003ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3004ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3008ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3010ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3011ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3012ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3013ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_4009ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_4008ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getEndNode_2005ContainedLinks(
            View view) {
        EndNode modelElement = (EndNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLoopNode_2006ContainedLinks(
            View view) {
        LoopNode modelElement = (LoopNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_2013ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getDecisionNode_2007ContainedLinks(
            View view) {
        DecisionNode modelElement = (DecisionNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getMapperNode_2010IncomingLinks(
            View view) {
        MapperNode modelElement = (MapperNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_2016IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLogicNode_2017IncomingLinks(
            View view) {
        LogicNode modelElement = (LogicNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getCallNode_2008ContainedLinks(
            View view) {
        CallNode modelElement = (CallNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getJoinNode_2002IncomingLinks(
            View view) {
        JoinNode modelElement = (JoinNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getFollowByRelationNode_2011IncomingLinks(
            View view) {
        FollowByRelationNode modelElement = (FollowByRelationNode) view
                .getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getStartNode_2004IncomingLinks(
            View view) {
        StartNode modelElement = (StartNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getViewNode_2018IncomingLinks(
            View view) {
        ViewNode modelElement = (ViewNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3005IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3001IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3002IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3006IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3007IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3003IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3004IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3008IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3010IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3011IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3012IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3013IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_4009IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_4008IncomingLinks(
            View view) {
        OperatorOutput modelElement = (OperatorOutput) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorInput_4009(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getEndNode_2005IncomingLinks(
            View view) {
        EndNode modelElement = (EndNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLoopNode_2006IncomingLinks(
            View view) {
        LoopNode modelElement = (LoopNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_2013IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getDecisionNode_2007IncomingLinks(
            View view) {
        DecisionNode modelElement = (DecisionNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getMapperNode_2010OutgoingLinks(
            View view) {
        MapperNode modelElement = (MapperNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_2016OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLogicNode_2017OutgoingLinks(
            View view) {
        LogicNode modelElement = (LogicNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getCallNode_2008IncomingLinks(
            View view) {
        CallNode modelElement = (CallNode) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getIncomingTypeModelFacetLinks_OperatorOutput_4008(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getJoinNode_2002OutgoingLinks(
            View view) {
        JoinNode modelElement = (JoinNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getFollowByRelationNode_2011OutgoingLinks(
            View view) {
        FollowByRelationNode modelElement = (FollowByRelationNode) view
                .getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getStartNode_2004OutgoingLinks(
            View view) {
        StartNode modelElement = (StartNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getViewNode_2018OutgoingLinks(
            View view) {
        ViewNode modelElement = (ViewNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3005OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3001OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3002OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3006OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3007OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3003OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3004OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_3008OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3010OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3011OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3012OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_3013OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_4009OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorOutput_4008OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    private static Collection<Neuro4jLinkDescriptor> getContainedTypeModelFacetLinks_OperatorInput_4009(
            ActionNode container) {
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        for (Iterator<?> links = container.getInput().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof OperatorInput) {
                continue;
            }
            OperatorInput link = (OperatorInput) linkObject;
            if (OperatorInput7EditPart.VISUAL_ID != Neuro4jVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            OperatorOutput dst = link.getInput();
            result.add(new Neuro4jLinkDescriptor(container, dst, link,
                    Neuro4jElementTypes.OperatorInput_4009,
                    OperatorInput7EditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<Neuro4jLinkDescriptor> getContainedTypeModelFacetLinks_OperatorOutput_4008(
            ActionNode container) {
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        for (Iterator<?> links = container.getOutput().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof OperatorOutput) {
                continue;
            }
            OperatorOutput link = (OperatorOutput) linkObject;
            if (OperatorOutput10EditPart.VISUAL_ID != Neuro4jVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            ActionNode dst = link.getTarget();
            result.add(new Neuro4jLinkDescriptor(container, dst, link,
                    Neuro4jElementTypes.OperatorOutput_4008,
                    OperatorOutput10EditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<Neuro4jLinkDescriptor> getIncomingTypeModelFacetLinks_OperatorInput_4009(
            OperatorOutput target,
            Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences
                .get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != Neuro4jPackage.eINSTANCE
                    .getOperatorInput_Input()
                    || false == setting.getEObject() instanceof OperatorInput) {
                continue;
            }
            OperatorInput link = (OperatorInput) setting.getEObject();
            if (OperatorInput7EditPart.VISUAL_ID != Neuro4jVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof ActionNode) {
                continue;
            }
            ActionNode container = (ActionNode) link.eContainer();
            result.add(new Neuro4jLinkDescriptor(container, target, link,
                    Neuro4jElementTypes.OperatorInput_4009,
                    OperatorInput7EditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<Neuro4jLinkDescriptor> getIncomingTypeModelFacetLinks_OperatorOutput_4008(
            ActionNode target,
            Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences
                .get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() != Neuro4jPackage.eINSTANCE
                    .getOperatorOutput_Target()
                    || false == setting.getEObject() instanceof OperatorOutput) {
                continue;
            }
            OperatorOutput link = (OperatorOutput) setting.getEObject();
            if (OperatorOutput10EditPart.VISUAL_ID != Neuro4jVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            if (false == link.eContainer() instanceof ActionNode) {
                continue;
            }
            ActionNode container = (ActionNode) link.eContainer();
            result.add(new Neuro4jLinkDescriptor(container, target, link,
                    Neuro4jElementTypes.OperatorOutput_4008,
                    OperatorOutput10EditPart.VISUAL_ID));

        }
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getEndNode_2005OutgoingLinks(
            View view) {
        EndNode modelElement = (EndNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getLoopNode_2006OutgoingLinks(
            View view) {
        LoopNode modelElement = (LoopNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getOperatorInput_2013OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getDecisionNode_2007OutgoingLinks(
            View view) {
        DecisionNode modelElement = (DecisionNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<Neuro4jLinkDescriptor> getCallNode_2008OutgoingLinks(
            View view) {
        CallNode modelElement = (CallNode) view.getElement();
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        result.addAll(getContainedTypeModelFacetLinks_OperatorInput_4009(modelElement));
        result.addAll(getContainedTypeModelFacetLinks_OperatorOutput_4008(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
        /**
         * @generated
         */
        @Override
        public List<Neuro4jNodeDescriptor> getSemanticChildren(View view) {
            return Neuro4jDiagramUpdater.getSemanticChildren(view);
        }

        /**
         * @generated
         */
        @Override
        public List<Neuro4jLinkDescriptor> getContainedLinks(View view) {
            return Neuro4jDiagramUpdater.getContainedLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<Neuro4jLinkDescriptor> getIncomingLinks(View view) {
            return Neuro4jDiagramUpdater.getIncomingLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<Neuro4jLinkDescriptor> getOutgoingLinks(View view) {
            return Neuro4jDiagramUpdater.getOutgoingLinks(view);
        }
    };

}
