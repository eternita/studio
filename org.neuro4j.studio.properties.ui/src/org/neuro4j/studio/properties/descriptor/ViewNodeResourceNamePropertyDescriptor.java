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
package org.neuro4j.studio.properties.descriptor;

import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.properties.sources.providers.ViewNodeRenderLoader;
import org.neuro4j.studio.properties.ui.celleditor.ViewResourceSelectionDialog;
import org.neuro4j.web.logic.render.ViewNodeRenderEngineDefinition;

public class ViewNodeResourceNamePropertyDescriptor extends PropertyDescriptor {

    private ViewNode viewNode = null;

    public ViewNodeResourceNamePropertyDescriptor(ViewNode object, Object id, String displayName) {
        super(id, displayName);
        viewNode = object;
    }

    @Override
    public CellEditor createPropertyEditor(Composite parent) {

        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {

                ViewResourceSelectionDialog dialog = new ViewResourceSelectionDialog(
                        PlatformUI.getWorkbench().getDisplay().getActiveShell(), false,
                        ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);

                String projectName = getProjectName();

                dialog.setTitle("Available resources");

                ViewNodeRenderEngineDefinition renderDefinition = ViewNodeRenderLoader.getInstance().getRenderDefinitionByName(ClassloaderHelper.getActiveProjectName(), viewNode.getRenderType());
                dialog.setResourceFilter(renderDefinition.getFileExt());
                dialog.setPathFilter(projectName + renderDefinition.getPathFilter());
                int result = dialog.open();
                labelProvider.dispose();
                return result == Window.OK ? Arrays.asList(dialog.getResult())
                        : null;
            }
        };
    }

    private String getProjectName()
    {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window =
                workbench == null ? null : workbench.getActiveWorkbenchWindow();
        IWorkbenchPage activePage =
                window == null ? null : window.getActivePage();

        IEditorPart editor =
                activePage == null ? null : activePage.getActiveEditor();
        IEditorInput input =
                editor == null ? null : editor.getEditorInput();
        String name = input instanceof FileEditorInput
                ? ((FileEditorInput) input).getFile().getProject().getName()
                : null;
        return name;

    }

}
