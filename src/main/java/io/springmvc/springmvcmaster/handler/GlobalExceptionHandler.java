package io.springmvc.springmvcmaster.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
      @InitBinder
      public void initBinder(WebDataBinder binder) {
//            exclude email field binding
            binder.setDisallowedFields("password");

      }

      @ExceptionHandler( {MethodArgumentNotValidException.class, IllegalArgumentException.class} )
      @ResponseBody
      public ResponseEntity<Map<String, String>> handleValidationException(
                 MethodArgumentNotValidException exception){
            Map<String,String> errors = new HashMap<>();
            exception.getBindingResult().getFieldErrors().forEach(error -> {
                  errors.put(error.getField(),error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);


      }
}
