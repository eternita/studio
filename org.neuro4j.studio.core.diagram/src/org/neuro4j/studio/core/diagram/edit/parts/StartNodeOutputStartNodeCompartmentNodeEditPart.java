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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.diagram.edit.policies.StartNodeOutputStartNodeCompartmentNodeItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.part.Messages;

/**
 * @generated
 */
public class StartNodeOutputStartNodeCompartmentNodeEditPart extends
        ListCompartmentEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 7001;

    /**
     * @generated
     */
    public StartNodeOutputStartNodeCompartmentNodeEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected boolean hasModelChildrenChanged(Notification evt) {
        return false;
    }

    /**
     * @generated
     */
    public String getCompartmentName() {
        return Messages.StartNodeOutputStartNodeCompartmentNodeEditPart_title;
    }

    /**
     * @generated NOT
     */
    public IFigure createFigure() {
        ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
                .createFigure();
        result.setTitleVisibility(false);
        // Setup for a XYLayout
        IFigure contentPane = result.getContentPane();
        contentPane.setLayoutManager(new XYLayout());

        // // Delete content pane insets
        // Insets is = contentPane.getInsets();
        // is.top = 0;
        // is.bottom = 10;
        // is.left = 0;
        // is.right = 0;
        //
        // // Setup graphical elements
        // RoundedRectangle roundedRectangle = new RoundedRectangle();
        // roundedRectangle.setBackgroundColor(ColorConstants.blue);
        // contentPane.add(roundedRectangle);

        return result;
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(
                EditPolicyRoles.SEMANTIC_ROLE,
                new StartNodeOutputStartNodeCompartmentNodeItemSemanticEditPolicy());
    }

    /**
     * @generated
     */
    protected void setRatio(Double ratio) {
        if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
            super.setRatio(ratio);
        }
    }

}
