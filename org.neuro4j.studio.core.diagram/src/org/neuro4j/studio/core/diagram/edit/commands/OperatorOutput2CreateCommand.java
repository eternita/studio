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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.OperatorOutput;

/**
 * @generated
 */
public class OperatorOutput2CreateCommand extends EditElementCommand {

    /**
     * @generated
     */
    public OperatorOutput2CreateCommand(CreateElementRequest req) {
        super(req.getLabel(), null, req);
    }

    /**
     * FIXME: replace with setElementToEdit()
     * 
     * @generated
     */
    protected EObject getElementToEdit() {
        EObject container = ((CreateElementRequest) getRequest())
                .getContainer();
        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }

    /**
     * @generated NOT
     */
    public boolean canExecute() {
        DecisionNode container = (DecisionNode) getElementToEdit();
        if (container.getMainFalseOutput() != null) {
            return false;
        }
        return true;

    }

    /**
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
        OperatorOutput newElement = Neuro4jFactory.eINSTANCE
                .createOperatorOutput();

        ActionNode owner = (ActionNode) getElementToEdit();
        owner.getOutput().add(newElement);
        DecisionNode childHolder = (DecisionNode) getElementToEdit();
        childHolder.setMainFalseOutput(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
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
        ICommand configureCommand = elementType
                .getEditCommand(configureRequest);
        if (configureCommand != null && configureCommand.canExecute()) {
            configureCommand.execute(monitor, info);
        }
    }

}
