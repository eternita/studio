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
import org.neuro4j.studio.core.HasFewInOutAnchors;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getLoopExit <em>Loop Exit</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getLoopInput <em>Loop Input</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getIteratorKey <em>Iterator Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getElementKey <em>Element Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getMainExit <em>Main Exit</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.LoopNodeImpl#getMainInput <em>Main Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 */
public class LoopNodeImpl extends ActionNodeImpl implements LoopNode, HasFewInOutAnchors {

    protected static final String NAME_EDEFAULT = "LoopNode";

    /**
     * The cached value of the '{@link #getLoopExit() <em>Loop Exit</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLoopExit()
     * @generated
     * @ordered
     */
    protected OperatorOutput loopExit;

    /**
     * The cached value of the '{@link #getLoopInput() <em>Loop Input</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLoopInput()
     * @generated
     * @ordered
     */
    protected OperatorInput loopInput;

    /**
     * The default value of the '{@link #getIteratorKey() <em>Iterator Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIteratorKey()
     * @generated
     * @ordered
     */
    protected static final String ITERATOR_KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIteratorKey() <em>Iterator Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIteratorKey()
     * @generated
     * @ordered
     */
    protected String iteratorKey = ITERATOR_KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getElementKey() <em>Element Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getElementKey()
     * @generated
     * @ordered
     */
    protected static final String ELEMENT_KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getElementKey() <em>Element Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getElementKey()
     * @generated
     * @ordered
     */
    protected String elementKey = ELEMENT_KEY_EDEFAULT;

    /**
     * The cached value of the '{@link #getMainExit() <em>Main Exit</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMainExit()
     * @generated
     * @ordered
     */
    protected OperatorOutput mainExit;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LoopNodeImpl() {
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
        return Neuro4jPackage.Literals.LOOP_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getLoopExit() {
        if (loopExit != null && loopExit.eIsProxy()) {
            InternalEObject oldLoopExit = (InternalEObject) loopExit;
            loopExit = (OperatorOutput) eResolveProxy(oldLoopExit);
            if (loopExit != oldLoopExit) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOOP_NODE__LOOP_EXIT, oldLoopExit, loopExit));
            }
        }
        return loopExit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetLoopExit() {
        return loopExit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLoopExit(OperatorOutput newLoopExit) {
        OperatorOutput oldLoopExit = loopExit;
        loopExit = newLoopExit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__LOOP_EXIT, oldLoopExit, loopExit));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorInput getLoopInput() {
        if (loopInput != null && loopInput.eIsProxy()) {
            InternalEObject oldLoopInput = (InternalEObject) loopInput;
            loopInput = (OperatorInput) eResolveProxy(oldLoopInput);
            if (loopInput != oldLoopInput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOOP_NODE__LOOP_INPUT, oldLoopInput, loopInput));
            }
        }
        return loopInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorInput basicGetLoopInput() {
        return loopInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLoopInput(OperatorInput newLoopInput) {
        OperatorInput oldLoopInput = loopInput;
        loopInput = newLoopInput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__LOOP_INPUT, oldLoopInput, loopInput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getIteratorKey() {
        return iteratorKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIteratorKey(String newIteratorKey) {
        String oldIteratorKey = iteratorKey;
        iteratorKey = newIteratorKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__ITERATOR_KEY, oldIteratorKey, iteratorKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getElementKey() {
        return elementKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setElementKey(String newElementKey) {
        String oldElementKey = elementKey;
        elementKey = newElementKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__ELEMENT_KEY, oldElementKey, elementKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput getMainExit() {
        if (mainExit != null && mainExit.eIsProxy()) {
            InternalEObject oldMainExit = (InternalEObject) mainExit;
            mainExit = (OperatorOutput) eResolveProxy(oldMainExit);
            if (mainExit != oldMainExit) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOOP_NODE__MAIN_EXIT, oldMainExit, mainExit));
            }
        }
        return mainExit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperatorOutput basicGetMainExit() {
        return mainExit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMainExit(OperatorOutput newMainExit) {
        OperatorOutput oldMainExit = mainExit;
        mainExit = newMainExit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__MAIN_EXIT, oldMainExit, mainExit));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.LOOP_NODE__MAIN_INPUT, oldMainInput, mainInput));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.LOOP_NODE__MAIN_INPUT, oldMainInput, mainInput));
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
            case Neuro4jPackage.LOOP_NODE__LOOP_EXIT:
                if (resolve)
                    return getLoopExit();
                return basicGetLoopExit();
            case Neuro4jPackage.LOOP_NODE__LOOP_INPUT:
                if (resolve)
                    return getLoopInput();
                return basicGetLoopInput();
            case Neuro4jPackage.LOOP_NODE__ITERATOR_KEY:
                return getIteratorKey();
            case Neuro4jPackage.LOOP_NODE__ELEMENT_KEY:
                return getElementKey();
            case Neuro4jPackage.LOOP_NODE__MAIN_EXIT:
                if (resolve)
                    return getMainExit();
                return basicGetMainExit();
            case Neuro4jPackage.LOOP_NODE__MAIN_INPUT:
                if (resolve)
                    return getMainInput();
                return basicGetMainInput();
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
            case Neuro4jPackage.LOOP_NODE__LOOP_EXIT:
                setLoopExit((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.LOOP_NODE__LOOP_INPUT:
                setLoopInput((OperatorInput) newValue);
                return;
            case Neuro4jPackage.LOOP_NODE__ITERATOR_KEY:
                setIteratorKey((String) newValue);
                return;
            case Neuro4jPackage.LOOP_NODE__ELEMENT_KEY:
                setElementKey((String) newValue);
                return;
            case Neuro4jPackage.LOOP_NODE__MAIN_EXIT:
                setMainExit((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.LOOP_NODE__MAIN_INPUT:
                setMainInput((OperatorInput) newValue);
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
            case Neuro4jPackage.LOOP_NODE__LOOP_EXIT:
                setLoopExit((OperatorOutput) null);
                return;
            case Neuro4jPackage.LOOP_NODE__LOOP_INPUT:
                setLoopInput((OperatorInput) null);
                return;
            case Neuro4jPackage.LOOP_NODE__ITERATOR_KEY:
                setIteratorKey(ITERATOR_KEY_EDEFAULT);
                return;
            case Neuro4jPackage.LOOP_NODE__ELEMENT_KEY:
                setElementKey(ELEMENT_KEY_EDEFAULT);
                return;
            case Neuro4jPackage.LOOP_NODE__MAIN_EXIT:
                setMainExit((OperatorOutput) null);
                return;
            case Neuro4jPackage.LOOP_NODE__MAIN_INPUT:
                setMainInput((OperatorInput) null);
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
            case Neuro4jPackage.LOOP_NODE__LOOP_EXIT:
                return loopExit != null;
            case Neuro4jPackage.LOOP_NODE__LOOP_INPUT:
                return loopInput != null;
            case Neuro4jPackage.LOOP_NODE__ITERATOR_KEY:
                return ITERATOR_KEY_EDEFAULT == null ? iteratorKey != null : !ITERATOR_KEY_EDEFAULT.equals(iteratorKey);
            case Neuro4jPackage.LOOP_NODE__ELEMENT_KEY:
                return ELEMENT_KEY_EDEFAULT == null ? elementKey != null : !ELEMENT_KEY_EDEFAULT.equals(elementKey);
            case Neuro4jPackage.LOOP_NODE__MAIN_EXIT:
                return mainExit != null;
            case Neuro4jPackage.LOOP_NODE__MAIN_INPUT:
                return mainInput != null;
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
        result.append(" (iteratorKey: ");
        result.append(iteratorKey);
        result.append(", elementKey: ");
        result.append(elementKey);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        setNotNullProperty(entity, ELEMENT_PROPERTY_KEY, getElementKey());
        setNotNullProperty(entity, ITERATOR_PROPERTY_KEY, getIteratorKey());
    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        setElementKey(entity.getParameter(ELEMENT_PROPERTY_KEY));
        setIteratorKey(entity.getParameter(ITERATOR_PROPERTY_KEY));
    }

    public static final String ELEMENT_PROPERTY_KEY = SWFParametersConstants.LOOP_NODE_ELEMENT;
    public static final String ITERATOR_PROPERTY_KEY = SWFParametersConstants.LOOP_NODE_ITERATOR;

    @Override
    public String getFreeOutputTerminal(String connectionName)
    {
        if (connectionName == null)
        {
            if (mainExit == null)
            {
                return "EAST";
            } else {
                return "SOUTH";
            }
        }
        if (LoopNode.LOOP_EXIT.equals(connectionName)) {
            return "SOUTH";
        } else {
            return "EAST";
        }

    }

    @Override
    public String getFreeInputTerminal(String connectionName) {
        if (connectionName == null)
        {
            if (mainInput == null)
            {
                return "NOTH";
            } else {
                return "WEST";
            }
        }
        if (LoopNode.LOOP_INPUT.equals(connectionName)) {
            return "WEST";
        } else {
            return "NORTH";
        }
    }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.LoopNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        LoopNodeImpl node = new LoopNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setName(this.getName());
        node.setIteratorKey(this.getIteratorKey());
        node.setElementKey(this.getElementKey());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }

} // LoopNodeImpl
