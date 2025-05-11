package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {
      @NotEmpty(message = "username is essential")
      private String username;

      @Email(message = "email is invalid")
      private String email;
}
