package io.springmvc.springmvcmaster.model;

import io.springmvc.springmvcmaster.validation.ValidPassword;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
      @NotNull(message = "username cannot be null")
      @ValidPassword(minLength = 8)
      private String password;

}
