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
package org.neuro4j.studio.debug.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointsListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.debug.internal.ui.views.breakpoints.BreakpointContainer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.debug.core.model.JDIStackFrame;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.parts.NodeBaseEditPart;
import org.neuro4j.studio.core.diagram.markers.MarkerMng;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorUtil;
import org.neuro4j.studio.core.impl.CallNodeImpl;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.debug.core.model.ActionNodeBreakpoint;
import org.neuro4j.studio.debug.core.model.FlowDebugTarget;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;
import org.neuro4j.studio.debug.core.model.MarkerManager;
import org.neuro4j.workflow.debug.DebugService;

public class BreakpoinMng {
	
	
	
	public static final String DEBUGSERV_STRING = DebugService.class.getCanonicalName();

    private boolean isBaseBreakpointLoaded = false;

    IDebugTarget currentTarget = null;

    NodeBaseEditPart lastSuspendedEditPart = null;

    boolean nextStepInProgress = false;

    private static final String UUIDS = "uuids";

    Map<String, Set<String>> nodesWithDebugMarkers = new HashMap<String, Set<String>>();

    private static BreakpoinMng instance = new BreakpoinMng();

    Set<String> uuidsInBreakpoints = new HashSet<String>();

    List<IBreakpointsListener> listeners = new ArrayList<IBreakpointsListener>();

    List<BreakpointContainer> containers = new ArrayList<BreakpointContainer>();
    
    private  FlowLineBreakpointAdapter[] activeBreakpoints = null; 

    private BreakpoinMng()
    {

    }

    public static BreakpoinMng getInstance()
    {
    
        return instance;
    }


    
    public void removeBreakpointByUUID(String uuid)
    {
    	activeBreakpoints = null;
    	
        FlowLineBreakpointAdapter[] javaLineBreakpoints = BreakpoinMng.getInstance().getBreakpoints();
        for (FlowLineBreakpointAdapter adapter : javaLineBreakpoints)
        {
            IBreakpoint ib = adapter.getJavaLineBreakpoint();
            IMarker marker = ib.getMarker();
            String uuids = marker.getAttribute(UUIDS, "");
            if (uuids.contains(uuid))
            {
                removeNodeFromBreakpoint((JavaLineBreakpoint) ib, uuid);
            }
        }
    }

    @SuppressWarnings("restriction")
    public void removeNodeFromBreakpoint(ActionNode node) {
        JavaLineBreakpoint javaLineBreakpoint = BreakpoinMng.getInstance().getExistingBreakPoint();
        if (javaLineBreakpoint != null) {

            removeNodeFromBreakpoint(javaLineBreakpoint, node.getId());
        }
    }

    @SuppressWarnings("restriction")
    private void removeNodeFromBreakpoint(JavaLineBreakpoint javaLineBreakpoint, String uuid) {
    	activeBreakpoints = null;
        try {
            removeBreakpoints(new FlowLineBreakpointAdapter[] { new FlowLineBreakpointAdapter(uuid, javaLineBreakpoint) });
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void removeFlowBreakpoint(JavaLineBreakpoint javaLineBreakpoint,
            String uuid) {
    	
    	activeBreakpoints = null;
    	
        try {
            // hide debug element
            NodeBaseEditPart part = (NodeBaseEditPart) MarkerMng.getInstance().getEditPartAndMark(uuid);

            if (part != null)
            {
                part.hideDebugElement();
            }

            // remove uuid from attribute
            removeUuid(javaLineBreakpoint, uuid);

            IMarker marker = javaLineBreakpoint.getMarker();
            String uuids = marker.getAttribute(UUIDS, "");
            // removed last node
            if (uuids.length() < 24)
            {

                return;
            }

            MarkerMng.getInstance().updateMarker(javaLineBreakpoint.getMarker());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void removeUuid(JavaLineBreakpoint javaLineBreakpoint, String id) {

        uuidsInBreakpoints.remove(id);

        IMarker marker = javaLineBreakpoint.getMarker();
        String uuids = marker.getAttribute(UUIDS, "");
        uuids = uuids.replace(id, "");
        String[] us = uuids.trim().split(" ");
        StringBuffer stb = new StringBuffer();
        for (String uuid : us)
        {
            if (uuid.length() < 20)
            {
                continue;
            }
            stb.append(uuid).append(" ");
        }
        try {
            marker.setAttribute(UUIDS, stb.toString().trim());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("restriction")
    public JavaLineBreakpoint getExistingBreakPoint()
    {
        IBreakpoint[] bps = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints();
        for (IBreakpoint bp : bps)
        {
            String flowType = bp.getMarker().getAttribute("flowType", "");

            if (flowType.equals(DEBUGSERV_STRING))
            {
                return (JavaLineBreakpoint) bp;
            }
        }
        return null;
    }

    public void updateFigure(ActionNode node, boolean showDebugElement)
    {
        IEditorPart editorPart = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart instanceof IDiagramWorkbenchPart) {

            DiagramEditPart diagramPart = ((IDiagramWorkbenchPart) editorPart)
                    .getDiagramEditPart();
            // EObject element = prev;
            List<EditPart> editPartCollector = new ArrayList<EditPart>();

            Neuro4jDiagramEditorUtil.findElementsInDiagramByID(diagramPart, node,
                    editPartCollector);
            if (editPartCollector.size() == 1) {
                if (editPartCollector.get(0) instanceof NodeBaseEditPart)
                {
                    NodeBaseEditPart editPart = (NodeBaseEditPart) editPartCollector.get(0);
                    if (showDebugElement)
                    {
                        editPart.showDebugElement();
                    } else {
                        editPart.hideDebugElement();
                    }

                }

            }

        }

    }

    @SuppressWarnings("restriction")
    public JavaLineBreakpoint createBreakPoint()
    {

        if (!BreakpoinMng.getInstance().hasClassInClasspath(DEBUGSERV_STRING))
        {

            return null;
        }

        JavaLineBreakpoint lineBreakpoint = null;

        try {

            lineBreakpoint = new ActionNodeBreakpoint(DEBUGSERV_STRING);

            // lineBreakpoint.setCondition("lba.getUuid().equals(\"" + node.getId() +"\")");
            lineBreakpoint.setCondition("1==1");
            lineBreakpoint.setConditionEnabled(true);
            lineBreakpoint.setConditionSuspendOnTrue(true);
            IDebugTarget target = BreakpoinMng.getInstance().getCurrentTarget();
            if (target != null)
            {
                lineBreakpoint.addToTarget((JDIDebugTarget) target);
            }

            DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
            return lineBreakpoint;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public void clearBreakpoint(IBreakpoint bp) {
        // TODO Auto-generated method stub

    }

    public static String getResourceName(JDIStackFrame gframe) throws CoreException
    {

        String uuid = getCurrentUuid(gframe);
        if (uuid != null)
        {

            String resource = getResourceByUUID(uuid);
            return resource;

        }

        return null;
    }

    public static boolean isValidFrame(JDIStackFrame frame) {

        Field f;
        try {
            f = frame.getClass().getDeclaredField("fDepth");
            f.setAccessible(true);
            Integer o = (Integer) f.get(frame); // IllegalAccessException
            return o > 0;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    public static String[] getNodeNameAndUuid(JDIStackFrame gframe) throws CoreException
    {
        if (gframe == null)
        {
            return null;
        }

        // if(!isValidFrame(gframe)){
        // return null;
        // }
        if (gframe.hasVariables())
        {
            IVariable[] list = gframe.getVariables();
            if (list.length > 0)
            {
                IVariable thisV = list[1];
                IJavaVariable javaV = (IJavaVariable) thisV;
                // String name = javaV.getName();

                // IVariable lba = lbaObject(javaV);

                if (javaV != null)
                {
                    String uuid = getUUIDfromLba(javaV);
                    String name = getNamefromLba(javaV);
                    // String packageName = getCurrentPackage(gframe);
                    // return packageName + " : " + name + "(" + uuid + ")";
                    return new String[] { name, uuid };
                }

            }

        }

        return null;
    }

    public static String getCurrentUuid(JDIStackFrame gframe) throws CoreException
    {
        if (gframe == null)
        {
            return null;
        }

        if (gframe.hasVariables())
        {
            IVariable[] list = gframe.getVariables();
            if (list.length > 0)
            {
            	IVariable thisV = null;
            	if (gframe.getDeclaringTypeName().equals(CallNodeImpl.IMPL_CLASS))
            	{
            		 thisV = list[0];
            	} else {
            		 thisV = list[1];	
            	}
               
                IJavaVariable javaV = (IJavaVariable) thisV;
                // String name = javaV.getName();

                String uuid = getUUIDfromLba(javaV);
                return uuid;

            }

        }

        return null;
    }

    public static String getCurrentPackage(JDIStackFrame gframe) throws CoreException
    {
        if (gframe == null)
        {
            return null;
        }

        if (gframe.hasVariables())
        {
            IVariable[] list = gframe.getVariables();
            if (list.length > 0)
            {
                IVariable thisV = list[1];
                IJavaVariable javaV = (IJavaVariable) thisV;
                // String name = javaV.getName();

                if (javaV.getName().equals("context")
                        || javaV.getName().equals("ctx")) {
                    IVariable[] vars = javaV.getValue().getVariables();
                    for (IVariable v : vars) {
                        if (v.getName().equals("packages")) {
                           // JDIFieldVariable packages = (JDIFieldVariable) v;
                          //  JDIFieldVariable data = (JDIFieldVariable) packages.getValue().getVariables()[4];
                            // data.getValue().getV
                          //  ObjectReferenceImpl c = (ObjectReferenceImpl) packages.getObjectReference();
                            return v.getName();
                        }

                    }
                }

            }

        }

        return null;
    }


    public static String getUUIDfromLba(IVariable lba) throws DebugException
    {
        IVariable[] vars = lba.getValue().getVariables();
        for (IVariable var : vars)
        {
            if (var.getName().equals("uuid"))
                return var.getValue().getValueString();
        }
        return null;
    }

    public static String getNamefromLba(IVariable lba) throws DebugException
    {
        IVariable[] vars = lba.getValue().getVariables();
        for (IVariable var : vars)
        {
            if (var.getName().equals("name"))
                return var.getValue().getValueString();
        }
        return null;
    }

    public static String getResourceByUUID(String uuid) throws CoreException
    {

        if (uuid == null)
        {
            return null;
        }

        IFile resource = ResourceFinder.getInstance().findFileWithUUID(uuid);
        if (resource != null)
        {
            return resource.getProjectRelativePath().toPortableString();
        }

        IResource res = ClassloaderHelper.getCurrentResource();
        if (res != null)
        {
            return res.getProjectRelativePath().toPortableString();
        }
        return null;

    }

    public void suspend(NodeBaseEditPart currentNode)
    {
        resume();

        lastSuspendedEditPart = currentNode;
        if (lastSuspendedEditPart != null)
        {
            lastSuspendedEditPart.suspendFigureOnStop();
        }
    }

    public void resume()
    {
        if (lastSuspendedEditPart != null)
        {
            lastSuspendedEditPart.resumeFigureOnStop();
        }

    }

    public void disconect()
    {
        resume();

        lastSuspendedEditPart = null;
        nextStepInProgress = false;
    }

    public IDebugTarget getCurrentTarget() {
        return currentTarget;
    }

    public void setCurrentTarget(IDebugTarget currentTarget) {
        this.currentTarget = currentTarget;
    }

    public boolean isUUIDInBreakpoint(String uuid) {
        if (nextStepInProgress)
        {
            return true;
        }

        return uuidsInBreakpoints.contains(uuid);
    }

    public void registerUUIDForSuspend(String uuid) {
        uuidsInBreakpoints.add(uuid);
    }

    public void unregisterUUIDs()
    {
        uuidsInBreakpoints.clear();
    }

    public void setNextStepInProgress(boolean nextStepInProgress) {
        this.nextStepInProgress = nextStepInProgress;
    }

    public void removeBreakpointListener(IBreakpointsListener listener)
    {
        listeners.remove(listener);
    }

    public void addBreakpointListener(IBreakpointsListener listener) {
        listeners.add(listener);
    }

    public FlowLineBreakpointAdapter[] getBreakpoints() {
    	if (activeBreakpoints != null)
    	{
    		return activeBreakpoints;
    	}
        IBreakpoint[] bps = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints();
        List<FlowLineBreakpointAdapter> list = new ArrayList<FlowLineBreakpointAdapter>();
        for (IBreakpoint bp : bps)
        {
            IMarker marker = bp.getMarker();
            String uuids = marker.getAttribute(UUIDS, "");
            String[] us = uuids.trim().split(" ");
            for (String uuid : us)
            {
                if (uuid.length() < 20)
                {
                    continue;
                }
                FlowLineBreakpointAdapter a = new FlowLineBreakpointAdapter(uuid, bp);
                list.add(a);
            }

        }
        return list.toArray(new FlowLineBreakpointAdapter[list.size()]);
    }

    public void removeBreakpoints(FlowLineBreakpointAdapter[] breakpoints) throws CoreException {

        for (FlowLineBreakpointAdapter bp : breakpoints)
        {
            ModelDelta parent = new ModelDelta(null, IModelDelta.NO_CHANGE);
            removeFlowBreakpoint((JavaLineBreakpoint) bp.getJavaLineBreakpoint(), bp.getUuid());

            for (BreakpointContainer container : containers)
            {
                container.removeBreakpoint(bp, parent);
            }
        }

        for (IBreakpointsListener listener : listeners)
        {
            listener.breakpointsRemoved(breakpoints, null);
        }

    }

    public void registerBreakpointContainer(BreakpointContainer container) {
        containers.add(container);
    }

    public void addUuidToBreakpoint(JavaLineBreakpoint javaLineBreakpoint, ActionNode node) {

        FlowLineBreakpointAdapter adapter = new FlowLineBreakpointAdapter(node.getId(), javaLineBreakpoint);

        IMarker marker = javaLineBreakpoint.getMarker();
        String uuids = marker.getAttribute(UUIDS, "");
        if (uuids.contains(node.getId()))
        {
            return;
        }
        uuids = uuids + " " + node.getId();
        try {
            marker.setAttribute(UUIDS, uuids);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        registerUUIDForSuspend(node.getId());
        ModelDelta parent = new ModelDelta(null, IModelDelta.NO_CHANGE);

        for (BreakpointContainer container : containers)
        {
            container.addBreakpoint(adapter, parent);
        }

        FlowLineBreakpointAdapter[] array = new FlowLineBreakpointAdapter[] { adapter };

        for (IBreakpointsListener listener : listeners)
        {
            listener.breakpointsAdded(array);
        }
    }

    public void loadBaseBreakpointsIfNotLoaded() {
        if (!isBaseBreakpointLoaded)
        {
            initializeCoreBreakpoints();
            isBaseBreakpointLoaded = true;
        }

    }

    protected void initializeCoreBreakpoints() {
    	boolean flowBreakpoinLoaded = false;
        unregisterUUIDs();
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints();
        
        for (int i = 0; i < breakpoints.length; i++) {
            IBreakpoint bp = breakpoints[i];
            if (bp instanceof JavaLineBreakpoint)
            {
                JavaLineBreakpoint jlb = (JavaLineBreakpoint) bp;
                try {
                    if (jlb.getMarker().getAttribute("flowType") == null) {
                        continue;
                    }
                    
                    flowBreakpoinLoaded = true;

                } catch (CoreException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }


        if (!flowBreakpoinLoaded)
        {
            JavaLineBreakpoint bp = (ActionNodeBreakpoint) BreakpoinMng.getInstance().createBreakPoint();

            try {
                DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(bp);
            } catch (CoreException e) {
                e.printStackTrace();
            }        	
        }

        

    }

    public boolean hasClassInClasspath(String node)
    {
        IResource resource = MarkerManager.getBeehiveElementMarkerResource(node);

        if (resource == null)
        {
            org.neuro4j.studio.core.buildpath.ExceptionHandler.handle("Debug Configuration Error", node + " not found in classpath. Please add Neuro4j library to classpath.");
            return false;
        } else {
            return true;
        }
    }

}
