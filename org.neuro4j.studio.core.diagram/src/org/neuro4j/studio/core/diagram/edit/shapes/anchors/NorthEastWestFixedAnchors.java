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
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.shapes.FixedConnectionAnchor;

/**
 * For Join node
 * 
 * @author pavlikdm
 * 
 */
public class NorthEastWestFixedAnchors extends NorthEastSouthFixedAnchors {



    public NorthEastWestFixedAnchors(int i, int j, HashMap<String, PrecisionPoint> anchorLocations) {
        super(i, j, null, anchorLocations);
    }

    public ConnectionAnchor getSourceConnectionAnchorAt(Point p, String connectionName) {
        if (p == null && connectionName == null)
        {
           return  getDefaultSourceAnchor();
        }
        double minDistance = Double.MAX_VALUE;
        String nearestTerminal = null;

        for (String terminal : new String[] { "NORTH", "WEST", "EAST", "SOUTH" }) {

            FixedConnectionAnchor anchor = anchors.get(terminal);
            Point anchorPosition = anchor.getLocation();
            double distance = p.getDistance(anchorPosition);
            if (distance < minDistance) {
                minDistance = distance;
                nearestTerminal = terminal;
            }
        }
        return anchors.get(nearestTerminal);
        


    }
    
    protected ConnectionAnchor getDefaultSourceAnchor()
    {
        return anchors.get("SOUTH");
    }

    public ConnectionAnchor getSourceConnectionAnchorAt(Point location,
            OperatorOutput operator) {

        ActionNode source = (ActionNode) operator.eContainer();

        List<RelativeBendpoint> coordinates = operator.getCoordinates();

        int x_source = source.getX();
        int y_source = source.getY();

        if (!coordinates.isEmpty())
        {

            RelativeBendpoint p = coordinates.get(0);

            if (p.getSourceX() == 0)
            {

                // NORTH or SOUTH

                if (p.getSourceY() > 0) {
                    return anchors.get("SOUTH");
                } else {
                    return anchors.get("NORTH");
                }
            } else if (p.getSourceY() == 0) {

                if (p.getSourceX() > 0) {
                    return anchors.get("EAST");
                } else {
                    return anchors.get("WEST");
                }
            }

        }
        else {
            ActionNode target = operator.getTarget();

            if (target.getY() < y_source) {
                return anchors.get("NORTH");
            } else if (target.getY() == y_source) {
                if (target.getX() > x_source)
                {
                    return anchors.get("EAST");
                } else {
                    return anchors.get("WEST");
                }

            } else {

                return anchors.get("SOUTH");
            }
        }

        return anchors.get("SOUTH");
    }

    public ConnectionAnchor getTargetConnectionAnchorAt(Point point,
            String connectionName) {

        // if (point == null){
        // if (connectionName != null)
        // {
        // String terminal = getNextFreeTargetTerminal(connectionName);
        // return getConnectionAnchor(terminal);
        //
        // } else {
        // return getConnectionAnchor("NORTH");
        // }
        //
        // } else {
        double minDistance = Double.MAX_VALUE;
        String nearestTerminal = null;

        for (String terminal : new String[] { "NORTH", "WEST", "EAST" }) {

            FixedConnectionAnchor anchor = anchors.get(terminal);
            Point anchorPosition = anchor.getLocation();
            double distance = point.getDistance(anchorPosition);
            if (distance < minDistance) {
                minDistance = distance;
                nearestTerminal = terminal;
            }
        }
        return anchors.get(nearestTerminal);
        // }

    }

    public ConnectionAnchor getTargetConnectionAnchorAt(Point point,
            OperatorOutput connection, EditPart editPart) {

        if (point == null) {

            return getConnectionAnchor("NORTH");

        } else {
            double minDistance = Double.MAX_VALUE;
            String nearestTerminal = null;

            for (String terminal : new String[] { "NORTH", "WEST", "EAST", "SOUTH" }) {

                FixedConnectionAnchor anchor = anchors.get(terminal);
                Point anchorPosition = anchor.getLocation();
                double distance = point.getDistance(anchorPosition);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTerminal = terminal;
                }
            }
            return anchors.get(nearestTerminal);
        }

    }

    public ConnectionAnchor getTargetConnectionAnchorAt(Point point) {

        if (point == null) {

            return getConnectionAnchor("NORTH");

        } else {
            double minDistance = Double.MAX_VALUE;
            String nearestTerminal = null;

            for (String terminal : new String[] { "NORTH", "WEST", "EAST", "SOUTH" }) {

                FixedConnectionAnchor anchor = anchors.get(terminal);
                Point anchorPosition = anchor.getLocation();
                double distance = point.getDistance(anchorPosition);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTerminal = terminal;
                }
            }
            return anchors.get(nearestTerminal);
        }

    }

    //
    // public String getNextFreeTargetTerminal(String connectionName) {
    // return action.getFreeInputTerminal(connectionName);
    // }

    public ConnectionAnchor getTargetConnectionAnchorAt(Point point,
            OperatorOutput operator) {
        ActionNode target = operator.getTarget();
        ActionNode source = (ActionNode) operator.eContainer();

        List<RelativeBendpoint> coordinates = operator.getCoordinates();

        int x_source = source.getX();
        int y_source = source.getY();

        if (!coordinates.isEmpty())
        {
            RelativeBendpoint p = coordinates.get(coordinates.size() - 1);

            if (p.getSourceX() < 0)
            {
                if (p.getTargetX() == 0) {
                    if (p.getTargetY() > 0)
                    {
                        return anchors.get("SOUTH");
                    }
                    return anchors.get("NORTH");
                } else if (p.getTargetY() == 0)
                {
                    return anchors.get("EAST");
                }
            } else {
                if (p.getTargetX() == 0) {
                    if (p.getSourceY() < 0)
                    {
                        return anchors.get("SOUTH");
                    }
                    return anchors.get("NORTH");
                } else if (p.getTargetY() == 0)
                {
                    return anchors.get("WEST");
                }
            }

        }

        int x_target = target.getX();
        int y_target = target.getY();

        if ((y_target - y_source) > Math.abs(x_target - x_source))
        {
            return anchors.get("NORTH");
        }

        if (((y_target - y_source) < (x_target - x_source)) && (x_target > x_source))
        {
            return anchors.get("WEST");
        }

        if (((y_target - y_source) < (x_source - x_target)) && (x_target < x_source))
        {
            return anchors.get("EAST");
        }

        return anchors.get("NORTH");
    }
    
    @Override
    public Rectangle getHandleBounds() {
        Rectangle original = super.getHandleBounds();
        return new Rectangle(original.x,original.y,30,30);
    }

}
