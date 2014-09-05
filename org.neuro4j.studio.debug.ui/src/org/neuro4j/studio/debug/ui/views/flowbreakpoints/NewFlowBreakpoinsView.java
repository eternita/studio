package org.neuro4j.studio.debug.ui.views.flowbreakpoints;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.IBreakpointsListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.neuro4j.studio.debug.core.ResourceFinder;
import org.neuro4j.studio.debug.core.model.FlowLineBreakpointAdapter;



public class NewFlowBreakpoinsView extends ViewPart implements IBreakpointsListener {

	private TreeViewer viewer;
	private boolean treePainted = false;
	private IMemento memento;
	IContentProvider contentProvider = null;

	@Override
	public void createPartControl(Composite parent) {
		createViewer(parent);

		 addDoubleClickListener();
		//
		// addPageAndPartSelectionListener();
		//
		// addLinkWithEditorSupport();
		//
		// addExpansionListener();
		//
		// addHelpListener();
		//
		// addSelectionListener();
		//
		// registerContextMenu();
		//
		// initDragAndDrop();
		
		addBreakpoinListener();
		
		getSite().setSelectionProvider(this.viewer);


		startView();
	}
	
	  private void addDoubleClickListener()
	  {
	    this.viewer.addDoubleClickListener(new IDoubleClickListener() {
	      public void doubleClick(DoubleClickEvent event) {
	        ISelection selection = event.getSelection();
	        if ((selection instanceof ITreeSelection)) {
	          ITreeSelection ss = (ITreeSelection)selection;
	          if (ss.size() == 1) {
	        	FlowLineBreakpointAdapter obj = (FlowLineBreakpointAdapter)ss.getFirstElement();
	            IWorkbench iworkbench = PlatformUI.getWorkbench();
	            if (iworkbench != null) {
	                IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
	                if (iworkbenchwindow != null) {
	                    IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
	                    IFile file = ResourceFinder.getInstance().findFileWithUUID(obj.getUuid());
	                    
	                    try {
	                        IDE.openEditor(iworkbenchpage, file);
	                    } catch ( PartInitException e ) {
	                        //Put your exception handler here if you wish to
	                    }
	                }
	            }
	          }
	        }
	      }
	    });
	  }
	
	private void addBreakpoinListener()
	{
		BreakpoinMng.getInstance().addBreakpointListener(this);
	}

	private void startView() {
		
		this.viewer.setInput(BreakpoinMng.getInstance().getBreakpoints());

		contentProvider = this.viewer.getContentProvider();


	}

	Object getViewerInput() {
		return this.viewer.getInput();
	}

	@Override
	public void setFocus() {

	}

	private void createViewer(Composite parent) {
		parent.setLayout(new FillLayout());

		this.viewer = new TreeViewer(new Tree(parent, 66306));

		this.viewer.getTree().setLinesVisible(true);
		this.viewer.setUseHashlookup(true);
		createColumns(new TreeColumn[0], new int[0]);
		this.viewer.setContentProvider(getContentProvider());

		this.viewer.getTree().addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				NewFlowBreakpoinsView.this.treePainted = true;
				NewFlowBreakpoinsView.this.viewer.getTree()
						.removePaintListener(this);
			}
		});
	}

	private IContentProvider getContentProvider() {
		return new BreakpointsViewerContentProvider(this);
	}

	private void createColumns(TreeColumn[] currentColumns, int[] widths) {
		Tree tree = this.viewer.getTree();
		TableLayout layout = new TableLayout();



		TreeViewerColumn column = null;
		layout.addColumnData(new ColumnPixelData(440, true, true));
		column = new TreeViewerColumn(this.viewer, 0);
		column.setLabelProvider(new MarkerColumnLabelProvider());
		column.getColumn().setText("breakpoints");



		this.viewer.getTree().setLayout(layout);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.layout(true);
		

	}

	TreeViewer getViewer() {
		return this.viewer;
	}

	@Override
	public void breakpointsAdded(IBreakpoint[] arg0) {
		if(!this.viewer.getControl().isDisposed())
		{
			this.viewer.setInput(BreakpoinMng.getInstance().getBreakpoints());				
		}
		
	}

	@Override
	public void breakpointsChanged(IBreakpoint[] arg0, IMarkerDelta[] arg1) {
		this.viewer.setInput(BreakpoinMng.getInstance().getBreakpoints());
		
	}

	@Override
	public void breakpointsRemoved(IBreakpoint[] arg0, IMarkerDelta[] arg1) {
		if(!this.viewer.getControl().isDisposed())
		{
			this.viewer.setInput(BreakpoinMng.getInstance().getBreakpoints());				
		}

		
	}


}