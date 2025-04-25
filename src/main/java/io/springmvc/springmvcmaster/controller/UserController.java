package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/greeting")
    public Map<String, Model> greeting(Model model) {
        model.addAttribute("name", "user");
        model.addAttribute("message", "Welcome to Spring MVC!");
        return Map.of("model", model);
    }
    @GetMapping("/greeting2")
    public Map<String, Object> greeting2(Model model) {
        Map<String,Object> data = new HashMap<>();
        data.put("name", "user");
        data.put("message", "Welcome to Spring MVC!");
        model.addAllAttributes(data);
        return Map.of("data", data, "model", model);
    }
    @GetMapping("/greeting3")
    public Map<String, Model> greeting3(Model model) {
        User user = new User("user", "Welcome to Spring MVC!");
        model.addAttribute("user", user);
        return Map.of("model", model);
    }
}

