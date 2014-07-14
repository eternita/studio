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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.NetworkTypesEnum;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.part.Messages;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.diagram.part.Neuro4jDocumentProvider;
import org.neuro4j.studio.core.util.ClassloaderHelper;

public class Neuro2DocumentProvider extends Neuro4jDocumentProvider {

    protected void setDocumentContent(final IDocument document,
            IEditorInput element) throws CoreException {

        IDiagramDocument diagramDocument = (IDiagramDocument) document;
        TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
        if (element instanceof FileEditorInput) {
            IStorage storage = ((FileEditorInput) element).getStorage();
            IResource res = ((FileEditorInput) element).getFile();
            ClassloaderHelper.setCurrentResource(res);

            // Diagram diagram = DiagramIOUtil.load(domain, storage, true,
            // getProgressMonitor());
            // document.setContent(diagram);

            getDiagram(document, domain, storage);

        } else if (element instanceof URIEditorInput) {
            URI uri = ((URIEditorInput) element).getURI();
            Resource resource = null;
            try {
                resource = domain.getResourceSet().getResource(
                        uri.trimFragment(), false);
                if (resource == null) {
                    resource = domain.getResourceSet().createResource(
                            uri.trimFragment());
                }
                if (!resource.isLoaded()) {
                    try {
                        Map options = new HashMap(
                                GMFResourceFactory.getDefaultLoadOptions());
                        // @see 171060
                        // options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
                        // Boolean.TRUE);
                        resource.load(options);
                    } catch (IOException e) {
                        resource.unload();
                        throw e;
                    }
                }
                if (uri.fragment() != null) {
                    EObject rootElement = resource.getEObject(uri.fragment());
                    if (rootElement instanceof Diagram) {
                        document.setContent((Diagram) rootElement);
                        return;
                    }
                } else {
                    for (Iterator it = resource.getContents().iterator(); it
                            .hasNext();) {
                        Object rootElement = it.next();
                        if (rootElement instanceof Diagram) {
                            document.setContent((Diagram) rootElement);
                            return;
                        }
                    }
                }
                throw new RuntimeException(
                        Messages.Neuro4jDocumentProvider_NoDiagramInResourceError);
            } catch (Exception e) {
                CoreException thrownExcp = null;
                if (e instanceof CoreException) {
                    thrownExcp = (CoreException) e;
                } else {
                    String msg = e.getLocalizedMessage();
                    thrownExcp = new CoreException(
                            new Status(
                                    IStatus.ERROR,
                                    Neuro4jDiagramEditorPlugin.ID,
                                    0,
                                    msg != null ? msg
                                            : Messages.Neuro4jDocumentProvider_DiagramLoadingError,
                                    e));
                }
                throw thrownExcp;
            }
        } else {
            throw new CoreException(
                    new Status(
                            IStatus.ERROR,
                            Neuro4jDiagramEditorPlugin.ID,
                            0,
                            NLS.bind(
                                    Messages.Neuro4jDocumentProvider_IncorrectInputError,
                                    new Object[] {
                                            element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
                            null));
        }

    }

    private void getDiagram(final IDocument document,
            final TransactionalEditingDomain domain, final IStorage storage) {

        final Network model = Neuro4jDiagramEditorUtil.createInitialModel();
        model.setType(NetworkTypesEnum.FLOW);

        final Diagram diagram = createDiagram(model, new NullProgressMonitor());

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(
                domain,
                Messages.Neuro4jDiagramEditorUtil_CreateDiagramCommandLabel,
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                URI uri = URI.createPlatformResourceURI(storage.getFullPath()
                        .toString(), true);

                Resource resource1 = domain.getResourceSet().getResource(uri, false);
                if (resource1 == null) {
                    resource1 = domain.getResourceSet().createResource(uri);
                }

                if (!resource1.isLoaded()) {

                    InputStream inputStream = null;
                    try {
                        inputStream = storage.getContents();
                    } catch (CoreException e) {
                        try {
                            ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, monitor);
                            try {
                                inputStream = storage.getContents();
                            } catch (CoreException e2) {
                                // TODO Auto-generated catch block
                                e2.printStackTrace();
                            }
                        } catch (CoreException e1) {

                        }
                    }
                    Map<Object, Object> options = new HashMap<Object, Object>();

                    options.put(Network.DEFAULT_NAME, model);

                    try {

                        resource1.load(inputStream, options);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    Neuro4jDiagramEditorUtil
                            .attachModelToResource(model, resource1);

                    if (diagram != null) {

                        EObject[] objects = (EObject[]) resource1.getContents().toArray();
                        for (EObject eobj : objects) {
                            if (eobj instanceof Node)
                            {
                                model.getRootAction().add((ActionNode) eobj);

                            }

                        }
                        resource1.getContents().add(diagram);
                        diagram.setName(uri.lastSegment());
                        diagram.setElement(model);

                        document.setContent(diagram);
                    }
                }
                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    null, null);
            OperationHistoryFactory.getOperationHistory().execute(getCreateNoteCommand(model.getNotes(), diagram, domain),
                    null, null);
            OperationHistoryFactory.getOperationHistory().execute(getUpdateNoteCommand(diagram, diagram, domain, model.getNotes()),
                    null, null);

        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
        }
    }

    public Diagram createDiagram(final Network model,
            IProgressMonitor progressMonitor) {
        TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
                .createEditingDomain();
        progressMonitor.beginTask(
                Messages.Neuro4jDiagramEditorUtil_CreateDiagramProgressTask, 3);
        final DiagramAdapter diagramAdapter = new DiagramAdapter();

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(
                editingDomain,
                Messages.Neuro4jDiagramEditorUtil_CreateDiagramCommandLabel,
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                Diagram diagram = ViewService.createDiagram(model,
                        NetworkEditPart.MODEL_ID,
                        Neuro4jDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
                if (diagram != null) {

                    diagram.setElement(model);
                }
                diagramAdapter.setDiagram(diagram);

                return CommandResult.newOKCommandResult();
            }
        };
        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new SubProgressMonitor(progressMonitor, 1), null);
        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
        }

        return diagramAdapter.getDiagram();
    }

    protected CompositeTransactionalCommand getUpdateNoteCommand(
            Diagram diagram, View view, TransactionalEditingDomain editingDomain, List<NoteNode> notes2) {

        List<ShapeImpl> notes = diagram.getPersistedChildren();
        CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
                editingDomain, DiagramUIMessages.AddCommand_Label);
        int index = 0;
        for (ShapeImpl shape : notes) {
            NoteNode note = notes2.get(index);

            IAdaptable elementAdapter = new EObjectAdapter(shape);
            SetPropertyCommand cpc = new SetPropertyCommand(editingDomain,
                    elementAdapter, Properties.ID_DESCRIPTION, ViewType.TEXT,
                    note.getDescription());
            cc.compose(cpc);
            cpc = new SetPropertyCommand(editingDomain,
                    elementAdapter, Properties.ID_FILLCOLOR, "Fill Color",
                    13369343);
            cc.compose(cpc);
            Rectangle bounds = new Rectangle();
            bounds.setX(note.getX());
            bounds.setY(note.getY());
            bounds.setWidth(note.getWidth());
            bounds.setHeight(note.getHeight());

            SetBoundsCommand sb = new SetBoundsCommand(editingDomain, "Set Location or Size", elementAdapter, bounds);
            cc.compose(sb);
            index++;
        }
        return cc;

    }

    protected CompositeTransactionalCommand getCreateNoteCommand(List<NoteNode> list, View view, TransactionalEditingDomain editingDomain) {

        // CreateViewRequest request

        CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
                editingDomain, DiagramUIMessages.AddCommand_Label);

        IElementType NOTE = ElementTypeRegistry.getInstance().getType("org.eclipse.gmf.runtime.diagram.ui.presentation.note");

        for (NoteNode note : list) {
            CreateViewRequest createNoteRequest = CreateViewRequestFactory
                    .getCreateShapeRequest(NOTE, PreferencesHint.USE_DEFAULTS);

            Iterator descriptors = createNoteRequest.getViewDescriptors()
                    .iterator();

            while (descriptors.hasNext()) {
                CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptors
                        .next();

                CreateCommand createCommand = new CreateCommand(editingDomain,
                        descriptor, view);

                cc.compose(createCommand);
            }

        }

        return cc;

    }

    @Override
    protected void doSaveDocument(IProgressMonitor monitor, Object element,
            IDocument document, boolean overwrite) throws CoreException {
        // TODO Auto-generated method stub
        // ValidateAction.runValidation((View) document.getContent());

        super.doSaveDocument(monitor, element, document, overwrite);
    }

    private class DiagramAdapter {

        Diagram diagram = null;

        public Diagram getDiagram()
        {
            return diagram;
        }

        public void setDiagram(Diagram d) {
            this.diagram = d;
        }
    }

}
