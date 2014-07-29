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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.HasFewInOutAnchors;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.ParameterXML;
import org.neuro4j.studio.core.util.FlowUtils;
import org.neuro4j.studio.core.util.UUIDMgr;
import org.neuro4j.workflow.common.SWFParametersConstants;
import org.neuro4j.workflow.node.WorkflowNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#getClassName <em>Class Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#getMainOutput <em>Main Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#getErrorOutput <em>Error Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#isHasErrorOutput <em>Has Error Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#getInParameters <em>In Parameters</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LogicNodeImpl#getOutParameters <em>Out Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 */
public class LogicNodeImpl extends ActionNodeImpl implements LogicNode, HasFewInOutAnchors {

    protected static final String NAME_EDEFAULT = "CustomNode";


    public final static String PARAMETER_TYPE_IN = "IN";
    public final static String PARAMETER_TYPE_OUT = "OUT";
    /**
     * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected static final String CLASS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected String className = CLASS_NAME_EDEFAULT;

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
     * The cached value of the '{@link #getErrorOutput() <em>Error Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getErrorOutput()
     * @generated
     * @ordered
     */
    protected OperatorOutput errorOutput;

    /**
     * The default value of the '{@link #isHasErrorOutput() <em>Has Error Output</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isHasErrorOutput()
     * @generated
     * @ordered
     */
    protected static final boolean HAS_ERROR_OUTPUT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isHasErrorOutput() <em>Has Error Output</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isHasErrorOutput()
     * @generated
     * @ordered
     */
    protected boolean hasErrorOutput = HAS_ERROR_OUTPUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getInParameters() <em>In Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInParameters()
     * @generated
     * @ordered
     */
    protected EList<InOutParameter> inParameters;

    /**
     * The cached value of the '{@link #getOutParameters() <em>Out Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOutParameters()
     * @generated
     * @ordered
     */
    protected EList<InOutParameter> outParameters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LogicNodeImpl() {
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
        return Neuro4jPackage.Literals.LOGIC_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getClassName() {
        return className;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setClassName(String newClassName) {
        String oldClassName = className;
        className = newClassName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOGIC_NODE__CLASS_NAME, oldClassName, className));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getErrorOutput() {
        if (errorOutput != null && errorOutput.eIsProxy()) {
            InternalEObject oldErrorOutput = (InternalEObject) errorOutput;
            errorOutput = (OperatorOutput) eResolveProxy(oldErrorOutput);
            if (errorOutput != oldErrorOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT, oldErrorOutput, errorOutput));
            }
        }
        return errorOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetErrorOutput() {
        return errorOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setErrorOutput(OperatorOutput newErrorOutput) {
        OperatorOutput oldErrorOutput = errorOutput;
        errorOutput = newErrorOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT, oldErrorOutput, errorOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isHasErrorOutput() {
        return hasErrorOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setHasErrorOutput(boolean newHasErrorOutput) {
        boolean oldHasErrorOutput = hasErrorOutput;
        hasErrorOutput = newHasErrorOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT, oldHasErrorOutput, hasErrorOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getInParameters() {
        if (inParameters == null) {
            inParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS);
        }
        return inParameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getOutParameters() {
        if (outParameters == null) {
            outParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.LOGIC_NODE__OUT_PARAMETERS);
        }
        return outParameters;
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
            case Neuro4jPackage.LOGIC_NODE__CLASS_NAME:
                return getClassName();
            case Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT:
                if (resolve)
                    return getMainOutput();
                return basicGetMainOutput();
            case Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT:
                if (resolve)
                    return getErrorOutput();
                return basicGetErrorOutput();
            case Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT:
                return isHasErrorOutput();
            case Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS:
                return getInParameters();
            case Neuro4jPackage.LOGIC_NODE__OUT_PARAMETERS:
                return getOutParameters();
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
            case Neuro4jPackage.LOGIC_NODE__CLASS_NAME:
                setClassName((String) newValue);
                return;
            case Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT:
                setErrorOutput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT:
                setHasErrorOutput((Boolean) newValue);
                return;
            case Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS:
                getInParameters().clear();
                getInParameters().addAll((Collection<? extends InOutParameter>) newValue);
                return;
            case Neuro4jPackage.LOGIC_NODE__OUT_PARAMETERS:
                getOutParameters().clear();
                getOutParameters().addAll((Collection<? extends InOutParameter>) newValue);
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
            case Neuro4jPackage.LOGIC_NODE__CLASS_NAME:
                setClassName(CLASS_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) null);
                return;
            case Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT:
                setErrorOutput((OperatorOutput) null);
                return;
            case Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT:
                setHasErrorOutput(HAS_ERROR_OUTPUT_EDEFAULT);
                return;
            case Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS:
                getInParameters().clear();
                return;
            case Neuro4jPackage.LOGIC_NODE__OUT_PARAMETERS:
                getOutParameters().clear();
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
            case Neuro4jPackage.LOGIC_NODE__CLASS_NAME:
                return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
            case Neuro4jPackage.LOGIC_NODE__MAIN_OUTPUT:
                return mainOutput != null;
            case Neuro4jPackage.LOGIC_NODE__ERROR_OUTPUT:
                return errorOutput != null;
            case Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT:
                return hasErrorOutput != HAS_ERROR_OUTPUT_EDEFAULT;
            case Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS:
                return inParameters != null && !inParameters.isEmpty();
            case Neuro4jPackage.LOGIC_NODE__OUT_PARAMETERS:
                return outParameters != null && !outParameters.isEmpty();
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
        result.append(" (className: ");
        result.append(className);
        result.append(", hasErrorOutput: ");
        result.append(hasErrorOutput);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(NodeXML entity) {
        setNotNullConfig(entity, CLASS_NAME_PROPERTY_KEY, getName());
        setNotNullConfig(entity, CUSTOM_CLASS_NAME_PROPERTY_KEY, getClassName());
        saveInOutParameters(entity);

    }

    private void saveInOutParameters(NodeXML entity)
    {
        EList<InOutParameter> parameters = getInParameters();
        int i = 1;
        for (InOutParameter parameter : parameters)
        {
            saveParameter(i++, true, parameter, entity);

        }
        i = 1;
        parameters = getOutParameters();
        for (InOutParameter parameter : parameters)
        {
            saveParameter(i++, false, parameter, entity);

        }
    }

    private void saveParameter(int number, boolean isInput, InOutParameter parameter, NodeXML entity)
    {
        if (parameter.getValue() != null && "".equals(parameter.getValue().trim()))
        {
            return;
        }
        setNotNullProperty(entity, parameter.getName(), parameter.getValue(), isInput);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.neuro4j.studio.core.impl.ActionNodeImpl#getNodeSpecificProperties(org.neuro4j.core.Entity)
     */
    @Override
    public void getNodeSpecificProperties(NodeXML entity) {
        setClassName(entity.getConfig(CUSTOM_CLASS_NAME_PROPERTY_KEY));
        setName(entity.getName());
        readInputParameters(entity);
    }

    private void readInputParameters(NodeXML entity)
    {
        List<ParameterXML> properties = entity.getParameters();
        for (ParameterXML p : properties) {
                    boolean isOutput = (p.input != null && !p.input);
                    InOutParameter parameter = FlowUtils.getInParameter(getClassName(), p.getKey(), p.getValue(), (isOutput) ? "output" : "input");
                    if (parameter.isValid()) {
                        if (isOutput)
                        {
                            getOutParameters().add(parameter);
                        } else {
                            getInParameters().add(parameter);
                        }

                    }
        }

    }

    public static final String CLASS_NAME_PROPERTY_KEY = "SWF_BLOCK_CLASS";
    public static final String CUSTOM_CLASS_NAME_PROPERTY_KEY = SWFParametersConstants.LOGIC_NODE_CUSTOM_CLASS_NAME;

    public void notifyPropertyChanged(Object oldValue, Object newValue)
    {
        eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOGIC_NODE__IN_PARAMETERS, oldValue, newValue));
    }

    @Override
    public void onConnectionNameChange(Object newSelected) {

    }

    @Override
    public String getFreeOutputTerminal(String connectionName)
    {
        if (connectionName == null)
        {
            if (mainOutput == null)
            {
                return "SOUTH";
            } else {
                return "EAST";
            }
        }
        if ("ERROR".equals(connectionName)) {
            return "EAST";
        } else {
            return "SOUTH";
        }

    }

    @Override
    public String getFreeInputTerminal(String connectionName) {
        return "NORTH";
    }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.CustomNode";

    @Override
    public String buildToolTip() {
        return getClassName();
    }

    @Override
    public ActionNode createPasteClone(Network net) {
        LogicNodeImpl node = new LogicNodeImpl();

        node.setName(this.getName());

        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setClassName(this.getClassName());

        EList<InOutParameter> ip = this.getInParameters();
        node.getInParameters().addAll(ip);

        EList<InOutParameter> outp = this.getOutParameters();
        node.getOutParameters().addAll(outp);

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }
    
	@Override
	public NodeType getNodeType() {
		return NodeType.CUSTOM;
	}

} // LogicNodeImpl
