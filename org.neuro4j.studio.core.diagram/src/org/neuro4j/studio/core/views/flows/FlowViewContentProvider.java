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

package org.neuro4j.studio.core.views.flows;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.neuro4j.studio.core.util.AbstractEntry;
import org.neuro4j.studio.core.util.LogSession;

public class FlowViewContentProvider implements ITreeContentProvider {
	private FlowsListView logView;

	public FlowViewContentProvider(FlowsListView logView) {
		this.logView = logView;
	}

	public void dispose() { // do nothing
	}

	public Object[] getChildren(Object element) {
		return ((AbstractEntry) element).getChildren(element);
	}

	public Object[] getElements(Object element) {
		return logView.getElements();
	}

	public Object getParent(Object element) {
		if (element instanceof LogSession) {
			return null;
		}
		return ((AbstractEntry) element).getParent(element);
	}

	public boolean hasChildren(Object element) {
		return ((AbstractEntry) element).getChildren(element).length > 0;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { // do nothing
	}

	public boolean isDeleted(Object element) {
		return false;
	}
}
