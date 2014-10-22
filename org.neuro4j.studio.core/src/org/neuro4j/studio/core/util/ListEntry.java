package org.neuro4j.studio.core.util;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.eclipse.core.resources.IFile;

/**
 * Represents a given entry in the List view
 */
public class ListEntry extends AbstractEntry {

    private String pluginId;
    private Date fDate;
    private String message;
    private ListEntryType type;

    /**
     * Constructor
     */
    public ListEntry() {
        // do nothing
    }

    /**
     * Constructor - creates a new entry from the given status
     * 
     * @param status
     *        an existing status to create a new entry from
     */
    public ListEntry(IFile file) {
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

    @Override
    public String toString() {
        return message;
    }

    public ListEntryType getType() {
        return type;
    }

    public void setType(ListEntryType type) {
        this.type = type;
    }
    
    
}
