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

package org.neuro4j.studio.core.util;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Group of entries with additional Session data.
 */
public class LogSession extends Group {

	/**
	 * Describes the !SESSION header name
	 * 
	 * @since 3.5
	 */
	public static final String SESSION = "!SESSION"; //$NON-NLS-1$
	private String sessionData;
	private Date date;

	public LogSession() {
		super(null);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //$NON-NLS-1$
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) { // do nothing
		}
	}

	public String getSessionData() {
		return sessionData;
	}

	void setSessionData(String data) {
		this.sessionData = data;
	}

	public void processLogLine(String line) {
		// process "!SESSION <dateUnknownFormat> ----------------------------"
		if (line.startsWith(SESSION)) {
			line = line.substring(SESSION.length()).trim(); // strip "!SESSION "
			int delim = line.indexOf("----"); //$NON-NLS-1$ // single "-" may be in date, so take few for sure
			if (delim == -1) {
				return;
			}
			String dateBuffer = line.substring(0, delim).trim();
			setDate(dateBuffer);
		}
	}

	public void write(PrintWriter writer) {
		writer.write(sessionData);
		writer.println();
		super.write(writer);
	}

}
