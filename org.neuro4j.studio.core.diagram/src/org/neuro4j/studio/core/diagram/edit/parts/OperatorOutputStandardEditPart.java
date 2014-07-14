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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.diagram.edit.policies.MyConnectionGraphicalNodeEditPolicy;

/**
 * @generated
 */
public class OperatorOutputStandardEditPart extends OperatorOutput10EditPart {

    // /**
    // * @generated
    // */
    // public static final int VISUAL_ID = 4008;
    //
    // /**
    // * @generated
    // */
    public OperatorOutputStandardEditPart(View view) {
        super(view);
    }

    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
                new MyConnectionGraphicalNodeEditPolicy());

    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated
     */

    protected Connection createConnectionFigure() {
        return new OperatorOutputSourceFigure();
    }

    @Override
    protected ConnectionAnchor getTargetConnectionAnchor() {
        // TODO Auto-generated method stub
        return super.getTargetConnectionAnchor();
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        Point center = getFigure().getBounds().getCenter();
        getFigure().translateToAbsolute(center);
        Point pt = ((DropRequest) request).getLocation() == null ?
                center : new Point(((DropRequest) request).getLocation());
        if (request instanceof CreateRequest) {
            getFigure().translateToRelative(pt);
        }
        return ((IAnchorableFigure) getFigure()).getTargetConnectionAnchorAt(pt);
    }

    /**
     * @generated NOT
     */
    public class OperatorOutputSourceFigure extends OperatorOutput10EditPart.OperatorOutputSourceFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureOperatorOutputSourceNameLabel;

        /**
         * @generated
         */
        public OperatorOutputSourceFigure() {

            createContents();

        }

        /**
         * @generated
         */
        private void createContents() {

            ViewUtil.setStructuralFeatureValue(getEdge(), NotationPackage.eINSTANCE.getRoutingStyle_Routing(), null);

            fFigureOperatorOutputSourceNameLabel = new WrappingLabel();

            fFigureOperatorOutputSourceNameLabel.setText("123");

            this.add(fFigureOperatorOutputSourceNameLabel);

        }

        protected RotatableDecoration createTargetDecoration() {
            return null;
        }

    }

}
