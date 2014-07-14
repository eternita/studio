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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.neuro4j.studio.core.diagram.edit.policies.MyGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.StandardNodeItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

public class StandardNodeEditPart extends JoinNodeEditPart {

    public static final int VISUAL_ID = 2019;
    int type = 0;

    public StandardNodeEditPart(View view) {
        super(view);
    }

    protected IFigure createNodeShape(int type) {
        this.type = type;
        if (type == 1)
        {
            return primaryShape = new org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure(StandardNodeFigure.CIRCLE_IMAGE);
        } else {
            return primaryShape = new org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure();
        }

    }

    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(
                        Neuro4jVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new StandardNodeItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
                new MyGraphicalNodeEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    public org.neuro4j.studio.core.diagram.edit.shapes.JoinNodeFigure getPrimaryShape() {
        return (org.neuro4j.studio.core.diagram.edit.shapes.JoinNodeFigure) primaryShape;
    }

    protected NodeFigure createNodeFigure() {
        StandardNodeImpl node = (StandardNodeImpl) ((ShapeImpl) getModel()).getElement();
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new BorderLayout());
        org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure shape = (org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure) createNodeShape(node.getType());

        WrappingLabel label = ((org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure) primaryShape)
                .getFigureNodeName();
        label.setText(node.getName());

        figure.add(label, BorderLayout.TOP);

        figure.add(shape, BorderLayout.BOTTOM);
        contentPane = setupContentPane(shape);

        return figure;
    }

    protected NodeFigure createNodePlate() {

        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(30, 30);
        return result;
    }

    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == Neuro4jElementTypes.OperatorInput_4009) {

        } else if (relationshipType == Neuro4jElementTypes.OperatorOutput_4008) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
            types.add(Neuro4jElementTypes.StandardNode_2019);

        }
        return types;
    }

    @Override
    protected void refreshVisuals() {
        // TODO Auto-generated method stub
        super.refreshVisuals();
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        // TODO Auto-generated method stub
        super.handleNotificationEvent(notification);
        if (notification.getEventType() == Notification.SET && notification.getFeature() instanceof EAttributeImpl)
        {
            EAttributeImpl att = (EAttributeImpl) notification.getFeature();
            if (att.getName().equals("name"))
            {
                StandardNodeImpl node = (StandardNodeImpl) ((ShapeImpl) getModel()).getElement();
                WrappingLabel label = ((org.neuro4j.studio.core.diagram.edit.shapes.StandardNodeFigure) primaryShape)
                        .getFigureNodeName();
                label.setText(node.getName());
            }

        }
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        if (request instanceof ReconnectRequest) {
            if (((DropRequest) request).getLocation() == null) {
                return getNodeFigure().getTargetConnectionAnchorAt(null);
            }
            Point pt = ((DropRequest) request).getLocation().getCopy();
            return getNodeFigure().getTargetConnectionAnchorAt(pt);
        } else if (request instanceof DropRequest) {
            return getNodeFigure().getTargetConnectionAnchorAt(((DropRequest) request).getLocation());
        }
        return getNodeFigure().getTargetConnectionAnchorAt(null);
    }

    public String getPropertySheetLabel()
    {
        if (type == 1)
        {
            return "Relation";
        } else {
            return "Entity";
        }
    }

}
