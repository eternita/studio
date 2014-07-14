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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.debug.core.sourcelookup.containers.FolderSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.ProjectSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;

/**
 * Computes the default source lookup path for a PDA launch configuration.
 * The default source lookup path is the folder or project containing
 * the PDA program being launched. If the program is not specified, the workspace
 * is searched by default.
 */
public class FlowSourcePathComputerDelegate implements ISourcePathComputerDelegate {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.internal.core.sourcelookup.ISourcePathComputerDelegate#computeSourceContainers(org.eclipse.
     * debug.core.ILaunchConfiguration, org.eclipse.core.runtime.IProgressMonitor)
     */
    public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
        String path = configuration.getAttribute(IPDAConstants.ATTR_PDA_PROGRAM, (String) null);
        ISourceContainer sourceContainer = null;
        if (path != null) {
            IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
            if (resource != null) {
                IContainer container = resource.getParent();
                if (container.getType() == IResource.PROJECT) {
                    sourceContainer = new ProjectSourceContainer((IProject) container, false);
                } else if (container.getType() == IResource.FOLDER) {
                    sourceContainer = new FolderSourceContainer(container, false);
                }
            }
        }
        if (sourceContainer == null) {
            sourceContainer = new WorkspaceSourceContainer();
        }
        return new ISourceContainer[] { sourceContainer };
    }
}
