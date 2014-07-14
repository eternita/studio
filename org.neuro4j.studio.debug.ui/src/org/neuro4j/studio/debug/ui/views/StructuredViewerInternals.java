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

package org.neuro4j.studio.debug.ui.views;

import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

/**
 * This class is not part of the public API of JFace. See bug 267722.
 * 
 * @since 3.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class StructuredViewerInternals {

    /**
     * Nothing to see here.
     * 
     * @since 3.5
     * @noextend This interface is not intended to be extended by clients.
     * @noimplement This interface is not intended to be implemented by clients.
     */
    protected static interface AssociateListener {

        /**
         * Call when an element is associated with an Item
         * 
         * @param element
         * @param item
         */
        void associate(Object element, Item item);

        /**
         * Called when an Item is no longer associated
         * 
         * @param item
         */
        void disassociate(Item item);

        /**
         * Called when an element has been filtered out.
         * 
         * @since 3.6
         * @param element
         */
        void filteredOut(Object element);
    }

    /**
     * Nothing to see here. Sets or resets the AssociateListener for the given
     * Viewer.
     * 
     * @param viewer
     *        the viewer
     * @param listener
     *        the {@link AssociateListener}
     * @noreference This method is not intended to be referenced by clients.
     */
    protected static void setAssociateListener(StructuredViewer viewer,
            AssociateListener listener) {
        viewer.setAssociateListener(listener);
    }

    /**
     * Nothing to see here. Returns the items for the given element.
     * 
     * @param viewer
     * @param element
     * @return the Widgets corresponding to the element
     * 
     * @noreference This method is not intended to be referenced by clients.
     */
    protected static Widget[] getItems(StructuredViewer viewer, Object element) {
        return viewer.findItems(element);
    }

}
