package io.springmvc.springmvcmaster.exception.handler;

import io.springmvc.springmvcmaster.exception.CustomNotFoundException;
import io.springmvc.springmvcmaster.exception.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
      @ExceptionHandler(CustomNotFoundException.class)
      public ResponseEntity<ErrorResponse> handleException(CustomNotFoundException exception){
            ErrorResponse errorResponse=new ErrorResponseException(HttpStatus.BAD_REQUEST,exception);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
      }
      @ExceptionHandler(CustomValidationException.class)
      public ResponseEntity<ErrorResponse> handleException2(CustomValidationException exception){
            ErrorResponse errorResponse=new ErrorResponseException(HttpStatus.BAD_REQUEST,exception);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
      }
      @ExceptionHandler(Exception.class)
      public ResponseEntity<ErrorResponse> handleException3(Exception exception){
            ErrorResponse errorResponse=new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR,exception);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
      }

}
