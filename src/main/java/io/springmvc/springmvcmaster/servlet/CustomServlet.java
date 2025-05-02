package io.springmvc.springmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "customServlet", urlPatterns = {"/custom"}, loadOnStartup = 1)
public class CustomServlet extends HttpServlet {
      public CustomServlet() {
            super(); // 객체 생성

      }
      @Override
      public void init() throws ServletException {
            super.init(); // 초기화 작업 수행

      }
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.getWriter().println("Hello from customServlet!"); // GET 요청 처리
      }

      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.getWriter().println("Hello from customServlet!"); // POST 요청 처리
      }
      @Override
      public void destroy() {
            super.destroy(); // 서블릿 종료 시 작업 수행
      }
}
