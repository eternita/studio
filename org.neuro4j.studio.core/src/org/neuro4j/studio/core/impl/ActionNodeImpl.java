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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.swt.graphics.Color;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.NodeXML;
 ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.ActionNodeImpl#getInput <em>Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.ActionNodeImpl#getOutput <em>Output</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.ActionNodeImpl#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.ActionNodeImpl#getX <em>X</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.ActionNodeImpl#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ActionNodeImpl extends NodeImpl implements ActionNode {
    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInput()
     * @generated
     * @ordered
     */

    protected Network network;

    protected EList<OperatorInput> input;

    @Override
    public void setNetwork(Network network) {
        this.network = network;

    }

    /**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOutput()
     * @generated
     * @ordered
     */
    protected EList<OperatorOutput> output;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getX()
     * @generated
     * @ordered
     */
    protected static final int X_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getX() <em>X</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getX()
     * @generated
     * @ordered
     */
    protected int x = X_EDEFAULT;

    /**
     * The default value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getY()
     * @generated
     * @ordered
     */
    protected static final int Y_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getY()
     * @generated
     * @ordered
     */
    protected int y = Y_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ActionNodeImpl() {
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
        return Neuro4jPackage.Literals.ACTION_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<OperatorInput> getInput() {
        if (input == null) {
            input = new EObjectContainmentEList<OperatorInput>(OperatorInput.class, this, Neuro4jPackage.ACTION_NODE__INPUT);
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<OperatorOutput> getOutput() {
        if (output == null) {
            output = new EObjectContainmentEList<OperatorOutput>(OperatorOutput.class, this, Neuro4jPackage.ACTION_NODE__OUTPUT);
        }
        return output;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.ACTION_NODE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getX() {
        return x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setX(int newX) {
        int oldX = x;
        x = newX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.ACTION_NODE__X, oldX, x));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getY() {
        return y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setY(int newY) {
        int oldY = y;
        y = newY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.ACTION_NODE__Y, oldY, y));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Neuro4jPackage.ACTION_NODE__INPUT:
                return ((InternalEList<?>) getInput()).basicRemove(otherEnd, msgs);
            case Neuro4jPackage.ACTION_NODE__OUTPUT:
                return ((InternalEList<?>) getOutput()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case Neuro4jPackage.ACTION_NODE__INPUT:
                return getInput();
            case Neuro4jPackage.ACTION_NODE__OUTPUT:
                return getOutput();
            case Neuro4jPackage.ACTION_NODE__NAME:
                return getName();
            case Neuro4jPackage.ACTION_NODE__X:
                return getX();
            case Neuro4jPackage.ACTION_NODE__Y:
                return getY();
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
            case Neuro4jPackage.ACTION_NODE__NAME:
                setName((String) newValue);
                return;
            case Neuro4jPackage.ACTION_NODE__X:
                setX((Integer) newValue);
                return;
            case Neuro4jPackage.ACTION_NODE__Y:
                setY((Integer) newValue);
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
            case Neuro4jPackage.ACTION_NODE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Neuro4jPackage.ACTION_NODE__X:
                setX(X_EDEFAULT);
                return;
            case Neuro4jPackage.ACTION_NODE__Y:
                setY(Y_EDEFAULT);
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
            case Neuro4jPackage.ACTION_NODE__INPUT:
                return input != null && !input.isEmpty();
            case Neuro4jPackage.ACTION_NODE__OUTPUT:
                return output != null && !output.isEmpty();
            case Neuro4jPackage.ACTION_NODE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Neuro4jPackage.ACTION_NODE__X:
                return x != X_EDEFAULT;
            case Neuro4jPackage.ACTION_NODE__Y:
                return y != Y_EDEFAULT;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", x: ");
        result.append(x);
        result.append(", y: ");
        result.append(y);
        result.append(')');
        return result.toString();
    }

    @Override
    public void setNodeSpecificProperties(NodeXML entity) {

    }

    protected void setNotNullProperty(NodeXML entity, String key, String value, Boolean isInput)
    {
        if (null != value)
        {
            entity.addParameter(key, value, isInput);
        }
    }
    
    protected void setNotNullConfig(NodeXML entity, String key, String value)
    {
        if (null != value && !"".equals(value.trim()))
        {
            entity.addConfig(key, value);
        }
    }
    
    protected void setNotNullConfig(NodeXML entity, String key, String value, String defaultValue)
    {
        if (value == null || "".equals(value.trim()))
        {
        	setNotNullConfig(entity, key, defaultValue);
        } else {
        	setNotNullConfig(entity, key, value);
        }

    }

    protected void setNotNullProperty(NodeXML entity, String key, String value, String defaultValue, Boolean isInput)
    {
        if (value == null || "".equals(value.trim()))
        {
            setNotNullProperty(entity, key, defaultValue, isInput);
        } else {
            setNotNullProperty(entity, key, value, isInput);
        }

    }

    @Override
    public void getNodeSpecificProperties(NodeXML entity) {

    }

    @Override
    public String getDefaultName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void onConnectionNameChange(Object newSelected) {
        // TODO Auto-generated method stub

    }

    @Override
    public String buildToolTip() {
        return null;
    }

    @Override
    public String getLogicImplementationClassName() {
        return null;
    }

    public Network getNetwork()
    {
        return network;
    }

    @Override
    public int getXOffset() {
        // TODO Auto-generated method stub
        return 40;
    }

    @Override
    public int getYOffset() {
        // TODO Auto-generated method stub
        return 40;
    }

    @Override
    public String getDefaultName(int count) {
        return getDefaultName() + count;
    }

    @Override
    public void setBGColor(Color lightgray) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setOwnIcon() {
        // TODO Auto-generated method stub

    }

    @Override
    public ActionNode createPasteClone(Network net) {

        return null;
    }

} // ActionNodeImpl
