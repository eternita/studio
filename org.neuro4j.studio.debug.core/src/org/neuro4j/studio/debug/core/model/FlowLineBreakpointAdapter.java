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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpoint;

public class FlowLineBreakpointAdapter implements IBreakpoint {

    IBreakpoint javaLineBreakpoint = null;

    String uuid;

    private FlowLineBreakpointAdapter() {

    }

    public FlowLineBreakpointAdapter(String uuid, IBreakpoint javaLineBreakpoint) {
        this.javaLineBreakpoint = javaLineBreakpoint;
        this.uuid = uuid;
    }

    @Override
    public Object getAdapter(Class arg0) {

        return javaLineBreakpoint.getAdapter(arg0);
    }

    @Override
    public void delete() throws CoreException {
        javaLineBreakpoint.delete();

    }

    @Override
    public IMarker getMarker() {

        return javaLineBreakpoint.getMarker();
    }

    @Override
    public String getModelIdentifier() {
        // TODO Auto-generated method stub
        return javaLineBreakpoint.getModelIdentifier();
    }

    @Override
    public boolean isEnabled() throws CoreException {
        // TODO Auto-generated method stub
        return javaLineBreakpoint.isEnabled();
    }

    @Override
    public boolean isPersisted() throws CoreException {
        // TODO Auto-generated method stub
        return javaLineBreakpoint.isPersisted();
    }

    @Override
    public boolean isRegistered() throws CoreException {
        // TODO Auto-generated method stub
        return javaLineBreakpoint.isRegistered();
    }

    @Override
    public void setEnabled(boolean flag) throws CoreException {
        javaLineBreakpoint.setEnabled(flag);

    }

    @Override
    public void setMarker(IMarker imarker) throws CoreException {
        javaLineBreakpoint.setMarker(imarker);

    }

    @Override
    public void setPersisted(boolean flag) throws CoreException {
        javaLineBreakpoint.setPersisted(flag);

    }

    @Override
    public void setRegistered(boolean flag) throws CoreException {
        javaLineBreakpoint.setRegistered(flag);

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public IBreakpoint getJavaLineBreakpoint() {
        return javaLineBreakpoint;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((javaLineBreakpoint == null) ? 0 : javaLineBreakpoint
                        .hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FlowLineBreakpointAdapter other = (FlowLineBreakpointAdapter) obj;
        if (javaLineBreakpoint == null) {
            if (other.javaLineBreakpoint != null)
                return false;
        } else if (!javaLineBreakpoint.equals(other.javaLineBreakpoint))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

}
