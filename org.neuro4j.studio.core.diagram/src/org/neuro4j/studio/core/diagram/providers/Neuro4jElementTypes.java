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

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.diagram.edit.parts.CallNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.DecisionNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.EndNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.FollowByRelationNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.JoinNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LogicNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.LoopNodeEditPart;
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
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StandardNodeRelationEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.StartNodeEditPart;
import org.neuro4j.studio.core.diagram.edit.parts.ViewNodeEditPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;

/**
 * @generated
 */
public class Neuro4jElementTypes {

    /**
     * @generated
     */
    private Neuro4jElementTypes() {
    }

    /**
     * @generated
     */
    private static Map<IElementType, ENamedElement> elements;
    /**
     * @generated
     */
    private static ImageRegistry imageRegistry;

    /**
     * @generated
     */
    private static Set<IElementType> KNOWN_ELEMENT_TYPES;
    /**
     * @generated
     */
    public static final IElementType Network_1000 = getElementType("org.neuro4j.studio.core.diagram.Network_1000"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType MapperNode_2010 = getElementType("org.neuro4j.studio.core.diagram.MapperNode_2010"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_2016 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_2016"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType LogicNode_2017 = getElementType("org.neuro4j.studio.core.diagram.LogicNode_2017"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType EndNode_2005 = getElementType("org.neuro4j.studio.core.diagram.EndNode_2005"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType CallNode_2008 = getElementType("org.neuro4j.studio.core.diagram.CallNode_2008"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType JoinNode_2002 = getElementType("org.neuro4j.studio.core.diagram.JoinNode_2002"); //$NON-NLS-1$

    public static final IElementType StandardNode_2019 = getElementType("org.neuro4j.studio.core.diagram.StandardNode_2019"); //$NON-NLS-1$
    public static final IElementType StandardNodeRelation_2020 = getElementType("org.neuro4j.studio.core.diagram.StandardNodeRelation_2020"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType FollowByRelationNode_2011 = getElementType("org.neuro4j.studio.core.diagram.FollowByRelationNode_2011"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType LoopNode_2006 = getElementType("org.neuro4j.studio.core.diagram.LoopNode_2006"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_2013 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_2013"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType StartNode_2004 = getElementType("org.neuro4j.studio.core.diagram.StartNode_2004"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType ViewNode_2018 = getElementType("org.neuro4j.studio.core.diagram.ViewNode_2018"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_3005 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_3005"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3001 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3001"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3002 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3002"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_3006 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_3006"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_3007 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_3007"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3003 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3003"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3004 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3004"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_3008 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_3008"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3010 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3010"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3011 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3011"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3012 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3012"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_3013 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_3013"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorInput_4009 = getElementType("org.neuro4j.studio.core.diagram.OperatorInput_4009"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType OperatorOutput_4008 = getElementType("org.neuro4j.studio.core.diagram.OperatorOutput_4008"); //$NON-NLS-1$
    /**
     * @generated
     */
    public static final IElementType DecisionNode_2007 = getElementType("org.neuro4j.studio.core.diagram.DecisionNode_2007"); //$NON-NLS-1$

    /**
     * @generated
     */
    private static ImageRegistry getImageRegistry() {
        if (imageRegistry == null) {
            imageRegistry = new ImageRegistry();
        }
        return imageRegistry;
    }

    /**
     * @generated
     */
    private static String getImageRegistryKey(ENamedElement element) {
        return element.getName();
    }

    /**
     * @generated
     */
    private static ImageDescriptor getProvidedImageDescriptor(
            ENamedElement element) {
        if (element instanceof EStructuralFeature) {
            EStructuralFeature feature = ((EStructuralFeature) element);
            EClass eContainingClass = feature.getEContainingClass();
            EClassifier eType = feature.getEType();
            if (eContainingClass != null && !eContainingClass.isAbstract()) {
                element = eContainingClass;
            } else if (eType instanceof EClass
                    && !((EClass) eType).isAbstract()) {
                element = eType;
            }
        }
        if (element instanceof EClass) {
            EClass eClass = (EClass) element;
            if (!eClass.isAbstract()) {
                return Neuro4jDiagramEditorPlugin.getInstance()
                        .getItemImageDescriptor(
                                eClass.getEPackage().getEFactoryInstance()
                                        .create(eClass));
            }
        }
        // TODO : support structural features
        return null;
    }

    /**
     * @generated
     */
    public static ImageDescriptor getImageDescriptor(ENamedElement element) {
        String key = getImageRegistryKey(element);
        ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
        if (imageDescriptor == null) {
            imageDescriptor = getProvidedImageDescriptor(element);
            if (imageDescriptor == null) {
                imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
            }
            getImageRegistry().put(key, imageDescriptor);
        }
        return imageDescriptor;
    }

    /**
     * @generated
     */
    public static Image getImage(ENamedElement element) {
        String key = getImageRegistryKey(element);
        Image image = getImageRegistry().get(key);
        if (image == null) {
            ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
            if (imageDescriptor == null) {
                imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
            }
            getImageRegistry().put(key, imageDescriptor);
            image = getImageRegistry().get(key);
        }
        return image;
    }

    /**
     * @generated
     */
    public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
        ENamedElement element = getElement(hint);
        if (element == null) {
            return null;
        }
        return getImageDescriptor(element);
    }

    /**
     * @generated
     */
    public static Image getImage(IAdaptable hint) {
        ENamedElement element = getElement(hint);
        if (element == null) {
            return null;
        }
        return getImage(element);
    }

    /**
     * Returns 'type' of the ecore object associated with the hint.
     * 
     * @generated
     */
    public static ENamedElement getElement(IAdaptable hint) {
        Object type = hint.getAdapter(IElementType.class);
        if (elements == null) {
            elements = new IdentityHashMap<IElementType, ENamedElement>();

            elements.put(Network_1000, Neuro4jPackage.eINSTANCE.getNetwork());

            elements.put(DecisionNode_2007,
                    Neuro4jPackage.eINSTANCE.getDecisionNode());

            elements.put(FollowByRelationNode_2011,
                    Neuro4jPackage.eINSTANCE.getFollowByRelationNode());

            elements.put(LoopNode_2006, Neuro4jPackage.eINSTANCE.getLoopNode());

            elements.put(CallNode_2008, Neuro4jPackage.eINSTANCE.getCallNode());

            elements.put(EndNode_2005, Neuro4jPackage.eINSTANCE.getEndNode());

            elements.put(MapperNode_2010,
                    Neuro4jPackage.eINSTANCE.getMapperNode());

            elements.put(OperatorOutput_2016,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(LogicNode_2017,
                    Neuro4jPackage.eINSTANCE.getLogicNode());

            elements.put(OperatorInput_2013,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(JoinNode_2002, Neuro4jPackage.eINSTANCE.getJoinNode());
            elements.put(StandardNode_2019, Neuro4jPackage.eINSTANCE.getStandardNode());
            elements.put(StandardNodeRelation_2020, Neuro4jPackage.eINSTANCE.getStandardNode());
            elements.put(StartNode_2004,
                    Neuro4jPackage.eINSTANCE.getStartNode());

            elements.put(ViewNode_2018, Neuro4jPackage.eINSTANCE.getViewNode());

            elements.put(OperatorInput_3005,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(OperatorOutput_3001,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorOutput_3002,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorInput_3006,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(OperatorInput_3007,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(OperatorOutput_3003,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorOutput_3004,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorInput_3008,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(OperatorOutput_3010,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorOutput_3011,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorOutput_3012,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorOutput_3013,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());

            elements.put(OperatorInput_4009,
                    Neuro4jPackage.eINSTANCE.getOperatorInput());

            elements.put(OperatorOutput_4008,
                    Neuro4jPackage.eINSTANCE.getOperatorOutput());
        }
        return (ENamedElement) elements.get(type);
    }

    /**
     * @generated
     */
    private static IElementType getElementType(String id) {
        return ElementTypeRegistry.getInstance().getType(id);
    }

    /**
     * @generated NOT
     */
    public static boolean isKnownElementType(IElementType elementType) {
        if (KNOWN_ELEMENT_TYPES == null) {
            KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
            KNOWN_ELEMENT_TYPES.add(Network_1000);
            KNOWN_ELEMENT_TYPES.add(DecisionNode_2007);
            KNOWN_ELEMENT_TYPES.add(FollowByRelationNode_2011);
            KNOWN_ELEMENT_TYPES.add(LoopNode_2006);
            KNOWN_ELEMENT_TYPES.add(CallNode_2008);
            KNOWN_ELEMENT_TYPES.add(EndNode_2005);
            KNOWN_ELEMENT_TYPES.add(MapperNode_2010);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_2016);
            KNOWN_ELEMENT_TYPES.add(LogicNode_2017);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_2013);
            KNOWN_ELEMENT_TYPES.add(JoinNode_2002);
            KNOWN_ELEMENT_TYPES.add(StandardNode_2019);
            KNOWN_ELEMENT_TYPES.add(StandardNodeRelation_2020);
            KNOWN_ELEMENT_TYPES.add(StartNode_2004);
            KNOWN_ELEMENT_TYPES.add(ViewNode_2018);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_3005);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3001);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3002);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_3006);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_3007);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3003);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3004);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_3008);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3010);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3011);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3012);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_3013);
            KNOWN_ELEMENT_TYPES.add(OperatorInput_4009);
            KNOWN_ELEMENT_TYPES.add(OperatorOutput_4008);
        }
        return KNOWN_ELEMENT_TYPES.contains(elementType);
    }

    /**
     * @generated NOT
     */
    public static IElementType getElementType(int visualID) {
        switch (visualID) {
            case NetworkEditPart.VISUAL_ID:
                return Network_1000;
            case DecisionNodeEditPart.VISUAL_ID:
                return DecisionNode_2007;
            case FollowByRelationNodeEditPart.VISUAL_ID:
                return FollowByRelationNode_2011;
            case LoopNodeEditPart.VISUAL_ID:
                return LoopNode_2006;
            case CallNodeEditPart.VISUAL_ID:
                return CallNode_2008;
            case EndNodeEditPart.VISUAL_ID:
                return EndNode_2005;
            case MapperNodeEditPart.VISUAL_ID:
                return MapperNode_2010;
            case OperatorOutputEditPart.VISUAL_ID:
                return OperatorOutput_2016;
            case LogicNodeEditPart.VISUAL_ID:
                return LogicNode_2017;
            case OperatorInputEditPart.VISUAL_ID:
                return OperatorInput_2013;
            case JoinNodeEditPart.VISUAL_ID:
                return JoinNode_2002;
            case StandardNodeEditPart.VISUAL_ID:
                return StandardNode_2019;
            case StandardNodeRelationEditPart.VISUAL_ID:
                return StandardNodeRelation_2020;
            case StartNodeEditPart.VISUAL_ID:
                return StartNode_2004;
            case ViewNodeEditPart.VISUAL_ID:
                return ViewNode_2018;
            case OperatorInput2EditPart.VISUAL_ID:
                return OperatorInput_3005;
            case OperatorOutput2EditPart.VISUAL_ID:
                return OperatorOutput_3001;
            case OperatorOutput3EditPart.VISUAL_ID:
                return OperatorOutput_3002;
            case OperatorInput3EditPart.VISUAL_ID:
                return OperatorInput_3006;
            case OperatorInput4EditPart.VISUAL_ID:
                return OperatorInput_3007;
            case OperatorOutput4EditPart.VISUAL_ID:
                return OperatorOutput_3003;
            case OperatorOutput5EditPart.VISUAL_ID:
                return OperatorOutput_3004;
            case OperatorInput5EditPart.VISUAL_ID:
                return OperatorInput_3008;
            case OperatorOutput6EditPart.VISUAL_ID:
                return OperatorOutput_3010;
            case OperatorOutput7EditPart.VISUAL_ID:
                return OperatorOutput_3011;
            case OperatorOutput8EditPart.VISUAL_ID:
                return OperatorOutput_3012;
            case OperatorOutput9EditPart.VISUAL_ID:
                return OperatorOutput_3013;
            case OperatorInput7EditPart.VISUAL_ID:
                return OperatorInput_4009;
            case OperatorOutput10EditPart.VISUAL_ID:
                return OperatorOutput_4008;
        }
        return null;
    }

}
