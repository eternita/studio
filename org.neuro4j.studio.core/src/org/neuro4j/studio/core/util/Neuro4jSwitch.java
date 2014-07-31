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
package org.neuro4j.studio.core.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each
 * class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage
 * @generated
 */
public class Neuro4jSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static Neuro4jPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Neuro4jSwitch() {
        if (modelPackage == null) {
            modelPackage = Neuro4jPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case Neuro4jPackage.DOCUMENT_ROOT: {
                DocumentRoot documentRoot = (DocumentRoot) theEObject;
                T result = caseDocumentRoot(documentRoot);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.NETWORK: {
                Network network = (Network) theEObject;
                T result = caseNetwork(network);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.ACTION_NODE: {
                ActionNode actionNode = (ActionNode) theEObject;
                T result = caseActionNode(actionNode);
                if (result == null)
                    result = caseNode(actionNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.JOIN_NODE: {
                JoinNode joinNode = (JoinNode) theEObject;
                T result = caseJoinNode(joinNode);
                if (result == null)
                    result = caseActionNode(joinNode);
                if (result == null)
                    result = caseNode(joinNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.DECISION_NODE: {
                DecisionNode decisionNode = (DecisionNode) theEObject;
                T result = caseDecisionNode(decisionNode);
                if (result == null)
                    result = caseActionNode(decisionNode);
                if (result == null)
                    result = caseNode(decisionNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.LOOP_NODE: {
                LoopNode loopNode = (LoopNode) theEObject;
                T result = caseLoopNode(loopNode);
                if (result == null)
                    result = caseActionNode(loopNode);
                if (result == null)
                    result = caseNode(loopNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.CALL_NODE: {
                CallNode callNode = (CallNode) theEObject;
                T result = caseCallNode(callNode);
                if (result == null)
                    result = caseActionNode(callNode);
                if (result == null)
                    result = caseNode(callNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.START_NODE: {
                StartNode startNode = (StartNode) theEObject;
                T result = caseStartNode(startNode);
                if (result == null)
                    result = caseActionNode(startNode);
                if (result == null)
                    result = caseNode(startNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.END_NODE: {
                EndNode endNode = (EndNode) theEObject;
                T result = caseEndNode(endNode);
                if (result == null)
                    result = caseActionNode(endNode);
                if (result == null)
                    result = caseNode(endNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.MAPPER_NODE: {
                MapperNode mapperNode = (MapperNode) theEObject;
                T result = caseMapperNode(mapperNode);
                if (result == null)
                    result = caseActionNode(mapperNode);
                if (result == null)
                    result = caseNode(mapperNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.NODE: {
                Node node = (Node) theEObject;
                T result = caseNode(node);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.KEY_VALUE_PAIR: {
                KeyValuePair keyValuePair = (KeyValuePair) theEObject;
                T result = caseKeyValuePair(keyValuePair);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.IN_OUT_PARAMETER: {
                InOutParameter inOutParameter = (InOutParameter) theEObject;
                T result = caseInOutParameter(inOutParameter);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE: {
                FollowByRelationNode followByRelationNode = (FollowByRelationNode) theEObject;
                T result = caseFollowByRelationNode(followByRelationNode);
                if (result == null)
                    result = caseActionNode(followByRelationNode);
                if (result == null)
                    result = caseNode(followByRelationNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.LOGIC_NODE: {
                LogicNode logicNode = (LogicNode) theEObject;
                T result = caseLogicNode(logicNode);
                if (result == null)
                    result = caseActionNode(logicNode);
                if (result == null)
                    result = caseNode(logicNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.OPERATOR_OUTPUT: {
                OperatorOutput operatorOutput = (OperatorOutput) theEObject;
                T result = caseOperatorOutput(operatorOutput);
                if (result == null)
                    result = caseNode(operatorOutput);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.OPERATOR_INPUT: {
                OperatorInput operatorInput = (OperatorInput) theEObject;
                T result = caseOperatorInput(operatorInput);
                if (result == null)
                    result = caseNode(operatorInput);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.VIEW_NODE: {
                ViewNode viewNode = (ViewNode) theEObject;
                T result = caseViewNode(viewNode);
                if (result == null)
                    result = caseActionNode(viewNode);
                if (result == null)
                    result = caseNode(viewNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.NOTE_NODE: {
                NoteNode noteNode = (NoteNode) theEObject;
                T result = caseNoteNode(noteNode);
                if (result == null)
                    result = caseActionNode(noteNode);
                if (result == null)
                    result = caseNode(noteNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case Neuro4jPackage.STANDARD_NODE: {
                StandardNode standardNode = (StandardNode) theEObject;
                T result = caseStandardNode(standardNode);
                if (result == null)
                    result = caseActionNode(standardNode);
                if (result == null)
                    result = caseNode(standardNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Network</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Network</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNetwork(Network object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Action Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActionNode(ActionNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode(Node object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyValuePair(KeyValuePair object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>In Out Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Out Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInOutParameter(InOutParameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Follow By Relation Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Follow By Relation Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFollowByRelationNode(FollowByRelationNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Logic Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Logic Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLogicNode(LogicNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operator Output</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operator Output</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperatorOutput(OperatorOutput object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operator Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operator Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperatorInput(OperatorInput object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseViewNode(ViewNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Note Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Note Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNoteNode(NoteNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Standard Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Standard Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStandardNode(StandardNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Join Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Join Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJoinNode(JoinNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Decision Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Decision Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDecisionNode(DecisionNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Loop Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Loop Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoopNode(LoopNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallNode(CallNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Start Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Start Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStartNode(StartNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>End Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>End Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndNode(EndNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Mapper Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Mapper Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMapperNode(MapperNode object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *        the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // Neuro4jSwitch
