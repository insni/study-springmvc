package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sendErrorServlet", urlPatterns = "/sendErrorExample")
public class SendErrorServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid Request");
      }
}
