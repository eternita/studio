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

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.neuro4j.workflow.xml.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public class LogicNodeRelationProcessor extends ActionRelationProcessor {

    @Override
    protected void processOutpuNode(ActionNodeImpl source, WorkflowNode entity, OperatorOutput output, XmlTransition relation) {
        processOutpuNode(source, null, output);
    }

    @Override
    public boolean processOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output) {
        LogicNode node = (LogicNode) source;

        if (output.getName() != null) {

            if (LogicNode.NEXT.equals(output.getName()))
            {
                node.setMainOutput(output);
                node.getOutput().add(output);
                return true;
            } else if (LogicNode.ERROR.equals(output.getName())) {
                node.setErrorOutput(output);
                node.getOutput().add(output);
                return true;
            }
        }

        return false;

    }

    @Override
    public boolean updateOutpuNode(ActionNode source, ActionNode target,
            OperatorOutput output, String oldValue, String newValue) {
        // check if remove link
        LogicNode node = (LogicNode) source;
        if (newValue == null)
        {
            if (LogicNode.NEXT.equals(output.getName()))
            {
                node.setMainOutput(null);
            } else if (LogicNode.ERROR.equals(output.getName())) {
                node.setErrorOutput(null);
            }

            return true;
        }

        // update link
        if (LogicNode.ERROR.equals(newValue))
        {

            if (node.getErrorOutput() != null)
            {
                OperatorOutput o1 = node.getErrorOutput();
                o1.setName(LogicNode.NEXT);
                node.setMainOutput(o1);
            }
            node.setErrorOutput(output);

            ViewUtil.setStructuralFeatureValue(output.getEdge(),
                    NotationPackage.eINSTANCE.getLineStyle_LineColor(), 255);

        } else if (LogicNode.NEXT.equals(newValue)) {

            if (node.getMainOutput() != null)
            {
                // make it false
                OperatorOutput trueOutput = node.getMainOutput();
                trueOutput.setName(LogicNode.ERROR);
                node.setErrorOutput(trueOutput);
            }
            ViewUtil.setStructuralFeatureValue(output.getEdge(),
                    NotationPackage.eINSTANCE.getLineStyle_LineColor(), 0);
            node.setMainOutput(output);
        }

        return false;
    }

    @Override
    public boolean processOutpuNode(ActionNode source, String sourceAnchor, ActionNode target, String targetAnchor, OperatorOutput output)
    {

        // during creation -----
        LogicNode node = (LogicNode) source;
        if (output.getName() == null)
        {
            if ("SOUTH".equals(sourceAnchor) && node.getMainOutput() == null)
            {
                output.setName(LogicNode.NEXT);
                node.setMainOutput(output);

                return true;
            } else if ("EAST".equals(sourceAnchor) && node.getErrorOutput() == null) {

                output.setName(LogicNode.ERROR);
                node.setErrorOutput(output);
                ViewUtil.setStructuralFeatureValue(output.getEdge(),
                        NotationPackage.eINSTANCE.getLineStyle_LineColor(), 255);
                return true;
            }
        }

        if (node.getOutput().contains(output) && output.getName() != null)
        {
            return true;
        }
        // else {
        //
        // if ("SOUTH".equals(sourceAnchor) && node.getMainOutput() == null)
        // {
        // output.setName(LogicNode.NEXT);
        // node.setMainOutput(output);
        //
        // return true;
        // } else if ("EAST".equals(sourceAnchor) && node.getErrorOutput() == null){
        //
        // output.setName(LogicNode.ERROR);
        // node.setErrorOutput(output);
        // ViewUtil.setStructuralFeatureValue(output.getEdge(),
        // NotationPackage.eINSTANCE.getLineStyle_LineColor(), 255);
        // return true;
        // }
        //
        // }

        // -- during load

        return false;

    }

}
