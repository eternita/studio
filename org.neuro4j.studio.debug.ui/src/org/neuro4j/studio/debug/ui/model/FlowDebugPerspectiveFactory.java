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
package org.neuro4j.studio.debug.ui.model;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class FlowDebugPerspectiveFactory
        implements IPerspectiveFactory
{

    public void createInitialLayout(IPageLayout layout)
    {
//        IFolderLayout consoleFolder = layout.createFolder("org.eclipse.debug.internal.ui.ConsoleFolderView", 4, 0.75F, layout.getEditorArea());
//        consoleFolder.addView("org.eclipse.ui.console.ConsoleView");
//        consoleFolder.addView("org.eclipse.ui.views.TaskList");
//        consoleFolder.addPlaceholder("org.eclipse.ui.views.BookmarkView");
//        consoleFolder.addPlaceholder("org.eclipse.ui.views.PropertySheet");

        IFolderLayout navFolder = layout.createFolder("org.eclipse.debug.internal.ui.NavigatorFolderView", 3, 0.25F, layout.getEditorArea());
        navFolder.addView("org.neuro4j.studio.debug.ui.DebugView");
    //    navFolder.addView("org.eclipse.debug.ui.DebugView");
        navFolder.addPlaceholder("org.eclipse.ui.views.ResourceNavigator");

        IFolderLayout toolsFolder = layout.createFolder("org.eclipse.debug.internal.ui.ToolsFolderView", 2, 0.5F, "org.eclipse.debug.internal.ui.NavigatorFolderView");

        toolsFolder.addView("org.neuro4j.studio.debug.ui.BreakpointView");
        toolsFolder.addView("org.neuro4j.studio.debug.ui.DataStackView");


     //   toolsFolder.addView("org.eclipse.debug.ui.VariableView");
     //   toolsFolder.addView("org.eclipse.debug.ui.BreakpointView");
//        toolsFolder.addPlaceholder("org.eclipse.debug.ui.ExpressionView");
//        toolsFolder.addPlaceholder("org.eclipse.debug.ui.RegisterView");

        IFolderLayout outlineFolder = layout.createFolder("org.eclipse.debug.internal.ui.OutlineFolderView", 2, 0.75F, layout.getEditorArea());
        outlineFolder.addView("org.eclipse.ui.views.ContentOutline");

        layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
        layout.addActionSet("org.eclipse.debug.ui.debugActionSet");

        setContentsOfShowViewMenu(layout);
    }

    protected void setContentsOfShowViewMenu(IPageLayout layout)
    {
      //  layout.addShowViewShortcut("org.eclipse.debug.ui.DebugView");
     //   layout.addShowViewShortcut("org.eclipse.debug.ui.VariableView");
     //   layout.addShowViewShortcut("org.eclipse.debug.ui.BreakpointView");
     //   layout.addShowViewShortcut("org.eclipse.debug.ui.ExpressionView");
//        layout.addShowViewShortcut("org.eclipse.ui.views.ContentOutline");
//        layout.addShowViewShortcut("org.eclipse.ui.console.ConsoleView");
//        layout.addShowViewShortcut("org.eclipse.ui.views.TaskList");
    }
}