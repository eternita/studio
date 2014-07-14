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
package org.neuro4j.studio.debug.ui.views;

import org.eclipse.debug.internal.ui.viewers.model.ILabelUpdateListener;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IColumnPresentation;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelChangedListener;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IStateUpdateListener;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IViewerUpdateListener;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IMemento;

public class ViewerAdapter extends TreeModelViewer {

    TreeModelViewer adapter;

    public ViewerAdapter(TreeModelViewer adapter, Composite parent) {
        super(parent, 268436226, null);
        this.adapter = adapter;
    }

    public void add(Object parentElementOrTreePath, Object childElement) {
        adapter.add(parentElementOrTreePath, childElement);
    }

    public void add(Object parentElementOrTreePath, Object[] childElements) {
        adapter.add(parentElementOrTreePath, childElements);
    }

    public void addDoubleClickListener(IDoubleClickListener listener) {
        adapter.addDoubleClickListener(listener);
    }

    public void addDragSupport(int operations, Transfer[] transferTypes,
            DragSourceListener listener) {
        adapter.addDragSupport(operations, transferTypes, listener);
    }

    public void addDropSupport(int operations, Transfer[] transferTypes,
            DropTargetListener listener) {
        adapter.addDropSupport(operations, transferTypes, listener);
    }

    public void addFilter(ViewerFilter filter) {
        adapter.addFilter(filter);
    }

    public void addHelpListener(HelpListener listener) {
        adapter.addHelpListener(listener);
    }

    public void addLabelUpdateListener(ILabelUpdateListener listener) {
        adapter.addLabelUpdateListener(listener);
    }

    public void addModelChangedListener(IModelChangedListener listener) {
        adapter.addModelChangedListener(listener);
    }

    public void addOpenListener(IOpenListener listener) {
        adapter.addOpenListener(listener);
    }

    public void addPostSelectionChangedListener(
            ISelectionChangedListener listener) {
        adapter.addPostSelectionChangedListener(listener);
    }

    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        adapter.addSelectionChangedListener(listener);
    }

    public void addStateUpdateListener(IStateUpdateListener listener) {
        adapter.addStateUpdateListener(listener);
    }

    public void addTreeListener(ITreeViewerListener listener) {
        adapter.addTreeListener(listener);
    }

    public void addViewerUpdateListener(IViewerUpdateListener listener) {
        adapter.addViewerUpdateListener(listener);
    }

    public void autoExpand(TreePath elementPath) {
        adapter.autoExpand(elementPath);
    }

    public boolean canToggleColumns() {
        return adapter.canToggleColumns();
    }

    public void cancelEditing() {
        adapter.cancelEditing();
    }

    public void clearSelectionQuiet() {
        adapter.clearSelectionQuiet();
    }

    public void collapseAll() {
        adapter.collapseAll();
    }

    public void collapseToLevel(Object elementOrTreePath, int level) {
        adapter.collapseToLevel(elementOrTreePath, level);
    }

    public void editElement(Object element, int column) {
        adapter.editElement(element, column);
    }

    public boolean equals(Object arg0) {
        return adapter.equals(arg0);
    }

    public void expandAll() {
        adapter.expandAll();
    }

    public void expandToLevel(int level) {
        adapter.expandToLevel(level);
    }

    public void expandToLevel(Object elementOrTreePath, int level) {
        adapter.expandToLevel(elementOrTreePath, level);
    }

    public int findElementIndex(TreePath parentPath, Object element) {
        return adapter.findElementIndex(parentPath, element);
    }

    public Widget findItem(TreePath path) {
        return adapter.findItem(path);
    }

    public int getAutoExpandLevel() {
        return adapter.getAutoExpandLevel();
    }

    public ViewerCell getCell(Point point) {
        return adapter.getCell(point);
    }

    public CellEditor[] getCellEditors() {
        return adapter.getCellEditors();
    }

    public ICellModifier getCellModifier() {
        return adapter.getCellModifier();
    }

    public int getChildCount(TreePath path) {
        return adapter.getChildCount(path);
    }

    public Object getChildElement(TreePath path, int index) {
        return adapter.getChildElement(path, index);
    }

    public Item[] getChildren(Widget widget, Object[] elementChildren) {
        return adapter.getChildren(widget, elementChildren);
    }

    public Item[] getChildren(Widget widget) {
        return adapter.getChildren(widget);
    }

    public IColumnPresentation getColumnPresentation() {
        return adapter.getColumnPresentation();
    }

    public Object[] getColumnProperties() {
        return adapter.getColumnProperties();
    }

    public ColumnViewerEditor getColumnViewerEditor() {
        return adapter.getColumnViewerEditor();
    }

    public ViewerComparator getComparator() {
        return adapter.getComparator();
    }

    public IElementComparer getComparer() {
        return adapter.getComparer();
    }

    public IContentProvider getContentProvider() {
        return adapter.getContentProvider();
    }

    public Control getControl() {
        return adapter.getControl();
    }

    public Object getData(String key) {
        return adapter.getData(key);
    }

    public Display getDisplay() {
        return adapter.getDisplay();
    }

    public boolean getElementChecked(TreePath path) {
        return adapter.getElementChecked(path);
    }

    public boolean getElementChildrenRealized(TreePath parentPath) {
        return adapter.getElementChildrenRealized(parentPath);
    }

    public boolean getElementGrayed(TreePath path) {
        return adapter.getElementGrayed(path);
    }

    public ViewerLabel getElementLabel(TreePath path, String columnId) {
        return adapter.getElementLabel(path, columnId);
    }

    public TreePath[] getElementPaths(Object element) {
        return adapter.getElementPaths(element);
    }

    public Object[] getExpandedElements() {
        return adapter.getExpandedElements();
    }

    public boolean getExpandedState(Object elementOrTreePath) {
        return adapter.getExpandedState(elementOrTreePath);
    }

    public TreePath[] getExpandedTreePaths() {
        return adapter.getExpandedTreePaths();
    }

    public ViewerFilter[] getFilters() {
        return adapter.getFilters();
    }

    public boolean getHasChildren(Object elementOrTreePath) {
        return adapter.getHasChildren(elementOrTreePath);
    }

    public int getInitialColumnWidth(String columnId, int treeWidgetWidth,
            String[] visibleColumnIds) {
        return adapter.getInitialColumnWidth(columnId, treeWidgetWidth,
                visibleColumnIds);
    }

    public Object getInput() {
        return adapter.getInput();
    }

    public IBaseLabelProvider getLabelProvider() {
        return adapter.getLabelProvider();
    }

    public CellLabelProvider getLabelProvider(int columnIndex) {
        return adapter.getLabelProvider(columnIndex);
    }

    public IPresentationContext getPresentationContext() {
        return adapter.getPresentationContext();
    }

    public ISelection getSelection() {
        return adapter.getSelection();
    }

    public ViewerSorter getSorter() {
        return adapter.getSorter();
    }

    public TreePath getTopElementPath() {
        return adapter.getTopElementPath();
    }

    public Tree getTree() {
        if (adapter == null)
        {
            return null;
        }
        return adapter.getTree();
    }

    public String[] getVisibleColumns() {
        return adapter.getVisibleColumns();
    }

    public Object[] getVisibleExpandedElements() {
        return adapter.getVisibleExpandedElements();
    }

    public int hashCode() {
        return adapter.hashCode();
    }

    public void initState(IMemento memento) {
        adapter.initState(memento);
    }

    public void insert(Object parentElementOrTreePath, Object element,
            int position) {
        adapter.insert(parentElementOrTreePath, element, position);
    }

    public boolean isBusy() {
        return adapter.isBusy();
    }

    public boolean isCellEditorActive() {
        return adapter.isCellEditorActive();
    }

    public boolean isExpandable(Object element) {
        return adapter.isExpandable(element);
    }

    public boolean isShowColumns() {
        return adapter.isShowColumns();
    }

    public boolean overrideSelection(ISelection current, ISelection candidate) {
        return adapter.overrideSelection(current, candidate);
    }

    public void refresh() {
        adapter.refresh();
    }

    public void refresh(boolean updateLabels) {
        adapter.refresh(updateLabels);
    }

    public void refresh(Object element, boolean updateLabels) {
        adapter.refresh(element, updateLabels);
    }

    public void refresh(Object element) {
        adapter.refresh(element);
    }

    public void remove(Object parentOrTreePath, int index) {
        adapter.remove(parentOrTreePath, index);
    }

    public void remove(Object parent, Object[] elements) {
        adapter.remove(parent, elements);
    }

    public void remove(Object elementsOrTreePaths) {
        adapter.remove(elementsOrTreePaths);
    }

    public void remove(Object[] elementsOrTreePaths) {
        adapter.remove(elementsOrTreePaths);
    }

    public void removeDoubleClickListener(IDoubleClickListener listener) {
        adapter.removeDoubleClickListener(listener);
    }

    public void removeFilter(ViewerFilter filter) {
        adapter.removeFilter(filter);
    }

    public void removeHelpListener(HelpListener listener) {
        adapter.removeHelpListener(listener);
    }

    public void removeLabelUpdateListener(ILabelUpdateListener listener) {
        adapter.removeLabelUpdateListener(listener);
    }

    public void removeModelChangedListener(IModelChangedListener listener) {
        adapter.removeModelChangedListener(listener);
    }

    public void removeOpenListener(IOpenListener listener) {
        adapter.removeOpenListener(listener);
    }

    public void removePostSelectionChangedListener(
            ISelectionChangedListener listener) {
        adapter.removePostSelectionChangedListener(listener);
    }

    public void removeSelectionChangedListener(
            ISelectionChangedListener listener) {
        adapter.removeSelectionChangedListener(listener);
    }

    public void removeStateUpdateListener(IStateUpdateListener listener) {
        adapter.removeStateUpdateListener(listener);
    }

    public void removeTreeListener(ITreeViewerListener listener) {
        adapter.removeTreeListener(listener);
    }

    public void removeViewerUpdateListener(IViewerUpdateListener listener) {
        adapter.removeViewerUpdateListener(listener);
    }

    public void replace(Object parentElementOrTreePath, int index,
            Object element) {
        adapter.replace(parentElementOrTreePath, index, element);
    }

    public void resetColumnSizes(String[] columnIds) {
        adapter.resetColumnSizes(columnIds);
    }

    public void resetFilters() {
        adapter.resetFilters();
    }

    public void reveal(Object elementOrTreePath) {
        adapter.reveal(elementOrTreePath);
    }

    public void reveal(TreePath path, int index) {
        adapter.reveal(path, index);
    }

    public boolean saveElementState(TreePath path, ModelDelta delta,
            int flagsToSave) {
        return adapter.saveElementState(path, delta, flagsToSave);
    }

    public void saveState(IMemento memento) {
        adapter.saveState(memento);
    }

    public Item scrollDown(int x, int y) {
        return adapter.scrollDown(x, y);
    }

    public Item scrollUp(int x, int y) {
        return adapter.scrollUp(x, y);
    }

    public void setAutoExpandLevel(int level) {
        adapter.setAutoExpandLevel(level);
    }

    public void setCellEditors(CellEditor[] editors) {
        adapter.setCellEditors(editors);
    }

    public void setCellModifier(ICellModifier modifier) {
        adapter.setCellModifier(modifier);
    }

    public void setChildCount(Object elementOrTreePath, int count) {
        adapter.setChildCount(elementOrTreePath, count);
    }

    public void setColumnProperties(String[] columnProperties) {
        adapter.setColumnProperties(columnProperties);
    }

    public void setColumnViewerEditor(ColumnViewerEditor columnViewerEditor) {
        adapter.setColumnViewerEditor(columnViewerEditor);
    }

    public void setComparator(ViewerComparator comparator) {
        adapter.setComparator(comparator);
    }

    public void setComparer(IElementComparer comparer) {
        adapter.setComparer(comparer);
    }

    public void setContentProvider(IContentProvider provider) {
        adapter.setContentProvider(provider);
    }

    public void setData(String key, Object value) {
        adapter.setData(key, value);
    }

    public void setElementChecked(TreePath path, boolean checked, boolean grayed) {
        adapter.setElementChecked(path, checked, grayed);
    }

    public void setElementData(TreePath path, int numColumns, String[] labels,
            ImageDescriptor[] imageDescriptors, FontData[] fontDatas,
            RGB[] _foregrounds, RGB[] _backgrounds) {
        adapter.setElementData(path, numColumns, labels, imageDescriptors,
                fontDatas, _foregrounds, _backgrounds);
    }

    public void setExpandPreCheckFilters(boolean checkFilters) {
        adapter.setExpandPreCheckFilters(checkFilters);
    }

    public void setExpandedElements(Object[] elements) {
        adapter.setExpandedElements(elements);
    }

    public void setExpandedState(Object elementOrTreePath, boolean expanded) {
        adapter.setExpandedState(elementOrTreePath, expanded);
    }

    public void setExpandedTreePaths(TreePath[] treePaths) {
        adapter.setExpandedTreePaths(treePaths);
    }

    public void setFilters(ViewerFilter[] filters) {
        adapter.setFilters(filters);
    }

    public void setHasChildren(Object elementOrTreePath, boolean hasChildren) {
        adapter.setHasChildren(elementOrTreePath, hasChildren);
    }

    public void setLabelProvider(IBaseLabelProvider labelProvider) {
        adapter.setLabelProvider(labelProvider);
    }

    public void setSelection(ISelection selection, boolean reveal, boolean force) {
        adapter.setSelection(selection, reveal, force);
    }

    public void setSelection(ISelection selection, boolean reveal) {
        adapter.setSelection(selection, reveal);
    }

    public void setSelection(ISelection selection) {
        adapter.setSelection(selection);
    }

    public void setShowColumns(boolean show) {
        adapter.setShowColumns(show);
    }

    public void setSorter(ViewerSorter sorter) {
        adapter.setSorter(sorter);
    }

    public void setUseHashlookup(boolean enable) {
        adapter.setUseHashlookup(enable);
    }

    public void setVisibleColumns(String[] ids) {
        adapter.setVisibleColumns(ids);
    }

    public Widget testFindItem(Object element) {
        return adapter.testFindItem(element);
    }

    public Widget[] testFindItems(Object element) {
        return adapter.testFindItems(element);
    }

    public String toString() {
        return adapter.toString();
    }

    public boolean trySelection(ISelection selection, boolean reveal,
            boolean force) {
        return adapter.trySelection(selection, reveal, force);
    }

    public void update(Object element, String[] properties) {
        adapter.update(element, properties);
    }

    public void update(Object element) {
        adapter.update(element);
    }

    public void update(Object[] elements, String[] properties) {
        adapter.update(elements, properties);
    }

    public void updateViewer(IModelDelta delta) {
        adapter.updateViewer(delta);
    }

}
