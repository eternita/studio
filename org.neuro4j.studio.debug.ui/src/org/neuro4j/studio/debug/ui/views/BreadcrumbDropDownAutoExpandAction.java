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

import org.eclipse.debug.internal.core.IInternalDebugCoreConstants;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.views.launch.LaunchViewMessages;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

/**
 * Action that controls the preference for whether elements should be
 * automatically expanded in the breadcrumb drop down viewers.
 * 
 * @since 3.5
 */
class BreadcrumbDropDownAutoExpandAction extends Action {

    private final FlowLaunchView fLaunchView;

    /**
     * Creates a new action to set the debug view mode.
     * 
     * @param view
     *        Reference to the debug view.
     * @param mode
     *        The mode to be set by this action.
     * @param parent
     *        The view's parent control used to calculate view size
     *        in auto mode.
     */
    public BreadcrumbDropDownAutoExpandAction(FlowLaunchView view) {
        super(IInternalDebugCoreConstants.EMPTY_STRING, AS_CHECK_BOX);
        fLaunchView = view;

        setText(LaunchViewMessages.BreadcrumbDropDownAutoExpandAction_label);
        setToolTipText(LaunchViewMessages.BreadcrumbDropDownAutoExpandAction_tooltip);
        setDescription(LaunchViewMessages.BreadcrumbDropDownAutoExpandAction_description);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.DEBUG_VIEW_DROP_DOWN_AUTOEXPAND_ACTION);

        setChecked(fLaunchView.getBreadcrumbDropDownAutoExpand());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {
        fLaunchView.setBreadcrumbDropDownAutoExpand(isChecked());
    }
}
