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
package org.neuro4j.studio.core.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.neuro4j.studio.core.Neuro4jFactory;
import org.neuro4j.studio.core.Neuro4jPackage;
import org.neuro4j.studio.core.provider.Neuro4jEditPlugin;

/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Neuro4jModelWizard extends Wizard implements INewWizard {
    /**
     * The supported extensions for created files.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<String> FILE_EXTENSIONS =
            Collections.unmodifiableList(Arrays.asList(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jEditorFilenameExtensions").split("\\s*,\\s*")));

    /**
     * A formatted list of supported file extensions, suitable for display.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String FORMATTED_FILE_EXTENSIONS =
            Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

    /**
     * This caches an instance of the model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Neuro4jPackage neuro4jPackage = Neuro4jPackage.eINSTANCE;

    /**
     * This caches an instance of the model factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Neuro4jFactory neuro4jFactory = neuro4jPackage.getNeuro4jFactory();

    /**
     * This is the file creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Neuro4jModelWizardNewFileCreationPage newFileCreationPage;

    /**
     * This is the initial object creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Neuro4jModelWizardInitialObjectCreationPage initialObjectCreationPage;

    /**
     * Remember the selection during initialization for populating the default container.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * Remember the workbench during initialization.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IWorkbench workbench;

    /**
     * Caches the names of the features representing global elements.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected List<String> initialObjectNames;

    /**
     * This just records the information.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
        setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(Neuro4jEditorPlugin.INSTANCE.getImage("full/wizban/NewNeuro4j")));
    }

    /**
     * Returns the names of the features representing global elements.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<String> getInitialObjectNames() {
        if (initialObjectNames == null) {
            initialObjectNames = new ArrayList<String>();
            for (EStructuralFeature eStructuralFeature : ExtendedMetaData.INSTANCE.getAllElements(ExtendedMetaData.INSTANCE.getDocumentRoot(neuro4jPackage))) {
                if (eStructuralFeature.isChangeable()) {
                    EClassifier eClassifier = eStructuralFeature.getEType();
                    if (eClassifier instanceof EClass) {
                        EClass eClass = (EClass) eClassifier;
                        if (!eClass.isAbstract()) {
                            initialObjectNames.add(eStructuralFeature.getName());
                        }
                    }
                }
            }
            Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
        }
        return initialObjectNames;
    }

    /**
     * Create a new model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EObject createInitialModel() {
        EClass eClass = ExtendedMetaData.INSTANCE.getDocumentRoot(neuro4jPackage);
        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(initialObjectCreationPage.getInitialObjectName());
        EObject rootObject = neuro4jFactory.create(eClass);
        rootObject.eSet(eStructuralFeature, EcoreUtil.create((EClass) eStructuralFeature.getEType()));
        return rootObject;
    }

    /**
     * Do the work after everything is specified.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean performFinish() {
        try {
            // Remember the file.
            //
            final IFile modelFile = getModelFile();

            // Do the work within an operation.
            //
            WorkspaceModifyOperation operation =
                    new WorkspaceModifyOperation() {
                        @Override
                        protected void execute(IProgressMonitor progressMonitor) {
                            try {
                                // Create a resource set
                                //
                                ResourceSet resourceSet = new ResourceSetImpl();

                                // Get the URI of the model file.
                                //
                                URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

                                // Create a resource for this file.
                                //
                                Resource resource = resourceSet.createResource(fileURI);

                                // Add the initial model object to the contents.
                                //
                                EObject rootObject = createInitialModel();
                                if (rootObject != null) {
                                    resource.getContents().add(rootObject);
                                }

                                // Save the contents of the resource to the file system.
                                //
                                Map<Object, Object> options = new HashMap<Object, Object>();
                                options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
                                resource.save(options);
                            }
                            catch (Exception exception) {
                                Neuro4jEditorPlugin.INSTANCE.log(exception);
                            }
                            finally {
                                progressMonitor.done();
                            }
                        }
                    };

            getContainer().run(false, false, operation);

            // Select the new file resource in the current view.
            //
            IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
            IWorkbenchPage page = workbenchWindow.getActivePage();
            final IWorkbenchPart activePart = page.getActivePart();
            if (activePart instanceof ISetSelectionTarget) {
                final ISelection targetSelection = new StructuredSelection(modelFile);
                getShell().getDisplay().asyncExec
                        (new Runnable() {
                            public void run() {
                                ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
                            }
                        });
            }

            // Open an editor on the new file.
            //
            try {
                page.openEditor
                        (new FileEditorInput(modelFile),
                                workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
            } catch (PartInitException exception) {
                MessageDialog.openError(workbenchWindow.getShell(), Neuro4jEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
                return false;
            }

            return true;
        } catch (Exception exception) {
            Neuro4jEditorPlugin.INSTANCE.log(exception);
            return false;
        }
    }

    /**
     * This is the one page of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public class Neuro4jModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public Neuro4jModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
            super(pageId, selection);
        }

        /**
         * The framework calls this to see if the file is correct.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        protected boolean validatePage() {
            if (super.validatePage()) {
                String extension = new Path(getFileName()).getFileExtension();
                if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
                    String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
                    setErrorMessage(Neuro4jEditorPlugin.INSTANCE.getString(key, new Object[] { FORMATTED_FILE_EXTENSIONS }));
                    return false;
                }
                return true;
            }
            return false;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public IFile getModelFile() {
            return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
        }
    }

    /**
     * This is the page where the type of object to create is selected.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public class Neuro4jModelWizardInitialObjectCreationPage extends WizardPage {
        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Combo initialObjectField;

        /**
         * @generated
         *            <!-- begin-user-doc -->
         *            <!-- end-user-doc -->
         */
        protected List<String> encodings;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Combo encodingField;

        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public Neuro4jModelWizardInitialObjectCreationPage(String pageId) {
            super(pageId);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            {
                GridLayout layout = new GridLayout();
                layout.numColumns = 1;
                layout.verticalSpacing = 12;
                composite.setLayout(layout);

                GridData data = new GridData();
                data.verticalAlignment = GridData.FILL;
                data.grabExcessVerticalSpace = true;
                data.horizontalAlignment = GridData.FILL;
                composite.setLayoutData(data);
            }

            Label containerLabel = new Label(composite, SWT.LEFT);
            {
                containerLabel.setText(Neuro4jEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                containerLabel.setLayoutData(data);
            }

            initialObjectField = new Combo(composite, SWT.BORDER);
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                initialObjectField.setLayoutData(data);
            }

            for (String objectName : getInitialObjectNames()) {
                initialObjectField.add(getLabel(objectName));
            }

            if (initialObjectField.getItemCount() == 1) {
                initialObjectField.select(0);
            }
            initialObjectField.addModifyListener(validator);

            Label encodingLabel = new Label(composite, SWT.LEFT);
            {
                encodingLabel.setText(Neuro4jEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                encodingLabel.setLayoutData(data);
            }
            encodingField = new Combo(composite, SWT.BORDER);
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                encodingField.setLayoutData(data);
            }

            for (String encoding : getEncodings()) {
                encodingField.add(encoding);
            }

            encodingField.select(0);
            encodingField.addModifyListener(validator);

            setPageComplete(validatePage());
            setControl(composite);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected ModifyListener validator =
                new ModifyListener() {
                    public void modifyText(ModifyEvent e) {
                        setPageComplete(validatePage());
                    }
                };

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected boolean validatePage() {
            return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public void setVisible(boolean visible) {
            super.setVisible(visible);
            if (visible) {
                if (initialObjectField.getItemCount() == 1) {
                    initialObjectField.clearSelection();
                    encodingField.setFocus();
                }
                else {
                    encodingField.clearSelection();
                    initialObjectField.setFocus();
                }
            }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public String getInitialObjectName() {
            String label = initialObjectField.getText();

            for (String name : getInitialObjectNames()) {
                if (getLabel(name).equals(label)) {
                    return name;
                }
            }
            return null;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public String getEncoding() {
            return encodingField.getText();
        }

        /**
         * Returns the label for the specified feature name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected String getLabel(String featureName) {
            try {
                return Neuro4jEditPlugin.INSTANCE.getString("_UI_DocumentRoot_" + featureName + "_feature");
            } catch (MissingResourceException mre) {
                Neuro4jEditorPlugin.INSTANCE.log(mre);
            }
            return featureName;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Collection<String> getEncodings() {
            if (encodings == null) {
                encodings = new ArrayList<String>();
                for (StringTokenizer stringTokenizer = new StringTokenizer(Neuro4jEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens();) {
                    encodings.add(stringTokenizer.nextToken());
                }
            }
            return encodings;
        }
    }

    /**
     * The framework calls this to create the contents of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void addPages() {
        // Create a page, set the title, and the initial model file name.
        //
        newFileCreationPage = new Neuro4jModelWizardNewFileCreationPage("Whatever", selection);
        newFileCreationPage.setTitle(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jModelWizard_label"));
        newFileCreationPage.setDescription(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jModelWizard_description"));
        newFileCreationPage.setFileName(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
        addPage(newFileCreationPage);

        // Try and get the resource selection to determine a current directory for the file dialog.
        //
        if (selection != null && !selection.isEmpty()) {
            // Get the resource...
            //
            Object selectedElement = selection.iterator().next();
            if (selectedElement instanceof IResource) {
                // Get the resource parent, if its a file.
                //
                IResource selectedResource = (IResource) selectedElement;
                if (selectedResource.getType() == IResource.FILE) {
                    selectedResource = selectedResource.getParent();
                }

                // This gives us a directory...
                //
                if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
                    // Set this for the container.
                    //
                    newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

                    // Make up a unique new name here.
                    //
                    String defaultModelBaseFilename = Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jEditorFilenameDefaultBase");
                    String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
                    String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
                    for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
                        modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
                    }
                    newFileCreationPage.setFileName(modelFilename);
                }
            }
        }
        initialObjectCreationPage = new Neuro4jModelWizardInitialObjectCreationPage("Whatever2");
        initialObjectCreationPage.setTitle(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Neuro4jModelWizard_label"));
        initialObjectCreationPage.setDescription(Neuro4jEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
        addPage(initialObjectCreationPage);
    }

    /**
     * Get the file from the page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public IFile getModelFile() {
        return newFileCreationPage.getModelFile();
    }

}
