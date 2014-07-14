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
package org.neuro4j.studio.properties.ui.celleditor;

import java.util.ArrayList;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;

public class CTreeComboCellEditor extends ExtendedComboBoxCellEditor {

    public CTreeComboCellEditor(Composite parent, Object object, IItemPropertyDescriptor itemPropertyDescriptor, ILabelProvider iLabelProvider) {
        super(parent,
                new ArrayList<Object>(itemPropertyDescriptor.getChoiceOfValues(object)),
                iLabelProvider,
                itemPropertyDescriptor.isSortChoices(object));

    }
}