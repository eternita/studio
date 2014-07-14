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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILogicalStructureType;
import org.eclipse.debug.core.model.IExpression;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.views.variables.VariablesViewMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;

/**
 * Drop down action that displays available logical structures for a selected
 * variable or expression.
 */
public class AvailableLogicalStructuresAction extends Action implements IMenuCreator {

    private VariablesView fView;
    private Menu fMenu;
    private IValue fValue;
    private ILogicalStructureType[] fTypes;

    public AvailableLogicalStructuresAction(VariablesView view) {
        setView(view);
        setToolTipText(VariablesViewMessages.AvailableLogicalStructuresAction_0);
        setText(VariablesViewMessages.AvailableLogicalStructuresAction_1);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.VARIABLES_SELECT_LOGICAL_STRUCTURE);
        setEnabled(false);
        setMenuCreator(this);
        init();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
    }

    protected VariablesView getView() {
        return fView;
    }

    protected void setView(VariablesView view) {
        fView = view;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IMenuCreator#dispose()
     */
    public void dispose() {
        if (fMenu != null) {
            fMenu.dispose();
        }
        fView = null;
        fValue = null;
        fTypes = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Control)
     */
    public Menu getMenu(Control parent) {
        return null;
    }

    protected void addActionToMenu(Menu parent, Action action) {
        ActionContributionItem item = new ActionContributionItem(action);
        item.fill(parent, -1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Menu)
     */
    public Menu getMenu(Menu parent) {
        if (fMenu != null) {
            fMenu.dispose();
        }

        fMenu = new Menu(parent);
        ILogicalStructureType[] types = getTypes();
        ILogicalStructureType enabledType = DebugPlugin.getDefaultStructureType(types);
        if (types != null && types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                ILogicalStructureType type = types[i];
                Action action = new SelectLogicalStructureAction(getView(), type, getValue(), types);
                action.setChecked(enabledType == type);
                StringBuffer label = new StringBuffer();
                // add the numerical accelerator
                if (i < 9) {
                    label.append('&');
                    label.append(i + 1);
                    label.append(' ');
                }
                label.append(action.getText());
                action.setText(label.toString());
                addActionToMenu(fMenu, action);
            }
        }
        return fMenu;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent
     * )
     */
    public void init() {
        setValue(null);
        setTypes(null);
        if (getView().isShowLogicalStructure()) {
            ISelection s = getView().getViewer().getSelection();
            if (s instanceof IStructuredSelection) {
                IStructuredSelection selection = (IStructuredSelection) s;
                if (selection.size() == 1) {
                    Object obj = selection.getFirstElement();
                    IValue value = null;
                    if (obj instanceof IVariable) {
                        IVariable var = (IVariable) obj;
                        try {
                            value = var.getValue();
                        } catch (DebugException e) {
                        }
                    } else if (obj instanceof IExpression) {
                        IExpression expression = (IExpression) obj;
                        value = expression.getValue();
                    }
                    if (value != null) {
                        ILogicalStructureType[] types = DebugPlugin.getLogicalStructureTypes(value);
                        if (types.length > 0) {
                            setTypes(types);
                            setValue(value);
                            setEnabled(true);
                            return;
                        }
                    }
                }
            }
        }
        setEnabled(false);
    }

    protected ILogicalStructureType[] getTypes() {
        return fTypes;
    }

    private void setTypes(ILogicalStructureType[] types) {
        fTypes = types;
    }

    protected IValue getValue() {
        return fValue;
    }

    private void setValue(IValue value) {
        fValue = value;
    }
}
