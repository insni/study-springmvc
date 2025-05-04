package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.converter.URLToStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

      @Bean
      public StringToURLConverter stringToURLConverter() {
            return new StringToURLConverter();
      }

      @Bean
      public URLToStringConverter urlToStringConverter() {
            return new URLToStringConverter();
      }
}
