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
package org.neuro4j.studio.core.diagram.providers;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;

/**
 * @generated
 */
public class Neuro4jMarkerNavigationProvider extends
        AbstractModelMarkerNavigationProvider {

    /**
     * @generated
     */
    public static final String MARKER_TYPE = Neuro4jDiagramEditorPlugin.ID
            + ".diagnostic"; //$NON-NLS-1$

    /**
     * @generated
     */
    protected void doGotoMarker(IMarker marker) {
        String elementId = marker
                .getAttribute(
                        org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID,
                        null);
        if (elementId == null || !(getEditor() instanceof DiagramEditor)) {
            return;
        }
        DiagramEditor editor = (DiagramEditor) getEditor();
        Map editPartRegistry = editor.getDiagramGraphicalViewer()
                .getEditPartRegistry();
        EObject targetView = editor.getDiagram().eResource()
                .getEObject(elementId);
        if (targetView == null) {
            return;
        }
        EditPart targetEditPart = (EditPart) editPartRegistry.get(targetView);
        if (targetEditPart != null) {
            Neuro4jDiagramEditorUtil.selectElementsInDiagram(editor,
                    Arrays.asList(new EditPart[] { targetEditPart }));
        }
    }

    /**
     * @generated
     */
    public static void deleteMarkers(IResource resource) {
        try {
            resource.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
        } catch (CoreException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Failed to delete validation markers", e); //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    public static IMarker addMarker(IFile file, String elementId,
            String location, String message, int statusSeverity) {
        IMarker marker = null;
        try {
            marker = file.createMarker(MARKER_TYPE);
            marker.setAttribute(IMarker.MESSAGE, message);
            marker.setAttribute(IMarker.LOCATION, location);
            marker.setAttribute(
                    org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
                    elementId);
            int markerSeverity = IMarker.SEVERITY_INFO;
            if (statusSeverity == IStatus.WARNING) {
                markerSeverity = IMarker.SEVERITY_WARNING;
            } else if (statusSeverity == IStatus.ERROR
                    || statusSeverity == IStatus.CANCEL) {
                markerSeverity = IMarker.SEVERITY_ERROR;
            }
            marker.setAttribute(IMarker.SEVERITY, markerSeverity);
        } catch (CoreException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Failed to create validation marker", e); //$NON-NLS-1$
        }
        return marker;
    }
}
