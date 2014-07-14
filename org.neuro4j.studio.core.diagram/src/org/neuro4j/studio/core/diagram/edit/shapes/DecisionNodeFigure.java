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

        fFigureDecisionNodeFalseOutput = new Ellipse();

        fFigureDecisionNodeMainInput = new Ellipse();

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

    //
    //
    // /** The points of the triangle. */
    // protected PointList triangle = new PointList(3);
    //
    // protected void fillShape(Graphics g) {
    // g.fillPolygon(triangle);
    // }
    //
    // /**
    // * @see Shape#outlineShape(Graphics)
    // */
    // protected void outlineShape(Graphics g) {
    // g.drawPolygon(triangle);
    // }
    //
    // /**
    // * @see Orientable#setDirection(int)
    // */
    // public void setDirection(int value) {
    // if ((value & (NORTH | SOUTH)) != 0)
    // orientation = VERTICAL;
    // else
    // orientation = HORIZONTAL;
    // direction = value;
    // revalidate();
    // repaint();
    // }
    //
    // /**
    // * @see Orientable#setOrientation(int)
    // */
    // public void setOrientation(int value) {
    // if (orientation == VERTICAL && value == HORIZONTAL) {
    // if (direction == NORTH)
    // setDirection(WEST);
    // else
    // setDirection(EAST);
    // }
    // if (orientation == HORIZONTAL && value == VERTICAL) {
    // if (direction == WEST)
    // setDirection(NORTH);
    // else
    // setDirection(SOUTH);
    // }
    // }
    // /**
    // * @see IFigure#validate()
    // */
    // public void validate() {
    // super.validate();
    // Rectangle r = new Rectangle();
    // r.setBounds(getBounds());
    // r.crop(getInsets());
    // r.resize(-1, -1);
    // int size;
    // switch (direction & (NORTH | SOUTH)) {
    // case 0: // East or west.
    // size = Math.min(r.height / 2, r.width);
    // r.x += (r.width - size) / 2;
    // break;
    // default: // North or south
    // size = Math.min(r.height, r.width / 2);
    // r.y += (r.height - size) / 2;
    // break;
    // }
    //
    // size = Math.max(size, 1); // Size cannot be negative
    //
    // Point head, p2, p3;
    //
    // switch (direction) {
    // case NORTH:
    // head = new Point(r.x + r.width / 2, r.y);
    // p2 = new Point(head.x - size, head.y + size);
    // p3 = new Point(head.x + size, head.y + size);
    // break;
    // case SOUTH:
    // head = new Point(r.x + r.width / 2, r.y + size);
    // p2 = new Point(head.x - size, head.y - size);
    // p3 = new Point(head.x + size, head.y - size);
    // break;
    // case WEST:
    // head = new Point(r.x, r.y + r.height / 2);
    // p2 = new Point(head.x + size, head.y - size);
    // p3 = new Point(head.x + size, head.y + size);
    // break;
    // default:
    // head = new Point(r.x + size, r.y + r.height / 2);
    // p2 = new Point(head.x - size, head.y - size);
    // p3 = new Point(head.x - size, head.y + size);
    //
    // }
    // triangle.removeAllPoints();
    // triangle.addPoint(head);
    // triangle.addPoint(p2);
    // triangle.addPoint(p3);
    // }

}