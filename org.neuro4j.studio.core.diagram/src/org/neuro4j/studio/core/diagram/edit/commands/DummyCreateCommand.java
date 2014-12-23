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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.StandardNode;

public class DummyCreateCommand extends JoinNodeCreateCommand {

    /**
     * @generated
     */
    public DummyCreateCommand(CreateElementRequest req) {
        super(req);
    }

    public DummyCreateCommand(CreateRelationshipRequest req,
            EObject source, EObject target) {
        super(req);

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
     * @generated
     */
    public boolean canExecute() {
        return true;

    }

    /**
     * @generated NOT
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {

        return CommandResult.newOKCommandResult();
    }

    /**
     * @generated
     */
    protected void doConfigure(StandardNode newElement, IProgressMonitor monitor,
            IAdaptable info) throws ExecutionException {
    }

}
