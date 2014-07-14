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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.neuro4j.studio.debug.core.DebugExamplesPlugin;
import org.neuro4j.studio.debug.core.launching.IPDAConstants;

/**
 * Common function of PDA debug model elements
 */
public abstract class PDADebugElement extends PlatformObject implements IDebugElement {

    // containing target
    protected FlowDebugTarget fTarget;

    /**
     * Constructs a new debug element contained in the given
     * debug target.
     * 
     * @param target
     *        debug target (PDA VM)
     */
    public PDADebugElement(FlowDebugTarget target) {
        fTarget = target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
     */
    public String getModelIdentifier() {
        return IPDAConstants.ID_PDA_DEBUG_MODEL;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
     */
    public IDebugTarget getDebugTarget() {
        return fTarget;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
     */
    public ILaunch getLaunch() {
        return getDebugTarget().getLaunch();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class adapter) {
        if (adapter == IDebugElement.class) {
            return this;
        }
        return super.getAdapter(adapter);
    }

    protected void abort(String message, Throwable e) throws DebugException {
        throw new DebugException(new Status(IStatus.ERROR, DebugExamplesPlugin.getDefault().getParameterUniqueIdentifier(),
                DebugPlugin.INTERNAL_ERROR, message, e));
    }

    /**
     * Fires a debug event
     * 
     * @param event
     *        the event to be fired
     */
    protected void fireEvent(DebugEvent event) {
        DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
    }

    /**
     * Fires a <code>CREATE</code> event for this element.
     */
    protected void fireCreationEvent() {
        fireEvent(new DebugEvent(this, DebugEvent.CREATE));
    }

    /**
     * Fires a <code>RESUME</code> event for this element with
     * the given detail.
     * 
     * @param detail
     *        event detail code
     */
    public void fireResumeEvent(int detail) {
        fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
    }

    /**
     * Fires a <code>SUSPEND</code> event for this element with
     * the given detail.
     * 
     * @param detail
     *        event detail code
     */
    public void fireSuspendEvent(int detail) {
        fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
    }

    /**
     * Fires a <code>TERMINATE</code> event for this element.
     */
    protected void fireTerminateEvent() {
        fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
    }
}
