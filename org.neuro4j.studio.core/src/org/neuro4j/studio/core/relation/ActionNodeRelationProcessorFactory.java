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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.impl.StandardNodeImpl;
import org.neuro4j.studio.core.relation.impl.CallNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.DecisionNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.EndNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.FollowByRelationsNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.JoinNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.LogicNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.LoopNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.MapperNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.NoteNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.StandardNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.StartNodeRelationProcessor;
import org.neuro4j.studio.core.relation.impl.ViewNodeRelationProcessor;

public class ActionNodeRelationProcessorFactory {

    public static ActionNodeRelationProcessorFactory instance = new ActionNodeRelationProcessorFactory();

    private static StandardNodeRelationProcessor standardNodeRelationProcessor = new StandardNodeRelationProcessor();

    private ActionNodeRelationProcessorFactory()
    {

    }

    public static ActionNodeRelationProcessorFactory getInstance() {
        return instance;
    }

    Map<Integer, ActionRelationProcessor> processors = new HashMap<Integer, ActionRelationProcessor>();

    public ActionRelationProcessor createProcessor(ActionNode action)
    {
        if (action == null)
        {
            return null;
        } else if (action instanceof StandardNodeImpl)
        {
            return standardNodeRelationProcessor;
        }

        ActionRelationProcessor actionRelationProcessor = processors.get(action.eClass().getClassifierID());
        if (actionRelationProcessor == null)
        {
            actionRelationProcessor = create(action.eClass());
            processors.put(action.eClass().getClassifierID(), actionRelationProcessor);
        }
        return actionRelationProcessor;
    }

    private ActionRelationProcessor create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case Neuro4jPackage.JOIN_NODE:
                return createJoinNodeProcessor();
            case Neuro4jPackage.DECISION_NODE:
                return createDecisionNodeProcessor();
            case Neuro4jPackage.LOOP_NODE:
                return createLoopNodeProcessor();
            case Neuro4jPackage.CALL_NODE:
                return createCallNodeProcessor();
            case Neuro4jPackage.START_NODE:
                return createStartNodeProcessor();
            case Neuro4jPackage.END_NODE:
                return createEndNodeProcessor();
            case Neuro4jPackage.MAPPER_NODE:
                return createMapperNodeProcessor();
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE:
                return createFollowByRelationNodeProcessor();
            case Neuro4jPackage.LOGIC_NODE:
                return createLogicNodeProcessor();
            case Neuro4jPackage.VIEW_NODE:
                return createViewNodeProcessor();
            case Neuro4jPackage.NOTE_NODE:
                return createNoteNodeProcessor();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' has not a valid processor");
        }
    }

    private ActionRelationProcessor createLogicNodeProcessor() {
        return new LogicNodeRelationProcessor();
    }

    private ActionRelationProcessor createFollowByRelationNodeProcessor() {
        return new FollowByRelationsNodeRelationProcessor();
    }

    private ActionRelationProcessor createMapperNodeProcessor() {
        return new MapperNodeRelationProcessor();
    }

    private ActionRelationProcessor createEndNodeProcessor() {

        return new EndNodeRelationProcessor();
    }

    private ActionRelationProcessor createViewNodeProcessor() {

        return new ViewNodeRelationProcessor();
    }

    private ActionRelationProcessor createStartNodeProcessor() {
        return new StartNodeRelationProcessor();
    }

    private ActionRelationProcessor createCallNodeProcessor() {
        return new CallNodeRelationProcessor();
    }

    private ActionRelationProcessor createLoopNodeProcessor() {
        return new LoopNodeRelationProcessor();
    }

    private ActionRelationProcessor createDecisionNodeProcessor() {
        return new DecisionNodeRelationProcessor();
    }

    private ActionRelationProcessor createJoinNodeProcessor() {
        return new JoinNodeRelationProcessor();
    }

    private ActionRelationProcessor createNoteNodeProcessor() {

        return new NoteNodeRelationProcessor();
    }

    private ActionRelationProcessor createStandardNodeProcessor()
    {
        return new StandardNodeRelationProcessor();
    }

}
