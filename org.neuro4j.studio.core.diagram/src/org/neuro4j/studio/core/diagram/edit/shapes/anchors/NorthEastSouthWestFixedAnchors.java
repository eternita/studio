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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.shapes.FixedConnectionAnchor;

/**
 * Used for loop node.
 * 
 * @author pavlikdm
 * 
 */
public class NorthEastSouthWestFixedAnchors extends NorthEastSouthFixedAnchors {

    static {

        anchorLocations.put("WEST", new PrecisionPoint(0, 0.5d));

    }

    public NorthEastSouthWestFixedAnchors(int i, int j,
            ActionNode action) {
        super(i, j, action);
    }

    public ConnectionAnchor getSourceConnectionAnchorAt(Point p, String connectionName) {

        if (p == null)
        {
            if (connectionName.equals("NEXT"))
            {
                return anchors.get("EAST");
            }
            if (connectionName.equals("LOOP_EXIT"))
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
            if (dy > getBounds().height / 4 && dy < (getBounds().height - 7))
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

        for (String terminal : new String[] { "NORTH", "WEST" }) {

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
            if (hasCiclumConnection(connection, editPart))
            {
                return getConnectionAnchor("WEST");

            } else {
                return getConnectionAnchor("NORTH");
            }

        } else {
            double minDistance = Double.MAX_VALUE;
            String nearestTerminal = null;

            for (String terminal : new String[] { "NORTH", "WEST" }) {

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

            for (String terminal : new String[] { "NORTH", "WEST" }) {

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

    // public String getNextFreeTargetTerminal(String connectionName) {
    // return action.getFreeInputTerminal(connectionName);
    // }

    private boolean hasCiclumConnection(OperatorOutput output, EditPart editPart)
    {
        ActionNode source = output.getTarget();
        ShapeImpl shape = (ShapeImpl) editPart.getModel();
        ActionNode target = (ActionNode) shape.getElement();
        List<Node> path = getDirections(source, target);
        if (path.isEmpty())
        {
            return false;
        } else {
            return true;
        }

    }

    // private void processCicle(List<OperatorOutput> outputs, ActionNode original, ActionNode loopNode, StringBuffer
    // hasCicle){
    //
    // for(OperatorOutput output: outputs)
    // {
    // ActionNode target = output.getTarget();
    // if (target.equals(original))
    // {
    // hasCicle.append(Boolean.TRUE);
    // return;
    // } else if (loopNode.equals(target)){
    // hasCicle.append(Boolean.FALSE);
    // return;
    // }else
    // {
    // processCicle(target.getOutput(), original, loopNode, hasCicle);
    // }
    // }
    //
    // //return false;
    // }

    private List<Node> getDirections(ActionNode sourceNode, ActionNode destinationNode) {
        // Initialization.
        Map<ActionNode, ActionNode> nextNodeMap = new HashMap<ActionNode, ActionNode>();
        ActionNode currentNode = sourceNode;

        // Queue
        Queue<ActionNode> queue = new LinkedList<ActionNode>();
        queue.add(currentNode);

        /*
         * The set of visited nodes doesn't have to be a Map, and, since order
         * is not important, an ordered collection is not needed. HashSet is
         * fast for add and lookup, if configured properly.
         */
        Set<String> visitedNodes = new HashSet<String>();
        visitedNodes.add(currentNode.getId());

        // Search.
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.equals(destinationNode)) {
                break;
            } else {
                for (ActionNode nextNode : getChildNodes(currentNode)) {
                    if (!visitedNodes.contains(nextNode.getId())) {
                        queue.add(nextNode);
                        visitedNodes.add(nextNode.getId());

                        // Look up of next node instead of previous.
                        nextNodeMap.put(currentNode, nextNode);
                    }
                }
            }
        }

        // If all nodes are explored and the destination node hasn't been found.
        if (!currentNode.equals(destinationNode)) {
            return Collections.emptyList();
        }

        // Reconstruct path. No need to reverse.
        List<Node> directions = new LinkedList<Node>();
        for (Node node = sourceNode; node != null; node = nextNodeMap.get(node)) {
            directions.add(node);
        }

        return directions;
    }

    private List<ActionNode> getChildNodes(ActionNode currentNode) {
        List<ActionNode> list = new LinkedList<ActionNode>();
        List<OperatorOutput> out = currentNode.getOutput();
        for (OperatorOutput o : out)
        {
            if (o.getTarget() != null)
            {
                list.add(o.getTarget());
            }

        }
        return list;
    }

}
