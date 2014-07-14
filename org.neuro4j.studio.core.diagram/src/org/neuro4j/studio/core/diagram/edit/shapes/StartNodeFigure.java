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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

@SuppressWarnings("restriction")
public class StartNodeFigure extends BaseImageFigure {

    public static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/StartNode.png").createImage();

    /**
     * @generated
     */
    private WrappingLabel fFigureStartNodeTypeFigure;
    /**
     * @generated
     */
    private Ellipse fFigureStartNodeMainOutput;

    /**
     * @generated
     */
    private WrappingLabel fFigureStartNodeNameLabel;

    /**
     * @generated
     */
    public StartNodeFigure() {
        super(DEFAULT_IMAGE, 2);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {

        fFigureStartNodeNameLabel = new WrappingLabel();

        fFigureStartNodeNameLabel.setText("StartNode");

        fFigureStartNodeMainOutput = new OutputEdgeShape();
        fFigureStartNodeNameLabel.setTextAlignment(PositionConstants.RIGHT);

        // add(getDebugFigure());
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureStartNodeTypeFigure() {
        return fFigureStartNodeTypeFigure;
    }

    /**
     * @generated
     */
    public Ellipse getFigureStartNodeMainOutput() {
        return fFigureStartNodeMainOutput;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureStartNodeNameLabel() {
        return fFigureStartNodeNameLabel;
    }

}