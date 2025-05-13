package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/error")
@RestController
public class ErrorPageHandler {

      @GetMapping("/401")
      public Map<String,String> unAuthorized(){
            return Map.of("viewName", "401.html");
      }

      @GetMapping("/404")
      public Map<String,String> pageNotFound(){
            return Map.of("viewName", "404.html");
      }

      @GetMapping("/500")
      public Map<String,String> internalServerError(){
            return Map.of("viewName", "500.html");
      }

      @GetMapping("/exception")
      public Map<String,String> exception(){
            return Map.of("viewName", "exception.html");
      }
}
