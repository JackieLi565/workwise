package com.workwise.jobservice.resource;

import com.google.gson.Gson;
import com.workwise.jobservice.repository.JobRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;

@Path("/jobs")
public class JobResource {
    @GET
    @Produces("application/json")
    public String hello() {
        Gson g = new Gson();
        JobRepository j = new JobRepository();
        String jobJson;
        try {
            jobJson = g.toJson(j.findAll());
            return jobJson;
        } catch (SQLException e) {
            return "Error";
        }
    }
}