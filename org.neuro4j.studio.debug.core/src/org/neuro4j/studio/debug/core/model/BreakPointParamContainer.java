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

public class BreakPointParamContainer {

    private int lineNumber = 0;
    private int startChar = 0;
    private int endChar = 0;
    private String baseClassName;

    public BreakPointParamContainer(String baseClassName, int lineNumber,
            int startChar, int endChar) {
        super();
        this.baseClassName = baseClassName;
        this.lineNumber = lineNumber;
        this.startChar = startChar;
        this.endChar = endChar;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getStartChar() {
        return startChar;
    }

    public void setStartChar(int startChar) {
        this.startChar = startChar;
    }

    public int getEndChar() {
        return endChar;
    }

    public void setEndChar(int endChar) {
        this.endChar = endChar;
    }

    public String getBaseClassName() {
        return baseClassName;
    }

    public void setBaseClassName(String baseClassName) {
        this.baseClassName = baseClassName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((baseClassName == null) ? 0 : baseClassName.hashCode());
        result = prime * result + endChar;
        result = prime * result + lineNumber;
        result = prime * result + startChar;
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
        BreakPointParamContainer other = (BreakPointParamContainer) obj;
        if (baseClassName == null) {
            if (other.baseClassName != null)
                return false;
        } else if (!baseClassName.equals(other.baseClassName))
            return false;
        if (endChar != other.endChar)
            return false;
        if (lineNumber != other.lineNumber)
            return false;
        if (startChar != other.startChar)
            return false;
        return true;
    }

}
