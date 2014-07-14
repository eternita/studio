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
package org.neuro4j.studio.debug.ui.views;

import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextProvider;
import org.eclipse.jface.viewers.ISelection;

public class DebugContextEventAdapter extends DebugContextEvent {

    public DebugContextEventAdapter(IDebugContextProvider source,
            ISelection context, int flags) {
        super(source, context, flags);

    }

    @Override
    public ISelection getContext() {
        // TODO Auto-generated method stub
        return super.getContext();
    }

    @Override
    public int getFlags() {
        // TODO Auto-generated method stub
        return super.getFlags();
    }

    @Override
    public IDebugContextProvider getDebugContextProvider() {
        // TODO Auto-generated method stub
        return super.getDebugContextProvider();
    }

    @Override
    public Object getSource() {
        // TODO Auto-generated method stub
        return super.getSource();
    }

}
