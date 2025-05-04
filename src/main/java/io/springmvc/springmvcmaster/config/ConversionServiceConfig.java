package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.converter.URLToStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConversionServiceConfig {

      @Bean
      public StringToURLConverter stringToURLConverter() {
            return new StringToURLConverter();
      }

      @Bean
      public URLToStringConverter urlToStringConverter() {
            return new URLToStringConverter();
      }      @Bean
      public DefaultConversionService defaultConversionService(){
            DefaultConversionService defaultConversionService = new DefaultConversionService();
            defaultConversionService.addConverter(stringToURLConverter());
            defaultConversionService.addConverter(urlToStringConverter());
            return defaultConversionService;

      }
}
