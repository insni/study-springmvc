package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "setHeaderServlet", urlPatterns = "/setHeaderExample")
public class SetHeaderServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);
            resp.setHeader("X-Custom-Header","CustomValue");
            resp.getWriter().write("Header: X-Custom-Header=CustomValue");
      }
}
