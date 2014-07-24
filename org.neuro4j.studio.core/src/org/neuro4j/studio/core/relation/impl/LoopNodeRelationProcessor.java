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

import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public class LoopNodeRelationProcessor extends ActionRelationProcessor {

	@Override
	protected void processOutpuNode(ActionNodeImpl source, NodeXML entity,
			OperatorOutput output, TransitionXML relation) {
		processOutpuNode(source, null, output);
	}

	@Override
	public boolean processOutpuNode(ActionNode source, ActionNode target,
			OperatorOutput output) {
		LoopNode node = (LoopNode) source;
		if (output.getName() != null) {
			if (LoopNode.EXIT.equals(output.getName())) {
				// output.setName(LoopNode.EXIT);
				node.setMainExit(output);
				node.getOutput().add(output);

			} else if (LoopNode.LOOP_EXIT.equals(output.getName())) {
				node.setLoopExit(output);
				node.getOutput().add(output);
			}
			return true;
		}
		if (node.getMainExit() == null) {
			output.setName(LoopNode.EXIT);
			node.setMainExit(output);
			node.getOutput().add(output);
			return true;
		} else if (node.getLoopExit() == null) {
			output.setName(LoopNode.LOOP_EXIT);
			node.setLoopExit(output);
			node.getOutput().add(output);
			return true;
		}

		return false;

	}

	@Override
	public boolean updateOutpuNode(ActionNode source, ActionNode target,
			OperatorOutput output, String oldValue, String newValue) {
		LoopNode node = (LoopNode) source;
		// check if remove link
		if (newValue == null) {
			if (LoopNode.EXIT.equals(output.getName())) {
				node.setMainExit(null);
			} else if (LoopNode.LOOP_EXIT.equals(output.getName())) {
				node.setLoopExit(null);
			}

			return true;
		}

		// update link
		if (LoopNode.LOOP_EXIT.equals(newValue)) {

			if (node.getLoopExit() != null) {
				OperatorOutput falseOutput = node.getLoopExit();
				falseOutput.setName(LoopNode.EXIT);
				node.setMainExit(falseOutput);
			}
			node.setLoopExit(output);

		} else if (LoopNode.EXIT.equals(newValue)) {

			if (node.getMainExit() != null) {
				// make it false
				OperatorOutput trueOutput = node.getMainExit();
				trueOutput.setName(LoopNode.LOOP_EXIT);
				node.setLoopExit(trueOutput);
			}

			node.setMainExit(output);
		}

		return false;
	}

	@Override
	public boolean processOutpuNode(ActionNode source, String sourceAnchor,
			ActionNode target, String targetAnchor, OperatorOutput output) {

		LoopNode node = (LoopNode) source;
		if (output.getName() == null) {
			if ("SOUTH".equals(sourceAnchor) && node.getLoopExit() == null) {
				output.setName(LoopNode.LOOP_EXIT);
				node.setLoopExit(output);

				return true;
			} else if ("EAST".equals(sourceAnchor)
					&& node.getMainExit() == null) {

				output.setName(LoopNode.EXIT);
				node.setMainExit(output);
				// node.getOutput().add(output);
				return true;
			}
		}

		if (node.getOutput().contains(output) && output.getName() != null) {
			return true;
		}

		return false;

	}

}
