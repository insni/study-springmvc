package io.springmvc.springmvcmaster.exception.controller;

import io.springmvc.springmvcmaster.exception.CustomNotFoundException;
import io.springmvc.springmvcmaster.exception.CustomValidationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomExceptionController {
      @GetMapping("{id}")
      public String getResource(@PathVariable String id) throws Exception {
            if ("notfound".equals(id))
                  throw new CustomNotFoundException("resource not found");
             else if("invalid".equals(id))
                  throw new CustomValidationException("invalid");
            throw new Exception("exception");
      }

}
