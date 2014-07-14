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
package org.neuro4j.studio.debug.ui.views;

import org.eclipse.debug.internal.ui.views.launch.LaunchView;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * Fake part to used to create the breadcrumb page.
 * 
 * @since 3.5
 * @see LaunchView#fDefaultPageRec
 */
class BreadcrumbWorkbenchPart implements IWorkbenchPart {

    private IWorkbenchPartSite fSite = null;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        return (obj instanceof BreadcrumbWorkbenchPart);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return getClass().hashCode();
    }

    /**
     * Constructs a part for the given console that binds to the given
     * site
     */
    public BreadcrumbWorkbenchPart(IWorkbenchPartSite site) {
        fSite = site;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#addPropertyListener(org.eclipse.ui.IPropertyListener)
     */
    public void addPropertyListener(IPropertyListener listener) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    public void createPartControl(Composite parent) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#dispose()
     */
    public void dispose() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#getSite()
     */
    public IWorkbenchPartSite getSite() {
        return fSite;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#getTitle()
     */
    public String getTitle() {
        return ""; //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#getTitleImage()
     */
    public Image getTitleImage() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#getTitleToolTip()
     */
    public String getTitleToolTip() {
        return ""; //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#removePropertyListener(org.eclipse.ui.IPropertyListener)
     */
    public void removePropertyListener(IPropertyListener listener) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPart#setFocus()
     */
    public void setFocus() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class adapter) {
        return null;
    }
}
