package com.workwise.candidateservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/health")
public class HealthResource {
    @GET
    @Produces("application/json")
    public String hello() {
        return "{ status: 'OK'}";
    }
}