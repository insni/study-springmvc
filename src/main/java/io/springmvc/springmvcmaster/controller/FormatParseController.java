package io.springmvc.springmvcmaster.controller;

import io.springmvc.format.springmvcmaster.CustomNumberFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FormatParseController {
      private final CustomNumberFormatter customNumberFormatter;
      @GetMapping("/print")
      public Map<String, Object> print(Integer param){
            String print = customNumberFormatter.print(param, Locale.KOREA);
            return Map.of("param",param,"print",print);
      }
      @GetMapping("/parse")
      public Map<String, String> parse(String param) throws ParseException {
            Number parse = customNumberFormatter.parse(param, Locale.KOREA);
            return Map.of("param",param,"parse",parse.toString());
      }
}
