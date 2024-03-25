package com.workwise.uiservice.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CallbackServlet", urlPatterns = {"/callback"})
public class CallbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        if (code != null) {
            System.out.println("Received code: " + code);
            Cookie cookie = new Cookie("workwise", code);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(3600);

            response.addCookie(cookie);
            response.sendRedirect("/jobs");
            return;
        }
        response.sendRedirect("/");
    }
}
