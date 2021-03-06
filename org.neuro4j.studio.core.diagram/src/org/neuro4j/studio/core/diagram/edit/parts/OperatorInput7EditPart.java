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
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.diagram.edit.policies.OperatorInput7ItemSemanticEditPolicy;

/**
 * @generated
 */
public class OperatorInput7EditPart extends ConnectionNodeEditPart implements
        ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4009;

    /**
     * @generated
     */
    public OperatorInput7EditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new OperatorInput7ItemSemanticEditPolicy());
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
        return new ActionNodeOutputFigure();
    }

    /**
     * @generated
     */
    public ActionNodeOutputFigure getPrimaryShape() {
        return (ActionNodeOutputFigure) getFigure();
    }

    /**
     * @generated
     */
    public class ActionNodeOutputFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        private WrappingLabel fFigureOutputOperationNodeName;

        /**
         * @generated
         */
        public ActionNodeOutputFigure() {

            createContents();
            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureOutputOperationNodeName = new WrappingLabel();

            fFigureOutputOperationNodeName.setText("");

            this.add(fFigureOutputOperationNodeName);

        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            return df;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureOutputOperationNodeName() {
            return fFigureOutputOperationNodeName;
        }

    }

}
