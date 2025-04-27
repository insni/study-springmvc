package io.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserReaderController {
    // path variable with not name
//    @GetMapping("/{userId}")
//    public Map<String,Object> getUser(@PathVariable String userId){
//        return Map.of("userId",userId);
//    }
    @GetMapping("/{userId}")
    public Map<String,Object> getUser2(String userId){
        return Map.of("userId",userId==null ? "empty" : userId);
    }

}
