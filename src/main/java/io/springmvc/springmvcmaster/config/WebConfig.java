package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToEnumConverterFactory;
import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.converter.StringToUserConditionalConverter;
import io.springmvc.springmvcmaster.converter.URLToStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
      @Bean
      public StringToURLConverter stringToURLConverter() {
            return new StringToURLConverter();
      }

      @Bean
      public URLToStringConverter urlToStringConverter() {
            return new URLToStringConverter();
      }

      @Bean
      public io.springmvc.springmvcmaster.converter.StringToUserConditionalConverter stringToUserConditionalConverter() {
            return new StringToUserConditionalConverter();
      }

      @Bean
      public StringToEnumConverterFactory stringToEnumConverterFactory() {
            return new StringToEnumConverterFactory();
      }

      @Override
      public void addFormatters(FormatterRegistry registry) {
            WebMvcConfigurer.super.addFormatters(registry);
            registry.addConverter(stringToURLConverter());
            registry.addConverter(urlToStringConverter());
            registry.addConverter(stringToUserConditionalConverter());
            registry.addConverterFactory(stringToEnumConverterFactory());
      }
}
