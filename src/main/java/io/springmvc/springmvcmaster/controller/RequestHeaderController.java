package io.springmvc.springmvcmaster.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
public class RequestHeaderController {
    @GetMapping("/header")
    public Map<String, ? extends Serializable> handle(@RequestHeader("Accept-Encoding") String encoding,
                                                      @RequestHeader("Keep-Alive") long keepAlive) {
        return Map.of("Accept-Encoding", encoding,
                "Keep-Alive", keepAlive);
    }

    @GetMapping("/headers")
    public Map<String, String> handleHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/headers2")
    public MultiValueMap<String, String> handleHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        return headers;
    }

    @GetMapping("/headers3")
    public List<String> handleAccept(@RequestHeader("Accept") List<String> headers) {
        return headers;
    }
}
