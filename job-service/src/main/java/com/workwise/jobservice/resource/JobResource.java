package com.workwise.jobservice.resource;

import com.google.gson.Gson;
import com.workwise.jobservice.repository.JobRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jobs")
public class JobResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobs(@QueryParam("title") String title, @QueryParam("loc") String loc) {
        Boolean hasTitle = title != null, hasLoc = loc != null;
        if (hasTitle) title = title.replace("+", " ");
        if (hasLoc) loc = loc.replace("+", " ");

        Gson gson = new Gson();
        return Response.status(Response.Status.OK).entity(gson.toJson(JobRepository.findByFilter(title, loc))).build();
    }
}