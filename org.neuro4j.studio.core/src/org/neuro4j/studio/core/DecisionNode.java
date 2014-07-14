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
 * A representation of the model object '<em><b>Decision Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getMainTrueOutput <em>Main True Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getMainFalseOutput <em>Main False Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getMainInput <em>Main Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getOperator <em>Operator</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getCompType <em>Comp Type</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getCompKey <em>Comp Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.DecisionNode#getDecisionKey <em>Decision Key</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode()
 * @model
 * @generated
 */
public interface DecisionNode extends ActionNode {

    public static final int X_OFFSET = 25;

    public static final int Y_OFFSET = 20;
    public static String TRUE = "NEXT";

    public static String FALSE = "FALSE";

    /**
     * Returns the value of the '<em><b>Main True Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main True Output</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main True Output</em>' reference.
     * @see #setMainTrueOutput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_MainTrueOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainTrueOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getMainTrueOutput <em>Main True Output</em>}'
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main True Output</em>' reference.
     * @see #getMainTrueOutput()
     * @generated
     */
    void setMainTrueOutput(OperatorOutput value);

    /**
     * Returns the value of the '<em><b>Main False Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main False Output</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main False Output</em>' reference.
     * @see #setMainFalseOutput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_MainFalseOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainFalseOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getMainFalseOutput <em>Main False Output</em>}
     * ' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main False Output</em>' reference.
     * @see #getMainFalseOutput()
     * @generated
     */
    void setMainFalseOutput(OperatorOutput value);

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_MainInput()
     * @model
     * @generated
     */
    OperatorInput getMainInput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getMainInput <em>Main Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Input</em>' reference.
     * @see #getMainInput()
     * @generated
     */
    void setMainInput(OperatorInput value);

    /**
     * Returns the value of the '<em><b>Operator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Operator</em>' attribute.
     * @see #setOperator(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_Operator()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getOperator();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getOperator <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Operator</em>' attribute.
     * @see #getOperator()
     * @generated
     */
    void setOperator(String value);

    /**
     * Returns the value of the '<em><b>Comp Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comp Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Comp Type</em>' attribute.
     * @see #setCompType(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_CompType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getCompType();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getCompType <em>Comp Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Comp Type</em>' attribute.
     * @see #getCompType()
     * @generated
     */
    void setCompType(String value);

    /**
     * Returns the value of the '<em><b>Comp Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comp Key</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Comp Key</em>' attribute.
     * @see #setCompKey(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_CompKey()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getCompKey();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getCompKey <em>Comp Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Comp Key</em>' attribute.
     * @see #getCompKey()
     * @generated
     */
    void setCompKey(String value);

    /**
     * Returns the value of the '<em><b>Decision Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Decision Key</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Decision Key</em>' attribute.
     * @see #setDecisionKey(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getDecisionNode_DecisionKey()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getDecisionKey();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.DecisionNode#getDecisionKey <em>Decision Key</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Decision Key</em>' attribute.
     * @see #getDecisionKey()
     * @generated
     */
    void setDecisionKey(String value);

} // DecisionNode
