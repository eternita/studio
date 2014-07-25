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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.format.f4j.FlowConverter;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.util.search.CallNodeResolver;
import org.neuro4j.workflow.Workflow;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.loader.WorkflowLoader;
import org.neuro4j.workflow.node.StartNode;

public class FlowUtils {

    private static final RelativeBendpoint ZERO_POINT = new RelativeBendpoint(0, 0, 0, 0);

    public static List<String> getStartNodeList(InputStream stream, String flow) {
        List<String> startNodes = new ArrayList<String>();
        try {
           // Workflow wflow = WorkflowLoader.loadFlowFromFS(stream, flow);
           FlowXML wflow = FlowConverter.xml2workflow(stream, flow);

            for (NodeXML st : wflow.getNodesByType(NodeType.START)) {
                startNodes.add(st.getName());
            }

        } catch (FlowInitializationException e) {
            e.printStackTrace();
        }

        return startNodes;
    }

    public static List<String> getEndNodeList(String flowName) {
        return CallNodeResolver.getInstance().getEndNodeList(flowName);
    }

    public static Map<String, ParameterDefinition> getParameterDefinitions(String className, String type) {
        return ParameterDefinitionLoader.getInstance().getParameterDefinition(className, type);
    }

    public static List<InOutParameter> loadInputParameterDefinitions(String className, String type) {
        List<InOutParameter> classList = new ArrayList<InOutParameter>();
        Map<String, ParameterDefinition> map = getParameterDefinitions(className, type);
        if (map != null)
        {
            Collection<ParameterDefinition> collection = map.values();
            for (ParameterDefinition pd : collection)
            {
                InOutParameter ioParameter = Neuro4jFactory.eINSTANCE.createInOutParameter();
                ioParameter.setName(pd.name());
                ioParameter.setClassName(pd.type());
                ioParameter.setOptional(pd.isOptional());
                classList.add(ioParameter);
            }
        }

        return classList;
    }

    public static boolean isOutputParameter(String name)
    {

        if (name != null && name.endsWith("OUT")) {
            return true;
        }

        return false;

    }

    public static InOutParameter parseInParameter(String className, String stringValue, String type)
    {
        InOutParameter parameter = Neuro4jFactory.eINSTANCE.createInOutParameter();

        String[] values = stringValue.split(":");
        if (values != null && values.length == 2)
        {
            parameter.setName(values[0]);
            if (values[1] != null && !"NULL".equalsIgnoreCase(values[1]))
            {
                parameter.setValue(values[1]);
            }

            // load parameter definition from class
            Map<String, ParameterDefinition> map = ParameterDefinitionLoader.getInstance().getParameterDefinition(className, type);
            if (map == null)
            {
            	return parameter;
            }
            ParameterDefinition paramDef = map.get(parameter.getName());
            if (paramDef != null)
            {
                parameter.setClassName(paramDef.type());
                parameter.setOptional(paramDef.isOptional());
            }
        }

        return parameter;

    }
    
	public static InOutParameter getInParameter(String className, String key,
			String value, String type) {
		InOutParameter parameter = Neuro4jFactory.eINSTANCE
				.createInOutParameter();
		parameter.setName(key);
		parameter.setValue(value);
		// load parameter definition from class
		Map<String, ParameterDefinition> map = ParameterDefinitionLoader
				.getInstance().getParameterDefinition(className, type);
		if (map == null) {
			return parameter;
		}
		ParameterDefinition paramDef = map.get(key);
		if (paramDef != null) {
			parameter.setClassName(paramDef.type());
			parameter.setOptional(paramDef.isOptional());
		}

		return parameter;

	}

    public static List<RelativeBendpoint> parseCoordinatesToList(String value)
    {
        List<RelativeBendpoint> coordinates = Collections.emptyList();

        if (value != null)
        {
            coordinates = new ArrayList<RelativeBendpoint>();
            String[] values = value.split(PropetiesConstants.RELATION_COORDINATES_DELIMITER);
            for (String coordinate : values)
            {
                parsePoint(coordinate, coordinates);
            }
        }

        return coordinates;
    }

    public static String parseCoordinatesToString(List<RelativeBendpoint> points)
    {
        StringBuffer sb = new StringBuffer();

        if (points != null)
        {
            for (RelativeBendpoint point : points)
            {
                if (ZERO_POINT.equals(point))
                {
                    continue;
                }
                sb.append(point.convertToString().replace("[", "").replace("]", "")).append("|");
            }
        }

        return sb.toString();
    }

    private static void parsePoint(String value, List<RelativeBendpoint> container)
    {
        if (value != null)
        {
            String[] values = value.split(PropetiesConstants.RELATION_COORDINATES_POINT_DELIMITER);
            if (values != null && values.length == 4)
            {
                String x1 = values[0];
                String y1 = values[1];
                String x2 = values[2];
                String y2 = values[3];
                if (x1 != null && y1 != null && x2 != null && y2 != null)
                {
                    try {
                        int intX1 = Integer.parseInt(x1.trim());
                        int intY1 = Integer.parseInt(y1.trim());
                        int intX2 = Integer.parseInt(x2.trim());
                        int intY2 = Integer.parseInt(y2.trim());
                        RelativeBendpoint point = new RelativeBendpoint(intX1, intY1, intX2, intY2);
                        container.add(point);
                    } catch (NumberFormatException e) {
                        return;
                    }
                }

            }
        }
    }



}
