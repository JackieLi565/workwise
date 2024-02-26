package com.coe692.workwise.utils;

import com.coe692.workwise.json.ResponseTokens;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

// RESOURCE: https://gist.github.com/balvinder294/ecf07defa363317ff92e0550e61e127d
public class OAuth {
    public static String getClientRequestURL(Optional<String> state) {
        String root = "https://accounts.google.com/o/oauth2/v2/auth";

        String url = new AuthorizationRequestUrl(root, System.getenv("CLIENT_ID"), List.of("code"))
                .setRedirectUri(System.getenv("REDIRECT_URL"))
                .setScopes(List.of("https://www.googleapis.com/auth/userinfo.email"))
                .set("access_type", "offline")
                .set("promt", "concent")
                .build();

        return url;
    }

    public static ResponseTokens getAccessTokens(String code) throws IOException {
        String root = "https://www.googleapis.com/oauth2/v4/token";

        TokenResponse response =
                new AuthorizationCodeTokenRequest(new NetHttpTransport(), new GsonFactory(),
                        new GenericUrl(root), code)
                        .setRedirectUri(System.getenv("REDIRECT_URL"))
                        .set("client_id", System.getenv("CLIENT_ID"))
                        .set("client_secret", System.getenv("CLIENT_SECRET"))
                        .execute();

        Gson gson = new Gson();

        return gson.fromJson(response.toString(), ResponseTokens.class);
    }
}
