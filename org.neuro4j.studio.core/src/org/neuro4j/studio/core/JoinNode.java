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
 * A representation of the model object '<em><b>Join Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.JoinNode#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getJoinNode()
 * @model extendedMetaData="name='Action' kind='elementOnly'"
 * @generated
 */
public interface JoinNode extends ActionNode {

    public static final int X_OFFSET = 35;

    public static final int Y_OFFSET = 35;

    public static final String NEXT = "NEXT";

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getJoinNode_MainOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.JoinNode#getMainOutput <em>Main Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Output</em>' reference.
     * @see #getMainOutput()
     * @generated
     */
    void setMainOutput(OperatorOutput value);
} // JoinNode
