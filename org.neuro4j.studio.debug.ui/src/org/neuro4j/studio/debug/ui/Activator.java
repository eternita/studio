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
package org.neuro4j.studio.debug.ui;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointsListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.neuro4j.studio.core.diagram.markers.MarkerMng;
import org.neuro4j.studio.debug.core.BreakpoinMng;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.neuro4j.studio.debug.ui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        
        JavaPlugin.getImageDescriptorRegistry();
        
        
        DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(new IBreakpointsListener() {

            @Override
            public void breakpointsRemoved(IBreakpoint[] arg0, IMarkerDelta[] arg1) {

                for (IBreakpoint bp : arg0)
                {
                    MarkerMng.getInstance().removeMarker(bp.getMarker());
                    BreakpoinMng.getInstance().clearBreakpoint(bp);
                }
            }

            @Override
            public void breakpointsChanged(IBreakpoint[] arg0, IMarkerDelta[] arg1) {

            }

            @Override
            public void breakpointsAdded(IBreakpoint[] arg0) {

            }
        });

        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
