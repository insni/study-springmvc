package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {
     @NotNull(message = "username cannot be null")
     @Size(min = 3, max = 10, message = "username length must be between 3 and 10")
     private String username;

     @Email(message = "email is not valid")
     private String email;

     @Min(value = 0, message = "age must be greater than 0")
     @Max(value = 120,message = "age must be less than 120")
     private int age;

}

