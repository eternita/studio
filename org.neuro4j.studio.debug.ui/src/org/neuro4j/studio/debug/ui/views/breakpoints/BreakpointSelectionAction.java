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

import org.eclipse.ui.actions.SelectionListenerAction;

/**
 * A selection listener action for the breakpoints view.
 */
public abstract class BreakpointSelectionAction extends SelectionListenerAction {

    private FlowBreakpointsView fView;

    /**
     * Constructs an action for the breakpoints view.
     * 
     * @param text
     *        action name
     * @param view
     *        breakpoints view
     */
    public BreakpointSelectionAction(String text, FlowBreakpointsView view) {
        super(text);
        fView = view;
    }

    /**
     * Returns the breakpoints view.
     * 
     * @return breakpoints view
     */
    protected FlowBreakpointsView getBreakpointsView() {
        return fView;
    }

}
