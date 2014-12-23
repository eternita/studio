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
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.policies.DecisionNodeItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.MyGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.shapes.BaseImageFigure;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.DefaultSizeNodeFigureWithFixedAnchors;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MyCreateConnectionViewRequest;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.NorthEastSouthFixedAnchors;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;
import org.neuro4j.studio.core.impl.DecisionNodeImpl;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;

/**
 * @generated
 */
public class DecisionNodeEditPart extends NodeBaseEditPart {

    Color bgColor = ColorConstants.white;
    /**
     * @generated
     */
    public static final int VISUAL_ID = 2007;

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
    public DecisionNodeEditPart(View view) {
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
                new DecisionNodeItemSemanticEditPolicy());
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
        return primaryShape = new org.neuro4j.studio.core.diagram.edit.shapes.DecisionNodeFigure();
    }

    /**
     * @generated NOT
     */
    public org.neuro4j.studio.core.diagram.edit.shapes.DecisionNodeFigure getPrimaryShape() {
        return (org.neuro4j.studio.core.diagram.edit.shapes.DecisionNodeFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DecisionNodeCompKeyOperatorDecisionEditPart) {
            ((DecisionNodeCompKeyOperatorDecisionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getFigureDecisionNodeLabel());
            return true;
        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeMainInputEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeMainInput();
//            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
//            pane.add(((DecisionNodeDecisionNodeMainInputEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeFalseOutput();
//            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
//            pane.add(((DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeTrueOutput();
//            setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
//            pane.add(((DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
        if (childEditPart instanceof DecisionNodeDecisionNodeMainInputEditPart) {
            IFigure pane = getNodeFigure();

            IFigure f1 = getPrimaryShape().getFigureDecisionNodeMainInput();
            pane.add(f1, new Rectangle(30, 3, 8, 8));
            return true;
        }

        if (childEditPart instanceof DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) {
            IFigure pane = getNodeFigure();

            IFigure f1 = getPrimaryShape().getFigureDecisionNodeTrueOutput();
            pane.add(f1, new Rectangle(30, 60, 8, 8));
            return true;
        }
        if (childEditPart instanceof DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) {
            IFigure pane = getNodeFigure();

            IFigure f1 = getPrimaryShape().getFigureDecisionNodeFalseOutput();
            pane.add(f1, new Rectangle(59, 31, 8, 8));
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DecisionNodeCompKeyOperatorDecisionEditPart) {
            return true;
        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeMainInputEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeMainInput();
//            pane.remove(((DecisionNodeDecisionNodeMainInputEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeFalseOutput();
//            pane.remove(((DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
//        if (childEditPart instanceof DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) {
//            IFigure pane = getPrimaryShape().getFigureDecisionNodeTrueOutput();
//            pane.remove(((DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) childEditPart)
//                    .getFigure());
//            return true;
//        }
//        

        
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
        if (editPart instanceof DecisionNodeDecisionNodeMainInputEditPart) {
            return getPrimaryShape().getFigureDecisionNodeMainInput();
        }
        if (editPart instanceof DecisionNodeDecisionNodeFalseOutputCompartmentEditPart) {
            return getPrimaryShape().getFigureDecisionNodeFalseOutput();
        }
        if (editPart instanceof DecisionNodeDecisionNodeTrueOutputCompartmentEditPart) {
            return getPrimaryShape().getFigureDecisionNodeTrueOutput();
        }
        return getContentPane();
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        ShapeImpl shape = (ShapeImpl) getModel();
        DecisionNodeImpl node = (DecisionNodeImpl) shape.getElement();
        HashMap<String, PrecisionPoint> anchorLocations = new HashMap<String, PrecisionPoint>();

        anchorLocations.put("NORTH", new PrecisionPoint(0.155d, 0));
        anchorLocations.put("SOUTH", new PrecisionPoint(0.155d, 1d));
        anchorLocations.put("EAST", new PrecisionPoint(0.31d, 0.5d));
        DefaultSizeNodeFigureWithFixedAnchors result = new NorthEastSouthFixedAnchors(70, 70, node, anchorLocations);
        return result;
    }

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
            return ((NorthEastSouthFixedAnchors) getNodeFigure()).getSourceConnectionAnchorAt(
                    myCreateConnectionViewRequest.getLocation(), myCreateConnectionViewRequest.getOperator().getName());
        } else if (request instanceof DropRequest) {
            return (getNodeFigure()).getSourceConnectionAnchorAt(
                    ((DropRequest) request).getLocation());
        }
        return getNodeFigure().getSourceConnectionAnchorAt(null);
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
        org.neuro4j.studio.core.diagram.edit.shapes.DecisionNodeFigure shape = (org.neuro4j.studio.core.diagram.edit.shapes.DecisionNodeFigure) createNodeShape();

        org.eclipse.draw2d.Panel panel = new org.eclipse.draw2d.Panel();
        panel.setLayoutManager(new FlowLayout(true));


        addDebugFigure(panel);

        registerStopFigure((BaseImageFigure) primaryShape);

        figure.add(panel, new Rectangle(5, 5, 5, 5));
        figure.add(shape, new Rectangle(9, 10, 50, 50));

        
        figure.add(shape.getFigureDecisionNodeLabel(), new Rectangle(65,6, 150, 25));
        
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
                .getType(DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID));
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
        if (targetEditPart instanceof org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart) {
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
            if (type == Neuro4jElementTypes.OperatorInput_3005) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID));
            }
            if (type == Neuro4jElementTypes.OperatorOutput_3001) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID));
            }
            if (type == Neuro4jElementTypes.OperatorOutput_3002) {
                return getChildBySemanticHint(Neuro4jVisualIDRegistry
                        .getType(DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    // /**
    // * @generated
    // */
    // public class DecisionNodeFigure extends RectangleFigure {
    //
    // /**
    // * @generated
    // */
    // private Ellipse fFigureDecisionNodeTrueOutput;
    // /**
    // * @generated
    // */
    // private Ellipse fFigureDecisionNodeFalseOutput;
    // /**
    // * @generated
    // */
    // private Ellipse fFigureDecisionNodeMainInput;
    //
    // /**
    // * @generated
    // */
    // private WrappingLabel fFigureDecisionNodeLabel;
    //
    // /**
    // * @generated
    // */
    // public DecisionNodeFigure() {
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
    // fFigureDecisionNodeTrueOutput = new Ellipse();
    //
    // this.add(fFigureDecisionNodeTrueOutput, BorderLayout.CENTER);
    //
    // fFigureDecisionNodeFalseOutput = new Ellipse();
    //
    // this.add(fFigureDecisionNodeFalseOutput, BorderLayout.CENTER);
    //
    // fFigureDecisionNodeMainInput = new Ellipse();
    //
    // this.add(fFigureDecisionNodeMainInput, BorderLayout.CENTER);
    //
    // fFigureDecisionNodeLabel = new WrappingLabel();
    //
    // fFigureDecisionNodeLabel.setText("");
    //
    // this.add(fFigureDecisionNodeLabel);
    //
    // }
    //
    // /**
    // * @generated
    // */
    // public Ellipse getFigureDecisionNodeTrueOutput() {
    // return fFigureDecisionNodeTrueOutput;
    // }
    //
    // /**
    // * @generated
    // */
    // public Ellipse getFigureDecisionNodeFalseOutput() {
    // return fFigureDecisionNodeFalseOutput;
    // }
    //
    // /**
    // * @generated
    // */
    // public Ellipse getFigureDecisionNodeMainInput() {
    // return fFigureDecisionNodeMainInput;
    // }
    //
    // /**
    // * @generated
    // */
    // public WrappingLabel getFigureDecisionNodeLabel() {
    // return fFigureDecisionNodeLabel;
    // }
    //
    // }

}
