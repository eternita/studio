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

package org.neuro4j.studio.core.views.flows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener2;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.neuro4j.studio.core.Neuro4jCorePlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.providers.SelectedConnectionProvider;
import org.neuro4j.studio.core.diagram.providers.SelectedListEntryProvider;
import org.neuro4j.studio.core.util.AbstractEntry;
import org.neuro4j.studio.core.util.CollectionWorkspaceUpdater;
import org.neuro4j.studio.core.util.FlowFromJarsLoader;
import org.neuro4j.studio.core.util.Group;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;
import org.neuro4j.studio.core.util.LogSession;
import org.neuro4j.studio.core.util.MapWorkspaceUpdater;
import org.neuro4j.studio.core.util.WorkspaceUpdater;
import org.neuro4j.studio.core.views.dialogs.FlowResourcesSelectionDialog.FlowContentProvider;
import org.osgi.service.prefs.Preferences;

public abstract class AbstractListView extends ViewPart {

    FlowContentProvider contentProvider = null;
    public static final String P_LOG_WARNING = "warning"; //$NON-NLS-1$
    public static final String P_LOG_ERROR = "error"; //$NON-NLS-1$
    public static final String P_LOG_INFO = "info"; //$NON-NLS-1$
    public static final String P_LOG_OK = "ok"; //$NON-NLS-1$
    public static final String P_LOG_LIMIT = "limit"; //$NON-NLS-1$
    public static final String P_USE_LIMIT = "useLimit"; //$NON-NLS-1$
    public static final String P_SHOW_ALL_SESSIONS = "allSessions"; //$NON-NLS-1$
    protected static final String P_COLUMN_1 = "column2"; //$NON-NLS-1$
    protected static final String P_COLUMN_2 = "column3"; //$NON-NLS-1$
    protected static final String P_COLUMN_3 = "column4"; //$NON-NLS-1$
    public static final String P_ACTIVATE = "activate"; //$NON-NLS-1$
    public static final String P_SHOW_FILTER_TEXT = "show_filter_text"; //$NON-NLS-1$
    public static final String P_ORDER_TYPE = "orderType"; //$NON-NLS-1$
    public static final String P_ORDER_VALUE = "orderValue"; //$NON-NLS-1$
    public static final String P_IMPORT_LOG = "importLog"; //$NON-NLS-1$
    public static final String P_GROUP_BY = "groupBy"; //$NON-NLS-1$

    private int MESSAGE_ORDER;
    private int PLUGIN_ORDER;
    private int DATE_ORDER;

    public final static byte MESSAGE = 0x0;
    public final static byte PLUGIN = 0x1;
    public final static byte DATE = 0x2;
    public static int ASCENDING = 1;
    public static int DESCENDING = -1;

    public static final int GROUP_BY_NONE = 0;
    public static final int GROUP_BY_SESSION = 1;
    public static final int GROUP_BY_PLUGIN = 2;

    protected List elements;
    protected Map groups;
    protected LogSession currentSession;

    private List batchedEntries;
    private boolean batchEntries;

    private IMemento fMemento;

    private Comparator fComparator;

    // hover text
    private boolean fCanOpenTextShell;
    private Text fTextLabel;
    private Shell fTextShell;

    private TreeColumn fColumn1;
    private TreeColumn fColumn2;
    private TreeColumn fColumn3;

    protected Tree fTree;
    protected FilteredTree fFilteredTree;
    protected FlowViewLabelProvider fLabelProvider;

    protected Display fDisplay = null;

    WorkflowSearchEngine workflowSearchEngine;

    /**
     * Constructor
     */
    public AbstractListView(ListEntryType type) {
        switch (type) {
            case FLOW:
                elements = new ArrayList();     
                break;

            default:
                elements = new FilteredList(type);
                break;
        }
        groups = new HashMap();
        batchedEntries = new ArrayList();
        workflowSearchEngine = new WorkflowSearchEngine();
        Neuro4jDiagramEditorPlugin.getInstance().addListToObserver(getUpdater());
    }

    public abstract  CollectionWorkspaceUpdater getUpdater();

    
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    public void createPartControl(Composite parent) {
        fDisplay = getSite().getShell().getDisplay();
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        composite.setLayout(layout);

        loadElements();
        createViewer(composite);
        getSite().setSelectionProvider(fFilteredTree.getViewer());
        fTree.setToolTipText(""); //$NON-NLS-1$
        initializeViewerSorter();

        makeHoverShell();

        getSite().getWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener2() {

            public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, IWorkbenchPartReference partRef, String changeId) {
                if (!(partRef instanceof IViewReference))
                    return;

                IWorkbenchPart part = partRef.getPart(false);
                if (part == null) {
                    return;
                }

                if (part.equals(AbstractListView.this)) {
                    if (changeId.equals(IWorkbenchPage.CHANGE_VIEW_SHOW)) {
                        if (!batchedEntries.isEmpty()) {
                            pushBatchedEntries();
                        }

                        batchEntries = false;
                    } else if (changeId.equals(IWorkbenchPage.CHANGE_VIEW_HIDE)) {
                        batchEntries = true;
                    }
                }
            }

            public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
                // empty
            }

            public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
                // empty
            }

        });
    }

    void createViewer(Composite parent) {
        PatternFilter filter = new PatternFilter() {
            private final Object[] empty = new  Object[0];
            public final Object[] filter(Viewer viewer, Object parent, Object[] elements) {
                ArrayList out = null;
                for (Object obj : elements)
                {
                    ListEntry entry = (ListEntry) obj;
                    
                    if (entry.getType() == ListEntryType.CHILD)
                    {
                        return elements;
                    } else if (out == null){
                        out = new ArrayList(elements.length);
                    }
                    if (wordMatches(entry.getMessage()))
                    {

                        out.add(entry);
                    }
                }
                if (out == null)
                {
                    return empty;
                }
                return out.toArray();
            }
        };
        filter.setIncludeLeadingWildcard(true);
        fFilteredTree = new FilteredTree(parent, SWT.FULL_SELECTION, filter, true);
        // need to give filter Textbox some space from the border
        if (fFilteredTree.getFilterControl() != null) {
            Composite filterComposite = fFilteredTree.getFilterControl().getParent(); // FilteredTree new look lays
                                                                                      // filter Text on additional
                                                                                      // composite
            GridData gd = (GridData) filterComposite.getLayoutData();
            gd.verticalIndent = 2;
            gd.horizontalIndent = 1;
        }
        fFilteredTree.setLayoutData(new GridData(GridData.FILL_BOTH));
        fFilteredTree.setInitialText(Messages.FlowView_show_filter_initialText);
        fTree = fFilteredTree.getViewer().getTree();
        fTree.setLinesVisible(true);
        createColumns(fTree);
        fFilteredTree.getViewer().setContentProvider(new ListViewContentProvider(this));
        fFilteredTree.getViewer().setLabelProvider(fLabelProvider = new FlowViewLabelProvider(this));
        fLabelProvider.connect(this);
        fFilteredTree.getViewer().setAutoExpandLevel(0);
        fFilteredTree.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent e) {
                handleSelectionChanged(e.getSelection());
            }
        });
        
        fFilteredTree.getViewer().addDoubleClickListener(new IDoubleClickListener() {
            public void doubleClick(DoubleClickEvent event) {
                ListEntry entry = (ListEntry) ((TreeSelection) event.getSelection()).getFirstElement();
                openEntry(entry);
            }

            private void openEntry(ListEntry entry) {
                if (entry.getResource() != null)
                {
                    openResource(entry.getResource());
                }
                
            }
        });
        fFilteredTree.getViewer().setInput(this);
        addMouseListeners();

    }
    
    protected void openResource(final IFile resource) {
        final IWorkbenchPage activePage = JavaPlugin.getActivePage();
        if (activePage != null) {
            final Display display = fTextShell.getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    public void run() {
                        try {
                            IDE.openEditor(activePage, resource, true);
                        } catch (PartInitException e) {
                            JavaPlugin.log(e);
                        }
                    }
                });
            }
        }
    }

    abstract String getFirstColumnName();

    protected void createColumns(Tree tree) {
        fColumn1 = new TreeColumn(tree, SWT.LEFT);
        fColumn1.setText(getFirstColumnName());
        fColumn1.setWidth(fMemento.getInteger(P_COLUMN_1).intValue());
        // fColumn1.addSelectionListener(new SelectionAdapter() {
        // public void widgetSelected(SelectionEvent e) {
        // MESSAGE_ORDER *= -1;
        // ViewerComparator comparator = getViewerComparator(MESSAGE);
        // fFilteredTree.getViewer().setComparator(comparator);
        // boolean isComparatorSet = ((EventDetailsDialogAction) fPropertiesAction).resetSelection(MESSAGE,
        // MESSAGE_ORDER);
        // setComparator(MESSAGE);
        // if (!isComparatorSet)
        // ((EventDetailsDialogAction) fPropertiesAction).setComparator(fComparator);
        // fMemento.putInteger(P_ORDER_VALUE, MESSAGE_ORDER);
        // fMemento.putInteger(P_ORDER_TYPE, MESSAGE);
        // setColumnSorting(fColumn1, MESSAGE_ORDER);
        // }
        // });

        fColumn2 = new TreeColumn(tree, SWT.LEFT);
        fColumn2.setText(Messages.FlowView_column_plugin);
        fColumn2.setWidth(fMemento.getInteger(P_COLUMN_2).intValue());
        // fColumn2.addSelectionListener(new SelectionAdapter() {
        // public void widgetSelected(SelectionEvent e) {
        // PLUGIN_ORDER *= -1;
        // ViewerComparator comparator = getViewerComparator(PLUGIN);
        // fFilteredTree.getViewer().setComparator(comparator);
        // boolean isComparatorSet = ((EventDetailsDialogAction) fPropertiesAction).resetSelection(PLUGIN,
        // PLUGIN_ORDER);
        // setComparator(PLUGIN);
        // if (!isComparatorSet)
        // ((EventDetailsDialogAction) fPropertiesAction).setComparator(fComparator);
        // fMemento.putInteger(P_ORDER_VALUE, PLUGIN_ORDER);
        // fMemento.putInteger(P_ORDER_TYPE, PLUGIN);
        // setColumnSorting(fColumn2, PLUGIN_ORDER);
        // }
        // });

        fColumn3 = new TreeColumn(tree, SWT.LEFT);
        fColumn3.setText(Messages.FlowView_column_date);
        fColumn3.setWidth(fMemento.getInteger(P_COLUMN_3).intValue());
        // fColumn3.addSelectionListener(new SelectionAdapter() {
        // public void widgetSelected(SelectionEvent e) {
        // DATE_ORDER *= -1;
        // ViewerComparator comparator = getViewerComparator(DATE);
        // fFilteredTree.getViewer().setComparator(comparator);
        // setComparator(DATE);
        // ((EventDetailsDialogAction) fPropertiesAction).setComparator(fComparator);
        // fMemento.putInteger(P_ORDER_VALUE, DATE_ORDER);
        // fMemento.putInteger(P_ORDER_TYPE, DATE);
        // setColumnSorting(fColumn3, DATE_ORDER);
        // }
        // });

        tree.setHeaderVisible(true);
    }

    private void initializeViewerSorter() {
        byte orderType = fMemento.getInteger(P_ORDER_TYPE).byteValue();
        ViewerComparator comparator = getViewerComparator(orderType);
        fFilteredTree.getViewer().setComparator(comparator);
        if (orderType == MESSAGE)
            setColumnSorting(fColumn1, MESSAGE_ORDER);
        else if (orderType == PLUGIN)
            setColumnSorting(fColumn2, PLUGIN_ORDER);
        else if (orderType == DATE)
            setColumnSorting(fColumn3, DATE_ORDER);
    }

    private void setColumnSorting(TreeColumn column, int order) {
        fTree.setSortColumn(column);
        fTree.setSortDirection(order == ASCENDING ? SWT.UP : SWT.DOWN);
    }

    public void dispose() {
        if (fTextShell != null)
            fTextShell.dispose();
        fLabelProvider.disconnect(this);
        fFilteredTree.dispose();
        super.dispose();
    }

    public void fillContextMenu(IMenuManager manager) { // nothing
    }

    public AbstractEntry[] getElements() {
        return (AbstractEntry[]) elements.toArray(new AbstractEntry[elements.size()]);
    }

    protected void handleClear() {
        BusyIndicator.showWhile(fTree.getDisplay(), new Runnable() {
            public void run() {
                elements.clear();
                groups.clear();
                if (currentSession != null) {
                    currentSession.removeAllChildren();
                }
                asyncRefresh(false);
                resetDialogButtons();
            }
        });
    }

    /**
     * Reads the chosen backing log file
     */
    abstract  void loadElements();

    abstract String getTitleSummary();

    /**
     * Add new entries to correct groups in the view.
     * 
     * @param entries
     *        new entries to show up in groups in the view.
     */
    protected void group(List entries) {
        if (true) {
            elements.addAll(entries);
        } else {
            for (Iterator i = entries.iterator(); i.hasNext();) {
                ListEntry entry = (ListEntry) i.next();
                Group group = getGroup(entry);
                group.addChild(entry);
            }
        }
    }

    /**
     * Limits the number of entries according to the max entries limit set in
     * memento.
     */
    protected void limitEntriesCount() {
        int limit = Integer.MAX_VALUE;

        int entriesCount = getEntriesCount();

        if (entriesCount <= limit) {
            return;
        }
        Comparator dateComparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                Date l1 = ((ListEntry) o1).getDate();
                Date l2 = ((ListEntry) o2).getDate();
                if ((l1 != null) && (l2 != null)) {
                    return l1.before(l2) ? -1 : 1;
                } else if ((l1 == null) && (l2 == null)) {
                    return 0;
                } else
                    return (l1 == null) ? -1 : 1;
            }
        };

        elements.subList(0, elements.size() - limit).clear();

    }

    private int getEntriesCount() {
        // TODO:
        if (true) {
            return elements.size();
        }
        int size = 0;
        for (Iterator i = elements.iterator(); i.hasNext();) {
            AbstractEntry group = (AbstractEntry) i.next();
            size += group.size();
        }
        return size;
    }

    /**
     * Returns group appropriate for the entry. Group depends on P_GROUP_BY
     * preference, or is null if grouping is disabled (GROUP_BY_NONE), or group
     * could not be determined. May create group if it haven't existed before.
     * 
     * @param entry
     *        entry to be grouped
     * @return group or null if grouping is disabled
     */
    protected Group getGroup(ListEntry entry) {
        int groupBy = GROUP_BY_PLUGIN;
        Object elementGroupId = null;
        String groupName = null;

        switch (groupBy) {
            case GROUP_BY_PLUGIN:
                groupName = entry.getPluginId();
                elementGroupId = groupName;
                break;

            default: // grouping is disabled
                return null;
        }

        if (elementGroupId == null) { // could not determine group
            return null;
        }

        Group group = (Group) groups.get(elementGroupId);
        if (group == null) {

            group = new Group(groupName);
            groups.put(elementGroupId, group);
            elements.add(group);
        }

        return group;
    }

    /**
     * Push batched entries to log view.
     */
    private void pushBatchedEntries() {
        Job job = new Job(Messages.FlowView_AddingBatchedEvents) {
            protected IStatus run(IProgressMonitor monitor) {
                for (int i = 0; i < batchedEntries.size(); i++) {
                    if (!monitor.isCanceled()) {
                        ListEntry entry = (ListEntry) batchedEntries.get(i);
                        pushEntry(entry);
                        batchedEntries.remove(i);
                    }
                }
                asyncRefresh(true);
                return Status.OK_STATUS;
            }
        };
        job.schedule();
    }

    private synchronized void pushEntry(ListEntry entry) {
        if (true) {
            group(Collections.singletonList(entry));
            limitEntriesCount();
        }
        asyncRefresh(true);
    }

    protected final void asyncRefresh(final boolean activate) {
        if (fTree.isDisposed())
            return;
        Display display = fTree.getDisplay();
        final ViewPart view = this;
        if (display != null) {
            display.asyncExec(new Runnable() {
                public void run() {
                    if (!fTree.isDisposed()) {
                         TreeViewer viewer = fFilteredTree.getViewer();
                         viewer.refresh();
                        // viewer.expandToLevel(2);
                        // fDeleteLogAction.setEnabled(fInputFile.exists() &&
                        // fInputFile.equals(Platform.getLogFileLocation().toFile()));
                        // fOpenLogAction.setEnabled(fInputFile.exists());
                        // fExportLogAction.setEnabled(fInputFile.exists());
                        // fExportLogEntryAction.setEnabled(!viewer.getSelection().isEmpty());
                        // IWorkbenchWindow window =
                        // Neuro4jCorePlugin.getDefault().getWorkbench().getActiveWorkbenchWindow();
                        // if (window != null) {
                        // IWorkbenchPage page = window.getActivePage();
                        // if (page != null) {
                        // page.bringToTop(view);
                        // }
                        // }


                    }
                }
            });
        }
    }

    public void setFocus() {
        if (fFilteredTree != null) {
            if (fMemento.getBoolean(P_SHOW_FILTER_TEXT).booleanValue()) {
                Text filterControl = fFilteredTree.getFilterControl();
                if (filterControl != null && !filterControl.isDisposed()) {
                    filterControl.setFocus();
                }
            } else if (!fFilteredTree.isDisposed()) {
                fFilteredTree.setFocus();
            }
        }
    }

    private void handleSelectionChanged(ISelection selection) {

        updateStatus(selection);

        ListEntry entry = (ListEntry) ((TreeSelection) selection).getFirstElement();
        if (entry == null)
            return;
        if (entry.getType() == ListEntryType.CUSTOM_BLOCK || (entry.getType() == ListEntryType.CHILD && entry.getParent() != null && entry.getParent().getType() == ListEntryType.FLOW))
        {
            SelectedConnectionProvider.getInstance().setAvailableForInsert(false);
            SelectedListEntryProvider.getInstance().setAvailableForInsert(true);
            SelectedListEntryProvider.getInstance().setEntry(entry);
            // updateCursor();
        } else {
            SelectedConnectionProvider.getInstance().setAvailableForInsert(false);
            SelectedListEntryProvider.getInstance().setAvailableForInsert(false);
        }

    }

    private void updateStatus(ISelection selection) {
        IStatusLineManager status = getViewSite().getActionBars().getStatusLineManager();
        if (selection.isEmpty())
            status.setMessage(null);
        else {
            Object element = ((IStructuredSelection) selection).getFirstElement();
            status.setMessage(((FlowViewLabelProvider) fFilteredTree.getViewer().getLabelProvider()).getColumnText(element, 0));
        }
    }

    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);
        if (memento == null)
            this.fMemento = XMLMemento.createWriteRoot("LOGVIEW"); //$NON-NLS-1$
        else
            this.fMemento = memento;
        readSettings();

        // initialize column ordering
        // final byte type = this.fMemento.getInteger(P_ORDER_TYPE).byteValue();
        switch (0) {
            case DATE:
                DATE_ORDER = DESCENDING;
                MESSAGE_ORDER = DESCENDING;
                PLUGIN_ORDER = DESCENDING;
                break;
            case MESSAGE:
                MESSAGE_ORDER = DESCENDING;
                DATE_ORDER = DESCENDING;
                PLUGIN_ORDER = DESCENDING;
                break;
            case PLUGIN:
                PLUGIN_ORDER = DESCENDING;
                MESSAGE_ORDER = DESCENDING;
                DATE_ORDER = DESCENDING;
                break;
            default:
                DATE_ORDER = DESCENDING;
                MESSAGE_ORDER = DESCENDING;
                PLUGIN_ORDER = DESCENDING;
        }
        setComparator(0);
    }

    private void initializeMemento() {
        if (fMemento.getString(P_USE_LIMIT) == null) {
            fMemento.putString(P_USE_LIMIT, "true"); //$NON-NLS-1$
        }
        if (fMemento.getInteger(P_LOG_LIMIT) == null) {
            fMemento.putInteger(P_LOG_LIMIT, 50);
        }
        if (fMemento.getString(P_LOG_INFO) == null) {
            fMemento.putString(P_LOG_INFO, "true"); //$NON-NLS-1$
        }
        if (fMemento.getString(P_LOG_OK) == null) {
            fMemento.putString(P_LOG_OK, "true"); //$NON-NLS-1$
        }
        if (fMemento.getString(P_LOG_WARNING) == null) {
            fMemento.putString(P_LOG_WARNING, "true"); //$NON-NLS-1$
        }
        if (fMemento.getString(P_LOG_ERROR) == null) {
            fMemento.putString(P_LOG_ERROR, "true"); //$NON-NLS-1$
        }
        if (fMemento.getString(P_SHOW_ALL_SESSIONS) == null) {
            fMemento.putString(P_SHOW_ALL_SESSIONS, "true"); //$NON-NLS-1$
        }
    }

    // public void saveState(IMemento memento) {
    // if (this.fMemento == null || memento == null)
    // return;
    // //store some sane values to prevent the view from being broken
    // this.fMemento.putInteger(P_COLUMN_1, getColumnWidth(fColumn1, 300));
    // this.fMemento.putInteger(P_COLUMN_2, getColumnWidth(fColumn2, 150));
    // this.fMemento.putInteger(P_COLUMN_3, getColumnWidth(fColumn3, 150));
    //		this.fMemento.putString(P_ACTIVATE, fActivateViewAction.isChecked() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
    // memento.putMemento(this.fMemento);
    // // writeSettings();
    // }

    /**
     * Returns the width of the column or the default value if the column has been resized to be not visible
     * 
     * @param column
     *        the column to get the width from
     * @param defaultwidth
     *        the width to return if the column has been resized to not be visible
     * @return the width of the column or the default value
     * 
     * @since 3.6
     */
    int getColumnWidth(TreeColumn column, int defaultwidth) {
        int width = column.getWidth();
        return width < 1 ? defaultwidth : width;
    }

    protected void addMouseListeners() {
        Listener tableListener = new Listener() {
            public void handleEvent(Event e) {
                switch (e.type) {
                // case SWT.MouseExit :
                // case SWT.MouseMove :
                // onMouseMove(e);
                // break;
                // case SWT.MouseHover :
                // onMouseHover(e);
                // break;
                    case SWT.MouseDown:
                        onMouseDown(e);
                        break;
                }
            }
        };
        int[] tableEvents = new int[] { SWT.MouseDown /* , SWT.MouseMove, SWT.MouseHover, SWT.MouseExit */};
        for (int i = 0; i < tableEvents.length; i++) {
            fTree.addListener(tableEvents[i], tableListener);
        }
    }

    private void makeHoverShell() {
        // parent it off the workbench window's shell so it will be valid regardless of whether the view is a detached
        // window or not
        fTextShell = new Shell(getSite().getWorkbenchWindow().getShell(), SWT.NO_FOCUS | SWT.ON_TOP | SWT.TOOL);
        Display display = fTextShell.getDisplay();
        fTextShell.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
        GridLayout layout = new GridLayout(1, false);
        int border = ((fTree.getShell().getStyle() & SWT.NO_TRIM) == 0) ? 0 : 1;
        layout.marginHeight = border;
        layout.marginWidth = border;
        fTextShell.setLayout(layout);
        fTextShell.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Composite shellComposite = new Composite(fTextShell, SWT.NONE);
        layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        shellComposite.setLayout(layout);
        shellComposite.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING));
        fTextLabel = new Text(shellComposite, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 100;
        gd.grabExcessHorizontalSpace = true;
        fTextLabel.setLayoutData(gd);
        Color c = fTree.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
        fTextLabel.setBackground(c);
        c = fTree.getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND);
        fTextLabel.setForeground(c);
        fTextLabel.setEditable(false);
        fTextShell.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                onTextShellDispose(e);
            }
        });
    }

    void onTextShellDispose(DisposeEvent e) {
        fCanOpenTextShell = true;
        setFocus();
    }

    void onMouseDown(Event e) {
        if (fTextShell != null && !fTextShell.isDisposed() && !fTextShell.isFocusControl()) {
            fTextShell.setVisible(false);
            fCanOpenTextShell = true;
        }
    }

    void onMouseHover(Event e) {
        if (!fCanOpenTextShell || fTextShell == null || fTextShell.isDisposed())
            return;
        fCanOpenTextShell = false;
        Point point = new Point(e.x, e.y);
        TreeItem item = fTree.getItem(point);
        if (item == null)
            return;

        String message = null;
        if (item.getData() instanceof ListEntry) {
            message = ((ListEntry) item.getData()).getPluginId();
        }

        if (message == null)
            return;

        fTextLabel.setText(message);
        Rectangle bounds = fTree.getDisplay().getBounds();
        Point cursorPoint = fTree.getDisplay().getCursorLocation();
        int x = point.x;
        int y = point.y + 25;
        int width = fTree.getColumn(0).getWidth();
        int height = 125;
        if (cursorPoint.x + width > bounds.width)
            x -= width;
        if (cursorPoint.y + height + 25 > bounds.height)
            y -= height + 27;

        fTextShell.setLocation(fTree.toDisplay(x, y));
        fTextShell.setSize(width, height);
        fTextShell.setVisible(true);
    }

    void onMouseMove(Event e) {
        if (fTextShell != null && !fTextShell.isDisposed() && fTextShell.isVisible())
            fTextShell.setVisible(false);

        Point point = new Point(e.x, e.y);
        TreeItem item = fTree.getItem(point);
        if (item == null)
            return;
        Image image = item.getImage();
        Object data = item.getData();
        if (data instanceof ListEntry) {
            ListEntry entry = (ListEntry) data;
            int parentCount = getNumberOfParents(entry);
            int startRange = 20 + Math.max(image.getBounds().width + 2, 7 + 2) * parentCount;
            int endRange = startRange + 16;
            fCanOpenTextShell = e.x >= startRange && e.x <= endRange;
        }
    }

    private int getNumberOfParents(AbstractEntry entry) {
        AbstractEntry parent = (AbstractEntry) entry.getParent(entry);
        if (parent == null)
            return 0;
        return 1 + getNumberOfParents(parent);
    }

    public Comparator getComparator() {
        return fComparator;
    }

    private void setComparator(int i) {
        if (i == DATE) {
            fComparator = new Comparator() {
                public int compare(Object e1, Object e2) {
                    long date1 = 0;
                    long date2 = 0;
                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        date1 = ((ListEntry) e1).getDate().getTime();
                        date2 = ((ListEntry) e2).getDate().getTime();
                    } else if ((e1 instanceof LogSession) && (e2 instanceof LogSession)) {
                        date1 = ((LogSession) e1).getDate() == null ? 0 : ((LogSession) e1).getDate().getTime();
                        date2 = ((LogSession) e2).getDate() == null ? 0 : ((LogSession) e2).getDate().getTime();
                    }
                    if (date1 == date2) {
                        int result = elements.indexOf(e2) - elements.indexOf(e1);
                        if (DATE_ORDER == DESCENDING)
                            result *= DESCENDING;
                        return result;
                    }
                    if (DATE_ORDER == DESCENDING)
                        return date1 > date2 ? DESCENDING : ASCENDING;
                    return date1 < date2 ? DESCENDING : ASCENDING;
                }
            };
        } else if (i == PLUGIN) {
            fComparator = new Comparator() {
                public int compare(Object e1, Object e2) {
                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        ListEntry entry1 = (ListEntry) e1;
                        ListEntry entry2 = (ListEntry) e2;
                        return getDefaultComparator().compare(entry1.getPluginId(), entry2.getPluginId()) * PLUGIN_ORDER;
                    }
                    return 0;
                }
            };
        } else {
            fComparator = new Comparator() {
                public int compare(Object e1, Object e2) {
                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        ListEntry entry1 = (ListEntry) e1;
                        ListEntry entry2 = (ListEntry) e2;
                        return getDefaultComparator().compare(entry1.getMessage(), entry2.getMessage()) * MESSAGE_ORDER;
                    }
                    return 0;
                }
            };
        }
    }

    private Comparator getDefaultComparator() {
        return Policy.getComparator();
    }

    private ViewerComparator getViewerComparator(byte sortType) {
        if (sortType == PLUGIN) {
            return new ViewerComparator() {
                public int compare(Viewer viewer, Object e1, Object e2) {
                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        ListEntry entry1 = (ListEntry) e1;
                        ListEntry entry2 = (ListEntry) e2;
                        return getComparator().compare(entry1.getPluginId(), entry2.getPluginId()) * PLUGIN_ORDER;
                    }
                    return 0;
                }
            };
        } else if (sortType == MESSAGE) {
            return new ViewerComparator() {
                public int compare(Viewer viewer, Object e1, Object e2) {
                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        ListEntry entry1 = (ListEntry) e1;
                        ListEntry entry2 = (ListEntry) e2;
                        return getComparator().compare(entry1.getMessage(), entry2.getMessage()) * MESSAGE_ORDER;
                    }
                    return 0;
                }
            };
        } else {
            return new ViewerComparator() {
                private int indexOf(Object[] array, Object o) {
                    if (o == null)
                        return -1;
                    for (int i = 0; i < array.length; ++i)
                        if (o.equals(array[i]))
                            return i;
                    return -1;
                }

                public int compare(Viewer viewer, Object e1, Object e2) {
                    long date1 = 0;
                    long date2 = 0;

                    if ((e1 instanceof ListEntry) && (e2 instanceof ListEntry)) {
                        ListEntry le1 = (ListEntry) e1;
                        ListEntry le2 = (ListEntry) e2;
                        if (le1.getDate() == null || le2.getDate() == null)
                        {
                            return 0;
                        }

                        date1 = le1.getDate().getTime();
                        date2 = le2.getDate().getTime();
                    }

                    if (date1 == date2) {
                        AbstractEntry parent = (AbstractEntry) ((AbstractEntry) e1).getParent(null);
                        Object[] children = null;
                        if (parent != null)
                            children = parent.getChildren(parent);

                        int result = 0;
                        if (children != null) {
                            result = indexOf(children, e2) - indexOf(children, e1);
                        } else {
                            result = elements.indexOf(e1) - elements.indexOf(e2);
                        }
                        if (DATE_ORDER == DESCENDING)
                            result *= DESCENDING;
                        return result;
                    }
                    if (DATE_ORDER == DESCENDING)
                        return date1 > date2 ? DESCENDING : ASCENDING;
                    return date1 < date2 ? DESCENDING : ASCENDING;
                }
            };
        }
    }

    private void resetDialogButtons() {
        // ((EventDetailsDialogAction) fPropertiesAction).resetDialogButtons();
    }

    /**
     * Returns the plugin preferences used to maintain
     * state of log view
     * 
     * @return the plugin preferences
     */

    /**
     * Loads any saved {@link IDialogSettings} into the backing view memento
     */
    private void readSettings() {
        IDialogSettings s = getLogSettings();
        if (s == null) {
            initializeMemento();
        } else {
            fMemento.putString(P_USE_LIMIT, s.getBoolean(P_USE_LIMIT) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            fMemento.putString(P_LOG_INFO, s.getBoolean(P_LOG_INFO) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            fMemento.putString(P_LOG_OK, s.getBoolean(P_LOG_OK) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            fMemento.putString(P_LOG_WARNING, s.getBoolean(P_LOG_WARNING) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            fMemento.putString(P_LOG_ERROR, s.getBoolean(P_LOG_ERROR) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            fMemento.putString(P_SHOW_ALL_SESSIONS, s.getBoolean(P_SHOW_ALL_SESSIONS) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
            try {
                fMemento.putInteger(P_LOG_LIMIT, s.getInt(P_LOG_LIMIT));
            } catch (NumberFormatException e) {
                fMemento.putInteger(P_LOG_LIMIT, 50);
            }
        }

        Preferences p = getLogPreferences(); // never returns null
        fMemento.putInteger(P_COLUMN_1, getColumnWidthPreference(p, P_COLUMN_1, 300));
        fMemento.putInteger(P_COLUMN_2, getColumnWidthPreference(p, P_COLUMN_2, 150));
        fMemento.putInteger(P_COLUMN_3, getColumnWidthPreference(p, P_COLUMN_3, 150));
        fMemento.putBoolean(P_ACTIVATE, p.getBoolean(P_ACTIVATE, true));
        fMemento.putInteger(P_ORDER_VALUE, p.getInt(P_ORDER_VALUE, DESCENDING));
        fMemento.putInteger(P_ORDER_TYPE, p.getInt(P_ORDER_TYPE, AbstractListView.DATE));
        fMemento.putBoolean(P_SHOW_FILTER_TEXT, p.getBoolean(P_SHOW_FILTER_TEXT, true));
        fMemento.putInteger(P_GROUP_BY, p.getInt(P_GROUP_BY, AbstractListView.GROUP_BY_NONE));
    }

    private Preferences getLogPreferences() {
        return (new SessionScope()).getNode(Neuro4jCorePlugin.getPluginId());
    }

    /**
     * Returns the width to use for the column represented by the given key. The default width
     * is returned iff:
     * <ul>
     * <li>There is no preference for the given key</li>
     * <li>The returned preference value is too small, making the columns invisible by width.</li>
     * </ul>
     * 
     * @param preferences
     * @param key
     * @param defaultwidth
     * @return the stored width for the a column described by the given key or the default width
     * 
     * @since 3.6
     */
    int getColumnWidthPreference(Preferences preferences, String key, int defaultwidth) {
        int width = preferences.getInt(key, defaultwidth);
        return width < 1 ? defaultwidth : width;
    }

    /**
     * Returns whether given session equals to currently displayed in LogView.
     * 
     * @param session
     *        LogSession
     * @return true if given session equals to currently displayed in LogView
     */
    public boolean isCurrentLogSession(LogSession session) {
        return (currentSession != null) && (currentSession.equals(session));
    }

    private IDialogSettings getLogSettings() {
        IDialogSettings settings = Neuro4jCorePlugin.getDefault().getDialogSettings();
        return settings.getSection(getClass().getName());
    }
}
