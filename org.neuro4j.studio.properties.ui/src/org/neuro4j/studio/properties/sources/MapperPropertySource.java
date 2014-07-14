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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.neuro4j.studio.core.impl.MapperNodeImpl;
import org.neuro4j.studio.properties.utils.NameUtils;

/**
 */
public class MapperPropertySource implements IPropertySource {

    MapperNodeImpl node = null;
    KeyValuePair pair = null;

    public static String SOURCE = "Source"; //$NON-NLS-1$
    public static String TARGET = "Target"; //$NON-NLS-1$
    protected static IPropertyDescriptor[] descriptors;

    static {
        descriptors = new IPropertyDescriptor[] {
                new TextPropertyDescriptor(SOURCE, "Source"),
                new TextPropertyDescriptor(TARGET, "Target")
        };
    }

    public MapperPropertySource(MapperNodeImpl node, KeyValuePair pair) {
        this.node = node;
        this.pair = pair;
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
        if (SOURCE.equals(propName)) {
            return pair.getKey();
        }
        if (TARGET.equals(propName)) {
            if (pair.getValue() == null)
            {
                return "";
            }
            return pair.getValue();
        }
        return null;
    }

    public KeyValuePair getPair()
    {
        return pair;
    }

    // public Point getValue(){
    // return new Point(point.x, point.y);
    // }

    /**
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
     */
    public boolean isPropertySet(Object propName) {

        if (SOURCE.equals(propName) || TARGET.equals(propName))
            return true;
        return false;
    }

    public void resetPropertyValue(Object propName) {

    }

    public void setPropertyValue(Object propName, Object value) {
        if (SOURCE.equals(propName)) {
            pair.setKey(value.toString());
        }
        if (TARGET.equals(propName)) {
            if (NameUtils.validateVarName(value.toString()))
            {
                pair.setValue(value.toString());
            } else {

                MessageDialog dialog = new MessageDialog(Neuro4jCorePlugin.getActiveWorkbenchShell(), "Error message", null,
                        "Propery value is not valid", MessageDialog.ERROR, new String[] { "Ok" }, 0);
                int result = dialog.open();

                pair.setValue(pair.getValue());
                return;
            }

        }
        firePropertyChanged((String) propName, null, value);
    }

    public String toString() {
        if (pair.getValue() == null)
        {
            return "";
        }
        return pair.getValue();
    }

}
