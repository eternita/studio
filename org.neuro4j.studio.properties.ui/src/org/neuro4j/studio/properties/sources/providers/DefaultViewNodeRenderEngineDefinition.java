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
package org.neuro4j.studio.properties.sources.providers;

import org.neuro4j.web.logic.render.ViewNodeRenderEngineDefinition;

/**
 * Default render for ViewNode,
 * 
 */
public class DefaultViewNodeRenderEngineDefinition extends
        ViewNodeRenderEngineDefinition {

    public DefaultViewNodeRenderEngineDefinition(String name, String fileExt, String pathPrefix, String renderImpl) {
        super();
        this.name = name;
        this.fileExt = fileExt;
        this.pathPrefix = pathPrefix;
        this.renderImpl = renderImpl;
    }

    String name = null;

    String fileExt = null;

    String pathPrefix;
    
    String renderImpl = null;

    @Override
    public String getFileExt() {
        return fileExt;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPathFilter() {
        return pathPrefix;
    }
    
    public String getRenderImpl() {
        return renderImpl;
    }

}
