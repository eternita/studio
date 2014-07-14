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
package org.neuro4j.studio.core.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.MapperNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput3EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput4EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput5EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput6EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput8EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput9EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Messages;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class Neuro4jModelingAssistantProvider extends ModelingAssistantProvider {

    /**
     * @generated NOT
     */
    public List getTypesForPopupBar(IAdaptable host) {
        IGraphicalEditPart editPart = (IGraphicalEditPart) host
                .getAdapter(IGraphicalEditPart.class);
        if (editPart instanceof NetworkEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            // types.add(Neuro4jElementTypes.DecisionNode_2007);
            // types.add(Neuro4jElementTypes.FollowByRelationNode_2011);
            // types.add(Neuro4jElementTypes.LoopNode_2006);
            // types.add(Neuro4jElementTypes.CallNode_2008);
            // types.add(Neuro4jElementTypes.EndNode_2005);
            // types.add(Neuro4jElementTypes.MapperNode_2010);
            // types.add(Neuro4jElementTypes.OperatorOutput_2016);
            // types.add(Neuro4jElementTypes.LogicNode_2017);
            // types.add(Neuro4jElementTypes.OperatorInput_2013);
            // types.add(Neuro4jElementTypes.JoinNode_2002);
            // types.add(Neuro4jElementTypes.StartNode_2004);
            // types.add(Neuro4jElementTypes.ViewNode_2018);
            return types;
        }
        if (editPart instanceof DecisionNodeEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            // types.add(Neuro4jElementTypes.OperatorInput_3005);
            // types.add(Neuro4jElementTypes.OperatorOutput_3001);
            // types.add(Neuro4jElementTypes.OperatorOutput_3002);
            return types;
        }
        if (editPart instanceof LoopNodeEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            // types.add(Neuro4jElementTypes.OperatorInput_3006);
            // types.add(Neuro4jElementTypes.OperatorInput_3007);
            // types.add(Neuro4jElementTypes.OperatorOutput_3004);
            // types.add(Neuro4jElementTypes.OperatorOutput_3003);
            return types;
        }
        if (editPart instanceof LogicNodeEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(3);
            // types.add(Neuro4jElementTypes.OperatorInput_3008);
            // types.add(Neuro4jElementTypes.OperatorOutput_3010);
            // types.add(Neuro4jElementTypes.OperatorOutput_3011);
            return types;
        }
        if (editPart instanceof JoinNodeEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            // types.add(Neuro4jElementTypes.OperatorOutput_3012);
            return types;
        }
        if (editPart instanceof StartNodeEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            // types.add(Neuro4jElementTypes.OperatorOutput_3013);
            return types;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
                .getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof DecisionNodeEditPart) {
            return ((DecisionNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof FollowByRelationNodeEditPart) {
            return ((FollowByRelationNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof LoopNodeEditPart) {
            return ((LoopNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof CallNodeEditPart) {
            return ((CallNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof EndNodeEditPart) {
            return ((EndNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof MapperNodeEditPart) {
            return ((MapperNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof LogicNodeEditPart) {
            return ((LogicNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof JoinNodeEditPart) {
            return ((JoinNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof StartNodeEditPart) {
            return ((StartNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ViewNodeEditPart) {
            return ((ViewNodeEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnTarget(IAdaptable target) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
                .getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof DecisionNodeEditPart) {
            return ((DecisionNodeEditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof FollowByRelationNodeEditPart) {
            return ((FollowByRelationNodeEditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof LoopNodeEditPart) {
            return ((LoopNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof CallNodeEditPart) {
            return ((CallNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof EndNodeEditPart) {
            return ((EndNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof MapperNodeEditPart) {
            return ((MapperNodeEditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutputEditPart) {
            return ((OperatorOutputEditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof LogicNodeEditPart) {
            return ((LogicNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof JoinNodeEditPart) {
            return ((JoinNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof StartNodeEditPart) {
            return ((StartNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ViewNodeEditPart) {
            return ((ViewNodeEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput2EditPart) {
            return ((OperatorOutput2EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput3EditPart) {
            return ((OperatorOutput3EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput4EditPart) {
            return ((OperatorOutput4EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput5EditPart) {
            return ((OperatorOutput5EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput6EditPart) {
            return ((OperatorOutput6EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput7EditPart) {
            return ((OperatorOutput7EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput8EditPart) {
            return ((OperatorOutput8EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperatorOutput9EditPart) {
            return ((OperatorOutput9EditPart) targetEditPart)
                    .getMARelTypesOnTarget();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source,
            IAdaptable target) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
                .getAdapter(IGraphicalEditPart.class);
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
                .getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof DecisionNodeEditPart) {
            return ((DecisionNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof FollowByRelationNodeEditPart) {
            return ((FollowByRelationNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof LoopNodeEditPart) {
            return ((LoopNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof CallNodeEditPart) {
            return ((CallNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof EndNodeEditPart) {
            return ((EndNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof MapperNodeEditPart) {
            return ((MapperNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof LogicNodeEditPart) {
            return ((LogicNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof JoinNodeEditPart) {
            return ((JoinNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof StartNodeEditPart) {
            return ((StartNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ViewNodeEditPart) {
            return ((ViewNodeEditPart) sourceEditPart)
                    .getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForSource(IAdaptable target,
            IElementType relationshipType) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
                .getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof DecisionNodeEditPart) {
            return ((DecisionNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof FollowByRelationNodeEditPart) {
            return ((FollowByRelationNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof LoopNodeEditPart) {
            return ((LoopNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof CallNodeEditPart) {
            return ((CallNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof EndNodeEditPart) {
            return ((EndNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof MapperNodeEditPart) {
            return ((MapperNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutputEditPart) {
            return ((OperatorOutputEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof LogicNodeEditPart) {
            return ((LogicNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof JoinNodeEditPart) {
            return ((JoinNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof StartNodeEditPart) {
            return ((StartNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ViewNodeEditPart) {
            return ((ViewNodeEditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput2EditPart) {
            return ((OperatorOutput2EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput3EditPart) {
            return ((OperatorOutput3EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput4EditPart) {
            return ((OperatorOutput4EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput5EditPart) {
            return ((OperatorOutput5EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput6EditPart) {
            return ((OperatorOutput6EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput7EditPart) {
            return ((OperatorOutput7EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput8EditPart) {
            return ((OperatorOutput8EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperatorOutput9EditPart) {
            return ((OperatorOutput9EditPart) targetEditPart)
                    .getMATypesForSource(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForTarget(IAdaptable source,
            IElementType relationshipType) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
                .getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof DecisionNodeEditPart) {
            return ((DecisionNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof FollowByRelationNodeEditPart) {
            return ((FollowByRelationNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof LoopNodeEditPart) {
            return ((LoopNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof CallNodeEditPart) {
            return ((CallNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof EndNodeEditPart) {
            return ((EndNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof MapperNodeEditPart) {
            return ((MapperNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof LogicNodeEditPart) {
            return ((LogicNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof JoinNodeEditPart) {
            return ((JoinNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof StartNodeEditPart) {
            return ((StartNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ViewNodeEditPart) {
            return ((ViewNodeEditPart) sourceEditPart)
                    .getMATypesForTarget(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForSource(IAdaptable target,
            IElementType relationshipType) {
        return selectExistingElement(target,
                getTypesForSource(target, relationshipType));
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForTarget(IAdaptable source,
            IElementType relationshipType) {
        return selectExistingElement(source,
                getTypesForTarget(source, relationshipType));
    }

    /**
     * @generated
     */
    protected EObject selectExistingElement(IAdaptable host, Collection types) {
        if (types.isEmpty()) {
            return null;
        }
        IGraphicalEditPart editPart = (IGraphicalEditPart) host
                .getAdapter(IGraphicalEditPart.class);
        if (editPart == null) {
            return null;
        }
        Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
        HashSet<EObject> elements = new HashSet<EObject>();
        for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
                .hasNext();) {
            EObject element = it.next();
            if (isApplicableElement(element, types)) {
                elements.add(element);
            }
        }
        if (elements.isEmpty()) {
            return null;
        }
        return selectElement((EObject[]) elements.toArray(new EObject[elements
                .size()]));
    }

    /**
     * @generated
     */
    protected boolean isApplicableElement(EObject element, Collection types) {
        IElementType type = ElementTypeRegistry.getInstance().getElementType(
                element);
        return types.contains(type);
    }

    /**
     * @generated
     */
    protected EObject selectElement(EObject[] elements) {
        Shell shell = Display.getCurrent().getActiveShell();
        ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
                Neuro4jDiagramEditorPlugin.getInstance()
                        .getItemProvidersAdapterFactory());
        ElementListSelectionDialog dialog = new ElementListSelectionDialog(
                shell, labelProvider);
        dialog.setMessage(Messages.Neuro4jModelingAssistantProviderMessage);
        dialog.setTitle(Messages.Neuro4jModelingAssistantProviderTitle);
        dialog.setMultipleSelection(false);
        dialog.setElements(elements);
        EObject selected = null;
        if (dialog.open() == Window.OK) {
            selected = (EObject) dialog.getFirstResult();
        }
        return selected;
    }
}
