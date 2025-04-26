package io.springmvc.springmvcmaster.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.springmvc.springmvcmaster.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HttpEntityController {
    @PostMapping("/param")
    public ResponseEntity<User> httpEntity(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        return ResponseEntity.ok(user);


    }

    @PostMapping("/model")
    private ResponseEntity<User> model(@ModelAttribute User user) {
        return ResponseEntity.ok(user);

    }

    @PostMapping("/process")
    public ResponseEntity<User> processRequest(HttpEntity<String> http) throws JsonProcessingException {
        // get header and body
        String body = http.getBody();
        HttpHeaders headers = http.getHeaders();

        // convert user type
        ObjectMapper objectMapper = new ObjectMapper();
        User responseBody = objectMapper.readValue(body, User.class);

        // set response header
        HttpHeaders responseHttpHeader = new HttpHeaders();
        responseHttpHeader.add("Custom-Header","Processed");
        ResponseEntity<User> responseEntity = new ResponseEntity<>(responseBody, responseHttpHeader, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/process2")
    public ResponseEntity<User> processRequest2(HttpEntity<User> httpEntity){
        // get header and body
        User user = httpEntity.getBody();
        HttpHeaders headers = httpEntity.getHeaders();

        // set response header
        HttpHeaders responseHttpHeader = new HttpHeaders();
        responseHttpHeader.add("Custom-Header","Processed");
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, responseHttpHeader, HttpStatus.OK);
        return responseEntity;

    }
}



