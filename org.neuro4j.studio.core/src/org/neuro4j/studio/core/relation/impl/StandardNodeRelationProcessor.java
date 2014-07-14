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
package org.neuro4j.studio.core.relation.impl;

import org.eclipse.emf.common.util.EList;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.impl.OperatorInputImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

public class StandardNodeRelationProcessor extends JoinNodeRelationProcessor {

    @Override
    public boolean processOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output) {
        StandardNodeImpl sourceNode = (StandardNodeImpl) source;

        StandardNodeImpl targetNode = (StandardNodeImpl) target;
        if (sourceNode != null && targetNode != null)
        {
            if (targetNode.getType() == 1 && sourceNode.getType() == 1)
            {
                return false;
            }
        }

        if (targetNode.getType() == 1)
        {
            EList<OperatorInput> inputs = targetNode.getInput();
            OperatorInput input = new OperatorInputImpl();
            input.setId(targetNode.getId());
            input.setNode(source);
            inputs.add(input);
        }
        targetNode.update();

        EList<OperatorOutput> list = sourceNode.getOutput();

        // If source or target is circle relation - set the same id and name for this relation
        if (sourceNode.isCircleRelation())
        {

        } else if (targetNode.isCircleRelation())
        {


            output.setId(targetNode.getId());
        }
        sourceNode.update();
        list.add(output);

        return true;

    }

    @Override
    public boolean updateOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output, String oldValue, String newValue) {
        JoinNode node = (JoinNode) source;
        if (null == newValue)
        {
            node.setMainOutput(null);
        }
        return false;
    }

}
