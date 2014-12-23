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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

public class DecisionNodeFigure extends BaseImageFigure {

    public static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/DecisionNode.png").createImage();


    
    /**
     * @generated
     */
    private Ellipse fFigureDecisionNodeTrueOutput;
    /**
     * @generated
     */
    private Ellipse fFigureDecisionNodeFalseOutput;
    /**
     * @generated
     */
    private Ellipse fFigureDecisionNodeMainInput;
    /**
     * @generated
     */
    private WrappingLabel fFigureDecisionNodeLabel;

    /**
     * @generated
     */
    public DecisionNodeFigure() {

        super(DEFAULT_IMAGE, 0);
        BorderLayout layoutThis = new BorderLayout();

        this.setLayoutManager(layoutThis);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {

        fFigureDecisionNodeTrueOutput = new Ellipse();
        fFigureDecisionNodeTrueOutput.setFill(true);
        fFigureDecisionNodeTrueOutput.setBackgroundColor(ellipseBGColor);
        fFigureDecisionNodeTrueOutput.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        
        
        fFigureDecisionNodeFalseOutput = new Ellipse();
        fFigureDecisionNodeFalseOutput.setFill(true);
        fFigureDecisionNodeFalseOutput.setBackgroundColor(ellipseBGColor);
        fFigureDecisionNodeFalseOutput.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));

        fFigureDecisionNodeMainInput = new Ellipse();
        fFigureDecisionNodeMainInput.setFill(true);
        fFigureDecisionNodeMainInput.setBackgroundColor(ellipseBGColor);
        fFigureDecisionNodeMainInput.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        
        
        fFigureDecisionNodeLabel = new WrappingLabel();

        fFigureDecisionNodeLabel.setText("");

    }

    /**
     * @generated
     */
    /**
     * @generated
     */
    public Ellipse getFigureDecisionNodeTrueOutput() {
        return fFigureDecisionNodeTrueOutput;
    }

    /**
     * @generated
     */
    public Ellipse getFigureDecisionNodeFalseOutput() {
        return fFigureDecisionNodeFalseOutput;
    }

    /**
     * @generated
     */
    public Ellipse getFigureDecisionNodeMainInput() {
        return fFigureDecisionNodeMainInput;
    }

    public WrappingLabel getFigureDecisionNodeLabel() {
        return fFigureDecisionNodeLabel;
    }


}