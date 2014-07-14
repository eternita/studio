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

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupManager;
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupUIMessages;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;

/**
 * Does source lookup for the selected stack frame again.
 * 
 * @since 3.0
 */
public class LookupSourceAction extends SelectionListenerAction {

    private ISourceLookupDirector director = null;
    private FlowLaunchView fView = null;
    private IStackFrame frame = null;

    public LookupSourceAction(FlowLaunchView view) {
        super(SourceLookupUIMessages.LookupSourceAction_0);
        setEnabled(false);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.LOOKUP_SOURCE_ACTION);
        fView = view;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection(org.eclipse.jface.viewers.IStructuredSelection
     * )
     */
    protected boolean updateSelection(IStructuredSelection selection) {
        director = null;
        frame = null;
        if (selection.size() == 1) {
            Object object = selection.getFirstElement();
            if (object instanceof IStackFrame) {
                frame = (IStackFrame) object;
                ILaunch launch = frame.getLaunch();
                if (launch != null && launch.getLaunchConfiguration() != null &&
                        launch.getSourceLocator() instanceof ISourceLookupDirector) {
                    director = (ISourceLookupDirector) launch.getSourceLocator();
                }
            }
        }
        return director != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
        ISelection selection = fView.getViewer().getSelection();
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection ss = (IStructuredSelection) selection;
            if (ss.size() == 1) {
                IWorkbenchPage page = fView.getSite().getPage();
                SourceLookupManager.getDefault().displaySource(ss.getFirstElement(), page, true);
            }
        }
    }
}
