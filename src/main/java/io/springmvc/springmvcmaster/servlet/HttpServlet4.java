package io.springmvc.springmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "HelloServlet4", urlPatterns = "/servlet4")
public class HttpServlet4 extends jakarta.servlet.http.HttpServlet {
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            super.doGet(req, resp);

            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = request.getReader()) {
                  String line;
                  while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                  }
            }
            String requestBody = stringBuilder.toString();
            response.setContentType("application/json");
            String jsonRequestBody= new ObjectMapper().writeValueAsString(
                        Map.of("Received Plain Text", requestBody
                                    , "Processed Plain Text", requestBody
                        ));
            response.getWriter().write(jsonRequestBody);
      }
}
