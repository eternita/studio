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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.swt.graphics.Color;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.OperatorOutputImpl#getSource <em>Source</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.OperatorOutputImpl#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.OperatorOutputImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperatorOutputImpl extends NodeImpl implements OperatorOutput {

    List<KeyValuePair> properties = new ArrayList<KeyValuePair>();

    private Edge edge;

    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected ActionNode source;
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
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected ActionNode target;
    
    protected Routing routing;

    private List<RelativeBendpoint> coordinates = new ArrayList<RelativeBendpoint>();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected OperatorOutputImpl() {
        super();
        setId(UUIDMgr.getInstance().createUUIDString());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Neuro4jPackage.Literals.OPERATOR_OUTPUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode getSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSource(ActionNode newSource, NotificationChain msgs) {
        ActionNode oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_OUTPUT__SOURCE, oldSource, newSource);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSource(ActionNode newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject) source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Neuro4jPackage.OPERATOR_OUTPUT__SOURCE, null, msgs);
            if (newSource != null)
                msgs = ((InternalEObject) newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Neuro4jPackage.OPERATOR_OUTPUT__SOURCE, null, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_OUTPUT__SOURCE, newSource, newSource));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_OUTPUT__NAME, oldName, name));
    }

    public void setNameWithoutNotification(String newName) {
        name = newName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject) target;
            target = (ActionNode) eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Neuro4jPackage.OPERATOR_OUTPUT__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ActionNode basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTarget(ActionNode newTarget) {
        ActionNode oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.OPERATOR_OUTPUT__TARGET, oldTarget, target));
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
            case Neuro4jPackage.OPERATOR_OUTPUT__SOURCE:
                return basicSetSource(null, msgs);
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
            case Neuro4jPackage.OPERATOR_OUTPUT__SOURCE:
                return getSource();
            case Neuro4jPackage.OPERATOR_OUTPUT__NAME:
                return getName();
            case Neuro4jPackage.OPERATOR_OUTPUT__TARGET:
                if (resolve)
                    return getTarget();
                return basicGetTarget();
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
            case Neuro4jPackage.OPERATOR_OUTPUT__SOURCE:
                setSource((ActionNode) newValue);
                return;
            case Neuro4jPackage.OPERATOR_OUTPUT__NAME:
                setName((String) newValue);
                return;
            case Neuro4jPackage.OPERATOR_OUTPUT__TARGET:
                setTarget((ActionNode) newValue);
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
            case Neuro4jPackage.OPERATOR_OUTPUT__SOURCE:
                setSource((ActionNode) null);
                return;
            case Neuro4jPackage.OPERATOR_OUTPUT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Neuro4jPackage.OPERATOR_OUTPUT__TARGET:
                setTarget((ActionNode) null);
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
            case Neuro4jPackage.OPERATOR_OUTPUT__SOURCE:
                return source != null;
            case Neuro4jPackage.OPERATOR_OUTPUT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Neuro4jPackage.OPERATOR_OUTPUT__TARGET:
                return target != null;
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
        result.append(')');
        return result.toString();
    }

    @Override
    public void setEdge(Edge edge) {
        this.edge = edge;

    }

    @Override
    public Edge getEdge() {
        // TODO Auto-generated method stub
        return edge;
    }

    @Override
    public List<RelativeBendpoint> getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void setCoordinates(List<RelativeBendpoint> coordinates) {
        this.coordinates = coordinates;
    }

    public List<KeyValuePair> getProperties()
    {
        return properties;
    }

    public void addProperty(String key, String value)
    {
        KeyValuePair kvp = Neuro4jFactory.eINSTANCE.createKeyValuePair();
        kvp.setKey(key);
        kvp.setValue(value);
        properties.add(kvp);
    }

    public void notifyPropertyChanged(Object oldValue, Object newValue) {
        // during update properties it call it to update ui
        eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.NODE__ID, oldValue, newValue));
        update();
    }

    public void setBGColor(Color red) {
        ConnectorImpl connector = (ConnectorImpl) getEdge();
        connector.setLineColor(FigureUtilities.RGBToInteger(red.getRGB()).intValue());
    }

    @Override
    public OperatorOutput cloneForPast(ActionNode target) {
        OperatorOutputImpl out = new OperatorOutputImpl();
        out.setId(UUIDMgr.getInstance().createUUIDString());
        out.setNameWithoutNotification(this.getName());
        out.setTarget(target);

        return out;
    }

    public void setContainer(InternalEObject sourceObj) {
        eContainer = sourceObj;

    }

    @Override
    public Routing getRouting() {
        return routing;
    }

    @Override
    public void setRouting(Routing routing) {
        this.routing = routing;
    }
    
    

} // OperatorOutputImpl
