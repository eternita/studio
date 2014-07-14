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
package org.neuro4j.studio.core.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.neuro4j.studio.core.*;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.DocumentRoot;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.FollowByRelationNode;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Neuro4jFactoryImpl extends EFactoryImpl implements Neuro4jFactory {
    /**
     * @generated NOT
     */
    private UUIDMgr uuidMgr = UUIDMgr.getInstance();

    Map<String, Integer> nodeCount = new HashMap<String, Integer>();

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static Neuro4jFactory init() {
        try {
            Neuro4jFactory theNeuro4jFactory = (Neuro4jFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.neuro4j.org/neuro2");
            if (theNeuro4jFactory != null) {
                return theNeuro4jFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Neuro4jFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Neuro4jFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case Neuro4jPackage.DOCUMENT_ROOT:
                return createDocumentRoot();
            case Neuro4jPackage.NETWORK:
                return createNetwork();
            case Neuro4jPackage.ACTION_NODE:
                return createActionNode();
            case Neuro4jPackage.JOIN_NODE:
                return createJoinNode();
            case Neuro4jPackage.DECISION_NODE:
                return createDecisionNode();
            case Neuro4jPackage.LOOP_NODE:
                return createLoopNode();
            case Neuro4jPackage.CALL_NODE:
                return createCallNode();
            case Neuro4jPackage.START_NODE:
                return createStartNode();
            case Neuro4jPackage.END_NODE:
                return createEndNode();
            case Neuro4jPackage.MAPPER_NODE:
                return createMapperNode();
            case Neuro4jPackage.NODE:
                return createNode();
            case Neuro4jPackage.KEY_VALUE_PAIR:
                return createKeyValuePair();
            case Neuro4jPackage.IN_OUT_PARAMETER:
                return createInOutParameter();
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE:
                return createFollowByRelationNode();
            case Neuro4jPackage.LOGIC_NODE:
                return createLogicNode();
            case Neuro4jPackage.OPERATOR_OUTPUT:
                return createOperatorOutput();
            case Neuro4jPackage.OPERATOR_INPUT:
                return createOperatorInput();
            case Neuro4jPackage.VIEW_NODE:
                return createViewNode();
            case Neuro4jPackage.NOTE_NODE:
                return createNoteNode();
            case Neuro4jPackage.STANDARD_NODE:
                return createStandardNode();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DocumentRoot createDocumentRoot() {
        DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Network createNetwork() {
        NetworkImpl network = new NetworkImpl();
        return network;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode createActionNode() {
        ActionNodeImpl actionNode = new ActionNodeImpl();
        return actionNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Node createNode() {
        NodeImpl node = new NodeImpl();
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public KeyValuePair createKeyValuePair() {
        KeyValuePairImpl keyValuePair = new KeyValuePairImpl();
        return keyValuePair;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public InOutParameter createInOutParameter() {
        InOutParameterImpl inOutParameter = new InOutParameterImpl();
        return inOutParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public FollowByRelationNode createFollowByRelationNode() {
        FollowByRelationNodeImpl followByRelationNode = new FollowByRelationNodeImpl();
        followByRelationNode.setId(uuidMgr.createUUIDString());
        return followByRelationNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public LogicNode createLogicNode() {
        LogicNodeImpl logicNode = new LogicNodeImpl();
        logicNode.setId(uuidMgr.createUUIDString());
        return logicNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput createOperatorOutput() {
        OperatorOutputImpl operatorOutput = new OperatorOutputImpl();
        return operatorOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public OperatorInput createOperatorInput() {
        OperatorInputImpl operatorInput = new OperatorInputImpl();
        operatorInput.setId(uuidMgr.createUUIDString());
        return operatorInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public ViewNode createViewNode() {
        ViewNodeImpl viewNode = new ViewNodeImpl();
        viewNode.setId(uuidMgr.createUUIDString());
        return viewNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NoteNode createNoteNode() {
        NoteNodeImpl noteNode = new NoteNodeImpl();
        return noteNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public StandardNode createStandardNode() {
        StandardNodeImpl standardNode = new StandardNodeImpl();
        return standardNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public JoinNode createJoinNode() {
        JoinNodeImpl joinNode = new JoinNodeImpl();
        joinNode.setId(uuidMgr.createUUIDString());
        return joinNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public DecisionNode createDecisionNode() {
        DecisionNodeImpl decisionNode = new DecisionNodeImpl();
        decisionNode.setId(uuidMgr.createUUIDString());
        return decisionNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public LoopNode createLoopNode() {
        LoopNodeImpl loopNode = new LoopNodeImpl();
        loopNode.setId(uuidMgr.createUUIDString());
        return loopNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public CallNode createCallNode() {
        CallNodeImpl callNode = new CallNodeImpl();
        callNode.setId(uuidMgr.createUUIDString());
        return callNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public StartNode createStartNode() {
        StartNodeImpl startNode = new StartNodeImpl();
        startNode.setId(uuidMgr.createUUIDString());

        return startNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EndNode createEndNode() {
        EndNodeImpl endNode = new EndNodeImpl();
        endNode.setId(uuidMgr.createUUIDString());
        return endNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public MapperNode createMapperNode() {
        MapperNodeImpl mapperNode = new MapperNodeImpl();
        mapperNode.setId(uuidMgr.createUUIDString());
        return mapperNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Neuro4jPackage getNeuro4jPackage() {
        return (Neuro4jPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Neuro4jPackage getPackage() {
        return Neuro4jPackage.eINSTANCE;
    }

} // Neuro4jFactoryImpl
