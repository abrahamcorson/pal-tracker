package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry te);

    public TimeEntry find(long id) ;

    public TimeEntry update(long id, TimeEntry te);

    public void delete(long id);

    public List<TimeEntry> list() ;
}