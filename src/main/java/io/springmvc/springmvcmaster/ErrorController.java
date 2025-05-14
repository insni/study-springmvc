package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
      @GetMapping("/arithmetic-error")
      public String arithmeticError() {
            throw new ArithmeticException("Arithmetic Exception Occurred!");
      }
      @GetMapping("/nullpointer-error")
      public String nullPointerError() {
            throw new NullPointerException("Null Pointer Exception Occurred!");
      }
}