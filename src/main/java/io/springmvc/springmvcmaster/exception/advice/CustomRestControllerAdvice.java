package io.springmvc.springmvcmaster.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class CustomRestControllerAdvice {
      @ExceptionHandler(IllegalArgumentException.class)
      public ResponseEntity<Map<String,String>> handleIllegalArgumentException(IllegalArgumentException exception){
            Map<String, String> error = Map.of("error", exception.getMessage(),
                        "advice", this.getClass().getName(),
                        "cause", exception.getCause().toString());
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(error);
      }
}
