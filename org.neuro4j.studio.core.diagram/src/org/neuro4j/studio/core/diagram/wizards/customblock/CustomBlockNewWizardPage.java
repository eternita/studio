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
package org.neuro4j.studio.core.diagram.wizards.customblock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (java).
 */

public class CustomBlockNewWizardPage extends NewTypeWizardPage {

    private ISelection selection;

    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param pageName
     */
    public CustomBlockNewWizardPage(ISelection selection) {
        super(true, "wizardPage");
        setTitle("New Neuro4j Custom Block Wizard");
        setDescription("This wizard creates a new  custom block.");
        this.selection = selection;
    }

    public void init(IStructuredSelection selection)
    {
        IJavaElement jelem = getInitialJavaElement(selection);
        initContainerPage(jelem);
        initTypePage(jelem);
        setTypeName("CustomBlock1.java", true);

    }

    /**
     * @see IDialogPage#createControl(Composite)
     */
    public void createControl(Composite parent) {
        initializeDialogUnits(parent);

        Composite composite = new Composite(parent, 0);
        composite.setFont(parent.getFont());

        int nColumns = 4;

        GridLayout layout = new GridLayout();
        layout.numColumns = nColumns;
        composite.setLayout(layout);

        createContainerControls(composite, nColumns);
        createPackageControls(composite, nColumns);

        createSeparator(composite, nColumns);

        createTypeNameControls(composite, nColumns);

        initialize();
        dialogChanged();
        setControl(composite);
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */

    private void initialize() {
        if (selection != null && selection.isEmpty() == false
                && selection instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) selection;
            if (ssel.size() > 1)
                return;
            Object obj = ssel.getFirstElement();
            if (obj instanceof IResource) {
                IContainer container;
                if (obj instanceof IContainer)
                    container = (IContainer) obj;
                else
                    container = ((IResource) obj).getParent();
                // containerText.setText(container.getFullPath().toString());
            }
        }
        // fileText.setText("new_block.java");
    }

    /**
     * Uses the standard container selection dialog to choose the new value for
     * the container field.
     */

    /**
     * Ensures that both text fields are set.
     */

    private void dialogChanged() {

        String fileName = getFileName();

        if (fileName.length() == 0) {
            updateStatus("File name must be specified");
            return;
        }
        if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
            updateStatus("File name must be valid");
            return;
        }
        int dotLoc = fileName.lastIndexOf('.');
        if (dotLoc != -1) {
            String ext = fileName.substring(dotLoc + 1);
            if (ext.equalsIgnoreCase("java") == false) {
                updateStatus("File extension must be \"java\"");
                return;
            }
        }
    }

    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getFileName() {
        return getTypeName();
    }

    public void createType(IProgressMonitor monitor,
            Map<String, String> parameters) throws CoreException,
            InterruptedException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        monitor.beginTask(NewWizardMessages.NewTypeWizardPage_operationdesc, 8);

        IPackageFragmentRoot root = getPackageFragmentRoot();
        IPackageFragment pack = getPackageFragment();
        if (pack == null) {
            pack = root.getPackageFragment(""); //$NON-NLS-1$
        }

        if (!pack.exists()) {
            String packName = pack.getElementName();
            pack = root.createPackageFragment(packName, true,
                    new SubProgressMonitor(monitor, 1));
        } else {
            monitor.worked(1);
        }

        boolean needsSave;
        ICompilationUnit connectedCU = null;

        try {
            String typeName = getTypeName();
            IType createdType;

            String cuName = getTypeName();
            InputStream is = openContentStream();

            String content = readStream(is);
            content = replaceContent(content, "{fileName}",
                    getNameWithoutExt());
            content = replaceContent(content, "{packageFullName}",
                    getPackageFullString(pack));
            content = replaceContent(content, "{staticImport}",
                    getStaticImportString(pack));

            Iterator<String> it = parameters.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                String value = parameters.get(key);
                content = replaceContent(content, key, value);
            }

            ICompilationUnit parentCU = pack.createCompilationUnit(cuName,
                    content, false, new SubProgressMonitor(monitor, 2));
            needsSave = true;
            parentCU.becomeWorkingCopy(new SubProgressMonitor(monitor, 1));
            connectedCU = parentCU;
            //

            createdType = parentCU.getType(typeName);

            ICompilationUnit cu = createdType.getCompilationUnit();

            if (needsSave) {
                cu.commitWorkingCopy(true, new SubProgressMonitor(monitor, 1));
            } else {
                monitor.worked(1);
            }

        } finally {
            if (connectedCU != null) {
                connectedCU.discardWorkingCopy();
            }
            monitor.done();
        }
    }

    protected InputStream openContentStream() {
        return this.getClass()
                .getResourceAsStream("templates/customBlockTemplate.resource");
    }

    static private String readStream(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream != null)
        {
            try {
                inputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new String(baos.toByteArray());
    }

    private String replaceContent(String original, String key, String value)
    {
        return original.replace(key, value);
    }

    private String getPackageFullString(IPackageFragment pack) {
        String pkgStr = "";
        if (pack.getElementName() != null && !"".equals(pack.getElementName())) {
            pkgStr = "package " + pack.getElementName() + ";";
        }
        return pkgStr;
    }

    private String getStaticImportString(IPackageFragment pack) {
        String pkgStr = "";
        if (pack.getElementName() != null && !"".equals(pack.getElementName())) {
            pkgStr = "import static " + pack.getElementName() + "." + getNameWithoutExt() + ".*;";
        }
        return pkgStr;
    }

    protected String getCompilationUnitName(String typeName) {
        if (typeName.endsWith(JavaModelUtil.DEFAULT_CU_SUFFIX)) {
            return typeName;
        }
        return typeName + JavaModelUtil.DEFAULT_CU_SUFFIX;
    }

    private String getNameWithoutExt()
    {
        return getTypeName().replace(".java", "");
    }

}