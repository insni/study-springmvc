package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "HelloServlet3", urlPatterns = "/servlet3")
public class HttpServlet3 extends jakarta.servlet.http.HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

            resp.setContentType("text/plain");
            resp.getWriter().println("process url req parameter");
            String urlParameter = req.getParameter("urlParameter");
            resp.getWriter().println("url parameter: " + urlParameter);

            String[] URLAllParamter = req.getParameterValues("hobby");
            resp.getWriter().println("all parameter: " + URLAllParamter);
            if (URLAllParamter != null) {
                  for (String paramterI: URLAllParamter) {
                        resp.getWriter().println("hobby: " + paramterI);
                  }
            }

            Map<String, String[]> allParameter = req.getParameterMap();
            allParameter.forEach((key, value) -> {
                  try {
                        resp.getWriter().println(key + ": " + value[0]);
                  } catch (IOException e) {
                        throw new RuntimeException(e);
                  }
            });

      }
}
