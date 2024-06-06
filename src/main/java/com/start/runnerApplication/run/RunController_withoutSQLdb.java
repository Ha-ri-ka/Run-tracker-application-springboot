//package com.start.runnerApplication.run;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController //enables this class to respond to requests.
//@RequestMapping("/api/runs") //we place a mapping at the controller level so that we don't have to specify a path for each of the subsequent methods. they will all be after runs/..whatever is in THEIR path
//
//public class RunController_withoutSQLdb {
//    private final RunDatabase_withoutSQL runDatabase; //create an instance of the DB class so that we can access its methods and variables
//    public RunController_withoutSQLdb(RunDatabase_withoutSQL runDatabase)
//    {   this.runDatabase=runDatabase;   }
//
//    //THIS IS A GET OPERATION
//    @GetMapping("")
//    List<Run> findAll()
//    {
//        return runDatabase.allRuns();
//    }
//    //THIS IS A GET OPERATION
//    @GetMapping("/{id}")
//    Run findByid(@PathVariable Integer id) //path variable picks up the {id} specified in the PATH!!
//    {
//        Optional<Run> run=runDatabase.findByid(id);
//        if(run.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND); //if we try to retrieve an ID that doesn't exist, you will see not found as the error instead of smth that u cannot understand like an error code
//        }
//        return run.get(); //run here is an Optional variable. get() method extracts the value from several other things present in the object.
//    }
//
//    //CREATE-->POST
//    //we are CREATING a new run
//    //when we use this method WITHOUT responseStatus, you just see a response code of 200 which isn't informative. so to have a meaningful response, we use thw annotation
//    @ResponseStatus(HttpStatus.CREATED) //NOW you will see 201 CREATED as the response
//    @PostMapping("")
//    //valid ensures that the object passed in is valid based on the constraints we have added in the run record
//    void create(@Valid @RequestBody Run run) //we need to tell the controller that the run in this param is coming from the request body
//    {
//        runDatabase.create(run);
//    }
//
//    //UPDATE-->PUT
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    void update(@Valid @RequestBody Run run, @PathVariable Integer id)
//    {
//        runDatabase.update(run,id);
//    }
//    //DELETE-->DELETE
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    void delete(@PathVariable Integer id)
//    {
//        runDatabase.delete(id);
//    }
//}
