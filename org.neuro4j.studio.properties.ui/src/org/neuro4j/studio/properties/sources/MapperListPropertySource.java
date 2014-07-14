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
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.ui.services.properties.descriptors.CompositeSourcePropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.impl.MapperNodeImpl;
import org.neuro4j.studio.core.impl.Neuro4jFactoryImpl;

/**
 * @author Administrator
 * 
 *         To change this generated comment edit the template variable "typecomment":
 *         Window>Preferences>Java>Templates.
 *         To enable and disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public class MapperListPropertySource implements IPropertySource {

    MapperNodeImpl node;
    Map<String, KeyValuePair> values = new HashMap<String, KeyValuePair>();
    Map<KeyValuePair, MapperPropertySource> map = new HashMap<KeyValuePair, MapperPropertySource>();
    KeyValuePair newKeyValue = null;

    public MapperListPropertySource(MapperNodeImpl object) {
        node = object;
        createMap(object.getKeyValue());
    }

    public MapperNode getMapperNode()
    {
        return node;
    }

    private void createMap(EList<KeyValuePair> eList)
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
        EList<KeyValuePair> list = node.getKeyValue();

        ArrayList<IPropertyDescriptor> descriptors = new ArrayList<IPropertyDescriptor>();
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
        KeyValuePair pair = values.get(propName.toString());
        if (map.containsKey(pair)) {
            Object obj = map.get(pair);
            if (obj == null)
            {
                map.remove(pair);

            } else {
                return obj;
            }

        }
        MapperPropertySource desc = new MapperPropertySource(node,
                values.get(propName.toString()));
        map.put(pair, desc);
        return desc;

    }

    /**
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
     */
    public boolean isPropertySet(Object propName) {
        if (values.containsKey(propName.toString()))
            return true;
        return false;
    }

    public void resetPropertyValue(Object propName) {
    }

    public void setPropertyValue(Object propName, Object value) {
        KeyValuePair kvp = values.get(propName);
        if (value instanceof MapperPropertySource)
        {
            MapperPropertySource source = (MapperPropertySource) value;
            KeyValuePair kvpn = source.getPair();
            // if empty source - remove
            if (kvpn.getKey().equals(""))
            {
                node.getKeyValue().remove(kvpn);
                values.remove(propName);
            }
            kvp.setKey(kvpn.getKey());
            kvp.setValue(kvpn.getValue());
            values.remove(propName);
            values.put(kvp.getId(), kvp);

            if (newKeyValue.getId().equals(kvpn.getId()))
            {
                node.getKeyValue().add(kvp);
                createNewKeyValuePair();
            }
        }

        firePropertyChanged((String) propName);
    }

    public String toString() {
        return "";
    }

}
