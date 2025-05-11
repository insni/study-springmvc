package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
      @PostMapping
      public Map<String, Object> addUser(
                  @Valid @ModelAttribute User user,
                  BindingResult result,
                  Model model
      ) {
            Map<String, Object> response = new HashMap<>(); // 응답을 담을 맵

            // 유효성 검사 실패 시 처리
            if (result.hasErrors()) {
                  response.put("status", "error");
                  response.put("errors", result.getFieldErrors()); // 모든 필드 에러 정보 반환
                  return response;
            }

            // 유효성 검사 통과 시 처리
            response.put("status", "success");
            response.put("data", user); // 정상적으로 받은 User 객체 반환
            return response;

      }

}
