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
package org.neuro4j.studio.properties.ui.celleditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.swt.widgets.Shell;
import org.neuro4j.studio.core.util.PropetiesConstants;

public class ViewResourceSelectionDialog extends FlowResourcesSelectionDialog {

    public ViewResourceSelectionDialog(Shell shell, boolean multi,
            IContainer container, int typesMask) {
        super(shell, multi, container, typesMask);

    }

    protected List<String> convertToList(Object f) {
        File file = (File) f;
        List<String> list = new ArrayList<String>(1);

        String fileRelativePath = file.getProjectRelativePath().toPortableString();
        int index = fileRelativePath.indexOf("WEB-INF");
        if (index > 0)
        {
            fileRelativePath = fileRelativePath.substring(index + 7);
        }
        list.add(fileRelativePath);

        return list;
    }
}
