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

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.neuro4j.studio.core.Neuro4jCorePlugin;

public class ExceptionHandler
{
    private static ExceptionHandler fgInstance = new ExceptionHandler();

    public static void handle(CoreException e, String title, String message)
    {
        handle(e, Neuro4jCorePlugin.getActiveWorkbenchShell(), title, message);
    }

    public static void handle(CoreException e, Shell parent, String title, String message)
    {
        fgInstance.perform(e, parent, title, message);
    }

    public static void handle(String title, String message)
    {
        fgInstance.perform(Neuro4jCorePlugin.getActiveWorkbenchShell(), title, message);
    }

    private void perform(Shell activeWorkbenchShell, String title, String message)
    {

        displayMessageDialog("", activeWorkbenchShell, title, message);
    }

    public static void handle(InvocationTargetException e, Shell parent, String title, String message)
    {
        fgInstance.perform(e, parent, title, message);
    }

    protected void perform(CoreException e, Shell shell, String title, String message)
    {
        Neuro4jCorePlugin.log(e);
        IStatus status = e.getStatus();
        if (status != null)
            ErrorDialog.openError(shell, title, message, status);
        else
            displayMessageDialog(e.getMessage(), shell, title, message);
    }

    protected void perform(InvocationTargetException e, Shell shell, String title, String message)
    {
        Throwable target = e.getTargetException();
        if ((target instanceof CoreException)) {
            perform((CoreException) target, shell, title, message);
        } else {
            Neuro4jCorePlugin.log(e);
            if ((e.getMessage() != null) && (e.getMessage().length() > 0))
                displayMessageDialog(e.getMessage(), shell, title, message);
            else
                displayMessageDialog(target.getMessage(), shell, title, message);
        }
    }

    private void displayMessageDialog(String exceptionMessage, Shell shell, String title, String message)
    {
        StringWriter msg = new StringWriter();
        if (message != null) {
            msg.write(message);
            msg.write("\n\n");
        }
        MessageDialog.openError(shell, title, msg.toString());
    }
}