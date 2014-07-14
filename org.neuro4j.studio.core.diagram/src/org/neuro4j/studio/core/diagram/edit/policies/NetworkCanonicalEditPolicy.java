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
package org.neuro4j.studio.core.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
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
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MyCreateConnectionViewRequest;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramUpdater;
import org.neuro4j.studio.core.diagram.part.Neuro4jLinkDescriptor;
import org.neuro4j.studio.core.diagram.part.Neuro4jNodeDescriptor;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;

/**
 * @generated
 */
public class NetworkCanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    protected void refreshOnActivate() {
        // Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
        List<?> c = getHost().getChildren();
        for (int i = 0; i < c.size(); i++) {
            ((EditPart) c.get(i)).activate();
        }
        super.refreshOnActivate();
    }

    /**
     * @generated
     */
    protected EStructuralFeature getFeatureToSynchronize() {
        return Neuro4jPackage.eINSTANCE.getNetwork_RootAction();
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        LinkedList<EObject> result = new LinkedList<EObject>();
        List<Neuro4jNodeDescriptor> childDescriptors = Neuro4jDiagramUpdater
                .getNetwork_1000SemanticChildren(viewObject);
        for (Neuro4jNodeDescriptor d : childDescriptors) {
            result.add(d.getModelElement());
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection<EObject> semanticChildren,
            final View view) {
        return isMyDiagramElement(view)
                && !semanticChildren.contains(view.getElement());
    }

    /**
     * @generated
     */
    private boolean isMyDiagramElement(View view) {
        int visualID = Neuro4jVisualIDRegistry.getVisualID(view);
        switch (visualID) {
            case DecisionNodeEditPart.VISUAL_ID:
            case FollowByRelationNodeEditPart.VISUAL_ID:
            case LoopNodeEditPart.VISUAL_ID:
            case CallNodeEditPart.VISUAL_ID:
            case EndNodeEditPart.VISUAL_ID:
            case StandardNodeEditPart.VISUAL_ID:
            case StandardNodeRelationEditPart.VISUAL_ID:
            case MapperNodeEditPart.VISUAL_ID:
            case OperatorOutputEditPart.VISUAL_ID:
            case LogicNodeEditPart.VISUAL_ID:
            case OperatorInputEditPart.VISUAL_ID:
            case JoinNodeEditPart.VISUAL_ID:
            case StartNodeEditPart.VISUAL_ID:
            case ViewNodeEditPart.VISUAL_ID:
                return true;
        }
        return false;
    }

    /**
     * @generated NOT
     */
    protected void refreshSemantic() {
        if (resolveSemanticElement() == null) {
            return;
        }
        LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
        List<Neuro4jNodeDescriptor> childDescriptors = Neuro4jDiagramUpdater
                .getNetwork_1000SemanticChildren((View) getHost().getModel());
        LinkedList<View> orphaned = new LinkedList<View>();
        // we care to check only views we recognize as ours
        LinkedList<View> knownViewChildren = new LinkedList<View>();
        for (View v : getViewChildren()) {
            if (isMyDiagramElement(v)) {
                knownViewChildren.add(v);
            }
        }
        // alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
        //
        // iteration happens over list of desired semantic elements, trying to find best matching View, while original
        // CEP
        // iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference
        // same EObject, only last one
        // to answer isOrphaned == true will be used for the domain element representation, see
        // #cleanCanonicalSemanticChildren()
        for (Iterator<Neuro4jNodeDescriptor> descriptorsIterator = childDescriptors
                .iterator(); descriptorsIterator.hasNext();) {
            Neuro4jNodeDescriptor next = descriptorsIterator.next();
            String hint = Neuro4jVisualIDRegistry.getType(next.getVisualID());
            LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of
                                                                    // NodeDescriptor
            for (View childView : getViewChildren()) {
                EObject semanticElement = childView.getElement();
                if (next.getModelElement().equals(semanticElement)) {
                    if (hint.equals(childView.getType())) {
                        perfectMatch.add(childView);
                        // actually, can stop iteration over view children here, but
                        // may want to use not the first view but last one as a 'real' match (the way original CEP does
                        // with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
                    }
                }
            }
            if (perfectMatch.size() > 0) {
                descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
                // use only one view (first or last?), keep rest as orphaned for further consideration
                knownViewChildren.remove(perfectMatch.getFirst());
            }
        }
        // those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match
        // to,
        // or those we have potential matches to, and thus need to be recreated, preserving size/location information.
        orphaned.addAll(knownViewChildren);
        //
        ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
                childDescriptors.size());
        for (Neuro4jNodeDescriptor next : childDescriptors) {
            String hint = Neuro4jVisualIDRegistry.getType(next.getVisualID());
            IAdaptable elementAdapter = new CanonicalElementAdapter(
                    next.getModelElement(), hint);
            CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(
                    elementAdapter, Node.class, hint, ViewUtil.APPEND, false,
                    host().getDiagramPreferencesHint());
            viewDescriptors.add(descriptor);
        }

        boolean changed = deleteViews(orphaned.iterator());
        //
        CreateViewRequest request = getCreateViewRequest(viewDescriptors);
        Command cmd = getCreateViewCommand(request);
        if (cmd != null && cmd.canExecute()) {
            SetViewMutabilityCommand.makeMutable(
                    new EObjectAdapter(host().getNotationView())).execute();
            executeCommand(cmd);
            @SuppressWarnings("unchecked")
            List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
            createdViews.addAll(nl);
        }
        if (changed || createdViews.size() > 0) {
            postProcessRefreshSemantic(createdViews);
        }

        Collection<IAdaptable> createdConnectionViews = refreshConnections();

        // if (createdViews.size() > 1) {
        // // perform a layout of the container
        // DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
        // .getEditingDomain(), createdViews, host());
        // executeCommand(new ICommandProxy(layoutCmd));
        // }

        createdViews.addAll(createdConnectionViews);

        makeViewsImmutable(createdViews);
    }

    /**
     * @generated
     */
    private Collection<IAdaptable> refreshConnections() {
        Map<EObject, View> domain2NotationMap = new HashMap<EObject, View>();
        Collection<Neuro4jLinkDescriptor> linkDescriptors = collectAllLinks(
                getDiagram(), domain2NotationMap);
        Collection existingLinks = new LinkedList(getDiagram().getEdges());
        for (Iterator linksIterator = existingLinks.iterator(); linksIterator
                .hasNext();) {
            Edge nextDiagramLink = (Edge) linksIterator.next();
            int diagramLinkVisualID = Neuro4jVisualIDRegistry
                    .getVisualID(nextDiagramLink);
            if (diagramLinkVisualID == -1) {
                if (nextDiagramLink.getSource() != null
                        && nextDiagramLink.getTarget() != null) {
                    linksIterator.remove();
                }
                continue;
            }
            EObject diagramLinkObject = nextDiagramLink.getElement();
            EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
            EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
            for (Iterator<Neuro4jLinkDescriptor> linkDescriptorsIterator = linkDescriptors
                    .iterator(); linkDescriptorsIterator.hasNext();) {
                Neuro4jLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator
                        .next();
                if (diagramLinkObject == nextLinkDescriptor.getModelElement()
                        && diagramLinkSrc == nextLinkDescriptor.getSource()
                        && diagramLinkDst == nextLinkDescriptor
                                .getDestination()
                        && diagramLinkVisualID == nextLinkDescriptor
                                .getVisualID()) {
                    linksIterator.remove();
                    linkDescriptorsIterator.remove();
                    break;
                }
            }
        }
        deleteViews(existingLinks.iterator());
        return createConnections(linkDescriptors, domain2NotationMap);
    }

    /**
     * @generated
     */
    private Collection<Neuro4jLinkDescriptor> collectAllLinks(View view,
            Map<EObject, View> domain2NotationMap) {
        if (!NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                .getModelID(view))) {
            return Collections.emptyList();
        }
        LinkedList<Neuro4jLinkDescriptor> result = new LinkedList<Neuro4jLinkDescriptor>();
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case NetworkEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getNetwork_1000ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case DecisionNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getDecisionNode_2007ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case FollowByRelationNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getFollowByRelationNode_2011ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case LoopNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getLoopNode_2006ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case CallNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getCallNode_2008ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case EndNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getEndNode_2005ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case MapperNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getMapperNode_2010ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutputEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_2016ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case LogicNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getLogicNode_2017ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInputEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_2013ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case JoinNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getJoinNode_2002ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case StandardNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getStandardNode_2002ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case StandardNodeRelationEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getStandardNode_2002ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case StartNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getStartNode_2004ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case ViewNodeEditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getViewNode_2018ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInput2EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_3005ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput2EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3001ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput3EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3002ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInput3EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_3006ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInput4EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_3007ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput4EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3003ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput5EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3004ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInput5EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_3008ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput6EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3010ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput7EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3011ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput8EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3012ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput9EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_3013ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorInput7EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorInput_4009ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
            case OperatorOutput10EditPart.VISUAL_ID: {
                if (!domain2NotationMap.containsKey(view.getElement())) {
                    result.addAll(Neuro4jDiagramUpdater
                            .getOperatorOutput_4008ContainedLinks(view));
                }
                if (!domain2NotationMap.containsKey(view.getElement())
                        || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
                    domain2NotationMap.put(view.getElement(), view);
                }
                break;
            }
        }
        for (Iterator children = view.getChildren().iterator(); children
                .hasNext();) {
            result.addAll(collectAllLinks((View) children.next(),
                    domain2NotationMap));
        }
        for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
            result.addAll(collectAllLinks((View) edges.next(),
                    domain2NotationMap));
        }
        return result;
    }

    /**
     * @generated NOT
     */
    private Collection<IAdaptable> createConnections(
            Collection<Neuro4jLinkDescriptor> linkDescriptors,
            Map<EObject, View> domain2NotationMap) {
        LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
        for (Neuro4jLinkDescriptor nextLinkDescriptor : linkDescriptors) {
            EditPart sourceEditPart = getEditPart(
                    nextLinkDescriptor.getSource(), domain2NotationMap);
            EditPart targetEditPart = getEditPart(
                    nextLinkDescriptor.getDestination(), domain2NotationMap);
            if (sourceEditPart == null || targetEditPart == null) {
                continue;
            }

            OperatorOutputImpl operatorOutputImpl = (OperatorOutputImpl) nextLinkDescriptor.getModelElement();

            CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
                    nextLinkDescriptor.getSemanticAdapter(),
                    Neuro4jVisualIDRegistry.getType(nextLinkDescriptor
                            .getVisualID()), ViewUtil.APPEND, false,
                    ((IGraphicalEditPart) getHost())
                            .getDiagramPreferencesHint());
            CreateConnectionViewRequest ccr = new MyCreateConnectionViewRequest(descriptor, operatorOutputImpl);
            ccr.setTargetEditPart(targetEditPart);
            ccr.setType(RequestConstants.REQ_CONNECTION_START);
            ccr.setSourceEditPart(sourceEditPart);
            sourceEditPart.getCommand(ccr);

            ccr.setType(RequestConstants.REQ_CONNECTION_END);
            Command cmd = targetEditPart.getCommand(ccr);
            if (cmd != null && cmd.canExecute()) {
                executeCommand(cmd);
                IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
                if (viewAdapter != null) {
                    adapters.add(viewAdapter);
                }
            }
        }
        return adapters;
    }

    /**
     * @generated
     */
    private EditPart getEditPart(EObject domainModelElement,
            Map<EObject, View> domain2NotationMap) {
        View view = (View) domain2NotationMap.get(domainModelElement);
        if (view != null) {
            return (EditPart) getHost().getViewer().getEditPartRegistry()
                    .get(view);
        }
        return null;
    }

    /**
     * @generated
     */
    private Diagram getDiagram() {
        return ((View) getHost().getModel()).getDiagram();
    }
}
