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
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.ui.handlers.CollapseAllHandler;
import org.eclipse.ui.texteditor.IUpdate;
import org.neuro4j.studio.debug.ui.views.TreeModelViewer;

/**
 * CollapseAllAction
 */
public class CollapseAllAction extends Action implements IUpdate {

    private TreeModelViewer fViewer;

    public CollapseAllAction(TreeModelViewer viewer) {
        super(ActionMessages.CollapseAllAction_0, DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_ELCL_COLLAPSE_ALL));
        setToolTipText(ActionMessages.CollapseAllAction_0);
        setDisabledImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_DLCL_COLLAPSE_ALL));
        setHoverImageDescriptor(DebugPluginImages.getImageDescriptor(IInternalDebugUIConstants.IMG_LCL_COLLAPSE_ALL));
        setActionDefinitionId(CollapseAllHandler.COMMAND_ID);
        fViewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
        fViewer.collapseAll();
    }

    public void update() {
        setEnabled(fViewer.getInput() != null && fViewer.getChildCount(TreePath.EMPTY) > 0);
    }
}
