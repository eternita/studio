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
import org.eclipse.draw2d.FlowLayout;
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

    // private GeoShapeDiamondFigure fFigureEndNodeMainInput;

    /**
     * @generated
     */
    public ViewNodeFigure() {
        super(DEFAULT_IMAGE, 0);
        FlowLayout layoutThis = new FlowLayout();
        layoutThis.setStretchMinorAxis(false);
        layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

        layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
        layoutThis.setMajorSpacing(5);
        layoutThis.setMinorSpacing(5);
        layoutThis.setHorizontal(true);

        this.setLayoutManager(layoutThis);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {
        // this.getSize()

        // fFigureEndNodeMainInput = new InputEdgeShape(10,10,10);
        //
        // fFigureEndNodeMainInput.setSize(10, 10);
        // // Rectangle bounds = fFigureEndNodeMainInput.getBounds();
        // // bounds.y += 30;
        // // fFigureEndNodeMainInput.setBounds(bounds);
        // fFigureEndNodeMainInput.setBackgroundColor(ColorConstants.yellow);
        // // fFigureEndNodeMainInput.setLayoutManager(new XYLayout());
        // this.add(fFigureEndNodeMainInput);
        fFigureViewNodeViewNameFigure = new WrappingLabel();

        fFigureViewNodeViewNameFigure.setText("<..>");

        this.add(fFigureViewNodeViewNameFigure, BorderLayout.BOTTOM);

    }

    /**
     * @generated
     */
    public WrappingLabel getFigureViewNodeViewNameFigure() {
        return fFigureViewNodeViewNameFigure;
    }

}
