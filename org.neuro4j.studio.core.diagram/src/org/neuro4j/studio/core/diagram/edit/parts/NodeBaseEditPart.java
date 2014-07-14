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
package org.neuro4j.studio.core.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.diagram.edit.shapes.BaseImageFigure;
import org.neuro4j.studio.core.diagram.markers.MarkerMng;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

public class NodeBaseEditPart extends ShapeNodeEditPart {

    RectangleFigure rec = null;
    ActionNode node = null;
    BaseImageFigure stopFigure;

    public NodeBaseEditPart(View view) {
        super(view);
        node = (ActionNode) view.getElement();
    }

    @Override
    protected NodeFigure createNodeFigure() {
        // TODO Auto-generated method stub
        return null;
    }

    public void refreshToolTip()
    {
        ActionNode actionNode = getActionNode();
        String toolTip = actionNode.buildToolTip();
        if (toolTip != null)
        {
            org.eclipse.draw2d.Label label = (org.eclipse.draw2d.Label) getPrimaryShape().getToolTip();
            if (label != null)
            {
                label.setText(toolTip);
            } else {
                getPrimaryShape().setToolTip(new Label(toolTip));
            }

        }

    }

    @Override
    protected void unregisterVisuals() {
        ActionNode actionNode = getActionNode();
        if (actionNode != null)
        {
            if (MarkerMng.getInstance().isUUIDHasMarket(actionNode))
            {
                MarkerMng.getInstance().removeMarkerInfoForNode(actionNode);
                Neuro4jDiagramEditorPlugin.getInstance().fireRemoveEditPart(this);
            }

        }

        super.unregisterVisuals();
    }

    protected Figure getPrimaryShape() {
        // TODO Auto-generated method stub
        return null;
    }

    protected void addDebugFigure(org.eclipse.draw2d.Panel panel)
    {
        ActionNode actionNode = getActionNode();

        boolean hasDebugmarket = MarkerMng.getInstance().isUUIDHasMarket(actionNode);
        panel.add(getDebugFigure());
        if (hasDebugmarket)
        {

            showDebugElement();
        }
        MarkerMng.getInstance().registerEditPart(actionNode.getId(), this);

    }

    protected void registerStopFigure(BaseImageFigure figure) {
        this.stopFigure = figure;

        ActionNode actionNode = getActionNode();
        String stopUuid = MarkerMng.getInstance().getStopWithUUID();
        if (actionNode.getId().equals(stopUuid)) {
            suspendFigureOnStop();
        }
    }

    private IFigure getDebugFigure()
    {
        rec = new RectangleFigure();
        rec.setBackgroundColor(ColorConstants.lightGreen);
        rec.setBounds(new Rectangle(2, 2, 20, 10));
        rec.setVisible(false);
        return rec;
    }

    public void hideDebugElement() {
        if (rec != null) {
            rec.setVisible(false);
        }

    }

    public void showDebugElement() {
        if (rec != null) {
            rec.setVisible(true);
        }

    }

    public void setConnected()
    {
        rec.setBackgroundColor(ColorConstants.green);
    }

    public void setDisconnected()
    {
        rec.setBackgroundColor(ColorConstants.lightGreen);
    }

    public ActionNode getActionNode()
    {
        return node;
    }

    public void suspendFigureOnStop()
    {
        stopFigure.setBorderColor(ColorConstants.red);
        // stopFigure.setVisible(true);

    }

    public void resumeFigureOnStop()
    {
        stopFigure.setBorderColor(ColorConstants.white);
    }

}
