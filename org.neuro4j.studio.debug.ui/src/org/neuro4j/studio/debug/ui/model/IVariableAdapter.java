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

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.jdt.debug.core.IJavaType;
import org.eclipse.jdt.internal.debug.core.IJDIEventListener;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.debug.core.model.JDIVariable;

import com.sun.jdi.Type;
import com.sun.jdi.Value;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;

public class IVariableAdapter extends JDIVariable implements IVariable {

    JDIVariable var;
    String name;

    public IVariableAdapter(String name, JDIVariable original)
    {
        super((JDIDebugTarget) original.getDebugTarget());
        this.var = original;
        this.name = name;
    }

    public void addJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        var.addJDIEventListener(listener, request);
    }

    public boolean canDisconnect() {
        return var.canDisconnect();
    }

    public void disconnect() throws DebugException {
        var.disconnect();
    }

    public boolean equals(Object arg0) {
        if (arg0 instanceof IVariableAdapter)
        {
            return this == arg0;
        }
        return var.equals(arg0);
    }

    public void fireChangeEvent(int detail) {
        var.fireChangeEvent(detail);
    }

    public void fireCreationEvent() {
        var.fireCreationEvent();
    }

    public void fireEvent(DebugEvent event) {
        var.fireEvent(event);
    }

    public void fireResumeEvent(int detail) {
        var.fireResumeEvent(detail);
    }

    public void fireSuspendEvent(int detail) {
        var.fireSuspendEvent(detail);
    }

    public void fireTerminateEvent() {
        var.fireTerminateEvent();
    }

    public Object getAdapter(Class adapter) {
        return var.getAdapter(adapter);
    }

    public IDebugTarget getDebugTarget() {
        return var.getDebugTarget();
    }

    public EventRequestManager getEventRequestManager() {
        return var.getEventRequestManager();
    }

    public String getGenericSignature() throws DebugException {
        return var.getGenericSignature();
    }

    public JDIDebugTarget getJavaDebugTarget() {
        return var.getJavaDebugTarget();
    }

    public IJavaType getJavaType() throws DebugException {
        return var.getJavaType();
    }

    public ILaunch getLaunch() {
        return var.getLaunch();
    }

    public String getModelIdentifier() {
        return var.getModelIdentifier();
    }

    public String getName() throws DebugException {
        // return var.getName();
        return name;
    }

    public String getReferenceTypeName() throws DebugException {
        return var.getReferenceTypeName();
    }

    public int getRequestTimeout() {
        return var.getRequestTimeout();
    }

    public String getSignature() throws DebugException {
        return var.getSignature();
    }

    public IValue getValue() throws DebugException {
        return var.getValue();
    }

    public boolean hasValueChanged() {
        return var.hasValueChanged();
    }

    public int hashCode() {
        return var.hashCode();
    }

    public void internalError(RuntimeException e) {
        var.internalError(e);
    }

    public boolean isDisconnected() {
        return var.isDisconnected();
    }

    public boolean isFinal() {
        return var.isFinal();
    }

    public boolean isLocal() {
        return var.isLocal();
    }

    public boolean isPackagePrivate() {
        return var.isPackagePrivate();
    }

    public boolean isPrivate() throws DebugException {
        return var.isPrivate();
    }

    public boolean isProtected() throws DebugException {
        return var.isProtected();
    }

    public boolean isPublic() throws DebugException {
        return var.isPublic();
    }

    public boolean isStatic() {
        return var.isStatic();
    }

    public boolean isStepFiltersEnabled() {
        return var.isStepFiltersEnabled();
    }

    public boolean isSynthetic() {
        return var.isSynthetic();
    }

    public void jdiRequestFailed(String message, Throwable e)
            throws DebugException {
        var.jdiRequestFailed(message, e);
    }

    public void notSupported(String message) throws DebugException {
        var.notSupported(message);
    }

    public void queueEvent(DebugEvent event, EventSet set) {
        var.queueEvent(event, set);
    }

    public void queueSuspendEvent(int detail, EventSet set) {
        var.queueSuspendEvent(detail, set);
    }

    public void removeJDIEventListener(IJDIEventListener listener,
            EventRequest request) {
        var.removeJDIEventListener(listener, request);
    }

    public void requestFailed(String message, Exception e)
            throws DebugException {
        var.requestFailed(message, e);
    }

    public void requestFailed(String message, Throwable e, int code)
            throws DebugException {
        var.requestFailed(message, e, code);
    }

    public void setRequestTimeout(int timeout) {
        var.setRequestTimeout(timeout);
    }

    public void setValue(IValue value) throws DebugException {
        var.setValue(value);
    }

    public void setValue(String expression) throws DebugException {
        var.setValue(expression);
    }

    public boolean supportsRequestTimeout() {
        return var.supportsRequestTimeout();
    }

    public boolean supportsValueModification() {
        return var.supportsValueModification();
    }

    public void targetRequestFailed(String message, RuntimeException e)
            throws DebugException {
        var.targetRequestFailed(message, e);
    }

    public void targetRequestFailed(String message, Throwable e)
            throws DebugException {
        var.targetRequestFailed(message, e);
    }

    public String toString() {
        return var.toString();
    }

    public boolean verifyValue(IValue value) throws DebugException {
        return var.verifyValue(value);
    }

    public boolean verifyValue(String expression) throws DebugException {
        return var.verifyValue(expression);
    }

    @Override
    protected Type getUnderlyingType() throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Value retrieveValue() throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

}
