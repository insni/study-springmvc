package io.springmvc.springmvcmaster.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping( params = "type=pizza")
    public Map<String,String> order(String type){
        return Map.of("value","/order","params","pizza", "type",type);
    }
    @RequestMapping(params = "type=chicken")
    public Map<String,String> order2(String type){
        return Map.of("value","/order", "type",type);
    }
}
