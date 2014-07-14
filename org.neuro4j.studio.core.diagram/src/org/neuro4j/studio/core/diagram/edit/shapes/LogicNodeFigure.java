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
package org.neuro4j.studio.core.diagram.edit.shapes;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;

/**
 * @generated
 */
public class LogicNodeFigure extends BaseImageFigure {

    /**
     * @generated
     */
    private WrappingLabel fFigureLogicNodeClassNameFigure;

    /**
     * @generated
     */
    private WrappingLabel fFigureLogicNodeNameFigure;

    /**
     * @generated
     */
    public LogicNodeFigure()
    {
        super(LogicNodeEditPart.DEFAULT_IMAGE, 0);
        BorderLayout layoutThis = new BorderLayout();
        this.setLayoutManager(layoutThis);

        createContents();
        // ViewUtil.setStructuralFeatureValue(getPrimaryView(),
        // NotationPackage.eINSTANCE.getFontStyle_Bold(), true);
    }

    public LogicNodeFigure(ActionNode element) {
        this();
        String toolTip = element.buildToolTip();
        if (toolTip != null) {
            setToolTip(new Label(toolTip));
        }

    }

    /**
     * @generated
     */
    private void createContents() {

        fFigureLogicNodeClassNameFigure = new WrappingLabel();
        // fFigureLogicNodeClassNameFigure.setFont(new Fon)

        fFigureLogicNodeClassNameFigure.setText("<...>");

        this.add(fFigureLogicNodeClassNameFigure);

        fFigureLogicNodeNameFigure = new WrappingLabel();

        fFigureLogicNodeNameFigure.setText("<1..>");

        this.add(fFigureLogicNodeNameFigure, BorderLayout.LEFT);
        // this.add(fFigureLogicNodeMainInput, BorderLayout.CENTER);

    }

    /**
     * @generated
     */
    public WrappingLabel getFigureLogicNodeClassNameFigure() {
        return fFigureLogicNodeClassNameFigure;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureLogicNodeNameFigure() {
        return fFigureLogicNodeNameFigure;
    }

}