package org.neuro4j.studio.debug.ui.views.flowbreakpoints;



import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;

public class DeleteBreakPointAction extends Action {
	private TreeViewer fViewer;

	public DeleteBreakPointAction(TreeViewer viewer) {
		setViewer(viewer);
	}

	public void run() {
		ISelection selection =  getViewer().getSelection();
		TreeSelection ts = (TreeSelection)selection;
		
		TreePath[] path = ts.getPaths();
		FlowLineBreakpointAdapter[] array = new FlowLineBreakpointAdapter[path.length];
		int  index = 0;
		for (TreePath p: path){
			array[index++] =  (FlowLineBreakpointAdapter)p.getFirstSegment();
		}	
		
		try {
			BreakpoinMng.getInstance().removeBreakpoints(array);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected TreeViewer getViewer() {
		return fViewer;
	}

	protected void setViewer(TreeViewer viewer) {
		fViewer = viewer;
	}
}