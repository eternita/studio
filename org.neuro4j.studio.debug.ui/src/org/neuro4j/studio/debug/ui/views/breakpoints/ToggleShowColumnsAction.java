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

import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.views.variables.VariablesViewMessages;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IUpdate;
import org.neuro4j.studio.debug.ui.views.TreeModelViewer;

/**
 * Action to toggle the use of contributed variables content providers on and off.
 * When on, all registered variables content providers for the current debug model
 * are used. When off, the default content provider (that shows all children)
 * is used for all debug models.
 */
public class ToggleShowColumnsAction extends Action implements IUpdate {

    private TreeModelViewer fViewer;

    public ToggleShowColumnsAction(TreeModelViewer viewew) {
        super(VariablesViewMessages.ToggleShowColumnsAction_0, IAction.AS_CHECK_BOX);
        fViewer = viewew;
        setToolTipText(VariablesViewMessages.ToggleShowColumnsAction_1);
        setImageDescriptor(DebugUITools.getImageDescriptor(IInternalDebugUIConstants.IMG_OBJS_COMMON_TAB));
        setId(DebugUIPlugin.getUniqueIdentifier() + ".ToggleShowColumsAction"); //$NON-NLS-1$
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.SHOW_COLUMNS_ACTION);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run() {
        if (fViewer.getControl().isDisposed()) {
            return;
        }
        BusyIndicator.showWhile(fViewer.getControl().getDisplay(), new Runnable() {
            public void run() {
                fViewer.setShowColumns(isChecked());
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.texteditor.IUpdate#update()
     */
    public void update() {
        setEnabled(fViewer.canToggleColumns());
        setChecked(fViewer.isShowColumns());
    }

}
