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
package org.neuro4j.studio.core.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorInput7CreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorInputReorientCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorOutput10CreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorOutputReorientCommand;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeFalseOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeMainInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeDecisionNodeTrueOutputCompartmentEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput10EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput3EditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class DecisionNodeItemSemanticEditPolicy extends
        Neuro4jBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public DecisionNodeItemSemanticEditPolicy() {
        super(Neuro4jElementTypes.DecisionNode_2007);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
                getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
            Edge incomingLink = (Edge) it.next();
            if (Neuro4jVisualIDRegistry.getVisualID(incomingLink) == OperatorOutput10EditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(
                        incomingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
                continue;
            }
        }
        for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
            Edge outgoingLink = (Edge) it.next();
            if (Neuro4jVisualIDRegistry.getVisualID(outgoingLink) == OperatorInput7EditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(
                        outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
            if (Neuro4jVisualIDRegistry.getVisualID(outgoingLink) == OperatorOutput10EditPart.VISUAL_ID) {
                DestroyElementRequest r = new DestroyElementRequest(
                        outgoingLink.getElement(), false);
                cmd.add(new DestroyElementCommand(r));
                cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
                continue;
            }
        }
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyChildNodesCommand(cmd);
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    /**
     * @generated
     */
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (Neuro4jVisualIDRegistry.getVisualID(node)) {
                case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
                    for (Iterator<?> cit = node.getChildren().iterator(); cit
                            .hasNext();) {
                        Node cnode = (Node) cit.next();
                        switch (Neuro4jVisualIDRegistry.getVisualID(cnode)) {
                            case OperatorInput2EditPart.VISUAL_ID:
                                cmd.add(new DestroyElementCommand(
                                        new DestroyElementRequest(getEditingDomain(),
                                                cnode.getElement(), false))); // directlyOwned: true
                                // don't need explicit deletion of cnode as parent's view deletion would clean child
                                // views as well
                                // cmd.add(new
                                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                                // cnode));
                                break;
                        }
                    }
                    break;
                case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
                    for (Iterator<?> cit = node.getChildren().iterator(); cit
                            .hasNext();) {
                        Node cnode = (Node) cit.next();
                        switch (Neuro4jVisualIDRegistry.getVisualID(cnode)) {
                            case OperatorOutput2EditPart.VISUAL_ID:
                                for (Iterator<?> it = cnode.getTargetEdges().iterator(); it
                                        .hasNext();) {
                                    Edge incomingLink = (Edge) it.next();
                                    if (Neuro4jVisualIDRegistry
                                            .getVisualID(incomingLink) == OperatorInput7EditPart.VISUAL_ID) {
                                        DestroyElementRequest r = new DestroyElementRequest(
                                                incomingLink.getElement(), false);
                                        cmd.add(new DestroyElementCommand(r));
                                        cmd.add(new DeleteCommand(getEditingDomain(),
                                                incomingLink));
                                        continue;
                                    }
                                }
                                cmd.add(new DestroyElementCommand(
                                        new DestroyElementRequest(getEditingDomain(),
                                                cnode.getElement(), false))); // directlyOwned: true
                                // don't need explicit deletion of cnode as parent's view deletion would clean child
                                // views as well
                                // cmd.add(new
                                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                                // cnode));
                                break;
                        }
                    }
                    break;
                case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
                    for (Iterator<?> cit = node.getChildren().iterator(); cit
                            .hasNext();) {
                        Node cnode = (Node) cit.next();
                        switch (Neuro4jVisualIDRegistry.getVisualID(cnode)) {
                            case OperatorOutput3EditPart.VISUAL_ID:
                                for (Iterator<?> it = cnode.getTargetEdges().iterator(); it
                                        .hasNext();) {
                                    Edge incomingLink = (Edge) it.next();
                                    if (Neuro4jVisualIDRegistry
                                            .getVisualID(incomingLink) == OperatorInput7EditPart.VISUAL_ID) {
                                        DestroyElementRequest r = new DestroyElementRequest(
                                                incomingLink.getElement(), false);
                                        cmd.add(new DestroyElementCommand(r));
                                        cmd.add(new DeleteCommand(getEditingDomain(),
                                                incomingLink));
                                        continue;
                                    }
                                }
                                cmd.add(new DestroyElementCommand(
                                        new DestroyElementRequest(getEditingDomain(),
                                                cnode.getElement(), false))); // directlyOwned: true
                                // don't need explicit deletion of cnode as parent's view deletion would clean child
                                // views as well
                                // cmd.add(new
                                // org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
                                // cnode));
                                break;
                        }
                    }
                    break;
            }
        }
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
                : getCompleteCreateRelationshipCommand(req);
        return command != null ? command : super
                .getCreateRelationshipCommand(req);
    }

    /**
     * @generated
     */
    protected Command getStartCreateRelationshipCommand(
            CreateRelationshipRequest req) {
        if (Neuro4jElementTypes.OperatorInput_4009 == req.getElementType()) {
            return getGEFWrapper(new OperatorInput7CreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        if (Neuro4jElementTypes.OperatorOutput_4008 == req.getElementType()) {
            return getGEFWrapper(new OperatorOutput10CreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(
            CreateRelationshipRequest req) {
        if (Neuro4jElementTypes.OperatorInput_4009 == req.getElementType()) {
            return null;
        }
        if (Neuro4jElementTypes.OperatorOutput_4008 == req.getElementType()) {
            return getGEFWrapper(new OperatorOutput10CreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        return null;
    }

    /**
     * Returns command to reorient EClass based link. New link target or source
     * should be the domain model element associated with this node.
     * 
     * @generated
     */
    protected Command getReorientRelationshipCommand(
            ReorientRelationshipRequest req) {
        switch (getVisualID(req)) {
            case OperatorInput7EditPart.VISUAL_ID:
                return getGEFWrapper(new OperatorInputReorientCommand(req));
            case OperatorOutput10EditPart.VISUAL_ID:
                return getGEFWrapper(new OperatorOutputReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
