package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
      @NotNull(message = "username cannot be null")
      private String username;
      @NotNull(message = "email cannot be null")
      private String email;
      private String password;
}
