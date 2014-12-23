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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.neuro4j.studio.core.diagram.edit.policies.LoopNodeItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.MyGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.shapes.BaseImageFigure;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.DefaultSizeNodeFigureWithFixedAnchors;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MyCreateConnectionViewRequest;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.NorthEastSouthFixedAnchors;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.NorthEastSouthWestFixedAnchors;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;
import org.neuro4j.studio.core.impl.LoopNodeImpl;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;

/**
 * @generated
 */
public class LoopNodeEditPart extends NodeBaseEditPart {

    Color bgColor = ColorConstants.white;

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2006;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    protected IFigure primaryShape;

    /**
     * @generated
     */
    public LoopNodeEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(
                        Neuro4jVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new LoopNodeItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
                new MyGraphicalNodeEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                EditPolicy result = child
                        .getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new org.neuro4j.studio.core.diagram.edit.shapes.LoopNodeFigure();
    }

    /**
     * @generated NOT
     */
    public org.neuro4j.studio.core.diagram.edit.shapes.LoopNodeFigure getPrimaryShape() {
        return (org.neuro4j.studio.core.diagram.edit.shapes.LoopNodeFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof LoopNodeLabelEditPart) {
            ((LoopNodeLabelEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureLoopNodeLabel());
            return true;
        }
        IFigure pane = getNodeFigure();
        if (childEditPart instanceof LoopNodeLoopNodeLoopInputCompartmentEditPart) {
           
            IFigure f1 = getPrimaryShape().getFigureLoopNodeLoopInput();
            pane.add(f1, new Rectangle(3, 31, 8, 8));
            return true;

        }
        if (childEditPart instanceof LoopNodeLoopNodeMainInputCompartmentEditPart) {
        //    IFigure pane = getPrimaryShape().getFigureLoopNodeMainInput();
            IFigure f1 = getPrimaryShape().getFigureLoopNodeMainInput();
            pane.add(f1, new Rectangle(31, 3, 8, 8));
            return true;
        }
        if (childEditPart instanceof LoopNodeLogicNodeMainOutputCompartmentEditPart) {

            IFigure f1 = getPrimaryShape().getFigureLoopNodeLoopOuptut();
            pane.add(f1, new Rectangle(60, 31, 8, 8));
            return true;
        }
        if (childEditPart instanceof LoopNodeLoopNodeLoopOutputCompartmentEditPart) {

            IFigure f1 = getPrimaryShape().getFigureLoopNodeMainOutput();
            pane.add(f1, new Rectangle(31, 60, 8, 8));
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof LoopNodeLabelEditPart) {
            return true;
        }
        if (childEditPart instanceof LoopNodeLoopNodeLoopInputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureLoopNodeLoopInput();
            pane.remove(((LoopNodeLoopNodeLoopInputCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        if (childEditPart instanceof LoopNodeLoopNodeMainInputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureLoopNodeMainInput();
            pane.remove(((LoopNodeLoopNodeMainInputCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        if (childEditPart instanceof LoopNodeLogicNodeMainOutputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureLoopNodeLoopOuptut();
            pane.remove(((LoopNodeLogicNodeMainOutputCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        if (childEditPart instanceof LoopNodeLoopNodeLoopOutputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureLoopNodeMainOutput();
            pane.remove(((LoopNodeLoopNodeLoopOutputCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof LoopNodeLoopNodeLoopInputCompartmentEditPart) {
            return getPrimaryShape().getFigureLoopNodeLoopInput();
        }
        if (editPart instanceof LoopNodeLoopNodeMainInputCompartmentEditPart) {
            return getPrimaryShape().getFigureLoopNodeMainInput();
        }
        if (editPart instanceof LoopNodeLogicNodeMainOutputCompartmentEditPart) {
            return getPrimaryShape().getFigureLoopNodeLoopOuptut();
        }
        if (editPart instanceof LoopNodeLoopNodeLoopOutputCompartmentEditPart) {
            return getPrimaryShape().getFigureLoopNodeMainOutput();
        }
        return getContentPane();
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        if (request instanceof ReconnectRequest) {
            if (((DropRequest) request).getLocation() == null) {
                return getNodeFigure().getSourceConnectionAnchorAt(null);
            }
            Point pt = ((DropRequest) request).getLocation().getCopy();
            ConnectionEditPart ConnectionEditPart = ((ReconnectRequest) request).getConnectionEditPart();
            ConnectorImpl op = (ConnectorImpl) ConnectionEditPart.getModel();
            return ((NorthEastSouthFixedAnchors) getNodeFigure()).getSourceConnectionAnchorAt(pt, ((OperatorOutputImpl) op.getElement()).getName());
        }
        else if (request instanceof MyCreateConnectionViewRequest) {
            MyCreateConnectionViewRequest myCreateConnectionViewRequest = (MyCreateConnectionViewRequest) request;
            return ((NorthEastSouthWestFixedAnchors) getNodeFigure()).getSourceConnectionAnchorAt(
                    myCreateConnectionViewRequest.getLocation(), myCreateConnectionViewRequest.getOperator().getName());
        } else if (request instanceof DropRequest) {
            return (getNodeFigure()).getSourceConnectionAnchorAt(
                    ((DropRequest) request).getLocation());
        }
        return getNodeFigure().getSourceConnectionAnchorAt(null);
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        // super.getTargetConnectionAnchor(request)

        if (request instanceof ReconnectRequest) {
            if (((DropRequest) request).getLocation() == null) {
                return getNodeFigure().getTargetConnectionAnchorAt(null);
            }
            // return getNodeFigure().getTargetConnectionAnchorAt(null);
            Point pt = ((DropRequest) request).getLocation().getCopy();
            ConnectionEditPart ConnectionEditPart = ((ReconnectRequest) request).getConnectionEditPart();
            ConnectorImpl op = (ConnectorImpl) ConnectionEditPart.getModel();
            return ((NorthEastSouthWestFixedAnchors) getNodeFigure()).getTargetConnectionAnchorAt(pt, ((OperatorOutputImpl) op.getElement()), ((MyCreateConnectionViewRequest) request).getSourceEditPart());
        }
        else if (request instanceof MyCreateConnectionViewRequest) {
            MyCreateConnectionViewRequest myCreateConnectionViewRequest = (MyCreateConnectionViewRequest) request;
            return ((NorthEastSouthWestFixedAnchors) getNodeFigure()).getTargetConnectionAnchorAt(
                    myCreateConnectionViewRequest.getLocation(), myCreateConnectionViewRequest.getOperator(), ((MyCreateConnectionViewRequest) request).getSourceEditPart());
        } else if (request instanceof DropRequest) {
            return (getNodeFigure()).getTargetConnectionAnchorAt(
                    ((DropRequest) request).getLocation());
        }

        return getNodeFigure().getTargetConnectionAnchorAt(null);
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        ShapeImpl shape = (ShapeImpl) getModel();
        LoopNodeImpl node = (LoopNodeImpl) shape.getElement();

        HashMap<String, PrecisionPoint> locations = new HashMap<String, PrecisionPoint>(4);

        locations.put("WEST", new PrecisionPoint(0, 0.5d));
        locations.put("NORTH", new PrecisionPoint(0.17d, 0));
        locations.put("SOUTH", new PrecisionPoint(0.17d, 1d));
        locations.put("EAST", new PrecisionPoint(0.35d, 0.5d));

        DefaultSizeNodeFigureWithFixedAnchors result = new NorthEastSouthWestFixedAnchors(70, 70, node, locations);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new XYLayout());
        org.neuro4j.studio.core.diagram.edit.shapes.LoopNodeFigure shape = (org.neuro4j.studio.core.diagram.edit.shapes.LoopNodeFigure) createNodeShape();
        org.eclipse.draw2d.Panel panel = new org.eclipse.draw2d.Panel();
        panel.setLayoutManager(new FlowLayout(true));

        addDebugFigure(panel);

        registerStopFigure((BaseImageFigure) primaryShape);

        figure.add(panel, new Rectangle(5, 5, 5, 5));
        figure.add(shape, new Rectangle(10, 10, 50, 50));

        figure.add(shape.getFigureLoopNodeLabel(), new Rectangle(55, 7, 150, 25));

        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape
     *        instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated NOT
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(bgColor);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(Neuro4jVisualIDRegistry
                .getType(LoopNodeLabelEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(Neuro4jElementTypes.OperatorInput_4009);
        types.add(Neuro4jElementTypes.OperatorOutput_4008);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSourceAndTarget(
            IGraphicalEditPart targetEditPart) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (targetEditPart instanceof OperatorOutputEditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput2EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput3EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput4EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput5EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput6EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput7EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput8EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof OperatorOutput9EditPart) {
            types.add(Neuro4jElementTypes.OperatorInput_4009);
        }
        if (targetEditPart instanceof DecisionNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof FollowByRelationNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof CallNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof EndNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof MapperNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof LogicNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof JoinNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof StartNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        if (targetEditPart instanceof ViewNodeEditPart) {
            types.add(Neuro4jElementTypes.OperatorOutput_4008);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == Neuro4jElementTypes.OperatorInput_4009) {
            types.add(Neuro4jElementTypes.OperatorOutput_2016);
            types.add(Neuro4jElementTypes.OperatorOutput_3001);
            types.add(Neuro4jElementTypes.OperatorOutput_3002);
            types.add(Neuro4jElementTypes.OperatorOutput_3003);
            types.add(Neuro4jElementTypes.OperatorOutput_3004);
            types.add(Neuro4jElementTypes.OperatorOutput_3010);
            types.add(Neuro4jElementTypes.OperatorOutput_3011);
            types.add(Neuro4jElementTypes.OperatorOutput_3012);
            types.add(Neuro4jElementTypes.OperatorOutput_3013);
        } else if (relationshipType == Neuro4jElementTypes.OperatorOutput_4008) {
            types.add(Neuro4jElementTypes.DecisionNode_2007);
            types.add(Neuro4jElementTypes.FollowByRelationNode_2011);
            types.add(Neuro4jElementTypes.LoopNode_2006);
            types.add(Neuro4jElementTypes.CallNode_2008);
            types.add(Neuro4jElementTypes.MapperNode_2010);
            types.add(Neuro4jElementTypes.LogicNode_2017);
            types.add(Neuro4jElementTypes.JoinNode_2002);
            // types.add(Neuro4jElementTypes.StartNode_2004);
            types.add(Neuro4jElementTypes.ViewNode_2018);
            types.add(Neuro4jElementTypes.EndNode_2005);
        }
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(Neuro4jElementTypes.OperatorOutput_4008);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == Neuro4jElementTypes.OperatorOutput_4008) {
            types.add(Neuro4jElementTypes.DecisionNode_2007);
            types.add(Neuro4jElementTypes.FollowByRelationNode_2011);
            types.add(Neuro4jElementTypes.LoopNode_2006);
            types.add(Neuro4jElementTypes.CallNode_2008);
            types.add(Neuro4jElementTypes.EndNode_2005);
            types.add(Neuro4jElementTypes.MapperNode_2010);
            types.add(Neuro4jElementTypes.LogicNode_2017);
            types.add(Neuro4jElementTypes.JoinNode_2002);
            types.add(Neuro4jElementTypes.StartNode_2004);
            types.add(Neuro4jElementTypes.ViewNode_2018);
        }
        return types;
    }

    /**
     * @generated
     */
    public EditPart getTargetEditPart(Request request) {
        if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
                    .getViewAndElementDescriptor()
                    .getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter
                    .getAdapter(IElementType.class);
            if (type == Neuro4jElementTypes.OperatorInput_3006) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID));
            }
            if (type == Neuro4jElementTypes.OperatorInput_3007) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID));
            }
            if (type == Neuro4jElementTypes.OperatorOutput_3004) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID));
            }
            if (type == Neuro4jElementTypes.OperatorOutput_3003) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    public void refreshToolTip() {
        getPrimaryShape().getToolTip();

    }

    /**
     * @generated
     */
    public class LoopNodeFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureLoopNodeIteratorKeyFigure;
        /**
         * @generated
         */
        private WrappingLabel fFigureLoopNodeElementKeyFigure;
        /**
         * @generated
         */
        private Ellipse fFigureLoopNodeLoopInput;
        /**
         * @generated
         */
        private Ellipse fFigureLoopNodeLoopOuptut;
        /**
         * @generated
         */
        private Ellipse fFigureLoopNodeMainInput;
        /**
         * @generated
         */
        private Ellipse fFigureLoopNodeMainOutput;
        /**
         * @generated
         */
        private WrappingLabel fFigureLoopNodeLabel;

        /**
         * @generated
         */
        public LoopNodeFigure() {

            BorderLayout layoutThis = new BorderLayout();
            this.setLayoutManager(layoutThis);

            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureLoopNodeIteratorKeyFigure = new WrappingLabel();

            fFigureLoopNodeIteratorKeyFigure.setText("<...>");

            this.add(fFigureLoopNodeIteratorKeyFigure);

            fFigureLoopNodeElementKeyFigure = new WrappingLabel();

            fFigureLoopNodeElementKeyFigure.setText("<...>");

            this.add(fFigureLoopNodeElementKeyFigure);

            fFigureLoopNodeLoopOuptut = new Ellipse();

            this.add(fFigureLoopNodeLoopOuptut, BorderLayout.CENTER);

            fFigureLoopNodeMainOutput = new Ellipse();

            this.add(fFigureLoopNodeMainOutput, BorderLayout.CENTER);

            fFigureLoopNodeMainInput = new Ellipse();

            this.add(fFigureLoopNodeMainInput, BorderLayout.CENTER);

            fFigureLoopNodeLoopInput = new Ellipse();

            this.add(fFigureLoopNodeLoopInput, BorderLayout.CENTER);

            fFigureLoopNodeLabel = new WrappingLabel();

            fFigureLoopNodeLabel.setText("");

            this.add(fFigureLoopNodeLabel);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureLoopNodeIteratorKeyFigure() {
            return fFigureLoopNodeIteratorKeyFigure;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureLoopNodeElementKeyFigure() {
            return fFigureLoopNodeElementKeyFigure;
        }

        /**
         * @generated
         */
        public Ellipse getFigureLoopNodeLoopInput() {
            return fFigureLoopNodeLoopInput;
        }

        /**
         * @generated
         */
        public Ellipse getFigureLoopNodeLoopOuptut() {
            return fFigureLoopNodeLoopOuptut;
        }

        /**
         * @generated
         */
        public Ellipse getFigureLoopNodeMainInput() {
            return fFigureLoopNodeMainInput;
        }

        /**
         * @generated
         */
        public Ellipse getFigureLoopNodeMainOutput() {
            return fFigureLoopNodeMainOutput;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureLoopNodeLabel() {
            return fFigureLoopNodeLabel;
        }

    }

}
