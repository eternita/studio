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
package org.neuro4j.studio.core.utils;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.osgi.util.TextProcessor;

public class BasicElementLabels {
    private static String markLTR(String string, String delimiters)
    {
        return TextProcessor.process(string, delimiters);
    }

    public static String getPathLabel(IPath path, boolean isOSPath)
    {
        String label;
        if (isOSPath)
            label = path.toOSString();
        else {
            label = path.makeRelative().toString();
        }
        return markLTR(label, "/\\:.");
    }

    public static String getPathLabel(File file)
    {
        return markLTR(file.getAbsolutePath(), "/\\:.");
    }

    public static String getFilePattern(String name)
    {
        return markLTR(name, "*.?/\\:.");
    }

    public static String getURLPart(String name)
    {
        return markLTR(name, ":@?-#/\\:.");
    }

    public static String getResourceName(IResource resource)
    {
        return markLTR(resource.getName(), ":.");
    }

    public static String getResourceName(String resourceName)
    {
        return markLTR(resourceName, ":.");
    }

    public static String getVersionName(String name)
    {
        return markLTR(name, ":.");
    }

    public static String getJavaElementName(String name)
    {
        return markLTR(name, "<>()?,{}.:");
    }
}