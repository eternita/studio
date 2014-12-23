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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class CallNodeFigure extends BaseImageFigure {

    public static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/CallNode.png").createImage();

    

    
    /**
     * @generated
     */
    private WrappingLabel fFigureCallNodeFlowNameFigure;
    
    private Ellipse input, output; 
    

    /**
     * @generated
     */
    public CallNodeFigure() {
        super(DEFAULT_IMAGE, 0);
        BorderLayout layoutThis = new BorderLayout();

        this.setLayoutManager(layoutThis);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {

        fFigureCallNodeFlowNameFigure = new WrappingLabel();

        fFigureCallNodeFlowNameFigure.setText("<...>");

        this.add(fFigureCallNodeFlowNameFigure);
        
        input = new Ellipse();
        input.setFill(true);
        input.setBackgroundColor(ellipseBGColor);
        input.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        
        
        this.add(input);
        
        output = new Ellipse();
        output.setFill(true);
        output.setBackgroundColor(ellipseBGColor);
        output.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));

    }

    /**
     * @generated
     */
    public WrappingLabel getFigureCallNodeFlowNameFigure() {
        return fFigureCallNodeFlowNameFigure;
    }
    
    public IFigure getFigureCallNodeMainInput() {
        return input;
    }
    
    public IFigure getFigureCallNodeMainOutput() {
        return output;
    }

}