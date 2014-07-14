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
 * A representation of the model object '<em><b>In Out Parameter</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#getClassName <em>Class Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#isOptional <em>Optional</em>}</li>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#getDescription <em>Description</em>}</li>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#getValue <em>Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.InOutParameter#getParamType <em>Param Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter()
 * @model
 * @generated
 */
public interface InOutParameter extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Class Name</em>' attribute.
     * @see #setClassName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_ClassName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getClassName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#getClassName <em>Class Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Class Name</em>' attribute.
     * @see #getClassName()
     * @generated
     */
    void setClassName(String value);

    /**
     * Returns the value of the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #setOptional(boolean)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_Optional()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Optional</em>' attribute.
     * @see #isOptional()
     * @generated
     */
    void setOptional(boolean value);

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_Description()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#getDescription <em>Description</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_Value()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#getValue <em>Value</em>}' attribute.
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
     * Returns the value of the '<em><b>Param Type</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Param Type</em>' attribute.
     * @see #setParamType(int)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getInOutParameter_ParamType()
     * @model default="0" dataType="org.eclipse.emf.ecore.xml.type.Int"
     * @generated
     */
    int getParamType();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.InOutParameter#getParamType <em>Param Type</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Param Type</em>' attribute.
     * @see #getParamType()
     * @generated
     */
    void setParamType(int value);

    boolean isValid();

} // InOutParameter
