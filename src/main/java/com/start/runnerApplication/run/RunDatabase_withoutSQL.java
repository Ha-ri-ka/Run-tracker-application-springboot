package com.start.runnerApplication.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunDatabase {
    private List<Run> runs= new ArrayList<>();
    List <Run> allRuns() //method to return all runs in the database
    {
            return runs;
    } //part of GET operation

    Optional<Run> findByid(Integer id)
    {
        return runs.stream().filter(run -> run.Id()==id).findFirst();
    } //part of GET operation

    void create(Run run)
    {
        runs.add(run);
    }

    void update(Run run,Integer id)
    {
        Optional<Run> existingRun=findByid(id);
        if (existingRun.isPresent())
        {
            //existingRun= Optional.ofNullable(run); //experimenting with update //this doesn't work lol
              runs.set(runs.indexOf(existingRun.get()),run);
        }
    }

    void delete(Integer id)
    {
        runs.removeIf(run->run.Id().equals(id));
    }

    @PostConstruct
    private void init()
    {
        runs.add(new Run(1,"endpoint sesh", LocalDateTime.now(),LocalDateTime.now().plus(30, ChronoUnit.MINUTES),3,Location.OUTDOOR));
        runs.add(new Run(2,"arbi falls sesh", LocalDateTime.now(),LocalDateTime.now().plus(45, ChronoUnit.MINUTES),10,Location.OUTDOOR));
    }
}





