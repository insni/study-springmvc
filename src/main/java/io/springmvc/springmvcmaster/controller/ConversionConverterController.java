package io.springmvc.springmvcmaster.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConversionConverterController {
      private final DefaultFormattingConversionService defaultFormattingConversionService;
      @GetMapping("/format2")
      public Map<String, Object> convertCurrencyToNumber(String currency){
//이 부분 문제
            Number convertCurrencyToNumber = defaultFormattingConversionService.convert(currency, Number.class);
            return Map.of("currency", currency, "convert", convertCurrencyToNumber);
      }
      @GetMapping("/parse2")
      public Map<String, Object> convertNumberToCurrency(Integer currency){

            String convertCurrency = defaultFormattingConversionService.convert(currency, String.class);
            return Map.of("currency", currency, "convert", convertCurrency.toString());
      }
}
