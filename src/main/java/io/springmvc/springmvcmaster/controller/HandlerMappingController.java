package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HandlerMappingController {
    @RequestMapping({"/user", "/mypage"})
    public String multi(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
