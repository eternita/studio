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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.EndNode#getMode <em>Mode</em>}</li>
 * <li>{@link org.neuro4j.studio.core.EndNode#getOutParameters <em>Out Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getEndNode()
 * @model
 * @generated
 */
public interface EndNode extends ActionNode {
    public static final int X_OFFSET = 10;

    public static final int Y_OFFSET = 35;

    /**
     * Returns the value of the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mode</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mode</em>' attribute.
     * @see #setMode(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getEndNode_Mode()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getMode();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.EndNode#getMode <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Mode</em>' attribute.
     * @see #getMode()
     * @generated
     */
    void setMode(String value);

    /**
     * Returns the value of the '<em><b>Out Parameters</b></em>' reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.InOutParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Out Parameters</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Out Parameters</em>' reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getEndNode_OutParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getOutParameters();

} // EndNode
