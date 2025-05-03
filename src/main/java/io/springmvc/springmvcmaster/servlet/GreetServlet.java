package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GreetServlet", urlPatterns = "/greet")
public class GreetServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            if (name == null || name.isEmpty()) {
                  name = "World";
            }
            request.setAttribute("name", name);
            request.getRequestDispatcher("/greetResponse").forward(request, response);
      }

}
