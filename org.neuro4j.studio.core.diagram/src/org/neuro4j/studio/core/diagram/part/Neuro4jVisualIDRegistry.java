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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeDynamicFlowNameFlowNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeCompKeyOperatorDecisionEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeFalseOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeMainInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeTrueOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeJoinNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeErrorOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeMainInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeLogicNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLabelEditPart;
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
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeRelationEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeStartNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeViewNameDynamicViewNameEditPart;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class Neuro4jVisualIDRegistry {

    /**
     * @generated
     */
    private static final String DEBUG_KEY = "org.neuro4j.studio.core.diagram/debug/visualID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static int getVisualID(View view) {
        if (view instanceof Diagram) {
            if (NetworkEditPart.MODEL_ID.equals(view.getType())) {
                return NetworkEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                .getVisualID(view.getType());
    }

    /**
     * @generated
     */
    public static String getModelID(View view) {
        View diagram = view.getDiagram();
        while (view != diagram) {
            EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
            if (annotation != null) {
                return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
            }
            view = (View) view.eContainer();
        }
        return diagram != null ? diagram.getType() : null;
    }

    /**
     * @generated
     */
    public static int getVisualID(String type) {
        try {
            return Integer.parseInt(type);
        } catch (NumberFormatException e) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(
                    Platform.getDebugOption(DEBUG_KEY))) {
                Neuro4jDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: "
                                + type);
            }
        }
        return -1;
    }

    /**
     * @generated
     */
    public static String getType(int visualID) {
        return Integer.toString(visualID);
    }

    /**
     * @generated
     */
    public static int getDiagramVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (Neuro4jPackage.eINSTANCE.getNetwork().isSuperTypeOf(
                domainElement.eClass())
                && isDiagram((Network) domainElement)) {
            return NetworkEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * @generated NOT
     */
    public static int getNodeVisualID(View containerView, EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        String containerModelID = org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                .getModelID(containerView);
        if (!NetworkEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (NetworkEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = NetworkEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
            case NetworkEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return DecisionNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getFollowByRelationNode()
                        .isSuperTypeOf(domainElement.eClass())) {
                    return FollowByRelationNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getLoopNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return LoopNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getCallNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return CallNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getEndNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return EndNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getMapperNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return MapperNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutputEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getLogicNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return LogicNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorInputEditPart.VISUAL_ID;
                }
                if (domainElement instanceof StandardNodeImpl) {
                    if (((StandardNodeImpl) domainElement).getType() == 1)
                    {
                        return StandardNodeRelationEditPart.VISUAL_ID;
                    } else {
                        return StandardNodeEditPart.VISUAL_ID;
                    }

                }
                if (Neuro4jPackage.eINSTANCE.getJoinNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return JoinNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getStartNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return StartNodeEditPart.VISUAL_ID;
                }
                if (Neuro4jPackage.eINSTANCE.getViewNode().isSuperTypeOf(
                        domainElement.eClass())) {
                    return ViewNodeEditPart.VISUAL_ID;
                }
                break;
            case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorInput2EditPart.VISUAL_ID;
                }
                break;
            case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput2EditPart.VISUAL_ID;
                }
                break;
            case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput3EditPart.VISUAL_ID;
                }
                break;
            case LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorInput3EditPart.VISUAL_ID;
                }
                break;
            case LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorInput4EditPart.VISUAL_ID;
                }
                break;
            case LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput5EditPart.VISUAL_ID;
                }
                break;
            case LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput4EditPart.VISUAL_ID;
                }
                break;
            case LogicNodeLogicNodeMainInputEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorInput5EditPart.VISUAL_ID;
                }
                break;
            case LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput6EditPart.VISUAL_ID;
                }
                break;
            case LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput7EditPart.VISUAL_ID;
                }
                break;
            case JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput8EditPart.VISUAL_ID;
                }
                break;
            case StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                        domainElement.eClass())) {
                    return OperatorOutput9EditPart.VISUAL_ID;
                }
                break;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                .getModelID(containerView);
        if (!NetworkEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (NetworkEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = NetworkEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
            case NetworkEditPart.VISUAL_ID:
                if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (FollowByRelationNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LoopNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (CallNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (EndNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (MapperNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (OperatorOutputEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LogicNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (OperatorInputEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (StartNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (ViewNodeEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case DecisionNodeEditPart.VISUAL_ID:
                if (DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case FollowByRelationNodeEditPart.VISUAL_ID:
                if (FollowByRelationNodeNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LoopNodeEditPart.VISUAL_ID:
                if (LoopNodeLabelEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case CallNodeEditPart.VISUAL_ID:
                if (CallNodeDynamicFlowNameFlowNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case EndNodeEditPart.VISUAL_ID:
                if (EndNodeNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LogicNodeEditPart.VISUAL_ID:
                if (LogicNodeNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LogicNodeLogicNodeMainInputEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case JoinNodeEditPart.VISUAL_ID:
                if (JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case StartNodeEditPart.VISUAL_ID:
                if (StartNodeNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                if (StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case ViewNodeEditPart.VISUAL_ID:
                if (ViewNodeViewNameDynamicViewNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
                if (OperatorInput2EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput2EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput3EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID:
                if (OperatorInput3EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID:
                if (OperatorInput4EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput5EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput4EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LogicNodeLogicNodeMainInputEditPart.VISUAL_ID:
                if (OperatorInput5EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput6EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput7EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput8EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID:
                if (OperatorOutput9EditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
            case OperatorOutput10EditPart.VISUAL_ID:
                if (OperatorOutputNameEditPart.VISUAL_ID == nodeVisualID) {
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static int getLinkWithClassVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (domainElement instanceof StandardNodeImpl)
        {
            return OperatorOutput10EditPart.VISUAL_ID;
        }
        if (Neuro4jPackage.eINSTANCE.getOperatorInput().isSuperTypeOf(
                domainElement.eClass())) {
            return OperatorInput7EditPart.VISUAL_ID;
        }
        if (Neuro4jPackage.eINSTANCE.getOperatorOutput().isSuperTypeOf(
                domainElement.eClass())) {
            return OperatorOutput10EditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * User can change implementation of this method to handle some specific
     * situations not covered by default logic.
     * 
     * @generated
     */
    private static boolean isDiagram(Network element) {
        return true;
    }

    /**
     * @generated
     */
    public static boolean checkNodeVisualID(View containerView,
            EObject domainElement, int candidate) {
        if (candidate == -1) {
            // unrecognized id is always bad
            return false;
        }
        int basic = getNodeVisualID(containerView, domainElement);
        return basic == candidate;
    }

    /**
     * @generated
     */
    public static boolean isCompartmentVisualID(int visualID) {
        switch (visualID) {
            case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
            case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
            case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
            case LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID:
            case LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID:
            case LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
            case LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID:
            case LogicNodeLogicNodeMainInputEditPart.VISUAL_ID:
            case LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
            case LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID:
            case JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID:
            case StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID:
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static boolean isSemanticLeafVisualID(int visualID) {
        switch (visualID) {
            case NetworkEditPart.VISUAL_ID:
                return false;
            case EndNodeEditPart.VISUAL_ID:
            case CallNodeEditPart.VISUAL_ID:
            case MapperNodeEditPart.VISUAL_ID:
            case FollowByRelationNodeEditPart.VISUAL_ID:
            case OperatorInputEditPart.VISUAL_ID:
            case OperatorOutputEditPart.VISUAL_ID:
            case ViewNodeEditPart.VISUAL_ID:
            case OperatorOutput2EditPart.VISUAL_ID:
            case OperatorOutput3EditPart.VISUAL_ID:
            case OperatorOutput4EditPart.VISUAL_ID:
            case OperatorOutput5EditPart.VISUAL_ID:
            case OperatorInput2EditPart.VISUAL_ID:
            case OperatorInput3EditPart.VISUAL_ID:
            case OperatorInput4EditPart.VISUAL_ID:
            case OperatorInput5EditPart.VISUAL_ID:
            case OperatorOutput6EditPart.VISUAL_ID:
            case OperatorOutput7EditPart.VISUAL_ID:
            case OperatorOutput8EditPart.VISUAL_ID:
            case OperatorOutput9EditPart.VISUAL_ID:
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
        /**
         * @generated
         */
        @Override
        public int getVisualID(View view) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .getVisualID(view);
        }

        /**
         * @generated
         */
        @Override
        public String getModelID(View view) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .getModelID(view);
        }

        /**
         * @generated
         */
        @Override
        public int getNodeVisualID(View containerView, EObject domainElement) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .getNodeVisualID(containerView, domainElement);
        }

        /**
         * @generated
         */
        @Override
        public boolean checkNodeVisualID(View containerView,
                EObject domainElement, int candidate) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .checkNodeVisualID(containerView, domainElement, candidate);
        }

        /**
         * @generated
         */
        @Override
        public boolean isCompartmentVisualID(int visualID) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .isCompartmentVisualID(visualID);
        }

        /**
         * @generated
         */
        @Override
        public boolean isSemanticLeafVisualID(int visualID) {
            return org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry
                    .isSemanticLeafVisualID(visualID);
        }
    };

}
