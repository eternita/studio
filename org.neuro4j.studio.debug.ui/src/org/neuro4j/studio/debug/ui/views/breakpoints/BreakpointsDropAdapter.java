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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.internal.ui.views.breakpoints.BreakpointsViewer;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TreeItem;

/**
 * BreakpointsDropAdapter
 */
public class BreakpointsDropAdapter extends ViewerDropAdapter {

    private Item fTarget = null;
    private TreePath fPath = null;
    private FlowBreakpointsView fView;

    /**
     * Constructor
     * 
     * @param viewer
     *        the backing viewer
     */
    protected BreakpointsDropAdapter(TreeViewer viewer) {
        super(viewer);
        setFeedbackEnabled(false);
    }

    protected BreakpointsDropAdapter(TreeViewer viewer, FlowBreakpointsView view) {
        this(viewer);
        fView = view;
    }

    /**
     * @see org.eclipse.jface.viewers.ViewerDropAdapter#performDrop(java.lang.Object)
     */
    public boolean performDrop(Object data) {
        // This is temporary
        if (getViewer() instanceof BreakpointsViewer) {
            return ((BreakpointsViewer) getViewer()).performDrop(fTarget, (IStructuredSelection) LocalSelectionTransfer.getTransfer().getSelection());
        } else if (fView != null) {
            ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
            if (fPath != null && selection instanceof ITreeSelection) {
                if (selection instanceof ITreeSelection) {
                    return fView.performDrop(fPath, (ITreeSelection) LocalSelectionTransfer.getTransfer().getSelection());
                }
            }
        }
        return false;
    }

    /**
     * @see org.eclipse.jface.viewers.ViewerDropAdapter#determineTarget(org.eclipse.swt.dnd.DropTargetEvent)
     */
    protected Object determineTarget(DropTargetEvent event) {
        fTarget = (Item) event.item;
        if (fTarget instanceof TreeItem) {
            List list = new ArrayList();
            TreeItem item = (TreeItem) fTarget;
            while (item != null) {
                list.add(item.getData());
                item = item.getParentItem();
            }
            fPath = new TreePath(list.toArray());
        } else {
            fPath = null;
        }
        return fTarget;
    }

    /**
     * @see org.eclipse.jface.viewers.ViewerDropAdapter#validateDrop(java.lang.Object, int,
     *      org.eclipse.swt.dnd.TransferData)
     */
    public boolean validateDrop(Object target, int operation, TransferData transferType) {
        // This is temporary
        if (getViewer() instanceof BreakpointsViewer) {
            return ((BreakpointsViewer) getViewer()).canDrop(fTarget, (IStructuredSelection) LocalSelectionTransfer.getTransfer().getSelection());
        } else {
            ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
            if (fPath != null && selection instanceof ITreeSelection) {
                if (selection instanceof ITreeSelection) {
                    return fView.canDrop(fPath, (ITreeSelection) LocalSelectionTransfer.getTransfer().getSelection());
                }
            }
        }
        return false;
    }
}
