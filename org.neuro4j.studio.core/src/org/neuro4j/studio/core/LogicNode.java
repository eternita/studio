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
 * A representation of the model object '<em><b>Logic Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.LogicNode#getClassName <em>Class Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LogicNode#getMainOutput <em>Main Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LogicNode#getErrorOutput <em>Error Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LogicNode#isHasErrorOutput <em>Has Error Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LogicNode#getInParameters <em>In Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LogicNode#getOutParameters <em>Out Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode()
 * @model
 * @generated
 */
public interface LogicNode extends ActionNode {
    public static final int X_OFFSET = 11;

    public static final int Y_OFFSET = 17;

    public static final String NEXT = PropetiesConstants.RELATION_DEFAULT_NAME;
    public static final String ERROR = PropetiesConstants.RELATION_ERROR_NAME;

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_ClassName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getClassName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LogicNode#getClassName <em>Class Name</em>}' attribute.
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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_MainOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LogicNode#getMainOutput <em>Main Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Output</em>' reference.
     * @see #getMainOutput()
     * @generated
     */
    void setMainOutput(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Error Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Error Output</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Error Output</em>' reference.
     * @see #setErrorOutput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_ErrorOutput()
     * @model
     * @generated
     */
    OperatorOutput getErrorOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LogicNode#getErrorOutput <em>Error Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Error Output</em>' reference.
     * @see #getErrorOutput()
     * @generated
     */
    void setErrorOutput(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Has Error Output</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Has Error Output</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Has Error Output</em>' attribute.
     * @see #setHasErrorOutput(boolean)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_HasErrorOutput()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     * @generated
     */
    boolean isHasErrorOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LogicNode#isHasErrorOutput <em>Has Error Output</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Has Error Output</em>' attribute.
     * @see #isHasErrorOutput()
     * @generated
     */
    void setHasErrorOutput(boolean value);

    /**
     * Returns the value of the '<em><b>In Parameters</b></em>' reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.InOutParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Parameters</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>In Parameters</em>' reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_InParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getInParameters();

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLogicNode_OutParameters()
     * @model
     * @generated
     */
    EList<InOutParameter> getOutParameters();

} // LogicNode
