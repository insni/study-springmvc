package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {
      private final static ThreadLocal<String>
                  requestHolder = new ThreadLocal<>();

      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HandlerInterceptor.super.preHandle(request, response, handler);
            // gen req id
            String reqId = UUID.randomUUID().toString();
            // save req id
            requestHolder.set(reqId);
            log.info("req id[{}] - rehnadle: string reqr[{} {}]", reqId, request.getMethod(), request.getRequestURI());
            return true;

      }

      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            // get req id from thread local
            String reqId = requestHolder.get();
            log.info("req id[{}] - post handle: string reqr[{} {}]", reqId, request.getMethod(), request.getRequestURI());
      }

      @Override
      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            // get req id from thread local
            String reqId = requestHolder.get();
            if (ex == null)
                  log.info("req id [{}] - after completion: req completed success", reqId);
            else
                  log.error("req id [{}] - after completion: req completed failed", reqId, ex);

            // 비우기 thread local
            requestHolder.remove();
      }
}
