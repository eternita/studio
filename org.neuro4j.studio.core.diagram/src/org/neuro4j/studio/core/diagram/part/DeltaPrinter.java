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
package org.neuro4j.studio.core.diagram.part;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.neuro4j.studio.core.util.WorkspaceUpdateObserver;

public class DeltaPrinter implements IResourceDeltaVisitor {

    // List<ViewNodeRenderEngineDefinition> renders;
    WorkspaceUpdateObserver observer;

    public DeltaPrinter(WorkspaceUpdateObserver observer) {
        this.observer = observer;
    }

    public boolean visit(IResourceDelta delta) {
        switch (delta.getKind()) {
            case IResourceDelta.ADDED:
                break;
            case IResourceDelta.REMOVED:
                break;
            case IResourceDelta.CHANGED:
                if (delta.getFullPath().toString().endsWith(".classpath") || delta.getFullPath().toString().endsWith("pom.xml"))
                {
                    // this.renders.clear();
                    observer.update();
                    System.out.println("this.renders.clear()");
                }
                break;
        }
        return true; // visit the children
    }
}