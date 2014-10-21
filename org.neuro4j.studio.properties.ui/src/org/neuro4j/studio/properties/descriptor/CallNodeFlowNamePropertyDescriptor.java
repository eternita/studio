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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.neuro4j.studio.core.views.dialogs.FlowResourcesSelectionDialog;


public class CallNodeFlowNamePropertyDescriptor extends PropertyDescriptor {

    public CallNodeFlowNamePropertyDescriptor(Object id, String displayName) {
        super(id, displayName);
    }

    @Override
    public CellEditor createPropertyEditor(Composite parent) {
        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {

                FlowResourcesSelectionDialog dialog = new FlowResourcesSelectionDialog(
                        PlatformUI.getWorkbench().getDisplay().getActiveShell(), false,
                        ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);

                dialog.setTitle("Available  flows");
                dialog.setResourceFilter("n4j");
                dialog.setPathFilter("/");

                int result = dialog.open();
                labelProvider.dispose();
                return result == Window.OK ? Arrays.asList(dialog.getResult())
                        : null;
            }
        };
    }

}
