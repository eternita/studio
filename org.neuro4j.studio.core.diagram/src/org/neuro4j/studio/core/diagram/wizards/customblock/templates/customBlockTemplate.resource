{packageFullName}


import org.neuro4j.workflow.FlowContext;
import org.neuro4j.workflow.common.FlowExecutionException;
import org.neuro4j.workflow.common.FlowInitializationException;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;
import org.neuro4j.workflow.node.CustomBlock;
{staticImport}

@ParameterDefinitionList(input={
                                	{inputParameters}},
                         output={
                         	       {outputParameters}})	
public class {fileName} extends CustomBlock {
    
    {inputBlock1}  
    {outputBlock1}
    
    @Override
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
	
	@Override
	protected void init() throws FlowInitializationException{
		super.init();
	}
	

}
