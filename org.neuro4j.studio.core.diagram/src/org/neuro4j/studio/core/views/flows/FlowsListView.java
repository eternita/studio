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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.neuro4j.studio.core.util.CollectionWorkspaceUpdater;
import org.neuro4j.studio.core.util.FlowFromJarsLoader;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;

public class FlowsListView extends AbstractListView {

    public FlowsListView() {
        super(ListEntryType.FLOW);

    }

    void loadElements() {
        elements.clear();
        groups.clear();

        workflowSearchEngine.load(elements);

        List<ListEntry> flows = FlowFromJarsLoader.getInstance().getAllFlows();
        List result = new ArrayList(flows.size());
        for (ListEntry entry : flows)
        {
            result.add(entry);
        }

        group(result);
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
        return Messages.FlowView_Title;
    }

    @Override
    String getFirstColumnName() {
        return Messages.FlowView_column_message;
    }

    public CollectionWorkspaceUpdater getUpdater()
    {
        return new CollectionWorkspaceUpdater(elements) {
            public void update(IResource iResource, int action) {
                if (iResource != null && (iResource.getFileExtension().equals("classpath") || iResource.getName().equals("pom.xml") || iResource.getFileExtension().equals("n4j")))
                {
                    workflowSearchEngine.resetCache(iResource.getProject().getName());
                    loadElements();
                    asyncRefresh(false);
                }
            }
        };
    }

}
