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

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.util.OutputNamesUtils;
import org.neuro4j.studio.properties.label.providers.NameComboBoxLabelProvider;

public class NodeNamePropertyDescriptor extends ComboBoxPropertyDescriptor {

    private ActionNodeImpl node;
    private IItemPropertyDescriptor itemPropertyDescriptor;

    public NodeNamePropertyDescriptor(Object id, String displayName,
            String[] labelsArray, ActionNodeImpl object) {
        super(id, displayName, labelsArray);
        node = object;
        // to display in property view before selection
        String[] names = OutputNamesUtils.getRelationsNames(node);

        setLabelProvider(new NameComboBoxLabelProvider(names));
    }

    CellEditor editor = null;

    public NodeNamePropertyDescriptor(ActionNodeImpl object, IItemPropertyDescriptor itemPropertyDescriptor) {
        this("name", "Name", new String[] { }, object);
        this.itemPropertyDescriptor = itemPropertyDescriptor;
    }

    // public NodeNamePropertyDescriptor(Object id, String displayName) {
    // // super(id, displayName);
    // // setLabelProvider(new NameSourceLabelProvider());
    // }
    public CellEditor createPropertyEditor(Composite parent) {
        CellEditor editor = new ComboBoxCellEditor(parent, getAllowedRelationNames());
        if (getValidator() != null)
            editor.setValidator(getValidator());
        editor.addPropertyChangeListener(new IPropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                node.setName(event.getNewValue().toString());
            }
        });
        return editor;
    }

    private String[] getAllowedRelationNames()
    {
        String[] names = OutputNamesUtils.getRelationsNames(node);
        return names;
    }

}
