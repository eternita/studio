package org.neuro4j.studio.core;

import java.util.HashMap;
import java.util.Map;

import org.neuro4j.workflow.Workflow;
import org.neuro4j.workflow.node.WorkflowNode;



public class XmlWorkflow extends Workflow {
	
	private Map<String, WorkflowNode> map = new HashMap<String, WorkflowNode>();

	public XmlWorkflow(String flowName, String flowPackage) {
		super(flowName, flowPackage);
	}
	
	public WorkflowNode getNodeByName(String name){
		return map.get(name);
	}

	@Override
	public void registerNode(WorkflowNode entity) {
		super.registerNode(entity);
		map.put(entity.getName(), entity);
	}
	
	
	

}
