{packageFullName}


import java.util.HashMap;
import java.util.Map;

import org.neuro4j.workflow.ExecutionResult;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;
import org.neuro4j.workflow.common.TriggerBlock;
{staticImport}

@ParameterDefinitionList(input={
                                	},
                         output={
                         	       {outputParameters}})	
public class {fileName} extends TriggerBlock {
    
    {outputBlock1}
    
    
	
	
	// add your methods here
	public void yourMethod() {
         	
		/*
		 * 	put your code here 
		 * 
		 */
		
	
        Map<String, Object> parameters = new HashMap<String, Object>();

        // put output parameter to map.
        {outputBlock2}
        ExecutionResult result = executeFlow(parameters);

	}
	

}
