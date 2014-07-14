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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.policies.MyGraphicalNodeEditPolicy;
import org.neuro4j.studio.core.diagram.edit.policies.StandardNodeRelationItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.impl.StandardNodeImpl;

public class StandardNodeRelationEditPart extends StandardNodeEditPart {

    public static final int VISUAL_ID = 2020;

    public StandardNodeRelationEditPart(View view) {
        super(view);
    }

    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(
                        Neuro4jVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new StandardNodeRelationItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
                new MyGraphicalNodeEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        // TODO Auto-generated method stub
        super.handleNotificationEvent(notification);
        if (notification.getEventType() == Notification.SET && notification.getFeature() instanceof EAttributeImpl)
        {
            EAttributeImpl att = (EAttributeImpl) notification.getFeature();
            if (att.getName().equals("name"))
            {
                StandardNodeImpl node = (StandardNodeImpl) ((ShapeImpl) getModel()).getElement();
                EList<OperatorOutput> list = node.getOutput();
                for (OperatorOutput oo : list)
                {
                    oo.setName(node.getName());
                }
                EList<OperatorInput> inputs = node.getInput();
                for (OperatorInput in : inputs)
                {
                    ActionNode actionNode = in.getNode();
                    EList<OperatorOutput> oList = actionNode.getOutput();
                    for (OperatorOutput oo : oList)
                    {
                        if (oo.getId().equals(node.getId()))
                        {
                            oo.setName(node.getName());
                        }
                    }

                }

            }

        }
    }

}
