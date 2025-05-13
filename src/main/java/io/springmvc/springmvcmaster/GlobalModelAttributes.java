package io.springmvc.springmvcmaster;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {
      @ModelAttribute("appName")
      public String addApplicationName(){
            return "myApp";
      }
}
