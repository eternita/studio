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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.ViewNode#getViewName <em>View Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.ViewNode#getDynamicViewName <em>Dynamic View Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getViewNode()
 * @model
 * @generated
 */
public interface ViewNode extends ActionNode {

    public static final int X_OFFSET = 28;

    public static final int Y_OFFSET = 40;

    /**
     * Returns the value of the '<em><b>View Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>View Name</em>' attribute.
     * @see #setViewName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getViewNode_ViewName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getViewName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.ViewNode#getViewName <em>View Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>View Name</em>' attribute.
     * @see #getViewName()
     * @generated
     */
    void setViewName(String value);
    
    void setRenderImpl(String value);

    /**
     * Returns the value of the '<em><b>Dynamic View Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic View Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Dynamic View Name</em>' attribute.
     * @see #setDynamicViewName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getViewNode_DynamicViewName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getDynamicViewName();

    String getRenderType();
    
    String getRenderImpl();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.ViewNode#getDynamicViewName <em>Dynamic View Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Dynamic View Name</em>' attribute.
     * @see #getDynamicViewName()
     * @generated
     */
    void setDynamicViewName(String value);

} // ViewNode
