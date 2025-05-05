package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.format.KoreanCurrencyFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
public class ConversionConfig {

      @Bean
      public FormatterRegistrar customFormatterRegistrar(){
            FormatterRegistrar formatterRegistrar = new FormatterRegistrar() {
                  @Override
                  public void registerFormatters(FormatterRegistry registry) {
                        registry.addConverter(stringToURLConverter());
                        registry.addFormatter(koreanCurrencyFormatter());
                  }
            };
            formatterRegistrar.registerFormatters(defaultFormattingConversionService());
            return formatterRegistrar;
      }
      @Bean
      public StringToURLConverter stringToURLConverter() {
            return new StringToURLConverter();
      }

      @Bean
      public DefaultFormattingConversionService defaultFormattingConversionService (){
            DefaultFormattingConversionService defaultFormattingConversionService = new DefaultFormattingConversionService();
//            FormatterRegistrar 에서 대신 처리
//            defaultFormattingConversionService.addFormatter(koreanCurrencyFormatter());
            return defaultFormattingConversionService;
      }
      @Bean
      public KoreanCurrencyFormatter koreanCurrencyFormatter (){
            return new KoreanCurrencyFormatter();

      }
}
