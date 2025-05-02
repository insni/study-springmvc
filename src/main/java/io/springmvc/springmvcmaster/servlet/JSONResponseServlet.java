package io.springmvc.springmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "jsonResponseServlet", urlPatterns = "/jsonResponse")
public class JSONResponseServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

//            set response content type
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

//            generate user
            Map<String, String> user = Map.of("name", "John Doe",
                        "age", "30");

//            using to object mapper convert user obj to json type
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(user);

//            write response body
            PrintWriter writer=resp.getWriter();
            writer.write(jsonResponse);
            writer.close();
      }
}
