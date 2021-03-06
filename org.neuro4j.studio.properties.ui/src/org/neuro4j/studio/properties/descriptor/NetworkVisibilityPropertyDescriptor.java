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
package org.neuro4j.studio.properties.descriptor;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.ComboBoxLabelProvider;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.neuro4j.workflow.enums.FlowVisibility;

public class NetworkVisibilityPropertyDescriptor extends ComboBoxPropertyDescriptor {

    public NetworkVisibilityPropertyDescriptor(Object id, String displayName,
            String[] labelsArray) {
        super(id, displayName, labelsArray);
        setLabelProvider(new ComboBoxLabelProvider(getAllowedValues()));

    }

    public CellEditor createPropertyEditor(Composite parent) {
        CellEditor editor = new ComboBoxCellEditor(parent, getAllowedValues());
        if (getValidator() != null)
            editor.setValidator(getValidator());
        return editor;
    }

    private String[] getAllowedValues()
    {
        return FlowVisibility.types();
    }
}
