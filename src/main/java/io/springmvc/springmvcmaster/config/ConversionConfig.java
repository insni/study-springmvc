package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.format.KoreanCurrencyFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConversionConfig implements WebMvcConfigurer {

      @Override
      public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new StringToURLConverter());
            registry.addFormatter(new KoreanCurrencyFormatter());
      }

      @Bean
      public StringToURLConverter stringToURLConverter() {
            return new StringToURLConverter();
      }

      @Bean
      public KoreanCurrencyFormatter koreanCurrencyFormatter() {
            return new KoreanCurrencyFormatter();
      }
}
