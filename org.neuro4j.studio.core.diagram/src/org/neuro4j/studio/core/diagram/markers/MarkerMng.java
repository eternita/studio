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
package org.neuro4j.studio.core.diagram.markers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.parts.NodeBaseEditPart;

/**
 * This class keeps info which nodes have been registered for debug.
 * 
 */
public class MarkerMng {

    String stopWithUUID = "";

    Set<String> nodesWithDebugMarkers = new HashSet<String>();
    Map<String, ShapeNodeEditPart> editparts = new HashMap<String, ShapeNodeEditPart>();

    private static MarkerMng instance = new MarkerMng();

    private MarkerMng()
    {
        loadResourceMarkers(ResourcesPlugin.getWorkspace().getRoot());
    }

    public static MarkerMng getInstance()
    {
        return instance;
    }

    public boolean isUUIDHasMarket(ActionNode node)
    {
        return nodesWithDebugMarkers.contains(node.getId());
    }

    public void loadResourceMarkers(IResource res)
    {
        IMarker[] markers;
        try {
            markers = res.findMarkers("org.eclipse.jdt.debug.javaLineBreakpointMarker", true, 5);
            for (IMarker m : markers)
            {
                addMarker(m);
            }
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void registerEditPart(String uuid, ShapeNodeEditPart editpart)
    {
        editparts.put(uuid, editpart);
    }

    public ShapeNodeEditPart getEditPartAndMark(String uuid)
    {
        this.stopWithUUID = uuid;
        return editparts.get(uuid);

    }

    public void addMarker(IMarker marker)
    {

        try {
            String uuids = (String) marker.getAttribute("uuids");
            if (uuids == null)
            {
                return;
            }
            for (String uuid : uuids.split(" "))
            {
                nodesWithDebugMarkers.add(uuid);
            }
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void removeMarker(IMarker marker)
    {
        nodesWithDebugMarkers.clear();
    }

    public void removeMarkerInfoForNode(ActionNode node)
    {

     nodesWithDebugMarkers.remove(node.getId());

     editparts.remove(node.getId());
    }

    public void resentstopWithUUID()
    {
        stopWithUUID = "";
    }


    public void updateMarker(IMarker marker)
    {      

        try {
            String uuids = (String) marker.getAttribute("uuids");

            for (String uuid : uuids.split(" "))
            {
            	nodesWithDebugMarkers.add(uuid);
            }
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getStopWithUUID() {
        return stopWithUUID;
    }

}
