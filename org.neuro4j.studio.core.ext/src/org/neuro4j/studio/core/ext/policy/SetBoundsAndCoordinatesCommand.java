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
package org.neuro4j.studio.core.ext.policy;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.ActionNode;

public class SetBoundsAndCoordinatesCommand extends AbstractTransactionalCommand {

    private IAdaptable adapter;
    private Point location;
    private Dimension size;

    /**
     * Creates a <code>SetBoundsCommand</code> for the given view adapter with a given bounds.
     * 
     * @param editingDomain
     *        the editing domain through which model changes are made
     * @param label
     *        The command label
     * @param adapter
     *        An adapter to the <code>View</code>
     * @param bounds
     *        The new bounds
     */
    public SetBoundsAndCoordinatesCommand(TransactionalEditingDomain editingDomain, String label, IAdaptable adapter, Rectangle bounds) {
        super(editingDomain, label, null);
        Assert.isNotNull(adapter, "view cannot be null"); //$NON-NLS-1$
        Assert.isNotNull(bounds, "bounds cannot be null"); //$NON-NLS-1$
        this.adapter = adapter;
        this.location = bounds.getLocation();
        this.size = bounds.getSize();
    }

    /**
     * Creates a <code>SetBoundsCommand</code> for the given view adapter with a given location.
     * 
     * @param editingDomain
     *        the editing domain through which model changes are made
     * @param label
     *        The command label
     * @param adapter
     *        An adapter to the <code>View</code>
     * @param location
     *        The new location
     */
    public SetBoundsAndCoordinatesCommand(TransactionalEditingDomain editingDomain, String label, IAdaptable adapter, Point location) {
        super(editingDomain, label, null);
        Assert.isNotNull(adapter, "view cannot be null"); //$NON-NLS-1$
        Assert.isNotNull(location, "location cannot be null"); //$NON-NLS-1$
        this.adapter = adapter;
        this.location = location;
    }

    /**
     * Creates a <code>SetBoundsCommand</code> for the given view adapter with a given size.
     * 
     * @param editingDomain
     *        the editing domain through which model changes are made
     * @param label
     *        The command label
     * @param adapter
     *        An adapter to the <code>View</code>
     * @param size
     *        The new size
     */
    public SetBoundsAndCoordinatesCommand(TransactionalEditingDomain editingDomain, String label, IAdaptable adapter, Dimension size) {
        super(editingDomain, label, null);
        Assert.isNotNull(adapter, "view cannot be null"); //$NON-NLS-1$
        Assert.isNotNull(size, "size cannot be null"); //$NON-NLS-1$
        this.adapter = adapter;
        this.size = size;
    }

    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
            throws ExecutionException {

        if (adapter == null)
            return CommandResult.newErrorCommandResult("SetBoundsCommand: viewAdapter does not adapt to IView.class"); //$NON-NLS-1$

        View view = (View) adapter.getAdapter(View.class);

        if (location != null) {
            ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(location.x));
            ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(location.y));

            if (view.getElement() instanceof ActionNode)
            {
                ActionNode actionNode = (ActionNode) view.getElement();
                if (actionNode.getX() == 0 && actionNode.getY() == 0)
                {
                    actionNode.setX(location.x);
                    actionNode.setY(location.y);
                }
            }

        }
        if (size != null) {
            ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(), Integer.valueOf(size.width));
            ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(), Integer.valueOf(size.height));
        }
        return CommandResult.newOKCommandResult();
    }

    public List getAffectedFiles() {
        if (adapter != null) {
            View view = (View) adapter.getAdapter(View.class);
            if (view != null) {
                return getWorkspaceFiles(view);
            }
        }
        return super.getAffectedFiles();
    }
}
