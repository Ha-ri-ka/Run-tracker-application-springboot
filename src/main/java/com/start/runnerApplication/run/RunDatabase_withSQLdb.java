package com.start.runnerApplication.run;



import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Repository
public class RunDatabase_withSQLdb
{
    private final JdbcClient jdbcClient;

    public RunDatabase_withSQLdb(JdbcClient jdbcClient) {   this.jdbcClient = jdbcClient;  }

    //return all runs: GET
    List<Run> findAll()
    {
        return jdbcClient.sql("select * from run").query(Run.class).list();
    }

    //getByID: GET
    Optional<Run> findById(Integer id)
    {
        return jdbcClient.sql("select * from run where run.id=:id").param("id",id).query(Run.class).optional(); //:id signifies named parameters
    }

    //count number of tuples in DB: GET
    public int count()
    {
        return jdbcClient.sql("SELECT COUNT(*) FROM run").query().listOfRows().size();
    }

    //create new run: POST
    void create(Run run)
    {
        var data= jdbcClient.sql("INSERT INTO run VALUES (?,?,?,?,?,?)") //? are just placeholders
                .params(List.of(run.Id(),run.title(),run.started(),run.ended(),run.distance(),run.location().toString()))
                .update(); //returns how many rows are updated
        Assert.state(data==1,"Failed to create run "+run.title()); //this is to check if exactly one row has been updated. If not, the error message the displayed
    }
    //update run by id: PUT
    void update(Run run, Integer id)
    {
        var updated= jdbcClient.sql("UPDATE run set title= ? ,started= ? ,ended= ? ,distance= ? ,location= ? where Id= ?")
                .params(List.of(run.title(),run.started(),run.ended(),run.distance(),run.location().toString(),id))
                .update();
        Assert.state(updated==1,"Failed to update run "+ id);
    }
    //delete a run by ID: DELETE
    void delete(Integer id)
    {
        var del=jdbcClient.sql("DELETE FROM run where id= :id").param("id",id).update();
        Assert.state(del==1,"Failed to update run "+id);
    }
}
