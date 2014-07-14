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
package org.neuro4j.studio.core.diagram.part;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.neuro4j.studio.core.diagram.edit.parts.EditPartUpdateObserver;
import org.neuro4j.studio.core.diagram.edit.parts.EditPartUpdater;
import org.neuro4j.studio.core.diagram.edit.parts.NodeBaseEditPart;
import org.neuro4j.studio.core.diagram.edit.policies.Neuro4jBaseItemSemanticEditPolicy;
import org.neuro4j.studio.core.diagram.providers.ElementInitializers;
import org.neuro4j.studio.core.provider.Neuro4jItemProviderAdapterFactory;
import org.neuro4j.studio.core.util.ClassloaderHelper;
import org.neuro4j.studio.core.util.CollectionWorkspaceUpdater;
import org.neuro4j.studio.core.util.FlowFromJarsLoader;
import org.neuro4j.studio.core.util.ParameterDefinitionLoader;
import org.neuro4j.studio.core.util.WorkspaceUpdateObserver;
import org.neuro4j.studio.core.util.WorkspaceUpdater;
import org.neuro4j.studio.core.util.search.LogicClassNameLoader;
import org.osgi.framework.BundleContext;

/**
 * @generated
 */
public class Neuro4jDiagramEditorPlugin extends AbstractUIPlugin {

    /**
     * @generated
     */
    public static final String ID = "org.neuro4j.studio.core.diagram"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(
            ID);

    /**
     * @generated
     */
    private static Neuro4jDiagramEditorPlugin instance;

    /**
     * @generated
     */
    private ComposedAdapterFactory adapterFactory;

    /**
     * @generated NOT
     */
    protected Neuro4jDocumentProvider documentProvider;

    /**
     * @generated
     */
    private Neuro4jBaseItemSemanticEditPolicy.LinkConstraints linkConstraints;

    /**
     * @generated
     */
    private ElementInitializers initializers;

    private EditPartUpdateObserver editPartUpdateObserver = new EditPartUpdateObserver();

    /**
     * @generated
     */
    public Neuro4jDiagramEditorPlugin() {
    }

    private Set<String> excludeImageRegister = new HashSet<String>();

    WorkspaceUpdateObserver workspaceObserver = new WorkspaceUpdateObserver();

    /**
     * @generated NOT
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        instance = this;
        PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT,
                Neuro4jDiagramEditorPlugin.getInstance().getPreferenceStore());
        adapterFactory = createAdapterFactory();

        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        addListToObserver(ParameterDefinitionLoader.getInstance().getUpdater());
        addListToObserver(ClassloaderHelper.getUpdater());
        addListToObserver(new CollectionWorkspaceUpdater(excludeImageRegister));
        addListToObserver(LogicClassNameLoader.getUpdater());
        addListToObserver(FlowFromJarsLoader.getUpdater());

        workspace.addResourceChangeListener(new MyResourceChangeReporter(workspaceObserver), IResourceChangeEvent.POST_BUILD);
    }

    @Override
    public IPreferenceStore getPreferenceStore() {
        // TODO Auto-generated method stub
        IPreferenceStore store = super.getPreferenceStore();
        Color noteFillColor = DiagramColorConstants.diagramLightYellow;

        store.setDefault(IPreferenceConstants.PREF_SHOW_GRID, true);
        store.setDefault(IPreferenceConstants.PREF_SNAP_TO_GRID, false);
        PreferenceConverter.setDefault(store,
                IPreferenceConstants.PREF_NOTE_FILL_COLOR, noteFillColor
                        .getRGB());
        store.setDefault(IPreferenceConstants.PREF_GRID_SPACING, 100);
        store.setDefault(IPreferenceConstants.PREF_RULER_UNITS,
                RulerProvider.UNIT_PIXELS);
        return store;
    }

    /**
     * @generated
     */
    public void stop(BundleContext context) throws Exception {
        adapterFactory.dispose();
        adapterFactory = null;
        linkConstraints = null;
        initializers = null;
        instance = null;
        super.stop(context);
    }

    /**
     * @generated
     */
    public static Neuro4jDiagramEditorPlugin getInstance() {
        return instance;
    }

    /**
     * @generated
     */
    protected ComposedAdapterFactory createAdapterFactory() {
        ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
        fillItemProviderFactories(factories);
        return new ComposedAdapterFactory(factories);
    }

    /**
     * @generated
     */
    protected void fillItemProviderFactories(List<AdapterFactory> factories) {
        factories.add(new Neuro4jItemProviderAdapterFactory());
        factories.add(new ResourceItemProviderAdapterFactory());
        factories.add(new ReflectiveItemProviderAdapterFactory());
    }

    /**
     * @generated
     */
    public AdapterFactory getItemProvidersAdapterFactory() {
        return adapterFactory;
    }

    /**
     * @generated
     */
    public ImageDescriptor getItemImageDescriptor(Object item) {
        IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory
                .adapt(item, IItemLabelProvider.class);
        if (labelProvider != null) {
            return ExtendedImageRegistry.getInstance().getImageDescriptor(
                    labelProvider.getImage(item));
        }
        return null;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path.
     * 
     * @generated
     * @param path
     *        the path
     * @return the image descriptor
     */
    public static ImageDescriptor getBundledImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
    }

    /**
     * Respects images residing in any plug-in. If path is relative,
     * then this bundle is looked up for the image, otherwise, for absolute
     * path, first segment is taken as id of plug-in with image
     * 
     * @generated
     * @param path
     *        the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
     * @return the image descriptor
     */
    public static ImageDescriptor findImageDescriptor(String path) {
        final IPath p = new Path(path);
        if (p.isAbsolute() && p.segmentCount() > 1) {
            return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p
                    .removeFirstSegments(1).makeAbsolute().toString());
        } else {
            return getBundledImageDescriptor(p.makeAbsolute().toString());
        }
    }

    /**
     * Returns an image for the image file at the given plug-in relative path.
     * Client do not need to dispose this image. Images will be disposed automatically.
     * 
     * @generated
     * @param path
     *        the path
     * @return image instance
     */
    public Image getBundledImage(String path) {
        Image image = getImageRegistry().get(path);
        if (image == null) {
            getImageRegistry().put(path, getBundledImageDescriptor(path));
            image = getImageRegistry().get(path);
        }
        return image;
    }

    /**
     * Returns string from plug-in's resource bundle
     * 
     * @generated
     */
    public static String getString(String key) {
        return Platform.getResourceString(getInstance().getBundle(), "%" + key); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    public Neuro4jDocumentProvider getDocumentProvider() {
        if (documentProvider == null) {
            documentProvider = new Neuro4jDocumentProvider();
        }
        return documentProvider;
    }

    /**
     * @generated
     */
    public Neuro4jBaseItemSemanticEditPolicy.LinkConstraints getLinkConstraints() {
        return linkConstraints;
    }

    /**
     * @generated
     */
    public void setLinkConstraints(
            Neuro4jBaseItemSemanticEditPolicy.LinkConstraints lc) {
        this.linkConstraints = lc;
    }

    /**
     * @generated
     */
    public ElementInitializers getElementInitializers() {
        return initializers;
    }

    /**
     * @generated
     */
    public void setElementInitializers(ElementInitializers i) {
        this.initializers = i;
    }

    /**
     * @generated
     */
    public void logError(String error) {
        logError(error, null);
    }

    /**
     * @generated
     */
    public void logError(String error, Throwable throwable) {
        if (error == null && throwable != null) {
            error = throwable.getMessage();
        }
        getLog().log(
                new Status(IStatus.ERROR, Neuro4jDiagramEditorPlugin.ID,
                        IStatus.OK, error, throwable));
        debug(error, throwable);
    }

    /**
     * @generated
     */
    public void logInfo(String message) {
        logInfo(message, null);
    }

    /**
     * @generated
     */
    public void logInfo(String message, Throwable throwable) {
        if (message == null && throwable != null) {
            message = throwable.getMessage();
        }
        getLog().log(
                new Status(IStatus.INFO, Neuro4jDiagramEditorPlugin.ID,
                        IStatus.OK, message, throwable));
        debug(message, throwable);
    }

    /**
     * @generated
     */
    private void debug(String message, Throwable throwable) {
        if (!isDebugging()) {
            return;
        }
        if (message != null) {
            System.err.println(message);
        }
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public Image getImageFromLocalRegister(String name) {
        Image image = getImageRegistry().get(name);
        if (image != null) {
            return image;
        }

        if (excludeImageRegister.contains(name)) {
            return null;
        }

        excludeImageRegister.add(name);

        InputStream is = ClassloaderHelper.loadImage(name);

        if (is != null) {
            ImageDescriptor id = ImageDescriptor
                    .createFromImageData(new ImageData(
                            is));

            if (id != null) {
                image = id.createImage();
                getImageRegistry().put(name, image);
            }

        }
        return image;
    }

    public void addListToObserver(WorkspaceUpdater updater)
    {
        workspaceObserver.addList(updater);
    }

    public void addEditPartUpdater(EditPartUpdater editPartUpdater)
    {
        editPartUpdateObserver.addEditPartUpdater(editPartUpdater);
    }

    public void fireRemoveEditPart(NodeBaseEditPart nodeBaseEditPart)
    {
        editPartUpdateObserver.remove(nodeBaseEditPart);
    }
}