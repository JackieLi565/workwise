package com.coe692.workwise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name = "HealthServlet", urlPatterns = {"/Health"})
public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject res = new JSONObject();
        res.put("status", "OK");

        response.setContentType("application/json");
        response.getWriter().print(res.toString());
    }

}
