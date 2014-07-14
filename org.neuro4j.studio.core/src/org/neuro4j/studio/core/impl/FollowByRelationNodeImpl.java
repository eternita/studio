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
import org.neuro4j.workflow.xml.WorkflowNode;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.FollowByRelationNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Follow By Relation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.FollowByRelationNodeImpl#getRelationName <em>Relation Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.FollowByRelationNodeImpl#getMainInput <em>Main Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FollowByRelationNodeImpl extends ActionNodeImpl implements FollowByRelationNode {

    protected static final String NAME_EDEFAULT = "Switch";

    /**
     * The default value of the '{@link #getRelationName() <em>Relation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRelationName()
     * @generated
     * @ordered
     */
    protected static final String RELATION_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRelationName() <em>Relation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRelationName()
     * @generated
     * @ordered
     */
    protected String relationName = RELATION_NAME_EDEFAULT;

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
    protected FollowByRelationNodeImpl() {
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
        return Neuro4jPackage.Literals.FOLLOW_BY_RELATION_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRelationName(String newRelationName) {
        String oldRelationName = relationName;
        relationName = newRelationName;
        setName(getDefaultName() + " : " + relationName);
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.FOLLOW_BY_RELATION_NODE__RELATION_NAME, oldRelationName, relationName));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT, oldMainInput, mainInput));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT, oldMainInput, mainInput));
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
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__RELATION_NAME:
                return getRelationName();
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT:
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
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__RELATION_NAME:
                setRelationName((String) newValue);
                return;
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT:
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
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__RELATION_NAME:
                setRelationName(RELATION_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT:
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
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__RELATION_NAME:
                return RELATION_NAME_EDEFAULT == null ? relationName != null : !RELATION_NAME_EDEFAULT.equals(relationName);
            case Neuro4jPackage.FOLLOW_BY_RELATION_NODE__MAIN_INPUT:
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
        result.append(" (relationName: ");
        result.append(relationName);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        setNotNullProperty(entity, SWF_PARAM_DEFAULT, getRelationName());
    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        setRelationName(entity.getParameter(SWF_PARAM_DEFAULT));
    }

    public static final String SWF_PARAM_DEFAULT = SWFParametersConstants.SWITCH_NODE_ACTION_NAME;

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.SwitchBlock";

    @Override
    public String getDefaultName(int count) {
        return getDefaultName();
    }

    @Override
    public ActionNode createPasteClone(Network net) {
        FollowByRelationNodeImpl node = new FollowByRelationNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setName(this.getName());

        node.setRelationName(this.getRelationName());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }

} // FollowByRelationNodeImpl
