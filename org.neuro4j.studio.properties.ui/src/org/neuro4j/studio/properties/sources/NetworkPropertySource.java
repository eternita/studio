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

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.NetworkTypesEnum;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.properties.descriptor.NetworkVisibilityPropertyDescriptor;
import org.neuro4j.workflow.enums.NetworkVisibility;

public class NetworkPropertySource extends PropertySource {

    private static final String VISIBILITY_NAME = "visibility";
    AdapterFactory af;

    public NetworkPropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {
        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;

        Network network = (Network) object;

        if (NetworkTypesEnum.NET.equals(network.getType())) {

        } else {
            Object feature = itemPropertyDescriptor.getFeature(object);
            if (pkg.getNetwork_Visibility().equals(feature)) {
                IPropertyDescriptor desc = new NetworkVisibilityPropertyDescriptor(VISIBILITY_NAME, "Visibility", new String[] { });
                return desc;
            }
        }

        return super.createPropertyDescriptor(itemPropertyDescriptor);

    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        Network network = (Network) object;

        if (NetworkTypesEnum.NET.equals(network.getType())) {
            Properties prop = network.getConfig();

            Enumeration<Object> keys = prop.keys();
            List<PropertyDescriptor> descriptors = new LinkedList<PropertyDescriptor>();
            while (keys.hasMoreElements())
            {
                String key = (String) keys.nextElement();
                PropertyDescriptor desc = new PropertyDescriptor(key, key);
                descriptors.add(desc);

            }

            return descriptors.toArray(new IPropertyDescriptor[] { });
        } else {
            return super.getPropertyDescriptors();

        }

    }

    @Override
    public void setPropertyValue(Object propertyId, Object value) {
        if (VISIBILITY_NAME.equals(propertyId)) {
            Integer index = (Integer) value;
            NetworkVisibility[] names = NetworkVisibility.values();
            value = names[index].name();

        }

        itemPropertySource.getPropertyDescriptor(object, propertyId)
                .setPropertyValue(object, value);
    }

    @Override
    public Object getPropertyValue(Object propertyId) {
        if (VISIBILITY_NAME.equals(propertyId)) {
            PropertyValueWrapper value = (PropertyValueWrapper) itemPropertySource
                    .getPropertyDescriptor(object, propertyId)
                    .getPropertyValue(object);
            NetworkVisibility op = null;
            if (value != null) {
                op = NetworkVisibility.valueOf((String) value
                        .getEditableValue(this));
            }
            if (op == null) {
                op = NetworkVisibility.Public;
            }
            return new PropertyValueWrapper(af, object, op.ordinal(), null);
        }

        Network network = (Network) object;

        if (NetworkTypesEnum.NET.equals(network.getType())) {
            Properties prop = network.getConfig();

            String value = prop.getProperty((String) propertyId);
            return new PropertyValueWrapper(af, object, value, null);

        }

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}