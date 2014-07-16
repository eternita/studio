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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.neuro4j.workflow.common.SWFParametersConstants;
import org.neuro4j.workflow.node.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getMainTrueOutput <em>Main True Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getMainFalseOutput <em>Main False Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getMainInput <em>Main Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getOperator <em>Operator</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getCompType <em>Comp Type</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getCompKey <em>Comp Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.DecisionNodeImpl#getDecisionKey <em>Decision Key</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 */
public class DecisionNodeImpl extends ActionNodeImpl implements DecisionNode {

    protected static final String NAME_EDEFAULT = "DecisionNode";

    /**
     * The cached value of the '{@link #getMainTrueOutput() <em>Main True Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMainTrueOutput()
     * @generated
     * @ordered
     */
    protected OperatorOutput mainTrueOutput;

    /**
     * The cached value of the '{@link #getMainFalseOutput() <em>Main False Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMainFalseOutput()
     * @generated
     * @ordered
     */
    protected OperatorOutput mainFalseOutput;

    /**
     * The cached value of the '{@link #getMainInput() <em>Main Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMainInput()
     * @generated
     * @ordered
     */
    protected OperatorInput mainInput;

    /**
     * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOperator()
     * @generated
     * @ordered
     */
    protected static final String OPERATOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOperator()
     * @generated
     * @ordered
     */
    protected String operator = OPERATOR_EDEFAULT;

    /**
     * The default value of the '{@link #getCompType() <em>Comp Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCompType()
     * @generated
     * @ordered
     */
    protected static final String COMP_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCompType() <em>Comp Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCompType()
     * @generated
     * @ordered
     */
    protected String compType = COMP_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getCompKey() <em>Comp Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCompKey()
     * @generated
     * @ordered
     */
    protected static final String COMP_KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCompKey() <em>Comp Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCompKey()
     * @generated
     * @ordered
     */
    protected String compKey = COMP_KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getDecisionKey() <em>Decision Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDecisionKey()
     * @generated
     * @ordered
     */
    protected static final String DECISION_KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDecisionKey() <em>Decision Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDecisionKey()
     * @generated
     * @ordered
     */
    protected String decisionKey = DECISION_KEY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DecisionNodeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Neuro4jPackage.Literals.DECISION_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getMainTrueOutput() {
        if (mainTrueOutput != null && mainTrueOutput.eIsProxy()) {
            InternalEObject oldMainTrueOutput = (InternalEObject) mainTrueOutput;
            mainTrueOutput = (OperatorOutput) eResolveProxy(oldMainTrueOutput);
            if (mainTrueOutput != oldMainTrueOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT, oldMainTrueOutput, mainTrueOutput));
            }
        }
        return mainTrueOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetMainTrueOutput() {
        return mainTrueOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMainTrueOutput(OperatorOutput newMainTrueOutput) {
        OperatorOutput oldMainTrueOutput = mainTrueOutput;
        mainTrueOutput = newMainTrueOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT, oldMainTrueOutput, mainTrueOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getMainFalseOutput() {
        if (mainFalseOutput != null && mainFalseOutput.eIsProxy()) {
            InternalEObject oldMainFalseOutput = (InternalEObject) mainFalseOutput;
            mainFalseOutput = (OperatorOutput) eResolveProxy(oldMainFalseOutput);
            if (mainFalseOutput != oldMainFalseOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT, oldMainFalseOutput, mainFalseOutput));
            }
        }
        return mainFalseOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetMainFalseOutput() {
        return mainFalseOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMainFalseOutput(OperatorOutput newMainFalseOutput) {
        OperatorOutput oldMainFalseOutput = mainFalseOutput;
        mainFalseOutput = newMainFalseOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT, oldMainFalseOutput, mainFalseOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorInput getMainInput() {
        if (mainInput != null && mainInput.eIsProxy()) {
            InternalEObject oldMainInput = (InternalEObject) mainInput;
            mainInput = (OperatorInput) eResolveProxy(oldMainInput);
            if (mainInput != oldMainInput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.DECISION_NODE__MAIN_INPUT, oldMainInput, mainInput));
            }
        }
        return mainInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorInput basicGetMainInput() {
        return mainInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMainInput(OperatorInput newMainInput) {
        OperatorInput oldMainInput = mainInput;
        mainInput = newMainInput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__MAIN_INPUT, oldMainInput, mainInput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOperator(String newOperator) {
        String oldOperator = operator;
        operator = newOperator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__OPERATOR, oldOperator, operator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getCompType() {
        return compType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCompType(String newCompType) {
        String oldCompType = compType;
        compType = newCompType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__COMP_TYPE, oldCompType, compType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getCompKey() {
        return compKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCompKey(String newCompKey) {
        String oldCompKey = compKey;
        compKey = newCompKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__COMP_KEY, oldCompKey, compKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDecisionKey() {
        return decisionKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDecisionKey(String newDecisionKey) {
        String oldDecisionKey = decisionKey;
        decisionKey = newDecisionKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.DECISION_NODE__DECISION_KEY, oldDecisionKey, decisionKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT:
                if (resolve)
                    return getMainTrueOutput();
                return basicGetMainTrueOutput();
            case Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT:
                if (resolve)
                    return getMainFalseOutput();
                return basicGetMainFalseOutput();
            case Neuro4jPackage.DECISION_NODE__MAIN_INPUT:
                if (resolve)
                    return getMainInput();
                return basicGetMainInput();
            case Neuro4jPackage.DECISION_NODE__OPERATOR:
                return getOperator();
            case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
                return getCompType();
            case Neuro4jPackage.DECISION_NODE__COMP_KEY:
                return getCompKey();
            case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
                return getDecisionKey();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT:
                setMainTrueOutput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT:
                setMainFalseOutput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__MAIN_INPUT:
                setMainInput((OperatorInput) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__OPERATOR:
                setOperator((String) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
                setCompType((String) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__COMP_KEY:
                setCompKey((String) newValue);
                return;
            case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
                setDecisionKey((String) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT:
                setMainTrueOutput((OperatorOutput) null);
                return;
            case Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT:
                setMainFalseOutput((OperatorOutput) null);
                return;
            case Neuro4jPackage.DECISION_NODE__MAIN_INPUT:
                setMainInput((OperatorInput) null);
                return;
            case Neuro4jPackage.DECISION_NODE__OPERATOR:
                setOperator(OPERATOR_EDEFAULT);
                return;
            case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
                setCompType(COMP_TYPE_EDEFAULT);
                return;
            case Neuro4jPackage.DECISION_NODE__COMP_KEY:
                setCompKey(COMP_KEY_EDEFAULT);
                return;
            case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
                setDecisionKey(DECISION_KEY_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case Neuro4jPackage.DECISION_NODE__MAIN_TRUE_OUTPUT:
                return mainTrueOutput != null;
            case Neuro4jPackage.DECISION_NODE__MAIN_FALSE_OUTPUT:
                return mainFalseOutput != null;
            case Neuro4jPackage.DECISION_NODE__MAIN_INPUT:
                return mainInput != null;
            case Neuro4jPackage.DECISION_NODE__OPERATOR:
                return OPERATOR_EDEFAULT == null ? operator != null : !OPERATOR_EDEFAULT.equals(operator);
            case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
                return COMP_TYPE_EDEFAULT == null ? compType != null : !COMP_TYPE_EDEFAULT.equals(compType);
            case Neuro4jPackage.DECISION_NODE__COMP_KEY:
                return COMP_KEY_EDEFAULT == null ? compKey != null : !COMP_KEY_EDEFAULT.equals(compKey);
            case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
                return DECISION_KEY_EDEFAULT == null ? decisionKey != null : !DECISION_KEY_EDEFAULT.equals(decisionKey);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (operator: ");
        result.append(operator);
        result.append(", compType: ");
        result.append(compType);
        result.append(", compKey: ");
        result.append(compKey);
        result.append(", decisionKey: ");
        result.append(decisionKey);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        setCompKey(entity.getParameter(COMP_KEY_PROPERTY_KEY));
        setDecisionKey(entity.getParameter(DECISION_KEY_PROPERTY_KEY));
        setCompType(entity.getParameter(COMP_TYPE_PROPERTY_KEY));
        setOperator(entity.getParameter(OPERATOR_PROPERTY_KEY));

        // super.getNodeSpecificProperties(entity);
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        setNotNullProperty(entity, OPERATOR_PROPERTY_KEY, getOperator());
        setNotNullProperty(entity, COMP_KEY_PROPERTY_KEY, getCompKey());
        setNotNullProperty(entity, COMP_TYPE_PROPERTY_KEY, getCompType());
        setNotNullProperty(entity, DECISION_KEY_PROPERTY_KEY, getDecisionKey());
    }

    public static final String OPERATOR_PROPERTY_KEY = SWFParametersConstants.DECISION_NODE_OPERATOR;
    public static final String COMP_KEY_PROPERTY_KEY = SWFParametersConstants.DECISION_NODE_COMP_KEY;
    public static final String COMP_TYPE_PROPERTY_KEY = SWFParametersConstants.DECISION_NODE_COMP_TYPE;
    public static final String DECISION_KEY_PROPERTY_KEY = SWFParametersConstants.DECISION_NODE_DECISION_KEY;

    // @Override
    // public String getFreeOutputTerminal(String connectionName)
    // {
    // if (connectionName == null)
    // {
    // if (mainTrueOutput == null)
    // {
    // return "SOUTH";
    // } else {
    // return "EAST";
    // }
    // }
    // if ("FALSE".equals(connectionName)){
    // return "EAST";
    // } else{
    // return "SOUTH";
    // }
    //
    // }
    //
    // @Override
    // public String getFreeInputTerminal(String connectionName) {
    // return "NORTH";
    // }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.DecisionNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        DecisionNodeImpl node = new DecisionNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setName(this.getName());
        node.setCompKey(this.getCompKey());
        node.setDecisionKey(this.getDecisionKey());
        node.setCompType(this.getCompType());
        node.setOperator(this.getOperator());
        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }

} // DecisionNodeImpl
