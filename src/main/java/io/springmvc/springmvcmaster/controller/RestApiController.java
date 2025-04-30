package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestApiController {
    @GetMapping
    public Map<String, User> index(@RequestParam("name")String name, @RequestParam("age") String age, User  user) {
        return Map.of("user",user);
    }
}
