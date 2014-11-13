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
package org.neuro4j.studio.core.util;

import java.util.Collection;

import org.eclipse.core.resources.IResource;

public abstract class CollectionWorkspaceUpdater extends WorkspaceUpdater {

    Collection<?> object = null;

    public CollectionWorkspaceUpdater(Collection<?> list)
    {
        this.object = list;

    }

    public abstract void update(IResource resource, int action);

}
