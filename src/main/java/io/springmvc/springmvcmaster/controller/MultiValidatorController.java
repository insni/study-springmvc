package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Admin;
import io.springmvc.springmvcmaster.validator.ValidatorChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MultiValidatorController {
      private final ValidatorChain validatorChain;
      @PostMapping("/users2")
      public Map<String, Object> createUser(@ModelAttribute Admin admin, BindingResult result) {
            Map<String, Object> body = new HashMap<>();
            for (Validator validator : validatorChain.getValidators()) {
                  if (validator.supports(result.getTarget().getClass())) {
                        validator.validate(result.getTarget(), result);
                        break;
                  }
            }
            if (result.hasErrors()) {
                  List<String> errors = result.getAllErrors().stream().map(error ->
                              error.getDefaultMessage()).toList();
                  body.put("errors",errors);
                  body.put("viewName","form");
            }
             body.put("viewName","success");
            return body;
      }
}

