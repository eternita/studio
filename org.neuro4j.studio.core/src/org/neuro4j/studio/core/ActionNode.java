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
import org.eclipse.swt.graphics.Color;
import org.neuro4j.studio.core.format.f4j.NodeXML;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.ActionNode#getInput <em>Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.ActionNode#getOutput <em>Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.ActionNode#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.ActionNode#getX <em>X</em>}</li>
 * <li>{@link org.neuro4j.studio.core.ActionNode#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode()
 * @model extendedMetaData="name='Action' kind='elementOnly'"
 * @generated
 */
public interface ActionNode extends Node {
    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.OperatorInput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' reference list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Input</em>' containment reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode_Input()
     * @model containment="true" changeable="false"
     *        extendedMetaData="kind='attribute' name='subtopics'"
     * @generated
     */
    EList<OperatorInput> getInput();

    /**
     * Returns the value of the '<em><b>Output</b></em>' containment reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.OperatorOutput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output</em>' containment reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Output</em>' containment reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode_Output()
     * @model containment="true" changeable="false"
     * @generated
     */
    EList<OperatorOutput> getOutput();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.ActionNode#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>X</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>X</em>' attribute.
     * @see #setX(int)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode_X()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
     * @generated
     */
    int getX();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.ActionNode#getX <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>X</em>' attribute.
     * @see #getX()
     * @generated
     */
    void setX(int value);

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setY(int)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getActionNode_Y()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
     * @generated
     */
    int getY();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.ActionNode#getY <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Y</em>' attribute.
     * @see #getY()
     * @generated
     */
    void setY(int value);

    /**
     * Read node specific properties from EClass to Entity
     * 
     * @param entity
     */
    public void setNodeSpecificProperties(NodeXML entity);

    /**
     * Read node specific properties from Entity to EClass
     * 
     * @param entity
     */
    public void getNodeSpecificProperties(NodeXML entity);

    /**
     * @param count
     * @return
     */
    public String getDefaultName(int count);

    /**
     * @return
     */
    public String getDefaultName();

    /**
     * Calls once connection from this node was changed.
     * 
     * @param newSelected
     */
    void onConnectionNameChange(Object newSelected);

    void setNetwork(Network network);

    String buildToolTip();

    String getLogicImplementationClassName();
    
    NodeType getNodeType();

    Network getNetwork();

    /**
     * If node was replaced by other but uses the same id
     * 
     * @return
     */

    public int getXOffset();

    public int getYOffset();

    void setBGColor(Color lightgray);

    public void setOwnIcon();

    ActionNode createPasteClone(Network net);

} // ActionNode
