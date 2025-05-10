package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserValidatorWithBinderController {
      private final UserValidator userValidator;
      @InitBinder("user")
      protected void initBinder(WebDataBinder binder) {
            binder.setValidator(userValidator);
      }
      @PostMapping("/users3")
      public HashMap<String, Object> registerUser(@Validated @ModelAttribute("user") User user, BindingResult result, Map map) {
            HashMap<String, Object> body = new HashMap<>();
            body.put("errors", result.getAllErrors());
//            body.put("bindMap", map);
            body.put("user", user);
            if (result.hasErrors()) {
                  body.put("viewName", "userForm");
                  return body;
            }
            body.put("redirectUrl", "/success");
            return body;
      }
}