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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;

public class SelectedListEntryProvider {

    private ListEntry entry;
    private DiagramEditPart diagramEditPart;

    private boolean availableForInsert = false;

    private static SelectedListEntryProvider instance = new SelectedListEntryProvider();

    private SelectedListEntryProvider() {
        super();

    }

    public static SelectedListEntryProvider getInstance()
    {
        return instance;
    }

    public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
        this.diagramEditPart = diagramEditPart;
    }

    public ListEntry getEntry() {
        return entry;
    }

    public void setEntry(ListEntry entry) {
        this.entry = entry;
    }

    public boolean isAvailableForInsert() {
        return availableForInsert;
    }

    public void setAvailableForInsert(boolean availableForInsert) {
        this.availableForInsert = availableForInsert;
        if (!availableForInsert)
        {
            this.entry = null;
        }
    }

    public void createObject(int x, int y)
    {
        if (availableForInsert && this.entry != null)
        {
            availableForInsert = false;
            switch (this.entry.getType()) {

                case CUSTOM_BLOCK:

                    CreateUnspecifiedTypeRequest request = new
                            CreateUnspecifiedTypeRequest(
                                    Collections.singletonList(Neuro4jElementTypes.LogicNode_2017),
                                    diagramEditPart.getDiagramPreferencesHint());

                    request.setLocation(new Point(x, y));
                    Command command = diagramEditPart.getCommand(request);
                    command.execute();
                    List newObject = (List) request.getNewObject();
                    ViewAndElementDescriptor desc = (ViewAndElementDescriptor) newObject.get(0);
                    ShapeImpl shape =   (ShapeImpl) desc.getAdapter(ShapeImpl.class);
                    LogicNode lNode = (LogicNode) shape.getElement();
                    updateCustomBlock(lNode, this.entry);
                    break;
                    
                case CHILD:
                    if (entry.getParent().getType() != ListEntryType.FLOW )
                    {
                        return;
                    }
                    request = new
                            CreateUnspecifiedTypeRequest(
                                    Collections.singletonList(Neuro4jElementTypes.CallNode_2008),
                                    diagramEditPart.getDiagramPreferencesHint());

                    request.setLocation(new Point(x, y));
                    command = diagramEditPart.getCommand(request);
                    command.execute();
                     newObject = (List) request.getNewObject();
                    desc = (ViewAndElementDescriptor) newObject.get(0);
                    shape =   (ShapeImpl) desc.getAdapter(ShapeImpl.class);
                    CallNode cNode = (CallNode) shape.getElement();
                                                  
                    updateCallBlock(cNode, entry);
                    
                    break;

                default:
                    break;
            }
            this.entry = null;
        }
    }
    

    
    private void updateCustomBlock(final LogicNode node, final ListEntry entry) {

        final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramEditPart.getModel());

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Update customBlock",
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                String className = entry.getMessage();
                className = className.substring(className.lastIndexOf(".") + 1);        
                node.setName(className);
                node.setClassName(entry.getMessage());
                updateIcon(node);
                
                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new SubProgressMonitor(new NullProgressMonitor(), 1), null);
        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to update customBlock", e); //$NON-NLS-1$
        }
    }
    
    private void updateCallBlock(final CallNode node, final ListEntry entry) {

        final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramEditPart.getModel());

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Update CallNode",
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                
                String startNode = entry.getMessage();
                ListEntry parent = entry.getParent();
                String callFlow = parent.getMessage() + "-" + startNode;
                node.setName(callFlow.substring(callFlow.lastIndexOf("-") + 1));
                node.setFlowName(callFlow);
                
                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new SubProgressMonitor(new NullProgressMonitor(), 1), null);
        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to update customBlock", e); //$NON-NLS-1$
        }
    }
    
    private void updateIcon(EObject element)
    {
        String className = entry.getMessage();

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
