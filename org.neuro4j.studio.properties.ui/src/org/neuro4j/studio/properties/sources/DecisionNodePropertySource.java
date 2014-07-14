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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.properties.descriptor.DecisionCompTypePropertyDescriptor;
import org.neuro4j.workflow.enums.DecisionCompTypes;
import org.neuro4j.studio.properties.descriptor.DecisionOperatorPropertyDescriptor;
import org.neuro4j.workflow.enums.DecisionOperators;

public class DecisionNodePropertySource extends PropertySource {

    AdapterFactory af;

    public DecisionNodePropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {
        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);
        if (pkg.getDecisionNode_Operator().equals(feature)) {
            IPropertyDescriptor desc = new DecisionOperatorPropertyDescriptor(
                    "operator", "Operator", new String[] { });
            return desc;
        } else if (pkg.getDecisionNode_CompType().equals(feature)) {
            IPropertyDescriptor desc = new DecisionCompTypePropertyDescriptor(
                    "compType", "Comparison Type", new String[] { });
            return desc;

        }

        return super.createPropertyDescriptor(itemPropertyDescriptor);

    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        return super.getPropertyDescriptors();
    }

    @Override
    public void setPropertyValue(Object propertyId, Object value) {
        if ("operator".equals(propertyId)) {
            Integer index = (Integer) value;
            DecisionOperators[] names = DecisionOperators.values();
            value = names[index].name();

        } else if ("compType".equals(propertyId)) {
            Integer index = (Integer) value;
            DecisionCompTypes[] names = DecisionCompTypes.values();
            value = names[index].name();
        }

        itemPropertySource.getPropertyDescriptor(object, propertyId)
                .setPropertyValue(object, value);
    }

    @Override
    public Object getPropertyValue(Object propertyId) {
        if ("operator".equals(propertyId)) {
            PropertyValueWrapper value = (PropertyValueWrapper) itemPropertySource
                    .getPropertyDescriptor(object, propertyId)
                    .getPropertyValue(object);
            DecisionOperators op = null;
            if (value != null) {
                op = DecisionOperators.getByName((String) value
                        .getEditableValue(this));
            }
            if (op == null) {
                op = DecisionOperators.UNDEFINED;
            }
            return new PropertyValueWrapper(af, object, op.value, null);
        } else if ("compType".equals(propertyId)) {
            PropertyValueWrapper value = (PropertyValueWrapper) itemPropertySource
                    .getPropertyDescriptor(object, propertyId)
                    .getPropertyValue(object);
            DecisionCompTypes op = null;
            if (value != null) {
                op = DecisionCompTypes.getByName((String) value
                        .getEditableValue(this));
            }
            if (op == null) {
                op = DecisionCompTypes.context;
            }
            return new PropertyValueWrapper(af, object, op.value, null);
        }

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

}