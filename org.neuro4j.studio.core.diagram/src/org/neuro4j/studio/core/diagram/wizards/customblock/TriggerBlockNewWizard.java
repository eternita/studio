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


/**
 * This is a sample new wizard. Its role is to create a new file
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "java". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class TriggerBlockNewWizard extends CustomBlockNewWizard {




    /**
     * Constructor for CustomBlockNewWizard.
     */
    public TriggerBlockNewWizard() {
        super();

    }

    /**
     * Adding the page to the wizard.
     */

    public void addPages() {
        page = new TriggerBlockNewWizardPage(fSelection);
        addPage(page);
        this.page.init(fSelection);

        parameterPage = new TriggerBlockParametersWizardPage(page.getJavaProject());
        addPage(parameterPage);
    }

   

}