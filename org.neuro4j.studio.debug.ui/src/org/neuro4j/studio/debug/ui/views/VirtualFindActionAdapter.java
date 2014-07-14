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
package org.neuro4j.studio.debug.ui.views;

import org.eclipse.debug.internal.ui.viewers.model.VirtualFindAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.texteditor.IUpdate;

public class VirtualFindActionAdapter implements IUpdate {

    VirtualFindAction adapter = null;

    public VirtualFindActionAdapter(VirtualFindAction adapter) {
        super();
        this.adapter = adapter;
    }

    @Override
    public void update() {

    }

    public void addPropertyChangeListener(IPropertyChangeListener listener) {
        adapter.addPropertyChangeListener(listener);
    }

    public boolean equals(Object arg0) {
        return adapter.equals(arg0);
    }

    public int getAccelerator() {
        return adapter.getAccelerator();
    }

    public String getActionDefinitionId() {
        return adapter.getActionDefinitionId();
    }

    public String getDescription() {
        return adapter.getDescription();
    }

    public ImageDescriptor getDisabledImageDescriptor() {
        return adapter.getDisabledImageDescriptor();
    }

    public HelpListener getHelpListener() {
        return adapter.getHelpListener();
    }

    public ImageDescriptor getHoverImageDescriptor() {
        return adapter.getHoverImageDescriptor();
    }

    public String getId() {
        return adapter.getId();
    }

    public ImageDescriptor getImageDescriptor() {
        return adapter.getImageDescriptor();
    }

    public IMenuCreator getMenuCreator() {
        return adapter.getMenuCreator();
    }

    public int getStyle() {
        return adapter.getStyle();
    }

    public String getText() {
        return adapter.getText();
    }

    public String getToolTipText() {
        return adapter.getToolTipText();
    }

    public int hashCode() {
        return adapter.hashCode();
    }

    public boolean isChecked() {
        return adapter.isChecked();
    }

    public boolean isEnabled() {
        return adapter.isEnabled();
    }

    public boolean isHandled() {
        return adapter.isHandled();
    }

    public final void notifyResult(boolean success) {
        adapter.notifyResult(success);
    }

    public void removePropertyChangeListener(IPropertyChangeListener listener) {
        adapter.removePropertyChangeListener(listener);
    }

    public void run() {
        adapter.run();
    }

    public void runWithEvent(Event event) {
        adapter.runWithEvent(event);
    }

    public void setAccelerator(int keycode) {
        adapter.setAccelerator(keycode);
    }

    public void setActionDefinitionId(String id) {
        adapter.setActionDefinitionId(id);
    }

    public void setChecked(boolean checked) {
        adapter.setChecked(checked);
    }

    public void setDescription(String text) {
        adapter.setDescription(text);
    }

    public void setDisabledImageDescriptor(ImageDescriptor newImage) {
        adapter.setDisabledImageDescriptor(newImage);
    }

    public void setEnabled(boolean enabled) {
        adapter.setEnabled(enabled);
    }

    public void setHelpListener(HelpListener listener) {
        adapter.setHelpListener(listener);
    }

    public void setHoverImageDescriptor(ImageDescriptor newImage) {
        adapter.setHoverImageDescriptor(newImage);
    }

    public void setId(String id) {
        adapter.setId(id);
    }

    public void setImageDescriptor(ImageDescriptor newImage) {
        adapter.setImageDescriptor(newImage);
    }

    public void setMenuCreator(IMenuCreator creator) {
        adapter.setMenuCreator(creator);
    }

    public void setText(String text) {
        adapter.setText(text);
    }

    public void setToolTipText(String toolTipText) {
        adapter.setToolTipText(toolTipText);
    }

    public String toString() {
        return adapter.toString();
    }

}
