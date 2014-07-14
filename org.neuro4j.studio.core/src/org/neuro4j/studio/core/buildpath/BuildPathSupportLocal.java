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
package org.neuro4j.studio.core.buildpath;

import java.io.File;
import java.io.FilenameFilter;

public class BuildPathSupportLocal implements FilenameFilter {
    private String pre;
    private String post;
    final BuildPathSupport.Neuro4jStudioCorePluginDescription neuro4jStudioCorePluginDescription;

    BuildPathSupportLocal(
            BuildPathSupport.Neuro4jStudioCorePluginDescription paramJUnitPluginDescription,
            String paramString, int paramInt) {
        this.neuro4jStudioCorePluginDescription = paramJUnitPluginDescription;
        this.pre = paramString.substring(0, paramInt);
        this.post = paramString.substring(paramInt + 1);
    }

    public boolean accept(File dir, String name) {
        return (name.startsWith(this.pre)) && (name.endsWith(this.post));
    }

}