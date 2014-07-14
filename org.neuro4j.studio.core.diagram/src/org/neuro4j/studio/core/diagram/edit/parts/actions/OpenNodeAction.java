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
package org.neuro4j.studio.core.diagram.edit.parts.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.ide.IDE;

public abstract class OpenNodeAction implements IObjectActionDelegate {

    public final static String ID = "org.neuro4j.studio.core.diagram.edit.parts.actions.CallNodeOpenAction1";

    protected ShapeNodeEditPart selectedElement;

    public void run(IAction action) {

        String name = getStringParameter();
        if (name == null || "".equals(name.trim()))
        {
            return;
        }
        searchFile(name);
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

    protected void openResource(final IFile file) {

        final IWorkbenchPage activePage = JavaPlugin.getActivePage();
        if (activePage != null) {
            Display.getCurrent().asyncExec(new Runnable() {
                public void run() {
                    try {
                        IDE.openEditor(activePage, file, true);
                    } catch (PartInitException e) {
                        JavaPlugin.log(e);
                    }
                }
            });
        }
    }

    private void searchFile(String name)
    {
        FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(
                PlatformUI.getWorkbench().getDisplay().getActiveShell(), false,
                ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);

        dialog.setTitle(getTitle());
        dialog.setInitialPattern(getResourcePattern(name));
        int result = dialog.open();
        if (result == Window.OK) {
            Object[] files = dialog.getResult();
            if (files != null && files.length == 1)
            {
                if (files[0] instanceof IFile)
                {
                    IFile file = (IFile) files[0];
                    openResource(file);
                }

            }
        }

    }

    protected abstract String getResourcePattern(String name);

    protected abstract String getTitle();

    protected abstract String getStringParameter();

}
