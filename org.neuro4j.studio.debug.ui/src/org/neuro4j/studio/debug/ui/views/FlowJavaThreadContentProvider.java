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
package org.neuro4j.studio.debug.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdate;
import org.eclipse.jdt.debug.core.IJavaDebugTarget;
import org.eclipse.jdt.debug.core.IJavaThread;
import org.eclipse.jdt.internal.debug.core.model.JDIThread;
import org.eclipse.jdt.internal.debug.ui.monitors.JavaThreadContentProvider;

public class FlowJavaThreadContentProvider extends JavaThreadContentProvider {

    FlowJavaStackFrameLabelProvider javaStackFrameLabelProvider = new FlowJavaStackFrameLabelProvider();

    protected Object[] getChildren(IJavaThread thread) {
        try {
            if (thread instanceof JDIThread) {
                JDIThread jThread = (JDIThread) thread;
                if (!jThread.getDebugTarget().isSuspended()) {
                    if (jThread.isSuspendVoteInProgress()) {
                        return EMPTY;
                    }
                }
            }
            IStackFrame[] frames = thread.getStackFrames();
            if (!isDisplayMonitors()) {
                return frames;
            }

            // Object[] children= new Object[]{new CallNodeStackFrame((JDIDebugTarget) thread.getDebugTarget(),
            // frames[0]), new CallNodeStackFrame((JDIDebugTarget) thread.getDebugTarget(), frames[1])};
            List<IStackFrame> list = new ArrayList<IStackFrame>();
            list.add(thread.getTopStackFrame());
            Object[] children = getCallNodeFrames(frames, list);
            // int length = frames.length;
            // if (((IJavaDebugTarget) thread.getDebugTarget()).supportsMonitorInformation()) {
            // IDebugElement[] ownedMonitors = JavaDebugUtils.getOwnedMonitors(thread);
            // IDebugElement contendedMonitor = JavaDebugUtils.getContendedMonitor(thread);
            // length += ownedMonitors.length;
            // if (contendedMonitor != null) {
            // length++;
            // }
            // children = new Object[length];
            // if (ownedMonitors.length > 0) {
            // System.arraycopy(ownedMonitors, 0, children, 0, ownedMonitors.length);
            // }
            // if (contendedMonitor != null) {
            // // Insert the contended monitor after the owned monitors
            // children[ownedMonitors.length] = contendedMonitor;
            // }
            // } else {
            // children = new Object[length + 1];
            // children[0] = new NoMonitorInformationElement(thread.getDebugTarget());
            // }
            // int offset = children.length - frames.length;
            // System.arraycopy(frames, 0, children, offset, frames.length);
            return children;
        } catch (DebugException e) {
            return EMPTY;
        }
    }

    private Object[] getCallNodeFrames(IStackFrame[] frames, List<IStackFrame> list)
    {

        for (IStackFrame frame : frames)
        {
            if (isCallNode(frame)) {
                list.add(frame);
            }

        }
        return list.toArray();
    }

    private boolean isCallNode(IStackFrame frame)
    {
        return javaStackFrameLabelProvider.isCallNode(frame);
    }

    @Override
    protected void retrieveChildCount(IChildrenCountUpdate update) {
        // TODO Auto-generated method stub
        if (!update.isCanceled())
        {
            IStatus status = Status.OK_STATUS;
            try
            {
                IPresentationContext context = update.getPresentationContext();
                if (supportsContext(context))
                {
                    int childCount = getChildCount(update.getElement(), context, update);
                    if (!update.isCanceled())
                        update.setChildCount(childCount);
                } else
                {
                    update.setChildCount(0);
                }
            } catch (CoreException e)
            {
                status = e.getStatus();
            }
            update.setStatus(status);
        }
    }

    protected int getChildCount(Object element, IPresentationContext context, IViewerUpdate monitor)
            throws CoreException
    {
        IJavaThread thread = (IJavaThread) element;
        if (!thread.isSuspended()) {
            return 0;
        }
        // int childCount = thread.getFrameCount();
        List<IStackFrame> list = new ArrayList<IStackFrame>();
        list.add(thread.getTopStackFrame());
        Object[] objects = getCallNodeFrames(thread.getStackFrames(), list);
        int childCount = objects.length;
        if (isDisplayMonitors()) {
            if (((IJavaDebugTarget) thread.getDebugTarget()).supportsMonitorInformation()) {
                childCount += thread.getOwnedMonitors().length;
                if (thread.getContendedMonitor() != null)
                    childCount++;
            }
            else
            {
                childCount++;
            }
        }
        return childCount;
    }

}
