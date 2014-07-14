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
package org.neuro4j.studio.debug.ui.views.breakpoints;

import org.eclipse.debug.internal.ui.DebugPluginImages;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.views.variables.VariablesViewMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.PlatformUI;

/**
 * Action to toggle the use of contributed variables content providers on and off.
 * When on, all registered variables content providers for the current debug model
 * are used. When off, the default content provider (that shows all children)
 * is used for all debug models.
 */
public class ToggleLogicalStructureAction extends Action {

    private VariablesView fView;

    public ToggleLogicalStructureAction(VariablesView view) {
        super(null, IAction.AS_CHECK_BOX);
        setView(view);
        setToolTipText(VariablesViewMessages.ToggleObjectBrowsersAction_1);
        setHoverImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_LCL_SHOW_LOGICAL_STRUCTURE));
        setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_DLCL_SHOW_LOGICAL_STRUCTURE));
        setImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_ELCL_SHOW_LOGICAL_STRUCTURE));
        setId(DebugUIPlugin.getUniqueIdentifier() + ".ToggleObjectBrowsersAction"); //$NON-NLS-1$
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.VARIABLES_CONTENT_PROVIDERS_ACTION);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run() {
        if (!getView().isAvailable()) {
            return;
        }
        getView().setShowLogicalStructure(isChecked());
        BusyIndicator.showWhile(getView().getViewer().getControl().getDisplay(), new Runnable() {
            public void run() {
                getView().getViewer().refresh();
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#setChecked(boolean)
     */
    public void setChecked(boolean value) {
        super.setChecked(value);
    }

    protected VariablesView getView() {
        return fView;
    }

    protected void setView(VariablesView view) {
        fView = view;
    }

}
