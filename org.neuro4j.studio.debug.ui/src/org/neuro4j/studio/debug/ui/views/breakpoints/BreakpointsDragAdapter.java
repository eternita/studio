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
import org.eclipse.debug.internal.ui.views.breakpoints.BreakpointsViewer;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Item;

/**
 * A drag adapter for the breakpoints viewer
 */
public class BreakpointsDragAdapter extends DragSourceAdapter implements TransferDragSourceListener {

    /**
     * the associated viewer for the adapter
     */
    private AbstractTreeViewer fViewer;
    private Item[] fItems = null;

    private FlowBreakpointsView fView;
    private TreePath[] fTreePaths = null;

    /**
     * Constructor
     * 
     * @param viewer
     *        the associated viewer, which acts as the selection provider and therefore <b>must</b> implement
     *        <code>ISelectionProvider</code>
     */
    public BreakpointsDragAdapter(BreakpointsViewer viewer) {
        Assert.isNotNull(viewer);
        fViewer = viewer;
    }

    public BreakpointsDragAdapter(AbstractTreeViewer viewer, FlowBreakpointsView view) {
        Assert.isNotNull(view);
        fViewer = viewer;
        fView = view;
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
     * non Java-doc
     * 
     * @see org.eclipse.swt.dnd.DragSourceListener#dragStart
     */
    public void dragStart(DragSourceEvent event) {
        ISelection selection = fViewer.getSelection();
        LocalSelectionTransfer.getTransfer().setSelection(selection);
        LocalSelectionTransfer.getTransfer().setSelectionSetTime(event.time & 0xFFFFFFFFL);
        if (fViewer instanceof BreakpointsViewer) {
            BreakpointsViewer viewer = (BreakpointsViewer) fViewer;
            fItems = viewer.getSelectedItems();
            event.doit = viewer.canDrag(fItems);
        } else {
            if (selection instanceof ITreeSelection) {
                fTreePaths = ((ITreeSelection) selection).getPaths();
            } else {
                fTreePaths = new TreePath[0];
            }
            event.doit = fView.canDrag(fTreePaths);
        }
    }

    /*
     * non Java-doc
     * 
     * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData
     */
    public void dragSetData(DragSourceEvent event) {
        // For consistency set the data to the selection even though
        // the selection is provided by the LocalSelectionTransfer
        // to the drop target adapter.
        event.data = LocalSelectionTransfer.getTransfer().getSelection();
    }

    /*
     * non Java-doc
     * 
     * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished
     */
    public void dragFinished(DragSourceEvent event) {
        if (event.detail == DND.DROP_MOVE) {
            // remove from source on move operation
            if (fViewer instanceof BreakpointsViewer) {
                BreakpointsViewer viewer = (BreakpointsViewer) fViewer;
                viewer.performDrag(fItems);
            } else {
                fView.performDrag(fTreePaths);
            }
        }
        fItems = null;
        LocalSelectionTransfer.getTransfer().setSelection(null);
        LocalSelectionTransfer.getTransfer().setSelectionSetTime(0);
    }
}
