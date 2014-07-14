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
package org.neuro4j.studio.core.buildpath;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jdt.ui.wizards.NewElementWizardPage;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.neuro4j.studio.core.Neuro4jCore;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.neuro4j.studio.core.util.JUnitStubUtility;
import org.neuro4j.studio.core.utils.BasicElementLabels;

public class Neuro4jContainerWizardPage extends NewElementWizardPage
        implements IClasspathContainerPage, IClasspathContainerPageExtension
{
    private IJavaProject fProject;
    private IClasspathEntry fContainerEntryResult;
    private Combo fVersionCombo;
    private Text fResolvedPath;
    private Text fResolvedSourcePath;

    public Neuro4jContainerWizardPage()
    {
        super("Neuro4jContainerPage");


        this.fContainerEntryResult = JavaCore.newContainerEntry(Neuro4jCore.NEURO4J_CONTAINER_PATH);
    }

    public static IJavaProject getPlaceholderProject() {
        String name = "####internal";
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        while (true) {
            IProject project = root.getProject(name);
            if (!project.exists()) {
                return JavaCore.create(project);
            }
            name = name + '1';
        }
    }

    public boolean finish() {
        try {
            IJavaProject[] javaProjects = { getPlaceholderProject() };
            IClasspathContainer[] containers = new IClasspathContainer[1];
            JavaCore.setClasspathContainer(this.fContainerEntryResult.getPath(), javaProjects, containers, null);

        } catch (JavaModelException e) {
            ExceptionHandler.handle(e, Neuro4jCorePlugin.getActiveWorkbenchShell(), WizardMessages.Neuro4jContainerWizardPage_error_title, WizardMessages.Neuro4jContainerWizardPage_error_problem_configuring_container);
            return false;
        }
        return true;
    }

    public IClasspathEntry getSelection() {
        return this.fContainerEntryResult;
    }

    public void setSelection(IClasspathEntry containerEntry) {
        this.fContainerEntryResult = containerEntry;
    }

    public void createControl(Composite parent) {
        PixelConverter converter = new PixelConverter(parent);

        Composite composite = new Composite(parent, 0);
        composite.setFont(parent.getFont());

        composite.setLayout(new GridLayout(2, false));

        Label label = new Label(composite, 0);
        label.setFont(composite.getFont());
        label.setLayoutData(new GridData(4, 2, false, false, 1, 1));
        label.setText(WizardMessages.Neuro4jContainerWizardPage_combo_label);

        this.fVersionCombo = new Combo(composite, 8);
        this.fVersionCombo.setItems(new String[] {
                WizardMessages.Neuro4jContainerWizardPage_option_neuro4j08 });

        this.fVersionCombo.setFont(composite.getFont());

        GridData data = new GridData(1, 2, false, false, 1, 1);
        data.widthHint = converter.convertWidthInCharsToPixels(15);
        this.fVersionCombo.setLayoutData(data);

        this.fVersionCombo.select(0);

        this.fVersionCombo.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                Neuro4jContainerWizardPage.this.doSelectionChanged();
            }
        });
        label = new Label(composite, 0);
        label.setFont(composite.getFont());
        label.setText(WizardMessages.Neuro4jContainerWizardPage_resolved_label);
        label.setLayoutData(new GridData(4, 1, false, false, 1, 1));

        this.fResolvedPath = new Text(composite, 72);
        data = new GridData(4, 4, true, false, 1, 1);
        data.widthHint = converter.convertWidthInCharsToPixels(60);
        this.fResolvedPath.setFont(composite.getFont());
        this.fResolvedPath.setLayoutData(data);

        label = new Label(composite, 0);
        label.setFont(composite.getFont());
        label.setText(WizardMessages.Neuro4jContainerWizardPage_source_location_label);
        label.setLayoutData(new GridData(4, 1, false, false, 1, 1));

        this.fResolvedSourcePath = new Text(composite, 72);
        data = new GridData(4, 4, true, false, 1, 1);
        data.widthHint = converter.convertWidthInCharsToPixels(60);
        this.fResolvedSourcePath.setFont(composite.getFont());
        this.fResolvedSourcePath.setLayoutData(data);

        doSelectionChanged();

        setControl(composite);
    }

    public void setVisible(boolean visible)
    {
        super.setVisible(visible);
        if (visible)
            this.fVersionCombo.setFocus();
    }

    protected void doSelectionChanged()
    {
        Neuro4jStatus status = new Neuro4jStatus();
        IClasspathEntry corelibEntry = null, logicLibEntry = null;
        IPath containerPath = null;

        if ((this.fVersionCombo != null) && (this.fVersionCombo.getSelectionIndex() == 0)) {
            containerPath = Neuro4jCore.NEURO4J_CONTAINER_PATH;
            corelibEntry = BuildPathSupport.getNeuro4jCoreLibraryEntry();
            logicLibEntry = BuildPathSupport.getNeuro4jLogicLibraryEntry();
        }

        if (corelibEntry == null)
            status.setError(WizardMessages.Neuro4jContainerWizardPage_error_version_not_available);
        else if ((Neuro4jCore.NEURO4J_CONTAINER_PATH.equals(containerPath)) &&
                (this.fProject != null) && (!JUnitStubUtility.is50OrHigher(this.fProject))) {
            status.setWarning(WizardMessages.Neuro4jContainerWizardPage_warning_java5_required);
        }

        this.fContainerEntryResult = JavaCore.newContainerEntry(containerPath);

        if ((this.fResolvedPath != null) && (!this.fResolvedPath.isDisposed())) {
            if (corelibEntry != null)
                this.fResolvedPath.setText(getPathLabel(corelibEntry.getPath()) + getPathLabel(logicLibEntry.getPath()));
            else {
                this.fResolvedPath.setText(WizardMessages.Neuro4jContainerWizardPage_lib_not_found);
            }
        }
        if ((this.fResolvedSourcePath != null) && (!this.fResolvedSourcePath.isDisposed())) {
            if ((corelibEntry != null) && (corelibEntry.getSourceAttachmentPath() != null))
                this.fResolvedSourcePath.setText(getPathLabel(corelibEntry.getSourceAttachmentPath()));
            else {

                this.fResolvedSourcePath.setText(WizardMessages.Neuro4jContainerWizardPage_source_not_found);
            }
        }

        updateStatus(status);
    }

    private String getPathLabel(IPath path) {
        StringBuffer buf = new StringBuffer(BasicElementLabels.getResourceName(path.lastSegment()));
        buf.append(JavaElementLabels.CONCAT_STRING);
        buf.append(BasicElementLabels.getPathLabel(path.removeLastSegments(1), true));
        return buf.toString();
    }

    public void initialize(IJavaProject project, IClasspathEntry[] currentEntries)
    {
        this.fProject = project;
    }
}