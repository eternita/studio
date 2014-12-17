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
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.policies.MyConnectionGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.OperatorOutput10ItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MyPolylineConnection;

/**
 * @generated
 */
public class OperatorOutput10EditPart extends ConnectionNodeEditPart implements
        ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4008;

    /**
     * @generated
     */
    public OperatorOutput10EditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new OperatorOutput10ItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
                new MyConnectionGraphicalNodeEditPolicy());

    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof OperatorOutputNameEditPart) {
            ((OperatorOutputNameEditPart) childEditPart)
                    .setLabel(getPrimaryShape()
                            .getFigureOperatorOutputSourceNameLabel());
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
        super.addChildVisual(childEditPart, index);
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof OperatorOutputNameEditPart) {
            return true;
        }
        return false;
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
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated
     */

    protected List getModelSourceConnections() {
        return ViewUtil.getSourceConnections(getEdge());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
     */
    protected List getModelTargetConnections() {
        return ViewUtil.getTargetConnections(getEdge());
    }

    protected ConnectionAnchor getSourceConnectionAnchor() {
        if (getSource() != null && getSource() instanceof NodeEditPart) {
            NodeEditPart editPart = (NodeEditPart) getSource();
            return editPart.getSourceConnectionAnchor(this);
        }
        return super.getSourceConnectionAnchor();
    }

    protected Connection createConnectionFigure() {
        return new OperatorOutputSourceFigure();
    }

    /**
     * @generated
     */
    public OperatorOutputSourceFigure getPrimaryShape() {
        return (OperatorOutputSourceFigure) getFigure();
    }

    protected void refreshBendpoints() {
        RelativeBendpoints bendpoints = (RelativeBendpoints) getEdge()
                .getBendpoints();
        List modelConstraint = bendpoints.getPoints();
        List figureConstraint = new ArrayList();
        for (int i = 0; i < modelConstraint.size(); i++) {
            org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint wbp = (org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint) modelConstraint
                    .get(i);
            RelativeBendpoint rbp = new RelativeBendpoint(getConnectionFigure());
            rbp.setRelativeDimensions(new Dimension(wbp.getSourceX(), wbp
                    .getSourceY()), new Dimension(wbp.getTargetX(), wbp
                    .getTargetY()));
            if (modelConstraint.size() == 1) {
                rbp.setWeight(0.5f);
            } else {
                rbp.setWeight(i / ((float) modelConstraint.size() - 1));
            }
            figureConstraint.add(rbp);
        }
        getConnectionFigure().setRoutingConstraint(figureConstraint);
    }

    /**
     * @generated NOT
     */
    public class OperatorOutputSourceFigure extends MyPolylineConnection implements org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureOperatorOutputSourceNameLabel;

        /**
         * @generated
         */
        public OperatorOutputSourceFigure() {

            createContents();

            setTargetDecoration(createTargetDecoration());

        }

        /**
         * @generated
         */
        private void createContents() {
            // ViewUtil.setStructuralFeatureValue(getEdge(),
            // Routing r = new Routing(tolerance, elementGuid, elementGuid);
            // NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
            OperatorOutput operatorOutput  = (OperatorOutput)getEdge().getElement();
            
            ViewUtil.setStructuralFeatureValue(getEdge(), NotationPackage.eINSTANCE.getRoutingStyle_Routing(), operatorOutput.getRouting());

            fFigureOperatorOutputSourceNameLabel = new WrappingLabel();

            fFigureOperatorOutputSourceNameLabel.setText("");

            this.add(fFigureOperatorOutputSourceNameLabel);

        }

        public OperatorOutput10EditPart getEditPart()
        {
            return OperatorOutput10EditPart.this;
        }

        /**
         * @generated NOT
         */
        protected RotatableDecoration createTargetDecoration() {
            return new PolylineDecoration();
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureOperatorOutputSourceNameLabel() {
            return fFigureOperatorOutputSourceNameLabel;
        }

        @Override
        public ConnectionAnchor getConnectionAnchor(String terminal) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getConnectionAnchorTerminal(ConnectionAnchor c) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
            Point temp = p.getCopy();
            translateToRelative(temp);
            PrecisionPoint pt = BaseSlidableAnchor.getAnchorRelativeLocation(temp, getBounds());
            return new SlidableAnchor(this, pt);
        }

    }

}
