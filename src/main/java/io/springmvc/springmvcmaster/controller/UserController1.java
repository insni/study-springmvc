package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController1 {
    @GetMapping("/httpEntity")
    public ResponseEntity<User> processRequest(HttpEntity<User> httpEntity) {
        User user = httpEntity.getBody();
        return ResponseEntity.ok(user);
    }
}

