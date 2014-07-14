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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class MyPolylineDecoration extends PolylineDecoration
        implements RotatableDecoration
{
    // public static final PointList TRIANGLE_TIP = new PointList();

    PointList template = null;

    public MyPolylineDecoration(PointList pl)
    {
        setBackgroundColor(ColorConstants.black);
        setScale(7.0D, 3.0D);
        this.template = pl;
    }

}