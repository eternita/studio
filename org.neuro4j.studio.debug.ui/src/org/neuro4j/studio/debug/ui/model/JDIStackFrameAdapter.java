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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.jdt.debug.core.IJavaClassType;
import org.eclipse.jdt.debug.core.IJavaObject;
import org.eclipse.jdt.debug.core.IJavaReferenceType;
import org.eclipse.jdt.debug.core.IJavaValue;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jdt.internal.debug.core.IJDIEventListener;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.debug.core.model.JDIStackFrame;
import org.eclipse.jdt.internal.debug.core.model.JDIThread;
import org.eclipse.jdt.internal.debug.core.model.JDIVariable;

import com.sun.jdi.Method;
import com.sun.jdi.StackFrame;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

public class JDIStackFrameAdapter extends JDIStackFrame implements org.eclipse.debug.core.model.IStackFrame {

    JDIStackFrame jDIStackFrame;
    boolean isValid = true;

    public JDIStackFrameAdapter(JDIStackFrame frame) {
        this(frame.getThread(), getUnderlyingStackFrame(frame), 1);
        jDIStackFrame = frame;
        isValid = true;
    }

    public JDIStackFrameAdapter(IThread iThread, StackFrame frame, int depth) {
        super((JDIThread) iThread, frame, depth);

    }

    public static StackFrame getUnderlyingStackFrame(JDIStackFrame frame) {

        Field f;
        try {
            f = frame.getClass().getDeclaredField("fStackFrame");
            f.setAccessible(true);
            StackFrame o = (StackFrame) f.get(frame); // IllegalAccessException
            return o;
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // NoSuchFieldException
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public JDIStackFrame getJDIStackFrame()
    {
        return jDIStackFrame;
    }

    public void addJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        jDIStackFrame.addJDIEventListener(listener, request);
    }

    public boolean canDisconnect() {
        return jDIStackFrame.canDisconnect();
    }

    public boolean canDropToFrame() {
        return jDIStackFrame.canDropToFrame();
    }

    public boolean canForceReturn() {
        return jDIStackFrame.canForceReturn();
    }

    public boolean canResume() {
        return jDIStackFrame.canResume();
    }

    public boolean canStepInto() {
        return jDIStackFrame.canStepInto();
    }

    public boolean canStepOver() {
        return jDIStackFrame.canStepOver();
    }

    public boolean canStepReturn() {
        return jDIStackFrame.canStepReturn();
    }

    public boolean canStepWithFilters() {
        return jDIStackFrame.canStepWithFilters();
    }

    public boolean canSuspend() {
        return jDIStackFrame.canSuspend();
    }

    public boolean canTerminate() {
        return jDIStackFrame.canTerminate();
    }

    public void disconnect() throws DebugException {
        jDIStackFrame.disconnect();
    }

    public void dropToFrame() throws DebugException {
        jDIStackFrame.dropToFrame();
    }

    public boolean equals(Object arg0) {
        if (arg0 instanceof JDIStackFrameAdapter)
        {
            return true;
        }
        return jDIStackFrame.equals(arg0);
    }

    public IJavaVariable findVariable(String varName) throws DebugException {
        return jDIStackFrame.findVariable(varName);
    }

    public void fireChangeEvent(int detail) {
        jDIStackFrame.fireChangeEvent(detail);
    }

    public void fireCreationEvent() {
        jDIStackFrame.fireCreationEvent();
    }

    public void fireEvent(DebugEvent event) {
        jDIStackFrame.fireEvent(event);
    }

    public void fireResumeEvent(int detail) {
        jDIStackFrame.fireResumeEvent(detail);
    }

    public void fireSuspendEvent(int detail) {
        jDIStackFrame.fireSuspendEvent(detail);
    }

    public void fireTerminateEvent() {
        jDIStackFrame.fireTerminateEvent();
    }

    public void forceReturn(IJavaValue value) throws DebugException {
        jDIStackFrame.forceReturn(value);
    }

    public Object getAdapter(Class adapter) {
        return jDIStackFrame.getAdapter(adapter);
    }

    public List<String> getArgumentTypeNames() throws DebugException {
        return jDIStackFrame.getArgumentTypeNames();
    }

    public int getCharEnd() {
        return jDIStackFrame.getCharEnd();
    }

    public int getCharStart() {
        return jDIStackFrame.getCharStart();
    }

    public IDebugTarget getDebugTarget() {
        return jDIStackFrame.getDebugTarget();
    }

    public IJavaClassType getDeclaringType() throws DebugException {
        return jDIStackFrame.getDeclaringType();
    }

    public String getDeclaringTypeName() throws DebugException {
        return jDIStackFrame.getDeclaringTypeName();
    }

    public EventRequestManager getEventRequestManager() {
        return jDIStackFrame.getEventRequestManager();
    }

    public JDIDebugTarget getJavaDebugTarget() {
        return jDIStackFrame.getJavaDebugTarget();
    }

    public ILaunch getLaunch() {
        return jDIStackFrame.getLaunch();
    }

    public int getLineNumber() throws DebugException {
        return jDIStackFrame.getLineNumber();
    }

    public int getLineNumber(String stratum) throws DebugException {
        return jDIStackFrame.getLineNumber(stratum);
    }

    public IJavaVariable[] getLocalVariables() throws DebugException {
        return jDIStackFrame.getLocalVariables();
    }

    public String getMethodName() throws DebugException {
        return jDIStackFrame.getMethodName();
    }

    public String getModelIdentifier() {
        return jDIStackFrame.getModelIdentifier();
    }

    public String getName() throws DebugException {
        return jDIStackFrame.getName();
    }

    public String getReceivingTypeName() throws DebugException {
        return jDIStackFrame.getReceivingTypeName();
    }

    public IJavaReferenceType getReferenceType() throws DebugException {
        return jDIStackFrame.getReferenceType();
    }

    public IRegisterGroup[] getRegisterGroups() {
        return jDIStackFrame.getRegisterGroups();
    }

    public int getRequestTimeout() {
        return jDIStackFrame.getRequestTimeout();
    }

    public String getSignature() throws DebugException {
        return jDIStackFrame.getSignature();
    }

    public String getSourceName() throws DebugException {
        return jDIStackFrame.getSourceName();
    }

    public String getSourceName(String stratum) throws DebugException {
        return jDIStackFrame.getSourceName(stratum);
    }

    public String getSourcePath() throws DebugException {
        return jDIStackFrame.getSourcePath();
    }

    public String getSourcePath(String stratum) throws DebugException {
        return jDIStackFrame.getSourcePath(stratum);
    }

    public IJavaObject getThis() throws DebugException {
        return jDIStackFrame.getThis();
    }

    public IThread getThread() {
        return jDIStackFrame.getThread();
    }

    public Method getUnderlyingMethod() {
        return jDIStackFrame.getUnderlyingMethod();
    }

    public IVariable[] getVariables() throws DebugException {
        IVariable[] vars = getContextVars();
        if (vars != null)
        {
            return vars;
        }

        return jDIStackFrame.getVariables();
    }

    public boolean isValidDateFrame(JDIStackFrame frame) {

        Field f;
        try {
            f = frame.getClass().getDeclaredField("fDepth");
            f.setAccessible(true);
            Integer o = (Integer) f.get(frame); // IllegalAccessException
            if (o < 0)
            {
                isValid = false;
            }
            return o > 0;
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // NoSuchFieldException
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    private IVariable[] getContextVars() {
        try {
            if (!isValid && !isValidDateFrame(jDIStackFrame))
            {
                return new IVariable[0];
            }
            IVariable[] topVars = jDIStackFrame.getVariables();
            IVariable r = findVariableByName(topVars, "request");
            if (r == null)
            {
                return null;
            }
            for (IVariable var : r.getValue().getVariables()) {
                if (var.getName().equals("context")
                        || var.getName().equals("logicContext")) {
                    IVariable[] vars = var.getValue().getVariables();
                    IVariable parameters = findVariableByName(vars,
                            "parameters");

                    vars = parameters.getValue().getVariables();

                    IVariable table = findVariableByName(vars, "table");

                    IVariable[] varray1 = table.getValue().getVariables();
                    List<IVariable> list = new ArrayList<IVariable>();
                    for (IVariable v2 : varray1) {
                        if (v2.getValue() != null) {
                            IVariable[] entries = v2.getValue().getVariables();
                            IVariable value = null;
                            String name = "";
                            for (IVariable entryValue : entries) {

                                if (entryValue.getName().equals("value")) {

                                    value = entryValue;
                                }
                                if (entryValue.getName().equals("key")) {

                                    name = entryValue.getValue()
                                            .getValueString();
                                }

                            }
                            if (value != null) {
                                list.add(new IVariableAdapter(name,
                                        (JDIVariable) value));
                            }

                        }
                    }
                    IAdapterManager manager= Platform.getAdapterManager();                   
                    
                    return list.toArray(new IVariable[list.size()]);

                }
            }

        } catch (DebugException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isValid = false;
        }

        return new IVariable[0];
    }

    private IVariable findVariableByName(IVariable[] array, String name) throws DebugException {

        for (IVariable v : array) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public boolean hasRegisterGroups() {
        return jDIStackFrame.hasRegisterGroups();
    }

    public boolean hasVariables() throws DebugException {
        return jDIStackFrame.hasVariables();
    }

    public int hashCode() {
        return jDIStackFrame.hashCode();
    }

    public void internalError(RuntimeException e) {
        jDIStackFrame.internalError(e);
    }

    public boolean isConstructor() throws DebugException {
        return jDIStackFrame.isConstructor();
    }

    public boolean isDisconnected() {
        return jDIStackFrame.isDisconnected();
    }

    public boolean isFinal() throws DebugException {
        return jDIStackFrame.isFinal();
    }

    public boolean isNative() throws DebugException {
        return jDIStackFrame.isNative();
    }

    public boolean isObsolete() {
        return jDIStackFrame.isObsolete();
    }

    public boolean isOutOfSynch() throws DebugException {
        return jDIStackFrame.isOutOfSynch();
    }

    public boolean isPackagePrivate() throws DebugException {
        return jDIStackFrame.isPackagePrivate();
    }

    public boolean isPrivate() throws DebugException {
        return jDIStackFrame.isPrivate();
    }

    public boolean isProtected() throws DebugException {
        return jDIStackFrame.isProtected();
    }

    public boolean isPublic() throws DebugException {
        return jDIStackFrame.isPublic();
    }

    public boolean isStatic() throws DebugException {
        return jDIStackFrame.isStatic();
    }

    public boolean isStaticInitializer() throws DebugException {
        return jDIStackFrame.isStaticInitializer();
    }

    public boolean isStepFiltersEnabled() {
        return jDIStackFrame.isStepFiltersEnabled();
    }

    public boolean isStepping() {
        return jDIStackFrame.isStepping();
    }

    public boolean isSuspended() {
        return jDIStackFrame.isSuspended();
    }

    public boolean isSynchronized() throws DebugException {
        return jDIStackFrame.isSynchronized();
    }

    public boolean isSynthetic() throws DebugException {
        return jDIStackFrame.isSynthetic();
    }

    public boolean isTerminated() {
        return jDIStackFrame.isTerminated();
    }

    public boolean isVarArgs() throws DebugException {
        return jDIStackFrame.isVarArgs();
    }

    public void jdiRequestFailed(String message, Throwable e)
            throws DebugException {
        jDIStackFrame.jdiRequestFailed(message, e);
    }

    public void notSupported(String message) throws DebugException {
        jDIStackFrame.notSupported(message);
    }

    public void popFrame() throws DebugException {
        jDIStackFrame.popFrame();
    }

    public void queueEvent(DebugEvent event, EventSet set) {
        jDIStackFrame.queueEvent(event, set);
    }

    public void queueSuspendEvent(int detail, EventSet set) {
        jDIStackFrame.queueSuspendEvent(detail, set);
    }

    public void removeJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        jDIStackFrame.removeJDIEventListener(listener, request);
    }

    public void requestFailed(String message, Exception e)
            throws DebugException {
        jDIStackFrame.requestFailed(message, e);
    }

    public void requestFailed(String message, Throwable e, int code)
            throws DebugException {
        jDIStackFrame.requestFailed(message, e, code);
    }

    public void resume() throws DebugException {
        jDIStackFrame.resume();
    }

    public void setOutOfSynch(boolean outOfSynch) {
        jDIStackFrame.setOutOfSynch(outOfSynch);
    }

    public void setRequestTimeout(int timeout) {
        jDIStackFrame.setRequestTimeout(timeout);
    }

    public void stepInto() throws DebugException {
        jDIStackFrame.stepInto();
    }

    public void stepOver() throws DebugException {
        jDIStackFrame.stepOver();
    }

    public void stepReturn() throws DebugException {
        jDIStackFrame.stepReturn();
    }

    public void stepWithFilters() throws DebugException {
        jDIStackFrame.stepWithFilters();
    }

    public boolean supportsDropToFrame() {
        return jDIStackFrame.supportsDropToFrame();
    }

    public boolean supportsRequestTimeout() {
        return jDIStackFrame.supportsRequestTimeout();
    }

    public void suspend() throws DebugException {
        jDIStackFrame.suspend();
    }

    public void targetRequestFailed(String message, RuntimeException e)
            throws DebugException {
        jDIStackFrame.targetRequestFailed(message, e);
    }

    public void targetRequestFailed(String message, Throwable e)
            throws DebugException {
        jDIStackFrame.targetRequestFailed(message, e);
    }

    public void terminate() throws DebugException {
        jDIStackFrame.terminate();
    }

    public String toString() {
        return jDIStackFrame.toString();
    }

    public boolean wereLocalsAvailable() {
        return jDIStackFrame.wereLocalsAvailable();
    }

}
