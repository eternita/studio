/*
 * Copyright (c) 2013-2014, Neuro4j
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

package org.neuro4j.studio.core.format.f4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.neuro4j.studio.core.format.n4j.NetworkXML;
import org.neuro4j.workflow.common.FlowInitializationException;

public class FlowConverter {

	/**
	 * @param network
	 * @return
	 */
	public static String flow2xml(FlowXML network) {
		if (null == network)
			return null;

		NetworkXML net = new NetworkXML(network);

		StringWriter writer = new StringWriter();
		try {
			JAXBContext ctx = JAXBContext.newInstance(FlowXML.class);

			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(net, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		return writer.toString();
	}

	public static void flow2xmlstream(FlowXML network, OutputStream out) {
		if (null == network)
			return;
		try {
			JAXBContext ctx = JAXBContext.newInstance(FlowXML.class);

			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(network, out);
		} catch (JAXBException e) {
			e.printStackTrace();
			return;
		}
		return;
	}

	/**
	 * In case of exception input stream are closed by JAXB
	 * 
	 * @param xml
	 * @return
	 * @throws FlowInitializationException
	 */
	public static FlowXML xml2workflow(InputStream xml, String flow)
			throws  FlowInitializationException {
		if (null == xml)
			return null;

		FlowXML net = null;
		try {
			JAXBContext ctx = JAXBContext.newInstance(FlowXML.class);

			Unmarshaller um = ctx.createUnmarshaller();
			net = (FlowXML) um.unmarshal(xml);
			if (null == net)
				return null;

			//return netXML2net(net, flow);

		} catch (JAXBException e) {
			e.printStackTrace();
			throw new FlowInitializationException("Can't convert stream to workflow");
		}
		
		return net;
	}

	private static String getFlowPackage(String flow) {
		String flowPackage = "default";
		int index = flow.lastIndexOf("/");
		if (index > 0) {
			flowPackage = flow.substring(0, index);
		} else if (flow.contains(".")) {
			flowPackage = flow;
		}
		return flowPackage;
	}


	

	

}
