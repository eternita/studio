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
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.impl.Neuro4jFactoryImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

/**
 * @author Administrator
 * 
 *         To change this generated comment edit the template variable "typecomment":
 *         Window>Preferences>Java>Templates.
 *         To enable and disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public class StandardListPropertySource implements IPropertySource {

    Node node;
    Map<String, KeyValuePair> values = new HashMap<String, KeyValuePair>();
    Map<KeyValuePair, StandardPropertySource> map = new HashMap<KeyValuePair, StandardPropertySource>();
    KeyValuePair newKeyValue = null;

    public StandardListPropertySource(Node object) {
        node = object;
        createMap(object.getProperties());
    }

    public Node getMapperNode()
    {
        return node;
    }

    private void createMap(List<KeyValuePair> eList)
    {
        for (KeyValuePair pair : eList)
        {
            values.put(pair.getId(), pair);
        }
        createNewKeyValuePair();

    }

    private void createNewKeyValuePair()
    {
        newKeyValue = Neuro4jFactoryImpl.eINSTANCE.createKeyValuePair();
        newKeyValue.setKey("NEW");
        newKeyValue.setValue("");
        values.put(newKeyValue.getId(), newKeyValue);
    }

    protected void firePropertyChanged(String propName) {
        // Control ctl = (Control)element.getControl();
        //
        // if (ctl == null) {
        // // the GUIView is probably hidden in this case
        // return;
        // }
        // ctl.setSize(point);
    }

    public Object getEditableValue() {
        return this;
    }

    public IPropertyDescriptor[] getPropertyDescriptors() {
        List<KeyValuePair> list = node.getProperties();

        ArrayList<IPropertyDescriptor> descriptors = new ArrayList<IPropertyDescriptor>();
        TextPropertyDescriptor nameD = new TextPropertyDescriptor("nameId", "Name");
        descriptors.add(nameD);
        TextPropertyDescriptor idD = new TextPropertyDescriptor("idId", "uuid");
        descriptors.add(idD);
        int i = 1;
        for (KeyValuePair pair : list)
        {
            CompositeSourcePropertyDescriptor cd = new CompositeSourcePropertyDescriptor(node, pair.getId(), i + " : " + pair.getKey());
            cd.setReadOnly(true);
            descriptors.add(cd);
            i++;
        }
        CompositeSourcePropertyDescriptor cd = new CompositeSourcePropertyDescriptor(node, newKeyValue.getId(), i + " : NEW");
        cd.setReadOnly(true);
        descriptors.add(cd);
        return descriptors.toArray(new IPropertyDescriptor[descriptors.size()]);
    }

    public Object getPropertyValue(Object propName) {
        if ("nameId".equals(propName))
        {
            return node.getName();
        }
        if ("idId".equals(propName))
        {
            return node.getId();
        }

        KeyValuePair pair = values.get((String) propName);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        StandardPropertySource desc = new StandardPropertySource(node,
                values.get(propName.toString()));
        map.put(pair, desc);
        return desc;

    }

    /**
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
     */
    public boolean isPropertySet(Object propName) {
        if (values.containsKey((String) propName))
        {
            return true;
        }

        return false;
    }

    public void resetPropertyValue(Object propName) {
    }

    public void setPropertyValue(Object propName, Object value) {

        if ("nameId".equals(propName))
        {
            node.setName((String) value);
            node.notifyPropertyChanged(value, value);
        }

        KeyValuePair kvp = values.get((String) propName);
        if (value instanceof StandardPropertySource)
        {
            StandardPropertySource source = (StandardPropertySource) value;
            KeyValuePair kvpn = source.getPair();
            // if empty source - remove
            if (kvpn.getKey().equals(""))
            {
                node.getProperties().remove(kvpn);
                values.remove((String) propName);
            }
            kvp.setKey(kvpn.getKey());
            kvp.setValue(kvpn.getValue());
            values.remove(propName);
            values.put(kvp.getId(), kvp);

            if (newKeyValue.getId().equals(kvpn.getId()))
            {
                node.getProperties().add(kvp);
                createNewKeyValuePair();
            }
        }

        firePropertyChanged((String) propName);
    }

    public String toString() {
        return "";
    }

}
