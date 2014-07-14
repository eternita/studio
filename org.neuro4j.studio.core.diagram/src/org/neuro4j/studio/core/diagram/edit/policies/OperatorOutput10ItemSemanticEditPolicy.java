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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.commands.DummyCreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorInput7CreateCommand;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorInputReorientCommand;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput7EditPart;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

/**
 * @generated
 */
public class OperatorOutput10ItemSemanticEditPolicy extends
        Neuro4jBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public OperatorOutput10ItemSemanticEditPolicy() {
        super(Neuro4jElementTypes.OperatorOutput_4008);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {

        OperatorOutputImpl el = (OperatorOutputImpl) req.getElementToDestroy();
        Node target = (Node) el.getTarget();
        if (target != null)
        {
            target.update();
        }
        Node source = (Node) el.eContainer();
        if (source != null)
        {
            source.update();
        }

        el.setPropertySource(null);

        return getGEFWrapper(new DestroyElementCommand(req));
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
            return null;
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getCompleteCreateRelationshipCommand(
            CreateRelationshipRequest req) {
        if (Neuro4jElementTypes.OperatorInput_4009 == req.getElementType()) {
            return getGEFWrapper(new OperatorInput7CreateCommand(req,
                    req.getSource(), req.getTarget()));
        }
        if (Neuro4jElementTypes.OperatorOutput_4008 == req.getElementType() && req.getSource() instanceof StandardNodeImpl && req.getTarget() instanceof OperatorOutput)
        {
            return getGEFWrapper(createRelationCommand(req));
        } else if (Neuro4jElementTypes.OperatorOutput_4008 == req.getElementType()) {
            return getGEFWrapper(createRelationCommand(req));
        }

        return null;
    }

    private CompositeCommand createRelationCommand(CreateRelationshipRequest req)
    {
        CompositeCommand cmd = new CompositeCommand("create circle relation");

        DummyCreateCommand cm1 = new DummyCreateCommand(req);

        cm1.setLabel("Dummy command");

        // OperatorOutput10CreateCommand op = new OperatorOutput10CreateCommand(req, req.getSource(), req.getTarget());

        cmd.compose(cm1);
        // cmd.compose(op);

        return cmd;
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
        }
        return super.getReorientRelationshipCommand(req);
    }

}
