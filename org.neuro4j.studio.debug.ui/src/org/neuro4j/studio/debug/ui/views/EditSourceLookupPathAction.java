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
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupManager;
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupUIMessages;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.sourcelookup.SourceLookupDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;

/**
 * The action for editing the source lookup path. Brings up the
 * EditSourceLookupPathDialog.
 * 
 * @since 3.0
 */
public class EditSourceLookupPathAction extends SelectionListenerAction {

    private ISourceLookupDirector director = null;
    private FlowLaunchView fView = null;

    public EditSourceLookupPathAction(FlowLaunchView view) {
        super(SourceLookupUIMessages.EditSourceLookupPathAction_0);
        setEnabled(false);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.EDIT_SOURCELOOKUP_ACTION);
        setImageDescriptor(DebugUITools.getImageDescriptor(IInternalDebugUIConstants.IMG_SRC_LOOKUP_MENU));
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
        if (selection.size() == 1) {
            Object object = selection.getFirstElement();
            ILaunch launch = null;
            if (object instanceof IDebugElement) {
                launch = ((IDebugElement) object).getLaunch();
            } else if (object instanceof ILaunch) {
                launch = (ILaunch) object;
            }
            if (launch != null && launch.getLaunchConfiguration() != null &&
                    launch.getSourceLocator() instanceof ISourceLookupDirector) {
                director = (ISourceLookupDirector) launch.getSourceLocator();
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
        Shell shell = DebugUIPlugin.getShell();
        SourceLookupDialog dialog = new SourceLookupDialog(shell, director);
        if (dialog.open() == Window.OK) {
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
}
