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

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class Neuro4jCreationWizardPage extends WizardNewFileCreationPage {

    /**
     * @generated
     */
    private final String fileExtension;

    /**
     * @generated
     */
    public Neuro4jCreationWizardPage(String pageName,
            IStructuredSelection selection, String fileExtension) {
        super(pageName, selection);
        this.fileExtension = fileExtension;
    }

    /**
     * Override to create files with this extension.
     * 
     * @generated
     */
    protected String getExtension() {
        return fileExtension;
    }

    /**
     * @generated
     */
    public URI getURI() {
        return URI.createPlatformResourceURI(getFilePath().toString(), false);
    }

    /**
     * @generated
     */
    protected IPath getFilePath() {
        IPath path = getContainerFullPath();
        if (path == null) {
            path = new Path(""); //$NON-NLS-1$
        }
        String fileName = getFileName();
        if (fileName != null) {
            path = path.append(fileName);
        }
        return path;
    }

    /**
     * @generated
     */
    public void createControl(Composite parent) {
        super.createControl(parent);
        setFileName(Neuro4jDiagramEditorUtil.getUniqueFileName(
                getContainerFullPath(), getFileName(), getExtension()));
        setPageComplete(validatePage());
    }

    /**
     * @generated
     */
    protected boolean validatePage() {
        if (!super.validatePage()) {
            return false;
        }
        String extension = getExtension();
        if (extension != null
                && !getFilePath().toString().endsWith("." + extension)) {
            setErrorMessage(NLS
                    .bind(Messages.Neuro4jCreationWizardPageExtensionError,
                            extension));
            return false;
        }
        return true;
    }
}
