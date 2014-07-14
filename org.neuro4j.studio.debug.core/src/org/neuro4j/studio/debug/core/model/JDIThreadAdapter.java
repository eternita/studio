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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.jdt.debug.core.IEvaluationRunnable;
import org.eclipse.jdt.debug.core.IJavaObject;
import org.eclipse.jdt.debug.core.IJavaStackFrame;
import org.eclipse.jdt.debug.core.IJavaThread;
import org.eclipse.jdt.debug.core.IJavaThreadGroup;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jdt.internal.debug.core.IJDIEventListener;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaBreakpoint;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugElement;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.debug.core.model.JDIThread;

import com.sun.jdi.ThreadReference;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

public class JDIThreadAdapter extends JDIDebugElement implements IJavaThread {

    JDIThread adapter = null;

    public JDIThreadAdapter(JDIThread thread)
    {
        super((JDIDebugTarget) thread.getDebugTarget());
        this.adapter = thread;
    }

    public void addJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        adapter.addJDIEventListener(listener, request);
    }

    public boolean canDisconnect() {
        return adapter.canDisconnect();
    }

    public boolean canResume() {
        return adapter.canResume();
    }

    public boolean canStepInto() {
        return adapter.canStepInto();
    }

    public boolean canStepOver() {
        return adapter.canStepOver();
    }

    public boolean canStepReturn() {
        return adapter.canStepReturn();
    }

    public boolean canStepWithFilters() {
        return adapter.canStepWithFilters();
    }

    public boolean canSuspend() {
        return adapter.canSuspend();
    }

    public boolean canTerminate() {
        return adapter.canTerminate();
    }

    public boolean canTerminateEvaluation() {
        return adapter.canTerminateEvaluation();
    }

    public void completeBreakpointHandling(JavaBreakpoint breakpoint,
            boolean suspend, boolean queue, EventSet set) {
        adapter.completeBreakpointHandling(breakpoint, suspend, queue, set);
    }

    public List<IJavaStackFrame> computeNewStackFrames() throws DebugException {
        return adapter.computeNewStackFrames();
    }

    public List<IJavaStackFrame> computeStackFrames() throws DebugException {
        return adapter.computeStackFrames();
    }

    public void disconnect() throws DebugException {
        adapter.disconnect();
    }

    public boolean equals(Object arg0) {
        return adapter.equals(arg0);
    }

    public IJavaVariable findVariable(String varName) throws DebugException {
        return adapter.findVariable(varName);
    }

    public void fireChangeEvent(int detail) {
        adapter.fireChangeEvent(detail);
    }

    public void fireCreationEvent() {
        adapter.fireCreationEvent();
    }

    public void fireEvent(DebugEvent event) {
        adapter.fireEvent(event);
    }

    public void fireResumeEvent(int detail) {
        adapter.fireResumeEvent(detail);
    }

    public void fireSuspendEvent(int detail) {
        adapter.fireSuspendEvent(detail);
    }

    public void fireTerminateEvent() {
        adapter.fireTerminateEvent();
    }

    public Object getAdapter(Class adapter1) {
        return adapter.getAdapter(adapter1);
    }

    public IBreakpoint[] getBreakpoints() {
        return adapter.getBreakpoints();
    }

    public IJavaObject getContendedMonitor() throws DebugException {
        return adapter.getContendedMonitor();
    }

    public IDebugTarget getDebugTarget() {
        return adapter.getDebugTarget();
    }

    public EventRequestManager getEventRequestManager() {
        return adapter.getEventRequestManager();
    }

    public int getFrameCount() throws DebugException {
        return adapter.getFrameCount();
    }

    public JDIDebugTarget getJavaDebugTarget() {
        return adapter.getJavaDebugTarget();
    }

    public ILaunch getLaunch() {
        return adapter.getLaunch();
    }

    public String getModelIdentifier() {
        return adapter.getModelIdentifier();
    }

    public String getName() throws DebugException {
        return adapter.getName();
    }

    public IJavaObject[] getOwnedMonitors() throws DebugException {
        return adapter.getOwnedMonitors();
    }

    public int getPriority() throws DebugException {
        return adapter.getPriority();
    }

    public int getRequestTimeout() {
        return adapter.getRequestTimeout();
    }

    public IStackFrame[] getStackFrames() throws DebugException {
        return adapter.getStackFrames();
    }

    public IJavaThreadGroup getThreadGroup() throws DebugException {
        return adapter.getThreadGroup();
    }

    public String getThreadGroupName() throws DebugException {
        return adapter.getThreadGroupName();
    }

    public IJavaObject getThreadObject() throws DebugException {
        return adapter.getThreadObject();
    }

    public ISchedulingRule getThreadRule() {
        return adapter.getThreadRule();
    }

    public IStackFrame getTopStackFrame() throws DebugException {
        return adapter.getTopStackFrame();
    }

    public ThreadReference getUnderlyingThread() {
        return adapter.getUnderlyingThread();
    }

    public boolean handleSuspendForBreakpoint(JavaBreakpoint breakpoint,
            boolean suspendVote) {
        return adapter.handleSuspendForBreakpoint(breakpoint, suspendVote);
    }

    public boolean hasClientRequestedSuspend() {
        return adapter.hasClientRequestedSuspend();
    }

    public boolean hasOwnedMonitors() throws DebugException {
        return adapter.hasOwnedMonitors();
    }

    public boolean hasStackFrames() throws DebugException {
        return adapter.hasStackFrames();
    }

    public int hashCode() {
        return adapter.hashCode();
    }

    public void internalError(RuntimeException e) {
        adapter.internalError(e);
    }

    public boolean isDaemon() throws DebugException {
        return adapter.isDaemon();
    }

    public boolean isDisconnected() {
        return adapter.isDisconnected();
    }

    public boolean isIgnoringBreakpoints() {
        return adapter.isIgnoringBreakpoints();
    }

    public boolean isInvokingMethod() {
        return adapter.isInvokingMethod();
    }

    public boolean isOutOfSynch() throws DebugException {
        return adapter.isOutOfSynch();
    }

    public boolean isPerformingEvaluation() {
        return adapter.isPerformingEvaluation();
    }

    public boolean isStepFiltersEnabled() {
        return adapter.isStepFiltersEnabled();
    }

    public boolean isStepping() {
        return adapter.isStepping();
    }

    public boolean isSuspendVoteInProgress() {
        return adapter.isSuspendVoteInProgress();
    }

    public boolean isSuspended() {
        return adapter.isSuspended();
    }

    public boolean isSystemThread() {
        return adapter.isSystemThread();
    }

    public boolean isTerminated() {
        return adapter.isTerminated();
    }

    public boolean isUnderlyingThreadSuspended() {
        return adapter.isUnderlyingThreadSuspended();
    }

    public void jdiRequestFailed(String message, Throwable e)
            throws DebugException {
        adapter.jdiRequestFailed(message, e);
    }

    public boolean mayBeOutOfSynch() {
        return adapter.mayBeOutOfSynch();
    }

    public void notSupported(String message) throws DebugException {
        adapter.notSupported(message);
    }

    public void queueEvent(DebugEvent event, EventSet set) {
        adapter.queueEvent(event, set);
    }

    public void queueRunnable(Runnable evaluation) {
        adapter.queueRunnable(evaluation);
    }

    public void queueSuspendEvent(int detail, EventSet set) {
        adapter.queueSuspendEvent(detail, set);
    }

    public void removeJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        adapter.removeJDIEventListener(listener, request);
    }

    public void requestFailed(String message, Exception e)
            throws DebugException {
        adapter.requestFailed(message, e);
    }

    public void requestFailed(String message, Throwable e, int code)
            throws DebugException {
        adapter.requestFailed(message, e, code);
    }

    public void resume() throws DebugException {
        adapter.resume();
    }

    public void resumedFromClassPrepare() {
        adapter.resumedFromClassPrepare();
    }

    public void runEvaluation(IEvaluationRunnable evaluation,
            IProgressMonitor monitor, int evaluationDetail,
            boolean hitBreakpoints) throws DebugException {
        adapter.runEvaluation(evaluation, monitor, evaluationDetail,
                hitBreakpoints);
    }

    public void setRequestTimeout(int timeout) {
        adapter.setRequestTimeout(timeout);
    }

    public void stepInto() throws DebugException {
        adapter.stepInto();
    }

    public void stepOver() throws DebugException {
        adapter.stepOver();
    }

    public void stepReturn() throws DebugException {
        adapter.stepReturn();
    }

    public void stepWithFilters() throws DebugException {
        adapter.stepWithFilters();
    }

    public void stop(IJavaObject exception) throws DebugException {
        adapter.stop(exception);
    }

    public boolean supportsRequestTimeout() {
        return adapter.supportsRequestTimeout();
    }

    public void suspend() throws DebugException {
        adapter.suspend();
    }

    public void targetRequestFailed(String message, RuntimeException e)
            throws DebugException {
        adapter.targetRequestFailed(message, e);
    }

    public void targetRequestFailed(String message, Throwable e)
            throws DebugException {
        adapter.targetRequestFailed(message, e);
    }

    public void terminate() throws DebugException {
        adapter.terminate();
    }

    public void terminateEvaluation() throws DebugException {
        adapter.terminateEvaluation();
    }

    public String toString() {
        return adapter.toString();
    }

}
