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
package org.neuro4j.studio.debug.core.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IRequest;
import org.eclipse.debug.core.commands.IDebugCommandHandler;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.internal.core.commands.ResumeCommand;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.commands.actions.ExecuteActionRequest;
import org.eclipse.debug.internal.ui.commands.actions.ICommandParticipant;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.debug.core.IJavaHotCodeReplaceListener;
import org.eclipse.jdt.debug.core.IJavaThreadGroup;
import org.eclipse.jdt.debug.core.IJavaType;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jdt.debug.eval.IAstEvaluationEngine;
import org.eclipse.jdt.internal.debug.core.EventDispatcher;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaBreakpoint;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.debug.core.model.JDIStackFrame;
import org.eclipse.jdt.internal.debug.core.model.JDIThread;
import org.neuro4j.studio.debug.core.BreakpoinMng;

import com.sun.jdi.ReferenceType;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;
import com.sun.jdi.request.ClassPrepareRequest;

public class FlowDebugTarget extends JDIDebugTarget {

    public FlowDebugTarget(ILaunch launch, VirtualMachine jvm, String name,
            boolean supportTerminate, boolean supportDisconnect,
            IProcess process, boolean resume) {
        super(launch, jvm, name, supportTerminate, supportDisconnect, process, resume);

    }

    @SuppressWarnings("restriction")
    private DebugEvent handleEvent(final DebugEvent event)
    {
        // System.out.println("DebugEvent: " + event.getKind() + ", Detail:" + event.getDetail());

        switch (event.getKind()) {
            case DebugEvent.RESUME:

                if (event.getDetail() == DebugEvent.CLIENT_REQUEST)
                {
                    BreakpoinMng.getInstance().setNextStepInProgress(false);
                    return event;
                }
                break;
            case DebugEvent.SUSPEND:

                if (event.getDetail() == DebugEvent.STEP_END)
                {

                    BreakpoinMng.getInstance().resume();

                    Object element = event.getSource();
                    IDebugCommandHandler handler = new ResumeCommand();
                    if (handler != null) {
                        ExecuteActionRequest request = new ExecuteActionRequest(new Object[] { element });

                        request.setCommandParticipant(new ICommandParticipant() {

                            @Override
                            public void requestDone(IRequest irequest) {

                                DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new DebugEvent(event.getSource(), 32, 126) });
                                // BreakpoinMng.getInstance().setNextStepInProgress(true);

                            }
                        });
                        handler.execute(request);
                        BreakpoinMng.getInstance().setNextStepInProgress(true);
                    }

                    // ResumeCommand command = new ResumeCommand();
                    //
                    // delegate.init(Workbench.getInstance().getActiveWorkbenchWindow());
                    // delegate.run(null);
                    // DebugEvent newEvent = new DebugEvent(event.getSource(), DebugEvent.RESUME,
                    // DebugEvent.CLIENT_REQUEST);

                    return event;
                }
                break;
            case DebugEvent.TERMINATE:
                processDisconect();
                break;
            case DebugEvent.CLIENT_REQUEST:
                if (event.getDetail() == 126)
                {
                    // TODO
                    BreakpoinMng.getInstance().setNextStepInProgress(true);
                }
                break;
            default:
                break;
        }

        return event;
    }

    private boolean processCheckIfSuspend(DebugEvent event)
    {
        if (event.getSource() instanceof JDIThread)
        {
            JDIThread thread = (JDIThread) event.getSource();
            try {
                JDIStackFrame sframe = (JDIStackFrame) thread.getTopStackFrame();

                String uuid = BreakpoinMng.getInstance().getCurrentUuid(sframe);

                if (BreakpoinMng.getInstance().isUUIDInBreakpoint(uuid))
                {
                    return true;
                }

            } catch (DebugException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            thread.getBreakpoints();
        }
        return false;
    }

    private void processDisconect()
    {
        BreakpoinMng.getInstance().setCurrentTarget(null);

        BreakpoinMng.getInstance().disconect();

        // TODO: disconect - change color
    }

    @Override
    public void breakpointAdded(IBreakpoint breakpoint) {

        if (breakpoint instanceof ActionNodeBreakpoint)
        {
            addActionNodeBreakpoint((ActionNodeBreakpoint) breakpoint);
        }
        super.breakpointAdded(breakpoint);

    }

    private void addActionNodeBreakpoint(ActionNodeBreakpoint bp)
    {
        bp.connectBreakpoint();

    }

    @Override
    public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
        // TODO Auto-generated method stub
        super.breakpointChanged(breakpoint, delta);
    }

    @Override
    public void breakpointManagerEnablementChanged(boolean enabled) {
        // TODO Auto-generated method stub
        super.breakpointManagerEnablementChanged(enabled);
    }

    @Override
    public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
        // TODO Auto-generated method stub
        super.breakpointRemoved(breakpoint, delta);
    }

    @Override
    public boolean canDisconnect() {
        // TODO Auto-generated method stub
        return super.canDisconnect();
    }

    @Override
    public boolean canPopFrames() {
        // TODO Auto-generated method stub
        return super.canPopFrames();
    }

    @Override
    public boolean canResume() {
        // TODO Auto-generated method stub
        return super.canResume();
    }

    @Override
    public boolean canSuspend() {
        // TODO Auto-generated method stub
        return super.canSuspend();
    }

    @Override
    public boolean canTerminate() {
        // TODO Auto-generated method stub
        return super.canTerminate();
    }

    @Override
    protected void cancelSuspendByBreakpoint(JavaBreakpoint breakpoint)
            throws DebugException {
        // TODO Auto-generated method stub
        super.cancelSuspendByBreakpoint(breakpoint);
    }

    @Override
    protected void cleanup() {
        BreakpoinMng.getInstance().disconect();
        super.cleanup();
    }

    @Override
    public ClassPrepareRequest createClassPrepareRequest(String classPattern,
            String classExclusionPattern, boolean enabled, String sourceName)
            throws CoreException {
        // TODO Auto-generated method stub
        return super.createClassPrepareRequest(classPattern, classExclusionPattern,
                enabled, sourceName);
    }

    @Override
    public ClassPrepareRequest createClassPrepareRequest(String classPattern,
            String classExclusionPattern, boolean enabled) throws CoreException {
        // TODO Auto-generated method stub
        return super.createClassPrepareRequest(classPattern, classExclusionPattern,
                enabled);
    }

    @Override
    public ClassPrepareRequest createClassPrepareRequest(String classPattern,
            String classExclusionPattern) throws CoreException {
        // TODO Auto-generated method stub
        return super.createClassPrepareRequest(classPattern, classExclusionPattern);
    }

    @Override
    public ClassPrepareRequest createClassPrepareRequest(String classPattern)
            throws CoreException {
        // TODO Auto-generated method stub
        return super.createClassPrepareRequest(classPattern);
    }

    @Override
    protected JDIThread createThread(ThreadReference thread) {
        // TODO Auto-generated method stub
        return super.createThread(thread);
    }

    @Override
    protected void disconnected() {
        super.disconnected();
        DebugUIPlugin.getDefault().getPreferenceStore().setValue(IInternalDebugUIConstants.PREF_ACTIVATE_DEBUG_VIEW, Boolean.TRUE);
    }

    @Override
    public JDIThread findThread(ThreadReference tr) {
        // TODO Auto-generated method stub
        return super.findThread(tr);
    }

    @Override
    public IJavaVariable findVariable(String varName) throws DebugException {
        // TODO Auto-generated method stub
        return super.findVariable(varName);
    }

    @Override
    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return super.getAdapter(adapter);
    }

    @Override
    public IJavaThreadGroup[] getAllThreadGroups() throws DebugException {
        // TODO Auto-generated method stub
        return super.getAllThreadGroups();
    }

    @Override
    public List<IBreakpoint> getBreakpoints() {
        // TODO Auto-generated method stub
        return super.getBreakpoints();
    }

    @Override
    protected Integer getCRC(String typeName) throws DebugException {
        // TODO Auto-generated method stub
        return super.getCRC(typeName);
    }

    @Override
    public IDebugTarget getDebugTarget() {
        // TODO Auto-generated method stub
        return super.getDebugTarget();
    }

    @Override
    public String getDefaultStratum() {
        // TODO Auto-generated method stub
        return super.getDefaultStratum();
    }

    @Override
    public IAstEvaluationEngine getEvaluationEngine(IJavaProject project) {
        // TODO Auto-generated method stub
        return super.getEvaluationEngine(project);
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return super.getEventDispatcher();
    }

    @Override
    public Object[] getHotCodeReplaceListeners() {
        // TODO Auto-generated method stub
        return super.getHotCodeReplaceListeners();
    }

    @Override
    public IJavaType[] getJavaTypes(String name) throws DebugException {
        // TODO Auto-generated method stub
        return super.getJavaTypes(name);
    }

    @Override
    public ILaunch getLaunch() {
        // TODO Auto-generated method stub
        return super.getLaunch();
    }

    @Override
    public IMemoryBlock getMemoryBlock(long startAddress, long length)
            throws DebugException {
        // TODO Auto-generated method stub
        return super.getMemoryBlock(startAddress, length);
    }

    @Override
    public String getName() throws DebugException {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public IProcess getProcess() {
        // TODO Auto-generated method stub
        return super.getProcess();
    }

    @Override
    public IJavaThreadGroup[] getRootThreadGroups() throws DebugException {
        // TODO Auto-generated method stub
        return super.getRootThreadGroups();
    }

    @Override
    public String[] getStepFilters() {
        // TODO Auto-generated method stub
        return super.getStepFilters();
    }

    @Override
    protected int getSuspendCount() {
        // TODO Auto-generated method stub
        return super.getSuspendCount();
    }

    @Override
    public IThread[] getThreads() {
        // TODO Auto-generated method stub
        return super.getThreads();
    }

    @Override
    public VirtualMachine getVM() {
        // TODO Auto-generated method stub
        return super.getVM();
    }

    @Override
    public String getVMName() throws DebugException {
        // TODO Auto-generated method stub
        return super.getVMName();
    }

    @Override
    public String getVersion() throws DebugException {
        // TODO Auto-generated method stub
        return super.getVersion();
    }

    @Override
    public void handleDebugEvents(DebugEvent[] events) {
        List<DebugEvent> list = new ArrayList<DebugEvent>(events.length);
        for (DebugEvent event : events)
        {

            DebugEvent e = handleEvent(event);
            // events[0] = e;
            list.add(e);
        }

        super.handleDebugEvents(list.toArray(new DebugEvent[list.size()]));

    }

    @Override
    public void handleVMDeath(VMDeathEvent event) {
        // TODO Auto-generated method stub
        super.handleVMDeath(event);
    }

    @Override
    public void handleVMDisconnect(VMDisconnectEvent event) {
        // TODO Auto-generated method stub
        super.handleVMDisconnect(event);

    }

    @Override
    public void handleVMStart(VMStartEvent event) {
        // TODO Auto-generated method stub
        super.handleVMStart(event);
    }

    @Override
    public boolean hasHCRFailed() {
        // TODO Auto-generated method stub
        return super.hasHCRFailed();
    }

    @Override
    public boolean hasHCROccurred() {
        // TODO Auto-generated method stub
        return super.hasHCROccurred();
    }

    @Override
    public boolean hasThreads() {
        // TODO Auto-generated method stub
        return super.hasThreads();
    }

    @Override
    protected void incrementSuspendCount(int eventDetail) {
        // TODO Auto-generated method stub
        super.incrementSuspendCount(eventDetail);
    }

    @Override
    protected synchronized void initialize() {
        // TODO Auto-generated method stub
        super.initialize();

        // eventDispatcher = new MEventDispatcher(this);
    }

    @Override
    protected void initializeBreakpoints() {
        // IMarker[] markers =
        // DebugPlugin.getDefault().getBreakpointManager().getPersistedMarkers(ResourcesPlugin.getWorkspace().getRoot(),
        // false);
        BreakpoinMng.getInstance().unregisterUUIDs();
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints();
        Set<String> allBreakPoints = FlowBreakpointFactory.getInitBreakpoins();
        for (int i = 0; i < breakpoints.length; i++) {
            IBreakpoint bp = breakpoints[i];
            if (bp instanceof JavaLineBreakpoint)
            {
                JavaLineBreakpoint jlb = (JavaLineBreakpoint) bp;
                try {
                    if (jlb.getMarker().getAttribute("flowType") == null) {
                        continue;
                    }
                    FlowLineBreakpoint b = new ActionNodeBreakpoint(jlb);
                    allBreakPoints.remove(b.getMarker().getResource().getName());
                    breakpointAdded(b);
                } catch (CoreException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        for (String name : allBreakPoints)
        {
            JavaLineBreakpoint bp = FlowBreakpointFactory.createInitBreakpointByName(name);
            breakpointAdded(bp);
        }

    }

    @Override
    protected void initializeState() {
        // TODO Auto-generated method stub
        super.initializeState();
    }

    @Override
    public boolean isAvailable() {
        // TODO Auto-generated method stub
        return super.isAvailable();
    }

    @Override
    public boolean isDisconnected() {
        // TODO Auto-generated method stub
        return super.isDisconnected();
    }

    @Override
    public boolean isFilterConstructors() {
        // TODO Auto-generated method stub
        return super.isFilterConstructors();
    }

    @Override
    public boolean isFilterGetters() {
        // TODO Auto-generated method stub
        return super.isFilterGetters();
    }

    @Override
    public boolean isFilterSetters() {
        // TODO Auto-generated method stub
        return super.isFilterSetters();
    }

    @Override
    public boolean isFilterStaticInitializers() {
        // TODO Auto-generated method stub
        return super.isFilterStaticInitializers();
    }

    @Override
    public boolean isFilterSynthetics() {
        // TODO Auto-generated method stub
        return super.isFilterSynthetics();
    }

    @Override
    public boolean isOutOfSynch() throws DebugException {
        // TODO Auto-generated method stub
        return super.isOutOfSynch();
    }

    @Override
    public boolean isOutOfSynch(String qualifiedName) {
        // TODO Auto-generated method stub
        return super.isOutOfSynch(qualifiedName);
    }

    @Override
    public boolean isPerformingHotCodeReplace() {
        // TODO Auto-generated method stub
        return super.isPerformingHotCodeReplace();
    }

    @Override
    protected synchronized boolean isResumeOnStartup() {
        // TODO Auto-generated method stub
        return super.isResumeOnStartup();
    }

    @Override
    public boolean isStepFiltersEnabled() {
        // TODO Auto-generated method stub
        return super.isStepFiltersEnabled();
    }

    @Override
    public boolean isStepThruFilters() {
        // TODO Auto-generated method stub
        return super.isStepThruFilters();
    }

    @Override
    public boolean isSuspended() {
        // TODO Auto-generated method stub
        return super.isSuspended();
    }

    @Override
    public boolean isTerminated() {
        // TODO Auto-generated method stub
        return super.isTerminated();
    }

    @Override
    protected boolean isTerminating() {
        // TODO Auto-generated method stub
        return super.isTerminating();
    }

    @Override
    public List<ReferenceType> jdiClassesByName(String className) {
        // TODO Auto-generated method stub
        return super.jdiClassesByName(className);
    }

    @Override
    public void removeHotCodeReplaceListener(
            IJavaHotCodeReplaceListener listener) {
        // TODO Auto-generated method stub
        super.removeHotCodeReplaceListener(listener);
    }

    @Override
    public void removeOutOfSynchTypes(List<String> qualifiedNames) {
        // TODO Auto-generated method stub
        super.removeOutOfSynchTypes(qualifiedNames);
    }

    @Override
    public void resume() throws DebugException {
        super.resume();
        BreakpoinMng.getInstance().resume();
    }

    @Override
    protected void resume(boolean fireNotification) throws DebugException {
        // TODO Auto-generated method stub
        super.resume(fireNotification);
    }

    @Override
    public void resumeQuiet() throws DebugException {
        // TODO Auto-generated method stub
        super.resumeQuiet();
    }

    @Override
    protected void resumeThreads() throws DebugException {
        // TODO Auto-generated method stub
        super.resumeThreads();
    }

    @Override
    public byte[] sendCommand(byte commandSet, byte commandId, byte[] data)
            throws DebugException {
        // TODO Auto-generated method stub
        return super.sendCommand(commandSet, commandId, data);
    }

    @Override
    public byte[] sendJDWPCommand(byte commandSet, byte commandId, byte[] data)
            throws IOException {
        // TODO Auto-generated method stub
        return super.sendJDWPCommand(commandSet, commandId, data);
    }

    @Override
    public void setDefaultStratum(String stratum) {
        // TODO Auto-generated method stub
        super.setDefaultStratum(stratum);
    }

    @Override
    protected void setDisconnected(boolean disconnected) {
        // TODO Auto-generated method stub
        super.setDisconnected(disconnected);
    }

    @Override
    public void setFilterConstructors(boolean filter) {
        // TODO Auto-generated method stub
        super.setFilterConstructors(filter);
    }

    @Override
    public void setFilterGetters(boolean filter) {
        // TODO Auto-generated method stub
        super.setFilterGetters(filter);
    }

    @Override
    public void setFilterSetters(boolean filter) {
        // TODO Auto-generated method stub
        super.setFilterSetters(filter);
    }

    @Override
    public void setFilterStaticInitializers(boolean filter) {
        // TODO Auto-generated method stub
        super.setFilterStaticInitializers(filter);
    }

    @Override
    public void setFilterSynthetics(boolean filter) {
        // TODO Auto-generated method stub
        super.setFilterSynthetics(filter);
    }

    @Override
    public void setHCROccurred(boolean occurred) {
        // TODO Auto-generated method stub
        super.setHCROccurred(occurred);
    }

    @Override
    public void setIsPerformingHotCodeReplace(boolean isPerformingHotCodeReplace) {
        // TODO Auto-generated method stub
        super.setIsPerformingHotCodeReplace(isPerformingHotCodeReplace);
    }

    @Override
    protected void setName(String name) {
        // TODO Auto-generated method stub
        super.setName(name);
    }

    @Override
    protected void setProcess(IProcess process) {
        // TODO Auto-generated method stub
        super.setProcess(process);
    }

    @Override
    public void setStepFilters(String[] list) {
        // TODO Auto-generated method stub
        super.setStepFilters(list);
    }

    @Override
    public void setStepFiltersEnabled(boolean enabled) {
        // TODO Auto-generated method stub
        super.setStepFiltersEnabled(enabled);
    }

    @Override
    public void setStepThruFilters(boolean thru) {
        // TODO Auto-generated method stub
        super.setStepThruFilters(thru);
    }

    @Override
    protected void setTerminated(boolean terminated) {
        // TODO Auto-generated method stub
        super.setTerminated(terminated);
    }

    @Override
    protected void setTerminating(boolean terminating) {
        // TODO Auto-generated method stub
        super.setTerminating(terminating);
    }

    @Override
    protected void suspendedByBreakpoint(JavaBreakpoint breakpoint,
            boolean queueEvent, EventSet set) {
        // TODO Auto-generated method stub
        super.suspendedByBreakpoint(breakpoint, queueEvent, set);
    }

    @Override
    public void terminate() throws DebugException {
        BreakpoinMng.getInstance().setCurrentTarget(null);
        super.terminate();
    }

}
