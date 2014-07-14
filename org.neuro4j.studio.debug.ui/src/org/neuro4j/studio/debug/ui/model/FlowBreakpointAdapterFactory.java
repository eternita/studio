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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Creates a toggle breakpoint adapter
 */
public class FlowBreakpointAdapterFactory implements IAdapterFactory {
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
     */
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof ITextEditor) {
            ITextEditor editorPart = (ITextEditor) adaptableObject;
            IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
            if (resource != null) {
                String extension = resource.getFileExtension();
                if (extension != null && extension.equals("pda")) {
                    // return new FlowLineBreakpointAdapter();
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
     */
    public Class[] getAdapterList() {
        return new Class[] { IToggleBreakpointsTarget.class };
    }
}
