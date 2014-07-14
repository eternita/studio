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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.impl.LogicNodeImpl;
import org.neuro4j.studio.properties.descriptor.LogicNodeClassNamePropertyDescriptor;

public class LogicNodePropertySource extends PropertySource {

    Map<Object, LogicNodeParametersListPropertySource> map = new HashMap<Object, LogicNodeParametersListPropertySource>();
    AdapterFactory af;

    public LogicNodePropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {
        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);

        if (pkg.getLogicNode_ClassName().equals(feature)) {
            IPropertyDescriptor desc = new LogicNodeClassNamePropertyDescriptor((LogicNode) object, "className", "Class Name");
            return desc;
        }
        return super.createPropertyDescriptor(itemPropertyDescriptor);

    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        // TODO Auto-generated method stub
        return super.getPropertyDescriptors();
    }

    public boolean isPropertySet(Object propName) {
        return false;
    }

    @Override
    public void setPropertyValue(Object propertyId, Object value) {
        if (value instanceof LogicNodeParametersListPropertySource) {

            LogicNodeParametersListPropertySource ps = (LogicNodeParametersListPropertySource) value;

            IItemPropertyDescriptor iItemPropertyDescriptor = itemPropertySource
                    .getPropertyDescriptor(object, propertyId);
            if ("output".equals(ps.getType()))
            {
                iItemPropertyDescriptor.setPropertyValue(object, ps.getNode().getOutParameters());
            } else {
                iItemPropertyDescriptor.setPropertyValue(object, ps.getNode().getInParameters());
            }

        } else if (object instanceof LogicNode && "className".equals(propertyId))
        {
            LogicNodeImpl logicNode = (LogicNodeImpl) object;
            cleanMapForNode(logicNode);
            List<String> list = (List) value;
            if (list != null && list.size() > 0)
            {
                value = list.get(0);
            } else {
                value = null;
            }

            itemPropertySource.getPropertyDescriptor(object, propertyId)
                    .setPropertyValue(object, value);

            // set default name
            if (value != null) {
                String vstr = value.toString();
                String firstName = vstr.substring(vstr.lastIndexOf(".") + 1);
                itemPropertySource.getPropertyDescriptor(object, "name").setPropertyValue(object, firstName);
            }

        } else {
            IItemPropertyDescriptor iItemPropertyDescriptor = itemPropertySource
                    .getPropertyDescriptor(object, propertyId);

            iItemPropertyDescriptor.setPropertyValue(object, value);
        }

    }

    private void cleanMapForNode(LogicNodeImpl mapperNodeImpl)
    {
        map.remove("inParameters" + mapperNodeImpl.getId());
        map.remove("outParameters" + mapperNodeImpl.getId());
    }

    @Override
    public Object getPropertyValue(Object propertyId) {

        if (propertyId.toString().endsWith("Parameters")) {

            LogicNodeImpl mapperNodeImpl = (LogicNodeImpl) object;
            String id = propertyId.toString() + mapperNodeImpl.getId();
            if (map.containsKey(id)) {
                return map.get(id);
            } else {
                LogicNodeParametersListPropertySource desc = new LogicNodeParametersListPropertySource(mapperNodeImpl, (String) propertyId);
                map.put(id, desc);
                return desc;
            }

        }

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

}