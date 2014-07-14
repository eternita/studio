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
package org.neuro4j.studio.core.diagram.edit.parts;

import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.diagram.ui.editparts.NoteEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.NoteFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;

public class MyNoteEditPart extends NoteEditPart {

    public MyNoteEditPart(View view) {
        super(view);

    }

    protected NodeFigure createNodeFigure() {
        NoteFigure noteFigure = (NoteFigure) super.createNodeFigure();
        Object model = getModel();
        if (model != null && model instanceof View) {
            ShapeImpl notationView = (ShapeImpl) model;
            noteFigure.setToolTip(new Label(notationView.getDescription()));
        }

        return noteFigure;
    }
}
