package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class SingleValidatorController {
      @Autowired
      private UserValidator userValidator;

      @PostMapping("/users")
      public Map<String, Object> createUser(@ModelAttribute User user, BindingResult result, Map map) {
            userValidator.validate(user, result);
            if (result.hasErrors()) {
                  List<String> errors = result.getAllErrors().stream().map(error -> error.getDefaultMessage()).toList();
                  return Map.of("viewName","userForm", "errors",errors);
            }
            return Map.of("redirectUrl","/success");
      }
}