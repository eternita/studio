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
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.internal.ui.model.elements.DebugElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ICheckUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.jdt.debug.core.IJavaStackFrame;
import org.eclipse.jdt.internal.debug.core.model.JDIStackFrame;
import org.eclipse.jdt.internal.debug.core.model.JDIThread;
import org.eclipse.jface.viewers.TreePath;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.ResourceFinder;
import org.neuro4j.studio.debug.core.model.FlowDebugTarget;

public class FlowJavaStackFrameLabelProvider extends DebugElementLabelProvider {

    protected void retrieveLabel(ILabelUpdate update)
            throws CoreException
    {
        Object element = update.getElement();
        if ((element instanceof IJavaStackFrame)) {
            IJavaStackFrame frame = (IJavaStackFrame) element;
            if (!frame.getThread().isSuspended()) {
                update.cancel();
                return;
            }
        }
        String columnIds[] = update.getColumnIds();
        IPresentationContext presentationContext = update.getPresentationContext();
        TreePath elementPath = update.getElementPath();

        JDIStackFrame sf = (JDIStackFrame) elementPath.getLastSegment();
        if (sf == null || !(sf.getDebugTarget() instanceof FlowDebugTarget))
        {
            return;
        }

        int numColumns = 1;
        if (columnIds != null)
            numColumns = columnIds.length;
        for (int i = 0; i < numColumns; i++)
        {
            String columnId = null;
            if (columnIds != null)
                columnId = columnIds[i];
            // update.setLabel(getLabel(elementPath, presentationContext, columnId, i), i);
            update.setLabel(getLabel(sf), i);
            update.setImageDescriptor(getImageDescriptor(elementPath, presentationContext, columnId, i), i);
            update.setBackground(getBackground(elementPath, presentationContext, columnId), i);
            update.setForeground(getForeground(elementPath, presentationContext, columnId), i);
            update.setFontData(getFontData(elementPath, presentationContext, columnId), i);
            if ((update instanceof ICheckUpdate) && Boolean.TRUE.equals(presentationContext.getProperty("org.eclipse.debug.ui.check")))
                ((ICheckUpdate) update).setChecked(getChecked(elementPath, presentationContext), getGrayed(elementPath, presentationContext));
        }
    }

    private String getLabel(JDIStackFrame sf)
    {
        if (isCallNode(sf))
        {
            return getCallNodeLabel(sf);
        } else {
            return getNodeLabel(sf);
        }

    }

    public boolean isCallNode(IStackFrame frame) {
        try {
            IVariable[] vars = frame.getVariables();
            IVariable var = vars[0];

            if (var.getValue().getReferenceTypeName().equals("import org.neuro4j.workflow.def.node.CallByFlowNameBlock") && vars.length > 2) {
                return true;
            }

        } catch (DebugException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    private String getCallNodeLabel(JDIStackFrame frame) {
        String label = "";
        try {
            label = getCallNodeFlowName(frame);
        } catch (DebugException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return label;
    }

    private String getNodeLabel(JDIStackFrame sf) {

        try {

            String[] array = BreakpoinMng.getInstance().getNodeNameAndUuid(sf);

            String flowName = ResourceFinder.getInstance().getFlowNameByUuid(array[1]);

            return new StringBuffer(flowName).append(": ").append(array[0]).append(" (").append(array[1]).append(")").toString();

        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return "unknownNode";
    }

    private String getCallNodeFlowName(JDIStackFrame frame) throws DebugException
    {
        String uuid = null;
        try {
            uuid = BreakpoinMng.getInstance().getCurrentUuid(frame);

        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "CallNode";
        }

        String flowName = ResourceFinder.getInstance().getFlowNameByUuid(uuid);

        for (IVariable thisObject : frame.getVariables())
        {
            if (thisObject.getName().equals("flow")) {
                // return thisObject.getValue().toString();
                return new StringBuffer(flowName).append(": ").append(thisObject.getValue().toString()).append(" (").append(uuid).append(")").toString();
            }
        }

        return new StringBuffer(flowName).append(": ").append("CallNode").append(" (").append(uuid).append(")").toString();
    }

    protected ISchedulingRule getRule(ILabelUpdate update)
    {
        Object element = update.getElement();
        if ((element instanceof IJavaStackFrame)) {
            IJavaStackFrame frame = (IJavaStackFrame) element;
            return ((JDIThread) frame.getThread()).getThreadRule();
        }
        return null;
    }

    @Override
    public synchronized void update(ILabelUpdate[] updates) {
        // TODO Auto-generated method stub
        super.update(updates);
    }

}
