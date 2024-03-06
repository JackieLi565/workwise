package com.coe692.workwise.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AuthorizationFilter implements Filter {
    private final Set<String> SECURE_PATH = new HashSet<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.SECURE_PATH.add("/jobs.jsp");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURL = httpRequest.getRequestURI();
        if (this.SECURE_PATH.contains(requestURL)) {
            String workwiseAuthCookie = httpRequest.getHeader("Cookie");
            if (workwiseAuthCookie != null && workwiseAuthCookie.contains("workwise-auth")) {
                chain.doFilter(request, response);
            } else {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.sendRedirect("/401");
            }
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
