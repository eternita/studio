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
package org.neuro4j.studio.core.diagram.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
public class Neuro4jDiagramActionBarContributor extends
        DiagramActionBarContributor {

    /**
     * @generated
     */
    protected Class getEditorClass() {
        return Neuro4jDiagramEditor.class;
    }

    /**
     * @generated
     */
    protected String getEditorId() {
        return Neuro4jDiagramEditor.ID;
    }

    /**
     * @generated
     */
    public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);
        // print preview
        IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(
                IWorkbenchActionConstants.M_FILE);
        assert fileMenu != null;
        fileMenu.remove("pageSetupAction"); //$NON-NLS-1$
    }
}
