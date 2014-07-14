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

import org.eclipse.debug.internal.core.commands.Request;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.ui.IMemento;

/**
 * @since 3.3
 */
abstract class MementoUpdate extends Request implements IViewerUpdate {

    private IPresentationContext fContext;
    private Object fElement;
    private TreePath fElementPath;
    private IMemento fMemento;
    protected TreeModelContentProvider fProvider;
    protected Object fViewerInput;

    /**
     * Constructs a viewer state request.
     * 
     * @param provider
     *        the content provider to use for the update
     * @param viewerInput
     *        the current input
     * @param elementPath
     *        the path of the element to update
     * @param element
     *        the element to update
     * @param memento
     *        Memento to update
     * @param context
     *        the presentation context
     * 
     */
    public MementoUpdate(TreeModelContentProvider provider, Object viewerInput, IPresentationContext context, Object element, TreePath elementPath, IMemento memento) {
        fContext = context;
        fElement = element;
        fElementPath = elementPath;
        fMemento = memento;
        fProvider = provider;
        fViewerInput = viewerInput;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate#getPresentationContext()
     */
    public IPresentationContext getPresentationContext() {
        return fContext;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate#getElement()
     */
    public Object getElement() {
        return fElement;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate#getElementPath()
     */
    public TreePath getElementPath() {
        return fElementPath;
    }

    public IMemento getMemento() {
        return fMemento;
    }

    public TreeModelContentProvider getContentProvider() {
        return fProvider;
    }

    public Object getElement(TreePath path) {
        return fProvider.getElement(path);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate#getViewerInput()
     */
    public Object getViewerInput() {
        return fViewerInput;
    }

}
