package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/binder2")
@RequiredArgsConstructor
public class UserBinderController2 {
      private final UserService userService;

      @InitBinder
      public void initBinder(WebDataBinder binder) {
//            2. essential arguments username, email
            binder.setRequiredFields("username","email");
      }

      @PostMapping
      @ResponseBody
      public User addUser(@Valid User user,
                          BindingResult result) throws IllegalArgumentException{
            if (result.hasErrors()) {
                  throw new IllegalArgumentException(result.getAllErrors().toString());
            }
            return userService.addUser((User) result.getTarget());
      }
}
