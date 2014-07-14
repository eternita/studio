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
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.impl.NodeImpl;
import org.neuro4j.studio.core.impl.StandardNodeImpl;
import org.neuro4j.studio.core.util.OutputNamesUtils;
import org.neuro4j.studio.properties.descriptor.NodeNamePropertyDescriptor;

public class OutputPropertySource extends PropertySource {

    AdapterFactory af;

    public OutputPropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {
        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);
        if (pkg.getOperatorOutput_Name().equals(feature)) {
            NodeImpl actionNode = (NodeImpl) object;
            if (OutputNamesUtils.getRelationsNames(actionNode.eContainer()) != null) {
                IPropertyDescriptor desc = new NodeNamePropertyDescriptor(
                        (ActionNodeImpl) actionNode.eContainer(),
                        itemPropertyDescriptor);
                return desc;
            } else if (actionNode.eContainer() instanceof StandardNodeImpl)
            {
                IPropertyDescriptor desc = new TextPropertyDescriptor("standardName", "Name");
                return desc;
            } else {
                return new TextPropertyDescriptor("name", "Name");
            }
            // inputParameterElementProperties.getPropertyDescriptors();

        }

        return super.createPropertyDescriptor(itemPropertyDescriptor);

    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        // TODO Auto-generated method stub
        return super.getPropertyDescriptors();
    }

    @Override
    public void setPropertyValue(Object propertyId, Object value) {
        if (object instanceof OperatorOutput && "name".equals(propertyId)
                && value instanceof Integer) {
            NodeImpl eClass = (NodeImpl) object;
            ActionNode actionNode = (ActionNode) eClass.eContainer();
            Object newValue = OutputNamesUtils.getValueByIndex(actionNode,
                    (Integer) value);
            updateOtherConnections(actionNode, value);
            if (newValue != null) {
                value = newValue;
            }
        }

        itemPropertySource.getPropertyDescriptor(object, propertyId)
                .setPropertyValue(object, value);

    }

    private void updateOtherConnections(ActionNode actionNode, Object newSelected)
    {
        actionNode.onConnectionNameChange(newSelected);
    }

    @Override
    public Object getPropertyValue(Object propertyId) {
        if (object instanceof OperatorOutput && "name".equals(propertyId)) {
            NodeImpl eClass = (NodeImpl) object;
            ActionNode actionNode = (ActionNode) eClass.eContainer();
            PropertyValueWrapper value = (PropertyValueWrapper) super
                    .getPropertyValue(propertyId);
            String strValue = null;
            Object newValue = null;
            if (value != null) {
                strValue = (String) value.getEditableValue(this);

            }

            newValue = OutputNamesUtils.getIndexByValue(actionNode, strValue);
            if (newValue == null)
            {
                newValue = strValue;
            }
            return new PropertyValueWrapper(af, object, newValue, null);

        } else if ("standardName".equals(propertyId)) {

            return new PropertyValueWrapper(af, object, ((OperatorOutput) object).getName(), null);
        }

        // if (propertyId.equals("inputParameters"))
        // return new SizePropertySource(null);
        // if (propertyId.equals("name"))
        // return 0;

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

}