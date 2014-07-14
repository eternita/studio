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
package org.neuro4j.studio.core.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
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
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeStartNodeMainOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Messages;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;

/**
 * @generated
 */
public class Neuro4jNavigatorContentProvider implements ICommonContentProvider {

    /**
     * @generated
     */
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /**
     * @generated
     */
    private Viewer myViewer;

    /**
     * @generated
     */
    private AdapterFactoryEditingDomain myEditingDomain;

    /**
     * @generated
     */
    private WorkspaceSynchronizer myWorkspaceSynchronizer;

    /**
     * @generated
     */
    private Runnable myViewerRefreshRunnable;

    /**
     * @generated
     */
    @SuppressWarnings({ "unchecked", "serial", "rawtypes" })
    public Neuro4jNavigatorContentProvider() {
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
                .createEditingDomain();
        myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
        myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
            public Object get(Object key) {
                if (!containsKey(key)) {
                    put(key, Boolean.TRUE);
                }
                return super.get(key);
            }
        });
        myViewerRefreshRunnable = new Runnable() {
            public void run() {
                if (myViewer != null) {
                    myViewer.refresh();
                }
            }
        };
        myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
                new WorkspaceSynchronizer.Delegate() {
                    public void dispose() {
                    }

                    public boolean handleResourceChanged(final Resource resource) {
                        unloadAllResources();
                        asyncRefresh();
                        return true;
                    }

                    public boolean handleResourceDeleted(Resource resource) {
                        unloadAllResources();
                        asyncRefresh();
                        return true;
                    }

                    public boolean handleResourceMoved(Resource resource,
                            final URI newURI) {
                        unloadAllResources();
                        asyncRefresh();
                        return true;
                    }
                });
    }

    /**
     * @generated
     */
    public void dispose() {
        myWorkspaceSynchronizer.dispose();
        myWorkspaceSynchronizer = null;
        myViewerRefreshRunnable = null;
        myViewer = null;
        unloadAllResources();
        ((TransactionalEditingDomain) myEditingDomain).dispose();
        myEditingDomain = null;
    }

    /**
     * @generated
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        myViewer = viewer;
    }

    /**
     * @generated
     */
    void unloadAllResources() {
        for (Resource nextResource : myEditingDomain.getResourceSet()
                .getResources()) {
            nextResource.unload();
        }
    }

    /**
     * @generated
     */
    void asyncRefresh() {
        if (myViewer != null && !myViewer.getControl().isDisposed()) {
            myViewer.getControl().getDisplay()
                    .asyncExec(myViewerRefreshRunnable);
        }
    }

    /**
     * @generated
     */
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    /**
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * @generated
     */
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof IFile) {
            IFile file = (IFile) parentElement;
            URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
                    .toString(), true);
            Resource resource = myEditingDomain.getResourceSet().getResource(
                    fileURI, true);
            ArrayList<Neuro4jNavigatorItem> result = new ArrayList<Neuro4jNavigatorItem>();
            ArrayList<View> topViews = new ArrayList<View>(resource
                    .getContents().size());
            for (EObject o : resource.getContents()) {
                if (o instanceof View) {
                    topViews.add((View) o);
                }
            }
            return result.toArray();
        }

        if (parentElement instanceof Neuro4jNavigatorGroup) {
            Neuro4jNavigatorGroup group = (Neuro4jNavigatorGroup) parentElement;
            return group.getChildren();
        }

        if (parentElement instanceof Neuro4jNavigatorItem) {
            Neuro4jNavigatorItem navigatorItem = (Neuro4jNavigatorItem) parentElement;
            if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
                return EMPTY_ARRAY;
            }
            return getViewChildren(navigatorItem.getView(), parentElement);
        }

        return EMPTY_ARRAY;
    }

    /**
     * @generated
     */
    private Object[] getViewChildren(View view, Object parentElement) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {

            case FollowByRelationNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_FollowByRelationNode_2011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_FollowByRelationNode_2011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case LogicNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_LogicNode_2017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_LogicNode_2017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeLogicNodeMainInputEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput5EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput6EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput7EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case NetworkEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Diagram sv = (Diagram) view;
                Neuro4jNavigatorGroup links = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_Network_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(FollowByRelationNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(CallNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(EndNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(MapperNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutputEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInputEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(StartNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(ViewNodeEditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                links.addChildren(createNavigatorItems(connectedViews, links, false));
                connectedViews = getDiagramLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                links.addChildren(createNavigatorItems(connectedViews, links, false));
                if (!links.isEmpty()) {
                    result.add(links);
                }
                return result.toArray();
            }

            case JoinNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_JoinNode_2002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_JoinNode_2002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput8EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case StartNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_StartNode_2004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_StartNode_2004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput9EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput7EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput2EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case ViewNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_ViewNode_2018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_ViewNode_2018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput6EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput5EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case MapperNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_MapperNode_2010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_MapperNode_2010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutputEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_2016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case CallNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_CallNode_2008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_CallNode_2008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case LoopNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_LoopNode_2006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_LoopNode_2006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput3EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput4EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput4EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput5EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorInput7EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Edge sv = (Edge) view;
                Neuro4jNavigatorGroup target = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorInput_4009_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup source = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorInput_4009_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutputEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput2EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput3EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput4EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput5EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput6EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput7EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput8EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput9EditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(FollowByRelationNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(CallNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(EndNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(MapperNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(StartNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(ViewNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                if (!target.isEmpty()) {
                    result.add(target);
                }
                if (!source.isEmpty()) {
                    result.add(source);
                }
                return result.toArray();
            }

            case OperatorOutput10EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Edge sv = (Edge) view;
                Neuro4jNavigatorGroup target = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_4008_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup source = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_4008_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(FollowByRelationNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(CallNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(EndNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(MapperNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(StartNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksTargetByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(ViewNodeEditPart.VISUAL_ID));
                target.addChildren(createNavigatorItems(connectedViews, target,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(FollowByRelationNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(CallNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(EndNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(MapperNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(LogicNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(StartNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                connectedViews = getLinksSourceByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry.getType(ViewNodeEditPart.VISUAL_ID));
                source.addChildren(createNavigatorItems(connectedViews, source,
                        true));
                if (!target.isEmpty()) {
                    result.add(target);
                }
                if (!source.isEmpty()) {
                    result.add(source);
                }
                return result.toArray();
            }

            case OperatorOutput9EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput3EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput8EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case OperatorOutput4EditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_OperatorOutput_3003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case EndNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_EndNode_2005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_EndNode_2005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }

            case DecisionNodeEditPart.VISUAL_ID: {
                LinkedList<Neuro4jAbstractNavigatorItem> result = new LinkedList<Neuro4jAbstractNavigatorItem>();
                Node sv = (Node) view;
                Neuro4jNavigatorGroup outgoinglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_DecisionNode_2007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Neuro4jNavigatorGroup incominglinks = new Neuro4jNavigatorGroup(
                        Messages.NavigatorGroupName_DecisionNode_2007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
                Collection<View> connectedViews;
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput2EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput2EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getChildrenByType(
                        Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID));
                connectedViews = getChildrenByType(connectedViews,
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput3EditPart.VISUAL_ID));
                result.addAll(createNavigatorItems(connectedViews, parentElement,
                        false));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorInput7EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                connectedViews = getIncomingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                incominglinks.addChildren(createNavigatorItems(connectedViews,
                        incominglinks, true));
                connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
                        Neuro4jVisualIDRegistry
                                .getType(OperatorOutput10EditPart.VISUAL_ID));
                outgoinglinks.addChildren(createNavigatorItems(connectedViews,
                        outgoinglinks, true));
                if (!outgoinglinks.isEmpty()) {
                    result.add(outgoinglinks);
                }
                if (!incominglinks.isEmpty()) {
                    result.add(incominglinks);
                }
                return result.toArray();
            }
        }
        return EMPTY_ARRAY;
    }

    /**
     * @generated
     */
    private Collection<View> getLinksSourceByType(Collection<Edge> edges,
            String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (Edge nextEdge : edges) {
            View nextEdgeSource = nextEdge.getSource();
            if (type.equals(nextEdgeSource.getType())
                    && isOwnView(nextEdgeSource)) {
                result.add(nextEdgeSource);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getLinksTargetByType(Collection<Edge> edges,
            String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (Edge nextEdge : edges) {
            View nextEdgeTarget = nextEdge.getTarget();
            if (type.equals(nextEdgeTarget.getType())
                    && isOwnView(nextEdgeTarget)) {
                result.add(nextEdgeTarget);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getOutgoingLinksByType(
            Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getIncomingLinksByType(
            Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getChildrenByType(
            Collection<? extends View> nodes, String type) {
        LinkedList<View> result = new LinkedList<View>();
        for (View nextNode : nodes) {
            result.addAll(selectViewsByType(nextNode.getChildren(), type));
        }
        return result;
    }

    /**
     * @generated
     */
    private Collection<View> getDiagramLinksByType(
            Collection<Diagram> diagrams, String type) {
        ArrayList<View> result = new ArrayList<View>();
        for (Diagram nextDiagram : diagrams) {
            result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
        }
        return result;
    }

    // TODO refactor as static method
    /**
     * @generated
     */
    private Collection<View> selectViewsByType(Collection<View> views,
            String type) {
        ArrayList<View> result = new ArrayList<View>();
        for (View nextView : views) {
            if (type.equals(nextView.getType()) && isOwnView(nextView)) {
                result.add(nextView);
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private boolean isOwnView(View view) {
        return NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                .getModelID(view));
    }

    /**
     * @generated
     */
    private Collection<Neuro4jNavigatorItem> createNavigatorItems(
            Collection<View> views, Object parent, boolean isLeafs) {
        ArrayList<Neuro4jNavigatorItem> result = new ArrayList<Neuro4jNavigatorItem>(
                views.size());
        for (View nextView : views) {
            result.add(new Neuro4jNavigatorItem(nextView, parent, isLeafs));
        }
        return result;
    }

    /**
     * @generated
     */
    public Object getParent(Object element) {
        if (element instanceof Neuro4jAbstractNavigatorItem) {
            Neuro4jAbstractNavigatorItem abstractNavigatorItem = (Neuro4jAbstractNavigatorItem) element;
            return abstractNavigatorItem.getParent();
        }
        return null;
    }

    /**
     * @generated
     */
    public boolean hasChildren(Object element) {
        return element instanceof IFile || getChildren(element).length > 0;
    }

}
