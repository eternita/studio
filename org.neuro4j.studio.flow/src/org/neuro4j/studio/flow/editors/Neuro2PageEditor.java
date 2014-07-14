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
package org.neuro4j.studio.flow.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditor;
import org.neuro4j.studio.flow.Activator;

public class Neuro2PageEditor extends Neuro4jDiagramEditor {

    public static final String ID = "org.neuro4j.studio.flow.diagram.part.Neuro4jDiagramEditorID"; //$NON-NLS-1$

    /**
     * @generated
     */
    protected IDocumentProvider getDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput
                || input instanceof URIEditorInput) {
            return Activator.getInstance()
                    .getDocumentProvider();
        }

        return super.getDocumentProvider(input);
    }

    protected void setDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput
                || input instanceof URIEditorInput) {
            setDocumentProvider(Activator.getDefault()
                    .getDocumentProvider());
        } else {
            super.setDocumentProvider(input);
        }
    }

    // @Override
    // public void commandStackChanged(EventObject event) {
    // super.commandStackChanged(event);
    // DefaultOperationHistory doh = (DefaultOperationHistory)event.getSource();
    // doh.
    // IDocumentProvider dprovider = getDocumentProvider();
    // if (dprovider != null)
    // {
    // //firePropertyChange(PROP_DIRTY);
    // getDocumentProvider().changed(getEditorInput());
    // }
    //
    // }

    @Override
    public boolean isSaveAsAllowed() {
        // TODO Auto-generated method stub

        return super.isSaveAsAllowed();
    }

    @Override
    public void doSaveAs() {
        // TODO Auto-generated method stub
        super.doSaveAs();
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        // TODO Auto-generated method stub
        super.doSave(progressMonitor);
    }

    @Override
    protected void handleEditorInputChanged() {
        // TODO Auto-generated method stub
        super.handleEditorInputChanged();
    }

    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        getDiagram().eNotify(new ENotificationImpl((InternalEObject) getDiagram(), Notification.RESOLVE, Neuro4jPackage.ACTION_NODE__NAME, "", "loaded"));

    }
}
