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
package org.neuro4j.studio.flow.convert;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.workflow.node.WorkflowNode;

public interface Entity2ECoreConverter {

    public EObject convert(WorkflowNode entity);

    List<OperatorOutputImpl> getOutRelations(WorkflowNode entity, Map<String, EObject> map);

}
