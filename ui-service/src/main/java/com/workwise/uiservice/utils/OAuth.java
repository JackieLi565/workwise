package com.workwise.uiservice.utils;

import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;

import java.util.*;

public class OAuth {
    public String getClientRequestURL(String state) {
        AuthorizationRequestUrl url = this.getAuthURL().set("state", state);
        return url.build();
    }

    public String getClientRequestURL() {
        AuthorizationRequestUrl url = this.getAuthURL();
        return url.build();
    }

    private AuthorizationRequestUrl getAuthURL() {
        String root = "https://accounts.google.com/o/oauth2/v2/auth";

        AuthorizationRequestUrl url = new AuthorizationRequestUrl(root, System.getenv("CLIENT_ID"), List.of("code"))
                .setRedirectUri(System.getenv("REDIRECT_URL"))
                .setScopes(List.of("https://www.googleapis.com/auth/userinfo.email"))
                .set("access_type", "offline")
                .set("promt", "concent");

        return url;
    }
}
