package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.constant.Color;
import io.springmvc.springmvcmaster.model.URL;
import io.springmvc.springmvcmaster.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/spring/converter")
public class SpringConverterController {

      @PostMapping("/url")
      public Map<String, URL> saveURL(@ModelAttribute("url")URL url)
      {
            return Map.of("URL", url);
      }
      @PostMapping("/user")
      public Map<String, User> saveUser(@RequestParam("user") User user){
            return Map.of("user", user);
      }
      @PostMapping("/color")
      public Map<String, Color> saveColor(@RequestParam("color") Color color){
            return Map.of("color", color);
      }
}
