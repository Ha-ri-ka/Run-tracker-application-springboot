package com.start.runnerApplication.run;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController_withSQLdb {

    private final RunDatabase_withSQLdb runDatabase;

    public RunController_withSQLdb(RunDatabase_withSQLdb runDb)
    {
        runDatabase=runDb;
    }

    //return all runs: GET
    @GetMapping("")
    List<Run> findAll()
    {
        return runDatabase.findAll();
    }

    //getByID: GET
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id)
    {
        Optional<Run> run=runDatabase.findById(id);
        if (run.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    //create new run: POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run)
    {
        runDatabase.create(run);
    }

    //update run by id: PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run,@PathVariable Integer id)
    {
        runDatabase.update(run,id);
    }

    //delete a run by ID: DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id)
    {
        runDatabase.delete(id);
    }
}
