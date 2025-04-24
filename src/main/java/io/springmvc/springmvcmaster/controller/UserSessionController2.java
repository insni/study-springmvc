package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
@RequestMapping("/user2/session")
public class UserSessionController2 {
    @PostMapping
    public String setSession(Model model) {
        User user = new User("user", "welcome user");
        model.addAttribute("user", user);
        return "session2";
    }

    @GetMapping
    public String getSession(@SessionAttribute(name = "user") User user, Model model) {
        model.addAttribute("message", "user in session " + user.getName());
        return "session2";
    }

    @PostMapping("/clear")
    public String clearSession(SessionStatus sessionStatus, Model model, HttpSession httpSession) {
        sessionStatus.setComplete();
        return "session2";
    }


}
