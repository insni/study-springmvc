package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user/binder")
@RequiredArgsConstructor
public class UserBinderController {
      private final UserService userService;

      @InitBinder
      public void initBinder(WebDataBinder binder) {
//            1. allow field username, email
            binder.setAllowedFields("username","email");
//            binder.setDisallowedFields("password");
      }

      @PostMapping
      @ResponseBody
      public User addUser(@Valid User user,
                          BindingResult result) {
            return userService.addUser((User) result.getTarget());
      }
}
