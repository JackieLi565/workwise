package com.coe692.workwise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.coe692.workwise.dao.CandidateDAO;
import com.coe692.workwise.json.ResponseTokens;
import com.coe692.workwise.exception.NoDataException;
import com.coe692.workwise.model.Candidate;
import com.coe692.workwise.model.GoogleProvider;
import com.coe692.workwise.utils.OAuth;

@WebServlet(name = "CallbackServlet", urlPatterns = {"/callback"})
public class CallbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);

        try {
            if (code == null) throw new Exception("no code found");

            ResponseTokens accessToken = OAuth.getAccessTokens(code);
            String encodedJWT = accessToken.getId_token();

            DecodedJWT decodedJWT = JWT.decode(encodedJWT);
            String email = decodedJWT.getClaim("email").asString();
            Candidate candidate = (new CandidateDAO()).findByEmail(email);

            Cookie cookie = new Cookie("workwise-auth", encodedJWT);
            cookie.setMaxAge(2 * 60 * 60); // 2 hours
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            response.addCookie(cookie);
            response.sendRedirect("/jobs");
        } catch (Exception e) {
            if (e instanceof NoDataException) {
                response.sendRedirect("/register");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.sendRedirect("/500");
            }
        }
    }

}
