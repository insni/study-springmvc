package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Manager {
      @NotEmpty(message = "managername is essential",
      groups = Vgroups.CreateGroup.class)
      private String managerName;
      @Email(message = "email show be valid",
      groups = {
                  Vgroups.CreateGroup.class,
                  Vgroups.UpdateGroup.class
      })
      private String email;
}
