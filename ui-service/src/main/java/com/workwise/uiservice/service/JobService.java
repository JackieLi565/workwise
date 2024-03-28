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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JobService {
    private static final String ROOT = "http://localhost:8083/job-service/api";
    public static Optional<Map<String, Job>> getJobs(String keyword, String loc) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(String.format("%s/jobs", ROOT)).newBuilder();
        if (keyword != null) urlBuilder.addQueryParameter("title", keyword);
        if (loc != null) urlBuilder.addQueryParameter("loc", loc);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful() && response.body() != null) {
            String json = response.body().string();
            Gson gson = new Gson();

            Type type = new TypeToken<ArrayList<Job>>(){}.getType();
            ArrayList<Job> jobs = gson.fromJson(json, type);
            Map<String, Job> map = new HashMap<>();
            for (Job job : jobs) {
                map.put(job.getId(), job);
            }
            return Optional.of(map);
        }

        return Optional.empty();
    }
}
