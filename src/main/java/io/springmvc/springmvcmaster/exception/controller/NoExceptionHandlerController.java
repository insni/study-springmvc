package io.springmvc.springmvcmaster.exception.controller;

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

//      IllegalStateException 예외가 지정됨
      @ExceptionHandler
      public Map< String,  String> handleIllegalStateException(IllegalStateException ex) {
         return    Map.of("cause", "illegal state exception");
      }
}