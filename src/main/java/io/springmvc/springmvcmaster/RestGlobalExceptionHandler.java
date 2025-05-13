package io.springmvc.springmvcmaster;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(3)
public class RestGlobalExceptionHandler {
      @ExceptionHandler(IllegalArgumentException.class)
      public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("[RestControllerAdvice] Error Message is "+exception.getMessage());
      }
}
