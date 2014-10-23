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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.editparts.PaletteEditPart;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.neuro4j.studio.core.diagram.navigator.Neuro4jNavigatorItem;
import org.neuro4j.studio.core.diagram.providers.SelectedConnectionProvider;

/**
 * @generated
 */
public class Neuro4jDiagramEditor extends DiagramDocumentEditor implements
        IGotoMarker {

    /**
     * @generated
     */
    public static final String ID = "org.neuro4j.studio.flow.diagram.part.Neuro4jDiagramEditorID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final String CONTEXT_ID = "org.neuro4j.studio.core.diagram.ui.diagramContext"; //$NON-NLS-1$

    /**
     * @generated
     */
    public Neuro4jDiagramEditor() {
        super(true);

    }
    
    

    /**
     * @generated
     */
    protected String getContextID() {
        return CONTEXT_ID;
    }

    /**
     * @generated
     */
    protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
        PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
        fillPalette(root);
               
        return root;
    }

    protected void fillPalette(PaletteRoot root)
    {
        new Neuro4jPaletteFactory().fillPalette(root);

    }

    /**
     * @generated
     */
    protected PreferencesHint getPreferencesHint() {
        return Neuro4jDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
    }

    /**
     * @generated
     */
    public String getContributorId() {
        return Neuro4jDiagramEditorPlugin.ID;
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class type) {
        if (type == IShowInTargetList.class) {
            return new IShowInTargetList() {
                public String[] getShowInTargetIds() {
                    return new String[] { ProjectExplorer.VIEW_ID };
                }
            };
        }
        return super.getAdapter(type);
    }

    /**
     * @generated
     */
    protected IDocumentProvider getDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput
                || input instanceof URIEditorInput) {
            return Neuro4jDiagramEditorPlugin.getInstance()
                    .getDocumentProvider();
        }
        return super.getDocumentProvider(input);
    }

    /**
     * @generated
     */
    public TransactionalEditingDomain getEditingDomain() {
        IDocument document = getEditorInput() != null ? getDocumentProvider()
                .getDocument(getEditorInput()) : null;
        if (document instanceof IDiagramDocument) {
            return ((IDiagramDocument) document).getEditingDomain();
        }
        return super.getEditingDomain();
    }

    /**
     * @generated
     */
    protected void setDocumentProvider(IEditorInput input) {
        if (input instanceof IFileEditorInput
                || input instanceof URIEditorInput) {
            setDocumentProvider(Neuro4jDiagramEditorPlugin.getInstance()
                    .getDocumentProvider());
        } else {
            super.setDocumentProvider(input);
        }
    }

    /**
     * @generated
     */
    public void gotoMarker(IMarker marker) {
        MarkerNavigationService.getInstance().gotoMarker(this, marker);
    }

    /**
     * @generated
     */
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * @generated
     */
    public void doSaveAs() {
        performSaveAs(new NullProgressMonitor());
    }

    /**
     * @generated
     */
    protected void performSaveAs(IProgressMonitor progressMonitor) {
        Shell shell = getSite().getShell();
        IEditorInput input = getEditorInput();
        SaveAsDialog dialog = new SaveAsDialog(shell);
        IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input)
                .getFile() : null;
        if (original != null) {
            dialog.setOriginalFile(original);
        }
        dialog.create();
        IDocumentProvider provider = getDocumentProvider();
        if (provider == null) {
            // editor has been programmatically closed while the dialog was open
            return;
        }
        if (provider.isDeleted(input) && original != null) {
            String message = NLS.bind(
                    Messages.Neuro4jDiagramEditor_SavingDeletedFile,
                    original.getName());
            dialog.setErrorMessage(null);
            dialog.setMessage(message, IMessageProvider.WARNING);
        }
        if (dialog.open() == Window.CANCEL) {
            if (progressMonitor != null) {
                progressMonitor.setCanceled(true);
            }
            return;
        }
        IPath filePath = dialog.getResult();
        if (filePath == null) {
            if (progressMonitor != null) {
                progressMonitor.setCanceled(true);
            }
            return;
        }
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IFile file = workspaceRoot.getFile(filePath);
        final IEditorInput newInput = new FileEditorInput(file);
        // Check if the editor is already open
        IEditorMatchingStrategy matchingStrategy = getEditorDescriptor()
                .getEditorMatchingStrategy();
        IEditorReference[] editorRefs = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage()
                .getEditorReferences();
        for (int i = 0; i < editorRefs.length; i++) {
            if (matchingStrategy.matches(editorRefs[i], newInput)) {
                MessageDialog.openWarning(shell,
                        Messages.Neuro4jDiagramEditor_SaveAsErrorTitle,
                        Messages.Neuro4jDiagramEditor_SaveAsErrorMessage);
                return;
            }
        }
        boolean success = false;
        try {
            provider.aboutToChange(newInput);
            getDocumentProvider(newInput).saveDocument(progressMonitor,
                    newInput,
                    getDocumentProvider().getDocument(getEditorInput()), true);
            success = true;
        } catch (CoreException x) {
            IStatus status = x.getStatus();
            if (status == null || status.getSeverity() != IStatus.CANCEL) {
                ErrorDialog.openError(shell,
                        Messages.Neuro4jDiagramEditor_SaveErrorTitle,
                        Messages.Neuro4jDiagramEditor_SaveErrorMessage,
                        x.getStatus());
            }
        } finally {
            provider.changed(newInput);
            if (success) {
                setInput(newInput);
            }
        }
        if (progressMonitor != null) {
            progressMonitor.setCanceled(!success);
        }
    }

    /**
     * @generated
     */
    public ShowInContext getShowInContext() {
        return new ShowInContext(getEditorInput(), getNavigatorSelection());
    }

    /**
     * @generated
     */
    protected ISelection getNavigatorSelection() {
        IDiagramDocument document = getDiagramDocument();
        if (document == null) {
            return StructuredSelection.EMPTY;
        }
        Diagram diagram = document.getDiagram();
        if (diagram == null || diagram.eResource() == null) {
            return StructuredSelection.EMPTY;
        }
        IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
        if (file != null) {
            Neuro4jNavigatorItem item = new Neuro4jNavigatorItem(diagram, file,
                    false);
            return new StructuredSelection(item);
        }
        return StructuredSelection.EMPTY;
    }

    /**
     * @generated
     */
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(
                this, getDiagramGraphicalViewer());
        getDiagramGraphicalViewer().setContextMenu(provider);
        getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU,
                provider, getDiagramGraphicalViewer());

        getPaletteViewerProvider().getEditDomain().getPaletteViewer().addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent arg0) {

                org.eclipse.jface.viewers.StructuredSelection ep = (org.eclipse.jface.viewers.StructuredSelection) arg0.getSelection();
                PaletteEditPart f = (PaletteEditPart) ep.getFirstElement();
                if (f.getModel() instanceof ToolEntry)
                {
                    ToolEntry e = (ToolEntry) f.getModel();
                    if (isValidForInsert(e))
                    {
                        SelectedConnectionProvider.getInstance().setAvailableForInsert(true);
                    } else {
                        SelectedConnectionProvider.getInstance().setAvailableForInsert(false);
                    }
                }

            }
        });

        // DiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();
        // Layer printableLayers = (Layer)root.getLayer(LayerConstants.PRINTABLE_LAYERS);
        // Layer gridLayer = (Layer)root.getLayer(LayerConstants.GRID_LAYER);
        //
        // if (printableLayers != null && gridLayer != null){
        // LayeredPane paneForPrintable = (LayeredPane)printableLayers.getParent();
        // LayeredPane paneForGrid = (LayeredPane)gridLayer.getParent();
        // if (paneForGrid == paneForPrintable) {
        // paneForGrid.removeLayer(LayerConstants.GRID_LAYER);
        // paneForGrid.addLayerBefore(gridLayer, LayerConstants.GRID_LAYER, LayerConstants.PRINTABLE_LAYERS);
        // }
        // }
    }

    private boolean isValidForInsert(ToolEntry e)
    {
        if (e.getLabel().startsWith("Decision") || e.getLabel().startsWith("Call") || e.getLabel().startsWith("Custom") || e.getLabel().startsWith("Join") || e.getLabel().startsWith("Mapper") || e.getLabel().startsWith("Loop") || e.getLabel().startsWith("Switch"))
        {
            return true;
        }

        return false;
    }

}
