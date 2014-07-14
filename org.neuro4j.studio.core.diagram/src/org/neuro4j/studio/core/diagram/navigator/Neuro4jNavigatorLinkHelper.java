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
package org.neuro4j.studio.core.diagram.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class Neuro4jNavigatorLinkHelper implements ILinkHelper {

    /**
     * @generated
     */
    private static IEditorInput getEditorInput(Diagram diagram) {
        Resource diagramResource = diagram.eResource();
        for (EObject nextEObject : diagramResource.getContents()) {
            if (nextEObject == diagram) {
                return new FileEditorInput(
                        WorkspaceSynchronizer.getFile(diagramResource));
            }
            if (nextEObject instanceof Diagram) {
                break;
            }
        }
        URI uri = EcoreUtil.getURI(diagram);
        String editorName = uri.lastSegment() + '#'
                + diagram.eResource().getContents().indexOf(diagram);
        IEditorInput editorInput = new URIEditorInput(uri, editorName);
        return editorInput;
    }

    /**
     * @generated
     */
    public IStructuredSelection findSelection(IEditorInput anInput) {
        IDiagramDocument document = Neuro4jDiagramEditorPlugin.getInstance()
                .getDocumentProvider().getDiagramDocument(anInput);
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
    public void activateEditor(IWorkbenchPage aPage,
            IStructuredSelection aSelection) {
        if (aSelection == null || aSelection.isEmpty()) {
            return;
        }
        if (false == aSelection.getFirstElement() instanceof Neuro4jAbstractNavigatorItem) {
            return;
        }

        Neuro4jAbstractNavigatorItem abstractNavigatorItem = (Neuro4jAbstractNavigatorItem) aSelection
                .getFirstElement();
        View navigatorView = null;
        if (abstractNavigatorItem instanceof Neuro4jNavigatorItem) {
            navigatorView = ((Neuro4jNavigatorItem) abstractNavigatorItem)
                    .getView();
        } else if (abstractNavigatorItem instanceof Neuro4jNavigatorGroup) {
            Neuro4jNavigatorGroup navigatorGroup = (Neuro4jNavigatorGroup) abstractNavigatorItem;
            if (navigatorGroup.getParent() instanceof Neuro4jNavigatorItem) {
                navigatorView = ((Neuro4jNavigatorItem) navigatorGroup
                        .getParent()).getView();
            }
        }
        if (navigatorView == null) {
            return;
        }
        IEditorInput editorInput = getEditorInput(navigatorView.getDiagram());
        IEditorPart editor = aPage.findEditor(editorInput);
        if (editor == null) {
            return;
        }
        aPage.bringToTop(editor);
        if (editor instanceof DiagramEditor) {
            DiagramEditor diagramEditor = (DiagramEditor) editor;
            ResourceSet diagramEditorResourceSet = diagramEditor
                    .getEditingDomain().getResourceSet();
            EObject selectedView = diagramEditorResourceSet.getEObject(
                    EcoreUtil.getURI(navigatorView), true);
            if (selectedView == null) {
                return;
            }
            GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
                    .getAdapter(GraphicalViewer.class);
            EditPart selectedEditPart = (EditPart) graphicalViewer
                    .getEditPartRegistry().get(selectedView);
            if (selectedEditPart != null) {
                graphicalViewer.select(selectedEditPart);
            }
        }
    }

}
