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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.Group;
import org.neuro4j.studio.core.util.LogSession;

public class FlowViewLabelProvider extends LabelProvider implements ITableLabelProvider, ITableFontProvider {

    private static int MAX_LABEL_LENGTH = 200;

    private Image infoImage;
    private Image okImage;
    private Image errorImage;
    private Image warningImage;
    private Image errorWithStackImage;
    private Image hierarchicalImage;
    ArrayList consumers = new ArrayList();
    private DateFormat dateFormat;

    private AbstractListView logView;

    public FlowViewLabelProvider(AbstractListView logView) {
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ENGLISH);
        errorImage = SharedImages.getImage(SharedImages.DESC_ERROR_ST_OBJ);
        warningImage = SharedImages.getImage(SharedImages.DESC_WARNING_ST_OBJ);
        infoImage = SharedImages.getImage(SharedImages.DESC_INFO_ST_OBJ);
        okImage = SharedImages.getImage(SharedImages.DESC_OK_ST_OBJ);
        errorWithStackImage = SharedImages.getImage(SharedImages.DESC_ERROR_STACK_OBJ);
        hierarchicalImage = SharedImages.getImage(SharedImages.DESC_HIERARCHICAL_LAYOUT_OBJ);

        this.logView = logView;
    }

    public void dispose() {
        if (consumers.size() == 0) {
            super.dispose();
        }
    }

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof Group) {
            return (columnIndex == 0) ? hierarchicalImage : null;
        }

        // FlowEntry entry = (FlowEntry) element;
        return errorWithStackImage;
    }

    public String getColumnText(Object element, int columnIndex) {
        if ((element instanceof LogSession) && (columnIndex == 2)) {
            LogSession session = (LogSession) element;
            if (session.getDate() == null)
                return ""; //$NON-NLS-1$

            return dateFormat.format(session.getDate());
        }

        if ((element instanceof Group) && (columnIndex == 0)) {
            return element.toString();
        }

        if (element instanceof ListEntry) {
            ListEntry entry = (ListEntry) element;
            switch (columnIndex) {
                case 0:
                    if (entry.getMessage() != null) {
                        String message = entry.getMessage();
                        if (message.length() > MAX_LABEL_LENGTH) {
                            StringBuffer sb = new StringBuffer();
                            sb.append("error");
                            return sb.toString();
                        }
                        return entry.getMessage();
                    }
                case 1:
                    if (entry.getPluginId() != null) {
                        return entry.getPluginId();
                    } else {
                        return "";
                    }
                case 2:
                    if (entry.getDate() != null)
                    {
                        return dateFormat.format(entry.getDate());     
                    }
                   
            }
        }

        return ""; //$NON-NLS-1$
    }

    public void connect(Object consumer) {
        if (!consumers.contains(consumer))
            consumers.add(consumer);
    }

    public void disconnect(Object consumer) {
        consumers.remove(consumer);
        if (consumers.size() == 0) {
            dispose();
        }
    }

    public Font getFont(Object element, int columnIndex) {
        if ((element instanceof LogSession) && (logView.isCurrentLogSession((LogSession) element))) {
            return JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
        }

        return null;
    }
}
