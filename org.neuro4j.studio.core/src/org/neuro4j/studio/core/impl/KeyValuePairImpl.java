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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.KeyValuePairImpl#getKey <em>Key</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.KeyValuePairImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.KeyValuePairImpl#getValueType <em>Value Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class KeyValuePairImpl extends EObjectImpl implements KeyValuePair {
    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    private String id = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected String key = KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getValueType()
     * @generated
     * @ordered
     */
    protected static final int VALUE_TYPE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getValueType()
     * @generated
     * @ordered
     */
    protected int valueType = VALUE_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public KeyValuePairImpl() {
        super();
        id = UUIDMgr.getInstance().createUUIDString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Neuro4jPackage.Literals.KEY_VALUE_PAIR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setKey(String newKey) {
        String oldKey = key;
        key = newKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.KEY_VALUE_PAIR__KEY, oldKey, key));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.KEY_VALUE_PAIR__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getValueType() {
        return valueType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setValueType(int newValueType) {
        int oldValueType = valueType;
        valueType = newValueType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.KEY_VALUE_PAIR__VALUE_TYPE, oldValueType, valueType));
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
            case Neuro4jPackage.KEY_VALUE_PAIR__KEY:
                return getKey();
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE:
                return getValue();
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE_TYPE:
                return getValueType();
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
            case Neuro4jPackage.KEY_VALUE_PAIR__KEY:
                setKey((String) newValue);
                return;
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE:
                setValue((String) newValue);
                return;
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE_TYPE:
                setValueType((Integer) newValue);
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
            case Neuro4jPackage.KEY_VALUE_PAIR__KEY:
                setKey(KEY_EDEFAULT);
                return;
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE_TYPE:
                setValueType(VALUE_TYPE_EDEFAULT);
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
            case Neuro4jPackage.KEY_VALUE_PAIR__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case Neuro4jPackage.KEY_VALUE_PAIR__VALUE_TYPE:
                return valueType != VALUE_TYPE_EDEFAULT;
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
        result.append(" (Key: ");
        result.append(key);
        result.append(", Value: ");
        result.append(value);
        result.append(", ValueType: ");
        result.append(valueType);
        result.append(')');
        return result.toString();
    }

    public String getId() {
        return id;
    }

} // KeyValuePairImpl
