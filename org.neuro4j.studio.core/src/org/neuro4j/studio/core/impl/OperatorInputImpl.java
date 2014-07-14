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
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.OperatorInputImpl#getInput <em>Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.OperatorInputImpl#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperatorInputImpl extends NodeImpl implements OperatorInput {
    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected OperatorOutput input;

    /**
     * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getNode()
     * @generated
     * @ordered
     */
    protected ActionNode node;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorInputImpl() {
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
        return Neuro4jPackage.Literals.OPERATOR_INPUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getInput() {
        if (input != null && input.eIsProxy()) {
            InternalEObject oldInput = (InternalEObject) input;
            input = (OperatorOutput) eResolveProxy(oldInput);
            if (input != oldInput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.OPERATOR_INPUT__INPUT, oldInput, input));
            }
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetInput() {
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setInput(OperatorOutput newInput) {
        OperatorOutput oldInput = input;
        input = newInput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_INPUT__INPUT, oldInput, input));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode getNode() {
        if (node != null && node.eIsProxy()) {
            InternalEObject oldNode = (InternalEObject) node;
            node = (ActionNode) eResolveProxy(oldNode);
            if (node != oldNode) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.OPERATOR_INPUT__NODE, oldNode, node));
            }
        }
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode basicGetNode() {
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNode(ActionNode newNode) {
        ActionNode oldNode = node;
        node = newNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_INPUT__NODE, oldNode, node));
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
            case Neuro4jPackage.OPERATOR_INPUT__INPUT:
                if (resolve)
                    return getInput();
                return basicGetInput();
            case Neuro4jPackage.OPERATOR_INPUT__NODE:
                if (resolve)
                    return getNode();
                return basicGetNode();
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
            case Neuro4jPackage.OPERATOR_INPUT__INPUT:
                setInput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.OPERATOR_INPUT__NODE:
                setNode((ActionNode) newValue);
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
            case Neuro4jPackage.OPERATOR_INPUT__INPUT:
                setInput((OperatorOutput) null);
                return;
            case Neuro4jPackage.OPERATOR_INPUT__NODE:
                setNode((ActionNode) null);
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
            case Neuro4jPackage.OPERATOR_INPUT__INPUT:
                return input != null;
            case Neuro4jPackage.OPERATOR_INPUT__NODE:
                return node != null;
        }
        return super.eIsSet(featureID);
    }

} // OperatorInputImpl
