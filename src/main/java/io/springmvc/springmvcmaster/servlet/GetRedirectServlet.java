package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getRedirectServlet", urlPatterns = "/getRedirectExample")
public class GetRedirectServlet extends HttpServlet {

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

            PrintWriter out = resp.getWriter();
            Cookie[] cookies = req.getCookies();

            StringBuilder json = new StringBuilder("[\n");

            for (int i = 0; i < cookies.length; i++) {
                  Cookie cookie = cookies[i];
                  json.append("  {\n")
                              .append("    \"name\": \"").append(cookie.getName()).append("\",\n")
                              .append("    \"value\": \"").append(cookie.getValue()).append("\",\n")
                              .append("    \"path\": \"").append(cookie.getPath()).append("\",\n")
                              .append("    \"domain\": \"").append(cookie.getDomain()).append("\",\n")
                              .append("    \"maxAge\": ").append(cookie.getMaxAge()).append(",\n")
                              .append("    \"secure\": ").append(cookie.getSecure()).append(",\n")
                              .append("    \"httpOnly\": ").append(cookie.isHttpOnly()).append(",\n")
                              .append("    \"version\": ").append(cookie.getVersion()).append("\n")
                              .append("  }");

                  if (i < cookies.length - 1) json.append(",");
                  json.append("\n");
            }

            json.append("]");

            out.write(json.toString());
      }
}
