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

import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.swt.graphics.Color;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Output</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.OperatorOutput#getSource <em>Source</em>}</li>
 * <li>{@link org.neuro4j.studio.core.OperatorOutput#getName <em>Name</em>}</li>
 * <li>{@link org.neuro4j.studio.core.OperatorOutput#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorOutput()
 * @model
 * @generated
 */
public interface OperatorOutput extends Node {

    // public static final String POINTS_KEY = "points";
    /**
     * Returns the value of the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source</em>' containment reference.
     * @see #setSource(ActionNode)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorOutput_Source()
     * @model containment="true"
     * @generated
     */
    ActionNode getSource();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.OperatorOutput#getSource <em>Source</em>}' containment
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Source</em>' containment reference.
     * @see #getSource()
     * @generated
     */
    void setSource(ActionNode value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorOutput_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.OperatorOutput#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(ActionNode)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getOperatorOutput_Target()
     * @model
     * @generated
     */
    ActionNode getTarget();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.OperatorOutput#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(ActionNode value);

    public void setNameWithoutNotification(String name);

    public void setEdge(Edge edge);

    public Edge getEdge();

    public List<RelativeBendpoint> getCoordinates();

    public void setCoordinates(List<RelativeBendpoint> coordinates);

    public List<KeyValuePair> getProperties();

    public void addProperty(String key, String value);

    void setBGColor(Color gray);

    OperatorOutput cloneForPast(ActionNode target);
    
    Routing getRouting();
    
    void setRouting(Routing routing);

} // OperatorOutput
