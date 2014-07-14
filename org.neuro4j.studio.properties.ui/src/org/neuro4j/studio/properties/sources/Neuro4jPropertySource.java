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

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.impl.ActionNodeImpl;
import org.neuro4j.studio.core.impl.NodeImpl;
import org.neuro4j.studio.core.util.OutputNamesUtils;
import org.neuro4j.studio.properties.descriptor.CallNodeFlowNamePropertyDescriptor;
import org.neuro4j.studio.properties.descriptor.NodeNamePropertyDescriptor;

public class Neuro4jPropertySource extends PropertySource {

    AdapterFactory af;

    public Neuro4jPropertySource(Object object,
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
            if (OutputNamesUtils.getRelationsNames((ActionNodeImpl) actionNode.eContainer()) != null)
            {
                IPropertyDescriptor desc = new NodeNamePropertyDescriptor((ActionNodeImpl) actionNode.eContainer(), itemPropertyDescriptor);
                return desc;
            }

        } else if (pkg.getCallNode_FlowName().equals(feature)) {
            IPropertyDescriptor desc = new CallNodeFlowNamePropertyDescriptor("flowName", "Flow Name");
            return desc;
        }

        return super.createPropertyDescriptor(itemPropertyDescriptor);

    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        // TODO Auto-generated method stub
        return super.getPropertyDescriptors();
    }

    @Override
    public void setPropertyValue(Object propertyId, Object value)
    {
        if (object instanceof OperatorOutput && "name".equals(propertyId) && value instanceof Integer)
        {
            NodeImpl eClass = (NodeImpl) object;
            ActionNode actionNode = (ActionNode) eClass.eContainer();
            Object newValue = OutputNamesUtils.getValueByIndex(actionNode, (Integer) value);
            if (newValue != null)
            {
                value = newValue;
            }
        } else if (object instanceof CallNode && "flowName".equals(propertyId))
        {
            List<String> list = (List) value;
            if (list != null && list.size() > 0)
            {
                value = list.get(0);
            } else {
                value = null;
            }
        }

        itemPropertySource.getPropertyDescriptor(object, propertyId).setPropertyValue(object, value);
    }

    @Override
    public Object getPropertyValue(Object propertyId) {
        if (object instanceof OperatorOutput && "name".equals(propertyId))
        {
            NodeImpl eClass = (NodeImpl) object;
            ActionNode actionNode = (ActionNode) eClass.eContainer();
            PropertyValueWrapper value = (PropertyValueWrapper) super.getPropertyValue(propertyId);
            String strValue = null;
            Integer newValue = null;
            if (value != null)
            {
                strValue = (String) value.getEditableValue(this);

            }

            newValue = OutputNamesUtils.getIndexByValue(actionNode, strValue);

            return new PropertyValueWrapper(af, object, newValue, null);

        }

        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue()
    {
        return itemPropertySource.getEditableValue(object);
    }

}