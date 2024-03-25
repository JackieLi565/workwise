package com.workwise.authservice.service;

import com.google.gson.Gson;
import com.workwise.authservice.model.User;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

public class CandidateService {
    private static final String ROOT = "http://localhost:8082/candidate-service/api";
    public static Optional<User> getUserByEmail(String email) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("%s/candidates", ROOT)).newBuilder();
        urlBuilder.addQueryParameter("email", email);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful() && response.body() != null) {
            String json = response.body().string();
            Gson gson = new Gson();

            return Optional.of(gson.fromJson(json, User.class));
        }

        return Optional.empty();
    }
}
