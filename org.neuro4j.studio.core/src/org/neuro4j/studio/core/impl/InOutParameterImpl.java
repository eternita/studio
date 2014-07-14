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
import org.neuro4j.studio.core.InOutParameter;
import org.neuro4j.studio.core.Neuro4jPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Out Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#getClassName <em>Class Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#isOptional <em>Optional</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.InOutParameterImpl#getParamType <em>Param Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InOutParameterImpl extends EObjectImpl implements InOutParameter {
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
     * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isOptional()
     * @generated
     * @ordered
     */
    protected static final boolean OPTIONAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isOptional()
     * @generated
     * @ordered
     */
    protected boolean optional = OPTIONAL_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

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
     * The default value of the '{@link #getParamType() <em>Param Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getParamType()
     * @generated
     * @ordered
     */
    protected static final int PARAM_TYPE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getParamType() <em>Param Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getParamType()
     * @generated
     * @ordered
     */
    protected int paramType = PARAM_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InOutParameterImpl() {
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
        return Neuro4jPackage.Literals.IN_OUT_PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__CLASS_NAME, oldClassName, className));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOptional(boolean newOptional) {
        boolean oldOptional = optional;
        optional = newOptional;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__OPTIONAL, oldOptional, optional));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__DESCRIPTION, oldDescription, description));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getParamType() {
        return paramType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParamType(int newParamType) {
        int oldParamType = paramType;
        paramType = newParamType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.IN_OUT_PARAMETER__PARAM_TYPE, oldParamType, paramType));
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
            case Neuro4jPackage.IN_OUT_PARAMETER__NAME:
                return getName();
            case Neuro4jPackage.IN_OUT_PARAMETER__CLASS_NAME:
                return getClassName();
            case Neuro4jPackage.IN_OUT_PARAMETER__OPTIONAL:
                return isOptional();
            case Neuro4jPackage.IN_OUT_PARAMETER__DESCRIPTION:
                return getDescription();
            case Neuro4jPackage.IN_OUT_PARAMETER__VALUE:
                return getValue();
            case Neuro4jPackage.IN_OUT_PARAMETER__PARAM_TYPE:
                return getParamType();
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
            case Neuro4jPackage.IN_OUT_PARAMETER__NAME:
                setName((String) newValue);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__CLASS_NAME:
                setClassName((String) newValue);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__OPTIONAL:
                setOptional((Boolean) newValue);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__VALUE:
                setValue((String) newValue);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__PARAM_TYPE:
                setParamType((Integer) newValue);
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
            case Neuro4jPackage.IN_OUT_PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__CLASS_NAME:
                setClassName(CLASS_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__OPTIONAL:
                setOptional(OPTIONAL_EDEFAULT);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case Neuro4jPackage.IN_OUT_PARAMETER__PARAM_TYPE:
                setParamType(PARAM_TYPE_EDEFAULT);
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
            case Neuro4jPackage.IN_OUT_PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Neuro4jPackage.IN_OUT_PARAMETER__CLASS_NAME:
                return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
            case Neuro4jPackage.IN_OUT_PARAMETER__OPTIONAL:
                return optional != OPTIONAL_EDEFAULT;
            case Neuro4jPackage.IN_OUT_PARAMETER__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case Neuro4jPackage.IN_OUT_PARAMETER__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case Neuro4jPackage.IN_OUT_PARAMETER__PARAM_TYPE:
                return paramType != PARAM_TYPE_EDEFAULT;
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
        result.append(", className: ");
        result.append(className);
        result.append(", optional: ");
        result.append(optional);
        result.append(", description: ");
        result.append(description);
        result.append(", value: ");
        result.append(value);
        result.append(", paramType: ");
        result.append(paramType);
        result.append(')');
        return result.toString();
    }

    @Override
    public boolean isValid() {
        if (getName() != null)
        {
            return true;
        }
        return false;
    }

} // InOutParameterImpl
