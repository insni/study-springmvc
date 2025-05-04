package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.constant.Color;
import io.springmvc.springmvcmaster.constant.Status;
import io.springmvc.springmvcmaster.converter.StringToEnumConverterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class StringToEnumConverterController {
      private final StringToEnumConverterFactory stringToEnumConverterFactory;
      @GetMapping("/enum")
      public HashMap<String, Object> convertToEnum(@RequestParam String value){
            HashMap<String, Object> convertReuslt = new HashMap<>();
            if (Arrays.stream(Color.values()).anyMatch(color -> color.name().equals(value))) {
                  Converter<String, Color> converter = stringToEnumConverterFactory.getConverter(Color.class);
                  Color convert = converter.convert(value);
                  convertReuslt.put("convert", convert);
            }
            else if(Arrays.stream(Status.values()).anyMatch(status -> status.name().equals(value))){
                  Converter<String, Status> converter = stringToEnumConverterFactory.getConverter(Status.class);
                  Status convert = converter.convert(value);
                  convertReuslt.put("convert", convert);
            }
            else {
                  convertReuslt.put("convert", "empty");
            }
            return convertReuslt;
      }
}
