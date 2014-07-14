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
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.Neuro4jPackage;

/**
 * This is the item provider adapter for a {@link org.neuro4j.studio.core.LogicNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class LogicNodeItemProvider
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
    public LogicNodeItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addClassNamePropertyDescriptor(object);
            // addMainOutputPropertyDescriptor(object);
            // addErrorOutputPropertyDescriptor(object);
            // addHasErrorOutputPropertyDescriptor(object);
            addInParametersPropertyDescriptor(object);
            addOutParametersPropertyDescriptor(object);

        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Class Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addClassNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_className_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_className_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__CLASS_NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Main Output feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMainOutputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_mainOutput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_mainOutput_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__MAIN_OUTPUT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Error Output feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addErrorOutputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_errorOutput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_errorOutput_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__ERROR_OUTPUT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Has Error Output feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addHasErrorOutputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_hasErrorOutput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_hasErrorOutput_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__HAS_ERROR_OUTPUT,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the In Parameters feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addInParametersPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_inParameters_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_inParameters_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__IN_PARAMETERS,
                        false,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Out Parameters feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addOutParametersPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_LogicNode_outParameters_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_LogicNode_outParameters_feature", "_UI_LogicNode_type"),
                        Neuro4jPackage.Literals.LOGIC_NODE__OUT_PARAMETERS,
                        false,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This returns LogicNode.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/LogicNode.png"));
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
        String label = ((LogicNode) object).getName();
        return label == null || label.length() == 0 ?
                getString("_UI_LogicNode_type") :
                getString("_UI_LogicNode_type") + " " + label;
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

        switch (notification.getFeatureID(LogicNode.class)) {
            case Neuro4jPackage.LOGIC_NODE__CLASS_NAME:
            case Neuro4jPackage.LOGIC_NODE__HAS_ERROR_OUTPUT:
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
