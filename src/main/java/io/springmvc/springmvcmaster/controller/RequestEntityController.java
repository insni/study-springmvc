package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class RequestEntityController {
    @PostMapping("/process")
    public Map<String, Object> process(RequestEntity<User> requestEntity){

        User body = requestEntity.getBody();
        String method = requestEntity.getMethod().name();
        String url = requestEntity.getUrl().toString();

        return Map.of("body", body, "method", method, "url", url);

    }
}
