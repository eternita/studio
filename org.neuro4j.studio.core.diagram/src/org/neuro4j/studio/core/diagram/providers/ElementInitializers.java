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

import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

    protected ElementInitializers() {
        // use #getInstance to access cached instance
    }

    /**
     * @generated
     */
    public static ElementInitializers getInstance() {
        ElementInitializers cached = Neuro4jDiagramEditorPlugin.getInstance()
                .getElementInitializers();
        if (cached == null) {
            Neuro4jDiagramEditorPlugin.getInstance().setElementInitializers(
                    cached = new ElementInitializers());
        }
        return cached;
    }
}
