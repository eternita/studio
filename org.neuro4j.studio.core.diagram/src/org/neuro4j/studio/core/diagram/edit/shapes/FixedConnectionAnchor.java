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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class FixedConnectionAnchor extends AbstractConnectionAnchor {

    private double xOffset;
    private double yOffset;
    private String type;

    public FixedConnectionAnchor(IFigure owner, PrecisionPoint offset) {
        this(owner, offset.preciseX, offset.preciseY);
    }

    public FixedConnectionAnchor(IFigure owner, double xOffset, double yOffset) {
        super(owner);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    @Override
    public Point getLocation(Point point) {
        return getLocation();
    }

    public Point getLocation() {
        Rectangle r = getOwner().getBounds();
        Point p = new PrecisionPoint(r.x + r.width * xOffset, r.y + r.height * yOffset);
        getOwner().translateToAbsolute(p);
        return p;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}