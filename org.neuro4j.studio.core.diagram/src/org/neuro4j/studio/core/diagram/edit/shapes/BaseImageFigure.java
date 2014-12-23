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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class BaseImageFigure extends ImageFigure {

    
    static final int ELLIPSE_SIZE = 8;
    
    Color borderColor = ColorConstants.white;
    public static final Color ellipseBGColor = new Color(ColorConstants.white.getDevice(), 161, 196, 224);

    public BaseImageFigure(Image defaultImage, int i) {
        super(defaultImage, 2);
    }

    @Override
    protected void paintFigure(Graphics graphics) {
        paintBorder(graphics);
        super.paintFigure(graphics);
    }

    public void paintBorder(Graphics graphics) {

        graphics.setForegroundColor(borderColor);
        graphics.setLineWidth(1);

        graphics.drawRectangle(this.getBounds().x,
                this.getBounds().y,
                this.getBounds().width - 1,
                this.getBounds().height - 1);

        Rectangle rect = getBounds();

        graphics.drawLine(rect.x,
                this.getBounds().y + rect.height,
                this.getBounds().x + rect.width - 1,
                this.getBounds().y + rect.height);


    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

}
