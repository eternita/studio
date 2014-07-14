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
package org.neuro4j.studio.debug.ui.views.breakpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IDebugHelpContextIds;
import org.eclipse.debug.internal.ui.actions.ActionMessages;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IColumnPresentation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.texteditor.IUpdate;
import org.neuro4j.studio.debug.ui.views.TreeModelViewer;

/**
 * Configures visible columns in an asynch tree viewer/
 * 
 * @since 3.2
 */
public class ConfigureColumnsAction extends Action implements IUpdate {

    private TreeModelViewer fViewer;

    class ColumnContentProvider implements IStructuredContentProvider {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
         */
        public Object[] getElements(Object inputElement) {
            return ((IColumnPresentation) inputElement).getAvailableColumns();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose() {
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
         * java.lang.Object, java.lang.Object)
         */
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

    }

    class ColumnLabelProvider extends LabelProvider {

        private Map fImages = new HashMap();

        public Image getImage(Object element) {
            ImageDescriptor imageDescriptor = fViewer.getColumnPresentation().getImageDescriptor((String) element);
            if (imageDescriptor != null) {
                Image image = (Image) fImages.get(imageDescriptor);
                if (image == null) {
                    image = imageDescriptor.createImage();
                    fImages.put(imageDescriptor, image);
                }
                return image;
            }
            return null;
        }

        public String getText(Object element) {
            return fViewer.getColumnPresentation().getHeader((String) element);
        }

        public void dispose() {
            super.dispose();
            Iterator iterator = fImages.values().iterator();
            while (iterator.hasNext()) {
                Image image = (Image) iterator.next();
                image.dispose();
            }
            fImages.clear();
        }

    }

    public ConfigureColumnsAction(TreeModelViewer viewer) {
        setText(ActionMessages.ConfigureColumnsAction_0);
        setId(DebugUIPlugin.getUniqueIdentifier() + ".ConfigureColumnsAction"); //$NON-NLS-1$
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.CONFIGURE_COLUMNS_ACTION);
        fViewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.texteditor.IUpdate#update()
     */
    public void update() {
        setEnabled(fViewer.isShowColumns());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run() {
        ListSelectionDialog dialog = new ListSelectionDialog(
                fViewer.getControl().getShell(),
                fViewer.getColumnPresentation(),
                new ColumnContentProvider(),
                new ColumnLabelProvider(),
                ActionMessages.ConfigureColumnsAction_1);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IDebugHelpContextIds.CONFIGURE_COLUMNS_DIALOG);
        String[] visibleColumns = fViewer.getVisibleColumns();
        List initialSelection = new ArrayList(visibleColumns.length);
        for (int i = 0; i < visibleColumns.length; i++) {
            initialSelection.add(visibleColumns[i]);
        }
        dialog.setTitle(ActionMessages.ConfigureColumnsAction_2);
        dialog.setInitialElementSelections(initialSelection);
        if (dialog.open() == Window.OK) {
            Object[] result = dialog.getResult();
            if (result.length == 0) {
                fViewer.setShowColumns(false);
            } else {
                String[] ids = new String[result.length];
                System.arraycopy(result, 0, ids, 0, result.length);
                fViewer.resetColumnSizes(ids);
                fViewer.setVisibleColumns(ids);
            }
        }

    }

}
