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
package org.neuro4j.studio.core.diagram.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StandardNode;
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
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.impl.NetworkImpl;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;
import org.neuro4j.studio.core.relation.ActionNodeRelationProcessorFactory;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;
import org.neuro4j.studio.core.util.PropetiesConstants;

/**
 * @generated
 */
public class Neuro4jViewProvider extends AbstractProvider implements
        IViewProvider {
    public static int SDT = 50;

    /**
     * @generated
     */
    public final boolean provides(IOperation operation) {
        if (operation instanceof CreateViewForKindOperation) {
            return provides((CreateViewForKindOperation) operation);
        }
        assert operation instanceof CreateViewOperation;
        if (operation instanceof CreateDiagramViewOperation) {
            return provides((CreateDiagramViewOperation) operation);
        } else if (operation instanceof CreateEdgeViewOperation) {
            return provides((CreateEdgeViewOperation) operation);
        } else if (operation instanceof CreateNodeViewOperation) {
            return provides((CreateNodeViewOperation) operation);
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean provides(CreateViewForKindOperation op) {
        /*
         * if (op.getViewKind() == Node.class)
         * return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
         * if (op.getViewKind() == Edge.class)
         * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
         */
        return true;
    }

    /**
     * @generated
     */
    protected boolean provides(CreateDiagramViewOperation op) {
        return NetworkEditPart.MODEL_ID.equals(op.getSemanticHint())
                && Neuro4jVisualIDRegistry
                        .getDiagramVisualID(getSemanticElement(op
                                .getSemanticAdapter())) != -1;
    }

    /**
     * @generated
     */
    protected boolean provides(CreateNodeViewOperation op) {
        if (op.getContainerView() == null) {
            return false;
        }
        IElementType elementType = getSemanticElementType(op
                .getSemanticAdapter());
        EObject domainElement = getSemanticElement(op.getSemanticAdapter());
        int visualID;
        if (op.getSemanticHint() == null) {
            // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
            // In this situation there should be NO elementType, visualID will be determined
            // by VisualIDRegistry.getNodeVisualID() for domainElement.
            if (elementType != null || domainElement == null) {
                return false;
            }
            visualID = Neuro4jVisualIDRegistry.getNodeVisualID(
                    op.getContainerView(), domainElement);
        } else {
            visualID = Neuro4jVisualIDRegistry
                    .getVisualID(op.getSemanticHint());
            if (elementType != null) {
                if (!Neuro4jElementTypes.isKnownElementType(elementType)
                        || (!(elementType instanceof IHintedType))) {
                    return false; // foreign element type
                }
                String elementTypeHint = ((IHintedType) elementType)
                        .getSemanticHint();
                if (!op.getSemanticHint().equals(elementTypeHint)) {
                    return false; // if semantic hint is specified it should be the same as in element type
                }
                if (domainElement != null
                        && visualID != Neuro4jVisualIDRegistry.getNodeVisualID(
                                op.getContainerView(), domainElement)) {
                    return false; // visual id for node EClass should match visual id from element type
                }
            } else {
                if (!NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                        .getModelID(op.getContainerView()))) {
                    return false; // foreign diagram
                }
                switch (visualID) {
                    case DecisionNodeEditPart.VISUAL_ID:
                    case FollowByRelationNodeEditPart.VISUAL_ID:
                    case LoopNodeEditPart.VISUAL_ID:
                    case CallNodeEditPart.VISUAL_ID:
                    case EndNodeEditPart.VISUAL_ID:
                    case MapperNodeEditPart.VISUAL_ID:
                    case LogicNodeEditPart.VISUAL_ID:
                    case JoinNodeEditPart.VISUAL_ID:
                    case StandardNodeEditPart.VISUAL_ID:
                    case StandardNodeRelationEditPart.VISUAL_ID:
                    case StartNodeEditPart.VISUAL_ID:
                    case ViewNodeEditPart.VISUAL_ID:
                    case OperatorInput2EditPart.VISUAL_ID:
                    case OperatorOutput2EditPart.VISUAL_ID:
                    case OperatorOutputEditPart.VISUAL_ID:
                    case OperatorInputEditPart.VISUAL_ID:
                    case OperatorOutput3EditPart.VISUAL_ID:
                    case OperatorInput3EditPart.VISUAL_ID:
                    case OperatorInput4EditPart.VISUAL_ID:
                    case OperatorOutput4EditPart.VISUAL_ID:
                    case OperatorOutput5EditPart.VISUAL_ID:
                    case OperatorInput5EditPart.VISUAL_ID:
                    case OperatorOutput6EditPart.VISUAL_ID:
                    case OperatorOutput7EditPart.VISUAL_ID:
                    case OperatorOutput8EditPart.VISUAL_ID:
                    case OperatorOutput9EditPart.VISUAL_ID:
                        if (domainElement == null
                                || visualID != Neuro4jVisualIDRegistry
                                        .getNodeVisualID(op.getContainerView(),
                                                domainElement)) {
                            return false; // visual id in semantic hint should match visual id for domain element
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return DecisionNodeEditPart.VISUAL_ID == visualID
                || FollowByRelationNodeEditPart.VISUAL_ID == visualID
                || LoopNodeEditPart.VISUAL_ID == visualID
                || CallNodeEditPart.VISUAL_ID == visualID
                || EndNodeEditPart.VISUAL_ID == visualID
                || MapperNodeEditPart.VISUAL_ID == visualID
                || OperatorOutputEditPart.VISUAL_ID == visualID
                || LogicNodeEditPart.VISUAL_ID == visualID
                || OperatorInputEditPart.VISUAL_ID == visualID
                || JoinNodeEditPart.VISUAL_ID == visualID
                || StandardNodeEditPart.VISUAL_ID == visualID
                || StandardNodeRelationEditPart.VISUAL_ID == visualID
                || StartNodeEditPart.VISUAL_ID == visualID
                || ViewNodeEditPart.VISUAL_ID == visualID
                || OperatorInput2EditPart.VISUAL_ID == visualID
                || OperatorOutput2EditPart.VISUAL_ID == visualID
                || OperatorOutput3EditPart.VISUAL_ID == visualID
                || OperatorInput3EditPart.VISUAL_ID == visualID
                || OperatorInput4EditPart.VISUAL_ID == visualID
                || OperatorOutput4EditPart.VISUAL_ID == visualID
                || OperatorOutput5EditPart.VISUAL_ID == visualID
                || OperatorInput5EditPart.VISUAL_ID == visualID
                || OperatorOutput6EditPart.VISUAL_ID == visualID
                || OperatorOutput7EditPart.VISUAL_ID == visualID
                || OperatorOutput8EditPart.VISUAL_ID == visualID
                || OperatorOutput9EditPart.VISUAL_ID == visualID;
    }

    /**
     * @generated
     */
    protected boolean provides(CreateEdgeViewOperation op) {
        IElementType elementType = getSemanticElementType(op
                .getSemanticAdapter());
        if (!Neuro4jElementTypes.isKnownElementType(elementType)
                || (!(elementType instanceof IHintedType))) {
            return false; // foreign element type
        }
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        if (elementTypeHint == null
                || (op.getSemanticHint() != null && !elementTypeHint.equals(op
                        .getSemanticHint()))) {
            return false; // our hint is visual id and must be specified, and it should be the same as in element type
        }
        int visualID = Neuro4jVisualIDRegistry.getVisualID(elementTypeHint);
        EObject domainElement = getSemanticElement(op.getSemanticAdapter());
        if (domainElement != null
                && visualID != Neuro4jVisualIDRegistry
                        .getLinkWithClassVisualID(domainElement)) {
            return false; // visual id for link EClass should match visual id from element type
        }
        return true;
    }

    /**
     * @generated
     */
    public Diagram createDiagram(IAdaptable semanticAdapter,
            String diagramKind, PreferencesHint preferencesHint) {
        Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
        diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
        diagram.setType(NetworkEditPart.MODEL_ID);
        diagram.setElement(getSemanticElement(semanticAdapter));
        diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
        // diagram.
        // ViewUtil.setStructuralFeatureValue(diagram,
        // NotationPackage.eINSTANCE.getGradientStyle(), GradientStyle.VERTICAL_LITERAL);
        return diagram;
    }

    /**
     * @generated NOT
     */
    public Node createNode(IAdaptable semanticAdapter, View containerView,
            String semanticHint, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        final EObject domainElement = getSemanticElement(semanticAdapter);
        final int visualID;
        if (semanticHint == null) {
            visualID = Neuro4jVisualIDRegistry.getNodeVisualID(containerView,
                    domainElement);
        } else {
            visualID = Neuro4jVisualIDRegistry.getVisualID(semanticHint);
        }

        if (domainElement instanceof ActionNode)
        {
            NetworkImpl network = (NetworkImpl) containerView.getElement();
            ((ActionNode) domainElement).setNetwork(network);
        }

        switch (visualID) {
            case DecisionNodeEditPart.VISUAL_ID:
                return createDecisionNode_2007(domainElement, containerView, index,
                        persisted, preferencesHint);
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return createFollowByRelationNode_2011(domainElement,
                        containerView, index, persisted, preferencesHint);
            case LoopNodeEditPart.VISUAL_ID:
                return createLoopNode_2006(domainElement, containerView, index,
                        persisted, preferencesHint);
            case CallNodeEditPart.VISUAL_ID:
                return createCallNode_2008(domainElement, containerView, index,
                        persisted, preferencesHint);
            case EndNodeEditPart.VISUAL_ID:
                return createEndNode_2005(domainElement, containerView, index,
                        persisted, preferencesHint);
            case MapperNodeEditPart.VISUAL_ID:
                return createMapperNode_2010(domainElement, containerView, index,
                        persisted, preferencesHint);
            case OperatorOutputEditPart.VISUAL_ID:
                return createOperatorOutput_2016(domainElement, containerView,
                        index, persisted, preferencesHint);
            case LogicNodeEditPart.VISUAL_ID:
                return createLogicNode_2017(domainElement, containerView, index,
                        persisted, preferencesHint);
            case OperatorInputEditPart.VISUAL_ID:
                return createOperatorInput_2013(domainElement, containerView,
                        index, persisted, preferencesHint);
            case JoinNodeEditPart.VISUAL_ID:
                return createJoinNode_2002(domainElement, containerView, index,
                        persisted, preferencesHint);
            case StandardNodeEditPart.VISUAL_ID:
                return createStandardNode_2019(domainElement, containerView, index,
                        persisted, preferencesHint, StandardNodeEditPart.VISUAL_ID);
            case StandardNodeRelationEditPart.VISUAL_ID:
                return createStandardNode_2019(domainElement, containerView, index,
                        persisted, preferencesHint, StandardNodeRelationEditPart.VISUAL_ID);
            case StartNodeEditPart.VISUAL_ID:
                return createStartNode_2004(domainElement, containerView, index,
                        persisted, preferencesHint);
            case ViewNodeEditPart.VISUAL_ID:
                return createViewNode_2018(domainElement, containerView, index,
                        persisted, preferencesHint);
            case OperatorInput2EditPart.VISUAL_ID:
                return createOperatorInput_3005(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput2EditPart.VISUAL_ID:
                return createOperatorOutput_3001(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput3EditPart.VISUAL_ID:
                return createOperatorOutput_3002(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorInput3EditPart.VISUAL_ID:
                return createOperatorInput_3006(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorInput4EditPart.VISUAL_ID:
                return createOperatorInput_3007(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput4EditPart.VISUAL_ID:
                return createOperatorOutput_3003(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput5EditPart.VISUAL_ID:
                return createOperatorOutput_3004(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorInput5EditPart.VISUAL_ID:
                return createOperatorInput_3008(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput6EditPart.VISUAL_ID:
                return createOperatorOutput_3010(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput7EditPart.VISUAL_ID:
                return createOperatorOutput_3011(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput8EditPart.VISUAL_ID:
                return createOperatorOutput_3012(domainElement, containerView,
                        index, persisted, preferencesHint);
            case OperatorOutput9EditPart.VISUAL_ID:
                return createOperatorOutput_3013(domainElement, containerView,
                        index, persisted, preferencesHint);
        }
        // can't happen, provided #provides(CreateNodeViewOperation) is correct
        return null;
    }

    /**
     * @generated
     */
    public Edge createEdge(IAdaptable semanticAdapter, View containerView,
            String semanticHint, int index, boolean persisted,
            PreferencesHint preferencesHint) {

        IElementType elementType = getSemanticElementType(semanticAdapter);
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();

        if (elementTypeHint.equals(OperatorOutput10EditPart.VISUAL_ID + "") && semanticAdapter instanceof CreateElementRequestAdapter)
        {
            EObject eb = getSemanticElement(semanticAdapter);
            if (eb == null)
            {
                CreateRelationshipRequest eObject = (CreateRelationshipRequest) semanticAdapter.getAdapter(CreateRelationshipRequest.class);

                ActionNode source = (ActionNode) eObject.getSource();
                if (source instanceof StandardNodeImpl)
                {
                    return createOperatorOutputWithStandardNode((CreateElementRequestAdapter) semanticAdapter, containerView, index,
                            persisted, preferencesHint);
                } else {
                    return createOperatorOutputWithJoinNode((CreateElementRequestAdapter) semanticAdapter, containerView, index,
                            persisted, preferencesHint);
                }
            }

        }

        switch (Neuro4jVisualIDRegistry.getVisualID(elementTypeHint)) {
            case OperatorInput7EditPart.VISUAL_ID:
                return createOperatorInput_4009(
                        getSemanticElement(semanticAdapter), containerView, index,
                        persisted, preferencesHint);
            case OperatorOutput10EditPart.VISUAL_ID:
                return createOperatorOutput_4008(
                        getSemanticElement(semanticAdapter), containerView, index,
                        persisted, preferencesHint);
        }
        // can never happen, provided #provides(CreateEdgeViewOperation) is correct
        return null;
    }

    /**
     * @generated
     */
    public Node createMapperNode_2010(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(MapperNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_2016(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutputEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createLogicNode_2017(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(LogicNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5005 = createLabel(node,
                Neuro4jVisualIDRegistry
                        .getType(LogicNodeNameEditPart.VISUAL_ID));
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LogicNodeLogicNodeMainInputEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createJoinNode_2002(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(JoinNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        // org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
        // prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        // ViewUtil.setStructuralFeatureValue(node,
        // NotationPackage.eINSTANCE.getLineStyle_LineColor(),
        // FigureUtilities.RGBToInteger(lineRGB));
        // FontStyle nodeFontStyle = (FontStyle) node
        // .getStyle(NotationPackage.Literals.FONT_STYLE);
        // if (nodeFontStyle != null) {
        // FontData fontData = PreferenceConverter.getFontData(prefStore,
        // IPreferenceConstants.PREF_DEFAULT_FONT);
        // nodeFontStyle.setFontName(fontData.getName());
        // nodeFontStyle.setFontHeight(fontData.getHeight());
        // nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
        // nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
        // org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
        // .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
        // nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
        // .intValue());
        // }
        // org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
        // prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        // ViewUtil.setStructuralFeatureValue(node,
        // NotationPackage.eINSTANCE.getFillStyle_FillColor(),
        // FigureUtilities.RGBToInteger(fillRGB));
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    public Node createStandardNode_2019(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint, int visualid) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(visualid));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createFollowByRelationNode_2011(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(FollowByRelationNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5001 = createLabel(node,
                Neuro4jVisualIDRegistry
                        .getType(FollowByRelationNodeNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createStartNode_2004(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(StartNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold(true);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5003 = createLabel(node,
                Neuro4jVisualIDRegistry
                        .getType(StartNodeNameEditPart.VISUAL_ID));
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createViewNode_2018(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(ViewNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();
        prefStore.getDefaultBoolean(IPreferenceConstants.PREF_SHOW_GRID);

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold(true);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5004 = createLabel(
                node,
                Neuro4jVisualIDRegistry
                        .getType(ViewNodeViewNameDynamicViewNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorInput_3005(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInput2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3001(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput2EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3002(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput3EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorInput_3006(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInput3EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorInput_3007(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInput4EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3003(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput4EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3004(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput5EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorInput_3008(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInput5EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3010(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput6EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3011(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput7EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();
        prefStore.getDefaultBoolean(IPreferenceConstants.PREF_SHOW_GRID);
        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3012(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput8EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorOutput_3013(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput9EditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        // ViewUtil.setStructuralFeatureValue(node,
        // (EStructuralFeature) NotationPackage.eINSTANCE.getArrowStyle_ArrowTarget(),
        // ArrowType.SOLID_ARROW);
        return node;
    }

    /**
     * @generated
     */
    public Edge createOperatorInput_4009(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
                .createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
                2);
        points.add(new RelativeBendpoint());
        points.add(new RelativeBendpoint());
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInput7EditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(edge,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle edgeFontStyle = (FontStyle) edge
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        Routing routing = Routing.get(prefStore
                .getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge,
                    NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
                    routing);
        }
        return edge;
    }

    private JoinNode createMidiatorRelation(OperatorOutputImpl prevConnection, ActionNode source, Point locationPoint) {

        JoinNode standardNode = (JoinNode) Neuro4jFactory.eINSTANCE
                .createJoinNode();

        standardNode.setNetwork(source.getNetwork());
        source.getNetwork().addNode(standardNode);
        standardNode.setX(locationPoint.x);
        standardNode.setY(locationPoint.y);

        ActionNode t = (ActionNode) prevConnection.getTarget();

        prevConnection.setTarget(standardNode);

        // from new join to prev target
        OperatorOutput operatorOutput = Neuro4jFactory.eINSTANCE.createOperatorOutput();

        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory
                .getInstance().createProcessor(standardNode);

        if (actionRelationProcessor.processOutpuNode(standardNode, t,
                operatorOutput)) {

            // operatorOutput.getOutput().add(operatorOutput);

            operatorOutput.setTarget(t);
        }

        return standardNode;
    }

    private StandardNode createTargetRelation(OperatorOutputImpl prevConnection, StandardNodeImpl source, Point locationPoint) {

        StandardNode standardNode = (StandardNode) Neuro4jFactory.eINSTANCE
                .createStandardNode();

        standardNode.setType(1);

        standardNode.setId(prevConnection.getId());
        standardNode.setNetwork(source.getNetwork());
        source.getNetwork().addNode(standardNode);
        standardNode.setX(locationPoint.x);
        standardNode.setY(locationPoint.y);
        standardNode.getProperties().addAll(prevConnection.getProperties());
        StandardNode s = (StandardNode) prevConnection.eContainer();

        makeConnection(standardNode, s, prevConnection);

        StandardNode t = (StandardNode) prevConnection.getTarget();

        makeConnection(standardNode, t, prevConnection);

        standardNode.setName(prevConnection.getName());
        return standardNode;
    }

    private void makeConnection(ActionNode source, ActionNode target,
            OperatorOutputImpl origin) {

        OperatorOutput operatorOutput = Neuro4jFactory.eINSTANCE
                .createOperatorOutput();
        operatorOutput.setName(target.getName());
        // operatorOutput.setId(target.getId());

        operatorOutput.setId(origin.getId());
        operatorOutput.getProperties().addAll(origin.getProperties());

        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory
                .getInstance().createProcessor(source);

        if (actionRelationProcessor.processOutpuNode(source, target,
                operatorOutput)) {
            operatorOutput.setName(origin.getName());
            source.getOutput().add(operatorOutput);

            operatorOutput.setTarget(target);
        }
    }

    /**
     * Remove previous connection since new circe connection was added
     * 
     * @param operatorOutput
     */
    private void removeOldConnection(OperatorOutput operatorOutput)
    {
        ActionNode source = operatorOutput.getSource();
        if (source != null)
        {
            source.getOutput().remove(operatorOutput);
        }

        operatorOutput.setSource(null);
        operatorOutput.setTarget(null);
    }

    public Edge createOperatorOutputWithJoinNode(CreateElementRequestAdapter createElementRequestAdapter,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {

        CreateRelationshipRequest eObject = (CreateRelationshipRequest) createElementRequestAdapter.getAdapter(CreateRelationshipRequest.class);

        Point location = (Point) eObject.getParameter("location");

        ActionNode source = (ActionNode) eObject.getSource();

        OperatorOutputImpl targetRel = (OperatorOutputImpl) eObject.getTarget();

        JoinNode targetNode = createMidiatorRelation(targetRel, source, location);

        // Create connection from side node to new join
        OperatorOutput operatorOutput = Neuro4jFactory.eINSTANCE.createOperatorOutput();

        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory.getInstance().createProcessor(source);

        if (actionRelationProcessor.processOutpuNode(source, targetNode,
                operatorOutput)) {

            // doConfigure(operatorOutput, monitor, info);
            source.getOutput().add(operatorOutput);
            operatorOutput.setTarget(targetNode);
        }

        // removeOldConnection(target);

        //
        //
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        LineStyle ls = NotationFactory.eINSTANCE.createLineStyle();
        ls.setLineWidth(3);
        edge.getStyles().add(ls);
        edge.setLineWidth(3);
        operatorOutput.setEdge(edge);

        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
                .createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
                2);

        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput10EditPart.VISUAL_ID));
        edge.setElement(operatorOutput);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        if (PropetiesConstants.RELATION_ERROR_NAME
                .equalsIgnoreCase(operatorOutput.getName())) {
            lineRGB = new RGB(255, 0, 0);
        }
        ViewUtil.setStructuralFeatureValue(edge,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));

        FontStyle edgeFontStyle = (FontStyle) edge
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        Routing routing = Routing.get(prefStore
                .getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge,
                    NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
                    routing);
        }
        Node label6001 = createLabel(edge,
                Neuro4jVisualIDRegistry
                        .getType(OperatorOutputNameEditPart.VISUAL_ID));
        label6001.setLayoutConstraint(NotationFactory.eINSTANCE
                .createLocation());
        Location location6001 = (Location) label6001.getLayoutConstraint();
        location6001.setX(0);
        location6001.setY(40);
        return edge;
    }

    public Edge createOperatorOutputWithStandardNode(CreateElementRequestAdapter createElementRequestAdapter,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {

        CreateRelationshipRequest eObject = (CreateRelationshipRequest) createElementRequestAdapter.getAdapter(CreateRelationshipRequest.class);

        Point location = (Point) eObject.getParameter("location");

        StandardNodeImpl source = (StandardNodeImpl) eObject.getSource();

        OperatorOutputImpl target = (OperatorOutputImpl) eObject.getTarget();

        StandardNode targetNode = createTargetRelation(target, source, location);

        OperatorOutput operatorOutput = Neuro4jFactory.eINSTANCE.createOperatorOutput();

        // operatorOutput.setId(target.getId());

        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory.getInstance().createProcessor(source);

        if (actionRelationProcessor.processOutpuNode(source, targetNode,
                operatorOutput)) {
            operatorOutput.setName(target.getName());
            // doConfigure(operatorOutput, monitor, info);
            source.getOutput().add(operatorOutput);
            operatorOutput.setTarget(targetNode);
        }

        removeOldConnection(target);

        //
        //
        Connector edge = NotationFactory.eINSTANCE.createConnector();
        LineStyle ls = NotationFactory.eINSTANCE.createLineStyle();
        ls.setLineWidth(3);
        edge.getStyles().add(ls);
        edge.setLineWidth(3);
        operatorOutput.setEdge(edge);

        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
                .createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
                2);

        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput10EditPart.VISUAL_ID));
        edge.setElement(operatorOutput);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        if (PropetiesConstants.RELATION_ERROR_NAME
                .equalsIgnoreCase(operatorOutput.getName())) {
            lineRGB = new RGB(255, 0, 0);
        }
        ViewUtil.setStructuralFeatureValue(edge,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));

        FontStyle edgeFontStyle = (FontStyle) edge
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        Routing routing = Routing.get(prefStore
                .getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge,
                    NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
                    routing);
        }
        Node label6001 = createLabel(edge,
                Neuro4jVisualIDRegistry
                        .getType(OperatorOutputNameEditPart.VISUAL_ID));
        label6001.setLayoutConstraint(NotationFactory.eINSTANCE
                .createLocation());
        Location location6001 = (Location) label6001.getLayoutConstraint();
        location6001.setX(0);
        location6001.setY(40);
        return edge;
    }

    /**
     * @generated NOT
     */
    public Edge createOperatorOutput_4008(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        OperatorOutput operatorOutput = (OperatorOutput) domainElement;

        Connector edge = NotationFactory.eINSTANCE.createConnector();
        LineStyle ls = NotationFactory.eINSTANCE.createLineStyle();
        ls.setLineWidth(3);
        edge.getStyles().add(ls);
        edge.setLineWidth(3);
        operatorOutput.setEdge(edge);

        RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
                .createRelativeBendpoints();
        ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
                2);
        // ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
        // 2);
        // points.add(new AbsoluteBendpoint( 221, 144));
        // points.add(new AbsoluteBendpoint( 221, 240));
        // points.add(new RelativeBendpoint(221, 144, 123 , 344));
        // points.add(new RelativeBendpoint(221, 144, 344 , 344));
        // points.add(new RelativeBendpoint(221, 144, 344 , 354));
        bendpoints.setPoints(points);
        edge.setBendpoints(bendpoints);
        ViewUtil.insertChildView(containerView, edge, index, persisted);
        edge.setType(Neuro4jVisualIDRegistry
                .getType(OperatorOutput10EditPart.VISUAL_ID));
        edge.setElement(domainElement);
        // initializePreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        if (PropetiesConstants.RELATION_ERROR_NAME
                .equalsIgnoreCase(operatorOutput.getName())) {
            lineRGB = new RGB(255, 0, 0);
        }
        ViewUtil.setStructuralFeatureValue(edge,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));

        FontStyle edgeFontStyle = (FontStyle) edge
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (edgeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            edgeFontStyle.setFontName(fontData.getName());
            edgeFontStyle.setFontHeight(fontData.getHeight());
            edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        Routing routing = Routing.get(prefStore
                .getInt(IPreferenceConstants.PREF_LINE_STYLE));
        if (routing != null) {
            ViewUtil.setStructuralFeatureValue(edge,
                    NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
                    routing);
        }
        Node label6001 = createLabel(edge,
                Neuro4jVisualIDRegistry
                        .getType(OperatorOutputNameEditPart.VISUAL_ID));
        label6001.setLayoutConstraint(NotationFactory.eINSTANCE
                .createLocation());
        Location location6001 = (Location) label6001.getLayoutConstraint();
        location6001.setX(0);
        location6001.setY(40);
        return edge;
    }

    /**
     * @generated
     */
    public Node createEndNode_2005(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry.getType(EndNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold(true);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5002 = createLabel(node,
                Neuro4jVisualIDRegistry.getType(EndNodeNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    public Node createLoopNode_2006(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(LoopNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5006 = createLabel(node,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLabelEditPart.VISUAL_ID));
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createOperatorInput_2013(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(OperatorInputEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        return node;
    }

    /**
     * @generated
     */
    public Node createDecisionNode_2007(EObject domainElement,
            View containerView, int index, boolean persisted,
            PreferencesHint preferencesHint) {
        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(DecisionNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5008 = createLabel(
                node,
                Neuro4jVisualIDRegistry
                        .getType(DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID));
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        createCompartment(
                node,
                Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID),
                false, true, true, true);
        return node;
    }

    /**
     * @generated
     */
    public Node createCallNode_2008(EObject domainElement, View containerView,
            int index, boolean persisted, PreferencesHint preferencesHint) {

        Shape node = NotationFactory.eINSTANCE.createShape();
        node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
        node.setType(Neuro4jVisualIDRegistry
                .getType(CallNodeEditPart.VISUAL_ID));
        ViewUtil.insertChildView(containerView, node, index, persisted);
        node.setElement(domainElement);
        stampShortcut(containerView, node);
        // initializeFromPreferences
        final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
                .getPreferenceStore();

        org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_LINE_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getLineStyle_LineColor(),
                FigureUtilities.RGBToInteger(lineRGB));
        FontStyle nodeFontStyle = (FontStyle) node
                .getStyle(NotationPackage.Literals.FONT_STYLE);
        if (nodeFontStyle != null) {
            FontData fontData = PreferenceConverter.getFontData(prefStore,
                    IPreferenceConstants.PREF_DEFAULT_FONT);
            nodeFontStyle.setFontName(fontData.getName());
            nodeFontStyle.setFontHeight(fontData.getHeight());
            nodeFontStyle.setBold(true);
            nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
            org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
                    .getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
            nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
                    .intValue());
        }
        org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(
                prefStore, IPreferenceConstants.PREF_FILL_COLOR);
        ViewUtil.setStructuralFeatureValue(node,
                NotationPackage.eINSTANCE.getFillStyle_FillColor(),
                FigureUtilities.RGBToInteger(fillRGB));
        Node label5007 = createLabel(
                node,
                Neuro4jVisualIDRegistry
                        .getType(CallNodeDynamicFlowNameFlowNameEditPart.VISUAL_ID));
        return node;
    }

    /**
     * @generated
     */
    private void stampShortcut(View containerView, Node target) {
        if (!NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                .getModelID(containerView))) {
            EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE
                    .createEAnnotation();
            shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
            shortcutAnnotation.getDetails().put("modelID", NetworkEditPart.MODEL_ID); //$NON-NLS-1$
            target.getEAnnotations().add(shortcutAnnotation);
        }
    }

    /**
     * @generated
     */
    private Node createLabel(View owner, String hint) {
        DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
        rv.setType(hint);
        ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
        return rv;
    }

    /**
     * @generated
     */
    private Node createCompartment(View owner, String hint,
            boolean canCollapse, boolean hasTitle, boolean canSort,
            boolean canFilter) {
        // SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
        // rv.setShowTitle(showTitle);
        // rv.setCollapsed(isCollapsed);
        Node rv;
        if (canCollapse) {
            rv = NotationFactory.eINSTANCE.createBasicCompartment();
        } else {
            rv = NotationFactory.eINSTANCE.createDecorationNode();
        }
        if (hasTitle) {
            TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
            ts.setShowTitle(true);
            rv.getStyles().add(ts);
        }
        if (canSort) {
            rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
        }
        if (canFilter) {
            rv.getStyles()
                    .add(NotationFactory.eINSTANCE.createFilteringStyle());
        }
        rv.setType(hint);
        ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
        return rv;
    }

    /**
     * @generated
     */
    private EObject getSemanticElement(IAdaptable semanticAdapter) {
        if (semanticAdapter == null) {
            return null;
        }
        EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
        if (eObject != null) {
            return EMFCoreUtil.resolve(
                    TransactionUtil.getEditingDomain(eObject), eObject);
        }
        return null;
    }

    /**
     * @generated
     */
    private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
        if (semanticAdapter == null) {
            return null;
        }
        return (IElementType) semanticAdapter.getAdapter(IElementType.class);
    }
}
