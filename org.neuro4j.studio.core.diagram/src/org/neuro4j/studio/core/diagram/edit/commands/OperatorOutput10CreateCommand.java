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

import java.text.MessageFormat;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.diagram.edit.policies.Neuro4jBaseItemSemanticEditPolicy;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;

/**
 * @generated
 */
public class OperatorOutput10CreateCommand extends EditElementCommand {

    // private ActionNodeRelationProcessorFactory actionRelationProcessorFactory = new
    // ActionNodeRelationProcessorFactory();
    /**
     * @generated
     */
    private final EObject source;

    /**
     * @generated
     */
    private final EObject target;

    /**
     * @generated
     */
    public OperatorOutput10CreateCommand(CreateRelationshipRequest request,
            EObject source, EObject target) {
        super(request.getLabel(), null, request);
        this.source = source;
        this.target = target;
    }

    protected String getDefaultLabel() {

        String label = MessageFormat.format(
                EMFTypeCoreMessages.Request_Label_Create,
                new Object[] { "NEXT" });

        return label;
    }

    /**
     * @generated
     */
    public boolean canExecute() {
        if (source == null && target == null) {
            return false;
        }
        if (source != null && false == source instanceof ActionNode) {
            return false;
        }
        if (target != null && false == target instanceof ActionNode) {
            return false;
        }
        if (getSource() == null) {
            return true; // link creation is in progress; source is not defined yet
        }
        // target may be null here but it's possible to check constraint
        return Neuro4jBaseItemSemanticEditPolicy.getLinkConstraints()
                .canCreateOperatorOutput_4008(getSource(), getTarget());
    }

    /**
     * @generated NOT
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
        if (!canExecute()) {
            throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
        }

        if (!doValidate()) {
            return CommandResult
                    .newErrorCommandResult("Error during adding connection");
        }

        ActionNode sourceObj = getSource();

        OperatorOutputImpl operatorOutput = (OperatorOutputImpl) Neuro4jFactory.eINSTANCE
                .createOperatorOutput();
        // ActionRelationProcessor actionRelationProcessor =
        // ActionNodeRelationProcessorFactory.getInstance().createProcessor(sourceObj);

        if (operatorOutput != null) {
            doConfigure(operatorOutput, monitor, info);
            // operatorOutput.setContainer((InternalEObject)sourceObj);
            sourceObj.getOutput().add(operatorOutput);
            // sourceObj.getOutput().remove(operatorOutput);
            operatorOutput.setTarget(getTarget());

            return CommandResult.newOKCommandResult(operatorOutput);
        } else {
            return CommandResult
                    .newErrorCommandResult("Error during adding connection");
        }

        // if (actionRelationProcessor.processOutpuNode(sourceObj, getTarget(),
        // operatorOutput)) {
        // doConfigure(operatorOutput, monitor, info);
        // sourceObj.getOutput().add(operatorOutput);
        // operatorOutput.setTarget(getTarget());
        //
        // return CommandResult.newOKCommandResult(operatorOutput);
        // } else {
        // return CommandResult
        // .newErrorCommandResult("Error during adding connection");
        // }
        //
        // ((CreateElementRequest) getRequest()).setNewElement(newElement);

    }

    private boolean doValidate() {
        if (getSource() instanceof EndNode) {
            return false;
        }
        if (getSource() instanceof ViewNode) {
            return false;
        }
        if (getTarget() instanceof StartNode) {
            return false;
        }
        if (getSource().equals(getTarget())) {
            return false;
        }

        return true;
    }

    /**
     * @generated
     */
    protected void doConfigure(OperatorOutput newElement,
            IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {
        IElementType elementType = ((CreateElementRequest) getRequest())
                .getElementType();
        ConfigureRequest configureRequest = new ConfigureRequest(
                getEditingDomain(), newElement, elementType);
        configureRequest.setClientContext(((CreateElementRequest) getRequest())
                .getClientContext());
        configureRequest.addParameters(getRequest().getParameters());
        configureRequest.setParameter(CreateRelationshipRequest.SOURCE,
                getSource());
        configureRequest.setParameter(CreateRelationshipRequest.TARGET,
                getTarget());
        ICommand configureCommand = elementType
                .getEditCommand(configureRequest);
        if (configureCommand != null && configureCommand.canExecute()) {
            configureCommand.execute(monitor, info);
        }
    }

    /**
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * @generated
     */
    protected ActionNode getSource() {
        return (ActionNode) source;
    }

    /**
     * @generated
     */
    protected ActionNode getTarget() {
        return (ActionNode) target;
    }

}
