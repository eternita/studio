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
package org.neuro4j.studio.debug.core;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.ui.contexts.ISuspendTrigger;
import org.eclipse.jdi.Bootstrap;
import org.eclipse.jdi.TimeoutException;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMConnector;
import org.eclipse.osgi.util.NLS;
import org.neuro4j.studio.debug.context.SuspendTrigger;
import org.neuro4j.studio.debug.core.launching.LaunchingMessages;
import org.neuro4j.studio.debug.core.model.FlowDebugTarget;

import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;

public class FlowSocketAttachConnector implements IVMConnector
{
    protected static AttachingConnector getAttachingConnector()
            throws CoreException
    {
        AttachingConnector connector = null;
        Iterator iter = Bootstrap.virtualMachineManager().attachingConnectors().iterator();
        while (iter.hasNext()) {
            AttachingConnector lc = (AttachingConnector) iter.next();
            if (lc.name().equals("com.sun.jdi.SocketAttach")) {
                connector = lc;
                break;
            }
        }
        if (connector == null) {
            abort(LaunchingMessages.SocketAttachConnector_Socket_attaching_connector_not_available_3, null, 114);
        }
        return connector;
    }

    public String getIdentifier()
    {
        return IJavaLaunchConfigurationConstants.ID_SOCKET_ATTACH_VM_CONNECTOR;
    }

    public String getName()
    {
        return LaunchingMessages.SocketAttachConnector_Standard__Socket_Attach__4;
    }

    protected static void abort(String message, Throwable exception, int code)
            throws CoreException
    {
        throw new CoreException(new Status(4, DebugExamplesPlugin.getID(), code, message, exception));
    }

    public void connect(Map<String, String> arguments, IProgressMonitor monitor, ILaunch launch)
            throws CoreException
    {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        IProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
        subMonitor.beginTask(LaunchingMessages.SocketAttachConnector_Connecting____1, 2);
        subMonitor.subTask(LaunchingMessages.SocketAttachConnector_Configuring_connection____1);

        AttachingConnector connector = getAttachingConnector();
        String portNumberString = (String) arguments.get("port");
        if (portNumberString == null) {
            abort(LaunchingMessages.SocketAttachConnector_Port_unspecified_for_remote_connection__2, null, 111);
        }
        String host = (String) arguments.get("hostname");
        if (host == null) {
            abort(LaunchingMessages.SocketAttachConnector_Hostname_unspecified_for_remote_connection__4, null, 109);
        }
        Map map = connector.defaultArguments();

        Connector.Argument param = (Connector.Argument) map.get("hostname");
        param.setValue(host);
        param = (Connector.Argument) map.get("port");
        param.setValue(portNumberString);

        String timeoutString = (String) arguments.get("timeout");
        if (timeoutString != null) {
            param = (Connector.Argument) map.get("timeout");
            param.setValue(timeoutString);
        }

        ILaunchConfiguration configuration = launch.getLaunchConfiguration();
        boolean allowTerminate = false;
        if (configuration != null) {
            allowTerminate = configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_ALLOW_TERMINATE, false);
        }
        subMonitor.worked(1);
        subMonitor.subTask(LaunchingMessages.SocketAttachConnector_Establishing_connection____2);
        try {
            VirtualMachine vm = connector.attach(map);
            String vmLabel = constructVMLabel(vm, host, portNumberString, configuration);
            // IDebugTarget debugTarget = JDIDebugModel.newDebugTarget(launch, vm, vmLabel, null, allowTerminate, true);
            IDebugTarget debugTarget = new FlowDebugTarget(launch, vm, vmLabel, allowTerminate, true, null, true);
            // int eventPort = findFreePort();
            // IDebugTarget debugTarget = new PDADebugTarget(launch, null, 8888, int eventPort);
            launch.addDebugTarget(debugTarget);

            addSuspendListener(launch);

            BreakpoinMng.getInstance().setCurrentTarget(debugTarget);
            subMonitor.worked(1);
            subMonitor.done();
        } catch (TimeoutException e) {
            abort(LaunchingMessages.SocketAttachConnector_0, e, 113);
        } catch (UnknownHostException e) {
            abort(NLS.bind(LaunchingMessages.SocketAttachConnector_Failed_to_connect_to_remote_VM_because_of_unknown_host____0___1, new String[] { host }), e, 113);
        } catch (ConnectException e) {
            abort(LaunchingMessages.SocketAttachConnector_Failed_to_connect_to_remote_VM_as_connection_was_refused_2, e, 113);
        } catch (IOException e) {
            abort(LaunchingMessages.SocketAttachConnector_Failed_to_connect_to_remote_VM_1, e, 113);
        } catch (IllegalConnectorArgumentsException e) {
            abort(LaunchingMessages.SocketAttachConnector_Failed_to_connect_to_remote_VM_1, e, 113);
        }
    }

    public static int findFreePort() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(0);
            return socket.getLocalPort();
        } catch (IOException e) {
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
        return -1;
    }

    private void addSuspendListener(ILaunch launch)
    {
        ISuspendTrigger trigger = (ISuspendTrigger) launch.getAdapter(ISuspendTrigger.class);
        if (trigger != null) {
            trigger.addSuspendTriggerListener(new SuspendTrigger());
        }

        DebugUIPlugin.getDefault().getPreferenceStore().setValue(IInternalDebugUIConstants.PREF_ACTIVATE_DEBUG_VIEW, Boolean.FALSE);
    }

    protected String constructVMLabel(VirtualMachine vm, String host, String port, ILaunchConfiguration configuration)
    {
        String name = null;
        try {
            name = vm.name();
        } catch (TimeoutException localTimeoutException) {
        } catch (VMDisconnectedException localVMDisconnectedException) {
        }
        if (name == null) {
            if (configuration == null)
                name = "";
            else {
                name = configuration.getName();
            }
        }
        StringBuffer buffer = new StringBuffer(name);
        buffer.append('[');
        buffer.append(host);
        buffer.append(':');
        buffer.append(port);
        buffer.append(']');
        return buffer.toString();
    }

    public Map<String, Connector.Argument> getDefaultArguments()
            throws CoreException
    {
        Map def = getAttachingConnector().defaultArguments();
        Connector.IntegerArgument arg = (Connector.IntegerArgument) def.get("port");
        arg.setValue(8000);
        return def;
    }

    public List<String> getArgumentOrder()
    {
        List list = new ArrayList(2);
        list.add("hostname");
        list.add("port");
        return list;
    }
}