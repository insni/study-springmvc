package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @RequestMapping( method = RequestMethod.GET)
    public Map<String,String> example() {
        return Map.of("message", "Hello, World!");
    }



}
