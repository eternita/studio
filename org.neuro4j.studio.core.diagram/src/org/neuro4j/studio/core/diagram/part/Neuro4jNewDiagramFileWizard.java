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

import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;

/**
 * @generated
 */
public class Neuro4jNewDiagramFileWizard extends Wizard {

    /**
     * @generated
     */
    private WizardNewFileCreationPage myFileCreationPage;

    /**
     * @generated
     */
    private ModelElementSelectionPage diagramRootElementSelectionPage;

    /**
     * @generated
     */
    private TransactionalEditingDomain myEditingDomain;

    /**
     * @generated
     */
    public Neuro4jNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot,
            TransactionalEditingDomain editingDomain) {
        assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
        assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
        assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

        myFileCreationPage = new WizardNewFileCreationPage(
                Messages.Neuro4jNewDiagramFileWizard_CreationPageName,
                StructuredSelection.EMPTY);
        myFileCreationPage
                .setTitle(Messages.Neuro4jNewDiagramFileWizard_CreationPageTitle);
        myFileCreationPage.setDescription(NLS.bind(
                Messages.Neuro4jNewDiagramFileWizard_CreationPageDescription,
                NetworkEditPart.MODEL_ID));
        IPath filePath;
        String fileName = URI.decode(domainModelURI.trimFileExtension()
                .lastSegment());
        if (domainModelURI.isPlatformResource()) {
            filePath = new Path(domainModelURI.trimSegments(1)
                    .toPlatformString(true));
        } else if (domainModelURI.isFile()) {
            filePath = new Path(domainModelURI.trimSegments(1).toFileString());
        } else {
            // TODO : use some default path
            throw new IllegalArgumentException(
                    "Unsupported URI: " + domainModelURI); //$NON-NLS-1$
        }
        myFileCreationPage.setContainerFullPath(filePath);
        myFileCreationPage.setFileName(Neuro4jDiagramEditorUtil
                .getUniqueFileName(filePath, fileName, "neuro4j_diagram")); //$NON-NLS-1$

        diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(
                Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageName);
        diagramRootElementSelectionPage
                .setTitle(Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageTitle);
        diagramRootElementSelectionPage
                .setDescription(Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageDescription);
        diagramRootElementSelectionPage.setModelElement(diagramRoot);

        myEditingDomain = editingDomain;
    }

    /**
     * @generated
     */
    public void addPages() {
        addPage(myFileCreationPage);
        addPage(diagramRootElementSelectionPage);
    }

    /**
     * @generated
     */
    public boolean performFinish() {
        LinkedList<IFile> affectedFiles = new LinkedList<IFile>();
        IFile diagramFile = myFileCreationPage.createNewFile();
        Neuro4jDiagramEditorUtil.setCharset(diagramFile);
        affectedFiles.add(diagramFile);
        URI diagramModelURI = URI.createPlatformResourceURI(diagramFile
                .getFullPath().toString(), true);
        ResourceSet resourceSet = myEditingDomain.getResourceSet();
        final Resource diagramResource = resourceSet
                .createResource(diagramModelURI);
        AbstractTransactionalCommand command = new AbstractTransactionalCommand(
                myEditingDomain,
                Messages.Neuro4jNewDiagramFileWizard_InitDiagramCommand,
                affectedFiles) {

            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                int diagramVID = Neuro4jVisualIDRegistry
                        .getDiagramVisualID(diagramRootElementSelectionPage
                                .getModelElement());
                if (diagramVID != NetworkEditPart.VISUAL_ID) {
                    return CommandResult
                            .newErrorCommandResult(Messages.Neuro4jNewDiagramFileWizard_IncorrectRootError);
                }
                Diagram diagram = ViewService.createDiagram(
                        diagramRootElementSelectionPage.getModelElement(),
                        NetworkEditPart.MODEL_ID,
                        Neuro4jDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
                diagramResource.getContents().add(diagram);
                diagramResource.getContents().add(diagram.getElement());
                return CommandResult.newOKCommandResult();
            }
        };
        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new NullProgressMonitor(), null);
            diagramResource.save(Neuro4jDiagramEditorUtil.getSaveOptions());
            Neuro4jDiagramEditorUtil.openDiagram(diagramResource);
        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
        } catch (IOException ex) {
            Neuro4jDiagramEditorPlugin.getInstance().logError(
                    "Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
        } catch (PartInitException ex) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * @generated
     */
    private static class DiagramRootElementSelectionPage extends
            ModelElementSelectionPage {

        /**
         * @generated
         */
        protected DiagramRootElementSelectionPage(String pageName) {
            super(pageName);
        }

        /**
         * @generated
         */
        protected String getSelectionTitle() {
            return Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageSelectionTitle;
        }

        /**
         * @generated
         */
        protected boolean validatePage() {
            if (selectedModelElement == null) {
                setErrorMessage(Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
                return false;
            }
            boolean result = ViewService
                    .getInstance()
                    .provides(
                            new CreateDiagramViewOperation(
                                    new EObjectAdapter(selectedModelElement),
                                    NetworkEditPart.MODEL_ID,
                                    Neuro4jDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
            setErrorMessage(result ? null
                    : Messages.Neuro4jNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
            return result;
        }
    }
}
