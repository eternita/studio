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
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.corext.refactoring.StubTypeContext;
import org.eclipse.jdt.internal.corext.refactoring.TypeContextChecker;
import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.jdt.internal.ui.refactoring.contentassist.CompletionContextRequestor;
import org.eclipse.jdt.internal.ui.refactoring.contentassist.JavaTypeCompletionProcessor;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.internal.ui.wizards.SuperInterfaceSelectionDialog;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IListAdapter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.ListDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringButtonDialogField;
import org.eclipse.jdt.ui.wizards.NewContainerWizardPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.neuro4j.studio.core.diagram.wizards.utils.WizardParameterBuilder;
import org.neuro4j.workflow.common.ParameterDefinition;
import org.neuro4j.workflow.common.ParameterDefinitionList;

public class CustomBlockParametersWizardPage extends NewContainerWizardPage {
    // private Text text1;
    private Composite container;
    private MyStringDialogField fSuperClassDialogField, fSuperClassDialogField1, fSuperClassDialogField2;
    protected IStatus fSuperClassStatus;
    private StubTypeContext fSuperClassStubTypeContext;
    private IPackageFragment fCurrPackage;
    private IType fCurrEnclosingType;
    private IType fCurrType;
    IJavaProject iJavaProject;
    Vector<MyStringDialogField> parametersClassFields = new Vector<MyStringDialogField>();
    Vector<Text> parametersNameFields = new Vector<Text>();
    Vector<Button> parametersOptionalFields = new Vector<Button>();

    public CustomBlockParametersWizardPage(IJavaProject iJavaProject) {
        super("Parameter definition page");
        setTitle("Parameter definition page");
        setDescription("Please provide input and output parameters.");
        TypeFieldsAdapter adapter = new TypeFieldsAdapter(null);
        this.iJavaProject = iJavaProject;
        this.fSuperClassStatus = new StatusInfo();

        fSuperClassDialogField = createSuperClassField("", adapter);
        fSuperClassDialogField1 = createSuperClassField("", adapter);
        fSuperClassDialogField2 = createSuperClassField("", adapter);

        parametersClassFields.add(fSuperClassDialogField);
        parametersClassFields.add(fSuperClassDialogField1);
        parametersClassFields.add(fSuperClassDialogField2);

    }

    private MyStringDialogField createSuperClassField(String label, TypeFieldsAdapter adapter)
    {
        MyStringDialogField fSuperClassDialogField1 = new MyStringDialogField(adapter);
        fSuperClassDialogField1.setDialogFieldListener(adapter);
        fSuperClassDialogField1.setLabelText(".");

        fSuperClassDialogField1.setButtonLabel(NewWizardMessages.NewTypeWizardPage_superclass_button);

        return fSuperClassDialogField1;
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

        parameterTypeLebel.setText("Input:");

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

        Label label1 = new Label(container, SWT.NULL);
        label1.setText("Parameter1");
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label1.setLayoutData(gd);

        createSuperClassControls(fSuperClassDialogField, container, layout.numColumns);

        Label label2 = new Label(container, SWT.NULL);
        label2.setText("Parameter2");
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label2.setLayoutData(gd);

        createSuperClassControls(fSuperClassDialogField1, container, layout.numColumns);

        createLine(container, ncol);

        parameterTypeLebel = new Label(container, SWT.NONE);
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan = ncol - 1;
        parameterTypeLebel.setLayoutData(gd);
        parameterTypeLebel.setText("Output:");

        createLine(container, ncol);

        label2 = new Label(container, SWT.NULL);
        label2.setText("Parameter1");
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label2.setLayoutData(gd);

        createSuperClassControls(fSuperClassDialogField2, container, layout.numColumns);

        // Required to avoid an error in the system
        setControl(container);
        setPageComplete(false);

    }

    protected void createSuperClassControls(MyStringDialogField scField, Composite composite, int nColumns)
    {

        final Text nameField = new Text(container, SWT.BORDER | SWT.SINGLE);
        nameField.setText("");
        nameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // is optional

        Button check = new Button(container, SWT.CHECK);

        check.setSelection(true);
        check.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        check.setAlignment(SWT.CENTER);
        scField.doFillIntoGrid(composite, nColumns);

        Text text = scField.getTextControl(composite);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        text.setLayoutData(gd);
        parametersNameFields.add(nameField);
        parametersOptionalFields.add(check);

        JavaTypeCompletionProcessor superClassCompletionProcessor = new JavaTypeCompletionProcessor(false, false, true);
        superClassCompletionProcessor.setCompletionContextRequestor(new CompletionContextRequestor()
        {
            public StubTypeContext getStubTypeContext() {
                return CustomBlockParametersWizardPage.this.getSuperClassStubTypeContext();
            }
        });

        scField.setContentAssistProcessor(superClassCompletionProcessor);

    }

    public static StubTypeContext createSupertypeStubTypeContext(String typeName, IType enclosingType, IPackageFragment packageFragment)
    {
        String prolog = "class " + typeName + (true ? " implements " : " extends ");
        // String prolog = typeName;
        String epilog = " {} ";
        StubTypeContext stubTypeContext;
        if (enclosingType != null) {

            try {
                ICompilationUnit cu = enclosingType.getCompilationUnit();
                ISourceRange typeSourceRange = enclosingType.getSourceRange();
                int focalPosition = typeSourceRange.getOffset() + typeSourceRange.getLength() - 1;

                ASTParser parser = ASTParser.newParser(4);
                parser.setSource(cu);
                parser.setFocalPosition(focalPosition);
                CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);

                stubTypeContext = TypeContextChecker.createStubTypeContext(cu, compilationUnit, focalPosition);
                stubTypeContext = new StubTypeContext(stubTypeContext.getCuHandle(),
                        stubTypeContext.getBeforeString() + prolog,
                        epilog + stubTypeContext.getAfterString());
            } catch (CoreException e) {
                JavaPlugin.log(e);
                stubTypeContext = new StubTypeContext(null, null, null);
            }
        }
        else
        {

            if (packageFragment != null) {
                ICompilationUnit cu = packageFragment.getCompilationUnit("$$__$$.java");
                stubTypeContext = new StubTypeContext(cu, "package " + packageFragment.getElementName() + ";" + prolog, epilog);
            }
            else {
                stubTypeContext = new StubTypeContext(null, null, null);
            }
        }
        return stubTypeContext;
    }

    private class TypeFieldsAdapter
            implements IStringButtonAdapter, IDialogFieldListener, IListAdapter<CustomBlockParametersWizardPage.InterfaceWrapper>, SelectionListener
    {
        private TypeFieldsAdapter(Object object)
        {
        }

        public void changeControlPressed(DialogField field)
        {
            CustomBlockParametersWizardPage.this.typePageChangeControlPressed(field);
        }

        public void customButtonPressed(ListDialogField<CustomBlockParametersWizardPage.InterfaceWrapper> field, int index)
        {
            // CustomBlockParametersWizardPage.this.typePageCustomButtonPressed(field, index);
        }

        public void selectionChanged(ListDialogField<CustomBlockParametersWizardPage.InterfaceWrapper> field) {
        }

        public void dialogFieldChanged(DialogField field) {
            CustomBlockParametersWizardPage.this.typePageDialogFieldChanged(field);
        }

        public void doubleClicked(ListDialogField<CustomBlockParametersWizardPage.InterfaceWrapper> field)
        {
        }

        public void widgetSelected(SelectionEvent e) {
            CustomBlockParametersWizardPage.this.typePageLinkActivated();
        }

        public void widgetDefaultSelected(SelectionEvent e) {
            CustomBlockParametersWizardPage.this.typePageLinkActivated();
        }
    }

    private static class InterfaceWrapper
    {
        public String interfaceName;

        public InterfaceWrapper(String interfaceName)
        {
            this.interfaceName = interfaceName;
        }

        public int hashCode()
        {
            return this.interfaceName.hashCode();
        }

        public boolean equals(Object obj)
        {
            return (obj != null) && (getClass().equals(obj.getClass())) && (((InterfaceWrapper) obj).interfaceName.equals(this.interfaceName));
        }
    }

    private void typePageChangeControlPressed(DialogField field) {
        if (field instanceof MyStringDialogField) {
            IType type = chooseSuperClass();
            if (type != null)
                ((MyStringDialogField) field).setText(SuperInterfaceSelectionDialog.getNameWithTypeParameters(type));
        }
    }

    public void typePageDialogFieldChanged(DialogField field) {
        String fieldName = null;
        if (field instanceof StringButtonDialogField) {
            this.fSuperClassStatus = superClassChanged(field);
            fieldName = "NewTypeWizardPage.superclass";
        }

        handleFieldChanged(fieldName);

    }

    protected IType chooseSuperClass()
    {
        IJavaProject project = getJavaProject();
        if (project == null) {
            return null;
        }

        IJavaElement[] elements = { project };
        IJavaSearchScope scope = SearchEngine.createJavaSearchScope(elements);

        FilteredTypesSelectionDialog dialog = new FilteredTypesSelectionDialog(getShell(), false,
                getWizard().getContainer(), scope, IJavaSearchConstants.CLASS_AND_INTERFACE);
        dialog.setTitle("Class Selection");
        dialog.setMessage("Choose a type:");
        // dialog.setInitialPattern(getSuperClass());

        if (dialog.open() == 0) {
            return (IType) dialog.getFirstResult();
        }
        return null;
    }

    protected IStatus superClassChanged(DialogField field)
    {
        StatusInfo status = new StatusInfo();
        IPackageFragmentRoot root = getPackageFragmentRoot();
        ((StringButtonDialogField) field).enableButton(true);

        // this.fSuperClassStubTypeContext = null;

        String sclassName = getSuperClass(field);
        if (sclassName.length() == 0)
        {
            return status;
        }

        if (root != null) {
            Type type = TypeContextChecker.parseSuperClass(sclassName);
            if (type == null) {
                status.setError(NewWizardMessages.NewTypeWizardPage_error_InvalidSuperClassName);
                return status;
            }
            if (((type instanceof ParameterizedType)) && (!JavaModelUtil.is50OrHigher(root.getJavaProject()))) {
                status.setError(NewWizardMessages.NewTypeWizardPage_error_SuperClassNotParameterized);
                return status;
            }
        } else {
            status.setError("");
        }
        return status;
    }

    public String getSuperClass(DialogField field)
    {
        return ((StringButtonDialogField) field).getText();
    }

    private void typePageLinkActivated()
    {
        IJavaProject project = getJavaProject();
        if (project != null) {
            PreferenceDialog dialog = PreferencesUtil.createPropertyDialogOn(getShell(), project.getProject(), "org.eclipse.jdt.ui.propertyPages.CodeTemplatePreferencePage", null, null);
            dialog.open();
        } else {
            String title = NewWizardMessages.NewTypeWizardPage_configure_templates_title;
            String message = NewWizardMessages.NewTypeWizardPage_configure_templates_message;
            MessageDialog.openInformation(getShell(), title, message);
        }
    }

    private StubTypeContext getSuperClassStubTypeContext() {
        if (this.fSuperClassStubTypeContext == null)
        {
            String typeName = "$$__$$";
            this.fSuperClassStubTypeContext = createSupertypeStubTypeContext(typeName, null, getPackageFragment());
        }

        return this.fSuperClassStubTypeContext;
    }

    public IPackageFragment getPackageFragment()
    {
        if (this.fCurrEnclosingType != null) {
            return this.fCurrEnclosingType.getPackageFragment();
        }

        return null;
    }

    public IJavaProject getJavaProject() {
        return this.iJavaProject;
    }

    private void createLine(Composite parent, int ncol)
    {
        Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.BOLD);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = ncol;
        line.setLayoutData(gridData);
    }

    public String getName(int index)
    {
        return parametersNameFields.get(index).getText();
    }

    public Boolean getIsOptional(int index)
    {
        return parametersOptionalFields.get(index).getSelection();
    }

    public String getClassName(int index)
    {
        return parametersClassFields.get(index).getText();
    }

    public void processParameters(Map<String, String> parameters) {

        ParameterDefinitionList list = getParameterDefList();
        WizardParameterBuilder builder = new WizardParameterBuilder(list);

        String inputParameters = builder.buildInputString();
        String outPutParameters = builder.buildOutputString();

        String outputBlock1 = builder.buildOutputBlock1();
        String outputBlock2 = builder.buildOutputBlock2();

        String intputBlock1 = builder.buildInputBlock1();
        String intputBlock2 = builder.buildInputBlock2();

        parameters.put("{inputParameters}", inputParameters);
        parameters.put("{outputParameters}", outPutParameters);
        parameters.put("{outputBlock1}", outputBlock1);
        parameters.put("{outputBlock2}", outputBlock2);
        parameters.put("{inputBlock1}", intputBlock1);
        parameters.put("{inputBlock2}", intputBlock2);
    }

    private ParameterDefinitionList getParameterDefList()
    {
        ParameterDefinitionList list = new ParameterDefinitionList() {

            @Override
            public Class<? extends Annotation> annotationType() {

                return org.neuro4j.workflow.common.ParameterDefinitionList.class;
            }

            @Override
            public ParameterDefinition[] input() {
                ParameterDefinition pd1 = getParameterDefinition(0);
                ParameterDefinition pd2 = getParameterDefinition(1);
                return new ParameterDefinition[] { pd1, pd2 };
            }

            @Override
            public ParameterDefinition[] output() {
                ParameterDefinition pd3 = getParameterDefinition(2);
                return new ParameterDefinition[] { pd3 };
            }
        };

        return list;

    }

    private final ParameterDefinition getParameterDefinition(final int index)
    {
        final String name = getName(index);
        if (name == null || "".equals(name.trim()))
        {
            return null;
        }

        final String type = getClassName(index);
        final Boolean isOptional = getIsOptional(index);
        ParameterDefinition pd = new ParameterDefinition() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return org.neuro4j.workflow.common.ParameterDefinition.class;
            }

            @Override
            public String type() {
                return type;
            }

            @Override
            public String name() {
                return name;
            }

            @Override
            public boolean isOptional() {
                return isOptional;
            }
        };

        return pd;
    }

}
