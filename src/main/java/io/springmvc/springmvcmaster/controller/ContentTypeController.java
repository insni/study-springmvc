package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/content-type")
public class ContentTypeController {

    //    content-type text/*
    @RequestMapping(value = "/text", method = RequestMethod.POST, headers = "content-type=text/*")
    public Map<String, String> handleText(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader(); // InputStreamReader도 가능

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return Map.of("header", sb.toString().trim());
    }

    //    content-type application/json
    @RequestMapping(value = "/json", method = RequestMethod.POST, headers = "content-type=application/json")
    public Map<String, String> handleJson(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader(); // InputStreamReader도 가능

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return Map.of("header", sb.toString().trim());
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET, headers = "My-Header=myValue")
    public Map<String, String> handleNoContentType(@RequestHeader("My-Header") String myHeader) {
        return Map.of("My-Header", myHeader);
    }

    @RequestMapping(value = "/json2", method = RequestMethod.POST, headers = "content-type=application/json")
    public Map<String, String> handleJson2(HttpServletRequest request,
                                          @RequestHeader(value = "X-Custom-Header", required = false) String customHeader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return Map.of(
                "body", sb.toString().trim(),
                "X-Custom-Header", customHeader != null ? customHeader : "not provided"
        );
    }


}
