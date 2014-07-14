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
package org.neuro4j.studio.debug.context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationsMessages;
import org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;
import org.eclipse.debug.internal.ui.views.ViewContextManager;
import org.eclipse.debug.internal.ui.views.ViewContextService;
import org.eclipse.debug.ui.contexts.ISuspendTriggerListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class SuspendTrigger implements ISuspendTriggerListener {

    @Override
    public void suspended(ILaunch launch, Object arg1) {

        String perspectiveId = "org.neuro4j.studio.debug.ui.model.DebugPerspective";

        final String targetId = perspectiveId;
        Job switchJob = new MyUIJob("Perspective Switch Job") { //$NON-NLS-1$
            @SuppressWarnings("restriction")
            public IStatus runInUIThread(IProgressMonitor monitor) {
                IWorkbenchWindow window = null;
                if (targetId != null) {
                    // get the window to open the perspective in
                    window = getWindowForPerspective(targetId);
                    if (window == null) {
                        return Status.OK_STATUS;
                    }

                }
                if (window != null) {
                    ViewContextService service = ViewContextManager.getDefault().getService(window);
                    service.showViewQuiet("org.neuro4j.studio.debug.ui.DebugView");
                }
                return Status.OK_STATUS;
            }
        };

        switchJob.setSystem(true);
        switchJob.setPriority(Job.INTERACTIVE);
        switchJob.setRule(AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(this));
        switchJob.schedule();
    }

    private IWorkbenchWindow getWindowForPerspective(String perspectiveId) {
        IWorkbenchWindow window = DebugUIPlugin.getActiveWorkbenchWindow();
        if (isWindowShowingPerspective(window, perspectiveId)) {
            return window;
        }
        IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
        for (int i = 0; i < windows.length; i++) {
            window = windows[i];
            if (isWindowShowingPerspective(window, perspectiveId)) {
                return window;
            }
        }
        window = DebugUIPlugin.getActiveWorkbenchWindow();
        if (window != null) {
            return window;
        }
        if (windows.length > 0) {
            return windows[0];
        }
        return null;
    }

    private boolean isWindowShowingPerspective(IWorkbenchWindow window, String perspectiveId) {
        if (window != null) {
            IWorkbenchPage page = window.getActivePage();
            if (page != null) {
                IPerspectiveDescriptor perspectiveDescriptor = page.getPerspective();
                if (perspectiveDescriptor != null && perspectiveDescriptor.getId().equals(perspectiveId)) {
                    return true;
                }
            }
        }
        return false;
    }

    private abstract class MyUIJob extends Job {
        public MyUIJob(String name) {
            super(name);
            setSystem(true);
            setPriority(Job.INTERACTIVE);
            setRule(AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(this));
        }

        protected IStatus run(final IProgressMonitor monitor) {
            if (monitor.isCanceled()) {
                return Status.CANCEL_STATUS;
            }
            Display asyncDisplay = DebugUIPlugin.getStandardDisplay();
            if (asyncDisplay == null || asyncDisplay.isDisposed()) {
                return Status.CANCEL_STATUS;
            }
            asyncDisplay.asyncExec(new Runnable() {
                public void run() {
                    IStatus result = null;
                    Throwable throwable = null;
                    try {
                        if (monitor.isCanceled()) {
                            result = Status.CANCEL_STATUS;
                        } else {
                            result = runInUIThread(monitor);
                        }

                    } catch (Throwable t) {
                        throwable = t;
                    } finally {
                        if (result == null) {
                            result = new Status(IStatus.ERROR,
                                    PlatformUI.PLUGIN_ID, IStatus.ERROR,
                                    LaunchConfigurationsMessages.PerspectiveManager_Error_1,
                                    throwable);
                        }
                        done(result);
                    }
                }
            });
            return Job.ASYNC_FINISH;
        }

        public abstract IStatus runInUIThread(IProgressMonitor monitor);

    }

}