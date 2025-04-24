package io.springmvc.springmvcmaster.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private String name;
    private String message;

    public UserDTO(String name, String message) {
        this.name = name==null ?  "" : name;
        this.message = message== null? "" : message;
    }
}
