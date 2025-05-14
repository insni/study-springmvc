package io.springmvc.springmvcmaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

      @Override
      public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
            WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
            CustomHandlerExceptionResolver customHandlerExceptionResolver = new CustomHandlerExceptionResolver();
            resolvers.add(customHandlerExceptionResolver);
      }


}
