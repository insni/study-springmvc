package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/convert")
public class ConvertController {
      @GetMapping("/number")
      public Map<String, Integer> convertNumber(@RequestParam Integer number) {
            return Map.of("convertedNumber", number);
      }

      @GetMapping("/user/{id}")
      public Map<String, Long> getUserById(@PathVariable("id") Long id) {
            return Map.of("userId", id);
      }

      @PostMapping("/user")
      public Map<String, User> createUser(@ModelAttribute User user){
            return Map.of("user", user);
      }

}
