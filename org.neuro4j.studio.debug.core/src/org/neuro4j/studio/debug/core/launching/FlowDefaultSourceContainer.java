package org.neuro4j.studio.debug.core.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputer;
import org.eclipse.debug.core.sourcelookup.containers.DefaultSourceContainer;

public class FlowDefaultSourceContainer extends DefaultSourceContainer {  
    
    /**
     * Unique identifier for the default source container type
     * (value <code>org.eclipse.debug.core.containerType.default</code>).
     */
    public static final String TYPE_ID = DebugPlugin.getUniqueIdentifier() + ".containerType.default"; //$NON-NLS-1$

    /**
     * Constructs a default source container. 
     */
    public FlowDefaultSourceContainer() {
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        return obj instanceof FlowDefaultSourceContainer;
    }   

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return getClass().hashCode();
    }   
    

    
    /**
     * Returns the source path computer to use, or <code>null</code>
     * if none.
     * 
     * @return the source path computer to use, or <code>null</code>
     * if none
     */
    private ISourcePathComputer getSourcePathComputer() {
        ISourceLookupDirector director = getDirector();
        if (director != null) {
            return director.getSourcePathComputer();
        }
        return null;
    }


    /* (non-Javadoc)
     * @see org.eclipse.debug.core.sourcelookup.containers.CompositeSourceContainer#createSourceContainers()
     */
    protected ISourceContainer[] createSourceContainers() throws CoreException {
        ISourcePathComputer sourcePathComputer = getSourcePathComputer();
        if (sourcePathComputer != null) {
            ILaunchConfiguration config= getLaunchConfiguration();
            if (config != null) {
                return sourcePathComputer.computeSourceContainers(config, null);
            }
        }
        
        return new ISourceContainer[0];
    }
}