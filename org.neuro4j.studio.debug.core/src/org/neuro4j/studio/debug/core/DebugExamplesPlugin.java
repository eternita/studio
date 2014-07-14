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
package org.neuro4j.studio.debug.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;

/**
 * Plug-in class for debug examples
 */
public class DebugExamplesPlugin extends Plugin {

    private static DebugExamplesPlugin fgDefault = null;

    public DebugExamplesPlugin(IPluginDescriptor descriptor) {
        super(descriptor);
        fgDefault = this;
    }

    /**
     * Returns the singleton Debug Examples plug-in.
     * 
     * @return the singleton Debug Examples plug-in
     */
    public static DebugExamplesPlugin getDefault() {
        return fgDefault;
    }

    /**
     * Return a <code>java.io.File</code> object that corresponds to the specified <code>IPath</code> in the plugin
     * directory, or <code>null</code> if none.
     */
    public static File getFileInPlugin(IPath path) {
        try {
            URL installURL =
                    new URL(getDefault().getParameterInstallURL(), path.toString());
            URL localURL = Platform.asLocalURL(installURL);
            return new File(localURL.getFile());
        } catch (IOException ioe) {
            return null;
        }
    }

    private URL getParameterInstallURL() {
        // TODO Auto-generated method stub
        return null;
    }

    public static String getID() {
        // TODO Auto-generated method stub
        return "org.eclipse.debug.examples.core";
    }

    public String getParameterUniqueIdentifier() {
        // TODO Auto-generated method stub
        return null;
    }
}
