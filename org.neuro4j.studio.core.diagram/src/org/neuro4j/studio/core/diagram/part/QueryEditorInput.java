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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPersistableElement;

public class QueryEditorInput implements IFileEditorInput, IEditorInput {

    private IEditorInput fileinput = null;

    private String query;

    public QueryEditorInput(IEditorInput fileinput, String query)
    {
        this.fileinput = fileinput;
        this.query = query;
    }

    @Override
    public IStorage getStorage() throws CoreException {
        // TODO Auto-generated method stub
        return ((IFileEditorInput) fileinput).getStorage();
    }

    @Override
    public boolean exists() {
        // TODO Auto-generated method stub
        return fileinput.exists();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        // TODO Auto-generated method stub
        return fileinput.getImageDescriptor();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return fileinput.getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return fileinput.getPersistable();
    }

    @Override
    public String getToolTipText() {
        // TODO Auto-generated method stub
        return fileinput.getToolTipText();
    }

    @Override
    public Object getAdapter(Class arg0) {
        // TODO Auto-generated method stub
        return fileinput.getAdapter(arg0);
    }

    @Override
    public IFile getFile() {
        // TODO Auto-generated method stub
        return ((IFileEditorInput) fileinput).getFile();
    }

    public String getQuery()
    {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public IEditorInput getIEditorInput() {
        return this.fileinput;
    }

}
