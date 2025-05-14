package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

      @GetMapping
      public Map<String,String> findUser() throws Exception {
            throw new Exception("not found user");
      }
}
