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
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.workflow.enums.DecisionOperators;

/**
 * This is the item provider adapter for a {@link org.neuro4j.studio.core.DecisionNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DecisionNodeItemProvider
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
    public DecisionNodeItemProvider(AdapterFactory adapterFactory) {
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

            // addMainTrueOutputPropertyDescriptor(object);
            // addMainFalseOutputPropertyDescriptor(object);
            // addMainInputPropertyDescriptor(object);
            addOperatorPropertyDescriptor(object);
            addDecisionKeyPropertyDescriptor(object);

            addCompTypePropertyDescriptor(object);
            addCompKeyPropertyDescriptor(object);

        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Main True Output feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMainTrueOutputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_mainTrueOutput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_mainTrueOutput_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__MAIN_TRUE_OUTPUT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Main False Output feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMainFalseOutputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_mainFalseOutput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_mainFalseOutput_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__MAIN_FALSE_OUTPUT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Main Input feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMainInputPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_mainInput_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_mainInput_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__MAIN_INPUT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Operator feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOperatorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_operator_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_operator_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__OPERATOR,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Comp Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCompTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_compType_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_compType_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__COMP_TYPE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Comp Key feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCompKeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_compKey_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_compKey_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__COMP_KEY,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Decision Key feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDecisionKeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_DecisionNode_decisionKey_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_DecisionNode_decisionKey_feature", "_UI_DecisionNode_type"),
                        Neuro4jPackage.Literals.DECISION_NODE__DECISION_KEY,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This returns DecisionNode.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DecisionNode.png"));
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
        String label = ((DecisionNode) object).getName();
        return label == null || label.length() == 0 ?
                getString("_UI_DecisionNode_type") :
                getString("_UI_DecisionNode_type") + " " + label;
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

        switch (notification.getFeatureID(DecisionNode.class)) {
            case Neuro4jPackage.DECISION_NODE__OPERATOR:
                hideShowDecisionProperty(notification);
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case Neuro4jPackage.DECISION_NODE__COMP_TYPE:
            case Neuro4jPackage.DECISION_NODE__COMP_KEY:
            case Neuro4jPackage.DECISION_NODE__DECISION_KEY:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    private void hideShowDecisionProperty(Notification notification)
    {
        DecisionOperators doperator = DecisionOperators.valueOf(notification.getNewStringValue());
        if (doperator == null)
        {
            return;
        }
        if (doperator.isSingleOperand() && itemPropertyDescriptors.size() == 6)
        {
            itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
            itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
        } else if (!doperator.isSingleOperand() && itemPropertyDescriptors.size() == 4) {
            addCompTypePropertyDescriptor(this);
            addCompKeyPropertyDescriptor(this);
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

    @Override
    public IItemPropertyDescriptor getPropertyDescriptor(Object object,
            Object propertyId) {
        return super.getPropertyDescriptor(object, propertyId);
    }

}
