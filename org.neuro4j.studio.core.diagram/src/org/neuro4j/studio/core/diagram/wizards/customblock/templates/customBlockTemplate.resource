{packageFullName}


import org.neuro4j.workflow.FlowContext;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;
import org.neuro4j.workflow.ActionBlock;
import static org.neuro4j.workflow.enums.ActionBlockCache.*;
{staticImport}

@ParameterDefinitionList(input={
                                	{inputParameters}},
                         output={
                         	       {outputParameters}})	
@CachedNode(type=NONE)                         	       
public class {fileName} implements ActionBlock {
    
    {inputBlock1}  
    {outputBlock1}
    
    
    public int execute(FlowContext ctx) throws FlowExecutionException {
		
		{inputBlock2}
		
		//TODO: put your code here
		
        if (/*error != */false)
        {
        	return ERROR;
        }
		
		{outputBlock2}
		
		return NEXT;
	}
	
	

}
