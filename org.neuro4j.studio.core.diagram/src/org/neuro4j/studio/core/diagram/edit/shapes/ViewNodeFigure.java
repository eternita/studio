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
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class ViewNodeFigure extends BaseImageFigure {

    public static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/ViewNode.png").createImage();

    /**
     * @generated
     */
    private WrappingLabel fFigureViewNodeViewNameFigure;

    private Ellipse input;

    /**
     * @generated
     */
    public ViewNodeFigure() {
        super(DEFAULT_IMAGE, 0);
        FlowLayout layoutThis = new FlowLayout();


        this.setLayoutManager(layoutThis);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {
        
        input = new Ellipse();
        input.setFill(true);
        input.setPreferredSize(new Dimension(ELLIPSE_SIZE, ELLIPSE_SIZE));
        input.setBackgroundColor(ellipseBGColor);
        this.add(input);
        
        fFigureViewNodeViewNameFigure = new WrappingLabel();
      

        this.add(fFigureViewNodeViewNameFigure, BorderLayout.BOTTOM);

    }

    /**
     * @generated
     */
    public WrappingLabel getFigureViewNodeViewNameFigure() {
        return fFigureViewNodeViewNameFigure;
    }

    public IFigure getInputEllipse() {
        return input;
    }

}
