package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("/api/user2")
public class UserController2 {
      @GetMapping
      public ResponseEntity<Map<String, String>> getUser() {
            RestClient build = RestClient.builder()
                        .baseUrl("http://localhost:8080/api/user")
                        .build();
            try {
                  String response = build.post()
                              .exchange((req, res) -> {
                                    HttpStatusCode statusCode = res.getStatusCode();
                                    final String clientError = "Client error occurred";
                                    final String serverError = "Server error occurred";

                                    if (statusCode.is5xxServerError()) {
                                          throw new CustomException(statusCode, serverError);
                                    } else if (statusCode.is4xxClientError()) {
                                          throw new CustomException(statusCode, clientError);
                                    }


                                    try (InputStream body = res.getBody()) {
                                          return new String(body.readAllBytes());
                                    } catch (Exception e) {
                                          throw new RuntimeException("read for error response body");
                                    }

                              });
                  return ResponseEntity.status(HttpStatus.OK)
                              .body(Map.of("response", response));
            } catch (CustomException e) {
                  return ResponseEntity.status(e.getStatusCode())
                              .body(Map.of("message", e.getMessage()));
            } catch (Exception e){
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                              .body(Map.of("message", e.getMessage()));
            }


      }


      @PostMapping
      public ResponseEntity<Map<String, String>> addUser() {
            String badRequest = "bad request";
            String internerServer = "interner server error";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Map.of("message", internerServer));
      }


}
