package org.neuro4j.studio.debug.adapter;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.neuro4j.workflow.WorkflowRequest;
import org.neuro4j.workflow.debug.DebugTarget;
import org.neuro4j.workflow.node.WorkflowNode;

public class JavaFlowDebugger implements DebugTarget{

	private JDIDebugTarget target;
	
	public JavaFlowDebugger(JDIDebugTarget target){
		this.target = target;
	}
	

	
	@Override
	public void onNodeCall(WorkflowNode arg0, WorkflowRequest arg1) {
		System.out.println("dd");
		try {
			target.suspend();
		} catch (DebugException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
