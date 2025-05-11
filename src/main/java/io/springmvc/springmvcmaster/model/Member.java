package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
      @Size(min = 6,message = "membername must be at least 6 characters")
      @NotNull(message = "membername is essential")
      private String membername;
      @Size(min = 6,message = "password must be at least 6 characters")
      @NotNull(message = "password is essential")
      private String password;
      @NotNull(message = "mail is essential")
      private String mail;

}
