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
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.util.UUIDMgr;
import org.neuro4j.workflow.node.WorkflowNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapper Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.MapperNodeImpl#getKeyValue <em>Key Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.MapperNodeImpl#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MapperNodeImpl extends ActionNodeImpl implements MapperNode {

    protected static final String NAME_EDEFAULT = "MapperNode";

    /**
     * The cached value of the '{@link #getKeyValue() <em>Key Value</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getKeyValue()
     * @generated
     * @ordered
     */
    protected EList<KeyValuePair> keyValue;

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
    protected MapperNodeImpl() {
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
        return Neuro4jPackage.Literals.MAPPER_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<KeyValuePair> getKeyValue() {
        if (keyValue == null) {
            keyValue = new EObjectResolvingEList<KeyValuePair>(KeyValuePair.class, this, Neuro4jPackage.MAPPER_NODE__KEY_VALUE);
        }
        return keyValue;
    }

    public void notifyPropertyChanged(Object oldValue, Object newValue)
    {
        eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.MAPPER_NODE__KEY_VALUE, oldValue, newValue));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT, oldMainOutput, mainOutput));
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
            case Neuro4jPackage.MAPPER_NODE__KEY_VALUE:
                return getKeyValue();
            case Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT:
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
            case Neuro4jPackage.MAPPER_NODE__KEY_VALUE:
                getKeyValue().clear();
                getKeyValue().addAll((Collection<? extends KeyValuePair>) newValue);
                return;
            case Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT:
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
            case Neuro4jPackage.MAPPER_NODE__KEY_VALUE:
                getKeyValue().clear();
                return;
            case Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT:
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
            case Neuro4jPackage.MAPPER_NODE__KEY_VALUE:
                return keyValue != null && !keyValue.isEmpty();
            case Neuro4jPackage.MAPPER_NODE__MAIN_OUTPUT:
                return mainOutput != null;
        }
        return super.eIsSet(featureID);
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        EList<KeyValuePair> list = this.getKeyValue();
        int i = 1;
        for (KeyValuePair kbp : list)
        {
            entity.addParameter(KEY_PREFIX + i, kbp.getKey() + KEY_VALUE_SEPARATOR + kbp.getValue());
            i++;
        }
    }

    /**
	 * 
	 */
    @Override
    public void getNodeSpecificProperties(WorkflowNode entity) {
        Set<String> keys = entity.getParameters().keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            //
            if (key.startsWith(KEY_PREFIX))
            {
                String value = entity.getParameter(key);
                if (value != null)
                {
                    String[] values = value.split(":");
                    if (null != values)
                    {
                        KeyValuePair kvp = Neuro4jFactory.eINSTANCE.createKeyValuePair();
                        kvp.setKey(values[0]);
                        if (values.length == 2)
                        {
                            kvp.setValue(values[1]);
                        }
                        getKeyValue().add(kvp);
                    }

                }

            }

        }

    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.KeyMapper";

    @Override
    public ActionNode createPasteClone(Network net) {
        MapperNodeImpl node = new MapperNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());

        EList<KeyValuePair> kv = this.getKeyValue();

        node.getKeyValue().addAll(kv);

        node.setName(this.getName());

        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }

} // MapperNodeImpl
