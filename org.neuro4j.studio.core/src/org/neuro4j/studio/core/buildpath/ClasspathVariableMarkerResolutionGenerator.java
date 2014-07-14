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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.CorrectionEngine;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.util.BusyIndicatorRunnableContext;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.neuro4j.studio.core.Neuro4jCorePlugin;

public class ClasspathVariableMarkerResolutionGenerator implements IMarkerResolutionGenerator2
{
    private static final IMarkerResolution[] NO_RESOLUTION = new IMarkerResolution[0];

    public boolean hasResolutions(IMarker marker)
    {
        int id = marker.getAttribute("id", -1);
        if (id == 1010) {
            String[] arguments = CorrectionEngine.getProblemArguments(marker);
            if ((arguments == null) || (arguments.length == 0))
                return false;
            if ((arguments[0].startsWith("NEURO4J_HOME/")) ||
                    (arguments[0].startsWith("NEURO4J_SRC_HOME/")))
                return true;
        }
        return false;
    }

    public IMarkerResolution[] getResolutions(IMarker marker)
    {
        if (!hasResolutions(marker)) {
            return NO_RESOLUTION;
        }

        String[] arguments = CorrectionEngine.getProblemArguments(marker);
        final IPath path = new Path(arguments[0]);
        final IJavaProject project = getJavaProject(marker);

        return new IMarkerResolution2[] {
                new IMarkerResolution2() {
                    public Image getImage() {
                        return JavaPluginImages.get("org.eclipse.jdt.ui.correction_change.gif");
                    }

                    public String getLabel() {
                        return WizardMessages.ClasspathVariableMarkerResolutionGenerator_use_Neuro4j;
                    }

                    public String getDescription() {
                        return WizardMessages.ClasspathVariableMarkerResolutionGenerator_use_Neuro4j_desc;
                    }

                    public void run(IMarker nonsenseArgument)
                    {
                        try {
                            IClasspathEntry[] entries = project.getRawClasspath();
                            int idx = ClasspathVariableMarkerResolutionGenerator.this.indexOfClasspath(entries, path);
                            if (idx == -1) {
                                return;
                            }
                            entries[idx] = BuildPathSupport.getNeuro4jCoreLibraryEntry();

                            ClasspathVariableMarkerResolutionGenerator.setClasspath(project, entries, new BusyIndicatorRunnableContext());
                        }
                        catch (JavaModelException e) {
                            Neuro4jCorePlugin.log(e);
                        }
                    }
                }
        };
    }

    private IJavaProject getJavaProject(IMarker marker) {
        return JavaCore.create(marker.getResource().getProject());
    }

    private int indexOfClasspath(IClasspathEntry[] entries, IPath path) {
        for (int i = 0; i < entries.length; i++) {
            IClasspathEntry curr = entries[i];
            if ((curr.getEntryKind() == 4) && (curr.getPath().equals(path))) {
                return i;
            }
        }
        return -1;
    }

    private static void setClasspath(final IJavaProject project, final IClasspathEntry[] entries, IRunnableContext context)
    {
        try
        {
            context.run(true, false, new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try {
                        project.setRawClasspath(entries, monitor);
                    } catch (JavaModelException e) {
                        throw new InvocationTargetException(e);
                    }
                }
            });
        } catch (InvocationTargetException e) {
            Neuro4jCorePlugin.log(e);
        } catch (InterruptedException localInterruptedException)
        {
        }
    }
}