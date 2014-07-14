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
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

public class ToggleDetailPaneAction extends Action
{
    private VariablesView fVariablesView;
    private String fOrientation;

    public ToggleDetailPaneAction(VariablesView view, String orientation, String hiddenLabel)
    {
        super("", 8);
        setVariablesView(view);
        setOrientation(orientation);

        if (orientation == "Variables.detail.orientation.underneath") {
            setText(ActionMessages.ToggleDetailPaneAction_1);
            setToolTipText(ActionMessages.ToggleDetailPaneAction_2);
            setDescription(ActionMessages.ToggleDetailPaneAction_2);
            setImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_ELCL_DETAIL_PANE_UNDER"));
            setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_DLCL_DETAIL_PANE_UNDER"));
            setHoverImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_LCL_DETAIL_PANE_UNDER"));
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "org.eclipse.debug.ui.vertical_detail_pane_layout_action_context");
        } else if (orientation == "Variables.detail.orientation.right") {
            setText(ActionMessages.ToggleDetailPaneAction_4);
            setToolTipText(ActionMessages.ToggleDetailPaneAction_5);
            setDescription(ActionMessages.ToggleDetailPaneAction_5);
            setImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_ELCL_DETAIL_PANE_RIGHT"));
            setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_DLCL_DETAIL_PANE_RIGHT"));
            setHoverImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_LCL_DETAIL_PANE_RIGHT"));
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "org.eclipse.debug.ui.horizontal_detail_pane_layout_action_context");
        } else if (orientation == "Variables.detail.orientation.auto") {
            setText(ActionMessages.ToggleDetailPaneAction_0);
            setToolTipText(ActionMessages.ToggleDetailPaneAction_3);
            setDescription(ActionMessages.ToggleDetailPaneAction_3);
            setImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_ELCL_DETAIL_PANE_AUTO"));
            setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_DLCL_DETAIL_PANE_AUTO"));
            setHoverImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_ELCL_DETAIL_PANE_AUTO"));
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "org.eclipse.debug.ui.horizontal_detail_pane_layout_action_context");
        } else {
            setText(hiddenLabel);
            setToolTipText(ActionMessages.ToggleDetailPaneAction_8);
            setDescription(ActionMessages.ToggleDetailPaneAction_8);
            setImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_ELCL_DETAIL_PANE_HIDE"));
            setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_DLCL_DETAIL_PANE_HIDE"));
            setHoverImageDescriptor(DebugPluginImages.getImageDescriptor("IMG_LCL_DETAIL_PANE_HIDE"));
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, "org.eclipse.debug.ui.detail_pane_hidden_layout_action_context");
        }
    }

    public void run()
    {
        getVariablesView().setDetailPaneOrientation(getOrientation());
    }

    private VariablesView getVariablesView() {
        return this.fVariablesView;
    }

    private void setVariablesView(VariablesView variablesView) {
        this.fVariablesView = variablesView;
    }

    private void setOrientation(String orientation) {
        this.fOrientation = orientation;
    }

    public String getOrientation() {
        return this.fOrientation;
    }
}