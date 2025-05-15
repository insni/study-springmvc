package io.springmvc.springmvcmaster.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CustomException extends RuntimeException{
      private HttpStatusCode statusCode;

      public CustomException(HttpStatusCode statusCode,String message) {
            super(message);
            this.statusCode= statusCode;
      }
}
