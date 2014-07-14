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

import org.eclipse.jdt.internal.ui.util.SWTUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringDialogField;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class MyStringDialogField extends StringDialogField
{
    private Button fBrowseButton;
    private String fBrowseButtonLabel;
    private IStringButtonAdapter fStringButtonAdapter;
    private boolean fButtonEnabled;

    public MyStringDialogField(IStringButtonAdapter adapter)
    {
        this.fStringButtonAdapter = adapter;
        this.fBrowseButtonLabel = "!Browse...!";
        this.fButtonEnabled = true;
    }

    public void setButtonLabel(String label)
    {
        this.fBrowseButtonLabel = label;
    }

    public void changeControlPressed()
    {
        this.fStringButtonAdapter.changeControlPressed(this);
    }

    public Control[] doFillIntoGrid(Composite parent, int nColumns)
    {
        assertEnoughColumns(nColumns);

        // Label label = getLabelControl(parent);
        // label.setLayoutData(gridDataForLabel(1));
        Text text = getTextControl(parent);
        text.setLayoutData(gridDataForText(nColumns - 1));
        Button button = getChangeControl(parent);
        button.setLayoutData(gridDataForButton(button, 1));

        return new Control[] { text, button };
    }

    public int getNumberOfControls()
    {
        return 2;
    }

    protected static GridData gridDataForButton(Button button, int span) {
        GridData gd = new GridData();
        gd.horizontalAlignment = 4;
        gd.grabExcessHorizontalSpace = false;
        gd.horizontalSpan = span;
        gd.widthHint = SWTUtil.getButtonWidthHint(button);
        return gd;
    }

    public Button getChangeControl(Composite parent)
    {
        if (this.fBrowseButton == null) {
            assertCompositeNotNull(parent);

            this.fBrowseButton = new Button(parent, 8);
            this.fBrowseButton.setFont(parent.getFont());
            this.fBrowseButton.setText(this.fBrowseButtonLabel);
            this.fBrowseButton.setEnabled((isEnabled()) && (this.fButtonEnabled));
            this.fBrowseButton.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    MyStringDialogField.this.changeControlPressed();
                }

                public void widgetSelected(SelectionEvent e) {
                    MyStringDialogField.this.changeControlPressed();
                }
            });
        }

        return this.fBrowseButton;
    }

    public void enableButton(boolean enable)
    {
        if (isOkToUse(this.fBrowseButton)) {
            this.fBrowseButton.setEnabled((isEnabled()) && (enable));
        }
        this.fButtonEnabled = enable;
    }

    protected void updateEnableState()
    {
        super.updateEnableState();
        if (isOkToUse(this.fBrowseButton))
            this.fBrowseButton.setEnabled((isEnabled()) && (this.fButtonEnabled));
    }
}