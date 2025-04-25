package io.springmvc.springmvcmaster.model;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private String message;

    public User(String name, String message) {
        this.name = name==null ?  "" : name;
        this.message = message== null? "" : message;
    }
}
