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

import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementCompareRequest;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ITreeModelViewer;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.ui.IMemento;

/**
 * @since 3.3
 */
public class ElementCompareRequest extends MementoUpdate implements IElementCompareRequest {

    private boolean fEqual;
    private final int fModelIndex;
    private ModelDelta fDelta;
    private boolean fKnowsHasChildren;
    private boolean fKnowsChildCount;
    private boolean fCheckChildrenRealized;

    /**
     * @param provider
     *        the content provider to use for the update
     * @param viewerInput
     *        the current input
     * @param element
     *        the element to update
     * @param elementPath
     *        the path of the element to update
     * @param memento
     *        Memento to encode result into
     * @param delta
     *        Delta to write the result comparison into.
     * @param modelIndex
     *        Index of element to compare.
     * @param knowsHasChildren
     *        Flag indicating whether provider knows the has
     *        children state of element.
     * @param knowsChildCount
     *        Flag indicating whether provider knows the
     *        child count state of element.
     * @param checkChildrenRealized
     *        Flag indicating if any realized children should be checked
     */
    public ElementCompareRequest(TreeModelContentProvider provider, Object viewerInput, Object element,
            TreePath elementPath, IMemento memento, ModelDelta delta, int modelIndex,
            boolean knowsHasChildren, boolean knowsChildCount, boolean checkChildrenRealized)
    {
        super(provider, viewerInput, provider.getPresentationContext(), element, elementPath, memento);
        fProvider = provider;
        fDelta = delta;
        fModelIndex = modelIndex;
        fKnowsHasChildren = knowsHasChildren;
        fKnowsChildCount = knowsChildCount;
        fCheckChildrenRealized = checkChildrenRealized;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.IElementCompareRequest#setEqual(boolean)
     */
    public void setEqual(boolean equal) {
        fEqual = equal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IProgressMonitor#done()
     */
    public void done() {
        ITreeModelViewer viewer = getContentProvider().getViewer();
        if (viewer == null)
            return; // disposed
        if (viewer.getDisplay().getThread() == Thread.currentThread()) {
            fProvider.getStateTracker().compareFinished(ElementCompareRequest.this, fDelta);
        } else {
            viewer.getDisplay().asyncExec(new Runnable() {
                public void run() {
                    if (getContentProvider().isDisposed())
                        return;
                    fProvider.getStateTracker().compareFinished(ElementCompareRequest.this, fDelta);
                }
            });
        }
    }

    public boolean isEqual() {
        return fEqual;
    }

    ModelDelta getDelta() {
        return fDelta;
    }

    int getModelIndex() {
        return fModelIndex;
    }

    void setKnowsHasChildren(boolean hasChildren) {
        fKnowsHasChildren = hasChildren;
    }

    boolean knowsHasChildren() {
        return fKnowsHasChildren;
    }

    void setKnowsChildCount(boolean childCount) {
        fKnowsChildCount = childCount;
    }

    boolean knowChildCount() {
        return fKnowsChildCount;
    }

    void setCheckChildrenRealized(boolean checkChildrenRealized) {
        fCheckChildrenRealized = checkChildrenRealized;
    }

    boolean checkChildrenRealized() {
        return fCheckChildrenRealized;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("IElementCompareRequest: "); //$NON-NLS-1$
        buf.append(getElement());
        return buf.toString();
    }

}
