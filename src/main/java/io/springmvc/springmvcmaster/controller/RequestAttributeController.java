package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestAttributeController {
@GetMapping("/example")
    public String handleRequest(@RequestAttribute("myAttribute") String myAttribute){
    return "myAttribute value is " + myAttribute;
}
}
