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

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILogicalStructureType;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;

/**
 * Action to set the logical structure to display for a variable (enables/disables
 * logical structure types for the same variable).
 */
public class SelectLogicalStructureAction extends Action {

    private VariablesView fView;
    private ILogicalStructureType fType;
    private ILogicalStructureType[] fAvailableTypes;

    /**
     * 
     * @param view
     *        Variables view
     * @param type
     *        the type that this action will turn on/off
     * @param value
     *        the value for which logical structures are to be chosen
     * @param availableTypes
     *        the set of logical structure types that are being offered
     *        to the user in addition to the type controlled by this action
     */
    public SelectLogicalStructureAction(VariablesView view, ILogicalStructureType type, IValue value, ILogicalStructureType[] availableTypes) {
        super(type.getDescription(value), IAction.AS_CHECK_BOX);
        setView(view);
        fAvailableTypes = availableTypes;
        fType = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
        valueChanged();
    }

    private void valueChanged() {
        if (!getView().isAvailable()) {
            return;
        }
        BusyIndicator.showWhile(getView().getViewer().getControl().getDisplay(), new Runnable() {
            public void run() {
                // Checking this action sets the type to fType, unchecking it sets the type
                // to null ("none selected")
                ILogicalStructureType type = null;
                if (isChecked()) {
                    type = fType;
                }
                DebugPlugin.setDefaultStructureType(fAvailableTypes, type);
                getView().getViewer().refresh();
            }
        });
    }

    protected VariablesView getView() {
        return fView;
    }

    protected void setView(VariablesView view) {
        fView = view;
    }
}
