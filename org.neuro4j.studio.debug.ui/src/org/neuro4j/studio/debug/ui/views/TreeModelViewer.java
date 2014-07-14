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

import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

public class TreeModelViewer extends InternalTreeModelViewer {

    public TreeModelViewer(Composite parent, int style,
            IPresentationContext context) {
        super(parent, style, context);
    }

    @Override
    public int findElementIndex(TreePath parentPath, Object element) {
        // TODO Auto-generated method stub
        return super.findElementIndex(parentPath, element);
    }

    @Override
    public Widget findItem(TreePath path) {
        // TODO Auto-generated method stub
        return super.findItem(path);
    }

    @Override
    public TreePath[] getElementPaths(Object element) {
        // TODO Auto-generated method stub
        return super.getElementPaths(element);
    }

    @Override
    public TreePath getTopElementPath() {
        // TODO Auto-generated method stub
        return super.getTopElementPath();
    }

    @Override
    protected TreePath getTreePathFromItem(Item item) {
        // TODO Auto-generated method stub
        return super.getTreePathFromItem(item);
    }

    @Override
    public void setSelection(ISelection selection, boolean reveal, boolean force) {
        // TODO Auto-generated method stub
        super.setSelection(selection, reveal, force);
    }

    @Override
    public void setSelection(ISelection selection, boolean reveal) {
        // TODO Auto-generated method stub
        super.setSelection(selection, reveal);
    }

    @Override
    public boolean trySelection(ISelection selection, boolean reveal,
            boolean force) {
        // TODO Auto-generated method stub
        return super.trySelection(selection, reveal, force);
    }

    @Override
    protected void createChildren(Widget widget) {
        // TODO Auto-generated method stub
        super.createChildren(widget);
    }

}
