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
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.shapes.FixedConnectionAnchor;

public class NorthEastSouthFixedAnchors extends DefaultSizeNodeFigureWithFixedAnchors {
    static final HashMap<String, PrecisionPoint> anchorLocations = new HashMap<String, PrecisionPoint>();

    protected ActionNode action;

    static {

        anchorLocations.put("NORTH", new PrecisionPoint(0.5d, 0));
        anchorLocations.put("SOUTH", new PrecisionPoint(0.5d, 1d));
        anchorLocations.put("EAST", new PrecisionPoint(1d, 0.5d));
    }

    public NorthEastSouthFixedAnchors(Dimension defSize,
            HashMap<String, PrecisionPoint> anchorLocations) {
        super(defSize, anchorLocations);

    }

    public NorthEastSouthFixedAnchors(int i, int j, ActionNode action) {
        super(i, j, anchorLocations);
        this.action = action;
    }

    public ConnectionAnchor getSourceConnectionAnchorAt(Point p, String connectionName) {

        if (p == null)
        {
            if (connectionName.equals("FALSE") || connectionName.equals("ERROR"))
            {
                return anchors.get("EAST");
            }
            if (connectionName.equals("TRUE") || connectionName.equals("NEXT"))
            {
                return anchors.get("SOUTH");
            }
        }

        int x = getBounds().x;
        int y = getBounds().y;
        int dx = p.x - x;
        int dy = p.y - y;
        if (dx > getBounds().width / 2)
        { // EAST
            if (dy > getBounds().height / 4 && dy < (getBounds().height - getBounds().height / 4))
            {
                return getConnectionAnchor("EAST");
            } else if (dy > (getBounds().height - 7)) {
                return getConnectionAnchor("SOUTH");
            }
        } else
        {
            if (dy > getBounds().height / 2)
                return getConnectionAnchor("SOUTH");

        }
        // System.out.println(p);
        return getConnectionAnchor("SOUTH");

        // String terminal = getNextFreeTerminal(connectionName);
        // return getConnectionAnchor(terminal);

    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
        return findNearestAnchorFrom(p, "NORTH");
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

    private ConnectionAnchor findNearestAnchorFrom(Point point, String string) {

        return getConnectionAnchor(string);

    }

    public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
        return getSourceConnectionAnchorAt(p, null);
    }

    // public String getNextFreeTerminal(String connectionName)
    // {
    // return action.getFreeOutputTerminal(connectionName);
    // }

}
