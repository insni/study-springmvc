package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Controller
@RequestMapping("/handler")
@RequiredArgsConstructor
public class MyHandlerMethodController2 {
      private final MyService myService;

      @ResponseBody
      @GetMapping("/method2")
      public void handlerMethodInvoke(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse
      ) throws Exception {
            Method method = myService.getClass().getMethod("processRequest", User.class);
            ServletInvocableHandlerMethod invocableHandlerMethod = new ServletInvocableHandlerMethod(
                        myService, method);

            invocableHandlerMethod.setHandlerMethodArgumentResolvers(getHandlerMethodArgumentResolverComposite());
            invocableHandlerMethod.setHandlerMethodReturnValueHandlers(getHandlerMethodReturnValueHandlerComposite());

            // gen obj to req process
            ServletWebRequest servletWebRequest = new ServletWebRequest(
                        httpServletRequest, httpServletResponse);
            // need to save in model data
            ModelAndViewContainer mavContainer = new ModelAndViewContainer();

            //call service method
            //java.lang.IllegalArgumentException: Unknown return value type: java.util.ImmutableCollections$Map1
            //	at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:76) ~[spring-web-6.2.2.jar:6.2.2]
            //	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:136) ~[spring-webmvc-6.2.2.jar:6.2.2]
            invocableHandlerMethod.invokeAndHandle(servletWebRequest, mavContainer);
            if (mavContainer.containsAttribute("result")) {
                  httpServletResponse.getWriter()
                              .write(mavContainer.getModel().get("result").toString());
            }


      }

      private static HandlerMethodArgumentResolverComposite getHandlerMethodArgumentResolverComposite() {
            HandlerMethodArgumentResolverComposite handlerMethodArgumentResolverComposite = new HandlerMethodArgumentResolverComposite();
            handlerMethodArgumentResolverComposite.addResolver(new MyArgumentResolver());
            return handlerMethodArgumentResolverComposite;
      }

      private static HandlerMethodReturnValueHandlerComposite getHandlerMethodReturnValueHandlerComposite() {
            HandlerMethodReturnValueHandlerComposite handlerMethodReturnValueHandlerComposite =
                        new HandlerMethodReturnValueHandlerComposite();
            handlerMethodReturnValueHandlerComposite.addHandler(new MyReturnValueHandler());
            return handlerMethodReturnValueHandlerComposite;
      }
}
