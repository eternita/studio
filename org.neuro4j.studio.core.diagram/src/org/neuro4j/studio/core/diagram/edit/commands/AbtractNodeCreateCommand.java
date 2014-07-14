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

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput10EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput10EditPart.OperatorOutputSourceFigure;
import org.neuro4j.studio.core.diagram.providers.SelectedConnectionProvider;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.relation.ActionNodeRelationProcessorFactory;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public abstract class AbtractNodeCreateCommand extends EditElementCommand {

    protected AbtractNodeCreateCommand(String label, EObject elementToEdit,
            IEditCommandRequest request) {
        super(label, elementToEdit, request);
    }

    public void reorderConnections(ActionNode mediator)
    {
        MouseEvent event = SelectedConnectionProvider.getInstance().getEvent();
        if (event != null)
        {
            OperatorOutputSourceFigure operatorOutputSourceFigure = (OperatorOutputSourceFigure) event.getSource();
            OperatorOutput10EditPart operatorOutput10EditPart = operatorOutputSourceFigure.getEditPart();

            ConnectorImpl model = (ConnectorImpl) operatorOutput10EditPart.getModel();
            OperatorOutputImpl oo = (OperatorOutputImpl) model.getElement();

            if (oo == null)
            {
                return;
            }

            ActionNode target = oo.getTarget();

            oo.setTarget(mediator);

            OperatorOutput secondConnection = Neuro4jFactory.eINSTANCE
                    .createOperatorOutput();

            ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory
                    .getInstance().createProcessor(mediator);

            if (actionRelationProcessor.processOutpuNode(mediator, target,
                    secondConnection)) {
                mediator.getOutput().add(secondConnection);
                secondConnection.setTarget(target);
            }

        }

    }

}
