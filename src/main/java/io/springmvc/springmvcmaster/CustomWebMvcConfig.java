package io.springmvc.springmvcmaster;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

@Configuration
public class CustomWebMvcConfig implements
            WebMvcConfigurer {

      @Override
      public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
            WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
            resolvers.add(simpleMappingExceptionResolver());
      }
      public MockSimpleMappingExceptionResolver simpleMappingExceptionResolver() {
            MockSimpleMappingExceptionResolver simpleMappingExceptionResolver = new MockSimpleMappingExceptionResolver();

//             map exception and view name
            Properties resolverExceptionMappings=new Properties();

//            resolverExceptionMappings.put("java.lang.ArithmeticException","errorArithmetic");
//            resolverExceptionMappings.put("java.lang.NullPointerException","errorNullPointer");

//             does not have view(.html, .jsp)
            resolverExceptionMappings.put("java.lang.ArithmeticException","/errorArithmetic");
            resolverExceptionMappings.put("java.lang.NullPointerException","/errorNullPointer");

            simpleMappingExceptionResolver.setExceptionMappings(resolverExceptionMappings);

            // default view when does not havee view
            simpleMappingExceptionResolver.setDefaultErrorView("error-default");

            // map view name and http status code
            Properties resolverStatusCode=new Properties();
            resolverStatusCode.put("errorArithmetic","400");
            resolverStatusCode.put("errorNullPointer","500");
            simpleMappingExceptionResolver.setStatusCodes(resolverStatusCode);
            return simpleMappingExceptionResolver;
      }
}
