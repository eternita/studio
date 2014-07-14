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

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class JUnitStubUtility {

    public static boolean is50OrHigher(String compliance) {
        return !isVersionLessThan(compliance, "1.5");
    }

    public static boolean isVersionLessThan(String version1, String version2)
    {
        if ("cldc1.1".equals(version1)) {
            version1 = "1.1a";
        }
        if ("cldc1.1".equals(version2)) {
            version2 = "1.1a";
        }
        return version1.compareTo(version2) < 0;
    }

    public static boolean is50OrHigher(IJavaProject project)
    {
        String source = project != null ? project.getOption("org.eclipse.jdt.core.compiler.source", true) : JavaCore.getOption("org.eclipse.jdt.core.compiler.source");
        return is50OrHigher(source);
    }

}
