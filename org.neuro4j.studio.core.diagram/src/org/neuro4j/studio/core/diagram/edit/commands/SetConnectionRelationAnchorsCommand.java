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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.relation.ActionNodeRelationProcessorFactory;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public class SetConnectionRelationAnchorsCommand extends SetConnectionAnchorsCommand {

    private ActionNode source;
    private ActionNode target;

    public SetConnectionRelationAnchorsCommand(
            TransactionalEditingDomain editingDomain, String label) {
        super(editingDomain, label);

    }

    protected CommandResult doExecuteWithResult(
            IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {

        assert null != getEdgeAdaptor() : "Null child in SetConnectionAnchorsCommand";//$NON-NLS-1$		

        Edge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);
        assert null != edge : "Null edge in SetConnectionAnchorsCommand";//$NON-NLS-1$		

      //  setNewSourceTerminal("SOUTH");
        
        if (getNewSourceTerminal() != null) {
            if (getNewSourceTerminal().length() == 0)
                edge.setSourceAnchor(null);
            else {
                IdentityAnchor a = (IdentityAnchor) edge.getSourceAnchor();
                if (a == null)
                    a = NotationFactory.eINSTANCE.createIdentityAnchor();
                a.setId(getNewSourceTerminal());
                edge.setSourceAnchor(a);
            }
        }
        if (getNewTargetTerminal() != null) {
            if (getNewTargetTerminal().length() == 0)
                edge.setTargetAnchor(null);
            else {
                IdentityAnchor a = (IdentityAnchor) edge.getTargetAnchor();
                if (a == null)
                    a = NotationFactory.eINSTANCE.createIdentityAnchor();
                a.setId(getNewTargetTerminal());
                edge.setTargetAnchor(a);
            }

        }
        if (!updateOutputs(edge)) {
            return CommandResult.newCancelledCommandResult();
        }
        return CommandResult.newOKCommandResult();
    }

    private boolean updateOutputs(Edge edge) {
        OperatorOutputImpl operatorOutput = (OperatorOutputImpl) edge.getElement();
        if (operatorOutput == null) {
            return false;
        }

        ActionNode source = (ActionNode) operatorOutput.eContainer();

        String sourceTerminal = getNewSourceTerminal();
        String targetTerminal = getNewTargetTerminal();
        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory.getInstance().createProcessor(source);

        boolean result = actionRelationProcessor.processOutpuNode(source, sourceTerminal, operatorOutput.getTarget(), targetTerminal, operatorOutput);
        if (result == false)
        {
            return false;
        }

        // doConfigure(operatorOutput, monitor, info);
        source.getOutput().add(operatorOutput);
        operatorOutput.setTarget(operatorOutput.getTarget());

        return true;
    }

}
