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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.neuro4j.studio.core.Neuro4jFactory
 * @model kind="package"
 * @generated
 */
public interface Neuro4jPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "core";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.neuro4j.org/neuro2";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "Neuro4j";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    Neuro4jPackage eINSTANCE = org.neuro4j.studio.core.impl.Neuro4jPackageImpl.init();

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.DocumentRootImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 0;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Map</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MAP = 3;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.NetworkImpl <em>Network</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.NetworkImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNetwork()
     * @generated
     */
    int NETWORK = 1;

    /**
     * The feature id for the '<em><b>Root Action</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK__ROOT_ACTION = 0;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK__TITLE = 1;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK__VISIBILITY = 2;

    /**
     * The number of structural features of the '<em>Network</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.NodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNode()
     * @generated
     */
    int NODE = 10;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE__ID = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE__DESCRIPTION = 1;

    /**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.ActionNodeImpl <em>Action Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.ActionNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getActionNode()
     * @generated
     */
    int ACTION_NODE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__ID = NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__DESCRIPTION = NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__INPUT = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__OUTPUT = NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__NAME = NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__X = NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE__Y = NODE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Action Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ACTION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.JoinNodeImpl <em>Join Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.JoinNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getJoinNode()
     * @generated
     */
    int JOIN_NODE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE__MAIN_OUTPUT = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Join Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JOIN_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.DecisionNodeImpl <em>Decision Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.DecisionNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getDecisionNode()
     * @generated
     */
    int DECISION_NODE = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Main True Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__MAIN_TRUE_OUTPUT = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Main False Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__MAIN_FALSE_OUTPUT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Main Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__MAIN_INPUT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Operator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__OPERATOR = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Comp Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__COMP_TYPE = ACTION_NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Comp Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__COMP_KEY = ACTION_NODE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Decision Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE__DECISION_KEY = ACTION_NODE_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Decision Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DECISION_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.LoopNodeImpl <em>Loop Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.LoopNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getLoopNode()
     * @generated
     */
    int LOOP_NODE = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Loop Exit</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__LOOP_EXIT = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Loop Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__LOOP_INPUT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Iterator Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__ITERATOR_KEY = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Element Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__ELEMENT_KEY = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Main Exit</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__MAIN_EXIT = ACTION_NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Main Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE__MAIN_INPUT = ACTION_NODE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Loop Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.CallNodeImpl <em>Call Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.CallNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getCallNode()
     * @generated
     */
    int CALL_NODE = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Flow Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__FLOW_NAME = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dynamic Flow Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__DYNAMIC_FLOW_NAME = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Input Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__INPUT_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Output Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE__OUTPUT_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Call Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.StartNodeImpl <em>Start Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.StartNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getStartNode()
     * @generated
     */
    int START_NODE = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__TYPE = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Input Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__INPUT_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE__MAIN_OUTPUT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Start Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int START_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.EndNodeImpl <em>End Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.EndNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getEndNode()
     * @generated
     */
    int END_NODE = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__MODE = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Out Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE__OUT_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>End Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int END_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.MapperNodeImpl <em>Mapper Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.MapperNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getMapperNode()
     * @generated
     */
    int MAPPER_NODE = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Key Value</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__KEY_VALUE = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE__MAIN_OUTPUT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Mapper Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MAPPER_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.KeyValuePairImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getKeyValuePair()
     * @generated
     */
    int KEY_VALUE_PAIR = 11;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int KEY_VALUE_PAIR__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int KEY_VALUE_PAIR__VALUE = 1;

    /**
     * The feature id for the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int KEY_VALUE_PAIR__VALUE_TYPE = 2;

    /**
     * The number of structural features of the '<em>Key Value Pair</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int KEY_VALUE_PAIR_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.InOutParameterImpl <em>In Out Parameter</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.InOutParameterImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getInOutParameter()
     * @generated
     */
    int IN_OUT_PARAMETER = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__NAME = 0;

    /**
     * The feature id for the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__CLASS_NAME = 1;

    /**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__OPTIONAL = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__VALUE = 4;

    /**
     * The feature id for the '<em><b>Param Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER__PARAM_TYPE = 5;

    /**
     * The number of structural features of the '<em>In Out Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IN_OUT_PARAMETER_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.FollowByRelationNodeImpl
     * <em>Follow By Relation Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.FollowByRelationNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getFollowByRelationNode()
     * @generated
     */
    int FOLLOW_BY_RELATION_NODE = 13;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Relation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__RELATION_NAME = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Main Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE__MAIN_INPUT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Follow By Relation Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLLOW_BY_RELATION_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.LogicNodeImpl <em>Logic Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.LogicNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getLogicNode()
     * @generated
     */
    int LOGIC_NODE = 14;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__CLASS_NAME = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__MAIN_OUTPUT = ACTION_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Error Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__ERROR_OUTPUT = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Has Error Output</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__HAS_ERROR_OUTPUT = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>In Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__IN_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Out Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE__OUT_PARAMETERS = ACTION_NODE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Logic Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOGIC_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.OperatorOutputImpl <em>Operator Output</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.OperatorOutputImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getOperatorOutput()
     * @generated
     */
    int OPERATOR_OUTPUT = 15;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT__ID = NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT__DESCRIPTION = NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT__SOURCE = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT__NAME = NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT__TARGET = NODE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Operator Output</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_OUTPUT_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.OperatorInputImpl <em>Operator Input</em>}'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.OperatorInputImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getOperatorInput()
     * @generated
     */
    int OPERATOR_INPUT = 16;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_INPUT__ID = NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_INPUT__DESCRIPTION = NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_INPUT__INPUT = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_INPUT__NODE = NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Operator Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATOR_INPUT_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.ViewNodeImpl <em>View Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.ViewNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getViewNode()
     * @generated
     */
    int VIEW_NODE = 17;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__Y = ACTION_NODE__Y;

    /**
     * The feature id for the '<em><b>View Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__VIEW_NAME = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dynamic View Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE__DYNAMIC_VIEW_NAME = ACTION_NODE_FEATURE_COUNT + 1;

    int VIEW_NODE_RENDER_TYPET = ACTION_NODE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>View Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VIEW_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.NoteNodeImpl <em>Note Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.NoteNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNoteNode()
     * @generated
     */
    int NOTE_NODE = 18;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE__Y = ACTION_NODE__Y;

    /**
     * The number of structural features of the '<em>Note Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NOTE_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.neuro4j.studio.core.impl.StandardNodeImpl <em>Standard Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.neuro4j.studio.core.impl.StandardNodeImpl
     * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getStandardNode()
     * @generated
     */
    int STANDARD_NODE = 19;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__ID = ACTION_NODE__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__DESCRIPTION = ACTION_NODE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__INPUT = ACTION_NODE__INPUT;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__OUTPUT = ACTION_NODE__OUTPUT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__NAME = ACTION_NODE__NAME;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__X = ACTION_NODE__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE__Y = ACTION_NODE__Y;

    /**
     * The number of structural features of the '<em>Standard Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STANDARD_NODE_FEATURE_COUNT = ACTION_NODE_FEATURE_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.neuro4j.studio.core.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot();

    /**
     * Returns the meta object for the attribute list '{@link org.neuro4j.studio.core.DocumentRoot#getMixed
     * <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.neuro4j.studio.core.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed();

    /**
     * Returns the meta object for the map '{@link org.neuro4j.studio.core.DocumentRoot#getXMLNSPrefixMap
     * <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.neuro4j.studio.core.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
     * Returns the meta object for the map '{@link org.neuro4j.studio.core.DocumentRoot#getXSISchemaLocation
     * <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.neuro4j.studio.core.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
     * Returns the meta object for the containment reference '{@link org.neuro4j.studio.core.DocumentRoot#getMap
     * <em>Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Map</em>'.
     * @see org.neuro4j.studio.core.DocumentRoot#getMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Map();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.Network <em>Network</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Network</em>'.
     * @see org.neuro4j.studio.core.Network
     * @generated
     */
    EClass getNetwork();

    /**
     * Returns the meta object for the containment reference list '{@link org.neuro4j.studio.core.Network#getRootAction
     * <em>Root Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Root Action</em>'.
     * @see org.neuro4j.studio.core.Network#getRootAction()
     * @see #getNetwork()
     * @generated
     */
    EReference getNetwork_RootAction();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.Network#getTitle <em>Title</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Title</em>'.
     * @see org.neuro4j.studio.core.Network#getTitle()
     * @see #getNetwork()
     * @generated
     */
    EAttribute getNetwork_Title();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.Network#getVisibility
     * <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Visibility</em>'.
     * @see org.neuro4j.studio.core.Network#getVisibility()
     * @see #getNetwork()
     * @generated
     */
    EAttribute getNetwork_Visibility();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.ActionNode <em>Action Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Action Node</em>'.
     * @see org.neuro4j.studio.core.ActionNode
     * @generated
     */
    EClass getActionNode();

    /**
     * Returns the meta object for the containment reference list '{@link org.neuro4j.studio.core.ActionNode#getInput
     * <em>Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Input</em>'.
     * @see org.neuro4j.studio.core.ActionNode#getInput()
     * @see #getActionNode()
     * @generated
     */
    EReference getActionNode_Input();

    /**
     * Returns the meta object for the containment reference list '{@link org.neuro4j.studio.core.ActionNode#getOutput
     * <em>Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Output</em>'.
     * @see org.neuro4j.studio.core.ActionNode#getOutput()
     * @see #getActionNode()
     * @generated
     */
    EReference getActionNode_Output();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.ActionNode#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.neuro4j.studio.core.ActionNode#getName()
     * @see #getActionNode()
     * @generated
     */
    EAttribute getActionNode_Name();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.ActionNode#getX <em>X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>X</em>'.
     * @see org.neuro4j.studio.core.ActionNode#getX()
     * @see #getActionNode()
     * @generated
     */
    EAttribute getActionNode_X();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.ActionNode#getY <em>Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Y</em>'.
     * @see org.neuro4j.studio.core.ActionNode#getY()
     * @see #getActionNode()
     * @generated
     */
    EAttribute getActionNode_Y();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.JoinNode <em>Join Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Join Node</em>'.
     * @see org.neuro4j.studio.core.JoinNode
     * @generated
     */
    EClass getJoinNode();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.JoinNode#getMainOutput
     * <em>Main Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Output</em>'.
     * @see org.neuro4j.studio.core.JoinNode#getMainOutput()
     * @see #getJoinNode()
     * @generated
     */
    EReference getJoinNode_MainOutput();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.DecisionNode <em>Decision Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Decision Node</em>'.
     * @see org.neuro4j.studio.core.DecisionNode
     * @generated
     */
    EClass getDecisionNode();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.DecisionNode#getMainTrueOutput
     * <em>Main True Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main True Output</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getMainTrueOutput()
     * @see #getDecisionNode()
     * @generated
     */
    EReference getDecisionNode_MainTrueOutput();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.DecisionNode#getMainFalseOutput
     * <em>Main False Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main False Output</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getMainFalseOutput()
     * @see #getDecisionNode()
     * @generated
     */
    EReference getDecisionNode_MainFalseOutput();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.DecisionNode#getMainInput
     * <em>Main Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Input</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getMainInput()
     * @see #getDecisionNode()
     * @generated
     */
    EReference getDecisionNode_MainInput();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.DecisionNode#getOperator
     * <em>Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Operator</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getOperator()
     * @see #getDecisionNode()
     * @generated
     */
    EAttribute getDecisionNode_Operator();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.DecisionNode#getCompType
     * <em>Comp Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Comp Type</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getCompType()
     * @see #getDecisionNode()
     * @generated
     */
    EAttribute getDecisionNode_CompType();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.DecisionNode#getCompKey
     * <em>Comp Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Comp Key</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getCompKey()
     * @see #getDecisionNode()
     * @generated
     */
    EAttribute getDecisionNode_CompKey();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.DecisionNode#getDecisionKey
     * <em>Decision Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Decision Key</em>'.
     * @see org.neuro4j.studio.core.DecisionNode#getDecisionKey()
     * @see #getDecisionNode()
     * @generated
     */
    EAttribute getDecisionNode_DecisionKey();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.LoopNode <em>Loop Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Loop Node</em>'.
     * @see org.neuro4j.studio.core.LoopNode
     * @generated
     */
    EClass getLoopNode();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LoopNode#getLoopExit
     * <em>Loop Exit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Loop Exit</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getLoopExit()
     * @see #getLoopNode()
     * @generated
     */
    EReference getLoopNode_LoopExit();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LoopNode#getLoopInput
     * <em>Loop Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Loop Input</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getLoopInput()
     * @see #getLoopNode()
     * @generated
     */
    EReference getLoopNode_LoopInput();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.LoopNode#getIteratorKey
     * <em>Iterator Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Iterator Key</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getIteratorKey()
     * @see #getLoopNode()
     * @generated
     */
    EAttribute getLoopNode_IteratorKey();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.LoopNode#getElementKey
     * <em>Element Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Element Key</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getElementKey()
     * @see #getLoopNode()
     * @generated
     */
    EAttribute getLoopNode_ElementKey();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LoopNode#getMainExit
     * <em>Main Exit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Exit</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getMainExit()
     * @see #getLoopNode()
     * @generated
     */
    EReference getLoopNode_MainExit();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LoopNode#getMainInput
     * <em>Main Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Input</em>'.
     * @see org.neuro4j.studio.core.LoopNode#getMainInput()
     * @see #getLoopNode()
     * @generated
     */
    EReference getLoopNode_MainInput();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.CallNode <em>Call Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Call Node</em>'.
     * @see org.neuro4j.studio.core.CallNode
     * @generated
     */
    EClass getCallNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.CallNode#getFlowName
     * <em>Flow Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Flow Name</em>'.
     * @see org.neuro4j.studio.core.CallNode#getFlowName()
     * @see #getCallNode()
     * @generated
     */
    EAttribute getCallNode_FlowName();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.CallNode#getDynamicFlowName
     * <em>Dynamic Flow Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Dynamic Flow Name</em>'.
     * @see org.neuro4j.studio.core.CallNode#getDynamicFlowName()
     * @see #getCallNode()
     * @generated
     */
    EAttribute getCallNode_DynamicFlowName();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.CallNode#getInputParameters
     * <em>Input Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Input Parameters</em>'.
     * @see org.neuro4j.studio.core.CallNode#getInputParameters()
     * @see #getCallNode()
     * @generated
     */
    EReference getCallNode_InputParameters();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.CallNode#getOutputParameters
     * <em>Output Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Output Parameters</em>'.
     * @see org.neuro4j.studio.core.CallNode#getOutputParameters()
     * @see #getCallNode()
     * @generated
     */
    EReference getCallNode_OutputParameters();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.StartNode <em>Start Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Start Node</em>'.
     * @see org.neuro4j.studio.core.StartNode
     * @generated
     */
    EClass getStartNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.StartNode#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.neuro4j.studio.core.StartNode#getType()
     * @see #getStartNode()
     * @generated
     */
    EAttribute getStartNode_Type();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.StartNode#getInputParameters
     * <em>Input Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Input Parameters</em>'.
     * @see org.neuro4j.studio.core.StartNode#getInputParameters()
     * @see #getStartNode()
     * @generated
     */
    EReference getStartNode_InputParameters();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.StartNode#getMainOutput
     * <em>Main Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Output</em>'.
     * @see org.neuro4j.studio.core.StartNode#getMainOutput()
     * @see #getStartNode()
     * @generated
     */
    EReference getStartNode_MainOutput();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.EndNode <em>End Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>End Node</em>'.
     * @see org.neuro4j.studio.core.EndNode
     * @generated
     */
    EClass getEndNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.EndNode#getMode <em>Mode</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mode</em>'.
     * @see org.neuro4j.studio.core.EndNode#getMode()
     * @see #getEndNode()
     * @generated
     */
    EAttribute getEndNode_Mode();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.EndNode#getOutParameters
     * <em>Out Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Out Parameters</em>'.
     * @see org.neuro4j.studio.core.EndNode#getOutParameters()
     * @see #getEndNode()
     * @generated
     */
    EReference getEndNode_OutParameters();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.MapperNode <em>Mapper Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Mapper Node</em>'.
     * @see org.neuro4j.studio.core.MapperNode
     * @generated
     */
    EClass getMapperNode();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.MapperNode#getKeyValue
     * <em>Key Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Key Value</em>'.
     * @see org.neuro4j.studio.core.MapperNode#getKeyValue()
     * @see #getMapperNode()
     * @generated
     */
    EReference getMapperNode_KeyValue();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.MapperNode#getMainOutput
     * <em>Main Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Output</em>'.
     * @see org.neuro4j.studio.core.MapperNode#getMainOutput()
     * @see #getMapperNode()
     * @generated
     */
    EReference getMapperNode_MainOutput();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Node</em>'.
     * @see org.neuro4j.studio.core.Node
     * @generated
     */
    EClass getNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.Node#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.neuro4j.studio.core.Node#getId()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_Id();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.Node#getDescription
     * <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.neuro4j.studio.core.Node#getDescription()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_Description();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.KeyValuePair <em>Key Value Pair</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Key Value Pair</em>'.
     * @see org.neuro4j.studio.core.KeyValuePair
     * @generated
     */
    EClass getKeyValuePair();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.KeyValuePair#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.neuro4j.studio.core.KeyValuePair#getKey()
     * @see #getKeyValuePair()
     * @generated
     */
    EAttribute getKeyValuePair_Key();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.KeyValuePair#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.neuro4j.studio.core.KeyValuePair#getValue()
     * @see #getKeyValuePair()
     * @generated
     */
    EAttribute getKeyValuePair_Value();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.KeyValuePair#getValueType
     * <em>Value Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Value Type</em>'.
     * @see org.neuro4j.studio.core.KeyValuePair#getValueType()
     * @see #getKeyValuePair()
     * @generated
     */
    EAttribute getKeyValuePair_ValueType();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.InOutParameter <em>In Out Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>In Out Parameter</em>'.
     * @see org.neuro4j.studio.core.InOutParameter
     * @generated
     */
    EClass getInOutParameter();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#getName()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_Name();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#getClassName
     * <em>Class Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Class Name</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#getClassName()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_ClassName();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#isOptional
     * <em>Optional</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#isOptional()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_Optional();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#getDescription
     * <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#getDescription()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_Description();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#getValue <em>Value</em>}
     * '.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#getValue()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_Value();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.InOutParameter#getParamType
     * <em>Param Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Param Type</em>'.
     * @see org.neuro4j.studio.core.InOutParameter#getParamType()
     * @see #getInOutParameter()
     * @generated
     */
    EAttribute getInOutParameter_ParamType();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.FollowByRelationNode
     * <em>Follow By Relation Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Follow By Relation Node</em>'.
     * @see org.neuro4j.studio.core.FollowByRelationNode
     * @generated
     */
    EClass getFollowByRelationNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.FollowByRelationNode#getRelationName
     * <em>Relation Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relation Name</em>'.
     * @see org.neuro4j.studio.core.FollowByRelationNode#getRelationName()
     * @see #getFollowByRelationNode()
     * @generated
     */
    EAttribute getFollowByRelationNode_RelationName();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.FollowByRelationNode#getMainInput
     * <em>Main Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Input</em>'.
     * @see org.neuro4j.studio.core.FollowByRelationNode#getMainInput()
     * @see #getFollowByRelationNode()
     * @generated
     */
    EReference getFollowByRelationNode_MainInput();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.LogicNode <em>Logic Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Logic Node</em>'.
     * @see org.neuro4j.studio.core.LogicNode
     * @generated
     */
    EClass getLogicNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.LogicNode#getClassName
     * <em>Class Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Class Name</em>'.
     * @see org.neuro4j.studio.core.LogicNode#getClassName()
     * @see #getLogicNode()
     * @generated
     */
    EAttribute getLogicNode_ClassName();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LogicNode#getMainOutput
     * <em>Main Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Main Output</em>'.
     * @see org.neuro4j.studio.core.LogicNode#getMainOutput()
     * @see #getLogicNode()
     * @generated
     */
    EReference getLogicNode_MainOutput();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.LogicNode#getErrorOutput
     * <em>Error Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Error Output</em>'.
     * @see org.neuro4j.studio.core.LogicNode#getErrorOutput()
     * @see #getLogicNode()
     * @generated
     */
    EReference getLogicNode_ErrorOutput();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.LogicNode#isHasErrorOutput
     * <em>Has Error Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Has Error Output</em>'.
     * @see org.neuro4j.studio.core.LogicNode#isHasErrorOutput()
     * @see #getLogicNode()
     * @generated
     */
    EAttribute getLogicNode_HasErrorOutput();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.LogicNode#getInParameters
     * <em>In Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>In Parameters</em>'.
     * @see org.neuro4j.studio.core.LogicNode#getInParameters()
     * @see #getLogicNode()
     * @generated
     */
    EReference getLogicNode_InParameters();

    /**
     * Returns the meta object for the reference list '{@link org.neuro4j.studio.core.LogicNode#getOutParameters
     * <em>Out Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Out Parameters</em>'.
     * @see org.neuro4j.studio.core.LogicNode#getOutParameters()
     * @see #getLogicNode()
     * @generated
     */
    EReference getLogicNode_OutParameters();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.OperatorOutput <em>Operator Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Operator Output</em>'.
     * @see org.neuro4j.studio.core.OperatorOutput
     * @generated
     */
    EClass getOperatorOutput();

    /**
     * Returns the meta object for the containment reference '{@link org.neuro4j.studio.core.OperatorOutput#getSource
     * <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Source</em>'.
     * @see org.neuro4j.studio.core.OperatorOutput#getSource()
     * @see #getOperatorOutput()
     * @generated
     */
    EReference getOperatorOutput_Source();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.OperatorOutput#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.neuro4j.studio.core.OperatorOutput#getName()
     * @see #getOperatorOutput()
     * @generated
     */
    EAttribute getOperatorOutput_Name();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.OperatorOutput#getTarget
     * <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Target</em>'.
     * @see org.neuro4j.studio.core.OperatorOutput#getTarget()
     * @see #getOperatorOutput()
     * @generated
     */
    EReference getOperatorOutput_Target();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.OperatorInput <em>Operator Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Operator Input</em>'.
     * @see org.neuro4j.studio.core.OperatorInput
     * @generated
     */
    EClass getOperatorInput();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.OperatorInput#getInput <em>Input</em>}
     * '.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Input</em>'.
     * @see org.neuro4j.studio.core.OperatorInput#getInput()
     * @see #getOperatorInput()
     * @generated
     */
    EReference getOperatorInput_Input();

    /**
     * Returns the meta object for the reference '{@link org.neuro4j.studio.core.OperatorInput#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Node</em>'.
     * @see org.neuro4j.studio.core.OperatorInput#getNode()
     * @see #getOperatorInput()
     * @generated
     */
    EReference getOperatorInput_Node();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.ViewNode <em>View Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>View Node</em>'.
     * @see org.neuro4j.studio.core.ViewNode
     * @generated
     */
    EClass getViewNode();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.ViewNode#getViewName
     * <em>View Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>View Name</em>'.
     * @see org.neuro4j.studio.core.ViewNode#getViewName()
     * @see #getViewNode()
     * @generated
     */
    EAttribute getViewNode_ViewName();

    /**
     * Returns the meta object for the attribute '{@link org.neuro4j.studio.core.ViewNode#getDynamicViewName
     * <em>Dynamic View Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Dynamic View Name</em>'.
     * @see org.neuro4j.studio.core.ViewNode#getDynamicViewName()
     * @see #getViewNode()
     * @generated
     */
    EAttribute getViewNode_DynamicViewName();

    EAttribute getViewNode_RenderType();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.NoteNode <em>Note Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Note Node</em>'.
     * @see org.neuro4j.studio.core.NoteNode
     * @generated
     */
    EClass getNoteNode();

    /**
     * Returns the meta object for class '{@link org.neuro4j.studio.core.StandardNode <em>Standard Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Standard Node</em>'.
     * @see org.neuro4j.studio.core.StandardNode
     * @generated
     */
    EClass getStandardNode();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    Neuro4jFactory getNeuro4jFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.DocumentRootImpl <em>Document Root</em>}
         * ' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.DocumentRootImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

        /**
         * The meta object literal for the '<em><b>Map</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__MAP = eINSTANCE.getDocumentRoot_Map();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.NetworkImpl <em>Network</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.NetworkImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNetwork()
         * @generated
         */
        EClass NETWORK = eINSTANCE.getNetwork();

        /**
         * The meta object literal for the '<em><b>Root Action</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference NETWORK__ROOT_ACTION = eINSTANCE.getNetwork_RootAction();

        /**
         * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NETWORK__TITLE = eINSTANCE.getNetwork_Title();

        /**
         * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NETWORK__VISIBILITY = eINSTANCE.getNetwork_Visibility();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.ActionNodeImpl <em>Action Node</em>}'
         * class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.ActionNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getActionNode()
         * @generated
         */
        EClass ACTION_NODE = eINSTANCE.getActionNode();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ACTION_NODE__INPUT = eINSTANCE.getActionNode_Input();

        /**
         * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ACTION_NODE__OUTPUT = eINSTANCE.getActionNode_Output();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ACTION_NODE__NAME = eINSTANCE.getActionNode_Name();

        /**
         * The meta object literal for the '<em><b>X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ACTION_NODE__X = eINSTANCE.getActionNode_X();

        /**
         * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ACTION_NODE__Y = eINSTANCE.getActionNode_Y();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.JoinNodeImpl <em>Join Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.JoinNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getJoinNode()
         * @generated
         */
        EClass JOIN_NODE = eINSTANCE.getJoinNode();

        /**
         * The meta object literal for the '<em><b>Main Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference JOIN_NODE__MAIN_OUTPUT = eINSTANCE.getJoinNode_MainOutput();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.DecisionNodeImpl <em>Decision Node</em>}
         * ' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.DecisionNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getDecisionNode()
         * @generated
         */
        EClass DECISION_NODE = eINSTANCE.getDecisionNode();

        /**
         * The meta object literal for the '<em><b>Main True Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DECISION_NODE__MAIN_TRUE_OUTPUT = eINSTANCE.getDecisionNode_MainTrueOutput();

        /**
         * The meta object literal for the '<em><b>Main False Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DECISION_NODE__MAIN_FALSE_OUTPUT = eINSTANCE.getDecisionNode_MainFalseOutput();

        /**
         * The meta object literal for the '<em><b>Main Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DECISION_NODE__MAIN_INPUT = eINSTANCE.getDecisionNode_MainInput();

        /**
         * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DECISION_NODE__OPERATOR = eINSTANCE.getDecisionNode_Operator();

        /**
         * The meta object literal for the '<em><b>Comp Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DECISION_NODE__COMP_TYPE = eINSTANCE.getDecisionNode_CompType();

        /**
         * The meta object literal for the '<em><b>Comp Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DECISION_NODE__COMP_KEY = eINSTANCE.getDecisionNode_CompKey();

        /**
         * The meta object literal for the '<em><b>Decision Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DECISION_NODE__DECISION_KEY = eINSTANCE.getDecisionNode_DecisionKey();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.LoopNodeImpl <em>Loop Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.LoopNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getLoopNode()
         * @generated
         */
        EClass LOOP_NODE = eINSTANCE.getLoopNode();

        /**
         * The meta object literal for the '<em><b>Loop Exit</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOOP_NODE__LOOP_EXIT = eINSTANCE.getLoopNode_LoopExit();

        /**
         * The meta object literal for the '<em><b>Loop Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOOP_NODE__LOOP_INPUT = eINSTANCE.getLoopNode_LoopInput();

        /**
         * The meta object literal for the '<em><b>Iterator Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute LOOP_NODE__ITERATOR_KEY = eINSTANCE.getLoopNode_IteratorKey();

        /**
         * The meta object literal for the '<em><b>Element Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute LOOP_NODE__ELEMENT_KEY = eINSTANCE.getLoopNode_ElementKey();

        /**
         * The meta object literal for the '<em><b>Main Exit</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOOP_NODE__MAIN_EXIT = eINSTANCE.getLoopNode_MainExit();

        /**
         * The meta object literal for the '<em><b>Main Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOOP_NODE__MAIN_INPUT = eINSTANCE.getLoopNode_MainInput();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.CallNodeImpl <em>Call Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.CallNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getCallNode()
         * @generated
         */
        EClass CALL_NODE = eINSTANCE.getCallNode();

        /**
         * The meta object literal for the '<em><b>Flow Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CALL_NODE__FLOW_NAME = eINSTANCE.getCallNode_FlowName();

        /**
         * The meta object literal for the '<em><b>Dynamic Flow Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CALL_NODE__DYNAMIC_FLOW_NAME = eINSTANCE.getCallNode_DynamicFlowName();

        /**
         * The meta object literal for the '<em><b>Input Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_NODE__INPUT_PARAMETERS = eINSTANCE.getCallNode_InputParameters();

        /**
         * The meta object literal for the '<em><b>Output Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_NODE__OUTPUT_PARAMETERS = eINSTANCE.getCallNode_OutputParameters();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.StartNodeImpl <em>Start Node</em>}'
         * class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.StartNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getStartNode()
         * @generated
         */
        EClass START_NODE = eINSTANCE.getStartNode();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute START_NODE__TYPE = eINSTANCE.getStartNode_Type();

        /**
         * The meta object literal for the '<em><b>Input Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference START_NODE__INPUT_PARAMETERS = eINSTANCE.getStartNode_InputParameters();

        /**
         * The meta object literal for the '<em><b>Main Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference START_NODE__MAIN_OUTPUT = eINSTANCE.getStartNode_MainOutput();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.EndNodeImpl <em>End Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.EndNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getEndNode()
         * @generated
         */
        EClass END_NODE = eINSTANCE.getEndNode();

        /**
         * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute END_NODE__MODE = eINSTANCE.getEndNode_Mode();

        /**
         * The meta object literal for the '<em><b>Out Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference END_NODE__OUT_PARAMETERS = eINSTANCE.getEndNode_OutParameters();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.MapperNodeImpl <em>Mapper Node</em>}'
         * class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.MapperNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getMapperNode()
         * @generated
         */
        EClass MAPPER_NODE = eINSTANCE.getMapperNode();

        /**
         * The meta object literal for the '<em><b>Key Value</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MAPPER_NODE__KEY_VALUE = eINSTANCE.getMapperNode_KeyValue();

        /**
         * The meta object literal for the '<em><b>Main Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MAPPER_NODE__MAIN_OUTPUT = eINSTANCE.getMapperNode_MainOutput();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.NodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNode()
         * @generated
         */
        EClass NODE = eINSTANCE.getNode();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE__ID = eINSTANCE.getNode_Id();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE__DESCRIPTION = eINSTANCE.getNode_Description();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.KeyValuePairImpl
         * <em>Key Value Pair</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.KeyValuePairImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getKeyValuePair()
         * @generated
         */
        EClass KEY_VALUE_PAIR = eINSTANCE.getKeyValuePair();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute KEY_VALUE_PAIR__KEY = eINSTANCE.getKeyValuePair_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute KEY_VALUE_PAIR__VALUE = eINSTANCE.getKeyValuePair_Value();

        /**
         * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute KEY_VALUE_PAIR__VALUE_TYPE = eINSTANCE.getKeyValuePair_ValueType();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.InOutParameterImpl
         * <em>In Out Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.InOutParameterImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getInOutParameter()
         * @generated
         */
        EClass IN_OUT_PARAMETER = eINSTANCE.getInOutParameter();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__NAME = eINSTANCE.getInOutParameter_Name();

        /**
         * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__CLASS_NAME = eINSTANCE.getInOutParameter_ClassName();

        /**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__OPTIONAL = eINSTANCE.getInOutParameter_Optional();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__DESCRIPTION = eINSTANCE.getInOutParameter_Description();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__VALUE = eINSTANCE.getInOutParameter_Value();

        /**
         * The meta object literal for the '<em><b>Param Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IN_OUT_PARAMETER__PARAM_TYPE = eINSTANCE.getInOutParameter_ParamType();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.FollowByRelationNodeImpl
         * <em>Follow By Relation Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.FollowByRelationNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getFollowByRelationNode()
         * @generated
         */
        EClass FOLLOW_BY_RELATION_NODE = eINSTANCE.getFollowByRelationNode();

        /**
         * The meta object literal for the '<em><b>Relation Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute FOLLOW_BY_RELATION_NODE__RELATION_NAME = eINSTANCE.getFollowByRelationNode_RelationName();

        /**
         * The meta object literal for the '<em><b>Main Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference FOLLOW_BY_RELATION_NODE__MAIN_INPUT = eINSTANCE.getFollowByRelationNode_MainInput();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.LogicNodeImpl <em>Logic Node</em>}'
         * class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.LogicNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getLogicNode()
         * @generated
         */
        EClass LOGIC_NODE = eINSTANCE.getLogicNode();

        /**
         * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute LOGIC_NODE__CLASS_NAME = eINSTANCE.getLogicNode_ClassName();

        /**
         * The meta object literal for the '<em><b>Main Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOGIC_NODE__MAIN_OUTPUT = eINSTANCE.getLogicNode_MainOutput();

        /**
         * The meta object literal for the '<em><b>Error Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOGIC_NODE__ERROR_OUTPUT = eINSTANCE.getLogicNode_ErrorOutput();

        /**
         * The meta object literal for the '<em><b>Has Error Output</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute LOGIC_NODE__HAS_ERROR_OUTPUT = eINSTANCE.getLogicNode_HasErrorOutput();

        /**
         * The meta object literal for the '<em><b>In Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOGIC_NODE__IN_PARAMETERS = eINSTANCE.getLogicNode_InParameters();

        /**
         * The meta object literal for the '<em><b>Out Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference LOGIC_NODE__OUT_PARAMETERS = eINSTANCE.getLogicNode_OutParameters();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.OperatorOutputImpl
         * <em>Operator Output</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.OperatorOutputImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getOperatorOutput()
         * @generated
         */
        EClass OPERATOR_OUTPUT = eINSTANCE.getOperatorOutput();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OPERATOR_OUTPUT__SOURCE = eINSTANCE.getOperatorOutput_Source();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute OPERATOR_OUTPUT__NAME = eINSTANCE.getOperatorOutput_Name();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OPERATOR_OUTPUT__TARGET = eINSTANCE.getOperatorOutput_Target();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.OperatorInputImpl
         * <em>Operator Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.OperatorInputImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getOperatorInput()
         * @generated
         */
        EClass OPERATOR_INPUT = eINSTANCE.getOperatorInput();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OPERATOR_INPUT__INPUT = eINSTANCE.getOperatorInput_Input();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OPERATOR_INPUT__NODE = eINSTANCE.getOperatorInput_Node();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.ViewNodeImpl <em>View Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.ViewNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getViewNode()
         * @generated
         */
        EClass VIEW_NODE = eINSTANCE.getViewNode();

        /**
         * The meta object literal for the '<em><b>View Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute VIEW_NODE__VIEW_NAME = eINSTANCE.getViewNode_ViewName();

        /**
         * The meta object literal for the '<em><b>Dynamic View Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute VIEW_NODE__DYNAMIC_VIEW_NAME = eINSTANCE.getViewNode_DynamicViewName();

        EAttribute VIEW_NODE__RENDER_TYPE = eINSTANCE.getViewNode_RenderType();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.NoteNodeImpl <em>Note Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.NoteNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getNoteNode()
         * @generated
         */
        EClass NOTE_NODE = eINSTANCE.getNoteNode();

        /**
         * The meta object literal for the '{@link org.neuro4j.studio.core.impl.StandardNodeImpl <em>Standard Node</em>}
         * ' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.neuro4j.studio.core.impl.StandardNodeImpl
         * @see org.neuro4j.studio.core.impl.Neuro4jPackageImpl#getStandardNode()
         * @generated
         */
        EClass STANDARD_NODE = eINSTANCE.getStandardNode();

    }

} // Neuro4jPackage
