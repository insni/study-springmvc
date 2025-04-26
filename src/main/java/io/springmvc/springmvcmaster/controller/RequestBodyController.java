package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class RequestBodyController {

    @PostMapping("/readbody")
    public ResponseEntity<String> readBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader= request.getReader()){
            String line;
            while ((line=reader.readLine())!=null){
                requestBody.append(line);
            }

        }
        return ResponseEntity.ok(requestBody.toString());

    }

}
