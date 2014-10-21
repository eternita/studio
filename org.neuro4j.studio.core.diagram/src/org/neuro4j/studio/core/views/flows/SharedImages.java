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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.neuro4j.studio.core.Neuro4jCorePlugin;

public final class SharedImages {

	private SharedImages() { // do nothing
	}

	public final static String ICONS_PATH = "icons/"; //$NON-NLS-1$

	private static final String PATH_OBJ = ICONS_PATH + "obj16/"; //$NON-NLS-1$
	private static final String PATH_LCL = ICONS_PATH + "elcl16/"; //$NON-NLS-1$
	private static final String PATH_LCL_DISABLED = ICONS_PATH + "dlcl16/"; //$NON-NLS-1$
	private static final String PATH_EVENTS = ICONS_PATH + "eview16/"; //$NON-NLS-1$

	/* Event Details */
	public static final String DESC_PREV_EVENT = PATH_EVENTS + "event_prev.gif"; //$NON-NLS-1$
	public static final String DESC_NEXT_EVENT = PATH_EVENTS + "event_next.gif"; //$NON-NLS-1$	

	public static final String DESC_CLEAR = PATH_LCL + "clear.gif"; //$NON-NLS-1$
	public static final String DESC_CLEAR_DISABLED = PATH_LCL_DISABLED + "clear.gif"; //$NON-NLS-1$
	public static final String DESC_REMOVE_LOG = PATH_LCL + "remove.gif"; //$NON-NLS-1$
	public static final String DESC_REMOVE_LOG_DISABLED = PATH_LCL_DISABLED + "remove.gif"; //$NON-NLS-1$
	public static final String DESC_EXPORT = PATH_LCL + "export_log.gif"; //$NON-NLS-1$
	public static final String DESC_EXPORT_DISABLED = PATH_LCL_DISABLED + "export_log.gif"; //$NON-NLS-1$
	public static final String DESC_FILTER = PATH_LCL + "filter_ps.gif"; //$NON-NLS-1$
	public static final String DESC_FILTER_DISABLED = PATH_LCL_DISABLED + "filter_ps.gif"; //$NON-NLS-1$
	public static final String DESC_IMPORT = PATH_LCL + "import_log.gif"; //$NON-NLS-1$
	public static final String DESC_IMPORT_DISABLED = PATH_LCL_DISABLED + "import_log.gif"; //$NON-NLS-1$
	public static final String DESC_OPEN_LOG = PATH_LCL + "open_log.gif"; //$NON-NLS-1$
	public static final String DESC_OPEN_LOG_DISABLED = PATH_LCL_DISABLED + "open_log.gif"; //$NON-NLS-1$
	public static final String DESC_PROPERTIES = PATH_LCL + "properties.gif"; //$NON-NLS-1$
	public static final String DESC_PROPERTIES_DISABLED = PATH_LCL_DISABLED + "properties.gif"; //$NON-NLS-1$
	public static final String DESC_READ_LOG = PATH_LCL + "restore_log.gif"; //$NON-NLS-1$
	public static final String DESC_READ_LOG_DISABLED = PATH_LCL_DISABLED + "restore_log.gif"; //$NON-NLS-1$

	public static final String DESC_ERROR_ST_OBJ = PATH_OBJ + "error_st_obj.gif"; //$NON-NLS-1$
	public static final String DESC_ERROR_STACK_OBJ = PATH_OBJ + "error_stack.gif"; //$NON-NLS-1$
	public static final String DESC_INFO_ST_OBJ = PATH_OBJ + "info_st_obj.gif"; //$NON-NLS-1$
	public static final String DESC_OK_ST_OBJ = PATH_OBJ + "ok_st_obj.gif"; //$NON-NLS-1$
	public static final String DESC_WARNING_ST_OBJ = PATH_OBJ + "warning_st_obj.gif"; //$NON-NLS-1$
	public static final String DESC_HIERARCHICAL_LAYOUT_OBJ = PATH_OBJ + "hierarchical.gif"; //$NON-NLS-1$

	public static ImageDescriptor getImageDescriptor(String key) {
		return Neuro4jCorePlugin.getDefault().getImageRegistry().getDescriptor(key);
	}

	public static Image getImage(String key) {
		return Neuro4jCorePlugin.getDefault().getImageRegistry().get(key);
	}

}
