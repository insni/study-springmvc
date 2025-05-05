package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.format.KoreanCurrencyFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class KoreanFormatParseController {

      private final DefaultFormattingConversionService defaultFormattingConversionService;
     @GetMapping("/format")
      public Map<String, Object> format(Integer param ){

            defaultFormattingConversionService.addFormatter(new KoreanCurrencyFormatter());
            String convert = defaultFormattingConversionService.convert(param, String.class);
            return Map.of("param", param, "convert", convert);
      }
      @GetMapping("/parse")
      public Map<String,String> parse(String param) throws ParseException {

            defaultFormattingConversionService.addFormatter(new KoreanCurrencyFormatter());
            Number convert = defaultFormattingConversionService.convert(param, Number.class);
            return Map.of("param", param, "convert", convert.toString());
      }
}
