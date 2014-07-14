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
package org.neuro4j.studio.core.buildpath;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;

public class Neuro4jStatus implements IStatus
{
    private String fStatusMessage;
    private int fSeverity;

    public Neuro4jStatus()
    {
        this(0, null);
    }

    public Neuro4jStatus(int severity, String message)
    {
        this.fStatusMessage = message;
        this.fSeverity = severity;
    }

    public static IStatus createError(String message) {
        return new Neuro4jStatus(4, message);
    }

    public static IStatus createWarning(String message) {
        return new Neuro4jStatus(2, message);
    }

    public static IStatus createInfo(String message) {
        return new Neuro4jStatus(1, message);
    }

    public boolean isOK()
    {
        return this.fSeverity == 0;
    }

    public boolean isWarning()
    {
        return this.fSeverity == 2;
    }

    public boolean isInfo()
    {
        return this.fSeverity == 1;
    }

    public boolean isError()
    {
        return this.fSeverity == 4;
    }

    public String getMessage()
    {
        return this.fStatusMessage;
    }

    public void setError(String errorMessage)
    {
        Assert.isNotNull(errorMessage);
        this.fStatusMessage = errorMessage;
        this.fSeverity = 4;
    }

    public void setWarning(String warningMessage)
    {
        Assert.isNotNull(warningMessage);
        this.fStatusMessage = warningMessage;
        this.fSeverity = 2;
    }

    public void setInfo(String infoMessage)
    {
        Assert.isNotNull(infoMessage);
        this.fStatusMessage = infoMessage;
        this.fSeverity = 1;
    }

    public void setOK()
    {
        this.fStatusMessage = null;
        this.fSeverity = 0;
    }

    public boolean matches(int severityMask)
    {
        return (this.fSeverity & severityMask) != 0;
    }

    public boolean isMultiStatus()
    {
        return false;
    }

    public int getSeverity()
    {
        return this.fSeverity;
    }

    public String getPlugin()
    {
        return "org.neuro4j.logic";
    }

    public Throwable getException()
    {
        return null;
    }

    public int getCode()
    {
        return this.fSeverity;
    }

    public IStatus[] getChildren()
    {
        return new IStatus[0];
    }
}