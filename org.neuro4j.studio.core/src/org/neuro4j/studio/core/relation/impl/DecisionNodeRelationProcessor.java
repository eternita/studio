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

import org.neuro4j.workflow.node.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public class DecisionNodeRelationProcessor extends ActionRelationProcessor {

    @Override
    protected void processOutpuNode(ActionNodeImpl source, WorkflowNode entity, OperatorOutput output, XmlTransition relation) {
        processOutpuNode(source, null, output);
    }

    @Override
    public boolean processOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output) {
        DecisionNode node = (DecisionNode) source;

        if (output.getName() != null) {

            if (DecisionNode.FALSE.equals(output.getName()))
            {
                node.setMainFalseOutput(output);
                node.getOutput().add(output);
                return true;
            } else if (DecisionNode.TRUE.equals(output.getName())) {
                node.setMainTrueOutput(output);
                node.getOutput().add(output);
                return true;
            }

        }

        return false;

    }

    /**
     * Create connection in editor.
     * Returns false if connection is not valid.
     */
    @Override
    public boolean processOutpuNode(ActionNode source, String sourceAnchor, ActionNode target, String targetAnchor, OperatorOutput output)
    {

        DecisionNode node = (DecisionNode) source;
        if (output.getName() == null)
        {
            if ("SOUTH".equals(sourceAnchor) && node.getMainTrueOutput() == null)
            {
                output.setName(DecisionNode.TRUE);
                node.setMainTrueOutput(output);

                return true;
            } else if ("EAST".equals(sourceAnchor) && node.getMainFalseOutput() == null) {

                output.setName(DecisionNode.FALSE);
                node.setMainFalseOutput(output);

                return true;
            }
        }

        if (node.getOutput().contains(output) && output.getName() != null)
        {
            return true;
        }

        return false;

    }

    @Override
    public boolean updateOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output, String oldValue, String newValue) {

        DecisionNode node = (DecisionNode) source;
        // check if remove link
        if (newValue == null)
        {
            if (DecisionNode.FALSE.equals(output.getName()))
            {
                node.setMainFalseOutput(null);
            } else if (DecisionNode.TRUE.equals(output.getName())) {
                node.setMainTrueOutput(null);
            }

            return true;
        }

        // update link
        if (DecisionNode.FALSE.equals(newValue))
        {

            if (node.getMainFalseOutput() != null)
            {
                OperatorOutput falseOutput = node.getMainFalseOutput();
                falseOutput.setName(DecisionNode.TRUE);
                node.setMainTrueOutput(falseOutput);
            }
            node.setMainFalseOutput(output);

        } else if (DecisionNode.TRUE.equals(newValue)) {

            if (node.getMainTrueOutput() != null)
            {
                // make it false
                OperatorOutput trueOutput = node.getMainTrueOutput();
                trueOutput.setName(DecisionNode.FALSE);
                node.setMainFalseOutput(trueOutput);
            }

            node.setMainTrueOutput(output);
        }

        return false;
    }

}
