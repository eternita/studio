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
package org.neuro4j.studio.core.diagram.edit.parts.actions;

import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.impl.LogicNodeImpl;

public class OpenCustomBlockAction extends OpenNodeAction {
    public final static String ID = "org.neuro4j.studio.core.diagram.edit.parts.actions.OpenCustomBlockAction1";

    @Override
    protected String getResourcePattern(String name) {

        String fileName = name.replace(".", "/").trim();
        return "*" + fileName + ".java";
    }

    @Override
    protected String getTitle() {
        return "Custom Blocks...";
    }

    @Override
    protected String getStringParameter() {
        ShapeImpl shape = (ShapeImpl) ((LogicNodeEditPart) selectedElement).getModel();
        LogicNodeImpl callNode = (LogicNodeImpl) shape.getElement();
        String name = callNode.getClassName();
        return name;
    }

}
