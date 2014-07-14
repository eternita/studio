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

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.impl.LogicNodeImpl;
import org.neuro4j.studio.core.impl.MapperNodeImpl;
import org.neuro4j.studio.properties.descriptor.ReadOnlyPropertyDescriptor;

/**
 */
public class ParameterDefinitionPropertySource implements IPropertySource {

    LogicNodeImpl node = null;
    InOutParameter pair = null;

    public static final String NAME = "Name";
    public static final String TYPE = "Type";
    public static final String IS_OPTIONAL = "isOptional";
    protected IPropertyDescriptor[] descriptors = null;

    public ParameterDefinitionPropertySource(LogicNodeImpl node, InOutParameter pair) {
        this.node = node;
        this.pair = pair;

        descriptors = new IPropertyDescriptor[] {
                new TextPropertyDescriptor(NAME, NAME),
                new ReadOnlyPropertyDescriptor(TYPE, TYPE),
                new ReadOnlyPropertyDescriptor(IS_OPTIONAL, IS_OPTIONAL),
        };
    }

    protected void firePropertyChanged(String propName, Object oldValue, Object newValue) {
        node.notifyPropertyChanged(oldValue, newValue);
    }

    public Object getEditableValue() {
        return this;
    }

    public IPropertyDescriptor[] getPropertyDescriptors() {
        return descriptors;
    }

    public Object getPropertyValue(Object propName) {
        if (NAME.equals(propName)) {
            if (pair.getValue() == null)
            {
                return "";
            }
            return pair.getValue();
        } else if (TYPE.equals(propName)) {
            return this.pair.getClassName();
        } else if (IS_OPTIONAL.equals(propName)) {
            return this.pair.isOptional() + "";
        }
        return null;
    }

    public InOutParameter getPair()
    {
        return pair;
    }

    /**
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
     */
    public boolean isPropertySet(Object propName) {
        if (NAME.equals(propName))
            return true;
        return false;
    }

    public void resetPropertyValue(Object propName) {

    }

    public void setPropertyValue(Object propName, Object value) {
        if (NAME.equals(propName)) {
            pair.setValue(value.toString());
            firePropertyChanged((String) propName, null, value);
        }

    }

    public String toString() {
        if (pair.getValue() == null || "".equals(pair.getValue().trim()))
        {
            return pair.getName() + " : " + pair.getName();
        } else {
            return pair.getName() + " : " + pair.getValue();
        }

    }

}
