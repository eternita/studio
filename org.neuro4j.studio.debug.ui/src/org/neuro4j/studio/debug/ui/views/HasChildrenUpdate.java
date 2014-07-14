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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate;
import org.eclipse.jface.viewers.TreePath;

/**
 * @since 3.3
 */
class HasChildrenUpdate extends ViewerUpdateMonitor implements IHasChildrenUpdate {

    private boolean fHasChildren = false;

    private List fBatchedRequests = null;

    /**
     * Constructs a request to update an element
     * 
     * @param provider
     *        the content provider
     * @param viewerInput
     *        the current input
     * @param elementPath
     *        the path to the element being update
     * @param element
     *        the element
     * @param elementContentProvider
     *        the content provider for the element
     */
    public HasChildrenUpdate(TreeModelContentProvider provider, Object viewerInput, TreePath elementPath, Object element, IElementContentProvider elementContentProvider) {
        super(provider, viewerInput, elementPath, element, elementContentProvider, provider.getPresentationContext());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.viewers.ViewerUpdateMonitor#performUpdate()
     */
    protected void performUpdate() {
        TreeModelContentProvider contentProvider = getContentProvider();
        TreePath elementPath = getElementPath();
        if (!fHasChildren) {
            contentProvider.clearFilters(elementPath);
        }
        if (DebugUIPlugin.DEBUG_CONTENT_PROVIDER && DebugUIPlugin.DEBUG_TEST_PRESENTATION_ID(getPresentationContext())) {
        }
        contentProvider.getViewer().setHasChildren(elementPath, fHasChildren);
        if (fHasChildren) {
            contentProvider.getViewer().autoExpand(elementPath);
        }
        if (elementPath.getSegmentCount() > 0) {
            getContentProvider().getStateTracker().restorePendingStateOnUpdate(getElementPath(), -1, true, false, false);
        }
    }

    public void setHasChilren(boolean hasChildren) {
        fHasChildren = hasChildren;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("IHasChildrenUpdate: "); //$NON-NLS-1$
        buf.append(getElement());
        return buf.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor#coalesce(org.eclipse.debug.internal.ui.viewers
     * .model.ViewerUpdateMonitor)
     */
    boolean coalesce(ViewerUpdateMonitor request) {
        if (request instanceof HasChildrenUpdate) {
            if (getElementPath().equals(request.getElementPath())) {
                // duplicate request
                return true;
            } else if (getElementContentProvider().equals(request.getElementContentProvider())) {
                if (fBatchedRequests == null) {
                    fBatchedRequests = new ArrayList();
                    fBatchedRequests.add(this);
                }
                fBatchedRequests.add(request);
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor#startRequest()
     */
    void startRequest() {
        if (fBatchedRequests == null) {
            getElementContentProvider().update(new IHasChildrenUpdate[] { this });
        } else {
            IHasChildrenUpdate[] updates = (IHasChildrenUpdate[]) fBatchedRequests.toArray(new IHasChildrenUpdate[fBatchedRequests.size()]);
            // notify that the other updates have also started to ensure correct sequence
            // of model updates - **** start at index 1 since the first (0) update has
            // already notified the content provider that it has started.
            for (int i = 1; i < updates.length; i++) {
                getContentProvider().updateStarted((ViewerUpdateMonitor) updates[i]);
            }
            getElementContentProvider().update(updates);
        }
    }

    boolean containsUpdate(TreePath path) {
        if (getElementPath().equals(path)) {
            return true;
        } else if (fBatchedRequests != null) {
            for (int i = 0; i < fBatchedRequests.size(); i++) {
                if (((ViewerUpdateMonitor) fBatchedRequests.get(i)).getElementPath().equals(path)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor#getPriority()
     */
    int getPriority() {
        return 1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.ViewerUpdateMonitor#getSchedulingPath()
     */
    TreePath getSchedulingPath() {
        TreePath path = getElementPath();
        if (path.getSegmentCount() > 0) {
            return path.getParentPath();
        }
        return path;
    }

    boolean hasChildren() {
        return fHasChildren;
    }

    protected boolean doEquals(ViewerUpdateMonitor update) {
        return update instanceof HasChildrenUpdate &&
                getViewerInput().equals(update.getViewerInput()) &&
                getElementPath().equals(update.getElementPath());
    }

    protected int doHashCode() {
        return getClass().hashCode() + getViewerInput().hashCode() + getElementPath().hashCode();
    }

}
