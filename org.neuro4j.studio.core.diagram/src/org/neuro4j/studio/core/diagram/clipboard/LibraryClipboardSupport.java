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
package org.neuro4j.studio.core.diagram.clipboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.clipboard.core.AbstractClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteAction;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.impl.DecorationNodeImpl;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.part.Messages;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditor;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.impl.NodeImpl;

public class LibraryClipboardSupport extends AbstractClipboardSupport {

    Set<NodeImpl> lastSelectedNodes = new HashSet<NodeImpl>();

    public LibraryClipboardSupport() {
        super();
    }

    /**
     * Provide a mapping of name attributes for the EClasses of the Library
     * metamodel.
     */
    protected EAttribute getNameAttribute(EClass eClass) {
        EAttribute result;

        // switch (eClass.getClassifierID()) {
        // case Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT:
        // return null;
        // case Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT:
        // return null;
        // case Neuro4jPackage.DECISION_NODE__MAIN_INPUT:
        // return null;
        // case Neuro4jPackage.DECISION_NODE__OPERATOR:
        // return Neuro4jPackage.eINSTANCE.getDecisionNode_Operator();
        // case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
        // return Neuro4jPackage.eINSTANCE.getDecisionNode_CompType();
        // case Neuro4jPackage.DECISION_NODE__COMP_KEY:
        // return Neuro4jPackage.eINSTANCE.getDecisionNode_CompKey();
        // case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
        // return Neuro4jPackage.eINSTANCE.getDecisionNode_DecisionKey();
        // default:
        // result = null;
        // break;
        // }

        return null;
    }

    /**
     * Merge an author into an existing author of the same name when pasting.
     */
    public PasteAction getPasteCollisionAction(EClass eClass) {

        return super.getPasteCollisionAction(eClass);
    }

    public void sendCreateNotification(EObject eObject) {
        if (!lastSelectedNodes.isEmpty())
        {
            // ShapeImpl shape = (ShapeImpl)eObject;
            // ActionNode actionNode = (ActionNode)shape.getElement();

            Network net = getActiveNetwork();

            Iterator<NodeImpl> nodes = lastSelectedNodes.iterator();
            Map<String, ActionNode> map = new HashMap<String, ActionNode>();
            while (nodes.hasNext())
            {
                NodeImpl node = nodes.next();
                if (node instanceof ActionNodeImpl)
                {
                    ActionNode cloneNode = ((ActionNodeImpl) node).createPasteClone(net);
                    if (cloneNode != null)
                    {
                        map.put(node.getId(), cloneNode);

                        // addNode(net, cloneNode);
                    }
                }

            }

            nodes = lastSelectedNodes.iterator();

            while (nodes.hasNext())
            {
                NodeImpl node = nodes.next();
                if (node instanceof ActionNodeImpl)
                {
                    ActionNodeImpl an = (ActionNodeImpl) node;

                    List<OperatorOutput> outputs = an.getOutput();
                    for (OperatorOutput out : outputs)
                    {
                        ActionNode target = out.getTarget();
                        if (map.containsKey(target.getId()))
                        {
                            OperatorOutput newoutPut = out.cloneForPast(map.get(target.getId()));
                            ActionNode clonedSourceNode = map.get(an.getId());
                            clonedSourceNode.getOutput().add(newoutPut);

                        }
                    }
                }
            }

            for (ActionNode a : map.values())
            {
                addNode(net, a);
            }

            lastSelectedNodes.clear();

        }

    }

    private void addNode(final Network net, final ActionNode node) {

        final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(net);

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, Messages.Neuro4jDiagramEditorUtil_CreateDiagramCommandLabel,
                Collections.EMPTY_LIST) {
            protected CommandResult doExecuteWithResult(
                    IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {

                net.addNode(node);

                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command,
                    new SubProgressMonitor(new NullProgressMonitor(), 1), null);
        } catch (ExecutionException e) {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
        }
    }

    private static Network getActiveNetwork() {

        IWorkbench iworkbench = PlatformUI.getWorkbench();
        if (iworkbench != null) {
            IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
            if (iworkbenchwindow != null) {
                IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
                if (iworkbenchpage != null) {
                    Neuro4jDiagramEditor ieditorpart = (Neuro4jDiagramEditor) iworkbenchpage.getActiveEditor();
                    IDiagramGraphicalViewer view = ieditorpart.getDiagramGraphicalViewer();
                    EditPart part = view.getFocusEditPart();
                    DiagramImpl diagram = (DiagramImpl) part.getModel();
                    return (Network) diagram.getElement();

                }
            }
        }
        return null;
    }

    /**
     * We always copy an author's books.
     */
    public boolean isCopyAlways(EObject context, EReference eReference,
            Object value) {
        if (context instanceof ShapeImpl)
        {
            ShapeImpl shape = (ShapeImpl) context;
            if (shape.getElement() instanceof NodeImpl)
            {
                lastSelectedNodes.add((NodeImpl) shape.getElement());
            }

            // lastSelectedNode = (ActionNode) context;
        } else if (context instanceof DecorationNodeImpl) {

        }

        // if (eReference == LibraryPackage.eINSTANCE.getWriter_Books()) {
        // return true;
        // } else {
        return super.isCopyAlways(context, eReference, value);
        // return true;
        // }
    }
}