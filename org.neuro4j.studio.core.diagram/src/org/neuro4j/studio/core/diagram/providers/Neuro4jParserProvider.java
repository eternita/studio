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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeDynamicFlowNameFlowNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeCompKeyOperatorDecisionEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeLabelEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.OperatorOutputNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeNameEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeViewNameDynamicViewNameEditPart;
import org.neuro4j.studio.core.diagram.parsers.MessageFormatParser;
import org.neuro4j.studio.core.diagram.parsers.StartNodeNameParser;
import org.neuro4j.studio.core.diagram.part.Neuro4jVisualIDRegistry;

/**
 * @generated
 */
public class Neuro4jParserProvider extends AbstractProvider implements
        IParserProvider {

    /**
     * @generated
     */
    private IParser decisionNodeCompKeyOperatorDecisionKey_5008Parser;

    /**
     * @generated
     */
    private IParser getDecisionNodeCompKeyOperatorDecisionKey_5008Parser() {
        if (decisionNodeCompKeyOperatorDecisionKey_5008Parser == null) {
            EAttribute[] features = new EAttribute[] {
                    Neuro4jPackage.eINSTANCE.getDecisionNode_CompKey(),
                    Neuro4jPackage.eINSTANCE.getDecisionNode_Operator(),
                    Neuro4jPackage.eINSTANCE.getDecisionNode_DecisionKey() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("({0}  {1}  {2})"); //$NON-NLS-1$
            parser.setEditorPattern("({0}  {1}  {2})"); //$NON-NLS-1$
            parser.setEditPattern("({0}  {1}  {2})"); //$NON-NLS-1$
            decisionNodeCompKeyOperatorDecisionKey_5008Parser = parser;
        }
        return decisionNodeCompKeyOperatorDecisionKey_5008Parser;
    }

    /**
     * @generated
     */
    private IParser followByRelationNodeName_5001Parser;

    /**
     * @generated
     */
    private IParser getFollowByRelationNodeName_5001Parser() {
        if (followByRelationNodeName_5001Parser == null) {
            EAttribute[] features = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            EAttribute[] editableFeatures = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            followByRelationNodeName_5001Parser = parser;
        }
        return followByRelationNodeName_5001Parser;
    }

    /**
     * @generated
     */
    private IParser loopNodeElementKeyIteratorKey_5006Parser;

    /**
     * @generated
     */
    private IParser getLoopNodeElementKeyIteratorKey_5006Parser() {
        if (loopNodeElementKeyIteratorKey_5006Parser == null) {
            EAttribute[] features = new EAttribute[] {
                    Neuro4jPackage.eINSTANCE.getLoopNode_ElementKey(),
                    Neuro4jPackage.eINSTANCE.getLoopNode_IteratorKey() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("for({0} : {1})"); //$NON-NLS-1$
            parser.setEditorPattern("for({0} : {1})"); //$NON-NLS-1$
            parser.setEditPattern("for({0} : {1})"); //$NON-NLS-1$
            loopNodeElementKeyIteratorKey_5006Parser = parser;
        }
        return loopNodeElementKeyIteratorKey_5006Parser;
    }

    /**
     * @generated
     */
    private IParser callNodeDynamicFlowNameFlowName_5007Parser;

    /**
     * @generated
     */
    private IParser getCallNodeDynamicFlowNameFlowName_5007Parser() {
        if (callNodeDynamicFlowNameFlowName_5007Parser == null) {
            EAttribute[] features = new EAttribute[] {
                    Neuro4jPackage.eINSTANCE.getCallNode_DynamicFlowName(),
                    Neuro4jPackage.eINSTANCE.getCallNode_FlowName() };
            MessageFormatParser parser = new MessageFormatParser(features);
            callNodeDynamicFlowNameFlowName_5007Parser = parser;
        }
        return callNodeDynamicFlowNameFlowName_5007Parser;
    }

    /**
     * @generated
     */
    private IParser endNodeName_5002Parser;

    /**
     * @generated
     */
    private IParser getEndNodeName_5002Parser() {
        if (endNodeName_5002Parser == null) {
            EAttribute[] features = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            EAttribute[] editableFeatures = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            endNodeName_5002Parser = parser;
        }
        return endNodeName_5002Parser;
    }

    /**
     * @generated
     */
    private IParser logicNodeName_5005Parser;

    /**
     * @generated
     */
    private IParser getLogicNodeName_5005Parser() {
        if (logicNodeName_5005Parser == null) {
            EAttribute[] features = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            EAttribute[] editableFeatures = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            logicNodeName_5005Parser = parser;
        }
        return logicNodeName_5005Parser;
    }

    /**
     * @generated
     */
    private IParser startNodeName_5003Parser;

    /**
     * @generated
     */
    private IParser getStartNodeName_5003Parser() {
        if (startNodeName_5003Parser == null) {
            EAttribute[] features = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            EAttribute[] editableFeatures = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getActionNode_Name() };
            MessageFormatParser parser = new StartNodeNameParser(features,
                    editableFeatures);
            startNodeName_5003Parser = parser;
        }
        return startNodeName_5003Parser;
    }

    /**
     * @generated
     */
    private IParser viewNodeViewNameDynamicViewName_5004Parser;

    /**
     * @generated
     */
    private IParser getViewNodeViewNameDynamicViewName_5004Parser() {
        if (viewNodeViewNameDynamicViewName_5004Parser == null) {
            EAttribute[] features = new EAttribute[] {
                    Neuro4jPackage.eINSTANCE.getViewNode_ViewName(),
                    Neuro4jPackage.eINSTANCE.getViewNode_DynamicViewName() };
            EAttribute[] editableFeatures = new EAttribute[] {
                    Neuro4jPackage.eINSTANCE.getViewNode_ViewName(),
                    Neuro4jPackage.eINSTANCE.getViewNode_DynamicViewName() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            viewNodeViewNameDynamicViewName_5004Parser = parser;
        }
        return viewNodeViewNameDynamicViewName_5004Parser;
    }

    /**
     * @generated
     */
    private IParser operatorOutputName_6001Parser;

    /**
     * @generated
     */
    private IParser getOperatorOutputName_6001Parser() {
        if (operatorOutputName_6001Parser == null) {
            EAttribute[] features = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getOperatorOutput_Name() };
            EAttribute[] editableFeatures = new EAttribute[] { Neuro4jPackage.eINSTANCE
                    .getOperatorOutput_Name() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            operatorOutputName_6001Parser = parser;
        }
        return operatorOutputName_6001Parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
            case DecisionNodeCompKeyOperatorDecisionEditPart.VISUAL_ID:
                return getDecisionNodeCompKeyOperatorDecisionKey_5008Parser();
            case FollowByRelationNodeNameEditPart.VISUAL_ID:
                return getFollowByRelationNodeName_5001Parser();
            case LoopNodeLabelEditPart.VISUAL_ID:
                return getLoopNodeElementKeyIteratorKey_5006Parser();
            case CallNodeDynamicFlowNameFlowNameEditPart.VISUAL_ID:
                return getCallNodeDynamicFlowNameFlowName_5007Parser();
            case EndNodeNameEditPart.VISUAL_ID:
                return getEndNodeName_5002Parser();
            case LogicNodeNameEditPart.VISUAL_ID:
                return getLogicNodeName_5005Parser();
            case StartNodeNameEditPart.VISUAL_ID:
                return getStartNodeName_5003Parser();
            case ViewNodeViewNameDynamicViewNameEditPart.VISUAL_ID:
                return getViewNodeViewNameDynamicViewName_5004Parser();
            case OperatorOutputNameEditPart.VISUAL_ID:
                return getOperatorOutputName_6001Parser();
        }
        return null;
    }

    /**
     * Utility method that consults ParserService
     * 
     * @generated
     */
    public static IParser getParser(IElementType type, EObject object,
            String parserHint) {
        return ParserService.getInstance().getParser(
                new HintAdapter(type, object, parserHint));
    }

    /**
     * @generated
     */
    public IParser getParser(IAdaptable hint) {
        String vid = (String) hint.getAdapter(String.class);
        if (vid != null) {
            return getParser(Neuro4jVisualIDRegistry.getVisualID(vid));
        }
        View view = (View) hint.getAdapter(View.class);
        if (view != null) {
            return getParser(Neuro4jVisualIDRegistry.getVisualID(view));
        }
        return null;
    }

    /**
     * @generated
     */
    public boolean provides(IOperation operation) {
        if (operation instanceof GetParserOperation) {
            IAdaptable hint = ((GetParserOperation) operation).getHint();
            if (Neuro4jElementTypes.getElement(hint) == null) {
                return false;
            }
            return getParser(hint) != null;
        }
        return false;
    }

    /**
     * @generated
     */
    private static class HintAdapter extends ParserHintAdapter {

        /**
         * @generated
         */
        private final IElementType elementType;

        /**
         * @generated
         */
        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        /**
         * @generated
         */
        public Object getAdapter(Class adapter) {
            if (IElementType.class.equals(adapter)) {
                return elementType;
            }
            return super.getAdapter(adapter);
        }
    }

}
