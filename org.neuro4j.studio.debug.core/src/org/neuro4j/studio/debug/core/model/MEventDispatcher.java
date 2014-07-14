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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.jdt.debug.core.IJavaLineBreakpoint;
import org.eclipse.jdt.internal.debug.core.EventDispatcher;
import org.eclipse.jdt.internal.debug.core.IJDIEventListener;
import org.eclipse.jdt.internal.debug.core.JDIDebugMessages;
import org.eclipse.jdt.internal.debug.core.JDIDebugOptions;
import org.eclipse.jdt.internal.debug.core.JDIDebugPlugin;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;

import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventIterator;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;
import com.sun.jdi.request.EventRequest;

public class MEventDispatcher
        extends EventDispatcher
{
    private JDIDebugTarget fTarget;
    // private boolean fShutdown;
    private HashMap<EventRequest, IJDIEventListener> fEventHandlers;
    private Map<EventSet, List<DebugEvent>> fSetToQueue = new HashMap();

    private boolean fShutdown;

    public MEventDispatcher(JDIDebugTarget target)
    {
        super(target);
        fShutdown = false;
        this.fTarget = target;
        this.fEventHandlers = new HashMap(10);
    }

    private void dispatch(EventSet eventSet)
    {
        System.out.println("dispatch(EventSet eventSet)");
        if (isShutdown()) {
            return;
        }
        if (JDIDebugOptions.DEBUG_JDI_EVENTS) {
            EventIterator eventIter = eventSet.eventIterator();
            StringBuffer buf = new StringBuffer("JDI Event Set: {\n");
            while (eventIter.hasNext()) {
                buf.append(eventIter.next());
                if (eventIter.hasNext()) {
                    buf.append(", ");
                }
            }
            buf.append("}\n");
            JDIDebugOptions.trace(buf.toString());
        }
        EventIterator iter = eventSet.eventIterator();
        IJDIEventListener[] listeners = new IJDIEventListener[eventSet.size()];
        boolean vote = false;
        boolean resume = true;
        int index = -1;
        List deferredEvents = null;
        while (iter.hasNext()) {
            index++;
            if (isShutdown()) {
                return;
            }
            Event event = iter.nextEvent();
            if (event != null)
            {
                IJDIEventListener listener = (IJDIEventListener) this.fEventHandlers.get(event.request());
                listeners[index] = listener;
                if (listener != null) {
                    if ((listener instanceof IJavaLineBreakpoint))
                    {
                        try
                        {
                            if (((IJavaLineBreakpoint) listener).isConditionEnabled()) {
                                if (deferredEvents == null) {
                                    deferredEvents = new ArrayList(5);
                                }
                                deferredEvents.add(event);
                            }
                        } catch (CoreException exception) {
                            JDIDebugPlugin.log(exception);
                        }
                    } else {
                        vote = true;
                        resume = (listener.handleEvent(event, this.fTarget, !resume, eventSet)) && (resume);
                    }

                }
                else if ((event instanceof VMDeathEvent)) {
                    this.fTarget.handleVMDeath((VMDeathEvent) event);
                    shutdown();
                } else if ((event instanceof VMDisconnectEvent)) {
                    this.fTarget.handleVMDisconnect((VMDisconnectEvent) event);
                    shutdown();
                } else if ((event instanceof VMStartEvent)) {
                    this.fTarget.handleVMStart((VMStartEvent) event);
                }

            }

        }

        if (deferredEvents != null) {
            Iterator deferredIter = deferredEvents.iterator();
            while (deferredIter.hasNext()) {
                if (isShutdown()) {
                    return;
                }
                Event event = (Event) deferredIter.next();
                if (event != null)
                {
                    IJDIEventListener listener =
                            (IJDIEventListener) this.fEventHandlers
                                    .get(event.request());
                    if (listener != null) {
                        vote = true;
                        resume = (listener.handleEvent(event, this.fTarget, !resume, eventSet)) && (resume);
                    }
                }
            }

        }

        index = -1;
        iter = eventSet.eventIterator();
        while (iter.hasNext()) {
            index++;
            Event event = iter.nextEvent();

            IJDIEventListener listener = listeners[index];
            if (listener != null) {
                listener.eventSetComplete(event, this.fTarget, !resume, eventSet);
            }

        }

        fireEvents(eventSet);

        if ((vote) && (resume))
            try {
                eventSet.resume();
            } catch (VMDisconnectedException localVMDisconnectedException) {
            } catch (RuntimeException e) {
                try {
                    this.fTarget.targetRequestFailed(
                            JDIDebugMessages.EventDispatcher_0, e);
                } catch (DebugException de) {
                    JDIDebugPlugin.log(de);
                }
            }
    }

    public void run()
    {
        VirtualMachine vm = this.fTarget.getVM();
        if (vm != null) {
            EventQueue q = vm.eventQueue();
            EventSet eventSet = null;
            while (!isShutdown())
                try
                {
                    try {
                        eventSet = q.remove(1000L);
                    } catch (VMDisconnectedException localVMDisconnectedException) {
                        break;
                    }

                    if ((!isShutdown()) && (eventSet != null)) {
                        final EventSet set = eventSet;
                        Job job = new Job("JDI Event Dispatch")
                        {
                            protected IStatus run(IProgressMonitor monitor) {
                                MEventDispatcher.this.dispatch(set);
                                return Status.OK_STATUS;
                            }

                            public boolean belongsTo(Object family)
                            {
                                if ((family instanceof Class)) {
                                    Class clazz = (Class) family;
                                    EventIterator iterator = set.eventIterator();
                                    while (iterator.hasNext()) {
                                        Event event = iterator.nextEvent();
                                        if (clazz.isInstance(event)) {
                                            return true;
                                        }
                                    }
                                }
                                return false;
                            }
                        };
                        job.setSystem(true);
                        job.schedule();
                    }
                } catch (InterruptedException localInterruptedException) {
                    break;
                }
        }
    }

    public void shutdown()
    {
        super.shutdown();
        fShutdown = true;

    }

    private boolean isShutdown()
    {
        return fShutdown;
    }

    public void addJDIEventListener(IJDIEventListener listener, EventRequest request)
    {
        super.addJDIEventListener(listener, request);
        this.fEventHandlers.put(request, listener);
    }

    public void removeJDIEventListener(IJDIEventListener listener, EventRequest request)
    {
        super.removeJDIEventListener(listener, request);
        this.fEventHandlers.remove(request);
    }

    public void queue(DebugEvent event, EventSet set)
    {
        super.queue(event, set);
        synchronized (this.fSetToQueue) {
            List list = (List) this.fSetToQueue.get(set);
            if (list == null) {
                list = new ArrayList(5);
                this.fSetToQueue.put(set, list);
            }
            list.add(event);
        }
    }

    private void fireEvents(EventSet set)
    {
        DebugPlugin plugin = DebugPlugin.getDefault();
        if (plugin != null) {
            List list = null;
            synchronized (this.fSetToQueue) {
                list = (List) this.fSetToQueue.remove(set);
            }
            if (list != null) {
                DebugEvent[] events = (DebugEvent[]) list.toArray(new DebugEvent[list.size()]);
                plugin.fireDebugEventSet(events);
            }
        }
    }
}