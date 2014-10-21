package org.neuro4j.studio.core.util;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.eclipse.core.resources.IFile;

/**
 * Represents a given entry in the Error view
 */
public class FlowEntry extends AbstractEntry {

    public static final String SPACE = " "; //$NON-NLS-1$
    public static final String F_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"; //$NON-NLS-1$
    private final DateFormat GREGORIAN_SDF = new SimpleDateFormat(F_DATE_FORMAT, Locale.ENGLISH);

    private String pluginId;
    private String fDateString;
    private Date fDate;
    private String message;

    /**
     * Constructor
     */
    public FlowEntry() {
        // do nothing
    }

    /**
     * Constructor - creates a new entry from the given status
     * 
     * @param status
     *        an existing status to create a new entry from
     */
    public FlowEntry(IFile file) {
        processStatus(file);
    }

    /**
     * Returns the id of the plugin that generated this entry
     * 
     * @return the plugin id of this entry
     */
    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    /**
     * Returns the message for this entry or <code>null</code> if there is no message
     * 
     * @return the message or <code>null</code>
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns a pretty-print formatting for the date for this entry
     * 
     * @return the formatted date for this entry
     */
    public String getFormattedDate() {
        if (fDateString == null) {
            fDateString = GREGORIAN_SDF.format(getDate());
        }
        return fDateString;
    }

    /**
     * Returns the date for this entry or the epoch if the current date value is <code>null</code>
     * 
     * @return the entry date or the epoch if there is no date entry
     */
    public Date getDate() {

        return fDate;
    }
    
    

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public void processStatus(IFile line) {
        if (fDate == null) {
            fDate = new Date(line.getLocalTimeStamp());
            fDateString = GREGORIAN_SDF.format(fDate);
        }
    }


    public void setMessage(String message) {
        this.message = message;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.internal.views.log.AbstractEntry#write(java.io.PrintWriter)
     */
    public void write(PrintWriter writer) {

        // writer.println(getSeverityText());
        if (fDate != null) {
            writer.println(getDate());
        }
        if (message != null) {
            writer.println(getMessage());
        }
    }
}
