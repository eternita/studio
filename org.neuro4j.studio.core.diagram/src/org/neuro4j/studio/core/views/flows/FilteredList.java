package org.neuro4j.studio.core.views.flows;

import java.util.Collection;
import java.util.LinkedList;

import org.neuro4j.studio.core.util.ListEntry;
import org.neuro4j.studio.core.util.ListEntryType;

public class FilteredList extends LinkedList<ListEntry>{
    
    ListEntryType type;
    
    public FilteredList(ListEntryType type) {
        super();
        this.type = type;
    }

    public FilteredList(ListEntryType type, Collection<? extends ListEntry> c) {
        super(c);
        this.type = type;
    }

    @Override
    public boolean add(ListEntry e) {
       if (type != e.getType())
       {
           return false;
       }
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends ListEntry> c) {
        // TODO:
        for (ListEntry entry: c){
            add(entry);
        }
        
        return true;
    }

    
    

}
