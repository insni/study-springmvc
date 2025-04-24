package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "user");
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "greeting";
    }
    @GetMapping("/greeting2")
    public String greeting2(Model model) {
        Map<String,Object> data = new HashMap<>();
        data.put("name", "user");
        data.put("message", "Welcome to Spring MVC!");
        model.addAllAttributes(data);
        return "greeting";
    }
    @GetMapping("/greeting3")
    public String greeting3(Model model) {
        UserDTO user = new UserDTO("user", "Welcome to Spring MVC!");
        model.addAttribute("user", user);
        return "greeting";
    }


}

