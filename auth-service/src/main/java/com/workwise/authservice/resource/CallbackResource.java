package com.workwise.authservice.resource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;
import com.workwise.authservice.model.ResponseTokens;
import com.workwise.authservice.model.User;
import com.workwise.authservice.service.CandidateService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Path("/callback")
public class CallbackResource {
    public static final String ROOT = "https://www.googleapis.com/oauth2/v4/token";
    public static final String SUCCESS_REDIRECT_URL = "http://localhost:8080/callback";
    @GET
    @Produces("application/json")
    public Response handleCallback(@QueryParam("code") String code) {
        /*
        * TODO
        *  - Determine register or login via state
        *  - Store refresh token to db
        * */
        try {
            TokenResponse response =
                    new AuthorizationCodeTokenRequest(new NetHttpTransport(), new GsonFactory(),
                            new GenericUrl(ROOT), code)
                            .setRedirectUri(System.getenv("REDIRECT_URL"))
                            .set("client_id", System.getenv("CLIENT_ID"))
                            .set("client_secret", System.getenv("CLIENT_SECRET"))
                            .execute();

            Gson gson = new Gson();
            ResponseTokens rt = gson.fromJson(response.toString(), ResponseTokens.class);
            String encodedJWT = rt.getId_token();
            DecodedJWT decodedJWT = JWT.decode(encodedJWT);
            String email = decodedJWT.getClaim("email").asString();

            Optional<User> userOptional = CandidateService.getUserByEmail(email);

            if (userOptional.isEmpty()) return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("No User Found")
                    .build();

            User user = userOptional.get();
            Map<String, String> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("email", user.getProvider().getEmail());
            map.put("firstName", user.getFirstName());
            map.put("lastName", user.getLastName());
            map.put("image", user.getImage());

            Algorithm algorithm = Algorithm.HMAC256(System.getenv("JWT_SECRET"));
            String token = JWT.create()
                    .withIssuer("workwise")
                    .withPayload(map)
                    .sign(algorithm);

            return Response.temporaryRedirect(new URI(SUCCESS_REDIRECT_URL + "?code=" + token))
                    .build();
        } catch (Exception e) {
            // TODO redirect to 500 error page on client

            if (e instanceof IOException) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .header("Content-type", "text/plain")
                        .entity(e.toString())
                        .build();
            }

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .header("Content-type", "text/plain")
                    .entity(e.toString())
                    .build();
        }
    }
}
