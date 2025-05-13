package io.springmvc.springmvcmaster;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
      @PostMapping
      @AdminOnly
      public Map<String,String> addUser(
                   @ModelAttribute   User user){
            if (user == null ||(user.getUsername() == null || user.getEmail() == null))
                  return Map.of("message", "user not found");
            return Map.of("message", "save user");
      }
}
