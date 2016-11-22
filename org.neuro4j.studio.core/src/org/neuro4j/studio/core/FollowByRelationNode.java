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
 * A representation of the model object '<em><b>Follow By Relation Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.FollowByRelationNode#getRelationName <em>Relation Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.FollowByRelationNode#getMainInput <em>Main Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getFollowByRelationNode()
 * @model
 * @generated
 */
public interface FollowByRelationNode extends ActionNode {
    public static final int X_OFFSET = 25;

    public static final int Y_OFFSET = 20;
    
    public static final String FORK = "FORK";

    /**
     * Returns the value of the '<em><b>Relation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relation Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Relation Name</em>' attribute.
     * @see #setRelationName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getFollowByRelationNode_RelationName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getRelationName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.FollowByRelationNode#getRelationName
     * <em>Relation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Relation Name</em>' attribute.
     * @see #getRelationName()
     * @generated
     */
    void setRelationName(String value);

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
     * @see org.neuro4j.studio.core.Neuro4jPackage#getFollowByRelationNode_MainInput()
     * @model
     * @generated
     */
    
    String getFork();
    void setFork(String value);
    
    OperatorInput getMainInput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.FollowByRelationNode#getMainInput <em>Main Input</em>}'
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Input</em>' reference.
     * @see #getMainInput()
     * @generated
     */
    void setMainInput(OperatorInput value);

} // FollowByRelationNode
