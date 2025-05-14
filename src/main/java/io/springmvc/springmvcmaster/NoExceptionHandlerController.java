package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class NoExceptionHandlerController {
      @GetMapping("/default")
      public String handleDefault() {
            throw new IllegalStateException("Default exception occurred!");
      }
      @GetMapping("/default2")
      public String handleDefault2() {
            throw new IllegalArgumentException("Default exception occurred!");
      }

//      IllegalStateException 예외가 지정됨
      @ExceptionHandler
      public Map< String,  String> handleRuntimeException(RuntimeException ex) {
         return    Map.of("cause", "illegal state exception");
      }


}