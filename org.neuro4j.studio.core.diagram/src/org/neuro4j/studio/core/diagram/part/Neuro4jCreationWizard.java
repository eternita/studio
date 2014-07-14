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
package org.neuro4j.studio.core.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

//import org.neuro4j.studio.properties.ui.celleditor.FlowResourcesSelectionDialog;

/**
 * @generated
 */
public class Neuro4jCreationWizard extends Wizard implements INewWizard {

    /**
     * @generated
     */
    private IWorkbench workbench;

    /**
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * @generated
     */
    protected Neuro4jCreationWizardPage diagramModelFilePage;

    /**
     * @generated
     */
    protected Resource diagram;

    /**
     * @generated
     */
    private boolean openNewlyCreatedDiagramEditor = true;

    /**
     * @generated
     */
    public IWorkbench getWorkbench() {
        return workbench;
    }

    /**
     * @generated
     */
    public IStructuredSelection getSelection() {
        return selection;
    }

    /**
     * @generated
     */
    public final Resource getDiagram() {
        return diagram;
    }

    /**
     * @generated
     */
    public final boolean isOpenNewlyCreatedDiagramEditor() {
        return openNewlyCreatedDiagramEditor;
    }

    /**
     * @generated
     */
    public void setOpenNewlyCreatedDiagramEditor(
            boolean openNewlyCreatedDiagramEditor) {
        this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
    }

    /**
     * @generated
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(Messages.Neuro4jCreationWizardTitle);
        setDefaultPageImageDescriptor(Neuro4jDiagramEditorPlugin
                .getBundledImageDescriptor("icons/wizban/NewNeuro4jWizard.gif")); //$NON-NLS-1$
        setNeedsProgressMonitor(true);
    }

    /**
     * @generated NOT
     */
    public void addPages() {
        diagramModelFilePage = new Neuro4jCreationWizardPage("DiagramModelFile", getSelection(), "n4j"); //$NON-NLS-1$ //$NON-NLS-2$
        diagramModelFilePage
                .setTitle(Messages.Neuro4jCreationWizard_DiagramModelFilePageTitle);
        diagramModelFilePage
                .setDescription(Messages.Neuro4jCreationWizard_DiagramModelFilePageDescription);
        addPage(diagramModelFilePage);
    }

    /**
     * @generated NOT
     */
    public boolean performFinish() {
        IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

            protected void execute(IProgressMonitor monitor)
                    throws CoreException, InterruptedException {
                diagram = Neuro4jDiagramEditorUtil.createResource(
                        diagramModelFilePage.getURI(), monitor);
                if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
                    try {
                        Neuro4jDiagramEditorUtil.openDiagram(diagram);
                    } catch (PartInitException e) {
                        ErrorDialog.openError(getContainer().getShell(),
                                Messages.Neuro4jCreationWizardOpenEditorError,
                                null, e.getStatus());
                    }
                }
            }
        };
        try {
            getContainer().run(false, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof CoreException) {
                ErrorDialog.openError(getContainer().getShell(),
                        Messages.Neuro4jCreationWizardCreationError, null,
                        ((CoreException) e.getTargetException()).getStatus());
            } else {
                Neuro4jDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
            }
            return false;
        }
        if (diagram != null)
        {
            // DiagramImpl diagramimpl = (DiagramImpl) diagram.getContents().get(1);
            // diagramimpl.eNotify(new ENotificationImpl((InternalEObject)diagramimpl, Notification.RESOLVE,
            // Neuro4jPackage.ACTION_NODE__NAME, "", "loaded"));
        }

        return diagram != null;
    }
}
