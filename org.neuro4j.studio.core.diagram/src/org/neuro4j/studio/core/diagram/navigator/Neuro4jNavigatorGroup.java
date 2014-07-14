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
package org.neuro4j.studio.core.diagram.navigator;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @generated
 */
public class Neuro4jNavigatorGroup extends Neuro4jAbstractNavigatorItem {

    /**
     * @generated
     */
    private String myGroupName;

    /**
     * @generated
     */
    private String myIcon;

    /**
     * @generated
     */
    private Collection myChildren = new LinkedList();

    /**
     * @generated
     */
    Neuro4jNavigatorGroup(String groupName, String icon, Object parent) {
        super(parent);
        myGroupName = groupName;
        myIcon = icon;
    }

    /**
     * @generated
     */
    public String getGroupName() {
        return myGroupName;
    }

    /**
     * @generated
     */
    public String getIcon() {
        return myIcon;
    }

    /**
     * @generated
     */
    public Object[] getChildren() {
        return myChildren.toArray();
    }

    /**
     * @generated
     */
    public void addChildren(Collection children) {
        myChildren.addAll(children);
    }

    /**
     * @generated
     */
    public void addChild(Object child) {
        myChildren.add(child);
    }

    /**
     * @generated
     */
    public boolean isEmpty() {
        return myChildren.size() == 0;
    }

    /**
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof org.neuro4j.studio.core.diagram.navigator.Neuro4jNavigatorGroup) {
            org.neuro4j.studio.core.diagram.navigator.Neuro4jNavigatorGroup anotherGroup = (org.neuro4j.studio.core.diagram.navigator.Neuro4jNavigatorGroup) obj;
            if (getGroupName().equals(anotherGroup.getGroupName())) {
                return getParent().equals(anotherGroup.getParent());
            }
        }
        return super.equals(obj);
    }

    /**
     * @generated
     */
    public int hashCode() {
        return getGroupName().hashCode();
    }

}
