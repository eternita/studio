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
package org.neuro4j.studio.properties.sources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.common.ui.services.properties.descriptors.CompositeSourcePropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.impl.LogicNodeImpl;
import org.neuro4j.studio.core.util.FlowUtils;

public class LogicNodeParametersListPropertySource implements IPropertySource {

    LogicNodeImpl node;
    Map<String, InOutParameter> parameters = new HashMap<String, InOutParameter>();
    String type;

    // public LogicNodeInputParametersListPropertySource(LogicNodeImpl object){
    // node = object;
    // if (object.getClassName() != null)
    // {
    // createMap(FlowUtils.loadInputParameterDefinitions(object.getClassName(), "input"), node.getInParameters());
    // }
    //
    // }

    public LogicNodeParametersListPropertySource(LogicNodeImpl mapperNodeImpl, String propertyId) {
        node = mapperNodeImpl;
        if (mapperNodeImpl.getClassName() != null)
        {
            type = "input";
            if ("outParameters".equals(propertyId))
            {
                type = "output";
                createMap(FlowUtils.loadInputParameterDefinitions(mapperNodeImpl.getClassName(), type), node.getOutParameters());
            } else {
                createMap(FlowUtils.loadInputParameterDefinitions(mapperNodeImpl.getClassName(), type), node.getInParameters());
            }

        }
    }

    public LogicNodeImpl getNode()
    {
        return node;
    }

    protected void createMap(List<InOutParameter> defList, List<InOutParameter> valList)
    {
        for (InOutParameter pair : defList)
        {
            parameters.put(getPropertyNameWithType(pair.getName()), pair);
        }
        for (InOutParameter pair : valList)
        {
            InOutParameter iop = parameters.get(getPropertyNameWithType(pair.getName()));
            if (iop != null)
            {
                iop.setValue(pair.getValue());
            }
        }
    }

    protected void firePropertyChanged(String propName) {
        if ("output".equals(type))
        {
            node.getOutParameters().clear();
            node.getOutParameters().addAll(parameters.values());
        } else {
            node.getInParameters().clear();
            node.getInParameters().addAll(parameters.values());
        }

    }

    public Object getEditableValue() {
        return this;
    }

    public IPropertyDescriptor[] getPropertyDescriptors() {

        ArrayList<IPropertyDescriptor> descriptors = new ArrayList<IPropertyDescriptor>();
        int i = 1;
        for (InOutParameter pair : parameters.values())
        {
            CompositeSourcePropertyDescriptor cd = new CompositeSourcePropertyDescriptor(node, pair.getName(), "Parameter" + i);
            cd.setReadOnly(true);
            descriptors.add(cd);
            i++;
        }
        return descriptors.toArray(new IPropertyDescriptor[descriptors.size()]);
    }

    public Object getPropertyValue(Object propName) {

        ParameterDefinitionPropertySource desc = new ParameterDefinitionPropertySource(node,
                parameters.get(getPropertyNameWithType(propName.toString())));

        return desc;

    }

    /**
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
     */
    public boolean isPropertySet(Object propName) {
        if (parameters.containsKey(getPropertyNameWithType(propName.toString())))
            return true;
        return false;
    }

    public void resetPropertyValue(Object propName) {
    }

    public void setPropertyValue(Object propName, Object value) {
        InOutParameter kvp = parameters.get(getPropertyNameWithType(propName.toString()));
        if (value instanceof ParameterDefinitionPropertySource)
        {
            ParameterDefinitionPropertySource source = (ParameterDefinitionPropertySource) value;
            InOutParameter kvpn = source.getPair();
            // if empty source - remove

            kvp.setName(kvpn.getName());
            kvp.setValue(kvpn.getValue());
            parameters.remove(getPropertyNameWithType(propName.toString()));
            parameters.put(getPropertyNameWithType(kvp.getName()), kvp);

        }

        firePropertyChanged((String) propName);
    }

    private String getPropertyNameWithType(String name)
    {
        return type + name;
    }

    public String toString() {
        return "";
    }

    public String getType() {
        return type;
    }

}
