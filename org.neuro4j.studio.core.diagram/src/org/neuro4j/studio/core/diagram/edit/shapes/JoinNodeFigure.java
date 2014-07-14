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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

public class JoinNodeFigure extends BaseImageFigure {

    public static final Image DEFAULT_IMAGE = Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID, "icons/images/JoinNode.png").createImage();

    /**
     * @generated
     */
    protected WrappingLabel fFigureJoinNodeName;

    private Ellipse fFigureJoinNodeMainOutput;

    /**
     * @generated
     */
    public JoinNodeFigure() {
        this(DEFAULT_IMAGE);
    }

    public JoinNodeFigure(Image image) {
        super(image, 0);
        createContents();
    }

    /**
     * @generated
     */
    protected void createContents() {

        fFigureJoinNodeName = new WrappingLabel();
        //
        // fFigureJoinNodeName.setText("JoinNode");

        this.add(fFigureJoinNodeName);

        fFigureJoinNodeMainOutput = new OutputEdgeShape();
        // this.add(fFigureJoinNodeName);
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureJoinNodeName() {
        return fFigureJoinNodeName;
    }

    public Ellipse getFigureJoinNodeMainOutput() {
        return fFigureJoinNodeMainOutput;
    }

}