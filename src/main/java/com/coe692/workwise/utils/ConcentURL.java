package com.coe692.workwise.utils;

import java.util.HashMap;
import java.util.Map;

public class ConcentURL {
    private static final String ROOT = "https://accounts.google.com/o/oauth2/v2/auth";
    public static String URL() {
        Map<String, String> options = new HashMap<>();
        options.put("redirect_uri", System.getenv("REDIRECT_URL"));
        options.put("client_id", System.getenv("CLIENT_ID"));
        options.put("access_type", "offline");
        options.put("response_type", "code");
        options.put("prompt", "consent");
        options.put("scope", "https://www.googleapis.com/auth/userinfo.email");

        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            if (queryString.length() > 0) {
                queryString.append("&");
            }
            queryString.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue());
        }
        return ROOT + "?" + queryString.toString();
    }

    public static void main(String[] args) {
        System.out.println(URL());
    }
}
