package io.springmvc.springmvcmaster;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(2)
public class GlobalExceptionHandler {
      @ExceptionHandler(IllegalArgumentException.class)
      public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception){
            String message = exception.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("[ControllerAdvice] Error Message is "+message);
      }
}
