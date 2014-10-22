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

package org.neuro4j.studio.core.views.flows;

import org.neuro4j.studio.core.util.search.LogicClassNameLoader;

public class CustomBlocksListView extends AbstractListView {

    public CustomBlocksListView() {
        super();
    }

    void loadElements() {
        elements.clear();
        groups.clear();

        LogicClassNameLoader.getInstance().loadAllBlocksInWorkspace(elements);

        limitEntriesCount();

        if (fDisplay != null) {
            fDisplay.asyncExec(new Runnable() {
                public void run() {
                    setContentDescription(getTitleSummary());
                }
            });
        }

    }

    String getTitleSummary()
    {
        return Messages.CustomBlockView_Title;
    }
    
    @Override
    String getFirstColumnName() {
        return Messages.CustomBlockView_column_message;
    }

}
