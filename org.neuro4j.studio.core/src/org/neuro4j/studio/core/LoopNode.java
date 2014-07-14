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

import org.neuro4j.studio.core.util.PropetiesConstants;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getLoopExit <em>Loop Exit</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getLoopInput <em>Loop Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getIteratorKey <em>Iterator Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getElementKey <em>Element Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getMainExit <em>Main Exit</em>}</li>
 * <li>{@link org.neuro4j.studio.core.LoopNode#getMainInput <em>Main Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode()
 * @model
 * @generated
 */
public interface LoopNode extends ActionNode {

    public static final int X_OFFSET = 25;

    public static final int Y_OFFSET = 20;

    public static final String EXIT = PropetiesConstants.RELATION_DEFAULT_NAME;
    public static final String LOOP_EXIT = "LOOP_EXIT";
    public static final String LOOP_INPUT = "LOOP_INPUT";
    public static final String INPUT = "INPUT";

    /**
     * Returns the value of the '<em><b>Loop Exit</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loop Exit</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Loop Exit</em>' reference.
     * @see #setLoopExit(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_LoopExit()
     * @model
     * @generated
     */
    OperatorOutput getLoopExit();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getLoopExit <em>Loop Exit</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Loop Exit</em>' reference.
     * @see #getLoopExit()
     * @generated
     */
    void setLoopExit(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Loop Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loop Input</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Loop Input</em>' reference.
     * @see #setLoopInput(OperatorInput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_LoopInput()
     * @model
     * @generated
     */
    OperatorInput getLoopInput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getLoopInput <em>Loop Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Loop Input</em>' reference.
     * @see #getLoopInput()
     * @generated
     */
    void setLoopInput(OperatorInput value);

    /**
     * Returns the value of the '<em><b>Iterator Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Iterator Key</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Iterator Key</em>' attribute.
     * @see #setIteratorKey(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_IteratorKey()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getIteratorKey();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getIteratorKey <em>Iterator Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Iterator Key</em>' attribute.
     * @see #getIteratorKey()
     * @generated
     */
    void setIteratorKey(String value);

    /**
     * Returns the value of the '<em><b>Element Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element Key</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Element Key</em>' attribute.
     * @see #setElementKey(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_ElementKey()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getElementKey();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getElementKey <em>Element Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Element Key</em>' attribute.
     * @see #getElementKey()
     * @generated
     */
    void setElementKey(String value);

    /**
     * Returns the value of the '<em><b>Main Exit</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main Exit</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main Exit</em>' reference.
     * @see #setMainExit(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_MainExit()
     * @model
     * @generated
     */
    OperatorOutput getMainExit();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getMainExit <em>Main Exit</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Exit</em>' reference.
     * @see #getMainExit()
     * @generated
     */
    void setMainExit(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Main Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main Input</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main Input</em>' reference.
     * @see #setMainInput(OperatorInput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getLoopNode_MainInput()
     * @model
     * @generated
     */
    OperatorInput getMainInput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.LoopNode#getMainInput <em>Main Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Input</em>' reference.
     * @see #getMainInput()
     * @generated
     */
    void setMainInput(OperatorInput value);

} // LoopNode
