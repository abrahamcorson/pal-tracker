package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeEntryController {

    private TimeEntryRepository repo;

    public TimeEntryController(TimeEntryRepository repo)    {
        this.repo = repo;
    }

//    @RequestMapping
//    public TimeEntry read()   {
//        return null;
//    }
//
    @PostMapping("/time-entries")
    @ResponseBody
    public ResponseEntity create(@RequestBody TimeEntry te) {
        TimeEntry toCreate = repo.create(te);
        return new ResponseEntity(toCreate, HttpStatus.CREATED);
    }

    @PutMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry te) {

        TimeEntry toUpdate = repo.update(id, te);
        if (toUpdate == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable long id)   {
        repo.delete(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/time-entries")
    @ResponseBody
    public ResponseEntity list()    {
        return new ResponseEntity(repo.list(), HttpStatus.OK);
    }


    @GetMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity read(@PathVariable long id)    {

        TimeEntry te = repo.find(id);

        if (te!=null) {

            return new ResponseEntity(te, HttpStatus.OK);
        }
        else return new ResponseEntity(te, HttpStatus.NOT_FOUND);
    }

}
