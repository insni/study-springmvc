package io.springmvc.springmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "HelloServlet5", urlPatterns = "/servlet5")
public class HttpServlet5 extends HttpServlet {

      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            Map requestBody = objectMapper.readValue(request.getReader(), Map.class);

            Map<String, Object> responseBody = Map.of(
                        "status", "success",
                        "received", requestBody
            );
            response.setContentType("application/json");
            response.getWriter().write(objectMapper.writeValueAsString(responseBody));
      }
}
