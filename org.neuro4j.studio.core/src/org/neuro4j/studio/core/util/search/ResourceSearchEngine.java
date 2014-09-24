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
package org.neuro4j.studio.core.util.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.ui.ide.ResourceUtil;

public class ResourceSearchEngine {

    public ResourceSearchEngine() {

        container = ResourcesPlugin.getWorkspace().getRoot();
        typeMask = IResource.FILE;

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

    protected ItemsFilter createFilter(String name) {
        return new ResourceFilter(container, searchContainer, isDerived,
                typeMask, name);
    }

    public List<IFile> findFiles(String name) throws CoreException {

        ItemsFilter itemsFilter = createFilter(name);
        this.filter = itemsFilter;
        contentProvider = new ContentProvider();

        if (itemsFilter instanceof ResourceFilter)
            container.accept(new ResourceProxyVisitor(contentProvider,
                    (ResourceFilter) itemsFilter),
                    IResource.NONE);

        List<IFile> files = new ArrayList<IFile>();
        files.addAll(contentProvider.items);
        return files;
    }

    private IContainer container;
    private IContainer searchContainer;

    private int typeMask;
    private Text pattern;
    private boolean isDerived;
    private ItemsFilter filter;

    private ContentProvider contentProvider;

    public String getElementName(Object item) {
        IResource resource = (IResource) item;
        return resource.getName();
    }

    private class ContentProvider extends AbstractContentProvider implements
            IStructuredContentProvider {

        /**
         * Raw result of the searching (unsorted, unfiltered).
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */
        private Set<IFile> items;

        /**
         * Result of the last filtering.
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */
        private List<IFile> lastFilteredItems;

        /**
         * Result of the last sorting.
         * <p>
         * Standard object flow: <code>items -> lastSortedItems -> lastFilteredItems</code>
         */

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

            this.lastFilteredItems = new ArrayList<IFile>();

        }

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
                        this.items.add((IFile) item);
                    }
                } else {

                    this.items.add((IFile) item);
                }
            }
        }

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
                IContainer searchContainer, boolean showDerived, int typeMask, String name) {
            this(container, showDerived, typeMask);

            String stringPattern = "*" + name;
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
            this(container, searchContainer, isDerived, typeMask, "");
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
            String n = item.toString();
            if (n.contains(".jar"))
            {
                // System.out.println("Jar!");
            }
            // System.out.println(item);
            if (!(item instanceof IResource)) {
                return false;
            }
            if (!(item instanceof IFile)) {
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
                ResourceFilter resourceFilter)
                throws CoreException {
            super();
            this.proxyContentProvider = contentProvider;
            this.resourceFilter = resourceFilter;

            IResource[] resources = container.members();
            this.projects = new ArrayList(Arrays.asList(resources));

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse
         * .core.resources.IResourceProxy)
         */
        public boolean visit(IResourceProxy proxy) {

            IResource resource = proxy.requestResource();

            if (this.projects.remove((resource.getProject()))
                    || this.projects.remove((resource))) {

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

}
