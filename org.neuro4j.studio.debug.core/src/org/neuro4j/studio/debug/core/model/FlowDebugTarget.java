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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IRequest;
import org.eclipse.debug.core.commands.IDebugCommandHandler;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.internal.core.commands.ResumeCommand;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.internal.ui.commands.actions.ExecuteActionRequest;
import org.eclipse.debug.internal.ui.commands.actions.ICommandParticipant;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaLineBreakpoint;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.neuro4j.studio.debug.core.BreakpoinMng;

import com.sun.jdi.VirtualMachine;

public class FlowDebugTarget extends JDIDebugTarget {

	private boolean isStepOver = false;

	public FlowDebugTarget(ILaunch launch, VirtualMachine jvm, String name,
			boolean supportTerminate, boolean supportDisconnect,
			IProcess process, boolean resume) {
		super(launch, jvm, name, supportTerminate, supportDisconnect, process,
				resume);
		//DebugService.getInstance().setTarget(new JavaFlowDebugger(this));
	}

	@SuppressWarnings("restriction")
	private DebugEvent handleEvent(final DebugEvent event,
			List<ExecuteActionRequest> requests) {

		switch (event.getKind()) {
		case DebugEvent.RESUME:

			if (event.getDetail() == DebugEvent.CLIENT_REQUEST) {
				if (isStepOver) {
					isStepOver = false;
				} else {
					BreakpoinMng.getInstance().setNextStepInProgress(false);
					BreakpoinMng.getInstance().disconect();
				}

				return event;
			}
			if (event.getDetail() == DebugEvent.STEP_OVER) {
				isStepOver = true;
				BreakpoinMng.getInstance().setNextStepInProgress(true);
				return event;
			}
			break;
		case DebugEvent.SUSPEND:

			if (event.getDetail() == DebugEvent.STEP_END) {
				isStepOver = true;
				BreakpoinMng.getInstance().resume();
				BreakpoinMng.getInstance().setNextStepInProgress(true);
				Object element = event.getSource();

				ExecuteActionRequest request = new ExecuteActionRequest(
						new Object[] { element });

				request.setCommandParticipant(new ICommandParticipant() {

					@Override
					public void requestDone(IRequest irequest) {

					}
				});
				requests.add(request);
				BreakpoinMng.getInstance().setNextStepInProgress(true);
				return event;
			}
			break;
		case DebugEvent.TERMINATE:
			processDisconect();
			break;
		case DebugEvent.CLIENT_REQUEST:
			if (event.getDetail() == 126) {
				BreakpoinMng.getInstance().setNextStepInProgress(true);
			}
			break;
		default:
			break;
		}

		return event;
	}

	private void processDisconect() {
		BreakpoinMng.getInstance().setCurrentTarget(null);

		BreakpoinMng.getInstance().disconect();

		// TODO: disconect - change color
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {

		if (breakpoint instanceof ActionNodeBreakpoint) {
			addActionNodeBreakpoint((ActionNodeBreakpoint) breakpoint);
		}
		super.breakpointAdded(breakpoint);

	}

	private void addActionNodeBreakpoint(ActionNodeBreakpoint bp) {
		bp.connectBreakpoint();

	}

	@Override
	protected void cleanup() {
		BreakpoinMng.getInstance().disconect();
		super.cleanup();
	}

	@Override
	protected void disconnected() {
		super.disconnected();
		isStepOver = false;
		DebugUIPlugin
				.getDefault()
				.getPreferenceStore()
				.setValue(IInternalDebugUIConstants.PREF_ACTIVATE_DEBUG_VIEW,
						Boolean.TRUE);
	}

	@Override
	public void handleDebugEvents(DebugEvent[] events) {
		List<ExecuteActionRequest> requests = new ArrayList<ExecuteActionRequest>(1);
		for (DebugEvent event : events) {
			DebugEvent e = handleEvent(event, requests);
		}

		super.handleDebugEvents(events);
		if (!requests.isEmpty())
		{
			postProcess(requests);	
		}
		
	}

	private void postProcess(List<ExecuteActionRequest> requests) {
		for (ExecuteActionRequest request : requests) {
			IDebugCommandHandler handler = new ResumeCommand();

			handler.execute(request);

		}

	}

	@Override
	protected void initializeBreakpoints() {

		boolean flowBreakpoinLoaded = false;

		BreakpoinMng.getInstance().unregisterUUIDs();
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager().getBreakpoints();

		for (int i = 0; i < breakpoints.length; i++) {
			IBreakpoint bp = breakpoints[i];
			if (bp instanceof JavaLineBreakpoint) {
				JavaLineBreakpoint jlb = (JavaLineBreakpoint) bp;
				
				try {
					if (jlb.getMarker().getAttribute("flowType") == null) {
						continue;
					}
					FlowLineBreakpoint b = new ActionNodeBreakpoint(jlb);
					//jlb.addToTarget(this);
					breakpointAdded(b);
					flowBreakpoinLoaded = true;
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		if (!flowBreakpoinLoaded) {

			JavaLineBreakpoint bp = (ActionNodeBreakpoint) BreakpoinMng
					.getInstance().createBreakPoint();
//			try {
//                bp.addToTarget(this);
//            } catch (CoreException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
			breakpointAdded(bp);
		}

	}

	@Override
	public void resume() throws DebugException {
		super.resume();
		BreakpoinMng.getInstance().resume();
	}

	@Override
	public void terminate() throws DebugException {
		BreakpoinMng.getInstance().setCurrentTarget(null);
		isStepOver = false;
		super.terminate();
	}

}
