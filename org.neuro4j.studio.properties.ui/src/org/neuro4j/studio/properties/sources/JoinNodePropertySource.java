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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.impl.JoinNodeImpl;
import org.neuro4j.studio.properties.descriptor.ForkTypesPropertyDescriptor;

public class JoinNodePropertySource extends SwitchNodePropertySource {

	public JoinNodePropertySource(Object object, IItemPropertySource itemPropertySource, AdapterFactory af) {
		super(object, itemPropertySource, af);

	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {

		Neuro4jPackage pkg = Neuro4jPackage.eINSTANCE;
		Object feature = itemPropertyDescriptor.getFeature(object);

		if (pkg.getJoinNode_Fork().equals(feature)) {
			IPropertyDescriptor desc = new ForkTypesPropertyDescriptor("fork", "Fork", new String[] {});
			return desc;

		}

		return super.createPropertyDescriptor(itemPropertyDescriptor);

	}
	
    protected void updateIcon(boolean isFork)
    {
    	JoinNodeImpl element = (JoinNodeImpl) getEditableValue();
        IEditorPart editorPart = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {

            DiagramEditPart diagramPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
            List<EditPart> editPartCollector = new ArrayList<EditPart>();

            Neuro4jDiagramEditorUtil.findElementsInDiagramByID(diagramPart, element, editPartCollector);

            if (editPartCollector.size() > 0)
            {
            	JoinNodeEditPart editpart = (JoinNodeEditPart) editPartCollector.get(0);

                editpart.setImage(isFork);

            }

        }
    }

}