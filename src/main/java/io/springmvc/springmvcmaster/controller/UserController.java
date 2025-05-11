package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
      @PostMapping("/user")
      public Map<String, Object> addUser(@Valid
                                            @ModelAttribute
                                               User user,
                                            BindingResult result,
                                            Model model) {
            List<String> messages = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            if (result.hasErrors()) return Map.of("viewName", "userForm",
                        "viewDesc", "폼 페이지로 다시 이동",
                        "user", user,
                        "messages",messages);

            return Map.of("viewName", "userSuccess",
                        "viewDesc", "성공 페이지로 이동",
                        "user", user,
                        "messages",messages);

      }
      @PostMapping("/user2")
      public Map<String, Object> addUser2(@Valid
                                            @RequestBody
                                            User user,
                                            BindingResult result,
                                            Model model) {
            List<String> messages = result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList();
            if (result.hasErrors()) return Map.of("viewName", "userForm",
                        "viewDesc", "폼 페이지로 다시 이동",
                        "user", user,
                        "messages",messages);

            return Map.of("viewName", "userSuccess",
                        "viewDesc", "성공 페이지로 이동",
                        "user", user,
                        "messages",messages);

      }
}
