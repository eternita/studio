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
package org.neuro4j.studio.core.diagram.edit.shapes.anchors;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.neuro4j.studio.core.diagram.edit.shapes.FixedConnectionAnchor;

public class DefaultSizeNodeFigureWithFixedAnchors extends
        DefaultSizeNodeFigure {

    protected HashMap<String, FixedConnectionAnchor> anchors = new HashMap<String, FixedConnectionAnchor>();

    public DefaultSizeNodeFigureWithFixedAnchors(Dimension defSize, HashMap<String, PrecisionPoint> anchorLocations) {
        this(defSize.width, defSize.height, anchorLocations);
    }

    public DefaultSizeNodeFigureWithFixedAnchors(int width, int height, HashMap<String, PrecisionPoint> anchorLocations) {
        super(width, height);
        if (anchorLocations.size() == 0)
            throw new IllegalArgumentException("At least one fixed anchor must be specified");
        Iterator<String> terminals = anchorLocations.keySet().iterator();
        while (terminals.hasNext()) {
            String terminal = terminals.next();
            PrecisionPoint anchorLocation = anchorLocations.get(terminal);
            anchors.put(terminal, new FixedConnectionAnchor(this, anchorLocation));
        }
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
        return findNearestAnchorFrom(p);
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
        return findNearestAnchorFrom(p);
    }

    @Override
    public ConnectionAnchor getConnectionAnchor(String terminal) {
        return anchors.get(terminal);
    }

    @Override
    public String getConnectionAnchorTerminal(ConnectionAnchor c) {
        String selectedTerminal = null;
        Iterator<String> terminals = anchors.keySet().iterator();
        while (terminals.hasNext() && selectedTerminal == null) {
            String terminal = terminals.next();
            FixedConnectionAnchor anchor = anchors.get(terminal);
            if (anchor == c) {
                selectedTerminal = terminal;
            }
        }
        return selectedTerminal;
    }

    private ConnectionAnchor findNearestAnchorFrom(Point point) {
        ConnectionAnchor result = null;
        if (point == null || anchors.size() == 1) {
            result = anchors.values().iterator().next();
        }
        else {
            double minDistance = Double.MAX_VALUE;
            String nearestTerminal = null;
            Iterator<String> terminals = anchors.keySet().iterator();
            while (terminals.hasNext()) {
                String terminal = terminals.next();
                FixedConnectionAnchor anchor = anchors.get(terminal);
                Point anchorPosition = anchor.getLocation();
                double distance = point.getDistance(anchorPosition);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTerminal = terminal;
                }
            }
            result = anchors.get(nearestTerminal);
        }
        return result;
    }
    
    @Override
    public Rectangle getHandleBounds() {
        Rectangle original = super.getHandleBounds();
        return new Rectangle(original.x,original.y,50,70);
    }
    
    protected ConnectionAnchor getDefaultSourceAnchor()
    {
        return anchors.get("NORTH");
    }

}