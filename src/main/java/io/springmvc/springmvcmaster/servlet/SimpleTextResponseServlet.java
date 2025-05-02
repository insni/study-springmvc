package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "simpleTextResponseServlet", urlPatterns = "/textResponse")
public class SimpleTextResponseServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);
//            set response content type
            resp.setContentType("text/plain;charset=UTF-8");
//            write response body
            PrintWriter writer = resp.getWriter();
            writer.write("This is a text response");
            writer.write("Hello, this is a plain response");
            writer.close();


      }

}
