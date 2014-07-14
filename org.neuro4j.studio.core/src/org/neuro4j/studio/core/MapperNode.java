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

import org.eclipse.emf.common.util.EList;
import org.neuro4j.studio.core.util.PropetiesConstants;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapper Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.neuro4j.studio.core.MapperNode#getKeyValue <em>Key Value</em>}</li>
 * <li>{@link org.neuro4j.studio.core.MapperNode#getMainOutput <em>Main Output</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.neuro4j.studio.core.Neuro4jPackage#getMapperNode()
 * @model
 * @generated
 */
public interface MapperNode extends ActionNode {

    public static final int X_OFFSET = 29;

    public static final int Y_OFFSET = 30;

    public static final String NEXT = PropetiesConstants.RELATION_DEFAULT_NAME;

    public static final String KEY_PREFIX = "SWF_PARAM_KEY_";

    public static final String KEY_VALUE_SEPARATOR = ":";

    /**
     * Returns the value of the '<em><b>Key Value</b></em>' reference list.
     * The list contents are of type {@link org.neuro4j.studio.core.KeyValuePair}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key Value</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Key Value</em>' reference list.
     * @see org.neuro4j.studio.core.Neuro4jPackage#getMapperNode_KeyValue()
     * @model
     * @generated
     */
    EList<KeyValuePair> getKeyValue();

    /**
     * Returns the value of the '<em><b>Main Output</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main Output</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Main Output</em>' reference.
     * @see #setMainOutput(OperatorOutput)
     * @see org.neuro4j.studio.core.Neuro4jPackage#getMapperNode_MainOutput()
     * @model
     * @generated
     */
    OperatorOutput getMainOutput();

    /**
     * Sets the value of the '{@link org.neuro4j.studio.core.MapperNode#getMainOutput <em>Main Output</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *        the new value of the '<em>Main Output</em>' reference.
     * @see #getMainOutput()
     * @generated
     */
    void setMainOutput(OperatorOutput value);

} // MapperNode
