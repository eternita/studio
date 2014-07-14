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

import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementMementoRequest;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ITreeModelViewer;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.ui.IMemento;
import org.neuro4j.studio.debug.ui.views.ViewerStateTracker.IElementMementoCollector;

/**
 * Request for element memento.
 * 
 * @since 3.3
 */
class ElementMementoRequest extends MementoUpdate implements IElementMementoRequest {

    private IElementMementoCollector fManager;
    private ModelDelta fDelta;

    /**
     * @param provider
     *        the content provider to use for the update
     * @param viewerInput
     *        the current input
     * @param collector
     *        Collector to report the result to
     * @param element
     *        the element to update
     * @param elementPath
     *        the path of the element to update
     * @param memento
     *        Memento to encode result into
     * @param delta
     *        Delta to write the result comparison into.
     */
    public ElementMementoRequest(TreeModelContentProvider provider, Object viewerInput, IElementMementoCollector collector, Object element, TreePath elementPath, IMemento memento, ModelDelta delta) {
        super(provider, viewerInput, provider.getPresentationContext(), element, elementPath, memento);
        fManager = collector;
        fDelta = delta;
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
            doComplete();
        } else {
            viewer.getDisplay().asyncExec(new Runnable() {
                public void run() {
                    doComplete();
                }
            });
        }

    }

    private void doComplete() {
        if (getContentProvider().isDisposed())
            return;

        if (!isCanceled() && (getStatus() == null || getStatus().isOK())) {
            // replace the element with a memento
            fDelta.setElement(getMemento());
        }
        fManager.requestComplete(ElementMementoRequest.this);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("IElementMementoRequest: "); //$NON-NLS-1$
        buf.append(getElement());
        return buf.toString();
    }
}
