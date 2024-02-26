package com.coe692.workwise.utils;

import java.util.HashMap;
import java.util.Map;

public class URLSearchParams {
    public static String formatQueryParams(Map<String, String> map) {
        StringBuilder queryString = new StringBuilder();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (queryString.length() > 0) {
                queryString.append("&");
            }
            queryString.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue());
        }

        return queryString.toString();
    }

    public static Map<String, String> extractQueryParams(String url) {
        Map<String, String> queryParams = new HashMap<>();

        try {
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                String[] params = query.split("&");
                for (String param : params) {
                    String[] keyValue = param.split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = keyValue[1];
                        queryParams.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return queryParams;
    }

    public static String formatURL(String root, String queryParams) {
        return root + "?" + queryParams;
    }
}
