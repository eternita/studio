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
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

public class StandardNodePropertySource extends PropertySource {

    Map<Object, StandardListPropertySource> map = new HashMap<Object, StandardListPropertySource>();
    AdapterFactory af;

    public StandardNodePropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {
        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);

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
    public void setPropertyValue(Object propertyId, Object value)
    {
        if (value instanceof StandardListPropertySource)
        {
            StandardNodeImpl mn = (StandardNodeImpl) object;
            StandardListPropertySource ps = (StandardListPropertySource) value;

            IItemPropertyDescriptor iItemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(object, propertyId);
            iItemPropertyDescriptor.setPropertyValue(object, ps.getMapperNode().getProperties());
        } else {
            IItemPropertyDescriptor iItemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(object, propertyId);

            iItemPropertyDescriptor.setPropertyValue(object, value);
        }

    }

    @Override
    public Object getPropertyValue(Object propertyId) {

        if ("KeyValue".equals(propertyId)) {
            StandardNodeImpl StandardNodeImpl = (StandardNodeImpl) object;
            if (map.containsKey(StandardNodeImpl.getId()))
            {
                return map.get(StandardNodeImpl.getId());
            } else {
                StandardListPropertySource desc = new StandardListPropertySource(StandardNodeImpl);
                map.put(StandardNodeImpl.getId(), desc);
                return desc;
            }

            // inputParameterElementProperties.getPropertyDescriptors();

        }
        // if (propertyId.equals("inputParameters"))
        // return new SizePropertySource(null);
        // if (propertyId.equals("name"))
        // return 0;

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue()
    {
        return itemPropertySource.getEditableValue(object);
    }

}