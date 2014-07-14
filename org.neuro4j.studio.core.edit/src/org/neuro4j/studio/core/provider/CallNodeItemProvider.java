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
package org.neuro4j.studio.core.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.Neuro4jPackage;

/**
 * This is the item provider adapter for a {@link org.neuro4j.studio.core.CallNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class CallNodeItemProvider
        extends ActionNodeItemProvider
        implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public CallNodeItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addFlowNamePropertyDescriptor(object);
            addDynamicFlowNamePropertyDescriptor(object);
            addInputParametersPropertyDescriptor(object);
            addOutputParametersPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Flow Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addFlowNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_CallNode_flowName_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_CallNode_flowName_feature", "_UI_CallNode_type"),
                        Neuro4jPackage.Literals.CALL_NODE__FLOW_NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Dynamic Flow Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDynamicFlowNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_CallNode_dynamicFlowName_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_CallNode_dynamicFlowName_feature", "_UI_CallNode_type"),
                        Neuro4jPackage.Literals.CALL_NODE__DYNAMIC_FLOW_NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Input Parameters feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addInputParametersPropertyDescriptor(Object object) {
        // itemPropertyDescriptors.add
        // (createItemPropertyDescriptor
        // (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
        // getResourceLocator(),
        // getString("_UI_CallNode_inputParameters_feature"),
        // getString("_UI_PropertyDescriptor_description", "_UI_CallNode_inputParameters_feature", "_UI_CallNode_type"),
        // Neuro4jPackage.Literals.CALL_NODE__INPUT_PARAMETERS,
        // true,
        // false,
        // true,
        // null,
        // null,
        // null));
    }

    /**
     * This adds a property descriptor for the Output Parameters feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addOutputParametersPropertyDescriptor(Object object) {
        // itemPropertyDescriptors.add
        // (createItemPropertyDescriptor
        // (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
        // getResourceLocator(),
        // getString("_UI_CallNode_outputParameters_feature"),
        // getString("_UI_PropertyDescriptor_description", "_UI_CallNode_outputParameters_feature",
        // "_UI_CallNode_type"),
        // Neuro4jPackage.Literals.CALL_NODE__OUTPUT_PARAMETERS,
        // true,
        // false,
        // true,
        // null,
        // null,
        // null));
    }

    /**
     * This returns CallNode.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CallNode.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((CallNode) object).getName();
        return label == null || label.length() == 0 ?
                getString("_UI_CallNode_type") :
                getString("_UI_CallNode_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(CallNode.class)) {
            case Neuro4jPackage.CALL_NODE__FLOW_NAME:
            case Neuro4jPackage.CALL_NODE__DYNAMIC_FLOW_NAME:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
