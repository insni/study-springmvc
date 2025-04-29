package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Map<String, Object> getUser(@RequestParam(name = "name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/required-true")
    public Map<String, Object> requiredTrue(@RequestParam(name = "name", required = true) String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/required-false")
    public Map<String, Object> requiredFalse(@RequestParam(name = "name", required = false) String name) {
        try {
            Map<String, Object> user = userService.getUserByName(name);
            return user;
        } catch (Exception e) {
            Map<String, Object> user = new HashMap<>();
            user.put("required", "false");
            user.put("message", name + " is not found");
            return user;
        }
    }

    @GetMapping("/default-value")
    public Map<String, Object> defaultValue(@RequestParam(name = "name", defaultValue = "anonymous") String name) {
        return userService.getUserByName(name);
    }

    //    spring boot 3.2 이상부터는 @RequestParam(name = "name") String name과 @RequestParam String name은 동일하게 동작한다.
    @GetMapping("/no-name")
    public Map<String, Object> noName(@RequestParam String name) {
        return userService.getUserByName(name);
    }

    //    spring boot 3.2 이상부터는 @RequestParam(name = "name") String name과 @RequestParam String name은 동일하게 동작한다.
    @GetMapping("/no-request-param")
    public Map<String, Object> noRequestParam(String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/id")
    public Map<String, Object> getUserById(@RequestParam int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.getUserById(id);
            if (user == null)
                throw new Exception("User not found");
            response.put("user", user);
        } catch (Exception e) {
            response.put("message", "User not found");
        }
        return response;
    }

    @GetMapping("/id/anonymous")
    public Map<String, Object> getUserByIdElseAnonymous(@RequestParam(name = "id", defaultValue = "1") int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.getUserById(id);
            if (user == null)
                throw new Exception("User not found");
            response.put("user", user);
        } catch (Exception e) {
            response.put("message", "User not found");
        }
        return response;
    }

    @PostMapping
    public User save(@RequestParam Map<String, String> userDetails) {
        if (userDetails.containsKey("name") && userDetails.containsKey("id")) {
            return userService.save(userDetails.get("name"),
                    Integer.valueOf(userDetails.get("id")));
        }
        throw new IllegalArgumentException("Invalid user details");
    }

    @GetMapping("/multi-value")
    public List<User> findAllByIds(@RequestParam MultiValueMap<String, Object> params) {
        List<User> users=new ArrayList<>();
        List<Object> ids = params.get("id");
        List<Object> names = params.get("name");
        if (ids != null && !ids.isEmpty()) {
            List<User> usersByIds = ids.stream()
                    .map(id -> userService.getUserById(Integer.parseInt((String) id)))
                    .collect(Collectors.toList());
            users.addAll(usersByIds);
        }

        if (names != null && !names.isEmpty()) {
            List<User> usersByNames = names.stream()
                    .map(name -> (User) userService.getUserByName((String) name).get("user"))
                    .collect(Collectors.toList());
            users.addAll(usersByNames);
        }

        return users;
    }
    @GetMapping("/request-params")
    public Map<String, String> findAll(@RequestParam(name = "name",required = false) String name,
                                       @RequestParam(name = "id",required = false) String id,
                                       @RequestParam Map<String,String> requestParams) {
        return requestParams;
    }
}
