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

import java.util.Set;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.CallNode#getFlowName <em>Flow Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.CallNode#getDynamicFlowName <em>Dynamic Flow Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.CallNode#getInputParameters <em>Input Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.CallNode#getOutputParameters <em>Output Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getCallNode()
 * @model
 * @generated
 */
public interface CallNode extends ActionNode {

    public static final int X_OFFSET = 10;

    public static final int Y_OFFSET = 17;

    public static final String NEXT = "NEXT";

    /**
     * Returns the value of the '<em><b>Flow Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Flow Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Flow Name</em>' attribute.
     * @see #setFlowName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getCallNode_FlowName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getFlowName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.CallNode#getFlowName <em>Flow Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Flow Name</em>' attribute.
     * @see #getFlowName()
     * @generated
     */
    void setFlowName(String value);

    /**
     * Returns the value of the '<em><b>Dynamic Flow Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Flow Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Dynamic Flow Name</em>' attribute.
     * @see #setDynamicFlowName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getCallNode_DynamicFlowName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getDynamicFlowName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.CallNode#getDynamicFlowName <em>Dynamic Flow Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Dynamic Flow Name</em>' attribute.
     * @see #getDynamicFlowName()
     * @generated
     */
    void setDynamicFlowName(String value);

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getCallNode_InputParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getInputParameters();

    /**
     * Returns the value of the '<em><b>Output Parameters</b></em>' reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.InOutParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Parameters</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Output Parameters</em>' reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getCallNode_OutputParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getOutputParameters();

    Set<String> getUsedOutputNames();

} // CallNode
