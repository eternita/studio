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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.neuro4j.workflow.common.SWFParametersConstants;
import org.neuro4j.workflow.node.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.CallNodeImpl#getFlowName <em>Flow Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.CallNodeImpl#getDynamicFlowName <em>Dynamic Flow Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.CallNodeImpl#getInputParameters <em>Input Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.CallNodeImpl#getOutputParameters <em>Output Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CallNodeImpl extends ActionNodeImpl implements CallNode {

    protected static final String NAME_EDEFAULT = "CallNode";

    /**
     * The default value of the '{@link #getFlowName() <em>Flow Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getFlowName()
     * @generated
     * @ordered
     */
    protected static final String FLOW_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getFlowName() <em>Flow Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getFlowName()
     * @generated
     * @ordered
     */
    protected String flowName = FLOW_NAME_EDEFAULT;
    /**
     * The default value of the '{@link #getDynamicFlowName() <em>Dynamic Flow Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDynamicFlowName()
     * @generated
     * @ordered
     */
    protected static final String DYNAMIC_FLOW_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDynamicFlowName() <em>Dynamic Flow Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDynamicFlowName()
     * @generated
     * @ordered
     */
    protected String dynamicFlowName = DYNAMIC_FLOW_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputParameters() <em>Input Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInputParameters()
     * @generated
     * @ordered
     */
    protected EList<InOutParameter> inputParameters;
    /**
     * The cached value of the '{@link #getOutputParameters() <em>Output Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOutputParameters()
     * @generated
     * @ordered
     */
    protected EList<InOutParameter> outputParameters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CallNodeImpl() {
        super();
    }

    Set<String> usedOutputNames = new HashSet<String>();

    public Set<String> getUsedOutputNames() {
        return usedOutputNames;
    }

    public void setUsedOutputNames(Set<String> usedOutputNames) {
        this.usedOutputNames = usedOutputNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Neuro4jPackage.Literals.CALL_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFlowName(String newFlowName) {
        String oldFlowName = flowName;
        flowName = newFlowName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.CALL_NODE__FLOW_NAME, oldFlowName, flowName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDynamicFlowName() {
        return dynamicFlowName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDynamicFlowName(String newDynamicFlowName) {
        String oldDynamicFlowName = dynamicFlowName;
        dynamicFlowName = newDynamicFlowName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME, oldDynamicFlowName, dynamicFlowName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getInputParameters() {
        if (inputParameters == null) {
            inputParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.CALL_NODE__INPUT_PARAMETERS);
        }
        return inputParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getOutputParameters() {
        if (outputParameters == null) {
            outputParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.CALL_NODE__OUTPUT_PARAMETERS);
        }
        return outputParameters;
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
            case Neuro4jPackage.CALL_NODE__FLOW_NAME:
                return getFlowName();
            case Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME:
                return getDynamicFlowName();
            case Neuro4jPackage.CALL_NODE__INPUT_PARAMETERS:
                return getInputParameters();
            case Neuro4jPackage.CALL_NODE__OUTPUT_PARAMETERS:
                return getOutputParameters();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Neuro4jPackage.CALL_NODE__FLOW_NAME:
                setFlowName((String) newValue);
                return;
            case Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME:
                setDynamicFlowName((String) newValue);
                return;
            case Neuro4jPackage.CALL_NODE__INPUT_PARAMETERS:
                getInputParameters().clear();
                getInputParameters().addAll((Collection<? extends InOutParameter>) newValue);
                return;
            case Neuro4jPackage.CALL_NODE__OUTPUT_PARAMETERS:
                getOutputParameters().clear();
                getOutputParameters().addAll((Collection<? extends InOutParameter>) newValue);
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
            case Neuro4jPackage.CALL_NODE__FLOW_NAME:
                setFlowName(FLOW_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME:
                setDynamicFlowName(DYNAMIC_FLOW_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.CALL_NODE__INPUT_PARAMETERS:
                getInputParameters().clear();
                return;
            case Neuro4jPackage.CALL_NODE__OUTPUT_PARAMETERS:
                getOutputParameters().clear();
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
            case Neuro4jPackage.CALL_NODE__FLOW_NAME:
                return FLOW_NAME_EDEFAULT == null ? flowName != null : !FLOW_NAME_EDEFAULT.equals(flowName);
            case Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME:
                return DYNAMIC_FLOW_NAME_EDEFAULT == null ? dynamicFlowName != null : !DYNAMIC_FLOW_NAME_EDEFAULT.equals(dynamicFlowName);
            case Neuro4jPackage.CALL_NODE__INPUT_PARAMETERS:
                return inputParameters != null && !inputParameters.isEmpty();
            case Neuro4jPackage.CALL_NODE__OUTPUT_PARAMETERS:
                return outputParameters != null && !outputParameters.isEmpty();
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
        result.append(" (flowName: ");
        result.append(flowName);
        result.append(", dynamicFlowName: ");
        result.append(dynamicFlowName);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        // TODO Auto-generated method stub
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        setNotNullProperty(entity, FLOW_NAME_PROPERTY_KEY, getFlowName());
        setNotNullProperty(entity, DYNAMIC_FLOW_NAME_PROPERTY_KEY, getDynamicFlowName());
    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        setFlowName(entity.getParameter(FLOW_NAME_PROPERTY_KEY));
        setDynamicFlowName(entity.getParameter(DYNAMIC_FLOW_NAME_PROPERTY_KEY));
    }

    public static final String FLOW_NAME_PROPERTY_KEY = SWFParametersConstants.CAll_NODE_FLOW_NAME;
    public static final String DYNAMIC_FLOW_NAME_PROPERTY_KEY = SWFParametersConstants.CAll_NODE_DYNAMIC_FLOW_NAME;

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.CallNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        CallNodeImpl node = new CallNodeImpl();
        // node.setNetwork(net);
        node.setName(this.getName());
        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setDynamicFlowName(this.getDynamicFlowName());
        node.setFlowName(this.getFlowName());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }

} // CallNodeImpl
