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
package org.neuro4j.studio.core.diagram.edit.shapes.anchors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;

public class MySetConnectionBendpointsCommand extends SetConnectionBendpointsCommand {
    private List relPointList = new ArrayList(4);


    /**
     * @param editingDomain
     *        the editing domain through which model changes are made
     * @see java.lang.Object#Object()
     */
    public MySetConnectionBendpointsCommand(TransactionalEditingDomain editingDomain) {
        super(editingDomain);

    }


    /**
     * Returns the edgeAdaptor.
     * 
     * @return IAdaptable
     */

    public List getRelPointList() {
        return relPointList;
    }




    public void setNewPointList(
            List newPointList,
            Point sourceRefPoint,
            Point targetRefPoint) {
        super.setNewPointList(new PointList(), sourceRefPoint, targetRefPoint);

        this.relPointList = new ArrayList(newPointList.size());
        for (int i = 0; i < newPointList.size(); i++) {
            this.relPointList.add(newPointList.get(i));
        }

    }



    protected CommandResult doExecuteWithSavedResult(
            IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {

        Assert.isNotNull(relPointList);
        Assert.isNotNull(getSourceRefPoint());
        Assert.isNotNull(getTargetRefPoint());

        Edge edge =
                (Edge) getEdgeAdaptor().getAdapter(Edge.class);
        Assert.isNotNull(edge);

        List newBendpoints = new ArrayList();
        int numOfPoints = relPointList.size();
        for (short i = 0; i < numOfPoints; i++) {
            newBendpoints.add(relPointList.get(i));
        }

        RelativeBendpoints points = (RelativeBendpoints) edge.getBendpoints();
        points.setPoints(newBendpoints);
        return CommandResult.newOKCommandResult();
    }

    protected CommandResult doExecuteWithResult(
            IProgressMonitor progressMonitor, IAdaptable info)
            throws ExecutionException {
        if (relPointList != null && relPointList.size() > 0)
        {
            return doExecuteWithSavedResult(progressMonitor, info);
        }
        
        return super.doExecuteWithResult(progressMonitor, info);
    }
    
}
