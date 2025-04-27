package io.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ImageResourceReadController {
    @GetMapping("/ima?e.png")
    public Map<String,Object> getSingleCharacterMatch(HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        int lasSlashIndex = request.getRequestURI().lastIndexOf("/");
        String patternMatchedCharacter=request.getRequestURI().substring(lasSlashIndex+4,lasSlashIndex+5);
        return Map.of("requestURI", requestURI,
                "patternMatch",true,
                "patternMatchCharacter",patternMatchedCharacter
                );

    }

    @GetMapping("/*.png")
    public Map<String,Object> getSingleCharacterMatch2(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        int lasDotIndex = requestURI.lastIndexOf(".");
        int lasSlashIndex = requestURI.lastIndexOf("/");
        String patternMatchedCharacter= requestURI.substring(lasSlashIndex + 1,lasDotIndex);
        return Map.of("requestURI", requestURI,
                "patternMatch",true,
                "patternMatchCharacter",patternMatchedCharacter
        );
    }

    @GetMapping("/**")
    public Map<String, Object> findAllMatchResource(HttpServletRequest request) {
        String requestMapping = "/resource/";
        String requestURI = request.getRequestURI();
        int uriPatternMatchBeginIndex = requestURI.lastIndexOf(requestMapping)+requestMapping.length()-1;
        String patternMatchedCharacter= requestURI.substring(uriPatternMatchBeginIndex);
        return Map.of("requestURI", requestURI,
                "patternMatch",true,
                "patternMatchCharacter",patternMatchedCharacter
        );    }

}
