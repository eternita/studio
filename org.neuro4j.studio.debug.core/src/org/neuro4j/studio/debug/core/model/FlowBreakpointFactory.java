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

import java.util.HashSet;
import java.util.Set;

import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.debug.core.BreakpoinMng;

public class FlowBreakpointFactory {

    private static Set<String> set = new HashSet<String>();
    static {
        init();
    }

    private static void init()
    {

        set.add("StartBlock.java");
        set.add("EndBlock.java");
        set.add("DecisionBlock.java");
        set.add("LoopBlock.java");
        set.add("JoinBlock.java");
        set.add("CallBlock.java");
        set.add("SwitchBlock.java");
        set.add("CustomBlock.java");
        set.add("SetViewTemplate.java");
        set.add("KeyMapper.java");

    }

    public static Set<String> getInitBreakpoins()
    {
        Set<String> names = new HashSet<String>(set);

        return names;
    }

    public static ActionNodeBreakpoint createInitBreakpointByName(String name) {

        if (name.equals("StartBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createStartNode());
        } else if (name.equals("EndBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createEndNode());
        } else if (name.equals("DecisionBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createDecisionNode());
        } else if (name.equals("LoopBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createLoopNode());
        } else if (name.equals("JoinBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createJoinNode());
        } else if (name.equals("CallBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createCallNode());
        } else if (name.equals("SwitchBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createFollowByRelationNode());
        } else if (name.equals("CustomBlock.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createLogicNode());
        } else if (name.equals("SetViewTemplate.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createViewNode());
        } else if (name.equals("KeyMapper.java"))
        {
            return (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint(Neuro4jFactory.eINSTANCE.createMapperNode());
        } else {
            return null;
        }

    }

}
