package io.springmvc.springmvcmaster.config;

import io.springmvc.format.springmvcmaster.CustomNumberFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatConfig {

      @Bean
      public CustomNumberFormatter customNumberFormatter(){
            return new CustomNumberFormatter();
      }
}
