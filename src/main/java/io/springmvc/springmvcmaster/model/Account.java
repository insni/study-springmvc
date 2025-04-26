package io.springmvc.springmvcmaster.model;

import lombok.Getter;
import org.springframework.web.bind.annotation.BindParam;

import static java.lang.Math.*;

@Getter
public class Account {
    private String id;
    private String firstName;


    public Account(@BindParam("first-name") String firstName) {
        this.firstName = firstName;
        this.id= ((random() * 10) + 1)+"";
    }

}
