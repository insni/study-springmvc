package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/user")
public class UserSessionController {
    @GetMapping("/session")
    public String getUserSession(@SessionAttribute(name = "user", required = false) User user) {
        if (user == null) System.out.println("user not found in session");
        else System.out.println("user in session " + user.getName());
        return "session";
    }
    @GetMapping("/http/session")
    public String getUserHttpSession(HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");
        if (user == null) System.out.println("user not found in session");
        else System.out.println("user in session " + user.getName());
        return "session";
    }
}