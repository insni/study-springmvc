package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.format.KoreanCurrencyFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class KoreanFormatParseController {

      private final ConversionService conversionService;
     @GetMapping("/format")
      public Map<String, Object> format(Integer param ){

            String convert = conversionService.convert(param, String.class);
            return Map.of("param", param, "convert", convert);
      }
      @GetMapping("/parse")
      public ResponseEntity<Map<String,String>> parse(String param) throws ParseException {
            Number convert = conversionService.convert(param, Number.class);
            Map<String, String> body = Map.of("param", param, "convert", convert.toString());
            return ResponseEntity.ok(body);
      }
}
