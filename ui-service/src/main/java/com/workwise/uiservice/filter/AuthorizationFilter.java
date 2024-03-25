package com.workwise.uiservice.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.workwise.uiservice.utils.Validate;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AuthorizationFilter implements Filter {
    private final Set<String> SECURE_PATH = new HashSet<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.SECURE_PATH.add("/jobs");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String cookieHeader = httpRequest.getHeader("Cookie");
        String uri = httpRequest.getRequestURI();

        if (this.SECURE_PATH.contains(uri)) {
            if (cookieHeader.contains("workwise")) {
                Cookie[] cookies = httpRequest.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("workwise")) {
                        String encodedJWT = cookie.getValue();
                        Optional<DecodedJWT> decodedJWTOption = Validate.jwt(encodedJWT);

                        if (decodedJWTOption.isEmpty())
                            httpResponse.sendRedirect("/");
                    }
                }
            } else {
                httpResponse.sendRedirect("/");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
