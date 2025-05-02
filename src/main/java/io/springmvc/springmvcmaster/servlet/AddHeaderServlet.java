package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "addHeaderServlet", urlPatterns = "/addHeaderExample")
public class AddHeaderServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);
            resp.setHeader("X-Additional-Header","AdditionalValue");
            resp.getWriter().write("Header: X-Additional-Header=AdditionalValue");
      }
}
