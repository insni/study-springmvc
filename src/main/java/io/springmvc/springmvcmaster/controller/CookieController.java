package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
public class CookieController {
@GetMapping
    public String getCookie(@CookieValue(value = "userSession",defaultValue = "defaultSession") String session) {
    return "Session Id is " + session;
}
}
