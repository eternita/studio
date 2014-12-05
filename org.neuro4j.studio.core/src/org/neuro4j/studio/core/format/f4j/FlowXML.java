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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.neuro4j.studio.core.NodeType;

@XmlRootElement(name = "flow")
public class FlowXML {

    @XmlAttribute
    public String visibility;

    private String flowName;
    private String flowPackage;
    
    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node")
    List<NodeXML> nodes = new ArrayList<NodeXML>();

    Map<String, NodeXML> map;
    
    Map<String, NodeXML> names;

    public FlowXML()
    {

    }


    public FlowXML(String flow, String flowPackage) {
        this.flowName = flow;
        this.flowPackage = flowPackage;
	}

	public List<NodeXML> getEntities() {
        return nodes;
    }
	
	public List<NodeXML> getNodesByType(NodeType type) {
		List<NodeXML> list = new ArrayList<NodeXML>();
		for (NodeXML node: nodes)
		{
			if (type.name().equalsIgnoreCase(node.type))
			{
				list.add(node);
			}
		}
        return list;
    }

    public NodeXML getById(String uuid)
    {
        if (map == null)
        {
            map = new HashMap<String, NodeXML>();
            for (NodeXML e : nodes)
            {
                map.put(e.getUuid(), e);
            }
        }

        return map.get(uuid);
    }


    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

	public Collection<NodeXML> getXmlNodes() {
		return nodes;
	}

	public void registerNode(NodeXML entity) {
		nodes.add(entity);		
	}

	public NodeXML getNodeByName(String name) {
        if (names == null)
        {
        	names = new HashMap<String, NodeXML>();
            for (NodeXML e : nodes)
            {
            	names.put(e.getName(), e);
            }
        }

        return names.get(name);
	}


    public String getFlowPackage() {
        return flowPackage;
    }


    public String getFlowName() {
        return flowName;
    }
    
	
	


}
