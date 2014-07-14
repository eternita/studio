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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.actions.AbstractSelectionActionDelegate;
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.debug.internal.ui.breakpoints.provisional.IBreakpointContainer;
import org.eclipse.debug.internal.ui.views.breakpoints.WorkingSetCategory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

public class RemoveBreakpointAction extends AbstractSelectionActionDelegate {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action) {
        TreeSelection selection = (TreeSelection) getSelection();

        if (selection.isEmpty()) {
            return;
        }
        final Iterator itr = selection.iterator();
        final CoreException[] exception = new CoreException[1];
        // IWorkspaceRunnable runnable= new IWorkspaceRunnable() {
        // public void run(IProgressMonitor monitor) {
        ArrayList breakpointsToDelete = new ArrayList();
        ArrayList groupsToDelete = new ArrayList();
        boolean deleteAll = false;
        boolean deleteContainer = false;
        boolean prompted = false;
        while (itr.hasNext()) {
            Object next = itr.next();
            IBreakpoint breakpoint = (IBreakpoint) DebugPlugin.getAdapter(next, IBreakpoint.class);
            if (breakpoint != null) {
                breakpointsToDelete.add(breakpoint);

            }
        }
        final FlowLineBreakpointAdapter[] breakpoints = (FlowLineBreakpointAdapter[]) breakpointsToDelete.toArray(new FlowLineBreakpointAdapter[0]);

        if (breakpoints.length > 0) {
            ((FlowBreakpointsView) getView()).preserveSelection(getSelection());
        }
        try {
            BreakpoinMng.getInstance().removeBreakpoints(breakpoints);
            // TODO: BTH

            // ((FlowBreakpointsView)getView()).removeBreakpoints(breakpoints);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // new Job(ActionMessages.RemoveBreakpointAction_2) {
        // protected IStatus run(IProgressMonitor pmonitor) {
        // try {
        // Shell shell= getView() != null ? getView().getSite().getShell() : null;
        // // BreakpoinMng.getInstance().removeBreakpoints(breakpoints);
        //
        //
        //
        // BreakpoinMng.getInstance().removeBreakpoints(breakpoints);
        // ((FlowBreakpointsView)getView()).removeBreakpoints((TreeSelection) getSelection(), breakpoints);
        //
        //
        // return Status.OK_STATUS;
        // } catch (CoreException e) {
        // DebugUIPlugin.log(e);
        // }
        // return Status.CANCEL_STATUS;
        // }
        // }.schedule();
        // }
        // };
        // try {
        // ResourcesPlugin.getWorkspace().run(runnable, null, 0, null);
        // } catch (CoreException ce) {
        // exception[0]= ce;
        // }

        if (exception[0] != null) {
            IWorkbenchWindow window = DebugUIPlugin.getActiveWorkbenchWindow();
            if (window != null) {
                DebugUIPlugin.errorDialog(window.getShell(), ActionMessages.RemoveBreakpointAction_Removing_a_breakpoint_4, ActionMessages.RemoveBreakpointAction_Exceptions_occurred_attempting_to_remove_a_breakpoint__5, exception[0]);
            } else {
                DebugUIPlugin.log(exception[0]);
            }

        }
        ((FlowBreakpointsView) getView()).getViewer().refresh();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.ui.actions.AbstractSelectionActionDelegate#isEnabledFor(java.lang.Object)
     */
    protected boolean isEnabledFor(Object element) {
        if (element instanceof IBreakpointContainer) {
            if (((IBreakpointContainer) element).getCategory() instanceof WorkingSetCategory) {
                return true;
            }
            return ((IBreakpointContainer) element).getBreakpoints().length > 0;
        }
        return DebugPlugin.getAdapter(element, IBreakpoint.class) != null;
    }
}
