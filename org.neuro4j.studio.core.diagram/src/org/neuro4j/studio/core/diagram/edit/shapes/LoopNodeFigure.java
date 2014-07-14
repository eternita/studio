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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class LoopNodeFigure extends BaseImageFigure {

    private static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/LoopNode.png").createImage();

    /**
     * @generated
     */
    private WrappingLabel fFigureLoopNodeIteratorKeyFigure;
    /**
     * @generated
     */
    private WrappingLabel fFigureLoopNodeElementKeyFigure;
    /**
     * @generated
     */
    private Ellipse fFigureLoopNodeLoopInput;
    /**
     * @generated
     */
    private Ellipse fFigureLoopNodeLoopOuptut;
    /**
     * @generated
     */
    private Ellipse fFigureLoopNodeMainInput;
    /**
     * @generated
     */
    private Ellipse fFigureLoopNodeMainOutput;

    /**
     * @generated
     */
    private WrappingLabel fFigureLoopNodeLabel;

    /**
     * @generated
     */
    public LoopNodeFigure() {
        super(DEFAULT_IMAGE, 0);
        BorderLayout layoutThis = new BorderLayout();
        this.setLayoutManager(layoutThis);

        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {

        fFigureLoopNodeIteratorKeyFigure = new WrappingLabel();

        fFigureLoopNodeIteratorKeyFigure.setText("<...>");

        this.add(fFigureLoopNodeIteratorKeyFigure);

        fFigureLoopNodeElementKeyFigure = new WrappingLabel();

        fFigureLoopNodeElementKeyFigure.setText("<...>");

        this.add(fFigureLoopNodeElementKeyFigure);

        fFigureLoopNodeLoopOuptut = new Ellipse();

        // this.add(fFigureLoopNodeLoopOuptut, BorderLayout.CENTER);

        fFigureLoopNodeMainOutput = new Ellipse();

        // this.add(fFigureLoopNodeMainOutput, BorderLayout.CENTER);

        fFigureLoopNodeMainInput = new Ellipse();

        // this.add(fFigureLoopNodeMainInput, BorderLayout.CENTER);

        fFigureLoopNodeLoopInput = new Ellipse();

        // this.add(fFigureLoopNodeLoopInput, BorderLayout.CENTER);

        fFigureLoopNodeLabel = new WrappingLabel();

        fFigureLoopNodeLabel.setText("<Label>");

        this.add(fFigureLoopNodeLabel);

    }

    /**
     * @generated
     */
    public WrappingLabel getFigureLoopNodeIteratorKeyFigure() {
        return fFigureLoopNodeIteratorKeyFigure;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureLoopNodeElementKeyFigure() {
        return fFigureLoopNodeElementKeyFigure;
    }

    /**
     * @generated
     */
    public Ellipse getFigureLoopNodeLoopInput() {
        return fFigureLoopNodeLoopInput;
    }

    /**
     * @generated
     */
    public Ellipse getFigureLoopNodeLoopOuptut() {
        return fFigureLoopNodeLoopOuptut;
    }

    /**
     * @generated
     */
    public Ellipse getFigureLoopNodeMainInput() {
        return fFigureLoopNodeMainInput;
    }

    /**
     * @generated
     */
    public Ellipse getFigureLoopNodeMainOutput() {
        return fFigureLoopNodeMainOutput;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureLoopNodeLabel() {
        return fFigureLoopNodeLabel;
    }

}
