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
package org.neuro4j.studio.core.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.neuro4j.studio.core.diagram.providers.Neuro4jElementTypes;

/**
 * @generated
 */
public class Neuro4jPaletteFactory {

    /**
     * @generated NOT
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createConnectorGroup());
        paletteRoot.add(createCore1Group());
        paletteRoot.add(createWebGroup());
    }

    public void fillNmsPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createMnsConnectorGroup());
  //      paletteRoot.add(createCore1NmsGroup());

    }

    /**
     * Creates "core" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createCore1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(
                Messages.Core1Group_title);
        paletteContainer.setSmallIcon(Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID,
                "icons/coreGroup_s.png"));
        paletteContainer.setId("createCore1Group"); //$NON-NLS-1$
        paletteContainer.add(createStartNode5CreationTool());

        paletteContainer.add(createDecisionNode2CreationTool());
        paletteContainer.add(createLoopNode3CreationTool());

        paletteContainer.add(createLogicNode9CreationTool());

        paletteContainer.add(createCallNode4CreationTool());

        paletteContainer.add(createJoinNode1CreationTool());

        paletteContainer.add(createMapperNode7CreationTool());

        paletteContainer.add(createFollowByRelationNode8CreationTool());

        paletteContainer.add(createEndNode6CreationTool());
        paletteContainer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
        return paletteContainer;
    }

    private PaletteContainer createCore1NmsGroup() {
        PaletteDrawer paletteContainer = new PaletteDrawer(
                Messages.NmsEntityGroup_title);
        paletteContainer.setSmallIcon(Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID,
                "icons/coreGroup_s.png"));
        paletteContainer.setId("createCore1Group"); //$NON-NLS-1$

        paletteContainer.add(createStandardNode1CreationTool());
        // paletteContainer.add(createCircleRelationNodeCreationTool());

        paletteContainer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
        return paletteContainer;
    }

    private PaletteContainer createWebGroup() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.WebGroup_title);
        paletteContainer.setSmallIcon(Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID,
                "icons/webGroup_s.png"));
        paletteContainer.setId("createWebGroup"); //$NON-NLS-1$
        paletteContainer.add(createViewNode10CreationTool());
        paletteContainer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
        return paletteContainer;
    }

    private PaletteContainer createConnectorGroup() {
        PaletteGroup paletteContainer = new PaletteGroup(Messages.ConnectorGroup_title);
        paletteContainer.setId("createConnectorGroup"); //$NON-NLS-1$
        paletteContainer.add(createOperatorOutput11CreationTool());

        return paletteContainer;
    }

    private PaletteContainer createMnsConnectorGroup() {
        PaletteGroup paletteContainer = new PaletteGroup(Messages.ConnectorGroup_title);
        paletteContainer.setId("createConnectorGroup"); //$NON-NLS-1$
        paletteContainer.add(createRelationCreationTool());

        return paletteContainer;
    }

    private ToolEntry createJoinNode1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.JoinNode1CreationTool_title,
                Messages.JoinNode1CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.JoinNode_2002));
        entry.setId("createJoinNode1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.JoinNode_2002));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    private ToolEntry createCircleRelationNodeCreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.CircleRelationNode1CreationTool_title,
                Messages.CircleRelationNode1CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.StandardNodeRelation_2020));
        entry.setId("createJoinNode1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jDiagramEditorPlugin.imageDescriptorFromPlugin(Neuro4jDiagramEditorPlugin.ID,
                "icons/images/CircleRelation_s.png"));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    private ToolEntry createStandardNode1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.StandardNode1CreationTool_title,
                Messages.StandardNode1CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.StandardNode_2019));
        entry.setId("createJoinNode1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.JoinNode_2002));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createDecisionNode2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.DecisionNode2CreationTool_title,
                Messages.DecisionNode2CreationTool_desc,
                Collections
                        .singletonList(Neuro4jElementTypes.DecisionNode_2007));
        entry.setId("createDecisionNode2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.DecisionNode_2007));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLoopNode3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.LoopNode3CreationTool_title,
                Messages.LoopNode3CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.LoopNode_2006));
        entry.setId("createLoopNode3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.LoopNode_2006));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCallNode4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.CallNode4CreationTool_title,
                Messages.CallNode4CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.CallNode_2008));
        entry.setId("createCallNode4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.CallNode_2008));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createStartNode5CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.StartNode5CreationTool_title,
                Messages.StartNode5CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.StartNode_2004));
        entry.setId("createStartNode5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.StartNode_2004));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEndNode6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.EndNode6CreationTool_title,
                Messages.EndNode6CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.EndNode_2005));
        entry.setId("createEndNode6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.EndNode_2005));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createMapperNode7CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.MapperNode7CreationTool_title,
                Messages.MapperNode7CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.MapperNode_2010));
        entry.setId("createMapperNode7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.MapperNode_2010));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createFollowByRelationNode8CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.FollowByRelationNode8CreationTool_title,
                Messages.FollowByRelationNode8CreationTool_desc,
                Collections
                        .singletonList(Neuro4jElementTypes.FollowByRelationNode_2011));
        entry.setId("createFollowByRelationNode8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.FollowByRelationNode_2011));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLogicNode9CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.LogicNode9CreationTool_title,
                Messages.LogicNode9CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.LogicNode_2017));
        entry.setId("createLogicNode9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.LogicNode_2017));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createViewNode10CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(
                Messages.ViewNode10CreationTool_title,
                Messages.ViewNode10CreationTool_desc,
                Collections.singletonList(Neuro4jElementTypes.ViewNode_2018));
        entry.setId("createViewNode10CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.ViewNode_2018));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createOperatorOutput11CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.OperatorOutput11CreationTool_title,
                Messages.OperatorOutput11CreationTool_desc,
                Collections
                        .singletonList(Neuro4jElementTypes.OperatorOutput_4008));
        entry.setId("createOperatorOutput11CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.OperatorOutput_4008));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    private ToolEntry createRelationCreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.RelationCreationTool_title,
                Messages.RelationCreationTool_desc,
                Collections
                        .singletonList(Neuro4jElementTypes.OperatorOutput_4008));
        entry.setId("createOperatorOutput11CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(Neuro4jElementTypes
                .getImageDescriptor(Neuro4jElementTypes.OperatorOutput_4008));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    public static class NodeToolEntry extends ToolEntry {

        /**
         * @generated
         */
        private final List<IElementType> elementTypes;

        /**
         * @generated
         */
        private NodeToolEntry(String title, String description,
                List<IElementType> elementTypes) {
            super(title, description, null, null);
            this.elementTypes = elementTypes;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }

    /**
     * @generated
     */
    private static class LinkToolEntry extends ToolEntry {

        /**
         * @generated
         */
        private final List<IElementType> relationshipTypes;

        /**
         * @generated
         */
        private LinkToolEntry(String title, String description,
                List<IElementType> relationshipTypes) {
            super(title, description, null, null);
            this.relationshipTypes = relationshipTypes;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }
}
