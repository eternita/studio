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
package org.neuro4j.studio.core.diagram.wizards.customblock;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.actions.WorkbenchRunnableAdapter;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

/**
 * This is a sample new wizard. Its role is to create a new file
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "java". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class CustomBlockNewWizard extends Wizard implements INewWizard {
    private IWorkbench fWorkbench;
    protected IStructuredSelection fSelection;
    protected CustomBlockNewWizardPage page;
    protected CustomBlockParametersWizardPage parameterPage;

    private boolean fOpenEditorOnFinish = true;

    /**
     * Constructor for CustomBlockNewWizard.
     */
    public CustomBlockNewWizard() {
        super();
        setNeedsProgressMonitor(true);

    }

    /**
     * Adding the page to the wizard.
     */

    public void addPages() {
        page = new CustomBlockNewWizardPage(fSelection);
        addPage(page);
        this.page.init(fSelection);

        parameterPage = new CustomBlockParametersWizardPage(page.getJavaProject());
        addPage(parameterPage);
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        IWorkspaceRunnable op = new IWorkspaceRunnable() {
            public void run(final IProgressMonitor monitor) throws CoreException, OperationCanceledException {

                Display.getDefault().syncExec(new Runnable() {
                    public void run() {
                        try {
                            finishPage(monitor);

                        } catch (InterruptedException e) {
                            throw new OperationCanceledException(e.getMessage());

                        } catch (CoreException e) {
                            MessageDialog dialog = new MessageDialog(fWorkbench.getActiveWorkbenchWindow().getShell(), "Error", null,
                                    e.getMessage(), MessageDialog.ERROR, new String[] { }, 0);
                            int result = dialog.open();
                            throw new OperationCanceledException(e.getMessage());
                        }
                    }
                });

            }
        };
        try {
            ISchedulingRule rule = null;
            Job job = Job.getJobManager().currentJob();
            if (job != null)
                rule = job.getRule();
            IRunnableWithProgress runnable = null;
            if (rule != null)
                runnable = new WorkbenchRunnableAdapter(op, rule, true);
            else
                runnable = new WorkbenchRunnableAdapter(op, getSchedulingRule());
            getContainer().run(true, true, runnable);
        } catch (InvocationTargetException e) {
            handleFinishException(getShell(), e);
            return false;
        } catch (InterruptedException e) {
            return false;
        }
        boolean res = true;
        if (res)
        {
            IResource resource = this.page.getModifiedResource();
            if (resource != null) {
                selectAndReveal(resource);
                if (this.fOpenEditorOnFinish) {
                    openResource((IFile) resource);
                }
            }
        }
        return res;
    }

    protected ISchedulingRule getSchedulingRule() {
        return ResourcesPlugin.getWorkspace().getRoot(); // look all by default
    }

    protected void finishPage(IProgressMonitor monitor)
            throws InterruptedException, CoreException {
        Map<String, String> parameters = new HashMap<String, String>();
        this.parameterPage.processParameters(parameters);
        this.page.createType(monitor, parameters);

    }

    /**
     * The worker method. It will find the container, create the
     * file if missing or just replace its contents, and open
     * the editor on the newly created file.
     */

    private void throwCoreException(String message) throws CoreException {
        IStatus status =
                new Status(IStatus.ERROR, "org.neuro4j.studio.core.diagram", IStatus.OK, message, null);
        throw new CoreException(status);
    }

    /**
     * We will accept the selection in the workbench to see if
     * we can initialize from it.
     * 
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
        fWorkbench = workbench;
        fSelection = currentSelection;
    }

    protected void openResource(final IFile resource) {
        final IWorkbenchPage activePage = JavaPlugin.getActivePage();
        if (activePage != null) {
            final Display display = getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    public void run() {
                        try {
                            IDE.openEditor(activePage, resource, true);
                        } catch (PartInitException e) {
                            JavaPlugin.log(e);
                        }
                    }
                });
            }
        }
    }

    protected void selectAndReveal(IResource newResource) {
        BasicNewResourceWizard.selectAndReveal(newResource, fWorkbench.getActiveWorkbenchWindow());
    }

    protected void handleFinishException(Shell shell, InvocationTargetException e) {
        String title = NewWizardMessages.NewElementWizard_op_error_title;
        String message = NewWizardMessages.NewElementWizard_op_error_message;
        ExceptionHandler.handle(e, shell, title, message);
    }

}