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
package org.neuro4j.studio.core.diagram.wizards.utils;

import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;

public class WizardParameterBuilder {
    private ParameterDefinitionList list;
    public static final String OUT_PREFIX = "OUT_";
    public WizardParameterBuilder()
    {
        super();
    }

    public WizardParameterBuilder(ParameterDefinitionList list) {
        this();
        this.list = list;
    }

    public String buildInputBlock1()
    {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.input();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            String name = getInConstantName(pd);
            sb.append("static final String ").append(name).append(" = \"").append(pd.name()).append("\";\n    ");
        }

        return sb.toString();
    }

    public String buildInputBlock2()
    {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.input();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            String name = getInConstantName(pd);
            sb.append("Object ").append(pd.name()).append(" = ctx.get(").append(name).append(");\n        ");
        }
        return sb.toString();
    }

    public String buildOutputBlock1() {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.output();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            String name = getOutConstantName(pd);
            sb.append("static final String ").append(name).append(" = \"").append(pd.name()).append("\"; \n    ");
        }

        return sb.toString();
    }

    public String buildOutputBlock2() {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.output();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            String name = getOutConstantName(pd);
            sb.append("ctx.put(").append(name).append(", null); \n    ");
        }
        return sb.toString();
    }

    private String getOutConstantName(ParameterDefinition pd) {
        return OUT_PREFIX + pd.name().toUpperCase();
    }

    private String getInConstantName(ParameterDefinition pd) {
        return "IN_" + pd.name().toUpperCase();
    }

    private String getParameterDefinition(ParameterDefinition pd, boolean isInput)
    {
        String constantName = "";
        if (isInput)
        {
            constantName = getInConstantName(pd);
        } else {
            constantName = getOutConstantName(pd);
        }
        return "@ParameterDefinition(name=" + constantName + ", isOptional=" + pd.isOptional() + ", type= \"" + pd.type() + "\")";
    }

    public String buildInputString() {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.input();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            sb.append(getParameterDefinition(pd, true)).append(",");
        }
        if (sb.length() > 2)
        {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

    public String buildOutputString() {
        StringBuffer sb = new StringBuffer(" ");
        ParameterDefinition[] array = list.output();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            sb.append(getParameterDefinition(pd, false)).append(",");
        }

        if (sb.length() > 2)
        {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

}
