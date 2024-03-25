package com.workwise.uiservice.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.workwise.uiservice.model.Job;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Optional;

public class JobService {
    private static final String ROOT = "http://localhost:8083/job-service/api";
    public static Optional<Map<String, Job>> getJobs() throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("%s/jobs", ROOT)).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful() && response.body() != null) {
            String json = response.body().string();
            Gson gson = new Gson();

            Type type = new TypeToken<Map<String, Job>>(){}.getType();
            return Optional.of(gson.fromJson(json, type));
        }

        return Optional.empty();
    }
}
