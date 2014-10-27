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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.search.LogicClassNameLoader;

public class LogicNodeClassNamePropertyDescriptor extends PropertyDescriptor {

    private LogicNode node;

    public LogicNodeClassNamePropertyDescriptor(LogicNode node, String id, String displayName) {
        super(id, displayName);
        this.node = node;
    }

    @Override
    public CellEditor createPropertyEditor(Composite parent) {

        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {

                // Dialog creation
                ElementListSelectionDialog dialog = new ElementListSelectionDialog(
                        PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                        getLabelProvider());

                dialog.setTitle("Available  blocks");

                dialog.setMultipleSelection(false);
                List<ListEntry> list = LogicClassNameLoader.getInstance().getClasses(ClassloaderHelper.getActiveProjectName());

                dialog.setElements(list.toArray(new ListEntry[list.size()]));

                // Open the dialog and retrieve the user selection
                int result = dialog.open();
                labelProvider.dispose();
                if (dialog.getResult() != null)
                {
                    updateIcon(node, Arrays.asList(dialog.getResult()));
                }
                if (result == Window.OK)
                {
                    Object[] array = (Object[]) dialog.getResult();
                    if (array != null && array.length > 0)
                    {
                        ListEntry selectedEntry =  (ListEntry)array[0];
                        List<String> l = new ArrayList<String>(1);
                        l.add(selectedEntry.getMessage());
                        return l;                        
                    }

                }
                return  null;
            }
        };
    }

    private void updateIcon(EObject element, List<Object> list)
    {
        String className = null;
        if (list.size() == 1)
        {
            ListEntry entry = (ListEntry) list.get(0); 
            className = entry.getMessage();
        }
        IEditorPart editorPart = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {

            DiagramEditPart diagramPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
            List<EditPart> editPartCollector = new ArrayList<EditPart>();

            Neuro4jDiagramEditorUtil.findElementsInDiagramByID(diagramPart, element, editPartCollector);

            if (editPartCollector.size() > 0)
            {
                LogicNodeEditPart editpart = (LogicNodeEditPart) editPartCollector.get(0);

                editpart.updateImageForClass(className);

            }
            // editPartCollector

        }
    }

}
