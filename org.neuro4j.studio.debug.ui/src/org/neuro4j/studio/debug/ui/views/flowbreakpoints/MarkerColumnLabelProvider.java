package org.neuro4j.studio.debug.ui.views.flowbreakpoints;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.ResourceFinder;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

public class MarkerColumnLabelProvider extends ColumnLabelProvider{

	ResourceFinder resourceFinder = ResourceFinder.getInstance();
	
	@Override
	public Color getBackground(Object element) {
		return super.getBackground(element);
	}

	@Override
	public Font getFont(Object element) {
		return super.getFont(element);
	}

	@Override
	public Color getForeground(Object element) {
		return super.getForeground(element);
	}

	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}

	@Override
	public String getText(Object el) {
		
		FlowLineBreakpointAdapter element = (FlowLineBreakpointAdapter)el;
		
        String flowName = resourceFinder.getFlowNameByUuid(element.getUuid());
        if (ResourceFinder.UNKNOWN == flowName)
        {
            BreakpoinMng.getInstance().removeBreakpointByUUID(element.getUuid());
            return "";
        }

        String nodeName = resourceFinder.getNodeNameByUUid(element.getUuid());

        return flowName + " - " + nodeName + " : (" + element.getUuid() + ")";

        
	}

	@Override
	public void update(ViewerCell cell) {
		super.update(cell);
	}

}
