package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class UserRoleInterceptor implements HandlerInterceptor {
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if (handler instanceof HandlerMethod) {
                  HandlerMethod handlerMethod = (HandlerMethod) handler;
                  String controllerName = handlerMethod.getBeanType().getName();
                  String methodName = handlerMethod.getMethod().getName();


                        String userRole = request.getHeader("Role");
                        if ( !userRole.equals("USER")) {
                              response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                              response.getWriter().write("Access Denied");
                              return false;

                  }
                  System.out.println("controller: " + controllerName + ", method: " + methodName);
            }
            return true;
      }

      //  view name user name
      // get username at model attribute
      // set role and add role
      @Override
      public void postHandle(HttpServletRequest
                                         request, HttpServletResponse response, Object handler,
                             @Nullable ModelAndView modelAndView) throws Exception {

            if (modelAndView != null) {
                  String viewName = modelAndView.getViewName();

                  if ("userProfile".equals(viewName)) {
                        Map<String, Object> model = modelAndView.getModel();

                        if (model.containsKey("username")) {
                              String username = (String) model.get("username");
                              String role;
                              if ("user".equalsIgnoreCase(username)) {
                                    role = "User";
                              } else if ("guest".equalsIgnoreCase(username)) {
                                    role = "Guest";
                              } else {
                                    role = "Anonymous";
                              }
                              modelAndView.addObject("role", role);
                        }

                  }
            }


      }

      @Override
      public void afterCompletion(HttpServletRequest
                                              request, HttpServletResponse response, Object handler, Exception ex) throws
                  Exception {
            System.out.println("after completion: request completed");
      }
}
