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
package org.neuro4j.studio.flow;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.neuro4j.studio.core.diagram.part.Neuro4jDiagramEditorPlugin;
import org.neuro4j.studio.core.diagram.part.Neuro4jDocumentProvider;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.flow.editors.Neuro2DocumentProvider;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Neuro4jDiagramEditorPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.neuro4j.studio.flow"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;

        ISelectionListener listener = new ISelectionListener() {

            @Override
            public void selectionChanged(IWorkbenchPart sourcePart, ISelection selection) {

                if (selection instanceof IStructuredSelection) {
                    Object element = ((IStructuredSelection) selection).getFirstElement();

                    if (element instanceof NodeEditPart)
                    {
                        // ((CallNodeEditPart)element).getPrimaryView().getDiagram().eResource().;
                        IEditorPart editorPart = sourcePart.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();

                        if (editorPart != null)
                        {
                            IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
                            IFile file = input.getFile();
                            ClassloaderHelper.setCurrentResource(file);

                            IProject activeProject = file.getProject();
                            String activeProjectName = activeProject.getName();
                            ClassloaderHelper.setCurrentJavaProject(activeProjectName);
                        }
                    }
                }

                // ClassloaderHelper.setCurrentJavaProject(jProject);

            }

        };
        getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path
     * 
     * @param path
     *        the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    public Neuro4jDocumentProvider getDocumentProvider() {
        if (documentProvider == null) {
            documentProvider = new Neuro2DocumentProvider();
        }
        return documentProvider;
    }
}
