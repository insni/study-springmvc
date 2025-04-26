package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Account;
import io.springmvc.springmvcmaster.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/user/account")
public class UserAccountController {
        @ModelAttribute
        public User user(){
            return new User("John Doe","johndoe@email.com");
        }
        @GetMapping
        public Map<String, Object> getUser(Model model, Account account){
            return Map.of("account", model.asMap().get("account"), "user", model.asMap().get("user"));
        }


}
