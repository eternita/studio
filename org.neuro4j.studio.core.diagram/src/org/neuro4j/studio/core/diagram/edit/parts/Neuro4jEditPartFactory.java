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
package org.neuro4j.studio.core.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

/**
 * @generated
 */
public class Neuro4jEditPartFactory implements EditPartFactory {

    /**
     * @generated
     */
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            if (view.getType().equals("Note"))
            {
                return new MyNoteEditPart(view);
            }
            switch (Neuro4jVisualIDRegistry.getVisualID(view)) {

                case NetworkEditPart.VISUAL_ID:
                    return new NetworkEditPart(view);

                case DecisionNodeEditPart.VISUAL_ID:
                    return new DecisionNodeEditPart(view);

                case DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID:
                    return new DecisionNodeCompKeyOperatorDecisionEditPart(view);

                case FollowByRelationNodeEditPart.VISUAL_ID:
                    return new FollowByRelationNodeEditPart(view);

                case FollowByRelationNodeNameEditPart.VISUAL_ID:
                    return new FollowByRelationNodeNameEditPart(view);

                case LoopNodeEditPart.VISUAL_ID:
                    return new LoopNodeEditPart(view);

                case LoopNodeLabelEditPart.VISUAL_ID:
                    return new LoopNodeLabelEditPart(view);

                case CallNodeEditPart.VISUAL_ID:
                    return new CallNodeEditPart(view);

                case CallNodeDynamicFlowNameFlowNameEditPart.VISUAL_ID:
                    return new CallNodeDynamicFlowNameFlowNameEditPart(view);

                case EndNodeEditPart.VISUAL_ID:
                    return new EndNodeEditPart(view);

                case EndNodeNameEditPart.VISUAL_ID:
                    return new EndNodeNameEditPart(view);

                case MapperNodeEditPart.VISUAL_ID:
                    return new MapperNodeEditPart(view);

                case OperatorOutputEditPart.VISUAL_ID:
                    return new OperatorOutputEditPart(view);

                case LogicNodeEditPart.VISUAL_ID:
                    return new LogicNodeEditPart(view);

                case LogicNodeNameEditPart.VISUAL_ID:
                    return new LogicNodeNameEditPart(view);

                case OperatorInputEditPart.VISUAL_ID:
                    return new OperatorInputEditPart(view);

                case JoinNodeEditPart.VISUAL_ID:

                    if (view.getElement() instanceof StandardNodeImpl)
                    {
                        // TODO:
                        return new StandardNodeEditPart(view);
                    }

                    return new JoinNodeEditPart(view);
                case StandardNodeEditPart.VISUAL_ID:

                    return new StandardNodeEditPart(view);
                case StandardNodeRelationEditPart.VISUAL_ID:

                    return new StandardNodeRelationEditPart(view);
                case StartNodeEditPart.VISUAL_ID:
                    return new StartNodeEditPart(view);

                case StartNodeNameEditPart.VISUAL_ID:
                    return new StartNodeNameEditPart(view);

                case ViewNodeEditPart.VISUAL_ID:
                    return new ViewNodeEditPart(view);

                case ViewNodeViewNameDynamicViewNameEditPart.VISUAL_ID:
                    return new ViewNodeViewNameDynamicViewNameEditPart(view);

                case OperatorInput2EditPart.VISUAL_ID:
                    return new OperatorInput2EditPart(view);

                case OperatorOutput2EditPart.VISUAL_ID:
                    return new OperatorOutput2EditPart(view);

                case OperatorOutput3EditPart.VISUAL_ID:
                    return new OperatorOutput3EditPart(view);

                case OperatorInput3EditPart.VISUAL_ID:
                    return new OperatorInput3EditPart(view);

                case OperatorInput4EditPart.VISUAL_ID:
                    return new OperatorInput4EditPart(view);

                case OperatorOutput4EditPart.VISUAL_ID:
                    return new OperatorOutput4EditPart(view);

                case OperatorOutput5EditPart.VISUAL_ID:
                    return new OperatorOutput5EditPart(view);

                case OperatorInput5EditPart.VISUAL_ID:
                    return new OperatorInput5EditPart(view);

                case OperatorOutput6EditPart.VISUAL_ID:
                    return new OperatorOutput6EditPart(view);

                case OperatorOutput7EditPart.VISUAL_ID:
                    return new OperatorOutput7EditPart(view);

                case OperatorOutput8EditPart.VISUAL_ID:
                    return new OperatorOutput8EditPart(view);

                case OperatorOutput9EditPart.VISUAL_ID:
                    return new OperatorOutput9EditPart(view);

                case DecisionNodeDecisionNodeMainInputEditPart.VISUAL_ID:
                    return new DecisionNodeDecisionNodeMainInputEditPart(view);

                case DecisionNodeDecisionNodeFalseOutputCompartmentEditPart.VISUAL_ID:
                    return new DecisionNodeDecisionNodeFalseOutputCompartmentEditPart(
                            view);

                case DecisionNodeDecisionNodeTrueOutputCompartmentEditPart.VISUAL_ID:
                    return new DecisionNodeDecisionNodeTrueOutputCompartmentEditPart(
                            view);

                case LoopNodeLoopNodeLoopInputCompartmentEditPart.VISUAL_ID:
                    return new LoopNodeLoopNodeLoopInputCompartmentEditPart(view);

                case LoopNodeLoopNodeMainInputCompartmentEditPart.VISUAL_ID:
                    return new LoopNodeLoopNodeMainInputCompartmentEditPart(view);

                case LoopNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                    return new LoopNodeLogicNodeMainOutputCompartmentEditPart(view);

                case LoopNodeLoopNodeLoopOutputCompartmentEditPart.VISUAL_ID:
                    return new LoopNodeLoopNodeLoopOutputCompartmentEditPart(view);

                case LogicNodeLogicNodeMainInputEditPart.VISUAL_ID:
                    return new LogicNodeLogicNodeMainInputEditPart(view);

                case LogicNodeLogicNodeMainOutputCompartmentEditPart.VISUAL_ID:
                    return new LogicNodeLogicNodeMainOutputCompartmentEditPart(view);

                case LogicNodeLogicNodeErrorOutputCompartmentEditPart.VISUAL_ID:
                    return new LogicNodeLogicNodeErrorOutputCompartmentEditPart(
                            view);

                case JoinNodeJoinNodeMainOutputCompartmentEditPart.VISUAL_ID:
                    return new JoinNodeJoinNodeMainOutputCompartmentEditPart(view);

                case StartNodeStartNodeMainOutputCompartmentEditPart.VISUAL_ID:
                    return new StartNodeStartNodeMainOutputCompartmentEditPart(view);

                case OperatorInput7EditPart.VISUAL_ID:
                    return new OperatorInput7EditPart(view);

                case OperatorOutput10EditPart.VISUAL_ID:
                    if (((OperatorOutputImpl) view.getElement()).eContainer() instanceof StandardNodeImpl)
                    {
                        return new OperatorOutputStandardEditPart(view);
                    } else {
                        return new OperatorOutput10EditPart(view);
                    }

                case OperatorOutputNameEditPart.VISUAL_ID:
                    return new OperatorOutputNameEditPart(view);

            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * @generated
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

    /**
     * @generated
     */
    public static CellEditorLocator getTextCellEditorLocator(
            ITextAwareEditPart source) {
        return CellEditorLocatorAccess.INSTANCE
                .getTextCellEditorLocator(source);
    }

}
