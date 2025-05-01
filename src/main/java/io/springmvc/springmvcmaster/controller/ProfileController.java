package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequestMapping("/profile")
@RequestMapping("/${profile_path}")
public class ProfileController {
    @RequestMapping({"/view", "/edit"})
    public Map<String, String> viewProfile(HttpServletRequest httpServletRequest){
        return Map.of("RequestURI", httpServletRequest.getRequestURI());
    }

}
