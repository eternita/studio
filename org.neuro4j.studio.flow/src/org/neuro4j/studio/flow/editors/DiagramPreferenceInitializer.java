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
package org.neuro4j.studio.flow.editors;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.neuro4j.studio.core.diagram.preferences.DiagramAppearancePreferencePage;
import org.neuro4j.studio.core.diagram.preferences.DiagramConnectionsPreferencePage;
import org.neuro4j.studio.core.diagram.preferences.DiagramGeneralPreferencePage;
import org.neuro4j.studio.core.diagram.preferences.DiagramPrintingPreferencePage;
import org.neuro4j.studio.core.diagram.preferences.DiagramRulersAndGridPreferencePage;
import org.neuro4j.studio.flow.Activator;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

    /**
     * @generated NOT
     */
    public void initializeDefaultPreferences() {
        IPreferenceStore store = getPreferenceStore();
        DiagramGeneralPreferencePage.initDefaults(store);
        DiagramAppearancePreferencePage.initDefaults(store);
        DiagramConnectionsPreferencePage.initDefaults(store);
        DiagramPrintingPreferencePage.initDefaults(store);
        DiagramRulersAndGridPreferencePage.initDefaults(store);

    }

    /**
     * @generated
     */
    protected IPreferenceStore getPreferenceStore() {
        IPreferenceStore store = Activator.getInstance().getPreferenceStore();
        store.setDefault(IPreferenceConstants.PREF_SHOW_GRID, true);
        return store;
    }
}
