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
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.properties.descriptor.ComboPropertyDescriptor;
import org.neuro4j.studio.properties.descriptor.ViewNodeResourceNamePropertyDescriptor;
import org.neuro4j.studio.properties.sources.providers.DefaultViewNodeRenderEngineDefinition;
import org.neuro4j.studio.properties.sources.providers.ViewNodeRenderLoader;
import org.neuro4j.web.logic.render.ViewNodeRenderEngineDefinition;

public class ViewNodePropertySource extends PropertySource {

    AdapterFactory af;

    public ViewNodePropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {

        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);

        if (pkg.getViewNode_ViewName().equals(feature)) {
            IPropertyDescriptor desc = new ViewNodeResourceNamePropertyDescriptor((ViewNode) object, feature, "Resource Name");
            return desc;
        } else if (pkg.getViewNode_RenderType().equals(feature)) {
            IPropertyDescriptor desc = new ComboPropertyDescriptor("renderType", "renderType", new String[] { });
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
    	ViewNode viewNode =  (ViewNode) object;
        if (propertyId instanceof EAttributeImpl)
        {
            EAttributeImpl attr = (EAttributeImpl) propertyId;

            if ("viewName".equals(attr.getName())) {
                List<String> list = (List) value;
                if (list != null && list.size() > 0) {
                    value = list.get(0);
                } else {
                    value = null;
                }
            }
        }
        if ("viewName".equals(propertyId)) {
            List<String> list = (List) value;
            if (list != null && list.size() > 0) {
                value = list.get(0);
            } else {
                value = null;
            }

        } else if ("renderType".equals(propertyId)) {
        	if (value instanceof Integer){
                Integer index = (Integer) value;
                String[] names = ViewNodeRenderLoader.getInstance().getRenderNames(ClassloaderHelper.getActiveProjectName());
                if (index == -1)
                {
                    value = ViewNodeRenderLoader.DEFAULT_RENDER.getName();
                }
                else if (index <= names.length - 1)
                {
                    value = names[index];
                } else {
                    value = names[0];
                }        		
        	} 


            itemPropertySource.getPropertyDescriptor(viewNode, "viewName")
                    .setPropertyValue(viewNode, "");
            
            DefaultViewNodeRenderEngineDefinition renderDefinition = ViewNodeRenderLoader.getInstance().getRenderDefinitionByName(ClassloaderHelper.getActiveProjectName(), (String)value);
            
            viewNode.setRenderImpl(renderDefinition.getRenderImpl());

        }

        itemPropertySource.getPropertyDescriptor(object, propertyId)
                .setPropertyValue(object, value);
    }

    @Override
    public Object getPropertyValue(Object propertyId) {
        if (propertyId instanceof ViewNode)
        {
            return "";
        }
        if ("renderType".equals(propertyId)) {
            PropertyValueWrapper value = (PropertyValueWrapper) itemPropertySource
                    .getPropertyDescriptor(object, propertyId)
                    .getPropertyValue(object);
            int index = 0;
            String[] names = ViewNodeRenderLoader.getInstance().getRenderNames(ClassloaderHelper.getActiveProjectName());
            if (value != null)
            {

                index = searchIndex(names, (String) value.getEditableValue(this));
            } else {
                index = searchIndex(names, "jsp");
            }

            return new PropertyValueWrapper(af, object, index, null);
        }
        return super.getPropertyValue(propertyId);
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

    private int searchIndex(String[] names, String name)
    {
        int i = 0;
        for (String n : names)
        {
            if (n.equals(name))
            {
                return i;
            }
            i++;
        }

        return -1;
    }

}