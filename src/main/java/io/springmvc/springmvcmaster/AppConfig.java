package io.springmvc.springmvcmaster;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
      @Bean
      public MessageSource messageSource(){
                  ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
                  bundleMessageSource.setBasename("messages/validation");
                  bundleMessageSource.setDefaultEncoding("UTF-8");
                  return bundleMessageSource;

      }
}
