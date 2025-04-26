package io.springmvc.springmvcmaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private String username;
    private String email;

    public User(Object o) {
        LinkedHashMap<String,String> arguments = (LinkedHashMap<String,String>) o;
        String name = arguments.get("username");
        String message = arguments.get("email");
        this.username = name;
        this.email = message;
    }
}
