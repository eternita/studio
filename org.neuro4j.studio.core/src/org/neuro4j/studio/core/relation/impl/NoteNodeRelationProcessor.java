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
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.impl.CallNodeImpl;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

public class NoteNodeRelationProcessor extends ActionRelationProcessor {

	@Override
	protected void processOutpuNode(ActionNodeImpl source, NodeXML entity,
			OperatorOutput output, TransitionXML transition) {
		processOutpuNode(source, null, output);
	}

	@Override
	public boolean processOutpuNode(ActionNode source, ActionNode target,
			OperatorOutput output) {

		return false;

	}

	@Override
	public boolean updateOutpuNode(ActionNode source, ActionNode target,
			OperatorOutput output, String oldValue, String newValue) {
		CallNodeImpl node = (CallNodeImpl) source;

		if (newValue == null) {
			node.getUsedOutputNames().remove(output.getName());
		}
		return false;
	}

	@Override
	public boolean processOutpuNode(ActionNode source, String sourceAnchor,
			ActionNode target, String targetAnchor, OperatorOutput output) {
		return false;
	}

}
