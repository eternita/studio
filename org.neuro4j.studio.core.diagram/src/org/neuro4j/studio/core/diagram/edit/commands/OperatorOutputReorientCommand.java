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
package org.neuro4j.studio.core.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.policies.Neuro4jBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class OperatorOutputReorientCommand extends EditElementCommand {

    /**
     * @generated
     */
    private final int reorientDirection;

    /**
     * @generated
     */
    private final EObject oldEnd;

    /**
     * @generated
     */
    private final EObject newEnd;

    /**
     * @generated
     */
    public OperatorOutputReorientCommand(ReorientRelationshipRequest request) {
        super(request.getLabel(), request.getRelationship(), request);
        reorientDirection = request.getDirection();
        oldEnd = request.getOldRelationshipEnd();
        newEnd = request.getNewRelationshipEnd();
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (false == getElementToEdit() instanceof OperatorOutput) {
            return false;
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return canReorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return canReorientTarget();
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean canReorientSource() {
        if (!(oldEnd instanceof ActionNode && newEnd instanceof ActionNode)) {
            return false;
        }
        ActionNode target = getLink().getTarget();
        return Neuro4jBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperatorOutput_4008(getLink(), getNewSource(), target);
    }

    /**
     * @generated
     */
    protected boolean canReorientTarget() {
        if (!(oldEnd instanceof ActionNode && newEnd instanceof ActionNode)) {
            return false;
        }
        if (!(getLink().eContainer() instanceof ActionNode)) {
            return false;
        }
        ActionNode source = (ActionNode) getLink().eContainer();
        return Neuro4jBaseItemSemanticEditPolicy.getLinkConstraints()
                .canExistOperatorOutput_4008(getLink(), source, getNewTarget());
    }

    /**
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
            return reorientSource();
        }
        if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
            return reorientTarget();
        }
        throw new IllegalStateException();
    }

    /**
     * @generated
     */
    protected CommandResult reorientSource() throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    /**
     * @generated
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        getLink().setTarget(getNewTarget());
        return CommandResult.newOKCommandResult(getLink());
    }

    /**
     * @generated
     */
    protected OperatorOutput getLink() {
        return (OperatorOutput) getElementToEdit();
    }

    /**
     * @generated
     */
    protected ActionNode getOldSource() {
        return (ActionNode) oldEnd;
    }

    /**
     * @generated
     */
    protected ActionNode getNewSource() {
        return (ActionNode) newEnd;
    }

    /**
     * @generated
     */
    protected ActionNode getOldTarget() {
        return (ActionNode) oldEnd;
    }

    /**
     * @generated
     */
    protected ActionNode getNewTarget() {
        return (ActionNode) newEnd;
    }
}
