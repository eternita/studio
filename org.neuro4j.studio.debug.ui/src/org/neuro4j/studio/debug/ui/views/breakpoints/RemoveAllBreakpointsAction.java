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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointsListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.actions.AbstractRemoveAllActionDelegate;
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.debug.internal.ui.preferences.IDebugPreferenceConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

/**
 * Removes all breakpoints from the source (markers) and remove all
 * breakpoints from processes
 */
public class RemoveAllBreakpointsAction extends AbstractRemoveAllActionDelegate implements IBreakpointsListener {

    IViewPart view;
    private Shell fShell;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.actions.selection.AbstractRemoveAllActionDelegate#isEnabled()
     */
    protected boolean isEnabled() {
        return DebugPlugin.getDefault().getBreakpointManager().hasBreakpoints();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.IBreakpointsListener#breakpointsAdded(org.eclipse.debug.core.model.IBreakpoint[])
     */
    public void breakpointsAdded(IBreakpoint[] breakpoints) {
        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.IBreakpointsListener#breakpointsChanged(org.eclipse.debug.core.model.IBreakpoint[],
     * org.eclipse.core.resources.IMarkerDelta[])
     */
    public void breakpointsChanged(IBreakpoint[] breakpoints, IMarkerDelta[] deltas) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.IBreakpointsListener#breakpointsRemoved(org.eclipse.debug.core.model.IBreakpoint[],
     * org.eclipse.core.resources.IMarkerDelta[])
     */
    public void breakpointsRemoved(IBreakpoint[] breakpoints, IMarkerDelta[] deltas) {
        if (getAction() != null) {
            update();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.actions.selection.AbstractRemoveAllActionDelegate#initialize()
     */
    protected void initialize() {
        DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
     */
    public void dispose() {
        DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
        super.dispose();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action) {
        // final IBreakpointManager breakpointManager= DebugPlugin.getDefault().getBreakpointManager();
        final FlowLineBreakpointAdapter[] breakpoints = BreakpoinMng.getInstance().getBreakpoints();
        if (breakpoints.length < 1) {
            return;
        }
        IWorkbenchWindow window = DebugUIPlugin.getActiveWorkbenchWindow();
        if (window == null) {
            return;
        }
        IPreferenceStore store = DebugUIPlugin.getDefault().getPreferenceStore();
        boolean prompt = store.getBoolean(IDebugPreferenceConstants.PREF_PROMPT_REMOVE_ALL_BREAKPOINTS);
        boolean proceed = true;
        if (prompt) {
            MessageDialogWithToggle mdwt = MessageDialogWithToggle.openYesNoQuestion(window.getShell(), ActionMessages.RemoveAllBreakpointsAction_0,
                    ActionMessages.RemoveAllBreakpointsAction_1, ActionMessages.RemoveAllBreakpointsAction_3, !prompt, null, null);
            if (mdwt.getReturnCode() != IDialogConstants.YES_ID) {
                proceed = false;
            }
            else {
                store.setValue(IDebugPreferenceConstants.PREF_PROMPT_REMOVE_ALL_BREAKPOINTS, !mdwt.getToggleState());
            }
        }
        if (proceed) {
            // new Job(ActionMessages.RemoveAllBreakpointsAction_2) {
            // protected IStatus run(IProgressMonitor monitor) {
            // try {
            //
            // // DebugUITools.deleteBreakpoints(breakpoints, fShell, monitor);
            // BreakpoinMng.getInstance().removeBreakpoints(breakpoints);
            // ((FlowBreakpointsView)RemoveAllBreakpointsAction.this.view).removeBreakpoints(null, breakpoints);
            // } catch (CoreException e) {
            // DebugUIPlugin.log(e);
            // return Status.CANCEL_STATUS;
            // }
            // return Status.OK_STATUS;
            // }
            // }.schedule();

            try {

                BreakpoinMng.getInstance().removeBreakpoints(breakpoints);
                // ((FlowBreakpointsView)RemoveAllBreakpointsAction.this.view).removeBreakpoints(breakpoints);
            } catch (CoreException e) {
                DebugUIPlugin.log(e);
            }
        }
    }

    /*
     * @see org.eclipse.debug.internal.ui.actions.AbstractRemoveAllActionDelegate#init(org.eclipse.ui.IViewPart)
     * 
     * @since 3.7
     */
    public void init(IViewPart view) {
        super.init(view);
        this.view = view;

        fShell = view.getSite().getShell();
    }

    /*
     * @see org.eclipse.debug.internal.ui.actions.AbstractRemoveAllActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
     * 
     * @since 3.7
     */
    public void init(IWorkbenchWindow window) {
        super.init(window);
        fShell = window.getShell();
    }
}
