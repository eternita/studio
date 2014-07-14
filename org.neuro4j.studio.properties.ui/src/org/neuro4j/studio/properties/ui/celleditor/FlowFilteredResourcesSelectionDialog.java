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
package org.neuro4j.studio.properties.ui.celleditor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.internal.WorkbenchMessages;
import org.neuro4j.studio.core.util.FlowUtils;
import org.neuro4j.studio.core.util.PropetiesConstants;

public class FlowFilteredResourcesSelectionDialog extends
        ElementListSelectionDialog {

    public FlowFilteredResourcesSelectionDialog(Shell parent,
            ILabelProvider renderer) {
        super(parent, renderer);
        container = ResourcesPlugin.getWorkspace().getRoot();
        typeMask = IResource.FILE | IResource.FOLDER | IResource.PROJECT;

        IWorkbenchWindow ww = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow();
        if (ww != null) {
            IWorkbenchPage activePage = ww.getActivePage();
            if (activePage != null) {
                IResource resource = null;
                IEditorPart activeEditor = activePage.getActiveEditor();
                if (activeEditor != null
                        && activeEditor == activePage.getActivePart()) {
                    IEditorInput editorInput = activeEditor.getEditorInput();
                    resource = ResourceUtil.getResource(editorInput);
                } else {
                    ISelection selection = ww.getSelectionService()
                            .getSelection();
                    if (selection instanceof IStructuredSelection) {
                        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
                        if (structuredSelection.size() == 1) {
                            resource = ResourceUtil
                                    .getResource(structuredSelection
                                            .getFirstElement());
                        }
                    }
                }
                if (resource != null) {
                    if (!(resource instanceof IContainer)) {
                        resource = resource.getParent();
                    }
                    searchContainer = (IContainer) resource;
                }
            }
        }
    }

    protected ItemsFilter createFilter() {
        return new ResourceFilter(container, searchContainer, isDerived,
                typeMask);
    }

    public void fillContentProvider() throws CoreException {
        ItemsFilter itemsFilter = createFilter();
        this.filter = itemsFilter;
        contentProvider = new ContentProvider();
        IProgressMonitor progressMonitor = new NullProgressMonitor();
        if (itemsFilter instanceof ResourceFilter)
            container.accept(new ResourceProxyVisitor(contentProvider,
                    (ResourceFilter) itemsFilter, progressMonitor),
                    IResource.NONE);

        setElements(contentProvider.getSortedItems());

        if (progressMonitor != null)
            progressMonitor.done();
    }

    private IContainer container;
    private IContainer searchContainer;

    private int typeMask;
    private Text pattern;
    private boolean isDerived;
    private ItemsFilter filter;
    // private List lastCompletedResult;
    private Map<IProject, List<String>> projectSources = new HashMap<IProject, List<String>>();
    // private ItemsFilter lastCompletedFilter;
    private ContentProvider contentProvider;
    private ItemsListSeparator itemsListSeparator;
    private TableViewer list;

    public String getElementName(Object item) {
        IResource resource = (IResource) item;
        return resource.getName();
    }

    private class ContentProvider extends AbstractContentProvider implements
            IStructuredContentProvider, ILazyContentProvider {

        // private SelectionHistory selectionHistory;

        /**
         * Raw result of the searching (unsorted, unfiltered).
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */
        private Set<String> items;

        /**
         * Items that are duplicates.
         */
        private Set duplicates;

        /**
         * List of <code>ViewerFilter</code>s to be used during filtering
         */
        private List filters;

        /**
         * Result of the last filtering.
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */
        private List lastFilteredItems;

        /**
         * Result of the last sorting.
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */
        private List lastSortedItems;

        /**
         * Used for <code>getFilteredItems()</code> method canceling (when the
         * job that invoked the method was canceled).
         * <p>
         * Method canceling could be based (only) on monitor canceling unfortunately sometimes the method
         * <code>getFilteredElements()</code> could be run with a null monitor, the <code>reset</code> flag have to be
         * left intact.
         */
        private boolean reset;

        /**
         * Creates new instance of <code>ContentProvider</code>.
         */
        public ContentProvider() {
            this.items = Collections.synchronizedSet(new HashSet(2048));
            this.duplicates = Collections.synchronizedSet(new HashSet(256));
            this.lastFilteredItems = new ArrayList();
            this.lastSortedItems = Collections.synchronizedList(new ArrayList(
                    2048));
        }

        // /**
        // * Sets selection history.
        // *
        // * @param selectionHistory
        // * The selectionHistory to set.
        // */
        // public void setSelectionHistory(SelectionHistory selectionHistory) {
        // this.selectionHistory = selectionHistory;
        // }
        //
        // /**
        // * @return Returns the selectionHistory.
        // */
        // public SelectionHistory getSelectionHistory() {
        // return selectionHistory;
        // }
        //
        // /**
        // * Removes all content items and resets progress message.
        // */
        // public void reset() {
        // reset = true;
        // this.items.clear();
        // this.duplicates.clear();
        // this.lastSortedItems.clear();
        // }

        /**
         * Stops reloading cache - <code>getFilteredItems()</code> method.
         */
        public void stopReloadingCache() {
            reset = true;
        }

        /**
         * Adds filtered item.
         * 
         * @param item
         * @param itemsFilter
         */
        public void add(Object item, ItemsFilter itemsFilter) {
            if (itemsFilter == filter) {
                if (itemsFilter != null) {
                    if (itemsFilter.matchItem(item)) {
                        List<String> startNodes = getFlowsWithStartNodes(item);
                        this.items.addAll(startNodes);
                    }
                } else {
                    List<String> startNodes = getFlowsWithStartNodes(item);
                    this.items.addAll(startNodes);
                }
            }
        }

        /**
         * Add all history items to <code>contentProvider</code>.
         * 
         * @param itemsFilter
         */
        // public void addHistoryItems(ItemsFilter itemsFilter) {
        // if (this.selectionHistory != null) {
        // Object[] items = this.selectionHistory.getHistoryItems();
        // for (int i = 0; i < items.length; i++) {
        // Object item = items[i];
        // if (itemsFilter == filter) {
        // if (itemsFilter != null) {
        // if (itemsFilter.matchItem(item)) {
        // if (itemsFilter.isConsistentItem(item)) {
        // this.items.add(item.toString());
        // } else {
        // this.selectionHistory.remove(item);
        // }
        // }
        // }
        // }
        // }
        // }
        // }
        //
        // /**
        // * Refresh dialog.
        // */
        // public void refresh() {
        // //scheduleRefresh();
        // }
        //
        // /**
        // * Removes items from history and refreshes the view.
        // *
        // * @param item
        // * to remove
        // *
        // * @return removed item
        // */
        // public Object removeHistoryElement(Object item) {
        // if (this.selectionHistory != null)
        // this.selectionHistory.remove(item);
        // if (filter == null || filter.getPattern().length() == 0) {
        // items.remove(item);
        // duplicates.remove(item);
        // this.lastSortedItems.remove(item);
        // }
        //
        // synchronized (lastSortedItems) {
        // Collections.sort(lastSortedItems);
        // }
        // return item;
        // }

        // /**
        // * Adds item to history and refresh view.
        // *
        // * @param item
        // * to add
        // */
        // public void addHistoryElement(Object item) {
        // if (this.selectionHistory != null)
        // this.selectionHistory.accessed(item);
        // if (filter == null || !filter.matchItem(item)) {
        // this.items.remove(item);
        // this.duplicates.remove(item);
        // this.lastSortedItems.remove(item);
        // }
        // synchronized (lastSortedItems) {
        // Collections.sort(lastSortedItems);
        // }
        // this.refresh();
        // }

        /**
         * @param item
         * @return <code>true</code> if given item is part of the history
         */
        // public boolean isHistoryElement(Object item) {
        // if (this.selectionHistory != null) {
        // return this.selectionHistory.contains(item);
        // }
        // return false;
        // }

        /**
         * Sets/unsets given item as duplicate.
         * 
         * @param item
         *        item to change
         * 
         * @param isDuplicate
         *        duplicate flag
         */
        public void setDuplicateElement(Object item, boolean isDuplicate) {
            if (this.items.contains(item)) {
                if (isDuplicate)
                    this.duplicates.add(item);
                else
                    this.duplicates.remove(item);
            }
        }

        // /**
        // * Indicates whether given item is a duplicate.
        // *
        // * @param item
        // * item to check
        // * @return <code>true</code> if item is duplicate
        // */
        // public boolean isDuplicateElement(Object item) {
        // return duplicates.contains(item);
        // }

        // /**
        // * Load history from memento.
        // *
        // * @param memento
        // * memento from which the history will be retrieved
        // */
        // public void loadHistory(IMemento memento) {
        // if (this.selectionHistory != null)
        // this.selectionHistory.load(memento);
        // }

        // /**
        // * Save history to memento.
        // *
        // * @param memento
        // * memento to which the history will be added
        // */
        // public void saveHistory(IMemento memento) {
        // if (this.selectionHistory != null)
        // this.selectionHistory.save(memento);
        // }

        /**
         * Gets sorted items.
         * 
         * @return sorted items
         */
        public Object[] getSortedItems() {
            if (lastSortedItems.size() != items.size()) {
                synchronized (lastSortedItems) {
                    lastSortedItems.clear();
                    lastSortedItems.addAll(items);
                    Collections.sort(lastSortedItems);
                }
            }
            return lastSortedItems.toArray();
        }

        //
        // /**
        // * Remember result of filtering.
        // *
        // * @param itemsFilter
        // */
        // public void rememberResult(ItemsFilter itemsFilter) {
        // List itemsList = Collections.synchronizedList(Arrays
        // .asList(getSortedItems()));
        // // synchronization
        // if (itemsFilter == filter) {
        // lastCompletedFilter = itemsFilter;
        // lastCompletedResult = itemsList;
        // }
        //
        // }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
         * java.lang.Object)
         */
        public Object[] getElements(Object inputElement) {
            return lastFilteredItems.toArray();
        }

        // public int getNumberOfElements() {
        // return lastFilteredItems.size();
        // }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose() {
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
         * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
         */
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jface.viewers.ILazyContentProvider#updateElement(int)
         */
        public void updateElement(int index) {

            FlowFilteredResourcesSelectionDialog.this.list.replace((lastFilteredItems
                    .size() > index) ? lastFilteredItems.get(index) : null,
                    index);

        }

        /**
         * Main method responsible for getting the filtered items and checking
         * for duplicates. It is based on the
         * {@link FilteredItemsSelectionDialog.ContentProvider#getFilteredItems(Object, IProgressMonitor)} .
         * 
         * @param checkDuplicates
         *        <code>true</code> if data concerning elements duplication
         *        should be computed - it takes much more time than standard
         *        filtering
         * 
         * @param monitor
         *        progress monitor
         */
        // public void reloadCache(boolean checkDuplicates,
        // IProgressMonitor monitor) {
        //
        // reset = false;
        //
        // if (monitor != null) {
        // // the work is divided into two actions of the same length
        // int totalWork = checkDuplicates ? 200 : 100;
        //
        // monitor.beginTask(
        // WorkbenchMessages.FilteredItemsSelectionDialog_cacheRefreshJob,
        // totalWork);
        // }
        //
        // // the TableViewer's root (the input) is treated as parent
        //
        // lastFilteredItems = Arrays.asList(getFilteredItems(list.getInput(),
        // monitor != null ? new SubProgressMonitor(monitor, 100)
        // : null));
        //
        // if (reset || (monitor != null && monitor.isCanceled())) {
        // if (monitor != null)
        // monitor.done();
        // return;
        // }
        //
        // if (checkDuplicates) {
        // checkDuplicates(monitor);
        // }
        // if (monitor != null)
        // monitor.done();
        // }

        // private void checkDuplicates(IProgressMonitor monitor) {
        // synchronized (lastFilteredItems) {
        // IProgressMonitor subMonitor = null;
        // int reportEvery = lastFilteredItems.size() / 20;
        // if (monitor != null) {
        // subMonitor = new SubProgressMonitor(monitor, 100);
        // subMonitor
        // .beginTask(
        // WorkbenchMessages.FilteredItemsSelectionDialog_cacheRefreshJob_checkDuplicates,
        // 5);
        // }
        // HashMap helperMap = new HashMap();
        // for (int i = 0; i < lastFilteredItems.size(); i++) {
        // if (reset
        // || (subMonitor != null && subMonitor.isCanceled()))
        // return;
        // Object item = lastFilteredItems.get(i);
        //
        // if (!(item instanceof ItemsListSeparator)) {
        // Object previousItem = helperMap.put(
        // getElementName(item), item);
        // if (previousItem != null) {
        // setDuplicateElement(previousItem, true);
        // setDuplicateElement(item, true);
        // } else {
        // setDuplicateElement(item, false);
        // }
        // }
        //
        // if (subMonitor != null && reportEvery != 0
        // && (i + 1) % reportEvery == 0)
        // subMonitor.worked(1);
        // }
        // helperMap.clear();
        // }
        // }

        // /**
        // * Returns an array of items filtered using the provided
        // * <code>ViewerFilter</code>s with a separator added.
        // *
        // * @param parent
        // * the parent
        // * @param monitor
        // * progress monitor, can be <code>null</code>
        // * @return an array of filtered items
        // */
        // protected Object[] getFilteredItems(Object parent,
        // IProgressMonitor monitor) {
        // int ticks = 100;
        // if (monitor == null) {
        // monitor = new NullProgressMonitor();
        // }
        //
        // monitor.beginTask(
        // WorkbenchMessages.FilteredItemsSelectionDialog_cacheRefreshJob_getFilteredElements,
        // ticks);
        // if (filters != null) {
        // ticks /= (filters.size() + 2);
        // } else {
        // ticks /= 2;
        // }
        //
        // // get already sorted array
        // Object[] filteredElements = getSortedItems();
        //
        // monitor.worked(ticks);
        //
        // // filter the elements using provided ViewerFilters
        // if (filters != null && filteredElements != null) {
        // for (Iterator iter = filters.iterator(); iter.hasNext();) {
        // ViewerFilter f = (ViewerFilter) iter.next();
        // filteredElements = f.filter(list, parent, filteredElements);
        // monitor.worked(ticks);
        // }
        // }
        //
        // if (filteredElements == null || monitor.isCanceled()) {
        // monitor.done();
        // return new Object[0];
        // }
        //
        // ArrayList preparedElements = new ArrayList();
        // boolean hasHistory = false;
        //
        // if (filteredElements.length > 0) {
        // if (isHistoryElement(filteredElements[0])) {
        // hasHistory = true;
        // }
        // }
        //
        // int reportEvery = filteredElements.length / ticks;
        //
        // // add separator
        // for (int i = 0; i < filteredElements.length; i++) {
        // Object item = filteredElements[i];
        //
        // if (hasHistory && !isHistoryElement(item)) {
        // preparedElements.add(itemsListSeparator);
        // hasHistory = false;
        // }
        //
        // preparedElements.add(item);
        //
        // if (reportEvery != 0 && ((i + 1) % reportEvery == 0)) {
        // monitor.worked(1);
        // }
        // }
        //
        // monitor.done();
        //
        // return preparedElements.toArray();
        // }

        // /**
        // * Adds a filter to this content provider. For an example usage of such
        // * filters look at the project <code>org.eclipse.ui.ide</code>, class
        // * <code>org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog.CustomWorkingSetFilter</code>
        // * .
        // *
        // *
        // * @param filter
        // * the filter to be added
        // */
        // public void addFilter(ViewerFilter filter) {
        // if (filters == null) {
        // filters = new ArrayList();
        // }
        // filters.add(filter);
        // // currently filters are only added when dialog is restored
        // // if it is changed, refreshing the whole TableViewer should be
        // // added
        // }

    }

    protected class ResourceFilter extends ItemsFilter {

        private boolean showDerived = false;

        private IContainer filterContainer;

        /**
         * Container path pattern. Is <code>null</code> when only a file name
         * pattern is used.
         * 
         * @since 3.6
         */
        private SearchPattern containerPattern;
        /**
         * Container path pattern, relative to the current searchContainer. Is <code>null</code> if there's no search
         * container.
         * 
         * @since 3.6
         */
        private SearchPattern relativeContainerPattern;

        /**
         * Camel case pattern for the name part of the file name (without
         * extension). Is <code>null</code> if there's no extension.
         * 
         * @since 3.6
         */
        SearchPattern namePattern;
        /**
         * Camel case pattern for the file extension. Is <code>null</code> if
         * there's no extension.
         * 
         * @since 3.6
         */
        SearchPattern extensionPattern;

        private int filterTypeMask;

        /**
         * Creates new ResourceFilter instance
         * 
         * @param container
         * @param showDerived
         *        flag which determine showing derived elements
         * @param typeMask
         */
        public ResourceFilter(IContainer container, boolean showDerived,
                int typeMask) {
            super();
            this.filterContainer = container;
            this.showDerived = showDerived;
            this.filterTypeMask = typeMask;
        }

        /**
         * Creates new ResourceFilter instance
         * 
         * @param container
         * @param searchContainer
         *        IContainer to use for performing relative search
         * @param showDerived
         *        flag which determine showing derived elements
         * @param typeMask
         * @since 3.6
         */
        private ResourceFilter(IContainer container,
                IContainer searchContainer, boolean showDerived, int typeMask) {
            this(container, showDerived, typeMask);

            String stringPattern = getPattern();
            String filenamePattern;

            int sep = stringPattern.lastIndexOf(IPath.SEPARATOR);
            if (sep != -1) {
                filenamePattern = stringPattern.substring(sep + 1,
                        stringPattern.length());
                if ("*".equals(filenamePattern)) //$NON-NLS-1$
                    filenamePattern = "**"; //$NON-NLS-1$

                if (sep > 0) {
                    if (filenamePattern.length() == 0) // relative patterns
                                                       // don't need a file
                                                       // name
                        filenamePattern = "**"; //$NON-NLS-1$

                    String containerPattern = stringPattern.substring(0, sep);

                    if (searchContainer != null) {
                        relativeContainerPattern = new SearchPattern(
                                SearchPattern.RULE_EXACT_MATCH
                                        | SearchPattern.RULE_PATTERN_MATCH);
                        relativeContainerPattern.setPattern(searchContainer
                                .getFullPath().append(containerPattern)
                                .toString());
                    }

                    if (!containerPattern.startsWith("" + IPath.SEPARATOR)) //$NON-NLS-1$
                        containerPattern = IPath.SEPARATOR + containerPattern;
                    this.containerPattern = new SearchPattern(
                            SearchPattern.RULE_EXACT_MATCH
                                    | SearchPattern.RULE_PREFIX_MATCH
                                    | SearchPattern.RULE_PATTERN_MATCH);
                    this.containerPattern.setPattern(containerPattern);
                }
                patternMatcher.setPattern(filenamePattern);

            } else {
                filenamePattern = stringPattern;
            }

            int lastPatternDot = filenamePattern.lastIndexOf('.');
            if (lastPatternDot != -1) {
                char last = filenamePattern
                        .charAt(filenamePattern.length() - 1);
                if (last != ' ' && last != '<'
                        && getMatchRule() != SearchPattern.RULE_EXACT_MATCH) {
                    namePattern = new SearchPattern();
                    namePattern.setPattern(filenamePattern.substring(0,
                            lastPatternDot));
                    extensionPattern = new SearchPattern();
                    extensionPattern.setPattern(filenamePattern
                            .substring(lastPatternDot + 1));
                }
            }

        }

        /**
         * Creates new ResourceFilter instance
         */
        public ResourceFilter() {
            this(container, searchContainer, isDerived, typeMask);
        }

        /**
         * @param item
         *        Must be instance of IResource, otherwise <code>false</code> will be returned.
         * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isConsistentItem(java.lang.Object)
         */
        public boolean isConsistentItem(Object item) {
            if (!(item instanceof IResource)) {
                return false;
            }
            IResource resource = (IResource) item;
            if (this.filterContainer.findMember(resource.getFullPath()) != null)
                return true;
            return false;
        }

        /**
         * @param item
         *        Must be instance of IResource, otherwise <code>false</code> will be returned.
         * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#matchItem(java.lang.Object)
         */
        public boolean matchItem(Object item) {
            if (!(item instanceof IResource)) {
                return false;
            }
            IResource resource = (IResource) item;
            if ((!this.showDerived && resource.isDerived())
                    || ((this.filterTypeMask & resource.getType()) == 0))
                return false;

            String name = resource.getName();
            if (nameMatches(name)) {
                if (containerPattern != null) {
                    // match full container path:
                    String containerPath = resource.getParent().getFullPath()
                            .toString();
                    if (containerPattern.matches(containerPath))
                        return true;
                    // match path relative to current selection:
                    if (relativeContainerPattern != null)
                        return relativeContainerPattern.matches(containerPath);
                    return false;
                }
                return true;
            }

            return false;
        }

        private boolean nameMatches(String name) {
            if (namePattern != null) {
                // fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=212565
                int lastDot = name.lastIndexOf('.');
                if (lastDot != -1
                        && namePattern.matches(name.substring(0, lastDot))
                        && extensionPattern
                                .matches(name.substring(lastDot + 1))) {
                    return true;
                }
            }
            return matches(name);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#
         * isSubFilter
         * (org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter)
         */
        public boolean isSubFilter(ItemsFilter filter) {
            if (!super.isSubFilter(filter))
                return false;
            if (filter instanceof ResourceFilter) {
                ResourceFilter resourceFilter = (ResourceFilter) filter;
                if (this.showDerived == resourceFilter.showDerived) {
                    if (containerPattern == null) {
                        return resourceFilter.containerPattern == null;
                    } else if (resourceFilter.containerPattern == null) {
                        return false;
                    } else {
                        return containerPattern
                                .equals(resourceFilter.containerPattern);
                    }
                }
            }
            return false;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#
         * equalsFilter
         * (org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter)
         */
        public boolean equalsFilter(ItemsFilter iFilter) {
            if (!super.equalsFilter(iFilter))
                return false;
            if (iFilter instanceof ResourceFilter) {
                ResourceFilter resourceFilter = (ResourceFilter) iFilter;
                if (this.showDerived == resourceFilter.showDerived) {
                    if (containerPattern == null) {
                        return resourceFilter.containerPattern == null;
                    } else if (resourceFilter.containerPattern == null) {
                        return false;
                    } else {
                        return containerPattern
                                .equals(resourceFilter.containerPattern);
                    }
                }
            }
            return false;
        }

        /**
         * Check show derived flag for a filter
         * 
         * @return true if filter allow derived resources false if not
         */
        public boolean isShowDerived() {
            return showDerived;
        }

    }

    protected abstract class ItemsFilter {

        protected SearchPattern patternMatcher;

        /**
         * Creates new instance of ItemsFilter.
         */
        public ItemsFilter() {
            this(new SearchPattern());
        }

        /**
         * Creates new instance of ItemsFilter.
         * 
         * @param searchPattern
         *        the pattern to be used when filtering
         */
        public ItemsFilter(SearchPattern searchPattern) {
            patternMatcher = searchPattern;
            String stringPattern = ".n4j"; //$NON-NLS-1$
            if (pattern != null && !pattern.getText().equals("*")) { //$NON-NLS-1$
                stringPattern = pattern.getText();
            }
            patternMatcher.setPattern(stringPattern);
        }

        /**
         * Check if the given filter is a sub-filter of this filter. The default
         * implementation checks if the <code>SearchPattern</code> from the
         * given filter is a sub-pattern of the one from this filter.
         * <p>
         * <i>WARNING: This method is <b>not</b> defined in reading order, i.e. <code>a.isSubFilter(b)</code> is
         * <code>true</code> iff <code>b</code> is a sub-filter of <code>a</code>, and not vice-versa. </i>
         * </p>
         * 
         * @param filter
         *        the filter to be checked, or <code>null</code>
         * @return <code>true</code> if the given filter is sub-filter of this
         *         filter, <code>false</code> if the given filter isn't a
         *         sub-filter or is <code>null</code>
         * 
         * @see org.eclipse.ui.dialogs.SearchPattern#isSubPattern(org.eclipse.ui.dialogs.SearchPattern)
         */
        public boolean isSubFilter(ItemsFilter filter) {
            if (filter != null) {
                return this.patternMatcher.isSubPattern(filter.patternMatcher);
            }
            return false;
        }

        /**
         * Checks whether the provided filter is equal to the current filter.
         * The default implementation checks if <code>SearchPattern</code> from
         * current filter is equal to the one from provided filter.
         * 
         * @param filter
         *        filter to be checked, or <code>null</code>
         * @return <code>true</code> if the given filter is equal to current
         *         filter, <code>false</code> if given filter isn't equal to
         *         current one or if it is <code>null</code>
         * 
         * @see org.eclipse.ui.dialogs.SearchPattern#equalsPattern(org.eclipse.ui.dialogs.SearchPattern)
         */
        public boolean equalsFilter(ItemsFilter filter) {
            if (filter != null
                    && filter.patternMatcher.equalsPattern(this.patternMatcher)) {
                return true;
            }
            return false;
        }

        /**
         * Checks whether the pattern's match rule is camel case.
         * 
         * @return <code>true</code> if pattern's match rule is camel case, <code>false</code> otherwise
         */
        public boolean isCamelCasePattern() {
            return patternMatcher.getMatchRule() == SearchPattern.RULE_CAMELCASE_MATCH;
        }

        /**
         * Returns the pattern string.
         * 
         * @return pattern for this filter
         * 
         * @see SearchPattern#getPattern()
         */
        public String getPattern() {
            return patternMatcher.getPattern();
        }

        /**
         * Returns the rule to apply for matching keys.
         * 
         * @return an implementation-specific match rule
         * 
         * @see SearchPattern#getMatchRule() for match rules returned by the
         *      default implementation
         */
        public int getMatchRule() {
            return patternMatcher.getMatchRule();
        }

        /**
         * Matches text with filter.
         * 
         * @param text
         *        the text to match with the filter
         * @return <code>true</code> if text matches with filter pattern, <code>false</code> otherwise
         */
        protected boolean matches(String text) {
            return patternMatcher.matches(text);
        }

        /**
         * General method for matching raw name pattern. Checks whether current
         * pattern is prefix of name provided item.
         * 
         * @param item
         *        item to check
         * @return <code>true</code> if current pattern is a prefix of name
         *         provided item, <code>false</code> if item's name is shorter
         *         than prefix or sequences of characters don't match.
         */
        public boolean matchesRawNamePattern(Object item) {
            String prefix = patternMatcher.getPattern();
            String text = getElementName(item);

            if (text == null)
                return false;

            int textLength = text.length();
            int prefixLength = prefix.length();
            if (textLength < prefixLength) {
                return false;
            }
            for (int i = prefixLength - 1; i >= 0; i--) {
                if (Character.toLowerCase(prefix.charAt(i)) != Character
                        .toLowerCase(text.charAt(i)))
                    return false;
            }
            return true;
        }

        /**
         * Matches an item against filter conditions.
         * 
         * @param item
         * @return <code>true<code> if item matches against filter conditions, <code>false</code> otherwise
         */
        public abstract boolean matchItem(Object item);

        /**
         * Checks consistency of an item. Item is inconsistent if was changed or
         * removed.
         * 
         * @param item
         * @return <code>true</code> if item is consistent, <code>false</code> if item is inconsistent
         */
        public abstract boolean isConsistentItem(Object item);

    }

    protected abstract class AbstractContentProvider {
        /**
         * Adds the item to the content provider iff the filter matches the
         * item. Otherwise does nothing.
         * 
         * @param item
         *        the item to add
         * @param itemsFilter
         *        the filter
         * 
         * @see FilteredItemsSelectionDialog.ItemsFilter#matchItem(Object)
         */
        public abstract void add(Object item, ItemsFilter itemsFilter);
    }

    /**
     * ResourceProxyVisitor to visit resource tree and get matched resources.
     * During visit resources it updates progress monitor and adds matched
     * resources to ContentProvider instance.
     */
    private class ResourceProxyVisitor implements IResourceProxyVisitor {

        private AbstractContentProvider proxyContentProvider;

        private ResourceFilter resourceFilter;

        private IProgressMonitor progressMonitor;

        private List projects;

        /**
         * Creates new ResourceProxyVisitor instance.
         * 
         * @param contentProvider
         * @param resourceFilter
         * @param progressMonitor
         * @throws CoreException
         */
        public ResourceProxyVisitor(AbstractContentProvider contentProvider,
                ResourceFilter resourceFilter, IProgressMonitor progressMonitor)
                throws CoreException {
            super();
            this.proxyContentProvider = contentProvider;
            this.resourceFilter = resourceFilter;
            this.progressMonitor = progressMonitor;
            IResource[] resources = container.members();
            this.projects = new ArrayList(Arrays.asList(resources));

            if (progressMonitor != null)
                progressMonitor
                        .beginTask(
                                WorkbenchMessages.FilteredItemsSelectionDialog_searchJob_taskName,
                                projects.size());
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse
         * .core.resources.IResourceProxy)
         */
        public boolean visit(IResourceProxy proxy) {

            if (progressMonitor.isCanceled())
                return false;

            IResource resource = proxy.requestResource();

            if (this.projects.remove((resource.getProject()))
                    || this.projects.remove((resource))) {
                progressMonitor.worked(1);
            }

            proxyContentProvider.add(resource, resourceFilter);

            if (resource.getType() == IResource.FOLDER && resource.isDerived()
                    && !resourceFilter.isShowDerived()) {

                return false;
            }

            if (resource.getType() == IResource.FILE) {
                return false;
            }

            return true;
        }
    }

    // protected static abstract class SelectionHistory {
    //
    //		private static final String DEFAULT_ROOT_NODE_NAME = "historyRootNode"; //$NON-NLS-1$
    //
    //		private static final String DEFAULT_INFO_NODE_NAME = "infoNode"; //$NON-NLS-1$
    //
    // private static final int MAX_HISTORY_SIZE = 60;
    //
    // private final Set historyList;
    //
    // private final String rootNodeName;
    //
    // private final String infoNodeName;
    //
    // private SelectionHistory(String rootNodeName, String infoNodeName) {
    //
    // historyList = Collections.synchronizedSet(new LinkedHashSet() {
    //
    // private static final long serialVersionUID = 0L;
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see java.util.LinkedList#add(java.lang.Object)
    // */
    // public boolean add(Object arg0) {
    // if (this.size() >= MAX_HISTORY_SIZE) {
    // Iterator iterator = this.iterator();
    // iterator.next();
    // iterator.remove();
    // }
    // return super.add(arg0);
    // }
    //
    // });
    //
    // this.rootNodeName = rootNodeName;
    // this.infoNodeName = infoNodeName;
    // }
    //
    // /**
    // * Creates new instance of <code>SelectionHistory</code>.
    // */
    // public SelectionHistory() {
    // this(DEFAULT_ROOT_NODE_NAME, DEFAULT_INFO_NODE_NAME);
    // }
    //
    // /**
    // * Adds object to history.
    // *
    // * @param object
    // * the item to be added to the history
    // */
    // public synchronized void accessed(Object object) {
    // historyList.remove(object);
    // historyList.add(object);
    // }
    //
    // /**
    // * Returns <code>true</code> if history contains object.
    // *
    // * @param object
    // * the item for which check will be executed
    // * @return <code>true</code> if history contains object
    // * <code>false</code> in other way
    // */
    // public synchronized boolean contains(Object object) {
    // return historyList.contains(object);
    // }
    //
    // /**
    // * Returns <code>true</code> if history is empty.
    // *
    // * @return <code>true</code> if history is empty
    // */
    // public synchronized boolean isEmpty() {
    // return historyList.isEmpty();
    // }
    //
    // /**
    // * Remove element from history.
    // *
    // * @param element
    // * to remove form the history
    // * @return <code>true</code> if this list contained the specified
    // * element
    // */
    // public synchronized boolean remove(Object element) {
    // return historyList.remove(element);
    // }
    //
    // /**
    // * Load history elements from memento.
    // *
    // * @param memento
    // * memento from which the history will be retrieved
    // */
    // public void load(IMemento memento) {
    //
    // XMLMemento historyMemento = (XMLMemento) memento
    // .getChild(rootNodeName);
    //
    // if (historyMemento == null) {
    // return;
    // }
    //
    // IMemento[] mementoElements = historyMemento
    // .getChildren(infoNodeName);
    // for (int i = 0; i < mementoElements.length; ++i) {
    // IMemento mementoElement = mementoElements[i];
    // Object object = restoreItemFromMemento(mementoElement);
    // if (object != null) {
    // historyList.add(object);
    // }
    // }
    // }
    //
    // /**
    // * Save history elements to memento.
    // *
    // * @param memento
    // * memento to which the history will be added
    // */
    // public void save(IMemento memento) {
    //
    // IMemento historyMemento = memento.createChild(rootNodeName);
    //
    // Object[] items = getHistoryItems();
    // for (int i = 0; i < items.length; i++) {
    // Object item = items[i];
    // IMemento elementMemento = historyMemento
    // .createChild(infoNodeName);
    // storeItemToMemento(item, elementMemento);
    // }
    //
    // }
    //
    // /**
    // * Gets array of history items.
    // *
    // * @return array of history elements
    // */
    // public synchronized Object[] getHistoryItems() {
    // return historyList.toArray();
    // }
    //
    // /**
    // * Creates an object using given memento.
    // *
    // * @param memento
    // * memento used for creating new object
    // *
    // * @return the restored object
    // */
    // protected abstract Object restoreItemFromMemento(IMemento memento);
    //
    // /**
    // * Store object in <code>IMemento</code>.
    // *
    // * @param item
    // * the item to store
    // * @param memento
    // * the memento to store to
    // */
    // protected abstract void storeItemToMemento(Object item, IMemento memento);
    //
    // }

    // private class ResourceSelectionHistory extends SelectionHistory {
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see
    // * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.SelectionHistory
    // * #restoreItemFromMemento(org.eclipse.ui.IMemento)
    // */
    // protected Object restoreItemFromMemento(IMemento element) {
    // ResourceFactory resourceFactory = new ResourceFactory();
    // IResource resource = (IResource) resourceFactory
    // .createElement(element);
    // return resource;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see
    // * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.SelectionHistory
    // * #storeItemToMemento(java.lang.Object, org.eclipse.ui.IMemento)
    // */
    // protected void storeItemToMemento(Object item, IMemento element) {
    // IResource resource = (IResource) item;
    // ResourceFactory resourceFactory = new ResourceFactory(resource);
    // resourceFactory.saveState(element);
    // }
    //
    // }
    private class ItemsListSeparator {

        private String name;

        // /**
        // * Creates a new instance of the class.
        // *
        // * @param name
        // * the name of the separator
        // */
        // public ItemsListSeparator(String name) {
        // this.name = name;
        // }
        //
        // /**
        // * Returns the name of this separator.
        // *
        // * @return the name of the separator
        // */
        // public String getName() {
        // return name;
        // }
    }

    //
    // public boolean isHistoryElement(Object item) {
    // return this.contentProvider.isHistoryElement(item);
    // }

    private List<String> getFlowsWithStartNodes(Object f)
    {
        File file = (File) f;
        List<String> startNodes = new ArrayList<String>();
        String packageName = getFlowPackage(file);
        for (String eid : getNetwork(file, packageName))
        {
            startNodes.add(packageName + "-" + eid);
        }

        return startNodes;
    }

    @SuppressWarnings("restriction")
    private String getFlowPackage(File file)
    {
        String fileRelativePath = file.getProjectRelativePath().toPortableString();
        List<String> sourceFolders = getSourceDirectories(file.getProject());
        String path = getFilePathWithPackage(sourceFolders, new StringBuilder("/").append(file.getProject().getName()).append("/").append(fileRelativePath).toString());

        return path;
    }

    private String getFilePathWithPackage(List<String> sourceFolders, String fileRelativePath)
    {
        String name = null;
        for (String source : sourceFolders)
        {
            if (fileRelativePath.startsWith(source))
            {
                return fileRelativePath.replaceFirst(source, "").replace("/", ".").replace("." + PropetiesConstants.FLOW_FILE_EXT, "");
            }
        }
        return name;
    }

    @SuppressWarnings("restriction")
    private List<String> getNetwork(File iResource, String flow) {
        List<String> list = Collections.emptyList();
        InputStream fis = null;

        try {
            fis = iResource.getContents();
            if (null != fis) {
                list = FlowUtils.getStartNodeList(fis, flow);
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<String> getSourceDirectories(IProject project)
    {
        if (project == null)
            return null;

        List<String> ret = projectSources.get(project);
        if (ret != null)
        {
            return ret;
        } else {
            ret = new ArrayList<String>();
        }

        IJavaProject javaProject = JavaCore.create(project);
        try {
            IPackageFragmentRoot[] packageFragmentRoot = javaProject.getAllPackageFragmentRoots();
            for (int i = 0; i < packageFragmentRoot.length; i++) {
                if (packageFragmentRoot[i].getKind() == IPackageFragmentRoot.K_SOURCE && !packageFragmentRoot[i].isArchive())
                    ret.add(packageFragmentRoot[i].getPath().toPortableString() + "/");
            }
        } catch (JavaModelException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
        projectSources.put(project, ret);
        return ret;
    }
}
