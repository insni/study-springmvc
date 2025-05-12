package io.springmvc.springmvcmaster;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MyArgumentResolver implements HandlerMethodArgumentResolver {

      @Override
      public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameterType().equals(User.class);
      }

      @Override
      public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            User user=new User();
            user.setUsername(webRequest.getParameter("username"));
            String email = webRequest.getParameter("email");
            user.setEmail(email != null ? email : "");
            return user;
      }
}