package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/user")
public class UserController2 {
    @GetMapping("/requestBody")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser2(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/text", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<User> createUser3(@RequestBody String body) {
        String[] parts = body.split("&");
        String username = parts[0].split("=")[1];
        String email = parts[1].split("=")[1];

        User user = new User(username, email);

        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<User> createUser4(@RequestBody MultiValueMap<String, String> formData) {
        User user = new User(
                formData.getFirst("username"),
                formData.getFirst("email"));
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/mixed", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<User> createUser5(@RequestBody Object object) {
        if (object instanceof LinkedHashMap<?,?>) {
            User user = new User(object);
            return ResponseEntity.ok(user);
        } else {
            User user = (User) object;
            return ResponseEntity.ok(user);
        }
    }
}