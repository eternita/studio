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

import java.util.Iterator;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

public class MyConnectionGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

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
        PointList pointList = new PointList();
        if (request.getLocation() == null) {
            pointList.addPoint(sourceAnchor.getLocation(targetAnchor.getReferencePoint()));
            pointList.addPoint(targetAnchor.getLocation(sourceAnchor.getReferencePoint()));
        }
        else {
            pointList.addPoint(sourceAnchor.getLocation(request.getLocation()));
            pointList.addPoint(targetAnchor.getLocation(request.getLocation()));
        }
        SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand) commandItr.next(); // 3
        sbbCommand.setNewPointList(pointList, sourceAnchor.getReferencePoint(),
                targetAnchor.getReferencePoint());
        return request.getStartCommand();
    }

    protected Command getConnectionAndRelationshipCompleteCommand(
            CreateConnectionViewAndElementRequest request) {
        // get the element descriptor
        CreateElementRequestAdapter requestAdapter = request
                .getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
        // get the semantic request
        CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter
                .getAdapter(CreateRelationshipRequest.class);

        createElementRequest.setPrompt(!request.isUISupressed());

        // complete the semantic request by filling in the source and
        // destination
        INodeEditPart targetEP = getConnectionCompleteEditPart(request);
        View sourceView = (View) request.getSourceEditPart().getModel();
        View targetView = (View) targetEP.getModel();

        // resolve the source
        EObject source = ViewUtil.resolveSemanticElement(sourceView);
        if (source == null) {
            source = sourceView;
        }
        createElementRequest.setSource(source);

        // resolve the target
        EObject target = ViewUtil.resolveSemanticElement(targetView);
        if (target == null) {
            target = targetView;
        }
        createElementRequest.setTarget(target);

        // get the create element request based on the elementdescriptor's
        // request

        CreateRelationshipRequest createRelationshipRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
        createRelationshipRequest.getParameters().put("location", request.getLocation());
        Command createElementCommand = targetEP
                .getCommand(new EditCommandRequestWrapper(createRelationshipRequest, request.getExtendedData()));

        // create the create semantic element wrapper command
        if (null == createElementCommand)
            return null;

        SemanticCreateCommand semanticCommand = new SemanticCreateCommand(
                requestAdapter, createElementCommand);
        // get the view command
        Command viewCommand = getConnectionCompleteCommand(request);
        if (null == viewCommand)
            return null;
        // form the compound command and return
        CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
        cc.compose(semanticCommand);
        cc.compose(new CommandProxy(viewCommand));
        return new ICommandProxy(cc);
    }

}
