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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.neuro4j.studio.core.diagram.edit.commands.OperatorOutput8CreateCommand;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class JoinNodeJoinNodeMainOutputCompartmentItemSemanticEditPolicy extends
        Neuro4jBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public JoinNodeJoinNodeMainOutputCompartmentItemSemanticEditPolicy() {
        super(Neuro4jElementTypes.JoinNode_2002);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (Neuro4jElementTypes.OperatorOutput_3012 == req.getElementType()) {
            return getGEFWrapper(new OperatorOutput8CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
