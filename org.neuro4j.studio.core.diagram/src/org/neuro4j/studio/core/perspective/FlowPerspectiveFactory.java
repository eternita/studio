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
package org.neuro4j.studio.core.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class FlowPerspectiveFactory implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        
        

        IFolderLayout folder = layout.createFolder("left", IPageLayout.LEFT, 0.25F, editorArea);
        folder.addView("org.eclipse.jdt.ui.PackageExplorer");
        folder.addView("org.neuro4j.studio.core.views.flows.FlowTreeView");
        folder.addView("org.neuro4j.studio.core.views.flows.CustomBlocksTreeView");
        
        folder.addPlaceholder("org.eclipse.jdt.ui.TypeHierarchy");
        folder.addPlaceholder("org.eclipse.ui.views.ResourceNavigator");
        folder.addPlaceholder("org.eclipse.ui.navigator.ProjectExplorer");

        IFolderLayout letfBottom = layout.createFolder("left", IPageLayout.BOTTOM, 0.75F, "org.eclipse.jdt.ui.PackageExplorer");
        letfBottom.addView("org.eclipse.jdt.ui.FlowdocView");

        

        IFolderLayout outputfolder = layout.createFolder("bottom", 4, 0.75F, editorArea);
        outputfolder.addView("org.eclipse.ui.views.PropertySheet");
        outputfolder.addView("org.eclipse.ui.views.ProblemView");
        outputfolder.addView("org.eclipse.jdt.ui.JavadocView");
        outputfolder.addView("org.eclipse.jdt.ui.SourceView");
        outputfolder.addPlaceholder("org.eclipse.search.ui.views.SearchView");
        outputfolder.addPlaceholder("org.eclipse.ui.console.ConsoleView");
        outputfolder.addPlaceholder("org.eclipse.ui.views.BookmarkView");
        outputfolder.addPlaceholder("org.eclipse.ui.views.ProgressView");

        IFolderLayout outlineFolder = layout.createFolder("right", 2, 0.75F, editorArea);
        outlineFolder.addView("org.eclipse.ui.views.ContentOutline");

        outlineFolder.addPlaceholder("org.eclipse.ui.texteditor.TemplatesView");

        layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
        layout.addActionSet("org.eclipse.jdt.ui.JavaActionSet");
        layout.addActionSet("org.eclipse.jdt.ui.JavaElementCreationActionSet");
        layout.addActionSet("org.eclipse.ui.NavigateActionSet");

        layout.addShowViewShortcut("org.eclipse.jdt.ui.PackageExplorer");
        layout.addShowViewShortcut("org.eclipse.jdt.ui.TypeHierarchy");
        layout.addShowViewShortcut("org.eclipse.jdt.ui.SourceView");
        layout.addShowViewShortcut("org.eclipse.jdt.ui.JavadocView");

        layout.addShowViewShortcut("org.eclipse.search.ui.views.SearchView");

        layout.addShowViewShortcut("org.eclipse.ui.console.ConsoleView");

        layout.addShowViewShortcut("org.eclipse.ui.views.ContentOutline");
        layout.addShowViewShortcut("org.eclipse.ui.views.ProblemView");
        layout.addShowViewShortcut("org.eclipse.ui.views.ResourceNavigator");
        layout.addShowViewShortcut("org.eclipse.ui.views.TaskList");
        layout.addShowViewShortcut("org.eclipse.ui.views.ProgressView");
        layout.addShowViewShortcut("org.eclipse.ui.navigator.ProjectExplorer");
        layout.addShowViewShortcut("org.eclipse.ui.texteditor.TemplatesView");
        layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView");

        layout.addNewWizardShortcut("org.neuro4j.studio.core.diagram.wizards.webproject.NewWebFlowProjectWizard");
        layout.addNewWizardShortcut("org.neuro4j.studio.core.diagram.part.Neuro4jCreationWizardID");
        layout.addNewWizardShortcut("org.neuro4j.studio.core.diagram.wizards.customblock.CustomBlockNewWizardID");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard");
        // layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard");
        layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewJavaWorkingSetWizard");
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
        layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");

        layout.addPerspectiveShortcut("org.neuro4j.studio.flowPerspective");
        layout.addPerspectiveShortcut("org.eclipse.jdt.ui.JavaBrowsingPerspective");
        layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective");
    }

}
