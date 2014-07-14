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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
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
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Neuro4jPackageImpl extends EPackageImpl implements Neuro4jPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass networkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass actionNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass joinNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass decisionNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass loopNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass callNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass startNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass endNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass mapperNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass keyValuePairEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass inOutParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass followByRelationNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass logicNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass operatorOutputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass operatorInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass viewNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass noteNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass standardNodeEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.neuro4j.studio.core.Neuro4jPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private Neuro4jPackageImpl() {
        super(eNS_URI, Neuro4jFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link Neuro4jPackage#eINSTANCE} when that field is accessed. Clients should
     * not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Neuro4jPackage init() {
        if (isInited)
            return (Neuro4jPackage) EPackage.Registry.INSTANCE.getEPackage(Neuro4jPackage.eNS_URI);

        // Obtain or create and register package
        Neuro4jPackageImpl theNeuro4jPackage = (Neuro4jPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Neuro4jPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Neuro4jPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theNeuro4jPackage.createPackageContents();

        // Initialize created meta-data
        theNeuro4jPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theNeuro4jPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Neuro4jPackage.eNS_URI, theNeuro4jPackage);
        return theNeuro4jPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDocumentRoot_Map() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNetwork() {
        return networkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getNetwork_RootAction() {
        return (EReference) networkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNetwork_Title() {
        return (EAttribute) networkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNetwork_Visibility() {
        return (EAttribute) networkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getActionNode() {
        return actionNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getActionNode_Input() {
        return (EReference) actionNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getActionNode_Output() {
        return (EReference) actionNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getActionNode_Name() {
        return (EAttribute) actionNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getActionNode_X() {
        return (EAttribute) actionNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getActionNode_Y() {
        return (EAttribute) actionNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getJoinNode() {
        return joinNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getJoinNode_MainOutput() {
        return (EReference) joinNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDecisionNode() {
        return decisionNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDecisionNode_MainTrueOutput() {
        return (EReference) decisionNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDecisionNode_MainFalseOutput() {
        return (EReference) decisionNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDecisionNode_MainInput() {
        return (EReference) decisionNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDecisionNode_Operator() {
        return (EAttribute) decisionNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDecisionNode_CompType() {
        return (EAttribute) decisionNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDecisionNode_CompKey() {
        return (EAttribute) decisionNodeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDecisionNode_DecisionKey() {
        return (EAttribute) decisionNodeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLoopNode() {
        return loopNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLoopNode_LoopExit() {
        return (EReference) loopNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLoopNode_LoopInput() {
        return (EReference) loopNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getLoopNode_IteratorKey() {
        return (EAttribute) loopNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getLoopNode_ElementKey() {
        return (EAttribute) loopNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLoopNode_MainExit() {
        return (EReference) loopNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLoopNode_MainInput() {
        return (EReference) loopNodeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCallNode() {
        return callNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getCallNode_FlowName() {
        return (EAttribute) callNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getCallNode_DynamicFlowName() {
        return (EAttribute) callNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCallNode_InputParameters() {
        return (EReference) callNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCallNode_OutputParameters() {
        return (EReference) callNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStartNode() {
        return startNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getStartNode_Type() {
        return (EAttribute) startNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getStartNode_InputParameters() {
        return (EReference) startNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getStartNode_MainOutput() {
        return (EReference) startNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEndNode() {
        return endNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEndNode_Mode() {
        return (EAttribute) endNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEndNode_OutParameters() {
        return (EReference) endNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMapperNode() {
        return mapperNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getMapperNode_KeyValue() {
        return (EReference) mapperNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getMapperNode_MainOutput() {
        return (EReference) mapperNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNode() {
        return nodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNode_Id() {
        return (EAttribute) nodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNode_Description() {
        return (EAttribute) nodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getKeyValuePair() {
        return keyValuePairEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getKeyValuePair_Key() {
        return (EAttribute) keyValuePairEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getKeyValuePair_Value() {
        return (EAttribute) keyValuePairEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getKeyValuePair_ValueType() {
        return (EAttribute) keyValuePairEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInOutParameter() {
        return inOutParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_Name() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_ClassName() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_Optional() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_Description() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_Value() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInOutParameter_ParamType() {
        return (EAttribute) inOutParameterEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getFollowByRelationNode() {
        return followByRelationNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getFollowByRelationNode_RelationName() {
        return (EAttribute) followByRelationNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getFollowByRelationNode_MainInput() {
        return (EReference) followByRelationNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLogicNode() {
        return logicNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getLogicNode_ClassName() {
        return (EAttribute) logicNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLogicNode_MainOutput() {
        return (EReference) logicNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLogicNode_ErrorOutput() {
        return (EReference) logicNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getLogicNode_HasErrorOutput() {
        return (EAttribute) logicNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLogicNode_InParameters() {
        return (EReference) logicNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLogicNode_OutParameters() {
        return (EReference) logicNodeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOperatorOutput() {
        return operatorOutputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOperatorOutput_Source() {
        return (EReference) operatorOutputEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getOperatorOutput_Name() {
        return (EAttribute) operatorOutputEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOperatorOutput_Target() {
        return (EReference) operatorOutputEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOperatorInput() {
        return operatorInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOperatorInput_Input() {
        return (EReference) operatorInputEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOperatorInput_Node() {
        return (EReference) operatorInputEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getViewNode() {
        return viewNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getViewNode_ViewName() {
        return (EAttribute) viewNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getViewNode_DynamicViewName() {
        return (EAttribute) viewNodeEClass.getEStructuralFeatures().get(1);
    }

    public EAttribute getViewNode_RenderType() {
        return (EAttribute) viewNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNoteNode() {
        return noteNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStandardNode() {
        return standardNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Neuro4jFactory getNeuro4jFactory() {
        return (Neuro4jFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MAP);

        networkEClass = createEClass(NETWORK);
        createEReference(networkEClass, NETWORK__ROOT_ACTION);
        createEAttribute(networkEClass, NETWORK__TITLE);
        createEAttribute(networkEClass, NETWORK__VISIBILITY);

        actionNodeEClass = createEClass(ACTION_NODE);
        createEReference(actionNodeEClass, ACTION_NODE__INPUT);
        createEReference(actionNodeEClass, ACTION_NODE__OUTPUT);
        createEAttribute(actionNodeEClass, ACTION_NODE__NAME);
        createEAttribute(actionNodeEClass, ACTION_NODE__X);
        createEAttribute(actionNodeEClass, ACTION_NODE__Y);

        joinNodeEClass = createEClass(JOIN_NODE);
        createEReference(joinNodeEClass, JOIN_NODE__MAIN_OUTPUT);

        decisionNodeEClass = createEClass(DECISION_NODE);
        createEReference(decisionNodeEClass, DECISION_NODE__MAIN_TRUE_OUTPUT);
        createEReference(decisionNodeEClass, DECISION_NODE__MAIN_FALSE_OUTPUT);
        createEReference(decisionNodeEClass, DECISION_NODE__MAIN_INPUT);
        createEAttribute(decisionNodeEClass, DECISION_NODE__OPERATOR);
        createEAttribute(decisionNodeEClass, DECISION_NODE__COMP_TYPE);
        createEAttribute(decisionNodeEClass, DECISION_NODE__COMP_KEY);
        createEAttribute(decisionNodeEClass, DECISION_NODE__DECISION_KEY);

        loopNodeEClass = createEClass(LOOP_NODE);
        createEReference(loopNodeEClass, LOOP_NODE__LOOP_EXIT);
        createEReference(loopNodeEClass, LOOP_NODE__LOOP_INPUT);
        createEAttribute(loopNodeEClass, LOOP_NODE__ITERATOR_KEY);
        createEAttribute(loopNodeEClass, LOOP_NODE__ELEMENT_KEY);
        createEReference(loopNodeEClass, LOOP_NODE__MAIN_EXIT);
        createEReference(loopNodeEClass, LOOP_NODE__MAIN_INPUT);

        callNodeEClass = createEClass(CALL_NODE);
        createEAttribute(callNodeEClass, CALL_NODE__FLOW_NAME);
        createEAttribute(callNodeEClass, CALL_NODE__DYNAMIC_FLOW_NAME);
        createEReference(callNodeEClass, CALL_NODE__INPUT_PARAMETERS);
        createEReference(callNodeEClass, CALL_NODE__OUTPUT_PARAMETERS);

        startNodeEClass = createEClass(START_NODE);
        createEAttribute(startNodeEClass, START_NODE__TYPE);
        createEReference(startNodeEClass, START_NODE__INPUT_PARAMETERS);
        createEReference(startNodeEClass, START_NODE__MAIN_OUTPUT);

        endNodeEClass = createEClass(END_NODE);
        createEAttribute(endNodeEClass, END_NODE__MODE);
        createEReference(endNodeEClass, END_NODE__OUT_PARAMETERS);

        mapperNodeEClass = createEClass(MAPPER_NODE);
        createEReference(mapperNodeEClass, MAPPER_NODE__KEY_VALUE);
        createEReference(mapperNodeEClass, MAPPER_NODE__MAIN_OUTPUT);

        nodeEClass = createEClass(NODE);
        createEAttribute(nodeEClass, NODE__ID);
        createEAttribute(nodeEClass, NODE__DESCRIPTION);

        keyValuePairEClass = createEClass(KEY_VALUE_PAIR);
        createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__KEY);
        createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__VALUE);
        createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__VALUE_TYPE);

        inOutParameterEClass = createEClass(IN_OUT_PARAMETER);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__NAME);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__CLASS_NAME);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__OPTIONAL);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__DESCRIPTION);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__VALUE);
        createEAttribute(inOutParameterEClass, IN_OUT_PARAMETER__PARAM_TYPE);

        followByRelationNodeEClass = createEClass(FOLLOW_BY_RELATION_NODE);
        createEAttribute(followByRelationNodeEClass, FOLLOW_BY_RELATION_NODE__RELATION_NAME);
        createEReference(followByRelationNodeEClass, FOLLOW_BY_RELATION_NODE__MAIN_INPUT);

        logicNodeEClass = createEClass(LOGIC_NODE);
        createEAttribute(logicNodeEClass, LOGIC_NODE__CLASS_NAME);
        createEReference(logicNodeEClass, LOGIC_NODE__MAIN_OUTPUT);
        createEReference(logicNodeEClass, LOGIC_NODE__ERROR_OUTPUT);
        createEAttribute(logicNodeEClass, LOGIC_NODE__HAS_ERROR_OUTPUT);
        createEReference(logicNodeEClass, LOGIC_NODE__IN_PARAMETERS);
        createEReference(logicNodeEClass, LOGIC_NODE__OUT_PARAMETERS);

        operatorOutputEClass = createEClass(OPERATOR_OUTPUT);
        createEReference(operatorOutputEClass, OPERATOR_OUTPUT__SOURCE);
        createEAttribute(operatorOutputEClass, OPERATOR_OUTPUT__NAME);
        createEReference(operatorOutputEClass, OPERATOR_OUTPUT__TARGET);

        operatorInputEClass = createEClass(OPERATOR_INPUT);
        createEReference(operatorInputEClass, OPERATOR_INPUT__INPUT);
        createEReference(operatorInputEClass, OPERATOR_INPUT__NODE);

        viewNodeEClass = createEClass(VIEW_NODE);
        createEAttribute(viewNodeEClass, VIEW_NODE__VIEW_NAME);
        createEAttribute(viewNodeEClass, VIEW_NODE__DYNAMIC_VIEW_NAME);
        createEAttribute(viewNodeEClass, VIEW_NODE_RENDER_TYPET);

        noteNodeEClass = createEClass(NOTE_NODE);

        standardNodeEClass = createEClass(STANDARD_NODE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        actionNodeEClass.getESuperTypes().add(this.getNode());
        joinNodeEClass.getESuperTypes().add(this.getActionNode());
        decisionNodeEClass.getESuperTypes().add(this.getActionNode());
        loopNodeEClass.getESuperTypes().add(this.getActionNode());
        callNodeEClass.getESuperTypes().add(this.getActionNode());
        startNodeEClass.getESuperTypes().add(this.getActionNode());
        endNodeEClass.getESuperTypes().add(this.getActionNode());
        mapperNodeEClass.getESuperTypes().add(this.getActionNode());
        followByRelationNodeEClass.getESuperTypes().add(this.getActionNode());
        logicNodeEClass.getESuperTypes().add(this.getActionNode());
        operatorOutputEClass.getESuperTypes().add(this.getNode());
        operatorInputEClass.getESuperTypes().add(this.getNode());
        viewNodeEClass.getESuperTypes().add(this.getActionNode());
        noteNodeEClass.getESuperTypes().add(this.getActionNode());
        standardNodeEClass.getESuperTypes().add(this.getActionNode());

        // Initialize classes and features; add operations and parameters
        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Map(), this.getNetwork(), null, "map", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(networkEClass, Network.class, "Network", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNetwork_RootAction(), this.getNode(), null, "rootAction", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNetwork_Title(), theXMLTypePackage.getString(), "title", null, 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNetwork_Visibility(), theXMLTypePackage.getString(), "visibility", null, 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(actionNodeEClass, ActionNode.class, "ActionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getActionNode_Input(), this.getOperatorInput(), null, "input", null, 0, -1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getActionNode_Output(), this.getOperatorOutput(), null, "output", null, 0, -1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getActionNode_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getActionNode_X(), theXMLTypePackage.getInt(), "x", null, 0, 1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getActionNode_Y(), theXMLTypePackage.getInt(), "y", null, 0, 1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(joinNodeEClass, JoinNode.class, "JoinNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getJoinNode_MainOutput(), this.getOperatorOutput(), null, "mainOutput", null, 0, 1, JoinNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(decisionNodeEClass, DecisionNode.class, "DecisionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDecisionNode_MainTrueOutput(), this.getOperatorOutput(), null, "mainTrueOutput", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDecisionNode_MainFalseOutput(), this.getOperatorOutput(), null, "mainFalseOutput", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDecisionNode_MainInput(), this.getOperatorInput(), null, "mainInput", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDecisionNode_Operator(), theXMLTypePackage.getString(), "operator", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDecisionNode_CompType(), theXMLTypePackage.getString(), "compType", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDecisionNode_CompKey(), theXMLTypePackage.getString(), "compKey", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDecisionNode_DecisionKey(), theXMLTypePackage.getString(), "decisionKey", null, 0, 1, DecisionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(loopNodeEClass, LoopNode.class, "LoopNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLoopNode_LoopExit(), this.getOperatorOutput(), null, "loopExit", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLoopNode_LoopInput(), this.getOperatorInput(), null, "loopInput", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLoopNode_IteratorKey(), theXMLTypePackage.getString(), "iteratorKey", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLoopNode_ElementKey(), theXMLTypePackage.getString(), "elementKey", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLoopNode_MainExit(), this.getOperatorOutput(), null, "mainExit", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLoopNode_MainInput(), this.getOperatorInput(), null, "mainInput", null, 0, 1, LoopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(callNodeEClass, CallNode.class, "CallNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCallNode_FlowName(), theXMLTypePackage.getString(), "flowName", null, 0, 1, CallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCallNode_DynamicFlowName(), theXMLTypePackage.getString(), "dynamicFlowName", null, 0, 1, CallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCallNode_InputParameters(), this.getInOutParameter(), null, "inputParameters", null, 0, -1, CallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCallNode_OutputParameters(), this.getInOutParameter(), null, "outputParameters", null, 0, -1, CallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(startNodeEClass, StartNode.class, "StartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStartNode_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, StartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStartNode_InputParameters(), this.getInOutParameter(), null, "inputParameters", null, 0, -1, StartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStartNode_MainOutput(), this.getOperatorOutput(), null, "mainOutput", null, 0, 1, StartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(endNodeEClass, EndNode.class, "EndNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEndNode_Mode(), theXMLTypePackage.getString(), "mode", null, 0, 1, EndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEndNode_OutParameters(), this.getInOutParameter(), null, "outParameters", null, 0, -1, EndNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mapperNodeEClass, MapperNode.class, "MapperNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMapperNode_KeyValue(), this.getKeyValuePair(), null, "KeyValue", null, 0, -1, MapperNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMapperNode_MainOutput(), this.getOperatorOutput(), null, "mainOutput", null, 0, 1, MapperNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNode_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNode_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyValuePairEClass, KeyValuePair.class, "KeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKeyValuePair_Key(), theXMLTypePackage.getString(), "Key", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyValuePair_Value(), theXMLTypePackage.getString(), "Value", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyValuePair_ValueType(), theXMLTypePackage.getInt(), "ValueType", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(inOutParameterEClass, InOutParameter.class, "InOutParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInOutParameter_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInOutParameter_ClassName(), theXMLTypePackage.getString(), "className", null, 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInOutParameter_Optional(), theXMLTypePackage.getBoolean(), "optional", null, 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInOutParameter_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInOutParameter_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInOutParameter_ParamType(), theXMLTypePackage.getInt(), "paramType", "0", 0, 1, InOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(followByRelationNodeEClass, FollowByRelationNode.class, "FollowByRelationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFollowByRelationNode_RelationName(), theXMLTypePackage.getString(), "relationName", null, 0, 1, FollowByRelationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFollowByRelationNode_MainInput(), this.getOperatorInput(), null, "mainInput", null, 0, 1, FollowByRelationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(logicNodeEClass, LogicNode.class, "LogicNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLogicNode_ClassName(), theXMLTypePackage.getString(), "className", null, 0, 1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLogicNode_MainOutput(), this.getOperatorOutput(), null, "mainOutput", null, 0, 1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLogicNode_ErrorOutput(), this.getOperatorOutput(), null, "errorOutput", null, 0, 1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLogicNode_HasErrorOutput(), theXMLTypePackage.getBoolean(), "hasErrorOutput", null, 0, 1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLogicNode_InParameters(), this.getInOutParameter(), null, "inParameters", null, 0, -1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLogicNode_OutParameters(), this.getInOutParameter(), null, "outParameters", null, 0, -1, LogicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operatorOutputEClass, OperatorOutput.class, "OperatorOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperatorOutput_Source(), this.getActionNode(), null, "source", null, 0, 1, OperatorOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperatorOutput_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, OperatorOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorOutput_Target(), this.getActionNode(), null, "target", null, 0, 1, OperatorOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operatorInputEClass, OperatorInput.class, "OperatorInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperatorInput_Input(), this.getOperatorOutput(), null, "input", null, 0, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorInput_Node(), this.getActionNode(), null, "node", null, 0, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(viewNodeEClass, ViewNode.class, "ViewNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getViewNode_ViewName(), theXMLTypePackage.getString(), "viewName", null, 0, 1, ViewNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getViewNode_DynamicViewName(), theXMLTypePackage.getString(), "dynamicViewName", null, 0, 1, ViewNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getViewNode_RenderType(), theXMLTypePackage.getString(), "renderType", null, 0, 1, ViewNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(noteNodeEClass, NoteNode.class, "NoteNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(standardNodeEClass, StandardNode.class, "StandardNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
        addAnnotation(documentRootEClass,
                source,
                new String[] {
                        "name", "",
                        "kind", "mixed"
                });
        addAnnotation(getDocumentRoot_Mixed(),
                source,
                new String[] {
                        "kind", "elementWildcard",
                        "name", ":mixed"
                });
        addAnnotation(getDocumentRoot_XMLNSPrefixMap(),
                source,
                new String[] {
                        "kind", "attribute",
                        "name", "xmlns:prefix"
                });
        addAnnotation(getDocumentRoot_XSISchemaLocation(),
                source,
                new String[] {
                        "kind", "attribute",
                        "name", "xsi:schemaLocation"
                });
        addAnnotation(getDocumentRoot_Map(),
                source,
                new String[] {
                        "kind", "element",
                        "name", "map",
                        "namespace", "##targetNamespace"
                });
        addAnnotation(networkEClass,
                source,
                new String[] {
                        "name", "Map",
                        "kind", "elementOnly"
                });
        addAnnotation(getNetwork_RootAction(),
                source,
                new String[] {
                        "kind", "element",
                        "name", "rootTopics"
                });
        addAnnotation(getNetwork_Title(),
                source,
                new String[] {
                        "kind", "attribute",
                        "name", "title"
                });
        addAnnotation(actionNodeEClass,
                source,
                new String[] {
                        "name", "Action",
                        "kind", "elementOnly"
                });
        addAnnotation(getActionNode_Input(),
                source,
                new String[] {
                        "kind", "attribute",
                        "name", "subtopics"
                });
        addAnnotation(joinNodeEClass,
                source,
                new String[] {
                        "name", "Action",
                        "kind", "elementOnly"
                });
    }

} // Neuro4jPackageImpl
