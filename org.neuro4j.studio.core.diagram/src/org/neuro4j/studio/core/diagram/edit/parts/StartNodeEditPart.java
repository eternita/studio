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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.neuro4j.studio.core.diagram.edit.policies.MyGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.StartNodeItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.edit.shapes.BaseImageFigure;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.DefaultSizeNodeFigureWithFixedAnchors;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class StartNodeEditPart extends NodeBaseEditPart {

    private static final Color bgColor = ColorConstants.white;

    /**
     * @generated
     */
    public static final int VISUAL_ID = 2004;

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
    public StartNodeEditPart(View view) {
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
                new StartNodeItemSemanticEditPolicy());
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
        // ViewUtil.setStructuralFeatureValue(getPrimaryView(),
        // NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
        return primaryShape = new org.neuro4j.studio.core.diagram.edit.shapes.StartNodeFigure();
    }

    /**
     * @generated NOT
     */
    public org.neuro4j.studio.core.diagram.edit.shapes.StartNodeFigure getPrimaryShape() {
        return (org.neuro4j.studio.core.diagram.edit.shapes.StartNodeFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof StartNodeNameEditPart) {
            WrappingLabel l = getPrimaryShape()
                    .getFigureStartNodeNameLabel();

            ((StartNodeNameEditPart) childEditPart).setLabel(l);
            return true;
        }
        if (childEditPart instanceof StartNodeStartNodeMainOutputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureStartNodeMainOutput();

            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
            pane.add(((StartNodeStartNodeMainOutputCompartmentEditPart) childEditPart)
                    .getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof StartNodeNameEditPart) {
            return true;
        }
        if (childEditPart instanceof StartNodeStartNodeMainOutputCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureStartNodeMainOutput();
            pane.remove(((StartNodeStartNodeMainOutputCompartmentEditPart) childEditPart)
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
        if (editPart instanceof StartNodeStartNodeMainOutputCompartmentEditPart) {
            return getPrimaryShape().getFigureStartNodeMainOutput();
        }
        return getContentPane();
    }

    /**
     * @generated NOT
     */
    protected NodeFigure createNodePlate() {
        // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 53);
        HashMap<String, PrecisionPoint> anchorLocations = new HashMap<String, PrecisionPoint>();
        // The anchor's location is a little bit on the right in order to be sure
        // that the edges will be horizontally oriented
        anchorLocations.put("SOUTH", new PrecisionPoint(0.5d, 1d));
        DefaultSizeNodeFigureWithFixedAnchors result = new DefaultSizeNodeFigureWithFixedAnchors(80, 60, anchorLocations);
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

        figure.setLayoutManager(new BorderLayout());
        IFigure shape = createNodeShape();
        WrappingLabel label = ((org.neuro4j.studio.core.diagram.edit.shapes.StartNodeFigure) primaryShape)
                .getFigureStartNodeNameLabel();

        org.eclipse.draw2d.Panel panel = new org.eclipse.draw2d.Panel();
        panel.setLayoutManager(new FlowLayout(true));
        // panel.setSize(40, 50);
        panel.add(label, FlowLayout.ALIGN_CENTER);
        // panel.setBackgroundColor(ColorConstants.red);
        panel.setVisible(true);

        addDebugFigure(panel);
        registerStopFigure((BaseImageFigure) primaryShape);

        label.setTextJustification(PositionConstants.CENTER);
        label.setTextAlignment(PositionConstants.RIGHT);
        figure.add(panel, BorderLayout.TOP);
        figure.add(shape, BorderLayout.BOTTOM);

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
            // layout.setSpacing(5);
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

    @Override
    protected void setFont(FontData fontData) {
        fontData.setStyle(SWT.BOLD);
        super.setFont(fontData);
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
                .getType(StartNodeNameEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public List<IElementType> getMARelTypesOnSource() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        // types.add(Neuro4jElementTypes.OperatorInput_4009);
        // types.add(Neuro4jElementTypes.OperatorOutput_4008);
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
        if (targetEditPart instanceof LoopNodeEditPart) {
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
        if (targetEditPart instanceof org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart) {
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
        // types.add(Neuro4jElementTypes.OperatorOutput_4008);
        return types;
        // return null;
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
            // types.add(Neuro4jElementTypes.StartNode_2004);
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
            if (type == Neuro4jElementTypes.OperatorOutput_3013) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * @generated
     */
    public class StartNodeFigure extends RectangleFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureStartNodeTypeFigure;
        /**
         * @generated
         */
        private Ellipse fFigureStartNodeMainOutput;
        /**
         * @generated
         */
        private WrappingLabel fFigureStartNodeNameLabel;

        /**
         * @generated
         */
        public StartNodeFigure() {

            BorderLayout layoutThis = new BorderLayout();
            this.setLayoutManager(layoutThis);

            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureStartNodeTypeFigure = new WrappingLabel();

            fFigureStartNodeTypeFigure.setText("<...>");

            this.add(fFigureStartNodeTypeFigure);

            fFigureStartNodeMainOutput = new Ellipse();

            fFigureStartNodeMainOutput.setLineWidth(0);
            fFigureStartNodeMainOutput.setLineStyle(Graphics.LINE_DOT);

            this.add(fFigureStartNodeMainOutput, BorderLayout.CENTER);

            fFigureStartNodeNameLabel = new WrappingLabel();

            fFigureStartNodeNameLabel.setText("Start");

            this.add(fFigureStartNodeNameLabel);

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureStartNodeTypeFigure() {
            return fFigureStartNodeTypeFigure;
        }

        /**
         * @generated
         */
        public Ellipse getFigureStartNodeMainOutput() {
            return fFigureStartNodeMainOutput;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureStartNodeNameLabel() {
            return fFigureStartNodeNameLabel;
        }

    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(
            ConnectionEditPart connEditPart) {
        // TODO Auto-generated method stub
        ConnectionAnchor ca = super.getSourceConnectionAnchor(connEditPart);

        return ca;
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(
            ConnectionEditPart connEditPart) {
        // TODO Auto-generated method stub
        ConnectionAnchor ca = super.getTargetConnectionAnchor(connEditPart);
        return ca;
    }

    /**
     * @generated
     */
    // public class StartNodeFigure extends RectangleFigure {
    //
    // /**
    // * @generated
    // */
    // private WrappingLabel fFigureStartNodeTypeFigure;
    // /**
    // * @generated
    // */
    // private Ellipse fFigureStartNodeMainOutput;
    // /**
    // * @generated
    // */
    // private WrappingLabel fFigureStartNodeNameLabel;
    //
    // /**
    // * @generated
    // */
    // public StartNodeFigure() {
    //
    // BorderLayout layoutThis = new BorderLayout();
    // this.setLayoutManager(layoutThis);
    //
    // createContents();
    // }
    //
    // /**
    // * @generated
    // */
    // private void createContents() {
    //
    // fFigureStartNodeTypeFigure = new WrappingLabel();
    //
    // fFigureStartNodeTypeFigure.setText("<...>");
    //
    // this.add(fFigureStartNodeTypeFigure);
    //
    // fFigureStartNodeMainOutput = new Ellipse();
    //
    // fFigureStartNodeMainOutput.setLineWidth(0);
    // fFigureStartNodeMainOutput.setLineStyle(Graphics.LINE_DOT);
    //
    // this.add(fFigureStartNodeMainOutput, BorderLayout.CENTER);
    //
    // fFigureStartNodeNameLabel = new WrappingLabel();
    //
    // fFigureStartNodeNameLabel.setText("Start");
    //
    // this.add(fFigureStartNodeNameLabel);
    //
    // }
    //
    // /**
    // * @generated
    // */
    // public WrappingLabel getFigureStartNodeTypeFigure() {
    // return fFigureStartNodeTypeFigure;
    // }
    //
    // /**
    // * @generated
    // */
    // public Ellipse getFigureStartNodeMainOutput() {
    // return fFigureStartNodeMainOutput;
    // }
    //
    // /**
    // * @generated
    // */
    // public WrappingLabel getFigureStartNodeNameLabel() {
    // return fFigureStartNodeNameLabel;
    // }
    //
    // }

}
