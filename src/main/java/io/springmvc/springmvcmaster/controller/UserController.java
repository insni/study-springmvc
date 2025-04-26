package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/submit")
    public User submit(@ModelAttribute("user") User user) {
        return user;
    }

    @PostMapping("/update")
    public User update(@ModelAttribute(binding = false) User user) {
        return user;
    }





}
