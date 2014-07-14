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
package org.neuro4j.studio.core.diagram.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.neuro4j.studio.core.diagram.edit.policies.NetworkCanonicalEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.NetworkItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.ext.policy.NeuroXYLayoutEditPolicy;

/**
 * @generated
 */
public class NetworkEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    public static final String MODEL_ID = "Neuro4j"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final int VISUAL_ID = 1000;

    /**
     * @generated
     */
    public NetworkEditPart(View view) {
        super(view);
    }

    protected void createLayers(LayeredPane layeredPane) {

    }

    @Override
    protected IFigure createFigure() {

        IFigure graphics = super.createFigure();
        graphics.setBackgroundColor(ColorConstants.white);
        graphics.setOpaque(true);

        return graphics;
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new NetworkItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new NetworkCanonicalEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(
                        Neuro4jVisualIDRegistry.TYPED_INSTANCE));
        removeEditPolicy(EditPolicy.LAYOUT_ROLE);
        removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new NeuroXYLayoutEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
                createDDLayoutEditPolicy());
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    }

    /**
     * @generated
     */
    /* package-local */static class NodeLabelDragPolicy extends
            NonResizableEditPolicy {

        /**
         * @generated
         */
        @SuppressWarnings("rawtypes")
        protected List createSelectionHandles() {
            MoveHandle h = new MoveHandle((GraphicalEditPart) getHost());
            h.setBorder(null);
            return Collections.singletonList(h);
        }

        /**
         * @generated
         */
        public Command getCommand(Request request) {
            return null;
        }

        /**
         * @generated
         */
        public boolean understandsRequest(Request request) {
            return false;
        }
    }

    /**
     * @generated
     */
    /* package-local */static class LinkLabelDragPolicy extends
            NonResizableLabelEditPolicy {

        /**
         * @generated
         */
        @SuppressWarnings("rawtypes")
        protected List createSelectionHandles() {
            MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
            mh.setBorder(null);
            return Collections.singletonList(mh);
        }
    }

    @Override
    protected void activateEditPolicies() {
        EditPolicyIterator i = getEditPolicyIterator();
        while (i.hasNext()) {
            EditPolicy ep = i.next();
            ep.activate();
        }
    }

    protected DragDropEditPolicy createDDLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy() {

            @Override
            protected Command getDropCommand(ChangeBoundsRequest request) {
                // TODO Auto-generated method stub
                return super.getDropCommand(request);
            }

            @Override
            protected Command getDropElementCommand(EObject element,
                    DropObjectsRequest request) {
                // TODO Auto-generated method stub
                return super.getDropElementCommand(element, request);
            }

        };
        return lep;
    }

    @Override
    public List getPrimaryEditParts() {
        // TODO Auto-generated method stub
        return super.getPrimaryEditParts();
    }

    @Override
    public Command getCommand(Request _request) {
        // TODO Auto-generated method stub
        return super.getCommand(_request);
    }

    @Override
    public void showSourceFeedback(Request request) {
        // TODO Auto-generated method stub
        super.showSourceFeedback(request);
    }

    @Override
    public void showTargetFeedback(Request request) {
        // TODO Auto-generated method stub
        super.showTargetFeedback(request);
    }

    @Override
    public PreferencesHint getDiagramPreferencesHint() {
        // TODO Auto-generated method stub
        return super.getDiagramPreferencesHint();
    }

    @Override
    protected void addSourceConnection(ConnectionEditPart connection, int index) {
        // TODO Auto-generated method stub
        super.addSourceConnection(connection, index);
    }

    @Override
    protected void addTargetConnection(ConnectionEditPart connection, int index) {
        // TODO Auto-generated method stub
        super.addTargetConnection(connection, index);
    }

    public String getPropertySheetLabel() {
        // TODO Auto-generated method stub
        return "Network";
    }

}
