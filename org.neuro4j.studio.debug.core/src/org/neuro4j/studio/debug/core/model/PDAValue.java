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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * Value of a PDA variable.
 */
public class PDAValue extends PDADebugElement implements IValue {

    private String fValue;

    public PDAValue(FlowDebugTarget target, String value) {
        super(target);
        fValue = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
     */
    public String getReferenceTypeName() throws DebugException {
        try {
            Integer.parseInt(fValue);
        } catch (NumberFormatException e) {
            return "text";
        }
        return "integer";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IValue#getValueString()
     */
    public String getValueString() throws DebugException {
        return fValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IValue#isAllocated()
     */
    public boolean isAllocated() throws DebugException {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IValue#getVariables()
     */
    public IVariable[] getVariables() throws DebugException {
        return new IVariable[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IValue#hasVariables()
     */
    public boolean hasVariables() throws DebugException {
        return false;
    }
}
