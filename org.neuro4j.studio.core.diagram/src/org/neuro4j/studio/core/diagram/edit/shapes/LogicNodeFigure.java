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
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.util.EList;
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
    
    private Ellipse input, output, errorOutput;; 

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



        this.add(fFigureLogicNodeClassNameFigure);

        fFigureLogicNodeNameFigure = new WrappingLabel();



        this.add(fFigureLogicNodeNameFigure, BorderLayout.LEFT);
        // this.add(fFigureLogicNodeMainInput, BorderLayout.CENTER);
        
        input = new Ellipse();
        input.setFill(true);
        input.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        input.setBackgroundColor(ellipseBGColor);
        
        this.add(input);
        
        output = new Ellipse();
        output.setFill(true);
        output.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        output.setBackgroundColor(ellipseBGColor);
        
        this.add(output);
        
        errorOutput = new Ellipse();
        errorOutput.setFill(true);
        errorOutput.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        errorOutput.setBackgroundColor(ellipseBGColor);
        
        this.add(errorOutput);

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

    public IFigure getFigureLogicNodeMainInput() {
        return input;
    }
    
    public IFigure getFigureLogicNodeMainOutput() {
        return output;
    }
    
    public IFigure getFigureLogicNodeErrorOutput() {
        return errorOutput;
    }

}