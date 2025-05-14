package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/error")
public class ResolverController {
      @GetMapping("/view")
      public Map<String,String> wviewError(){
            throw new IllegalArgumentException( "view error");
      }
      @GetMapping("/json")
      public Map<String,String> jsonError(){
            throw new IllegalArgumentException( "json error");
      }
      @GetMapping("/sendError")
      public Map<String,String> sendError(){
            throw new IllegalArgumentException( "sendError error");
      }
}
