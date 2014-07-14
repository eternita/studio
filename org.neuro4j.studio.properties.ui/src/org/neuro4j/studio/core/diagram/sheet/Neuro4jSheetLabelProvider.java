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
package org.neuro4j.studio.core.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeEditPart;
import org.neuro4j.studio.core.diagram.navigator.Neuro4jNavigatorGroup;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class Neuro4jSheetLabelProvider extends BaseLabelProvider implements
        ILabelProvider {

    /**
     * @generated NOT
     */
    public String getText(Object element) {
        element = unwrap(element);
        if (element instanceof Neuro4jNavigatorGroup) {
            return ((Neuro4jNavigatorGroup) element).getGroupName();
        }

        if (element instanceof StandardNodeEditPart)
        {
            StandardNodeEditPart e = (StandardNodeEditPart) element;
            return e.getPropertySheetLabel();
        } else if (element instanceof NetworkEditPart)
        {
            NetworkEditPart e = (NetworkEditPart) element;
            return e.getPropertySheetLabel();
        }

        IElementType etype = getElementType(getView(element));
        return etype == null ? "" : etype.getDisplayName();
    }

    /**
     * @generated
     */
    public Image getImage(Object element) {
        IElementType etype = getElementType(getView(unwrap(element)));
        return etype == null ? null : Neuro4jElementTypes.getImage(etype);
    }

    /**
     * @generated
     */
    private Object unwrap(Object element) {
        if (element instanceof IStructuredSelection) {
            return ((IStructuredSelection) element).getFirstElement();
        }
        return element;
    }

    /**
     * @generated
     */
    private View getView(Object element) {
        if (element instanceof View) {
            return (View) element;
        }
        if (element instanceof IAdaptable) {
            return (View) ((IAdaptable) element).getAdapter(View.class);
        }
        return null;
    }

    /**
     * @generated
     */
    private IElementType getElementType(View view) {
        // For intermediate views climb up the containment hierarchy to find the one associated with an element type.
        while (view != null) {
            int vid = Neuro4jVisualIDRegistry.getVisualID(view);
            IElementType etype = Neuro4jElementTypes.getElementType(vid);
            if (etype != null) {
                return etype;
            }
            view = view.eContainer() instanceof View ? (View) view.eContainer()
                    : null;
        }
        return null;
    }

}
