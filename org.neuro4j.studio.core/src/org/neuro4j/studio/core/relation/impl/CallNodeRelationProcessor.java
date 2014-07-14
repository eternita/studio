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

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.neuro4j.workflow.xml.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.impl.CallNodeImpl;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;
import org.neuro4j.studio.core.util.OutputNamesUtils;

public class CallNodeRelationProcessor extends ActionRelationProcessor {

    @Override
    protected void processOutpuNode(ActionNodeImpl source, WorkflowNode entity, OperatorOutput output, XmlTransition relation) {
        processOutpuNode(source, null, output);
    }

    @Override
    public boolean processOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output) {

        CallNodeImpl node = (CallNodeImpl) source;
        Set<String> usedNames = node.getUsedOutputNames();

        if (output.getName() != null)
        {
            usedNames.add(output.getName());

        } else {
            String[] candidateNames = OutputNamesUtils.getRelationsNames(node);
            for (String candidateName : candidateNames)
            {
                if (!usedNames.contains(candidateName))
                {
                    usedNames.add(candidateName);
                    output.setName(candidateName);
                    break;
                }
            }

        }
        if (output.getName() == null)
        {
            return false;
        }

        EList<OperatorOutput> list = node.getOutput();
        if (target != null)
        {
            output.setTarget(target);
        }

        list.add(output);
        return true;

    }

    @Override
    public boolean updateOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output, String oldValue, String newValue) {
        CallNodeImpl node = (CallNodeImpl) source;

        if (newValue == null)
        {
            node.getUsedOutputNames().remove(output.getName());
        }
        return false;
    }

    @Override
    public boolean processOutpuNode(ActionNode source, String sourceAnchor,
            ActionNode target, String targetAnchor, OperatorOutput output) {
        // TODO Auto-generated method stub
        return processOutpuNode(source, target,
                output);
    }

    public boolean isValidConnection(ActionNode source, ActionNode target,
            OperatorOutput output) {
        return true;
    }

}
