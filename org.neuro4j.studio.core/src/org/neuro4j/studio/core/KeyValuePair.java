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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.KeyValuePair#getKey <em>Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.KeyValuePair#getValue <em>Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.KeyValuePair#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getKeyValuePair()
 * @model
 * @generated
 */
public interface KeyValuePair extends EObject {
    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getKeyValuePair_Key()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.KeyValuePair#getKey <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getKeyValuePair_Value()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.KeyValuePair#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Value Type</em>' attribute.
     * @see #setValueType(int)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getKeyValuePair_ValueType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
     * @generated
     */
    int getValueType();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.KeyValuePair#getValueType <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Value Type</em>' attribute.
     * @see #getValueType()
     * @generated
     */
    void setValueType(int value);

    String getId();

} // KeyValuePair
