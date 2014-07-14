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
package org.neuro4j.studio.debug.ui.views.breakpoints;

import org.eclipse.debug.internal.ui.views.DebugModelPresentationContext;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class FlowDebugModelPresentationContext extends DebugModelPresentationContext {

    public FlowDebugModelPresentationContext(String id, IWorkbenchPart part,
            IDebugModelPresentation presentation) {
        super(id, part, presentation);

    }

    public void initProperties(IMemento memento)
    {
        IMemento presentationMemento = null;

        IMemento[] mementos = memento.getChildren("PRESENTATION_CONTEXT_PROPERTIES");
        for (int i = 0; i < mementos.length; i++) {
            if (getId().equals(mementos[i].getID())) {
                presentationMemento = mementos[i];
                break;
            }
        }

        if (presentationMemento != null) {
            IMemento[] stringProperties = presentationMemento.getChildren("STRING");
            for (int i = 0; i < stringProperties.length; i++) {
                setProperty(stringProperties[i].getID(), stringProperties[i].getString("STRING"));
            }

            IMemento[] integerMementos = presentationMemento.getChildren("INTEGER");
            for (int i = 0; i < integerMementos.length; i++) {
                setProperty(integerMementos[i].getID(), integerMementos[i].getInteger("INTEGER"));
            }

            IMemento[] booleanMementos = presentationMemento.getChildren("BOOLEAN");
            for (int i = 0; i < booleanMementos.length; i++) {
                setProperty(booleanMementos[i].getID(), booleanMementos[i].getBoolean("BOOLEAN"));
            }

            IMemento[] persistableMementos = presentationMemento.getChildren("PERSISTABLE");
            for (int i = 0; i < persistableMementos.length; i++) {
                String factoryID = persistableMementos[i].getString("PERSISTABLE");
                if (factoryID != null) {
                    IElementFactory factory = PlatformUI.getWorkbench().getElementFactory(factoryID);
                    if (factory != null) {
                        Object element = factory.createElement(persistableMementos[i]);
                        if (element != null)
                            setProperty(persistableMementos[i].getID(), element);
                    }
                }
            }
        }
    }

    @Override
    public IDebugModelPresentation getModelPresentation() {
        // TODO Auto-generated method stub
        return super.getModelPresentation();
    }

    @Override
    public void addPropertyChangeListener(IPropertyChangeListener listener) {
        // TODO Auto-generated method stub
        super.addPropertyChangeListener(listener);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
    }

    @Override
    protected void firePropertyChange(String property, Object oldValue,
            Object newValue) {
        // TODO Auto-generated method stub
        super.firePropertyChange(property, oldValue, newValue);
    }

    @Override
    public String[] getColumns() {
        // TODO Auto-generated method stub
        return super.getColumns();
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public IWorkbenchPart getPart() {
        // TODO Auto-generated method stub
        return super.getPart();
    }

    @Override
    public String[] getProperties() {
        // TODO Auto-generated method stub
        return super.getProperties();
    }

    @Override
    public Object getProperty(String property) {
        // TODO Auto-generated method stub
        return super.getProperty(property);
    }

    @Override
    public IWorkbenchWindow getWindow() {
        // TODO Auto-generated method stub
        return super.getWindow();
    }

    @Override
    public void removePropertyChangeListener(IPropertyChangeListener listener) {
        // TODO Auto-generated method stub
        super.removePropertyChangeListener(listener);
    }

    @Override
    public void saveProperites(IMemento memento) {
        // TODO Auto-generated method stub
        super.saveProperites(memento);
    }

    @Override
    public void setColumns(String[] ids) {
        // TODO Auto-generated method stub
        super.setColumns(ids);
    }

    @Override
    public void setProperty(String property, Object value) {
        // TODO Auto-generated method stub
        super.setProperty(property, value);
    }

}
