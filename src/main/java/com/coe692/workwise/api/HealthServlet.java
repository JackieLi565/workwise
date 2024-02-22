package com.coe692.workwise.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

@WebServlet(name = "HealthServlet", urlPatterns = {"/api/health"})
public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject res = new JSONObject();
        res.put("status", "OK");
        Dotenv dotenv = Dotenv.load();
        String test = dotenv.get("CLIENT_SECRET");
        response.setContentType("application/json");
        response.getWriter().print(test);
    }

}
