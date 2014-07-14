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

import java.util.List;

import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.actions.breakpointGroups.BreakpointGroupMessages;
import org.eclipse.debug.internal.ui.breakpoints.provisional.IBreakpointContainer;
import org.eclipse.debug.internal.ui.breakpoints.provisional.OtherBreakpointCategory;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * Standard action for pasting resources on the clipboard to the selected resource's location.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 * 
 * @since 2.0
 */
public class PasteBreakpointsAction extends BreakpointSelectionAction {

    /**
     * Creates a new action.
     * 
     * @param view
     *        the view of this action
     */
    public PasteBreakpointsAction(FlowBreakpointsView view) {
        super(BreakpointGroupMessages.PasteBreakpointsAction_0, view);
        setToolTipText(BreakpointGroupMessages.PasteBreakpointsAction_1);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.PASTE_BREAKPOINTS_ACTION);
    }

    /**
     * Returns the actual target of the paste action. Returns null
     * if no valid target is selected.
     * 
     * @return the actual target of the paste action
     */
    private Object getTarget() {
        List selectedNonResources = getSelectedNonResources();
        if (selectedNonResources.size() == 1) {
            Object target = selectedNonResources.get(0);
            if (target instanceof IBreakpointContainer) {
                return target;
            }
        }
        return null;
    }

    /**
     * Implementation of method defined on <code>IAction</code>.
     */
    public void run() {
        if (getBreakpointsView().canPaste(getTarget(), LocalSelectionTransfer.getTransfer().getSelection())) {
            getBreakpointsView().performPaste(getTarget(), LocalSelectionTransfer.getTransfer().getSelection());
        }
    }

    /**
     * Returns whether this action should be enabled based on the selection
     * in the clipboard. Only updates when the breakpoints view has focus.
     */
    protected boolean updateSelection(IStructuredSelection selection) {
        // can't paste into "Others" (only move)
        Object target = getTarget();
        if (target instanceof IBreakpointContainer) {
            IBreakpointContainer container = (IBreakpointContainer) target;
            if (container.getCategory() instanceof OtherBreakpointCategory) {
                return false;
            }
            return true;
        }
        // don't access clipboard - causes Hang -see bug 84870
        return false;
    }
}
