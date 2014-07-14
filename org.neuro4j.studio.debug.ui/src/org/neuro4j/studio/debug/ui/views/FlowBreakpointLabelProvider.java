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
package org.neuro4j.studio.debug.ui.views;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.internal.ui.model.elements.DebugElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreePath;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.ResourceFinder;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

public class FlowBreakpointLabelProvider extends DebugElementLabelProvider
{

    ResourceFinder resourceFinder = ResourceFinder.getInstance();

    protected String getLabel(TreePath elementPath, IPresentationContext presentationContext, String columnId, int columnIndex)
            throws CoreException
    {
        if (columnIndex == 0) {

            FlowLineBreakpointAdapter element = (FlowLineBreakpointAdapter) elementPath.getLastSegment();

            String flowName = resourceFinder.getFlowNameByUuid(element.getUuid());
            if (ResourceFinder.UNKNOWN == flowName)
            {
                BreakpoinMng.getInstance().removeBreakpointByUUID(element.getUuid());
                return "";
            }

            String nodeName = resourceFinder.getNodeNameByUUid(element.getUuid());

            return flowName + " - " + nodeName + " : (" + element.getUuid() + ")";

        }
        return "";
    }

    protected ImageDescriptor getImageDescriptor(TreePath elementPath, IPresentationContext presentationContext, String columnId, int columnIndex)
            throws CoreException
    {
        if (columnIndex == 0) {
            return super.getImageDescriptor(elementPath, presentationContext, columnId, columnIndex);
        }
        return null;
    }

    public boolean getChecked(TreePath path, IPresentationContext presentationContext)
            throws CoreException
    {
        Object lastSegment = path.getLastSegment();
        if ((lastSegment instanceof IBreakpoint)) {
            return ((IBreakpoint) lastSegment).isEnabled();
        }

        return false;
    }
}