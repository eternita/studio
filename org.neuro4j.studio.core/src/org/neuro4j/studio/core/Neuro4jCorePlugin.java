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
package org.neuro4j.studio.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Neuro4jCorePlugin extends AbstractUIPlugin {

    private static Neuro4jCorePlugin plugin;
    private BundleContext fBundleContext;

    /**
     * Constructor.
     */
    public Neuro4jCorePlugin() {
        super();
        plugin = this;
    }

    /**
     * Get one instance of MSL plugin.
     */
    public static Neuro4jCorePlugin getDefault() {
        return plugin;
    }

    /**
     * Get plugin ID.
     */
    public static String getPluginId() {
        return getDefault().getBundle().getSymbolicName();
    }

    public void start(BundleContext context) throws Exception {
        plugin = this;
        super.start(context);
        this.fBundleContext = context;
    }

    public void stop(BundleContext context) throws Exception {
        super.stop(context);

        this.fBundleContext = null;
    }

    public static void logErrorMessage(String message, Throwable exception) {
        getDefault().getLog().log(new Status(IStatus.ERROR, getPluginId(), 1, message,
                        exception));
    }

    public static void logMessage(String message) {
        getDefault().getLog().log(new Status(IStatus.INFO, getPluginId(), message));
    }
    
    public static void log(Throwable e) {
        log(new Status(4, getPluginId(), 4, "Error", e));
    }

    public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }

    public Object getService(String serviceName) {
        ServiceReference reference = this.fBundleContext
                .getServiceReference(serviceName);
        if (reference == null)
            return null;
        return this.fBundleContext.getService(reference);
    }

    public static Shell getActiveWorkbenchShell() {
        IWorkbenchWindow workBenchWindow = getActiveWorkbenchWindow();
        if (workBenchWindow == null)
            return null;
        return workBenchWindow.getShell();
    }

    public static IWorkbenchWindow getActiveWorkbenchWindow()
    {
        if (plugin == null)
            return null;
        IWorkbench workBench = plugin.getWorkbench();
        if (workBench == null)
            return null;
        return workBench.getActiveWorkbenchWindow();
    }

}
