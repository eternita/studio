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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.neuro4j.workflow.common.SWFParametersConstants;
import org.neuro4j.workflow.enums.StartNodeTypes;
import org.neuro4j.workflow.xml.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.StartNodeImpl#getType <em>Type</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.StartNodeImpl#getInputParameters <em>Input Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.StartNodeImpl#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StartNodeImpl extends ActionNodeImpl implements StartNode {

    public static final String NAME_EDEFAULT = "StartNode";

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;
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
     * The cached value of the '{@link #getMainOutput() <em>Main Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMainOutput()
     * @generated
     * @ordered
     */
    protected OperatorOutput mainOutput;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StartNodeImpl() {
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
        return Neuro4jPackage.Literals.START_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.START_NODE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getInputParameters() {
        if (inputParameters == null) {
            inputParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.START_NODE__INPUT_PARAMETERS);
        }
        return inputParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getMainOutput() {
        if (mainOutput != null && mainOutput.eIsProxy()) {
            InternalEObject oldMainOutput = (InternalEObject) mainOutput;
            mainOutput = (OperatorOutput) eResolveProxy(oldMainOutput);
            if (mainOutput != oldMainOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.START_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
            }
        }
        return mainOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetMainOutput() {
        return mainOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMainOutput(OperatorOutput newMainOutput) {
        OperatorOutput oldMainOutput = mainOutput;
        mainOutput = newMainOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.START_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            case Neuro4jPackage.START_NODE__TYPE:
                return getType();
            case Neuro4jPackage.START_NODE__INPUT_PARAMETERS:
                return getInputParameters();
            case Neuro4jPackage.START_NODE__MAIN_OUTPUT:
                if (resolve)
                    return getMainOutput();
                return basicGetMainOutput();
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
            case Neuro4jPackage.START_NODE__TYPE:
                setType((String) newValue);
                return;
            case Neuro4jPackage.START_NODE__INPUT_PARAMETERS:
                getInputParameters().clear();
                getInputParameters().addAll((Collection<? extends InOutParameter>) newValue);
                return;
            case Neuro4jPackage.START_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) newValue);
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
            case Neuro4jPackage.START_NODE__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case Neuro4jPackage.START_NODE__INPUT_PARAMETERS:
                getInputParameters().clear();
                return;
            case Neuro4jPackage.START_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) null);
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
            case Neuro4jPackage.START_NODE__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case Neuro4jPackage.START_NODE__INPUT_PARAMETERS:
                return inputParameters != null && !inputParameters.isEmpty();
            case Neuro4jPackage.START_NODE__MAIN_OUTPUT:
                return mainOutput != null;
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
        result.append(" (type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        setNotNullProperty(entity, START_NODE_TYPE_PROPERTY_KEY, getType(), StartNodeTypes.PUBLIC.name());

    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        setType(entity.getParameter(START_NODE_TYPE_PROPERTY_KEY));
    }

    public static final String START_NODE_TYPE_PROPERTY_KEY = SWFParametersConstants.START_NODE_TYPE;

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.StartBlock";

    public boolean isValidName(String name, Node currentStartNode)
    {
        return network.isValidStartNodeName(name, currentStartNode);
    }

    @Override
    public int getXOffset() {
        return 40;
    }

    @Override
    public int getYOffset() {
        return 40;
    }

    @Override
    public ActionNode createPasteClone(Network net) {
        StartNodeImpl node = new StartNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());

        node.setType(this.getType());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        node.setName(this.getName());

        return node;
    }

} // StartNodeImpl
