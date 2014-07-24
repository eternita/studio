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
package org.neuro4j.studio.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.neuro4j.studio.core.Network;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.NodeType;
import org.neuro4j.studio.core.NoteNode;
import org.neuro4j.studio.core.format.f4j.NodeXML;
import org.neuro4j.studio.core.util.PropetiesConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Note Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class NoteNodeImpl extends ActionNodeImpl implements NoteNode {

    protected static final String NAME_EDEFAULT = "NoteNode";

    int width = -1;
    int height = -1;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NoteNodeImpl() {
        super();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int w) {
        this.width = w;

    }

    @Override
    public void setHeight(int h) {
        this.height = h;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Neuro4jPackage.Literals.NOTE_NODE;
    }

    @Override
    public String getLogicImplementationClassName() {
        return Network.NOTE_NODE_CLASS_NAME;
    }

    @Override
    public String getDefaultName() {
        // TODO Auto-generated method stub
        return NAME_EDEFAULT;
    }

    @Override
    public void getNodeSpecificProperties(NodeXML entity) {
        String locationW = entity.getConfig(PropetiesConstants.LOCATION_W);
        if (locationW != null)
        {
            int w = Integer.parseInt(locationW);
            setWidth(w);
        }

        String locationH = entity.getConfig(PropetiesConstants.LOCATION_H);
        if (locationH != null)
        {
            int h = Integer.parseInt(locationH);
            setHeight(h);
        }
        setDescription(entity.description);
    }

    @Override
    public void setNodeSpecificProperties(NodeXML entity) {
        setNotNullConfig(entity, DESCRIPTION, getDescription());

    }
    
	@Override
	public NodeType getNodeType() {
		return NodeType.NOTE;
	}

} // NoteNodeImpl
