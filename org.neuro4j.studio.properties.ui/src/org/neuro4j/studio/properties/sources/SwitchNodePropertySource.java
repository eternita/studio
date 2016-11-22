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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.workflow.enums.StartNodeTypes;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.impl.FollowByRelationNodeImpl;
import org.neuro4j.studio.core.impl.StartNodeImpl;
import org.neuro4j.studio.properties.descriptor.ForkTypesPropertyDescriptor;
import org.neuro4j.studio.properties.descriptor.StartTypesPropertyDescriptor;

public class SwitchNodePropertySource extends PropertySource {

    AdapterFactory af;

    public SwitchNodePropertySource(Object object,
            IItemPropertySource itemPropertySource, AdapterFactory af) {
        super(object, itemPropertySource);
        this.af = af;
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(
            IItemPropertyDescriptor itemPropertyDescriptor) {

        Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
        Object feature = itemPropertyDescriptor.getFeature(object);

        if (pkg.getFollowByRelationNode_Fork().equals(feature)) {
            IPropertyDescriptor desc = new ForkTypesPropertyDescriptor(
                    "fork", "Fork", new String[] { });
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
		if ("fork".equals(propertyId)) {
			Integer index = (Integer) value;

			switch (index) {
			case 2:
				value = "true";
				break;
			case 1:
				value = "false";
				break;
			default:
				value = "";
				break;
			}
			 updateIcon((index==2));

		}

		itemPropertySource.getPropertyDescriptor(object, propertyId).setPropertyValue(object, value);
	}

    @Override
    public Object getPropertyValue(Object propertyId) {

        if ("fork".equals(propertyId)) {
            PropertyValueWrapper value = (PropertyValueWrapper) itemPropertySource
                    .getPropertyDescriptor(object, propertyId)
                    .getPropertyValue(object);
            String op = null;
          
            if (value != null) {
                op = (String) value.getEditableValue(this);
            }
            int index = getIndex(op);
            return new PropertyValueWrapper(af, object, index, null);
        }
        return super.getPropertyValue(propertyId);

    }
    
    private int getIndex(String value){
    	if (value == null) {
    		return 0;
        }
        if (value.equalsIgnoreCase("true")){
        	return  2;
        } else if (value.equalsIgnoreCase("false")) {
        	return  1;
		} 
        return 0;
    }
    
    
    protected void updateIcon(boolean isFork)
    {
		FollowByRelationNodeImpl element = (FollowByRelationNodeImpl) getEditableValue();
        IEditorPart editorPart = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {

            DiagramEditPart diagramPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
            List<EditPart> editPartCollector = new ArrayList<EditPart>();

            Neuro4jDiagramEditorUtil.findElementsInDiagramByID(diagramPart, element, editPartCollector);

            if (editPartCollector.size() > 0)
            {
            	FollowByRelationNodeEditPart editpart = (FollowByRelationNodeEditPart) editPartCollector.get(0);

                editpart.setImage(isFork);

            }

        }
    }

    public Object getEditableValue() {
        return itemPropertySource.getEditableValue(object);
    }

}