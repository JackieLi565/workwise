package com.workwise.authservice.resource;

import javax.ws.rs.*;

@Path("/health")
public class HealthResource {
    @GET
    @Produces("application/json")
    public String hello() {
        return "{ status: 'OK'}";
    }
}