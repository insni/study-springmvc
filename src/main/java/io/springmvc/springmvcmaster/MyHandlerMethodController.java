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
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/handler")
@RequiredArgsConstructor
public class MyHandlerMethodController {
      private final MyService myService;

      @ResponseBody
      @GetMapping("/method")
      public void handlerMethodInvoke(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse
      ) throws Exception {
            Method method=myService.getClass().getMethod("processRequest", User.class);
            InvocableHandlerMethod invocableHandlerMethod= new InvocableHandlerMethod(
                        myService,method);
            // set argument resolve using for explain parameter of service method
            HandlerMethodArgumentResolverComposite handlerMethodArgumentResolverComposite=new HandlerMethodArgumentResolverComposite();
            handlerMethodArgumentResolverComposite.addResolver(new MyArgumentResolver());
            invocableHandlerMethod.setHandlerMethodArgumentResolvers(handlerMethodArgumentResolverComposite);

            // gen obj to req process
            ServletWebRequest servletWebRequest=new ServletWebRequest(
                        httpServletRequest,httpServletResponse);
            // need to save in model data
            ModelAndViewContainer mavContainer=new ModelAndViewContainer();
            // call service
            Object result=invocableHandlerMethod.invokeForRequest(servletWebRequest,mavContainer);

            // print response to result
             httpServletResponse.getWriter()
                        .write(result.toString());

      }
}
