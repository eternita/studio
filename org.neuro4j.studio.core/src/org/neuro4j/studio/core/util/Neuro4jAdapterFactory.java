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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage
 * @generated
 */
public class Neuro4jAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static Neuro4jPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Neuro4jAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = Neuro4jPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance
     * object of the model.
     * <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Neuro4jSwitch<Adapter> modelSwitch =
            new Neuro4jSwitch<Adapter>() {
                @Override
                public Adapter caseDocumentRoot(DocumentRoot object) {
                    return createDocumentRootAdapter();
                }

                @Override
                public Adapter caseNetwork(Network object) {
                    return createNetworkAdapter();
                }

                @Override
                public Adapter caseActionNode(ActionNode object) {
                    return createActionNodeAdapter();
                }

                @Override
                public Adapter caseJoinNode(JoinNode object) {
                    return createJoinNodeAdapter();
                }

                @Override
                public Adapter caseDecisionNode(DecisionNode object) {
                    return createDecisionNodeAdapter();
                }

                @Override
                public Adapter caseLoopNode(LoopNode object) {
                    return createLoopNodeAdapter();
                }

                @Override
                public Adapter caseCallNode(CallNode object) {
                    return createCallNodeAdapter();
                }

                @Override
                public Adapter caseStartNode(StartNode object) {
                    return createStartNodeAdapter();
                }

                @Override
                public Adapter caseEndNode(EndNode object) {
                    return createEndNodeAdapter();
                }

                @Override
                public Adapter caseMapperNode(MapperNode object) {
                    return createMapperNodeAdapter();
                }

                @Override
                public Adapter caseNode(Node object) {
                    return createNodeAdapter();
                }

                @Override
                public Adapter caseKeyValuePair(KeyValuePair object) {
                    return createKeyValuePairAdapter();
                }

                @Override
                public Adapter caseInOutParameter(InOutParameter object) {
                    return createInOutParameterAdapter();
                }

                @Override
                public Adapter caseFollowByRelationNode(FollowByRelationNode object) {
                    return createFollowByRelationNodeAdapter();
                }

                @Override
                public Adapter caseLogicNode(LogicNode object) {
                    return createLogicNodeAdapter();
                }

                @Override
                public Adapter caseOperatorOutput(OperatorOutput object) {
                    return createOperatorOutputAdapter();
                }

                @Override
                public Adapter caseOperatorInput(OperatorInput object) {
                    return createOperatorInputAdapter();
                }

                @Override
                public Adapter caseViewNode(ViewNode object) {
                    return createViewNodeAdapter();
                }

                @Override
                public Adapter caseNoteNode(NoteNode object) {
                    return createNoteNodeAdapter();
                }

                @Override
                public Adapter caseStandardNode(StandardNode object) {
                    return createStandardNodeAdapter();
                }

                @Override
                public Adapter defaultCase(EObject object) {
                    return createEObjectAdapter();
                }
            };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *        the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.DocumentRoot <em>Document Root</em>}
     * '.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.Network <em>Network</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.Network
     * @generated
     */
    public Adapter createNetworkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.ActionNode <em>Action Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.ActionNode
     * @generated
     */
    public Adapter createActionNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.Node
     * @generated
     */
    public Adapter createNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.KeyValuePair
     * <em>Key Value Pair</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.KeyValuePair
     * @generated
     */
    public Adapter createKeyValuePairAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.InOutParameter
     * <em>In Out Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.InOutParameter
     * @generated
     */
    public Adapter createInOutParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.FollowByRelationNode
     * <em>Follow By Relation Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.FollowByRelationNode
     * @generated
     */
    public Adapter createFollowByRelationNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.LogicNode <em>Logic Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.LogicNode
     * @generated
     */
    public Adapter createLogicNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.OperatorOutput
     * <em>Operator Output</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.OperatorOutput
     * @generated
     */
    public Adapter createOperatorOutputAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.OperatorInput
     * <em>Operator Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.OperatorInput
     * @generated
     */
    public Adapter createOperatorInputAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.ViewNode <em>View Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.ViewNode
     * @generated
     */
    public Adapter createViewNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.NoteNode <em>Note Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.NoteNode
     * @generated
     */
    public Adapter createNoteNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.StandardNode <em>Standard Node</em>}
     * '.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.StandardNode
     * @generated
     */
    public Adapter createStandardNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.JoinNode <em>Join Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.JoinNode
     * @generated
     */
    public Adapter createJoinNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.DecisionNode <em>Decision Node</em>}
     * '.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.DecisionNode
     * @generated
     */
    public Adapter createDecisionNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.LoopNode <em>Loop Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.LoopNode
     * @generated
     */
    public Adapter createLoopNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.CallNode <em>Call Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.CallNode
     * @generated
     */
    public Adapter createCallNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.StartNode <em>Start Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.StartNode
     * @generated
     */
    public Adapter createStartNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.EndNode <em>End Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.EndNode
     * @generated
     */
    public Adapter createEndNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.neuro4j.studio.core.MapperNode <em>Mapper Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.neuro4j.studio.core.MapperNode
     * @generated
     */
    public Adapter createMapperNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // Neuro4jAdapterFactory
