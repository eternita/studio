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
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.impl.OperatorOutputImpl;
import org.neuro4j.studio.core.relation.ActionNodeRelationProcessorFactory;
import org.neuro4j.studio.core.relation.ActionRelationProcessor;

/**
 * This is the item provider adapter for a {@link org.neuro4j.studio.core.OperatorOutput} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class OperatorOutputItemProvider
        extends NodeItemProvider
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
     * @generated NOT
     */
    public OperatorOutputItemProvider(AdapterFactory adapterFactory) {
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

            // addSourcePropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            // addTargetPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Source feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSourcePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_OperatorOutput_source_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_OperatorOutput_source_feature", "_UI_OperatorOutput_type"),
                        Neuro4jPackage.Literals.OPERATOR_OUTPUT__SOURCE,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_OperatorOutput_name_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_OperatorOutput_name_feature", "_UI_OperatorOutput_type"),
                        Neuro4jPackage.Literals.OPERATOR_OUTPUT__NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Target feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTargetPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_OperatorOutput_target_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_OperatorOutput_target_feature", "_UI_OperatorOutput_type"),
                        Neuro4jPackage.Literals.OPERATOR_OUTPUT__TARGET,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This returns OperatorOutput.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/OperatorOutput.png"));
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
        String label = ((OperatorOutput) object).getName();
        return label == null || label.length() == 0 ?
                getString("_UI_OperatorOutput_type") :
                getString("_UI_OperatorOutput_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        if (notification.getNewStringValue() != null && notification.getOldStringValue() != null && notification.getNewStringValue().equals(notification.getOldStringValue()))
        {
            return;
        }
        switch (notification.getFeatureID(OperatorOutput.class)) {
            case Neuro4jPackage.OPERATOR_OUTPUT__NAME:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                updateSourceTarget(notification);
                return;
        }
        // remove link
        if (notification.getNewValue() == null)
        {
            updateSourceTarget(notification);
        }
        super.notifyChanged(notification);
    }

    private void updateSourceTarget(Notification notification)
    {
        OperatorOutputImpl output = (OperatorOutputImpl) notification.getNotifier();

        ActionNode source = (ActionNode) output.eContainer();
        ActionRelationProcessor actionRelationProcessor = ActionNodeRelationProcessorFactory.getInstance().createProcessor(source);
        if (actionRelationProcessor != null)
        {
            actionRelationProcessor.updateOutpuNode(source, output.getTarget(), output, notification.getOldStringValue(), notification.getNewStringValue());

        }
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

    public Object getEditableValue(Object object)
    {
        return super.getEditableValue(object);
    }
}
