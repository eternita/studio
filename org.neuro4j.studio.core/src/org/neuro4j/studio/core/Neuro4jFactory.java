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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage
 * @generated
 */
public interface Neuro4jFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    Neuro4jFactory eINSTANCE = org.neuro4j.studio.core.impl.Neuro4jFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
    DocumentRoot createDocumentRoot();

    /**
     * Returns a new object of class '<em>Network</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Network</em>'.
     * @generated
     */
    Network createNetwork();

    /**
     * Returns a new object of class '<em>Action Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Action Node</em>'.
     * @generated
     */
    ActionNode createActionNode();

    /**
     * Returns a new object of class '<em>Join Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Join Node</em>'.
     * @generated
     */
    JoinNode createJoinNode();

    /**
     * Returns a new object of class '<em>Decision Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Decision Node</em>'.
     * @generated
     */
    DecisionNode createDecisionNode();

    /**
     * Returns a new object of class '<em>Loop Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Loop Node</em>'.
     * @generated
     */
    LoopNode createLoopNode();

    /**
     * Returns a new object of class '<em>Call Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Call Node</em>'.
     * @generated
     */
    CallNode createCallNode();

    /**
     * Returns a new object of class '<em>Start Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Start Node</em>'.
     * @generated
     */
    StartNode createStartNode();

    /**
     * Returns a new object of class '<em>End Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>End Node</em>'.
     * @generated
     */
    EndNode createEndNode();

    /**
     * Returns a new object of class '<em>Mapper Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Mapper Node</em>'.
     * @generated
     */
    MapperNode createMapperNode();

    /**
     * Returns a new object of class '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Node</em>'.
     * @generated
     */
    Node createNode();

    /**
     * Returns a new object of class '<em>Key Value Pair</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Key Value Pair</em>'.
     * @generated
     */
    KeyValuePair createKeyValuePair();

    /**
     * Returns a new object of class '<em>In Out Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>In Out Parameter</em>'.
     * @generated
     */
    InOutParameter createInOutParameter();

    /**
     * Returns a new object of class '<em>Follow By Relation Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Follow By Relation Node</em>'.
     * @generated
     */
    FollowByRelationNode createFollowByRelationNode();

    /**
     * Returns a new object of class '<em>Logic Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Logic Node</em>'.
     * @generated
     */
    LogicNode createLogicNode();

    /**
     * Returns a new object of class '<em>Operator Output</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Operator Output</em>'.
     * @generated
     */
    OperatorOutput createOperatorOutput();

    /**
     * Returns a new object of class '<em>Operator Input</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Operator Input</em>'.
     * @generated
     */
    OperatorInput createOperatorInput();

    /**
     * Returns a new object of class '<em>View Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>View Node</em>'.
     * @generated
     */
    ViewNode createViewNode();

    /**
     * Returns a new object of class '<em>Note Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Note Node</em>'.
     * @generated
     */
    NoteNode createNoteNode();

    /**
     * Returns a new object of class '<em>Standard Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Standard Node</em>'.
     * @generated
     */
    StandardNode createStandardNode();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    Neuro4jPackage getNeuro4jPackage();

} // Neuro4jFactory
