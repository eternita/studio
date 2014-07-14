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
package org.neuro4j.studio.core.diagram.wizards.webproject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jst.servlet.ui.internal.plugin.WEBUIMessages;
import org.eclipse.jst.servlet.ui.project.facet.WebProjectWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.neuro4j.studio.core.util.search.ResourceSearchEngine;
import org.osgi.framework.Bundle;

public class NewWebFlowProjectWizard extends WebProjectWizard {

    public NewWebFlowProjectWizard(IDataModel model) {

        super(model);

        setWindowTitle(WEBUIMessages.WEB_MODULE_WIZ_TITLE);

    }

    public NewWebFlowProjectWizard() {

        super();

        setWindowTitle(WEBUIMessages.WEB_MODULE_WIZ_TITLE);

    }

    @Override
    public boolean performFinish() {
        boolean result = super.performFinish();

        return result;
    }

    @Override
    protected void postPerformFinish() throws InvocationTargetException {
        String path = updateWebXml();
        copyErrorJsp(path);
        copyLibraries(path);
        super.postPerformFinish();
    }

    @Override
    protected void performFinish(IProgressMonitor monitor) throws CoreException {
        super.performFinish(monitor);

    }

    @Override
    public IWizardPage[] getPages() {
        return super.getPages();
    }

    private String updateWebXml()
    {
        InputStream templateStream = openContentStream("templates/webXmlTemplate.resource");

        String content = readStream(templateStream);
        IFile webXml = getwebXml();

        if (webXml != null)
        {
            String webXmlContent = null;
            try {
                webXmlContent = readStream(webXml.getContents());
            } catch (CoreException e) {
                e.printStackTrace();
            }
            webXmlContent = webXmlContent.replace("</display-name>", content);
            saveToFile(webXml, webXmlContent);
            return getlibPath(webXml);
        }
        return null;
    }

    private String copyErrorJsp(String path)
    {
        InputStream templateStream = openContentStream("templates/error.resource");

        ByteArrayOutputStream baos = readStreamToBAO(templateStream);

        if (path != null)
        {
            path = path.replace("lib", "jsp");
            File jspDir = new File(path);
            if (!jspDir.exists())
            {

                jspDir.mkdir();

                saveToFile(baos, path, "error.jsp");

            }

        }
        return null;
    }

    private String getlibPath(IFile webXmlPath) {
        String libpath = webXmlPath.getRawLocation().toOSString().replace("web.xml", "lib");
        return libpath;
    }

    private void copyLibraries(String path)
    {
        if (path == null)
        {
            return;
        }
        getNeuro4jLibraries(path);
    }

    private InputStream openContentStream(String templateName) {
        return this.getClass()
                .getResourceAsStream(templateName);
    }

    private void saveToFile(IFile webXml, String content) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(new File(webXml.getRawLocation().toOSString()));
            os.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
            {
                try {
                    os.flush();
                    os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
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

    private IFile getwebXml()
    {
        ResourceSearchEngine resourceSearchEngine = new ResourceSearchEngine(PlatformUI.getWorkbench().getDisplay().getActiveShell());
        List<IFile> files = Collections.emptyList();
        IFile webXml = null;
        try {
            files = resourceSearchEngine.findFiles("web.xml");
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String projectName = getProjectName();
        for (IFile file : files)
        {
            if (file.getProject().getName().equals(projectName)) {
                webXml = file;
                return webXml;
            }
        }

        return webXml;
    }

    private void getNeuro4jLibraries(String path)
    {
        Bundle coreBundle = Platform.getBundle("org.neuro4j.studio.workflow");

        try {
            URL coreLib = coreBundle.getEntry("neuro4j-core.jar");
            ByteArrayOutputStream bao = readStreamToBAO(coreLib.openStream());
            saveToFile(bao, path, "neuro4j-core.jar");
            URL logicLib = coreBundle.getEntry("neuro4j-workflow-common.jar");
            bao = readStreamToBAO(logicLib.openStream());
            saveToFile(bao, path, "neuro4j-workflow-common.jar");
            URL webLib = coreBundle.getEntry("neuro4j-logic-web.jar");
            bao = readStreamToBAO(webLib.openStream());
            saveToFile(bao, path, "neuro4j-logic-web.jar");

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    static private ByteArrayOutputStream readStreamToBAO(InputStream inputStream) {
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
        return baos;
    }

    private void saveToFile(ByteArrayOutputStream baos, String path, String libName) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(new File(path, libName));
            os.write(baos.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
            {
                try {
                    os.flush();
                    os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
