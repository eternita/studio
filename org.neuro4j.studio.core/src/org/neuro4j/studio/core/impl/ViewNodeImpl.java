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
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.ViewNode;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.util.UUIDMgr;
import org.neuro4j.workflow.common.SWFParametersConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.impl.ViewNodeImpl#getViewName <em>View Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.impl.ViewNodeImpl#getDynamicViewName <em>Dynamic View Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ViewNodeImpl extends ActionNodeImpl implements ViewNode {

    protected static final String NAME_EDEFAULT = "ViewNode";

    /**
     * The default value of the '{@link #getViewName() <em>View Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getViewName()
     * @generated
     * @ordered
     */
    protected static final String VIEW_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getViewName() <em>View Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getViewName()
     * @generated
     * @ordered
     */
    protected String viewName = VIEW_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDynamicViewName() <em>Dynamic View Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDynamicViewName()
     * @generated
     * @ordered
     */
    protected static final String DYNAMIC_VIEW_NAME_EDEFAULT = null;

    protected static final String RENDER_TYPET_EDEFAULT = "jsp";

    /**
     * The cached value of the '{@link #getDynamicViewName() <em>Dynamic View Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDynamicViewName()
     * @generated
     * @ordered
     */
    protected String dynamicViewName = DYNAMIC_VIEW_NAME_EDEFAULT;

    protected String renderType = RENDER_TYPET_EDEFAULT;
    
    protected String renderImpl = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ViewNodeImpl() {
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
        return Neuro4jPackage.Literals.VIEW_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setViewName(String newViewName) {
        String oldViewName = viewName;
        viewName = newViewName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.VIEW_NODE__VIEW_NAME, oldViewName, viewName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDynamicViewName() {
        return dynamicViewName;
    }

    public String getRenderType() {
        return renderType;
    }
    
    
    
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDynamicViewName(String newDynamicViewName) {
        String oldDynamicViewName = dynamicViewName;
        dynamicViewName = newDynamicViewName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.VIEW_NODE__DYNAMIC_VIEW_NAME, oldDynamicViewName, dynamicViewName));
    }

    public void setRenderType(String newRenderType) {
        String oldrenderType = renderType;
        renderType = newRenderType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Neuro4jPackage.VIEW_NODE_RENDER_TYPET, oldrenderType, renderType));
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
            case Neuro4jPackage.VIEW_NODE__VIEW_NAME:
                return getViewName();
            case Neuro4jPackage.VIEW_NODE__DYNAMIC_VIEW_NAME:
                return getDynamicViewName();
            case Neuro4jPackage.VIEW_NODE_RENDER_TYPET:
                return getRenderType();
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
            case Neuro4jPackage.VIEW_NODE__VIEW_NAME:
                setViewName((String) newValue);
                return;
            case Neuro4jPackage.VIEW_NODE__DYNAMIC_VIEW_NAME:
                setDynamicViewName((String) newValue);
                return;
            case Neuro4jPackage.VIEW_NODE_RENDER_TYPET:
                setRenderType((String) newValue);
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
            case Neuro4jPackage.VIEW_NODE__VIEW_NAME:
                setViewName(VIEW_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.VIEW_NODE__DYNAMIC_VIEW_NAME:
                setDynamicViewName(DYNAMIC_VIEW_NAME_EDEFAULT);
                return;
            case Neuro4jPackage.VIEW_NODE_RENDER_TYPET:
                setRenderType(RENDER_TYPET_EDEFAULT);
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
            case Neuro4jPackage.VIEW_NODE__VIEW_NAME:
                return VIEW_NAME_EDEFAULT == null ? viewName != null : !VIEW_NAME_EDEFAULT.equals(viewName);
            case Neuro4jPackage.VIEW_NODE__DYNAMIC_VIEW_NAME:
                return DYNAMIC_VIEW_NAME_EDEFAULT == null ? dynamicViewName != null : !DYNAMIC_VIEW_NAME_EDEFAULT.equals(dynamicViewName);

            case Neuro4jPackage.VIEW_NODE_RENDER_TYPET:
                return RENDER_TYPET_EDEFAULT == null ? renderType != null : !RENDER_TYPET_EDEFAULT.equals(renderType);

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
        result.append(" (viewName: ");
        result.append(viewName);
        result.append(", dynamicViewName: ");
        result.append(dynamicViewName);
        result.append(')');
        result.append(", renderType: ");
        result.append(renderType);
        result.append(')');
        return result.toString();
    }

    @Override
    public String getDefaultName() {
        return NAME_EDEFAULT;
    }

    @Override
    public void setNodeSpecificProperties(NodeXML entity) {
        setNotNullConfig(entity, VIEW_TEMPLATE_NAME, getViewName());
        setNotNullProperty(entity, VIEW_TEMPLATE_DYNAMIC_NAME, getDynamicViewName(), true);
        setNotNullConfig(entity, VIEW_TEMPLATE_RENDER_TYPE, getRenderType());
    }

    @Override
    public void getNodeSpecificProperties(NodeXML entity) {
        setDynamicViewName(entity.getParameter(VIEW_TEMPLATE_DYNAMIC_NAME));
        setViewName(entity.getConfig(VIEW_TEMPLATE_NAME));
        setRenderType(entity.getConfig(VIEW_TEMPLATE_RENDER_TYPE));
    }

    public static final String VIEW_TEMPLATE_NAME = SWFParametersConstants.VIEW_NODE_TEMPLATE_NAME;

    public static final String VIEW_TEMPLATE_DYNAMIC_NAME = SWFParametersConstants.VIEW_NODE_TEMPLATE_DYNAMIC_NAME;

    public static final String VIEW_TEMPLATE_RENDER_TYPE = SWFParametersConstants.VIEW_NODE_RENDER_TYPE;
    
    		


    @Override
    public String getLogicImplementationClassName() {
        return IMPL_CLASS;
    }

    public static final String IMPL_CLASS = "org.neuro4j.workflow.node.ViewNode";

    @Override
    public ActionNode createPasteClone(Network net) {
        ViewNodeImpl node = new ViewNodeImpl();

        node.setId(UUIDMgr.getInstance().createUUIDString());
        node.setName(this.getName());
        node.setDynamicViewName(this.getDynamicViewName());
        node.setViewName(this.getViewName());
        node.setRenderType(this.getRenderType());
        node.setX(this.getX() + 100);
        node.setY(this.getY() + 100);

        return node;
    }
    
	@Override
	public NodeType getNodeType() {
		return NodeType.VIEW;
	}

	

} // ViewNodeImpl
