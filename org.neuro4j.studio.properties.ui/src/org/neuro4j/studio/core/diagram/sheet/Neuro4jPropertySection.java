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
package org.neuro4j.studio.core.diagram.sheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.emf.ui.properties.sections.UndoableModelPropertySheetEntry;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.neuro4j.studio.properties.sources.providers.Nuero4jPropertySourceProvider;

/**
 * @generated
 */
public class Neuro4jPropertySection extends AbstractModelerPropertySection implements
        IPropertySourceProvider {

    Map<AdapterFactory, Nuero4jPropertySourceProvider> map = new HashMap<AdapterFactory, Nuero4jPropertySourceProvider>();
    /**
     * the property sheet page for this section
     */
    protected PropertySheetPage page;

    /**
     * @generated NOT
     */
    public IPropertySource getPropertySource(Object object) {
        if (object instanceof IPropertySource) {
            return (IPropertySource) object;
        }
        AdapterFactory af = getAdapterFactory(object);
        if (af != null) {
            IItemPropertySource ips = (IItemPropertySource) af.adapt(object,
                    IItemPropertySource.class);
            if (ips != null) {
                Nuero4jPropertySourceProvider provider = map.get(af);
                if (null == provider) {
                    provider = new Nuero4jPropertySourceProvider(af);
                    map.put(af, provider);
                }

                return provider.getPropertySource(object);
            }
        }
        if (object instanceof IAdaptable) {
            return (IPropertySource) ((IAdaptable) object)
                    .getAdapter(IPropertySource.class);
        }
        return null;
    }

    /**
     * @generated
     */
    protected IPropertySourceProvider getPropertySourceProvider() {
        return this;
    }

    /**
     * Modify/unwrap selection.
     * 
     * @generated
     */
    protected Object transformSelection(Object selected) {

        if (selected instanceof EditPart) {
            Object model = ((EditPart) selected).getModel();
            return model instanceof View ? ((View) model).getElement() : null;
        }
        if (selected instanceof View) {
            return ((View) selected).getElement();
        }
        if (selected instanceof IAdaptable) {
            View view = (View) ((IAdaptable) selected).getAdapter(View.class);
            if (view != null) {
                return view.getElement();
            }
        }
        return selected;
    }

    /**
     * @generated
     */
    public void setInput(IWorkbenchPart part, ISelection selection) {
        if (selection.isEmpty()
                || false == selection instanceof StructuredSelection) {
            super.setInput(part, selection);
            return;
        }
        final StructuredSelection structuredSelection = ((StructuredSelection) selection);
        ArrayList transformedSelection = new ArrayList(
                structuredSelection.size());
        for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
            Object r = transformSelection(it.next());
            if (r != null) {
                transformedSelection.add(r);
            }
        }
        // super.setInput(part, new StructuredSelection(transformedSelection));
        selection = new StructuredSelection(transformedSelection);
        IEditingDomainProvider provider = (IEditingDomainProvider) part
                .getAdapter(IEditingDomainProvider.class);
        if (provider != null) {
            EditingDomain theEditingDomain = provider.getEditingDomain();
            if (theEditingDomain instanceof TransactionalEditingDomain) {
                setEditingDomain((TransactionalEditingDomain) theEditingDomain);
            }
        }

        // Set the eObject for the section, too. The workbench part may not
        // adapt to IEditingDomainProvider, in which case the selected EObject
        // will be used to derive the editing domain.
        if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
            Object firstElement = ((IStructuredSelection) selection)
                    .getFirstElement();

            if (firstElement != null) {
                EObject adapted = unwrap(firstElement);

                if (adapted != null) {
                    setEObject(adapted);
                }
            }
        }

        page.selectionChanged(part, selection);
    }

    /**
     * @generated
     */
    protected AdapterFactory getAdapterFactory(Object object) {
        if (getEditingDomain() instanceof AdapterFactoryEditingDomain) {
            return ((AdapterFactoryEditingDomain) getEditingDomain())
                    .getAdapterFactory();
        }
        TransactionalEditingDomain editingDomain = TransactionUtil
                .getEditingDomain(object);
        if (editingDomain != null) {
            return ((AdapterFactoryEditingDomain) editingDomain)
                    .getAdapterFactory();
        }
        return null;
    }

    @Override
    public void createControls(final Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
    {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data = null;

        String tableLabelStr = getTableLabel();
        CLabel tableLabel = null;
        if (tableLabelStr != null && tableLabelStr.length() > 0)
        {
            tableLabel = getWidgetFactory().createCLabel(composite, tableLabelStr);
            data = new FormData();
            data.left = new FormAttachment(0, 0);
            data.top = new FormAttachment(0, 0);
            tableLabel.setLayoutData(data);
        }

        // //////////////////////////////////////////////////////////////////////
        // Use VadPropertySheetPage to provide custom properties behavior
        page = new FlowPropertySheetPage();

        // Use VadPropertySheetEntry to provide custom properties behavior
        UndoableModelPropertySheetEntry root = new FlowPropertySheetEntry(OperationHistoryFactory.getOperationHistory());
        // //////////////////////////////////////////////////////////////////////

        root.setPropertySourceProvider(getPropertySourceProvider());
        page.setRootEntry(root);

        page.createControl(composite);
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        if (tableLabel == null)
        {
            data.top = new FormAttachment(0, 0);
        }
        else
        {
            data.top = new FormAttachment(tableLabel, 0, SWT.BOTTOM);
        }
        data.bottom = new FormAttachment(100, 0);
        data.height = 100;
        data.width = 100;
        page.getControl().setLayoutData(data);

        setActionBars(aTabbedPropertySheetPage.getSite().getActionBars());

    }

    /**
     * Sets and prepares the actionBars for this section
     * 
     * @param actionBars
     *        the action bars for this page
     * @see org.eclipse.gmf.runtime.common.ui.properties.TabbedPropertySheetPage#setActionBars(org.eclipse.ui.IActionBars)
     */
    public void setActionBars(IActionBars actionBars) {
        if (actionBars != null) {
            actionBars.getMenuManager().removeAll();
            actionBars.getToolBarManager().removeAll();
            actionBars.getStatusLineManager().removeAll();

            page.makeContributions(actionBars.getMenuManager(), actionBars
                    .getToolBarManager(), actionBars.getStatusLineManager());

            actionBars.getToolBarManager().update(true);
        }

    }

    // /**
    // * Returns the PropertySource provider. The default implementation returns
    // * static adapter factory for the properties services. If the extending
    // * class needs to use a different provider then this method has to be
    // * overwriten.
    // *
    // * @return The PropertySource provider
    // */
    // protected IPropertySourceProvider getPropertySourceProvider() {
    // return propertiesProvider;
    // }

    /**
     * Returns the label for the table. The default implementation returns null,
     * that is, there is no label.
     * 
     * @return The label for the table
     */
    protected String getTableLabel() {
        return null;
    }

    // /* (non-Javadoc)
    // * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
    // org.eclipse.jface.viewers.ISelection)
    // */
    // public void setInput(IWorkbenchPart part, ISelection selection) {
    // IEditingDomainProvider provider = (IEditingDomainProvider) part
    // .getAdapter(IEditingDomainProvider.class);
    // if (provider != null) {
    // EditingDomain theEditingDomain = provider.getEditingDomain();
    // if (theEditingDomain instanceof TransactionalEditingDomain) {
    // setEditingDomain((TransactionalEditingDomain) theEditingDomain);
    // }
    // }
    //
    // // Set the eObject for the section, too. The workbench part may not
    // // adapt to IEditingDomainProvider, in which case the selected EObject
    // // will be used to derive the editing domain.
    // if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
    // Object firstElement = ((IStructuredSelection) selection)
    // .getFirstElement();
    //
    // if (firstElement != null) {
    // EObject adapted = unwrap(firstElement);
    //
    // if (adapted != null) {
    // setEObject(adapted);
    // }
    // }
    // }
    //
    // page.selectionChanged(part, selection);
    // }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
     */
    public void dispose() {
        super.dispose();

        if (page != null) {
            page.dispose();
            page = null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    public void refresh() {

        page.refresh();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.properties.tabbed.ISection#shouldUseExtraSpace()
     */
    public boolean shouldUseExtraSpace() {
        return true;
    }

    /**
     * Update if nessesary, upon receiving the model event.
     * 
     * @see #aboutToBeShown()
     * @see #aboutToBeHidden()
     * @param notification
     *        -
     *        even notification
     * @param element
     *        -
     *        element that has changed
     */
    public void update(final Notification notification, EObject element) {
        if (!isDisposed()) {
            postUpdateRequest(new Runnable() {

                public void run() {
                    if (!isDisposed() && !isNotifierDeleted(notification))
                        refresh();
                }
            });
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.core.edit.IDemuxedMListener#getFilter()
     */
    public NotificationFilter getFilter() {
        return NotificationFilter.createEventTypeFilter(Notification.SET).or(
                NotificationFilter.createEventTypeFilter(Notification.UNSET)).or(
                NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
                NotificationFilter.createEventTypeFilter(Notification.ADD_MANY))
                .or(NotificationFilter.createEventTypeFilter(Notification.REMOVE))
                .or(
                        NotificationFilter
                                .createEventTypeFilter(Notification.REMOVE_MANY)).and(
                        NotificationFilter.createNotifierTypeFilter(EObject.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#addToEObjectList(java.lang
     * .Object)
     */
    protected boolean addToEObjectList(Object object) {
        /* not implemented */
        return true;
    }

}
