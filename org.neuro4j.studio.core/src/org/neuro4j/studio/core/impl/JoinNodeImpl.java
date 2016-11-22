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
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.JoinNodeImpl#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JoinNodeImpl extends ActionNodeImpl implements JoinNode {

    protected static final String NAME_EDEFAULT = "JoinNode";
    protected static final String FORK_DEFAULT = "";
    protected String fork = FORK_DEFAULT;
    
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
    protected JoinNodeImpl() {
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
        return Neuro4jPackage.Literals.JOIN_NODE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            case Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT:
                if (resolve)
                    return getMainOutput();
                return basicGetMainOutput();
            case Neuro4jPackage.JOIN_NODE_FEATURE_FORK:
                return getFork();      
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
            case Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) newValue);
                return;
            case Neuro4jPackage.JOIN_NODE_FEATURE_FORK:
                setFork((String) newValue);
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
            case Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT:
                setMainOutput((OperatorOutput) null);
                return;
            case Neuro4jPackage.JOIN_NODE_FEATURE_FORK:
                setFork(FORK_DEFAULT);
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
            case Neuro4jPackage.JOIN_NODE__MAIN_OUTPUT:
                return mainOutput != null;
            case Neuro4jPackage.JOIN_NODE_FEATURE_FORK:
                return fork != null; 
        }
        return super.eIsSet(featureID);
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.JoinNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        JoinNodeImpl node = new JoinNodeImpl();
        // node.setNetwork(net);
        node.setId(UUIDMgr.getInstance().createUUIDString());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);
        node.setFork(this.getFork());
        return node;
    }

	@Override
	public NodeType getNodeType() {
		return NodeType.JOIN;
	}
	
	@Override
	public String getFork() {
		return fork;
	}

	@Override
    public void setFork(String newValue) {
//		if(newValue == null){
//			newValue = FORK_DEFAULT;
//		}
        String oldValue = fork;
        fork = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.JOIN_NODE_FEATURE_FORK, oldValue, fork));
    }
	
    @Override
    public void setNodeSpecificProperties(NodeXML entity) {
        setNotNullConfig(entity, FORK, getFork());
    }

    @Override
    public void getNodeSpecificProperties(NodeXML entity) {
        setFork(entity.getConfig(FORK));
    }
    public static final String FORK = "FORK";
} // JoinNodeImpl
