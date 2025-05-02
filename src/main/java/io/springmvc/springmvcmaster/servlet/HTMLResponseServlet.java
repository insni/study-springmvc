package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "htmlResponseServlet", urlPatterns = "/htmlResponse")
public class HTMLResponseServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

//            set response content type
            resp.setContentType("text/html;charset=UTF-8");

//            write response body
            PrintWriter writer=resp.getWriter();
            writer.write("<!DOCTYPE html>");
            writer.write("<html><head><title>HTML Response</title></head>");
            writer.write("<body>");
            writer.write("<h1>Welcome to the HTML Response</h1>");
            writer.write("<p>This is an HTML response.</p>");
            writer.write("</body></html>");
            writer.close();
      }
}
