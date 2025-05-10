package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Admin;
import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.validator.AdminValidator;
import io.springmvc.springmvcmaster.validator.UserValidator;
import lombok.RequiredArgsConstructor;
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
public class UserValidatorWithMultiBinderController {
      private final UserValidator userValidator;
      private final AdminValidator adminValidator;

      @InitBinder("user")
      protected void initBinder1(WebDataBinder binder) {
            binder.addValidators(userValidator);
      }
      @InitBinder("admin")
      protected void initBinder2(WebDataBinder binder) {
            binder.addValidators(adminValidator);
      }
      @PostMapping("/users4")
      public Map<String, Object> registerUser(@Validated @ModelAttribute("user") User user, BindingResult result) {
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
      @PostMapping("/admin4")
      public Map<String, Object> registerAdmin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result) {
            HashMap<String, Object> body = new HashMap<>();
            body.put("errors", result.getAllErrors());
//            body.put("bindMap", map);
            body.put("admin", admin);
            if (result.hasErrors()) {
                  body.put("viewName", "userForm");
                  return body;
            }
            body.put("redirectUrl", "/success");
            return body;
      }
}