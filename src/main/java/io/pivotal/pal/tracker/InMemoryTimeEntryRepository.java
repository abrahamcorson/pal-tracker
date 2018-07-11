package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long,TimeEntry> repo;


    public InMemoryTimeEntryRepository()    {

        repo = new HashMap<Long,TimeEntry>();
    }

    public TimeEntry create(TimeEntry te)  {

        te.setId(repo.size() + 1);
        repo.put(te.getId(), te);

        return te;
    }

    public TimeEntry find(long id) {

        if (!repo.containsKey(id))  {
            return null;
        }
        return repo.get(id);
    }

    public TimeEntry update(long id, TimeEntry te) {

        if (!repo.containsKey(id))  {
            return null;
        }

        TimeEntry toUpdate = repo.get(id);
        toUpdate.setUserId(te.getUserId());
        toUpdate.setDate(te.getDate());
        toUpdate.setHours(te.getHours());
        toUpdate.setProjectId(te.getProjectId());

        return toUpdate;
    }

    public void delete(long id) {

        repo.remove(id);

    }

    public List<TimeEntry> list()   {
        List<TimeEntry> list = new ArrayList<TimeEntry>();
        for (TimeEntry e : repo.values()) {
            list.add(e);
        }
        return list;
    }
}
