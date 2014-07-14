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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.gmf.runtime.common.ui.services.properties.descriptors.CompositeSourcePropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.impl.Neuro4jFactoryImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;
import org.neuro4j.studio.core.impl.StartNodeImpl;

/**
 * @author Administrator
 * 
 *         To change this generated comment edit the template variable "typecomment":
 *         Window>Preferences>Java>Templates.
 *         To enable and disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public class StandardPropertySource1 extends PropertySource {

    AdapterFactory af;
    StandardNodeImpl standardNode = null;

    Map<Object, KeyValuePair> properties = new HashMap<Object, KeyValuePair>();

    public StandardPropertySource1(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
        standardNode = (StandardNodeImpl) object;
        List<KeyValuePair> list = standardNode.getProperties();
        for (KeyValuePair pair : list)
        {
            properties.put(pair.getId(), pair);
        }

    }

    Map<String, PropertyDescriptor> descriptors = new HashMap<String, PropertyDescriptor>();

    public Object getEditableValue() {
        return this;
    }

    public IPropertyDescriptor[] getPropertyDescriptors() {
        List<KeyValuePair> list = standardNode.getProperties();

        for (KeyValuePair pair : list)
        {
            TextPropertyDescriptor cd = new TextPropertyDescriptor(pair.getId(), pair.getKey());
            // cd.setReadOnly(true);
            descriptors.put(pair.getId(), cd);

        }
        KeyValuePair kvp = createNewKeyValuePair();
        PropertyDescriptor cd = new CompositeSourcePropertyDescriptor("NewKeyID", "NewKey", "NewValue");

        descriptors.put(kvp.getId(), cd);
        return descriptors.values().toArray(new IPropertyDescriptor[descriptors.size()]);
    }

    private KeyValuePair createNewKeyValuePair()
    {
        KeyValuePair newKeyValue = Neuro4jFactoryImpl.eINSTANCE.createKeyValuePair();
        newKeyValue.setKey("NEW");
        newKeyValue.setValue("");
        properties.put(newKeyValue.getId(), newKeyValue);

        return newKeyValue;
    }

    // public void setPropertyValue(Object propName, Object value){
    // KeyValuePair kvp = values.get(propName);
    // if (value instanceof MapperPropertySource)
    // {
    // MapperPropertySource source = (MapperPropertySource)value;
    // KeyValuePair kvpn = source.getPair();
    // // if empty source - remove
    // if (kvpn.getKey().equals(""))
    // {
    // node.getKeyValue().remove(kvpn);
    // values.remove(propName);
    // }
    // kvp.setKey(kvpn.getKey());
    // kvp.setValue(kvpn.getValue());
    // values.remove(propName);
    // values.put(kvp.getId(), kvp);
    //
    // if (newKeyValue.getId().equals(kvpn.getId()))
    // {
    // node.getKeyValue().add(kvp);
    // createNewKeyValuePair();
    // }
    // }
    //
    // firePropertyChanged((String)propName);
    // }

    public String toString() {
        return "";
    }

}
