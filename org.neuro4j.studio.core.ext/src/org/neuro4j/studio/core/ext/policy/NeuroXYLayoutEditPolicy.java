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

import java.awt.Point;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.CallNode;
import org.neuro4j.studio.core.DecisionNode;
import org.neuro4j.studio.core.EndNode;
import org.neuro4j.studio.core.FollowByRelationNode;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.LogicNode;
import org.neuro4j.studio.core.LoopNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.StandardNode;
import org.neuro4j.studio.core.StartNode;
import org.neuro4j.studio.core.ViewNode;

public class NeuroXYLayoutEditPolicy extends XYLayoutEditPolicy {

    private static final int CELL_SIZE = 100;

    @Override
    protected Command getCreateCommand(CreateRequest request) {
        CreateViewRequest req = (CreateViewRequest) request;

        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
                .getEditingDomain();

        CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
                editingDomain, DiagramUIMessages.AddCommand_Label);
        Iterator iter = req.getViewDescriptors().iterator();

        final Rectangle BOUNDS = (Rectangle) getConstraintFor(request);

        while (iter.hasNext()) {
            CreateViewRequest.ViewDescriptor viewDescriptor = (CreateViewRequest.ViewDescriptor) iter.next();
            Rectangle rect = getBoundsOffest(req, BOUNDS, viewDescriptor);

            cc.compose(new SetBoundsAndCoordinatesCommand(editingDomain,
                    DiagramUIMessages.SetLocationCommand_Label_Resize,
                    viewDescriptor,
                    rect));
        }

        if (cc.reduce() == null)
            return null;

        return chainGuideAttachmentCommands(request,
                new ICommandProxy(cc.reduce()));
    }


    @Override
    protected Rectangle getBoundsOffest(CreateViewRequest request, Rectangle bounds, CreateViewRequest.ViewDescriptor viewDescriptor) {

        if (viewDescriptor == null || viewDescriptor.getElementAdapter() == null)
        {
            return bounds;
        }
        ActionNode node = (ActionNode) viewDescriptor.getElementAdapter().getAdapter(ActionNode.class);
        if (null != node)
        {
            bounds.setX(node.getX());
            bounds.setY(node.getY());

        } else {
            bounds = alignCoordinate(bounds, viewDescriptor.getSemanticHint());
        }

        return bounds;
    }


    private Rectangle alignCoordinate(Rectangle rectangle, String semanticHint)
    {
        Point d = getDimentionByHint(semanticHint);

        if (d == null)
        {
            return rectangle;
        }
        int x = ((rectangle.x / CELL_SIZE) * CELL_SIZE + d.x);
        int y = (rectangle.y / CELL_SIZE) * CELL_SIZE + d.y;
        rectangle.setX(x);
        rectangle.setY(y);
        return rectangle;
    }

    private Point getDimentionByHint(String semanticHint)
    {

        int i = Integer.parseInt(semanticHint);

        switch (i) {
            case 2004:
                return new Point(StartNode.X_OFFSET, StartNode.Y_OFFSET);

            case 2007:
                return new Point(DecisionNode.X_OFFSET, DecisionNode.Y_OFFSET);

            case 2011:
                return new Point(FollowByRelationNode.X_OFFSET, FollowByRelationNode.Y_OFFSET);

            case 2006:
                return new Point(LoopNode.X_OFFSET, LoopNode.Y_OFFSET);

            case 2008:
                return new Point(CallNode.X_OFFSET, CallNode.Y_OFFSET);

            case 2005:
                return new Point(EndNode.X_OFFSET, EndNode.Y_OFFSET);

            case 2017:
                return new Point(LogicNode.X_OFFSET, LogicNode.Y_OFFSET);

            case 2018:
                return new Point(ViewNode.X_OFFSET, ViewNode.Y_OFFSET);

            case 2019:
                return new Point(StandardNode.X_OFFSET, StandardNode.Y_OFFSET);

            case 2002:
                return new Point(JoinNode.X_OFFSET, JoinNode.Y_OFFSET);

            case 2010:
                return new Point(MapperNode.X_OFFSET, MapperNode.Y_OFFSET);

            default:
                break;
        }

        return null;
    }

}
