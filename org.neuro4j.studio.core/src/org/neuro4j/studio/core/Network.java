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
package org.neuro4j.studio.core;

import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.neuro4j.workflow.common.SWFParametersConstants;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.Network#getRootAction <em>Root Action</em>}</li>
 * <li>{@link org.neuro4j.studio.core.Network#getTitle <em>Title</em>}</li>
 * <li>{@link org.neuro4j.studio.core.Network#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getNetwork()
 * @model extendedMetaData="name='Map' kind='elementOnly'"
 * @generated
 */
public interface Network extends EObject {

    public static final String DEFAULT_NAME = "Network";

    public static final String VISIBILITY_KEY = SWFParametersConstants.NETWORK_VISIBILITY;
    public static final String CONFIG_NODE_CLASS_NAME = "org.neuro4j.workflow.node.NetConfig";
    public static final String NOTE_NODE_CLASS_NAME = "org.neuro4j.workflow.node.Note";

    /**
     * Returns the value of the '<em><b>Root Action</b></em>' containment reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.Node}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Action</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Root Action</em>' containment reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getNetwork_RootAction()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='rootTopics'"
     * @generated
     */
    EList<Node> getRootAction();

    /**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Title</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getNetwork_Title()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='title'"
     * @generated
     */
    String getTitle();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.Network#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
    void setTitle(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getNetwork_Visibility()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getVisibility();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.Network#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(String value);

    int getNodeCount(ActionNode name);

    void addNode(ActionNode node);

    void processNodeCount(ActionNode eObject);

    void addNote(NoteNode node);

    List<NoteNode> getNotes();

    public boolean isValidStartNodeName(String name, Node currentStartNode);

    public NetworkTypesEnum getType();

    public void setType(NetworkTypesEnum type);

    public Properties getConfig();

    public void setConfig(Properties prop);

    // public Storage getStorage();
    // public void setStorage(Storage storage);

    IResource getResource();

    void setResource(IResource resource);

} // Network
