package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Member;
import io.springmvc.springmvcmaster.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ValidationController {
      @PostMapping("/valid")
      public Map<String, List<String>> valid(@ModelAttribute User user, BindingResult bindingResult) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            return Map.of("errors", errors);
      }


      @PostMapping("/nonValid")
      public Map<String, List<String>> valid(@ModelAttribute Member member, BindingResult bindingResult) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            return Map.of("errors", errors);
      }
}
