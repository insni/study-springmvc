package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
      @GetMapping
      public ResponseEntity<Map<String, String>> getUser() {
            RestClient build = RestClient.builder()
                        .baseUrl("http://localhost:8080/api/user")
                        .build();
            try {
                  String response = build.post()
                              .retrieve()
                              .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                                    throw new CustomException(res.getStatusCode(), "Client error occurred");
                              })
                              .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                                    throw new CustomException(res.getStatusCode(), "Server error occurred");
                              })
                              .body(String.class);
            } catch (CustomException e) {
                  return ResponseEntity.status(e.getStatusCode())
                              .body(Map.of("message", e.getMessage()));
            }
            return ResponseEntity.status(HttpStatus.OK)
                        .body(Map.of("result", "success"));

      }


      @PostMapping
      public ResponseEntity<Map<String, String>> addUser() {
            String badRequest = "bad request";
            String internerServer = "interner server error";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(   Map.of("message", internerServer));
      }


}
