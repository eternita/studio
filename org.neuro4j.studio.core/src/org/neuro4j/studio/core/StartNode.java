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
import org.neuro4j.studio.core.util.PropetiesConstants;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.StartNode#getType <em>Type</em>}</li>
 * <li>{@link org.neuro4j.studio.core.StartNode#getInputParameters <em>Input Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.StartNode#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getStartNode()
 * @model
 * @generated
 */
public interface StartNode extends ActionNode {

    public static final String NEXT = PropetiesConstants.RELATION_DEFAULT_NAME;

    public static final int X_OFFSET = 10;

    public static final int Y_OFFSET = 10;

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getStartNode_Type()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.StartNode#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Input Parameters</b></em>' reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.InOutParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Parameters</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Input Parameters</em>' reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getStartNode_InputParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getInputParameters();

    /**
     * Returns the value of the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main Output</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main Output</em>' reference.
     * @see #setMainOutput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getStartNode_MainOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.StartNode#getMainOutput <em>Main Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Output</em>' reference.
     * @see #getMainOutput()
     * @generated
     */
    void setMainOutput(OperatorOutput value);

} // StartNode
