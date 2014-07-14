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
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

/**
 * This class implements the show target breakpoint action.
 * 
 * @since 3.6
 */
public class ShowTargetBreakpointsAction extends Action {
    /**
     * Breakpoints view
     */
    FlowBreakpointsView fView;

    /**
     * Constructor.
     * 
     * @param view
     *        the breakpoints view
     */
    public ShowTargetBreakpointsAction(FlowBreakpointsView view) {
        super();

        fView = view;

        setText(ActionMessages.ShowSupportedBreakpointsAction_Show_For_Selected);
        setToolTipText(ActionMessages.ShowSupportedBreakpointsAction_tooltip);

        setImageDescriptor(DebugPluginImages.getImageDescriptor(IDebugUIConstants.IMG_OBJS_DEBUG_TARGET));
        setChecked(false);
        setId(DebugUIPlugin.getUniqueIdentifier() + ".ShowSupportedBreakpointsAction"); //$NON-NLS-1$

        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.SHOW_BREAKPOINTS_FOR_MODEL_ACTION);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run() {
        if (fView.getViewer().getControl().isDisposed()) {
            return;
        }
        fView.setFilterSelection(isChecked());
    }
}
