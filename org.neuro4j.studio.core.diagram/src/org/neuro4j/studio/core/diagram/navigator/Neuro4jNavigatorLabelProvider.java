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
package org.neuro4j.studio.core.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.neuro4j.studio.core.JoinNode;
import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.OperatorInput;
import org.neuro4j.studio.core.OperatorOutput;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeDynamicFlowNameFlowNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeCompKeyOperatorDecisionEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLabelEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.MapperNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.NetworkEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput3EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput4EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput5EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorInputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput10EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput2EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput3EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput4EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput5EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput6EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput7EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput8EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutput9EditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeViewNameDynamicViewNameEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;
import org.neuro4j.studio.core.diagram.providers.Neuro4jParserProvider;

/**
 * @generated
 */
public class Neuro4jNavigatorLabelProvider extends LabelProvider implements
        ICommonLabelProvider, ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        Neuro4jDiagramEditorPlugin
                .getInstance()
                .getImageRegistry()
                .put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        Neuro4jDiagramEditorPlugin
                .getInstance()
                .getImageRegistry()
                .put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    public void updateLabel(ViewerLabel label, TreePath elementPath) {
        Object element = elementPath.getLastSegment();
        if (element instanceof Neuro4jNavigatorItem
                && !isOwnView(((Neuro4jNavigatorItem) element).getView())) {
            return;
        }
        label.setText(getText(element));
        label.setImage(getImage(element));
    }

    /**
     * @generated
     */
    public Image getImage(Object element) {
        if (element instanceof Neuro4jNavigatorGroup) {
            Neuro4jNavigatorGroup group = (Neuro4jNavigatorGroup) element;
            return Neuro4jDiagramEditorPlugin.getInstance().getBundledImage(
                    group.getIcon());
        }

        if (element instanceof Neuro4jNavigatorItem) {
            Neuro4jNavigatorItem navigatorItem = (Neuro4jNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return super.getImage(element);
            }
            return getImage(navigatorItem.getView());
        }

        return super.getImage(element);
    }

    /**
     * @generated
     */
    public Image getImage(View view) {
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?FollowByRelationNode", Neuro4jElementTypes.FollowByRelationNode_2011); //$NON-NLS-1$
            case OperatorInput2EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_3005); //$NON-NLS-1$
            case LogicNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?LogicNode", Neuro4jElementTypes.LogicNode_2017); //$NON-NLS-1$
            case NetworkEditPart.VISUAL_ID:
                return getImage("Navigator?Diagram?http://www.neuro4j.org/neuro2?Network", Neuro4jElementTypes.Network_1000); //$NON-NLS-1$
            case JoinNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?JoinNode", Neuro4jElementTypes.JoinNode_2002); //$NON-NLS-1$
            case StartNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?StartNode", Neuro4jElementTypes.StartNode_2004); //$NON-NLS-1$
            case OperatorOutput7EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3011); //$NON-NLS-1$
            case OperatorOutput2EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3001); //$NON-NLS-1$
            case ViewNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?ViewNode", Neuro4jElementTypes.ViewNode_2018); //$NON-NLS-1$
            case OperatorOutput6EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3010); //$NON-NLS-1$
            case OperatorOutput5EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3004); //$NON-NLS-1$
            case MapperNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?MapperNode", Neuro4jElementTypes.MapperNode_2010); //$NON-NLS-1$
            case OperatorOutputEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_2016); //$NON-NLS-1$
            case CallNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?CallNode", Neuro4jElementTypes.CallNode_2008); //$NON-NLS-1$
            case LoopNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?LoopNode", Neuro4jElementTypes.LoopNode_2006); //$NON-NLS-1$
            case OperatorInput7EditPart.VISUAL_ID:
                return getImage("Navigator?Link?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_4009); //$NON-NLS-1$
            case OperatorInput3EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_3006); //$NON-NLS-1$
            case OperatorOutput10EditPart.VISUAL_ID:
                return getImage("Navigator?Link?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_4008); //$NON-NLS-1$
            case OperatorInput4EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_3007); //$NON-NLS-1$
            case OperatorOutput9EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3013); //$NON-NLS-1$
            case OperatorOutput3EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3002); //$NON-NLS-1$
            case OperatorOutput8EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3012); //$NON-NLS-1$
            case OperatorOutput4EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorOutput", Neuro4jElementTypes.OperatorOutput_3003); //$NON-NLS-1$
            case EndNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?EndNode", Neuro4jElementTypes.EndNode_2005); //$NON-NLS-1$
            case OperatorInput5EditPart.VISUAL_ID:
                return getImage("Navigator?Node?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_3008); //$NON-NLS-1$
            case DecisionNodeEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?DecisionNode", Neuro4jElementTypes.DecisionNode_2007); //$NON-NLS-1$
            case OperatorInputEditPart.VISUAL_ID:
                return getImage("Navigator?TopLevelNode?http://www.neuro4j.org/neuro2?OperatorInput", Neuro4jElementTypes.OperatorInput_2013); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = Neuro4jDiagramEditorPlugin.getInstance()
                .getImageRegistry();
        Image image = imageRegistry.get(key);
        if (image == null && elementType != null
                && Neuro4jElementTypes.isKnownElementType(elementType)) {
            image = Neuro4jElementTypes.getImage(elementType);
            imageRegistry.put(key, image);
        }

        if (image == null) {
            image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
            imageRegistry.put(key, image);
        }
        return image;
    }

    /**
     * @generated
     */
    public String getText(Object element) {
        if (element instanceof Neuro4jNavigatorGroup) {
            Neuro4jNavigatorGroup group = (Neuro4jNavigatorGroup) element;
            return group.getGroupName();
        }

        if (element instanceof Neuro4jNavigatorItem) {
            Neuro4jNavigatorItem navigatorItem = (Neuro4jNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return null;
            }
            return getText(navigatorItem.getView());
        }

        return super.getText(element);
    }

    /**
     * @generated
     */
    public String getText(View view) {
        if (view.getElement() != null && view.getElement().eIsProxy()) {
            return getUnresolvedDomainElementProxyText(view);
        }
        switch (Neuro4jVisualIDRegistry.getVisualID(view)) {
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return getFollowByRelationNode_2011Text(view);
            case OperatorInput2EditPart.VISUAL_ID:
                return getOperatorInput_3005Text(view);
            case LogicNodeEditPart.VISUAL_ID:
                return getLogicNode_2017Text(view);
            case NetworkEditPart.VISUAL_ID:
                return getNetwork_1000Text(view);
            case JoinNodeEditPart.VISUAL_ID:
                return getJoinNode_2002Text(view);
            case StartNodeEditPart.VISUAL_ID:
                return getStartNode_2004Text(view);
            case OperatorOutput7EditPart.VISUAL_ID:
                return getOperatorOutput_3011Text(view);
            case OperatorOutput2EditPart.VISUAL_ID:
                return getOperatorOutput_3001Text(view);
            case ViewNodeEditPart.VISUAL_ID:
                return getViewNode_2018Text(view);
            case OperatorOutput6EditPart.VISUAL_ID:
                return getOperatorOutput_3010Text(view);
            case OperatorOutput5EditPart.VISUAL_ID:
                return getOperatorOutput_3004Text(view);
            case MapperNodeEditPart.VISUAL_ID:
                return getMapperNode_2010Text(view);
            case OperatorOutputEditPart.VISUAL_ID:
                return getOperatorOutput_2016Text(view);
            case CallNodeEditPart.VISUAL_ID:
                return getCallNode_2008Text(view);
            case LoopNodeEditPart.VISUAL_ID:
                return getLoopNode_2006Text(view);
            case OperatorInput7EditPart.VISUAL_ID:
                return getOperatorInput_4009Text(view);
            case OperatorInput3EditPart.VISUAL_ID:
                return getOperatorInput_3006Text(view);
            case OperatorOutput10EditPart.VISUAL_ID:
                return getOperatorOutput_4008Text(view);
            case OperatorInput4EditPart.VISUAL_ID:
                return getOperatorInput_3007Text(view);
            case OperatorOutput9EditPart.VISUAL_ID:
                return getOperatorOutput_3013Text(view);
            case OperatorOutput3EditPart.VISUAL_ID:
                return getOperatorOutput_3002Text(view);
            case OperatorOutput8EditPart.VISUAL_ID:
                return getOperatorOutput_3012Text(view);
            case OperatorOutput4EditPart.VISUAL_ID:
                return getOperatorOutput_3003Text(view);
            case EndNodeEditPart.VISUAL_ID:
                return getEndNode_2005Text(view);
            case OperatorInput5EditPart.VISUAL_ID:
                return getOperatorInput_3008Text(view);
            case DecisionNodeEditPart.VISUAL_ID:
                return getDecisionNode_2007Text(view);
            case OperatorInputEditPart.VISUAL_ID:
                return getOperatorInput_2013Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3001Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3004Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3004); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3012Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3012); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getDecisionNode_2007Text(View view) {
        IParser parser = Neuro4jParserProvider
                .getParser(
                        Neuro4jElementTypes.DecisionNode_2007,
                        view.getElement() != null ? view.getElement() : view,
                        Neuro4jVisualIDRegistry
                                .getType(DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3003Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_3006Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3006); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3010Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3010); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getJoinNode_2002Text(View view) {
        JoinNode domainModelElement = (JoinNode) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getLogicNode_2017Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.LogicNode_2017,
                view.getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry
                        .getType(LogicNodeNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3011Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3011); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getEndNode_2005Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.EndNode_2005,
                view.getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry.getType(EndNodeNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getViewNode_2018Text(View view) {
        IParser parser = Neuro4jParserProvider
                .getParser(
                        Neuro4jElementTypes.ViewNode_2018,
                        view.getElement() != null ? view.getElement() : view,
                        Neuro4jVisualIDRegistry
                                .getType(ViewNodeViewNameDynamicViewNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getStartNode_2004Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.StartNode_2004,
                view.getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry
                        .getType(StartNodeNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getNetwork_1000Text(View view) {
        Network domainModelElement = (Network) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getTitle());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_3007Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_3008Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getLoopNode_2006Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.LoopNode_2006,
                view.getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry
                        .getType(LoopNodeLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_2016Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2016); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_2013Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getMapperNode_2010Text(View view) {
        MapperNode domainModelElement = (MapperNode) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2010); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_4009Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4009); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3013Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_4008Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.OperatorOutput_4008,
                view.getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry
                        .getType(OperatorOutputNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getFollowByRelationNode_2011Text(View view) {
        IParser parser = Neuro4jParserProvider.getParser(
                Neuro4jElementTypes.FollowByRelationNode_2011, view
                        .getElement() != null ? view.getElement() : view,
                Neuro4jVisualIDRegistry
                        .getType(FollowByRelationNodeNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorInput_3005Text(View view) {
        OperatorInput domainModelElement = (OperatorInput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getId());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getOperatorOutput_3002Text(View view) {
        OperatorOutput domainModelElement = (OperatorOutput) view.getElement();
        if (domainModelElement != null) {
            return String.valueOf(domainModelElement.getName());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getCallNode_2008Text(View view) {
        IParser parser = Neuro4jParserProvider
                .getParser(
                        Neuro4jElementTypes.CallNode_2008,
                        view.getElement() != null ? view.getElement() : view,
                        Neuro4jVisualIDRegistry
                                .getType(CallNodeDynamicFlowNameFlowNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(
                    view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            Neuro4jDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getUnknownElementText(View view) {
        return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * @generated
     */
    private String getUnresolvedDomainElementProxyText(View view) {
        return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public String getDescription(Object anElement) {
        return null;
    }

    /**
     * @generated
     */
    private boolean isOwnView(View view) {
        return NetworkEditPart.MODEL_ID.equals(Neuro4jVisualIDRegistry
                .getModelID(view));
    }

}
