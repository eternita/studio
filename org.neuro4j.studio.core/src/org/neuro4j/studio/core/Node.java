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
package org.neuro4j.studio.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.Node#getId <em>Id</em>}</li>
 * <li>{@link org.neuro4j.studio.core.Node#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getNode_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.Node#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getNode_Description()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.Node#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    public IPropertySource getPropertySource();

    public void setPropertySource(IPropertySource propertySource);

    List<KeyValuePair> getProperties();

    void notifyPropertyChanged(Object oldValue, Object newValue);

    String getName();

    void setName(String value);

    public boolean isUpdated();

    public void update();

    void setBGColor(Color lightgray);

} // Node
