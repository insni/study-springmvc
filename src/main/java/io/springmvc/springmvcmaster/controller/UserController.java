package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

      @PostMapping("/users")
      public Map<String, List<String>> saveUser(@ModelAttribute User user, BindingResult bindingResult) {
            if (!StringUtils.hasText(user.getName())) {
                  bindingResult.addError(new FieldError("user", "name", "사용자 이름은 필수입니다."));
            }
            if (user.getAge() != null)
                  if (!StringUtils.hasText(user.getName()) && (user.getAge() < 1)) {
                        bindingResult.addError(new ObjectError("user", "사용자 입력 값은 모두 필수입니다."));
                  }

            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            return Map.of("errors", errors);

      }
}
