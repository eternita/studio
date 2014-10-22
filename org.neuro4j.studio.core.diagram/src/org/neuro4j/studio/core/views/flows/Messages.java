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

import org.eclipse.osgi.util.NLS;




public class Messages {

	public static String FlowView_AddingBatchedEvents;
    public static String FlowView_Title;
    public static String FlowView_GroupByNone;
    public static String FlowView_GroupBy;
    public static String FlowView_GroupByPlugin;
    public static String FlowView_GroupBySession;
    public static String FlowView_show_filter_initialText;
    public static String FlowView_column_message;
	public static String FlowView_column_plugin;
	public static String FlowView_column_date;
	
	
	public static String CustomBlockView_Title;
	public static String CustomBlockView_column_message;


    static {
        NLS.initializeMessages("org.neuro4j.studio.core.views.flows.messages", Messages.class); //$NON-NLS-1$
    }
    


}
