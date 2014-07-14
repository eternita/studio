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
package org.neuro4j.studio.core.diagram.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.commands.SetConnectionRelationAnchorsCommand;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MyCreateConnectionViewRequest;
import org.neuro4j.studio.core.diagram.edit.shapes.anchors.MySetConnectionBendpointsCommand;

public class MyGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

    @Override
    protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
        if (!(request instanceof CreateConnectionViewRequest))
            return null;
        CreateConnectionViewRequest req = (CreateConnectionViewRequest) request;
        CompositeCommand cc = new CompositeCommand(
                DiagramUIMessages.Commands_CreateCommand_Connection_Label);
        Diagram diagramView = ((View) getHost().getModel())
                .getDiagram();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        CreateCommand createCommand = new CreateCommand(editingDomain, req
                .getConnectionViewDescriptor(), diagramView.getDiagram());
        setViewAdapter((IAdaptable) createCommand.getCommandResult()
                .getReturnValue());

        SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
        sceCommand.setEdgeAdaptor(getViewAdapter());
        sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
        ConnectionAnchor sourceAnchor = getConnectableEditPart()
                .getSourceConnectionAnchor(request);
        SetConnectionRelationAnchorsCommand scaCommand = new SetConnectionRelationAnchorsCommand(editingDomain, StringStatics.BLANK);
        scaCommand.setEdgeAdaptor(getViewAdapter());
        scaCommand.setNewSourceTerminal(getConnectableEditPart()
                .mapConnectionAnchorToTerminal(sourceAnchor));

        MySetConnectionBendpointsCommand sbbCommand = new MySetConnectionBendpointsCommand(editingDomain);
        sbbCommand.setEdgeAdapter(getViewAdapter());

        // getCreateBendpointCommand(request)

        cc.compose(createCommand);
        cc.compose(sceCommand);
        cc.compose(scaCommand);
        cc.compose(sbbCommand);
        Command c = new ICommandProxy(cc);
        request.setStartCommand(c);
        return c;
    }

    @Override
    protected Command getConnectionCompleteCommand(
            CreateConnectionRequest request) {
        ICommandProxy proxy = (ICommandProxy) request
                .getStartCommand();
        if (proxy == null) {
            return null;
        }

        // reset the target edit-part for the request
        INodeEditPart targetEP = getConnectionCompleteEditPart(request);
        if (targetEP == null) {
            return null;
        }

        CreateConnectionViewRequest mrequest = (CreateConnectionViewRequest) request;

        CompositeCommand cc = (CompositeCommand) proxy.getICommand();
        ConnectionAnchor targetAnchor = targetEP
                .getTargetConnectionAnchor(request);
        Iterator commandItr = cc.iterator();
        commandItr.next(); // 0
        SetConnectionEndsCommand sceCommand = (SetConnectionEndsCommand) commandItr.next(); // 1
        sceCommand.setNewTargetAdaptor(new EObjectAdapter(((IGraphicalEditPart) targetEP).getNotationView()));
        SetConnectionAnchorsCommand scaCommand = (SetConnectionAnchorsCommand) commandItr.next(); // 2
        scaCommand.setNewTargetTerminal(targetEP
                .mapConnectionAnchorToTerminal(targetAnchor));
        setViewAdapter(sceCommand.getEdgeAdaptor());
        INodeEditPart sourceEditPart = (INodeEditPart) request
                .getSourceEditPart();
        ConnectionAnchor sourceAnchor = sourceEditPart
                .mapTerminalToConnectionAnchor(scaCommand.getNewSourceTerminal());

        OperatorOutput operator = null;
        List<RelativeBendpoint> coordinates = Collections.EMPTY_LIST;

        PointList pointList = new PointList();
        if (request.getLocation() == null) {

            if (mrequest instanceof MyCreateConnectionViewRequest)
            {
                operator = ((MyCreateConnectionViewRequest) request).getOperator();
                coordinates = operator.getCoordinates();
            }

            if (coordinates != null && coordinates.size() > 1)
            {
                MySetConnectionBendpointsCommand sbbCommand = (MySetConnectionBendpointsCommand) commandItr.next(); // 3
                sbbCommand.setNewPointList(coordinates, sourceAnchor.getReferencePoint(),
                        targetAnchor.getReferencePoint());
            } else {
                pointList.addPoint(sourceAnchor.getLocation(targetAnchor.getReferencePoint()));
                pointList.addPoint(targetAnchor.getLocation(sourceAnchor.getReferencePoint()));
                MySetConnectionBendpointsCommand sbbCommand = (MySetConnectionBendpointsCommand) commandItr.next(); // 3
                sbbCommand.setNewPointList(pointList, sourceAnchor.getReferencePoint(),
                        targetAnchor.getReferencePoint());
            }

        }
        else {
            pointList.addPoint(sourceAnchor.getLocation(request.getLocation()));
            pointList.addPoint(targetAnchor.getLocation(request.getLocation()));
            MySetConnectionBendpointsCommand sbbCommand = (MySetConnectionBendpointsCommand) commandItr.next(); // 3
            sbbCommand.setNewPointList(pointList, sourceAnchor.getReferencePoint(),
                    targetAnchor.getReferencePoint());
        }

        return request.getStartCommand();
    }

    private TransactionalEditingDomain getEditingDomain() {
        return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }

    public Command getCommand(Request request)
    {
        Command command = super.getCommand(request);
        return command;
    }

}
