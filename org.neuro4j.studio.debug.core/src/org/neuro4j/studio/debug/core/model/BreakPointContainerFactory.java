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
package org.neuro4j.studio.debug.core.model;

import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.FollowByRelationNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.impl.CallNodeImpl;
import org.neuro4j.studio.core.impl.DecisionNodeImpl;
import org.neuro4j.studio.core.impl.EndNodeImpl;
import org.neuro4j.studio.core.impl.FollowByRelationNodeImpl;
import org.neuro4j.studio.core.impl.JoinNodeImpl;
import org.neuro4j.studio.core.impl.LogicNodeImpl;
import org.neuro4j.studio.core.impl.LoopNodeImpl;
import org.neuro4j.studio.core.impl.MapperNodeImpl;
import org.neuro4j.studio.core.impl.StartNodeImpl;
import org.neuro4j.studio.core.impl.ViewNodeImpl;

public class BreakPointContainerFactory {

    private static final BreakPointParamContainer START_NODE = new BreakPointParamContainer(StartNodeImpl.IMPL_CLASS, new Integer(61), -1, -1);

    private static final BreakPointParamContainer END_NODE = new BreakPointParamContainer(EndNodeImpl.IMPL_CLASS, new Integer(51), -1, -1);

    private static final BreakPointParamContainer DECISION_NODE = new BreakPointParamContainer(DecisionNodeImpl.IMPL_CLASS, new Integer(80), -1, -1);

    private static final BreakPointParamContainer LOOP_NODE = new BreakPointParamContainer(LoopNodeImpl.IMPL_CLASS, new Integer(69), -1, -1);

    private static final BreakPointParamContainer JOIN_NODE = new BreakPointParamContainer(JoinNodeImpl.IMPL_CLASS, new Integer(59), -1, -1);

    private static final BreakPointParamContainer CALL_NODE = new BreakPointParamContainer(CallNodeImpl.IMPL_CLASS, new Integer(81), -1, -1);

    private static final BreakPointParamContainer SWITCH_NODE = new BreakPointParamContainer(FollowByRelationNodeImpl.IMPL_CLASS, new Integer(56), -1, -1);

    private static final BreakPointParamContainer LOGIC_NODE = new BreakPointParamContainer(LogicNodeImpl.IMPL_CLASS, new Integer(74), -1, -1);

    private static final BreakPointParamContainer MAPPER_NODE = new BreakPointParamContainer(MapperNodeImpl.IMPL_CLASS, new Integer(44), -1, -1);
    private static final BreakPointParamContainer VIEW_NODE = new BreakPointParamContainer(ViewNodeImpl.IMPL_CLASS, new Integer(69), -1, -1);

    public static BreakPointParamContainer getBreakPointContainer(ActionNode node)
    {

        if (node instanceof StartNode)
        {
            return START_NODE;
        } else if (node instanceof EndNode)
        {
            return END_NODE;
        } else if (node instanceof DecisionNode)
        {
            return DECISION_NODE;
        } else if (node instanceof LoopNode)
        {
            return LOOP_NODE;
        } else if (node instanceof JoinNode)
        {
            return JOIN_NODE;
        } else if (node instanceof CallNode)
        {
            return CALL_NODE;
        } else if (node instanceof FollowByRelationNode)
        {
            return SWITCH_NODE;
        } else if (node instanceof LogicNode)
        {
            return LOGIC_NODE;
        } else if (node instanceof MapperNode)
        {
            return MAPPER_NODE;
        } else if (node instanceof ViewNode)
        {
            return VIEW_NODE;
        }
        return null;
    }

}
