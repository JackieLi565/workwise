package com.coe692.workwise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.coe692.workwise.database.UserData;
import com.coe692.workwise.json.ResponseTokens;
import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.utils.OAuth;

@WebServlet(name = "CallbackServlet", urlPatterns = {"/callback"})
public class CallbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setStatus(302);

        try {
            if (code == null) throw new Exception("no code found");

            ResponseTokens accessToken = OAuth.getAccessTokens(code);

            DecodedJWT jwt = JWT.decode(accessToken.getId_token());
            String email = jwt.getClaim("email").asString();

            UserData.getUserByEmail(email);
            response.sendRedirect("jobs.jsp");
        } catch (Exception e) {
            if (e instanceof NoDataException) {
                response.sendRedirect("/register");
            } else {
                response.sendRedirect("/500");
            }
        }
    }

}
