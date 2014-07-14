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
package org.neuro4j.studio.core.coordinates;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class CoordinateStorage {

    private static final int CELL_SIZE = 100;

    private static final int X_OFFSET = 8;

    private static final int Y_OFFSET = 15;

    private Map<String, CoordinatePoint> map = new HashMap<String, CoordinatePoint>();

    public CoordinateStorage()
    {

    }

    public void addNewCoordinate(String id, CoordinatePoint point)
    {
        map.put(id, point);
    }

    public static CoordinatePoint getCoordinateByLocation(int _x, int _y)
    {
        int x = (_x + (CELL_SIZE - 1)) / CELL_SIZE;
        int y = (_y + (CELL_SIZE - 1)) / CELL_SIZE;

        return new CoordinatePoint(x, y);
    }

    public Point getCoordinateInCell(CoordinatePoint cc)
    {
        int x = cc.getX();
        int y = cc.getY();

        return new Point(x, y);
    }

    public static Rectangle alignCoordinate(Rectangle rectangle)
    {
        int x = (rectangle.x / CELL_SIZE) + X_OFFSET;
        int y = (rectangle.y / CELL_SIZE) + Y_OFFSET;
        rectangle.setX(x);
        rectangle.setY(y);
        return rectangle;
    }

}
