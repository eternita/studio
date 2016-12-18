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
package org.neuro4j.studio.core.format.n4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.neuro4j.studio.core.format.f4j.FlowXML;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.format.f4j.TransitionXML;
import org.neuro4j.workflow.common.FlowExecutionException;

public class NetworkConverter {

	public static String network2xml(FlowXML network) {
		if (null == network)
			return null;

		NetworkXML net = new NetworkXML(network);

		StringWriter writer = new StringWriter();
		try {
			JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(net, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		return writer.toString();
	}

	public static void network2xmlstream(FlowXML network, OutputStream out) {
		if (null == network)
			return;

		NetworkXML net = new NetworkXML(network);

		try {
			JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(net, out);
		} catch (JAXBException e) {
			e.printStackTrace();
			return;
		}
		return;
	}

	// /**
	// *
	// * @param xml
	// * @return
	// */
	public static FlowXML xml2network(String xml) throws ConvertationException {
		if (null == xml)
			return null;

		NetworkXML net = null;
		try {
			JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

			Unmarshaller um = ctx.createUnmarshaller();
			net = (NetworkXML) um.unmarshal(new StringReader(xml));
			if (null == net)
				return null;

			return netXML2net(net, "123");

		} catch (JAXBException e) {
			throw new ConvertationException("Can't convert string to network "
					+ xml, e);
		}
	}

	/**
	 * In case of exception input stream are closed by JAXB
	 * 
	 * @param xml
	 * @return
	 */
	public static FlowXML xml2workflow(InputStream xml, String flow)
			throws ConvertationException {
		if (null == xml)
			return null;

		NetworkXML net = null;
		try {
			JAXBContext ctx = JAXBContext.newInstance(NetworkXML.class);

			Unmarshaller um = ctx.createUnmarshaller();
			net = (NetworkXML) um.unmarshal(xml);
			if (null == net)
				return null;

			return netXML2net(net, flow);

		} catch (JAXBException e) {
			throw new ConvertationException("Can't convert stream to workflow",
					e);
		}
	}

	private static String getFlowPackage(String flow) {
		String flowPackage = "default";
		int index = flow.lastIndexOf("/");
		if (index > 0) {
			flowPackage = flow.substring(0, index);
		}
		return flowPackage;
	}

	private static FlowXML netXML2net(NetworkXML net, String flow) {

		FlowXML network = new FlowXML(flow, getFlowPackage(flow));

		for (EntityXML e : net.getEntities()) {

			Map<String, String> parameters = new HashMap<String, String>();

			for (PropertyXML rep : e.getRepresentations())
				if (rep.getValue() != null && !rep.getValue().trim().equals("")) {
					parameters.put(rep.getKey(), rep.getValue());
				}


				NodeXML entity;
				try {
					entity = createNode(network, e, parameters);
					network.registerNode(entity);
				} catch (FlowExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			

		}

		for (NodeXML entity : network.getXmlNodes()) {

			if (null != entity) {
				EntityXML e = net.getById(entity.getUuid());

				for (RelationTailXML rp : e.getRelations()) {
					EntityXML entityXML = net.getById(rp.getUuid());
					if (entityXML == null) {
						continue;
					}
					TransitionXML transition = new TransitionXML();
					transition.setUuid(entityXML.getUuid());
					transition.setName(entityXML.getName());
					transition.setFromNode(entity.getUuid());
					List<PropertyXML> representation = entityXML
							.getRepresentations();
					for (PropertyXML propertyXML : representation) {
						if (SWFConstants.EndUUID.equals(propertyXML.getKey())) {
							String targetUuid = propertyXML.getValue();
							NodeXML toNode = network.getById(targetUuid);
							if (null != toNode)
								transition.setToNode(toNode.getUuid());
							    transition.setTargetNode(toNode);
							entity.registerExit(transition);
						} else if (SWFConstants.POINTS.equals(propertyXML
								.getKey())) {
							String points = propertyXML.getValue();
							if (points != null) {
								transition.setPoints(points);
							}

						}
					}

				}
			}
		}

		return network;
	}

	private static NodeXML createNode(FlowXML workflow, EntityXML e,
			Map<String, String> parameters) throws FlowExecutionException {
		NodeXML node = null;


		if (node == null) {
			node = new NodeXML(e.getUuid(), e.getName());
			Set<String> keys = parameters.keySet();
			for (String key : keys) {

					node.addParameter(key, parameters.get(key), true);
			}
		}

		return node;
	}

}
