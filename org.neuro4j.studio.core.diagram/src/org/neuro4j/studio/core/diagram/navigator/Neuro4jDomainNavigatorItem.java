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
package org.neuro4j.studio.core.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * @generated
 */
public class Neuro4jDomainNavigatorItem extends PlatformObject {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { EObject.class,
                IPropertySource.class };
        Platform.getAdapterManager().registerAdapters(
                new IAdapterFactory() {

                    public Object getAdapter(Object adaptableObject,
                            Class adapterType) {
                        if (adaptableObject instanceof org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem) {
                            org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem domainNavigatorItem = (org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem) adaptableObject;
                            EObject eObject = domainNavigatorItem.getEObject();
                            if (adapterType == EObject.class) {
                                return eObject;
                            }
                            if (adapterType == IPropertySource.class) {
                                return domainNavigatorItem
                                        .getPropertySourceProvider()
                                        .getPropertySource(eObject);
                            }
                        }

                        return null;
                    }

                    public Class[] getAdapterList() {
                        return supportedTypes;
                    }
                },
                org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem.class);
    }

    /**
     * @generated
     */
    private Object myParent;

    /**
     * @generated
     */
    private EObject myEObject;

    /**
     * @generated
     */
    private IPropertySourceProvider myPropertySourceProvider;

    /**
     * @generated
     */
    public Neuro4jDomainNavigatorItem(EObject eObject, Object parent,
            IPropertySourceProvider propertySourceProvider) {
        myParent = parent;
        myEObject = eObject;
        myPropertySourceProvider = propertySourceProvider;
    }

    /**
     * @generated
     */
    public Object getParent() {
        return myParent;
    }

    /**
     * @generated
     */
    public EObject getEObject() {
        return myEObject;
    }

    /**
     * @generated
     */
    public IPropertySourceProvider getPropertySourceProvider() {
        return myPropertySourceProvider;
    }

    /**
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem) {
            return EcoreUtil
                    .getURI(getEObject())
                    .equals(EcoreUtil
                            .getURI(((org.neuro4j.studio.core.diagram.navigator.Neuro4jDomainNavigatorItem) obj)
                                    .getEObject()));
        }
        return super.equals(obj);
    }

    /**
     * @generated
     */
    public int hashCode() {
        return EcoreUtil.getURI(getEObject()).hashCode();
    }

}
