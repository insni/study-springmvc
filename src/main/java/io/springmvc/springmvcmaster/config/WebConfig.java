package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.formater.CustomCurrencyFormat;
import io.springmvc.springmvcmaster.formater.CustomCurrencyFormatterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

      @Override
      public void addFormatters(FormatterRegistry registry) {
//            WebMvcConfigurer.super.addFormatters(registry);
            registry.addFormatterForFieldAnnotation(new CustomCurrencyFormatterFactory());
      }
}
