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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.EndNodeImpl#getMode <em>Mode</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.EndNodeImpl#getOutParameters <em>Out Parameters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EndNodeImpl extends ActionNodeImpl implements EndNode {

    protected static final String NAME_EDEFAULT = "EndNode";

    /**
     * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMode()
     * @generated
     * @ordered
     */
    protected static final String MODE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMode()
     * @generated
     * @ordered
     */
    protected String mode = MODE_EDEFAULT;

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
    protected EndNodeImpl() {
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
        return Neuro4jPackage.Literals.END_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getMode() {
        return mode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMode(String newMode) {
        String oldMode = mode;
        mode = newMode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.END_NODE__MODE, oldMode, mode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<InOutParameter> getOutParameters() {
        if (outParameters == null) {
            outParameters = new EObjectResolvingEList<InOutParameter>(InOutParameter.class, this, Neuro4jPackage.END_NODE__OUT_PARAMETERS);
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
            case Neuro4jPackage.END_NODE__MODE:
                return getMode();
            case Neuro4jPackage.END_NODE__OUT_PARAMETERS:
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
            case Neuro4jPackage.END_NODE__MODE:
                setMode((String) newValue);
                return;
            case Neuro4jPackage.END_NODE__OUT_PARAMETERS:
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
            case Neuro4jPackage.END_NODE__MODE:
                setMode(MODE_EDEFAULT);
                return;
            case Neuro4jPackage.END_NODE__OUT_PARAMETERS:
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
            case Neuro4jPackage.END_NODE__MODE:
                return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
            case Neuro4jPackage.END_NODE__OUT_PARAMETERS:
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
        result.append(" (mode: ");
        result.append(mode);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.EndNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        EndNodeImpl node = new EndNodeImpl();
        // node.setNetwork(net);
        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setName(this.getName());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }
    
	@Override
	public NodeType getNodeType() {
		return NodeType.END;
	}

} // EndNodeImpl
