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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;

/**
 * This is the item provider adapter for a {@link org.neuro4j.studio.core.Network} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class NetworkItemProvider
        extends ItemProviderAdapter
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
    public NetworkItemProvider(AdapterFactory adapterFactory) {
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

            addTitlePropertyDescriptor(object);
            addVisibilityPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Title feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTitlePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_Network_title_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Network_title_feature", "_UI_Network_type"),
                        Neuro4jPackage.Literals.NETWORK__TITLE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Visibility feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addVisibilityPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
                (createItemPropertyDescriptor
                (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_Network_visibility_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Network_visibility_feature", "_UI_Network_type"),
                        Neuro4jPackage.Literals.NETWORK__VISIBILITY,
                        true,
                        false,
                        true,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(Neuro4jPackage.Literals.NETWORK__ROOT_ACTION);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns Network.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Network"));
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
        String label = ((Network) object).getTitle();
        return label == null || label.length() == 0 ?
                getString("_UI_Network_type") :
                getString("_UI_Network_type") + " " + label;
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

        switch (notification.getFeatureID(Network.class)) {
            case Neuro4jPackage.NETWORK__TITLE:
            case Neuro4jPackage.NETWORK__VISIBILITY:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case Neuro4jPackage.NETWORK__ROOT_ACTION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createActionNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createJoinNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createDecisionNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createLoopNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createCallNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createStartNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createEndNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createMapperNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createFollowByRelationNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createLogicNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createOperatorOutput()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createOperatorInput()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createViewNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createNoteNode()));

        newChildDescriptors.add
                (createChildParameter
                (Neuro4jPackage.Literals.NETWORK__ROOT_ACTION,
                        Neuro4jFactory.eINSTANCE.createStandardNode()));
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return Neuro4jEditPlugin.INSTANCE;
    }

}
