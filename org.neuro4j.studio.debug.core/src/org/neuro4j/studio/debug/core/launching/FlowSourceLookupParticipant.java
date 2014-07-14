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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;
import org.eclipse.jdt.internal.debug.core.model.JDIStackFrame;
import org.neuro4j.studio.debug.core.BreakpoinMng;

/**
 * The PDA source lookup participant knows how to translate a
 * PDA stack frame into a source file name
 */
public class FlowSourceLookupParticipant extends AbstractSourceLookupParticipant {
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.core.sourcelookup.ISourceLookupParticipant#getSourceName(java.lang.Object)
     */
    public String getSourceName(Object object) throws CoreException {
        if (object instanceof JDIStackFrame) {
            String resourceName = BreakpoinMng.getInstance().getResourceName((JDIStackFrame) object);
            return resourceName;
        }
        return null;
    }

}
