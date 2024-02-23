package com.coe692.workwise.utils;

import java.util.Map;

public class QueryStringBuilder {
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

    public static String formatURL(String root, String queryParams) {
        return root + "?" + queryParams;
    }
}
