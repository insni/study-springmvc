package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Component
public class MockSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

      @Override
      protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            return super.doResolveException(request, response, handler, ex);
      }

      @Override
      public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            return super.resolveException(request, response, handler, ex);
      }
}
