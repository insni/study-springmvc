package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "setStatusServlet", urlPatterns = "/setStatusExample")
public class SetStatusServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED); // 202
            resp.getWriter().write("Response status set to 202 Accepted");
      }
}
