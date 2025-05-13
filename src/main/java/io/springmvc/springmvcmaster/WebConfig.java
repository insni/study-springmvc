package io.springmvc.springmvcmaster;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

      private final AdminRoleInterceptor adminRoleInterceptor;
      private final UserRoleInterceptor userRoleInterceptor;
      private final LoggingInterceptor loggingInterceptor;

      @Override
      public void addInterceptors(InterceptorRegistry registry) {
            WebMvcConfigurer.super.addInterceptors(registry);
            registry.addInterceptor(adminRoleInterceptor)
                        .order(2)
                        .addPathPatterns("/admin")
                        .excludePathPatterns("/user/**");
            registry.addInterceptor(userRoleInterceptor)
                        .order(3)
                        .addPathPatterns("/user")
                        .excludePathPatterns("/admin/**");
            registry.addInterceptor(loggingInterceptor)
                        .order(1)
                        .addPathPatterns("/user","/admin");

      }
}
