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
package org.neuro4j.studio.debug.core.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.debug.ui.BreakpointUtils;
import org.neuro4j.studio.core.ActionNode;
import org.neuro4j.studio.core.util.ClassloaderHelper;

public class MarkerManager {

    public static IResource getBeehiveElementMarkerResource(ActionNode beehiveElement)
    {

        IResource resource = null;
        IType type;
        try {
            type = getIType(beehiveElement);
            if (type != null)
            {
                resource = BreakpointUtils.getBreakpointResource(type);
            }
        } catch (JavaModelException e) {
            e.printStackTrace();
        }

        return resource;
    }

    private static IType getIType(ActionNode beehiveElement) throws JavaModelException {
        IType parentType = ClassloaderHelper.getActiveJavaProject().findType(beehiveElement.getLogicImplementationClassName());
        return parentType;
    }

}
