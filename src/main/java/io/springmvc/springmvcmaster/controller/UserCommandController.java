package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserCommandController {
    private final UserService userService;

    @PostMapping //request mapping info
    public User addUser(@RequestBody User user) {  // handle method
        return userService.addUser(user);
    }
}
