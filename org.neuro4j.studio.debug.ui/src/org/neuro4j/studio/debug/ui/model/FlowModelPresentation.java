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
package org.neuro4j.studio.debug.ui.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Renders PDA debug elements
 */
public class FlowModelPresentation extends LabelProvider implements IDebugModelPresentation {

    public FlowModelPresentation() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
     */
    public void setAttribute(String attribute, Object value) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    public Image getImage(Object element) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue,
     * org.eclipse.debug.ui.IValueDetailListener)
     */
    public void computeDetail(IValue value, IValueDetailListener listener) {
        String detail = "";
        try {
            detail = value.getValueString();
        } catch (DebugException e) {
        }
        listener.detailComputed(value, detail);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
     */
    public IEditorInput getEditorInput(Object element) {
        if (element instanceof IFile) {
            return new FileEditorInput((IFile) element);
        }
        if (element instanceof ILineBreakpoint) {
            return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
     */
    public String getEditorId(IEditorInput input, Object element) {
        if (element instanceof IFile || element instanceof ILineBreakpoint) {
            return "org.eclipse.ui.DefaultTextEditor";
        }
        return null;
    }
}
