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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.markers.MarkerMng;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.ResourceFinder;

public class SetBreakPoinAction implements IObjectActionDelegate {

    protected ShapeNodeEditPart selectedElement;

    @SuppressWarnings("restriction")
    public void run(IAction action) {

        if (selectedElement != null)
        {

            ShapeImpl shape = (ShapeImpl) selectedElement.getModel();

            ActionNode node = (ActionNode) shape.getElement();

            if (!BreakpoinMng.getInstance().hasClassInClasspath(BreakpoinMng.DEBUGSERV_STRING))
            {
                org.neuro4j.studio.core.buildpath.ExceptionHandler.handle("Debug Configuration Error", node.getLogicImplementationClassName() + " not found in classpath. Please add Neuro4j library to classpath.");
                return;
            } else {
              //  BreakpoinMng.getInstance().loadBaseBreakpointsIfNotLoaded();
            }

            MarkerMng.getInstance().registerEditPart(node.getId(), selectedElement);

            JavaLineBreakpoint javaLineBreakpoint = BreakpoinMng.getInstance().getExistingBreakPoint();
            if (javaLineBreakpoint == null)
            {
                javaLineBreakpoint = BreakpoinMng.getInstance().createBreakPoint();
            }
            BreakpoinMng.getInstance().addUuidToBreakpoint(javaLineBreakpoint, node);
            MarkerMng.getInstance().updateMarker(javaLineBreakpoint.getMarker());
            BreakpoinMng.getInstance().updateFigure(node, true);

            ResourceFinder.getInstance().registerNode((IFile) ClassloaderHelper.getCurrentResource(), node);

        }

    }

    public void selectionChanged(IAction action, ISelection selection) {
        selectedElement = null;
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            if (structuredSelection.getFirstElement() instanceof ShapeNodeEditPart) {
                selectedElement = (ShapeNodeEditPart) structuredSelection.getFirstElement();
            }
        }
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {

    }

}
