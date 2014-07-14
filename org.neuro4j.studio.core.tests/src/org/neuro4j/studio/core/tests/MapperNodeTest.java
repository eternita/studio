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
package org.neuro4j.studio.core.tests;

import junit.textui.TestRunner;

import org.neuro4j.studio.core.MapperNode;
import org.neuro4j.studio.core.Neuro4jFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mapper Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MapperNodeTest extends ActionNodeTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(MapperNodeTest.class);
    }

    /**
     * Constructs a new Mapper Node test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public MapperNodeTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Mapper Node test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected MapperNode getFixture() {
        return (MapperNode) fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(Neuro4jFactory.eINSTANCE.createMapperNode());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

} // MapperNodeTest
