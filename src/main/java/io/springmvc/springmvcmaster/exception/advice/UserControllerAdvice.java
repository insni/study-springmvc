package io.springmvc.springmvcmaster.exception.advice;

import io.springmvc.springmvcmaster.controller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {UserController.class})
public class UserControllerAdvice {

      @ExceptionHandler(Exception.class)
      public ResponseEntity<ErrorResponse> handleException3(Exception exception){
            ErrorResponse errorResponse=new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR,exception);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
      }

}
