package io.springmvc.springmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "HttpServlet1", urlPatterns = "/servlet1")
public class HttpServlet1 extends HttpServlet {

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> responseBody = new HashMap<>();
            resp.setContentType("application/json");

//             header
            responseBody.put("User-Agent", req.getHeader("User-Agent"));


            StringBuilder accpetLanguaesBuilder = new StringBuilder();
//            headers
            req.getHeaders("Accept-Language").asIterator()
                        .forEachRemaining(header->
                                    accpetLanguaesBuilder.append("- " + header + ", "));
            responseBody.put("Accept-Language", accpetLanguaesBuilder.toString());


            StringBuilder headerNamesBuilder = new StringBuilder();
            req.getHeaderNames().asIterator().forEachRemaining(header->headerNamesBuilder.append("- " + header + ", "));
            responseBody.put("Header-Names", headerNamesBuilder.toString());

            PrintWriter writer = resp.getWriter();
            String jsonResponseBody = objectMapper.writeValueAsString(responseBody);
            writer.write(jsonResponseBody);
      }

}
