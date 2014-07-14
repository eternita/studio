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
package org.neuro4j.studio.debug.core.launching;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.jdt.launching.AbstractJavaLaunchConfigurationDelegate;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMConnector;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.osgi.util.NLS;
import org.neuro4j.studio.debug.core.FlowSocketAttachConnector;

/**
 * Launches PDA program on a PDA interpretter written in Perl
 */

public class FlowLaunchDelegate extends AbstractJavaLaunchConfigurationDelegate {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.
     * eclipse.debug.core.ILaunchConfiguration, java.lang.String,
     * org.eclipse.debug.core.ILaunch,
     * org.eclipse.core.runtime.IProgressMonitor)
     */
    public void launch(ILaunchConfiguration configuration, String mode,
            ILaunch launch, IProgressMonitor monitor) throws CoreException {

        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        monitor.beginTask(
                NLS.bind(
                        LaunchingMessages.JavaRemoteApplicationLaunchConfigurationDelegate_Attaching_to__0_____1,
                        new String[] { configuration.getName() }), 3);
        // check for cancellation
        if (monitor.isCanceled()) {
            return;
        }
        try {
            monitor.subTask(LaunchingMessages.JavaRemoteApplicationLaunchConfigurationDelegate_Verifying_launch_attributes____1);

            String connectorId = getVMConnectorId(configuration);
            IVMConnector connector = new FlowSocketAttachConnector();
            // if (connectorId == null) {
            // connector = JavaRuntime.getDefaultVMConnector();
            // } else {
            // connector = JavaRuntime.getVMConnector(connectorId);
            // }
            if (connector == null) {
                abort(LaunchingMessages.JavaRemoteApplicationLaunchConfigurationDelegate_Connector_not_specified_2,
                        null,
                        IJavaLaunchConfigurationConstants.ERR_CONNECTOR_NOT_AVAILABLE);
            }

            Map<String, String> argMap = configuration.getAttribute(
                    IJavaLaunchConfigurationConstants.ATTR_CONNECT_MAP,
                    (Map<String, String>) null);

            int connectTimeout = Platform.getPreferencesService().getInt(
                    "org.eclipse.jdt.launching",
                    JavaRuntime.PREF_CONNECT_TIMEOUT, 20000, null);
            argMap.put("timeout", Integer.toString(connectTimeout)); //$NON-NLS-1$

            // check for cancellation
            if (monitor.isCanceled()) {
                return;
            }

            monitor.worked(1);

            monitor.subTask(LaunchingMessages.JavaRemoteApplicationLaunchConfigurationDelegate_Creating_source_locator____2);
            // set the default source locator if required
            setDefaultSourceLocator(launch, configuration);

            monitor.worked(1);

            // connect to remote VM
            connector.connect(argMap, monitor, launch);
            IDebugTarget[] debugTarget1s = launch.getDebugTargets();
            for (int i = 0; i < debugTarget1s.length; i++) {
                IDebugTarget target = debugTarget1s[i];
                System.out.println(target.getName());
            }

            // IDebugTarget target = new PDADebugTarget(launch,
            // launch.addDebugTarget(target);

            // check for cancellation
            if (monitor.isCanceled()) {
                IDebugTarget[] debugTargets = launch.getDebugTargets();
                for (int i = 0; i < debugTargets.length; i++) {
                    IDebugTarget target = debugTargets[i];
                    if (target.canDisconnect()) {
                        target.disconnect();
                    }
                }
                return;
            }
        } finally {
            monitor.done();
        }
    }

}
