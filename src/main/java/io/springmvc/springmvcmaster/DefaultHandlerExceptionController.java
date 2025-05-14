package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/default/resolver")
public class DefaultHandlerExceptionController {
      @PostMapping
      public String defaultHandler() {
            return "post";
      }
      @PostMapping(value = "/consume", consumes = "application/json")
      public String consumeJson(@RequestBody String body){
            return "consumed json is " + body;
      }
}
