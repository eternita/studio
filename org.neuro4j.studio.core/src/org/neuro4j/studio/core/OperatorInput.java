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
 * A representation of the model object '<em><b>Operator Input</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.OperatorInput#getInput <em>Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.OperatorInput#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorInput()
 * @model
 * @generated
 */
public interface OperatorInput extends Node {
    /**
     * Returns the value of the '<em><b>Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Input</em>' reference.
     * @see #setInput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorInput_Input()
     * @model
     * @generated
     */
    OperatorOutput getInput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.OperatorInput#getInput <em>Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Input</em>' reference.
     * @see #getInput()
     * @generated
     */
    void setInput(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' reference isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Node</em>' reference.
     * @see #setNode(ActionNode)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorInput_Node()
     * @model
     * @generated
     */
    ActionNode getNode();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.OperatorInput#getNode <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Node</em>' reference.
     * @see #getNode()
     * @generated
     */
    void setNode(ActionNode value);

} // OperatorInput
