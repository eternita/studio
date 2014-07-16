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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.graphics.Color;
import org.neuro4j.workflow.node.WorkflowNode;
import org.neuro4j.studio.core.KeyValuePair;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.util.UUIDMgr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class StandardNodeImpl extends JoinNodeImpl implements StandardNode {

    private static String NAME_EDEFAULT = "Entity";

    private static String NAME_RELATION_EDEFAULT = "Relation";

    // private List<KeyValuePair> properties = null;
    // private List<Connected> connections = null;
    // private List<Representation> representation = null;

    private int type = 0;

    // private Entity entity = new Entity();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StandardNodeImpl() {
        super();
        id = UUIDMgr.getInstance().createUUIDString();
    }

    @Override
    public void getNodeSpecificProperties(WorkflowNode entity)
    {

        String r_type = entity.getParameter("r_type");
        if (r_type != null && r_type.equals("circle"))
        {
            type = 1;
        }

    }

    // public List<Connected> getConnections()
    // {
    // if (connections == null)
    // {
    // connections = new ArrayList<Connected>(5);
    // }
    //
    //
    // return connections;
    // }
    //
    // public List<KeyValuePair> getProperties()
    // {
    // if (properties == null)
    // {
    // properties = new ArrayList<KeyValuePair>(3);
    // }
    //
    //
    // return properties;
    // }

    public int getType()
    {
        return type;
    }

    public boolean isCircleRelation()
    {
        return type == 1;
    }

    @Override
    public void setType(int type) {
        this.type = type;

    }

    @Override
    public String getDefaultName() {
        if (getType() == 0)
        {
            return NAME_EDEFAULT;
        } else {
            return NAME_RELATION_EDEFAULT;
        }

    }

    public void notifyPropertyChanged(Object oldValue, Object newValue) {
        // during update properties it call it to update ui
        eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.ACTION_NODE__NAME, oldValue, newValue));
        update();
    }

    @Override
    public void setNodeSpecificProperties(WorkflowNode entity) {
        // super.setNodeSpecificProperties(entity);
        // if (properties != null)
        // {
        // for(KeyValuePair para: properties)
        // {
        // entity.setProperty(para.getKey(), para.getValue());
        // }
        // }

    }

    @Override
    public void addProperty(String key, String value)
    {

        KeyValuePair para = new KeyValuePairImpl();
        para.setKey(key);
        para.setValue(value);

        getProperties().add(para);
    }

    @Override
    public void addConnection(WorkflowNode rel) {
        // KeyValuePair para = new KeyValuePairImpl();
        // para.setKey(id);
        // para.setValue(name);

        // getConnections().add(rel);

    }

    @Override
    public boolean isUpdated() {
        return updated;
    }

    @Override
    public List getRepresentations() {
        // if (representation == null)
        // {
        // representation = new LinkedList<Representation>();
        // }
        // return representation;
        return null;
    }

    @Override
    public void setBGColor(Color lightgray) {

        System.out.println();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    // @Override
    // protected EClass eStaticClass() {
    // return Neuro4jPackage.Literals.STANDARD_NODE;
    // }

} // StandardNodeImpl
