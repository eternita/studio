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
package org.neuro4j.studio.core.relation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.neuro4j.workflow.node.Transition;
import org.neuro4j.workflow.node.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.XmlTransition;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.util.FlowUtils;

public abstract class ActionRelationProcessor {

    public void processRelation(ActionNodeImpl source, WorkflowNode entity, Map<String, EObject> map) {

        Collection<Transition> relations = entity.getExits();
        for (Transition rel : relations) {

            ActionNodeImpl target = (ActionNodeImpl) map.get(rel.getToNode().getUuid());
            //
            OperatorOutput outPut = Neuro4jFactory.eINSTANCE.createOperatorOutput();
            outPut.setName(rel.getName());
            outPut.setId(rel.getUuid());
            List<RelativeBendpoint> coordinates = parseInitialCoordinates((XmlTransition) rel);
            outPut.setCoordinates(coordinates);
            outPut.setTarget(target);
            processOutpuNode(source, entity, outPut, (XmlTransition) rel);
        }

    }

    private List<RelativeBendpoint> parseInitialCoordinates(XmlTransition relation)
    {
        String pointsStr = relation.getCoordinates();
        if (pointsStr != null)
        {
            return FlowUtils.parseCoordinatesToList(pointsStr);
        }
        return new LinkedList<RelativeBendpoint>();
    }

    protected abstract void processOutpuNode(ActionNodeImpl source, WorkflowNode entity, OperatorOutput output, XmlTransition relation);

    public abstract boolean processOutpuNode(ActionNode source, ActionNode target, OperatorOutput output);

    public abstract boolean updateOutpuNode(ActionNode source, ActionNode target, OperatorOutput output, String oldValue, String newValue);

    public abstract boolean processOutpuNode(ActionNode source, String sourceAnchor, ActionNode target, String targetAnchor, OperatorOutput output);

}
