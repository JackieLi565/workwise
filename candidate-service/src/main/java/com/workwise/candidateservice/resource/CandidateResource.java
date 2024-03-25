package com.workwise.candidateservice.resource;

import com.google.gson.Gson;
import com.workwise.candidateservice.model.User;
import com.workwise.candidateservice.repository.UserRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.Optional;

@Path("/candidates")
public class CandidateResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@QueryParam("email") String email) {
        try {
            if (email == null) return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Email query param not provided")
                    .build();

            Optional<User> userOptional = new UserRepository().findByEmail(email);

            if (userOptional.isEmpty()) return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("No User Found")
                    .build();

            User user = userOptional.get();
            Gson gson = new Gson();

            String jsonPayload = gson.toJson(user);
            return Response.ok().entity(jsonPayload).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).entity(e.toString()).build();
        }
    }
}
