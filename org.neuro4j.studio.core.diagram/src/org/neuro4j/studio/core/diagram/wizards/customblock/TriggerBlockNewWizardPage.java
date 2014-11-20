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

import java.io.InputStream;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (java).
 */

public class TriggerBlockNewWizardPage extends CustomBlockNewWizardPage {



    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param pageName
     */
    public TriggerBlockNewWizardPage(ISelection selection) {
        super(selection);
        setTitle("New Neuro4j Trigger Block Wizard");
        setDescription("This wizard creates a new  trigger block.");

    }

    public void init(IStructuredSelection selection)
    {
        IJavaElement jelem = getInitialJavaElement(selection);
        initContainerPage(jelem);
        initTypePage(jelem);
        setTypeName("TriggerBlock1.java", true);

    }




    protected InputStream openContentStream() {
        return this.getClass()
                .getResourceAsStream("templates/triggerBlockTemplate.resource");
    }

   

}