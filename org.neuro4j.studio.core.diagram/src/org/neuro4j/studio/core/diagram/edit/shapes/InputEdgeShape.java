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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.draw2d.figures.GeoShapeDiamondFigure;
import org.eclipse.swt.graphics.Color;

public class InputEdgeShape extends GeoShapeDiamondFigure {

    // public InputEdgeShape()
    // {
    // super();
    // //setBounds(rect);
    // }

    //
    // protected void fillShape(Graphics graphics) {
    // graphics.fillOval(getOptimizedBound());
    // }

    public InputEdgeShape(int width, int height, int spacing) {
        super(width, height, spacing);

    }

    @Override
    public void setBackgroundColor(Color bg) {
        // TODO Auto-generated method stub
        super.setBackgroundColor(ColorConstants.yellow);
    }

    // /**
    // * Outlines the ellipse.
    // *
    // * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
    // */
    // protected void outlineShape(Graphics graphics) {
    // graphics.drawOval(getOptimizedBound());
    // }

    // private Rectangle getOptimizedBound() {
    // float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
    // int inset1 = (int) Math.floor(lineInset);
    // int inset2 = (int) Math.ceil(lineInset);
    // Rectangle bounds = getBounds();
    // bounds.x += 85;
    // // bounds.y += 10;
    // bounds.width = 20;
    // bounds.height = 20;
    // Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
    // //r.x += 85;
    // //r.y += inset1;
    // // r.width -= inset1 + inset2;
    // // r.height -= inset1 + inset2;
    // return r;
    // }

}
