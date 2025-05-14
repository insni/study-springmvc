package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
      @Override
      public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            Map<String, Object> errorMessages = new HashMap<>();
            String acceptHeader = request.getHeader("Accept");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

            try {
                  if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
                        return new ModelAndView("error-view");
                  } else if (acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE)) {
                        response.getWriter().write(ex.getMessage());
                        return new ModelAndView();
                  }
                  if (ex instanceof RuntimeException) {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
                        return new ModelAndView();
                  }
            } catch (IOException e) {
                  errorMessages.put("message2", ex.getMessage());
            } finally {
                  errorMessages.put("message", ex.getMessage());
            }
            return null;
      }
}
