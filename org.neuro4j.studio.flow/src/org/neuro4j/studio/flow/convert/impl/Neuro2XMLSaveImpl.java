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
package org.neuro4j.studio.flow.convert.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.format.f4j.FlowConverter;
import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.util.PropetiesConstants;
import org.neuro4j.studio.core.util.UUIDMgr;
import org.neuro4j.studio.flow.convert.ECore2EnfinityConverter;
import org.neuro4j.workflow.enums.FlowVisibility;
import org.w3c.dom.Document;

public class Neuro2XMLSaveImpl extends XMLSaveImpl {

    protected ECore2EnfinityConverter converter = null;
    protected FlowXML network;

    public Neuro2XMLSaveImpl(Map<?, ?> options, XMLHelper helper,
            String encoding) {
        super(options, helper, encoding);
        this.converter = new ECore2EnfinityConverterImpl();
    }

    public Neuro2XMLSaveImpl(XMLHelper createXMLHelper) {
        super(createXMLHelper);
        this.converter = new ECore2EnfinityConverterImpl();
    }

    public void save(XMLResource resource, OutputStream outputStream,
            Map<?, ?> options) throws IOException {

        this.converter.setResource(resource);
        this.xmlResource = resource;
        init(resource, options);
        @SuppressWarnings("unchecked")
        List<? extends EObject> contents = roots = (List<? extends EObject>) options
                .get(XMLResource.OPTION_ROOT_OBJECTS);
        if (contents == null) {
            contents = resource.getContents();
        }

       
        
        if (contents.size() != 0)
        {
            // TODO: we do not need to use it.
            traverse(contents);
            DiagramImpl diagram = (DiagramImpl) contents.get(contents.size() - 1);
            org.neuro4j.studio.core.Network networkImpl = (org.neuro4j.studio.core.Network) diagram.getElement();

            saveNetworkConfiguration(networkImpl);
            saveNotes(diagram);
          
        }

        FlowConverter.flow2xmlstream(network, outputStream);
       
        endSave(contents);
        outputStream.flush();

        this.xmlResource = null;
    }

    private void saveNetworkConfiguration(org.neuro4j.studio.core.Network eNetwork)
    {
    	String visibility = eNetwork.getVisibility();
    	if (visibility == null)
    	{
    		visibility = FlowVisibility.Public.name();
    	}
    	network.setVisibility(visibility);     
    }
    

    private void saveNotes(DiagramImpl diagram)
    {
        List<ShapeImpl> shapes = diagram.getPersistedChildren();
        for (ShapeImpl shape : shapes)
        {
            if ("NOTE".equalsIgnoreCase(shape.getType())) {
                NodeXML note = createNoteEntity(shape);
                network.registerNode(note);
            }
        }

    }

    private NodeXML createNoteEntity(ShapeImpl shape)
    {
    	NodeXML configuration = new NodeXML("note", UUIDMgr.getInstance().createUUIDString(), null);
    	configuration.setType(NodeType.NOTE.toString());
        configuration.setDescription(shape.getDescription());
        this.converter.setCoordinates(configuration, shape);
        BoundsImpl bounds = (BoundsImpl) shape.getLayoutConstraint();
                      
        
        configuration.addConfig(PropetiesConstants.LOCATION_W, bounds.getWidth() + "");
        configuration.addConfig(PropetiesConstants.LOCATION_H, bounds.getHeight() + "");
        return configuration;
    }

    @Override
    protected void endSave(List<? extends EObject> contents) throws IOException {
        super.endSave(contents);

    }

    @Override
    protected void init(XMLResource resource, Map<?, ?> options) {
        // TODO Auto-generated method stub
        super.init(resource, options);
        network = new FlowXML(resource.getURI().lastSegment(), resource.getURI().path());
    }

    @Override
    protected void saveContainedMany(EObject o, EStructuralFeature f) {
        @SuppressWarnings("unchecked")
        List<? extends InternalEObject> values = ((InternalEList<? extends InternalEObject>) helper
                .getValue(o, f)).basicList();
        int size = values.size();

        for (int i = 0; i < size; i++) {
            InternalEObject value = values.get(i);
            if (value != null) {
                // saveElement(value, f);
                if (value instanceof ActionNode) {
                    ActionNode node = (ActionNode) value;

                    ShapeImpl updatedObject = getUpdatedObject(value);

                    NodeXML entity = this.converter.convert(node, updatedObject, network);
                    network.registerNode(entity);

                }
            }
        }
    }

    @Override
    public Document save(XMLResource resource, Document doc, Map<?, ?> options,
            DOMHandler handler) {
        // TODO Auto-generated method stub
        return super.save(resource, doc, options, handler);
    }

    @Override
    protected void saveContainedSingle(EObject o, EStructuralFeature f) {
        // TODO Auto-generated method stub
        super.saveContainedSingle(o, f);
    }

    @Override
    protected void saveEObjectMany(EObject o, EStructuralFeature f) {
        // TODO Auto-generated method stub
        super.saveEObjectMany(o, f);
    }

    private ShapeImpl getUpdatedObject(EObject node)
    {
        Map<String, EObject> updatedValues = this.xmlResource.getIDToEObjectMap();
        Collection<EObject> values = updatedValues.values();
        for (EObject obj : values)
        {
            if (obj instanceof ShapeImpl)
            {
                ShapeImpl shape = (ShapeImpl) obj;

                if (shape.getElement() == null)
                {
                    continue;
                }

                if (shape.getElement().equals(node)) {
                    return shape;
                }
            }
        }
        return null;
    }

}
