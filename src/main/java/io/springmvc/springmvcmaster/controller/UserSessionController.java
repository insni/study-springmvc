package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserSessionController {
    @GetMapping("/session")
    public Map<String, User> getUserSession(@SessionAttribute(name = "user", required = false) User user, Model model) {
        Map<String, User> response = new HashMap<>();

        try {
            response.put("userInSessionAttribute", user != null ? user : new User());
        } catch (Exception e) {
            response.put("userInSessionAttribute", new User());  // 빈 객체로 대응
        }

        try {
            Object modelUser = model.getAttribute("user");
            response.put("userInModel", modelUser != null ? (User) modelUser : new User());
        } catch (Exception e) {
            response.put("userInModel", new User());
        }
        return response;
    }


    @GetMapping("/http/session")
    public Map<String, User> getUserHttpSession(HttpSession httpSession,Model model) {
        Map<String, User> response = new HashMap<>();

        try {
            User sessionUser = (User) httpSession.getAttribute("user");
            response.put("userInHttpSession", sessionUser != null ? sessionUser : new User());
        } catch (Exception e) {
            response.put("userInHttpSession", new User());
        }

        try {
            Object modelUser = model.getAttribute("user");
            response.put("userInModel", modelUser != null ? (User) modelUser : new User());
        } catch (Exception e) {
            response.put("userInModel", new User());
        }
        return response;
    }

    @PostMapping
    public Map<String, User> setSession(HttpSession httpSession, Model model) {
        User user = new User("user", "welcome user");

        httpSession.setAttribute("user", user);
        model.addAttribute("user", user);

        Map<String, User> response = new HashMap<>(Map.of("modelAttribute", (User) httpSession.getAttribute("user")));
        response.put("sessionAttribute", (User) httpSession.getAttribute("user"));
        response.put("modelAttribute", (User) model.getAttribute("user"));
        return response;
    }
    @PostMapping("/clear")
    public Map<String, Object> clearSession(SessionStatus sessionStatus, HttpSession httpSession, Model model) {
        Map<String, Object> response = new HashMap<>();

        // 세션 정리
        sessionStatus.setComplete();
        httpSession.removeAttribute("user");

        // 세션 및 모델에서 user 추출
        User sessionUser = (User) httpSession.getAttribute("user");
        User modelUser = (User) model.getAttribute("user");


        // 그대로 담기 (null이면 null)
        response.put("userInSession", sessionUser);
        response.put("userInModel", modelUser);



        return response;
    }

}