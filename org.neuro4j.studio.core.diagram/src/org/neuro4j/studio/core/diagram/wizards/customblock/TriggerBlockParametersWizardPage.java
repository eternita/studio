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

import java.lang.annotation.Annotation;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.neuro4j.studio.core.diagram.wizards.utils.WizardParameterBuilder;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;

public class TriggerBlockParametersWizardPage extends CustomBlockParametersWizardPage {
    // private Text text1;


    public TriggerBlockParametersWizardPage(IJavaProject iJavaProject) {
        super();
        setTitle("Parameter definition page");
        setDescription("Please provide output parameters for trigger block.");
        TypeFieldsAdapter adapter = new TypeFieldsAdapter(null);
        this.iJavaProject = iJavaProject;
        this.fSuperClassStatus = new StatusInfo();

        fSuperClassDialogField = createSuperClassField("", adapter);


        parametersClassFields.add(fSuperClassDialogField);

    }



    @Override
    public void createControl(Composite parent) {

        int ncol = 6;
        container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout(ncol, false);
        container.setLayout(layout);

        Label parameterTypeLebel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.BEGINNING);
        // gd.horizontalSpan = 2;
        parameterTypeLebel.setLayoutData(gd);

//        parameterTypeLebel.setText("Input:");
//
        Label labelCheck = new Label(container, SWT.NONE);
        labelCheck.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        labelCheck.setText("Name");

        labelCheck = new Label(container, SWT.NONE);
        labelCheck.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        labelCheck.setText("Is optional?");

        labelCheck = new Label(container, SWT.NONE);
        labelCheck.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        labelCheck.setText("Class");
        createLine(container, ncol);
//
//        Label label1 = new Label(container, SWT.NULL);
//        label1.setText("Parameter1");
//        gd = new GridData();
//        gd.horizontalAlignment = GridData.BEGINNING;
//        label1.setLayoutData(gd);
//
//        createSuperClassControls(fSuperClassDialogField, container, layout.numColumns);
//
//        Label label2 = new Label(container, SWT.NULL);
//        label2.setText("Parameter2");
//        gd = new GridData();
//        gd.horizontalAlignment = GridData.BEGINNING;
//        label2.setLayoutData(gd);
//
//        createSuperClassControls(fSuperClassDialogField1, container, layout.numColumns);
//
//        createLine(container, ncol);

        parameterTypeLebel = new Label(container, SWT.NONE);
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan = ncol - 1;
        parameterTypeLebel.setLayoutData(gd);
        parameterTypeLebel.setText("Output:");

        createLine(container, ncol);

        Label label2 = new Label(container, SWT.NULL);
        label2.setText("Parameter1");
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label2.setLayoutData(gd);

        createSuperClassControls(fSuperClassDialogField, container, layout.numColumns);

        // Required to avoid an error in the system
        setControl(container);
        setPageComplete(false);

    }
    
    public void processParameters(Map<String, String> parameters) {

        ParameterDefinitionList list = getParameterDefList();
        WizardParameterBuilder builder = new WizardParameterBuilder(list);


        String outPutParameters = builder.buildOutputString();

        String outputBlock1 = builder.buildOutputBlock1();
        String outputBlock2 = buildOutputBlock2(list);

//        String intputBlock1 = builder.buildInputBlock1();
//        String intputBlock2 = builder.buildInputBlock2();

        parameters.put("{inputParameters}", "");
        parameters.put("{outputParameters}", outPutParameters);
        parameters.put("{outputBlock1}", outputBlock1);
        parameters.put("{outputBlock2}", outputBlock2);
        parameters.put("{inputBlock1}", "");
        parameters.put("{inputBlock2}", "");
    }

    protected ParameterDefinitionList getParameterDefList()
    {
        ParameterDefinitionList list = new ParameterDefinitionList() {

            @Override
            public Class<? extends Annotation> annotationType() {

                return org.neuro4j.workflow.common.ParameterDefinitionList.class;
            }

            @Override
            public ParameterDefinition[] input() {
                return new ParameterDefinition[] {};
            }

            @Override
            public ParameterDefinition[] output() {
                ParameterDefinition pd3 = getParameterDefinition(0);
                return new ParameterDefinition[] { pd3 };
            }
        };

        return list;

    }
    public String buildOutputBlock2(ParameterDefinitionList list) {
        StringBuffer sb = new StringBuffer();
        ParameterDefinition[] array = list.output();
        for (ParameterDefinition pd : array)
        {
            if (pd == null)
            {
                continue;
            }
            String name = getOutConstantName(pd);
            sb.append("parameters.put(").append(name).append(", null); \n    ");
        }
        return sb.toString();
    }
    
    private String getOutConstantName(ParameterDefinition pd) {
        return WizardParameterBuilder.OUT_PREFIX + pd.name().toUpperCase();
    }
  
}
