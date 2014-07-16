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
package org.neuro4j.studio.core.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

public class OutputNamesUtils {

	public static String[] getRelationsNames(EObject node) {
		if (node instanceof CallNode) {
			return getEndNodesForCallNode((CallNode) node);

		} else if (node instanceof StandardNodeImpl) {
			return null;
		}
		return getRelationsNames(node.eClass());
	}

	public static String[] getRelationsNames(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Neuro4jPackage.JOIN_NODE:
			return JOIN_NODE_OUTPUTS_NAMES;
		case Neuro4jPackage.DECISION_NODE:
			return DECISION_NODE_OUTPUTS_NAMES;
		case Neuro4jPackage.LOOP_NODE:
			return LOOP_NODE_OUTPUTS_NAMES;
		case Neuro4jPackage.CALL_NODE:
			return getEndNodesForCallNode((CallNode) eClass);
		case Neuro4jPackage.START_NODE:
			return START_NODE_OUTPUTS_NAMES;
		case Neuro4jPackage.MAPPER_NODE:
			return MAPPER_NODE_OUTPUTS_NAMES;
		case Neuro4jPackage.LOGIC_NODE:
			return LOGIC_NODE_OUTPUTS_NAMES;
		default:
			return null;
		}
	}

	private static final String[] START_NODE_OUTPUTS_NAMES = new String[] { StartNode.NEXT };
	public static final String[] LOGIC_NODE_OUTPUTS_NAMES = new String[] {
			LogicNode.NEXT, LogicNode.ERROR };
	private static final String[] JOIN_NODE_OUTPUTS_NAMES = new String[] { JoinNode.NEXT };
	private static final String[] MAPPER_NODE_OUTPUTS_NAMES = new String[] { MapperNode.NEXT };
	private static final String[] CALL_NODE_OUTPUTS_NAMES = new String[] { CallNode.NEXT };
	private static final String[] LOOP_NODE_OUTPUTS_NAMES = new String[] {
			LoopNode.EXIT, LoopNode.LOOP_EXIT };
	private static final String[] DECISION_NODE_OUTPUTS_NAMES = new String[] {
			DecisionNode.TRUE, DecisionNode.FALSE };

	public static Object getValueByIndex(ActionNode actionNode, Integer value) {
		String[] names = getRelationsNames(actionNode);
		if (names != null && names.length > value) {
			return names[value];
		}
		return null;
	}

	public static Integer getIndexByValue(ActionNode actionNode,
			String propertyValue) {
		String[] names = getRelationsNames(actionNode);
		if (names != null) {
			if (propertyValue == null) {
				return 0;
			}
			int index = Arrays.asList(names).indexOf(propertyValue);
			if (index > -1) {
				return index;
			}
		}
		return 0;
	}

	private static String[] getEndNodesForCallNode(CallNode callNode) {
		List<String> endNodeNames = Collections.EMPTY_LIST;
		String flowName = callNode.getFlowName();
		if (null != flowName) {
			endNodeNames = FlowUtils.getEndNodeList(flowName);

		} else {
			return CALL_NODE_OUTPUTS_NAMES;
		}

		return endNodeNames.toArray(new String[endNodeNames.size()]);
	}
}
