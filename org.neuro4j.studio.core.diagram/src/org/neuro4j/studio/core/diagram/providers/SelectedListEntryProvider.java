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

package org.neuro4j.studio.core.diagram.providers;

import java.util.Collections;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.neuro4j.studio.core.util.ListEntry;

public class SelectedListEntryProvider {

    private ListEntry entry;
    private DiagramEditPart diagramEditPart;

    private boolean availableForInsert = false;

    private static SelectedListEntryProvider instance = new SelectedListEntryProvider();

    private SelectedListEntryProvider() {
        super();

    }

    public static SelectedListEntryProvider getInstance()
    {
        return instance;
    }

    public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
        this.diagramEditPart = diagramEditPart;
    }

    public ListEntry getEntry() {
        return entry;
    }

    public void setEntry(ListEntry entry) {
        this.entry = entry;
    }

    public boolean isAvailableForInsert() {
        return availableForInsert;
    }

    public void setAvailableForInsert(boolean availableForInsert) {
        this.availableForInsert = availableForInsert;
        if (!availableForInsert)
        {
            this.entry = null;
        }
    }

    public void createObject(int x, int y)
    {
        if (availableForInsert && this.entry != null)
        {
            availableForInsert = false;
            switch (this.entry.getType()) {

                case CUSTOM_BLOCK:

                    CreateUnspecifiedTypeRequest request = new
                            CreateUnspecifiedTypeRequest(
                                    Collections.singletonList(Neuro4jElementTypes.LogicNode_2017),
                                    diagramEditPart.getDiagramPreferencesHint());

                    request.setLocation(new Point(x, y));
                    Command command = diagramEditPart.getCommand(request);
                    command.execute();

                    break;
                    
                case FLOW:
                    request = new
                            CreateUnspecifiedTypeRequest(
                                    Collections.singletonList(Neuro4jElementTypes.CallNode_2008),
                                    diagramEditPart.getDiagramPreferencesHint());

                    request.setLocation(new Point(x, y));
                    command = diagramEditPart.getCommand(request);
                    command.execute();

                    break;

                default:
                    break;
            }

         //   Object newObject = request.getNewObject();
            this.entry = null;
        }
    }

}
