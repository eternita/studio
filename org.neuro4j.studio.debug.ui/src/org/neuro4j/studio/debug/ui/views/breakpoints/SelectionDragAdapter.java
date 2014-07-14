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
package org.neuro4j.studio.debug.ui.views.breakpoints;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.neuro4j.studio.debug.ui.views.TreeModelViewer;

/**
 * Drag adapter for the variables view and expressions view. Allows selected variables and
 * expressions to be dragged.
 * 
 * @see org.eclipse.debug.internal.ui.views.expression.ExpressionDropAdapter
 * @since 3.4
 */
public class SelectionDragAdapter extends DragSourceAdapter implements TransferDragSourceListener {

    /**
     * The associated viewer for the adapter
     */
    private TreeModelViewer fViewer;

    /**
     * Constructor, takes the viewer that contains the selection provider
     * 
     * @param view
     *        the associated view, <b>must</b> implement <code>ISelectionProvider</code>
     */
    public SelectionDragAdapter(TreeModelViewer viewer) {
        Assert.isNotNull(viewer);
        fViewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.util.TransferDragSourceListener#getTransfer()
     */
    public Transfer getTransfer() {
        return LocalSelectionTransfer.getTransfer();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.swt.dnd.DragSourceAdapter#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragStart(DragSourceEvent event) {
        ISelection selection = fViewer.getSelection();
        LocalSelectionTransfer.getTransfer().setSelection(selection);
        LocalSelectionTransfer.getTransfer().setSelectionSetTime(event.time & 0xFFFFFFFFL);
        event.doit = !selection.isEmpty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.swt.dnd.DragSourceAdapter#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragSetData(DragSourceEvent event) {
        // For consistency set the data to the selection even though
        // the selection is provided by the LocalSelectionTransfer
        // to the drop target adapter.
        event.data = LocalSelectionTransfer.getTransfer().getSelection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.swt.dnd.DragSourceAdapter#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragFinished(DragSourceEvent event) {
        LocalSelectionTransfer.getTransfer().setSelection(null);
        LocalSelectionTransfer.getTransfer().setSelectionSetTime(0);
    }
}
