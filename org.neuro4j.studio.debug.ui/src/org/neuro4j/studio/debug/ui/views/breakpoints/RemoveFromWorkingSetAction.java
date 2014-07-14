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
import java.util.List;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.internal.ui.actions.breakpointGroups.BreakpointGroupMessages;
import org.eclipse.debug.internal.ui.breakpoints.provisional.IBreakpointContainer;
import org.eclipse.debug.internal.ui.views.breakpoints.WorkingSetCategory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;

/**
 * Removes a breakpoint from a breakpoint working set.
 */
public class RemoveFromWorkingSetAction extends BreakpointSelectionAction {

    private BreakpointSetElement[] fBreakpoints;

    /**
     * Constructs action to remove breakpoints from a category.
     * 
     * @param view
     */
    public RemoveFromWorkingSetAction(FlowBreakpointsView view) {
        super(BreakpointGroupMessages.RemoveFromWorkingSetAction_0, view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
        if (fBreakpoints != null) {
            for (int i = 0; i < fBreakpoints.length; i++) {
                fBreakpoints[i].container.getOrganizer().removeBreakpoint(fBreakpoints[i].breakpoint, fBreakpoints[i].container.getCategory());
            }
        }
    }

    protected static class BreakpointSetElement {
        BreakpointSetElement(IBreakpoint b, IBreakpointContainer c) {
            breakpoint = b;
            container = c;
        }

        IBreakpoint breakpoint;
        IBreakpointContainer container;
    }

    /**
     * Returns a array of breakpoint/container pairs for the selection
     * 
     * All the returned elements contain a breakpoint and a working set container the breakpoint is contained and the
     * breakpoint
     * can be removed from.
     * 
     * @param selection
     * @return
     */
    protected BreakpointSetElement[] getRemovableBreakpoints(IStructuredSelection selection) {
        List res = new ArrayList();
        if (selection instanceof ITreeSelection) {
            ITreeSelection tSel = (ITreeSelection) selection;

            TreePath[] paths = tSel.getPaths();
            for (int i = 0; i < paths.length; i++) {
                TreePath path = paths[i];

                // We can remove Breakpoints from their working set if any of their parents is a non "Other" breakpoint
                // working set
                IBreakpoint breakpoint = (IBreakpoint) DebugPlugin.getAdapter(path.getLastSegment(), IBreakpoint.class);
                if (breakpoint != null) {
                    TreePath parents = path.getParentPath();

                    for (int j = 0; j < parents.getSegmentCount(); j++) {
                        Object parent = parents.getSegment(j);

                        if (parent instanceof IBreakpointContainer) {
                            IBreakpointContainer container = (IBreakpointContainer) parent;

                            // Test if this is a working set container.
                            if (container.getCategory() instanceof WorkingSetCategory) {
                                // Test if this container allows to remove this breakpoint.
                                if (container.getOrganizer().canRemove(breakpoint, container.getCategory())) {
                                    res.add(new BreakpointSetElement(breakpoint, container));
                                }
                            }
                        }
                    }
                }
            }
        }
        return (BreakpointSetElement[]) res.toArray(new BreakpointSetElement[res.size()]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    public boolean isEnabled() {
        if (fBreakpoints != null) {
            return fBreakpoints.length > 0;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection(org.eclipse.jface.viewers.IStructuredSelection
     * )
     */
    protected boolean updateSelection(IStructuredSelection selection) {
        fBreakpoints = getRemovableBreakpoints(selection);
        return fBreakpoints.length > 0;
    }
}
