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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.neuro4j.studio.core.diagram.edit.commands.CallNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.DecisionNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.EndNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.FollowByRelationNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.JoinNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.LogicNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.LoopNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.MapperNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorInputCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorOutputCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.StandardNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.StartNodeCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.ViewNodeCreateCommand;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class NetworkItemSemanticEditPolicy extends
        Neuro4jBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public NetworkItemSemanticEditPolicy() {
        super(Neuro4jElementTypes.Network_1000);
    }

    /**
     * @generated NOT
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (Neuro4jElementTypes.DecisionNode_2007 == req.getElementType()) {
            return getGEFWrapper(new DecisionNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.FollowByRelationNode_2011 == req
                .getElementType()) {
            return getGEFWrapper(new FollowByRelationNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.LoopNode_2006 == req.getElementType()) {
            return getGEFWrapper(new LoopNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.CallNode_2008 == req.getElementType()) {
            return getGEFWrapper(new CallNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.EndNode_2005 == req.getElementType()) {
            return getGEFWrapper(new EndNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.MapperNode_2010 == req.getElementType()) {
            return getGEFWrapper(new MapperNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.OperatorOutput_2016 == req.getElementType()) {
            return getGEFWrapper(new OperatorOutputCreateCommand(req));
        }
        if (Neuro4jElementTypes.LogicNode_2017 == req.getElementType()) {
            return getGEFWrapper(new LogicNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.OperatorInput_2013 == req.getElementType()) {
            return getGEFWrapper(new OperatorInputCreateCommand(req));
        }
        if (Neuro4jElementTypes.JoinNode_2002 == req.getElementType()) {
            return getGEFWrapper(new JoinNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.StandardNode_2019 == req.getElementType()) {
            return getGEFWrapper(new StandardNodeCreateCommand(req, 0));
        }
        if (Neuro4jElementTypes.StandardNodeRelation_2020 == req.getElementType()) {
            return getGEFWrapper(new StandardNodeCreateCommand(req, 1));
        }
        if (Neuro4jElementTypes.StartNode_2004 == req.getElementType()) {
            return getGEFWrapper(new StartNodeCreateCommand(req));
        }
        if (Neuro4jElementTypes.ViewNode_2018 == req.getElementType()) {
            return getGEFWrapper(new ViewNodeCreateCommand(req));
        }

        if (Neuro4jElementTypes.OperatorOutput_4008 == req.getElementType()) {
            return getGEFWrapper(new OperatorOutputCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
                .getEditingDomain();
        return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
    }

    /**
     * @generated
     */
    private static class DuplicateAnythingCommand extends
            DuplicateEObjectsCommand {

        /**
         * @generated
         */
        public DuplicateAnythingCommand(
                TransactionalEditingDomain editingDomain,
                DuplicateElementsRequest req) {
            super(editingDomain, req.getLabel(), req
                    .getElementsToBeDuplicated(), req
                    .getAllDuplicatedElementsMap());
        }

    }

}
