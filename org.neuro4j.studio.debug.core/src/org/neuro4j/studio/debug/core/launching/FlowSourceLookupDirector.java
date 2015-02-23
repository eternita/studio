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
package org.neuro4j.studio.debug.core.launching;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputer;

/**
 * PDA source lookup director. For PDA source lookup there is one source
 * lookup participant.
 */
public class FlowSourceLookupDirector extends AbstractSourceLookupDirector {
    
    public FlowSourceLookupDirector() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.internal.core.sourcelookup.ISourceLookupDirector#initializeParticipants()
     */
    public void initializeParticipants() {
        addParticipants(new ISourceLookupParticipant[] { new FlowSourceLookupParticipant() });
       
    }

    @Override
    public void clearSourceElements(Object element) {
        // TODO Auto-generated method stub
        super.clearSourceElements(element);
    }

    @Override
    protected void doInitializeFromMemento(String memento, boolean dispose) throws CoreException {
        // TODO Auto-generated method stub
        super.doInitializeFromMemento(memento, dispose);
    }

    @Override
    protected List doSourceLookup(Object element) {
        // TODO Auto-generated method stub
        return super.doSourceLookup(element);
    }

    @Override
    public Object[] findSourceElements(Object object) throws CoreException {
        // TODO Auto-generated method stub
        return super.findSourceElements(object);
    }

    @Override
    protected Object getCachedElement(Object duplicate) {
        // TODO Auto-generated method stub
        return super.getCachedElement(duplicate);
    }

    @Override
    public ISourceLookupParticipant getCurrentParticipant() {
        // TODO Auto-generated method stub
        return super.getCurrentParticipant();
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public ILaunchConfiguration getLaunchConfiguration() {
        // TODO Auto-generated method stub
        return super.getLaunchConfiguration();
    }

    @Override
    public synchronized String getMemento() throws CoreException {
        // TODO Auto-generated method stub
        return super.getMemento();
    }

    @Override
    public synchronized ISourceLookupParticipant[] getParticipants() {
        // TODO Auto-generated method stub
        return super.getParticipants();
    }

    @Override
    public synchronized ISourceContainer[] getSourceContainers() {
        // TODO Auto-generated method stub
        return super.getSourceContainers();
    }

    @Override
    public Object getSourceElement(IStackFrame stackFrame) {
        // TODO Auto-generated method stub
        Object element =  super.getSourceElement(stackFrame);
        if (element != null)
        {
            System.out.println(element);            
        }
        return element;
    }

    @Override
    public Object getSourceElement(Object element) {
        // TODO Auto-generated method stub
        Object e =  super.getSourceElement(element);
        if (e != null)
        {
            System.out.println(e);            
        }

        return e;
    }

    @Override
    public ISourcePathComputer getSourcePathComputer() {
        // TODO Auto-generated method stub
        return super.getSourcePathComputer();
    }

    @Override
    public void initializeDefaults(ILaunchConfiguration configuration) throws CoreException {
        dispose();
        setLaunchConfiguration(configuration);
        setSourceContainers(new ISourceContainer[] { (ISourceContainer) new FlowDefaultSourceContainer() });
        initializeParticipants();
    }

    @Override
    public void initializeFromMemento(String memento, ILaunchConfiguration configuration) throws CoreException {
        // TODO Auto-generated method stub
        super.initializeFromMemento(memento, configuration);
    }

    @Override
    public void initializeFromMemento(String memento) throws CoreException {
        // TODO Auto-generated method stub
        super.initializeFromMemento(memento);
    }

    @Override
    public void launchAdded(ILaunch launch) {
        // TODO Auto-generated method stub
        super.launchAdded(launch);
    }
    

    @Override
    public void launchChanged(ILaunch launch) {
        // TODO Auto-generated method stub
        super.launchChanged(launch);
    }

    @Override
    public void launchConfigurationAdded(ILaunchConfiguration configuration) {
        // TODO Auto-generated method stub
        super.launchConfigurationAdded(configuration);
    }

    @Override
    public void launchConfigurationChanged(ILaunchConfiguration configuration) {
        // TODO Auto-generated method stub
        super.launchConfigurationChanged(configuration);
    }

    @Override
    public void launchConfigurationRemoved(ILaunchConfiguration configuration) {
        // TODO Auto-generated method stub
        super.launchConfigurationRemoved(configuration);
    }

    @Override
    public void launchRemoved(ILaunch launch) {
        // TODO Auto-generated method stub
        super.launchRemoved(launch);
    }

    @Override
    public void removeParticipants(ISourceLookupParticipant[] participants) {
        // TODO Auto-generated method stub
        super.removeParticipants(participants);
    }

    @Override
    protected void setLaunchConfiguration(ILaunchConfiguration configuration) {
        // TODO Auto-generated method stub
        super.setLaunchConfiguration(configuration);
    }

    @Override
    public void setSourceContainers(ISourceContainer[] containers) {
        // TODO Auto-generated method stub
        super.setSourceContainers(containers);
    }

    @Override
    public void setSourcePathComputer(ISourcePathComputer computer) {
        // TODO Auto-generated method stub
        super.setSourcePathComputer(computer);
    }

    @Override
    public boolean supportsSourceContainerType(ISourceContainerType type) {
        // TODO Auto-generated method stub
        return super.supportsSourceContainerType(type);
    }
    
    
}
