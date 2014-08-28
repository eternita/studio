package org.neuro4j.studio.debug.ui.views.flowbreakpoints;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

public class BreakpointsViewerContentProvider 
	implements ITreeContentProvider
	{
	  private Object input;
	  private final NewFlowBreakpoinsView markersView;

	  public BreakpointsViewerContentProvider(NewFlowBreakpoinsView extendedMarkersView)
	  {
	    this.markersView = extendedMarkersView;
	  }

	  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	  {
	    this.input = newInput;
	  }

	  public void dispose()
	  {
	  }

	  public Object[] getChildren(Object parentElement)
	  {
	    return null;
	  }

	  public Object[] getElements(Object inputElement)
	  {
	    return (FlowLineBreakpointAdapter[])this.input;
	  }


	  public Object getParent(Object element)
	  {
	      return this.input;
	  }

	  public boolean hasChildren(Object element)
	  {
	    return false;
	  }
	}