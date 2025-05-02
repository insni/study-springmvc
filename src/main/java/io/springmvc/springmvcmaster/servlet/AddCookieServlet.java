package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddCookieServlet", urlPatterns = "/addCookieExample")
public class AddCookieServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException {

            Cookie cookie = new Cookie("userToken", "abcd1234");
            cookie.setMaxAge(3600);
            cookie.setPath("/"); // 중요! 모든 경로에서 접근 가능하도록
            resp.addCookie(cookie);
            resp.getWriter().write("Cookie added: userToken=abcd1234");
            // 절대 getWriter().write() 사용하지 말고 바로 redirect
//            resp.sendRedirect("/getRedirectExample");
      }
}
