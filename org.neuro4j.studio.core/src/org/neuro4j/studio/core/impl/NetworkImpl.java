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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.NetworkTypesEnum;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.Node;
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.StartNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.NetworkImpl#getRootAction <em>Root Action</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.NetworkImpl#getTitle <em>Title</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.NetworkImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NetworkImpl extends EObjectImpl implements Network {

    IResource resource = null;

    NetworkTypesEnum type = null;
    private Properties prop = null;
    Map<String, Integer> nodeCount = new HashMap<String, Integer>(8);
    List<NoteNode> notes = new ArrayList<NoteNode>();
    // private Storage storage;

    Set<String> startNodeNames = new HashSet<String>();
    /**
     * The cached value of the '{@link #getRootAction() <em>Root Action</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRootAction()
     * @generated
     * @ordered
     */
    protected EList<Node> rootAction;

    /**
     * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected static final String TITLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected String title = TITLE_EDEFAULT;

    /**
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected static final String VISIBILITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected String visibility = VISIBILITY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NetworkImpl() {
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
        return Neuro4jPackage.Literals.NETWORK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Node> getRootAction() {
        if (rootAction == null) {
            rootAction = new EObjectContainmentEList<Node>(Node.class, this, Neuro4jPackage.NETWORK__ROOT_ACTION);
        }
        return rootAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTitle(String newTitle) {
        String oldTitle = title;
        title = newTitle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.NETWORK__TITLE, oldTitle, title));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVisibility(String newVisibility) {
        String oldVisibility = visibility;
        visibility = newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.NETWORK__VISIBILITY, oldVisibility, visibility));
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
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                return ((InternalEList<?>) getRootAction()).basicRemove(otherEnd, msgs);
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
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                return getRootAction();
            case Neuro4jPackage.NETWORK__TITLE:
                return getTitle();
            case Neuro4jPackage.NETWORK__VISIBILITY:
                return getVisibility();
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
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                getRootAction().clear();
                getRootAction().addAll((Collection<? extends Node>) newValue);
                return;
            case Neuro4jPackage.NETWORK__TITLE:
                setTitle((String) newValue);
                return;
            case Neuro4jPackage.NETWORK__VISIBILITY:
                setVisibility((String) newValue);
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
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                getRootAction().clear();
                return;
            case Neuro4jPackage.NETWORK__TITLE:
                setTitle(TITLE_EDEFAULT);
                return;
            case Neuro4jPackage.NETWORK__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
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
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                return rootAction != null && !rootAction.isEmpty();
            case Neuro4jPackage.NETWORK__TITLE:
                return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
            case Neuro4jPackage.NETWORK__VISIBILITY:
                return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
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
        result.append(" (title: ");
        result.append(title);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(')');
        return result.toString();
    }

    @Override
    public int getNodeCount(ActionNode node)
    {
        if (nodeCount.containsKey(node.getDefaultName()))
        {
            return nodeCount.get(node.getDefaultName());
        }
        return 0;
    }

    public void addNode(ActionNode node)
    {
        node.setNetwork(this);

        if (node.getName() != null && !node.getName().startsWith(node.getDefaultName()))
        {
            // if it already has name...
        } else {

            node.setName(getNextDefaultName(node));
        }

        processNodeCount(node);
        getRootAction().add(node);

    }

    private String getNextDefaultName(ActionNode newElement)
    {
        int count = getNodeCount(newElement) + 1;
        return newElement.getDefaultName(count);
    }

    @Override
    public void processNodeCount(ActionNode node) {

        if (nodeCount.containsKey(node.getDefaultName()))
        {
            Integer count = nodeCount.get(node.getDefaultName());
            nodeCount.put(node.getDefaultName(), ++count);

        } else {
            nodeCount.put(node.getDefaultName(), 1);
        }

    }

    @Override
    public void addNote(NoteNode node) {
        notes.add(node);

    }

    @Override
    public List<NoteNode> getNotes() {
        return notes;
    }

    @Override
    public boolean isValidStartNodeName(String name, Node currentStartNode) {
        if (name == null || "".equalsIgnoreCase(name.trim()))
        {
            return false;
        }
        List<Node> nodes = getRootAction();
        for (Node node : nodes)
        {
            if (node instanceof StartNode && !node.equals(currentStartNode))
            {
                if (((StartNode) node).getName().equals(name)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public NetworkTypesEnum getType() {
        return type;
    }

    @Override
    public void setType(NetworkTypesEnum type) {
        this.type = type;

    }

    @Override
    public Properties getConfig() {
        return prop;
    }

    @Override
    public void setConfig(Properties prop) {
        this.prop = prop;
    }

    // @Override
    // public Storage getStorage() {
    // return storage;
    // }
    //
    // @Override
    // public void setStorage(Storage storage) {
    // this.storage = storage;
    //
    // }

    @Override
    public IResource getResource() {
        return resource;
    }

    @Override
    public void setResource(IResource resource) {
        this.resource = resource;

    }

} // NetworkImpl
