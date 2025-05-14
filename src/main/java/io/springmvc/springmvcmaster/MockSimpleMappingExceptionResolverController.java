package io.springmvc.springmvcmaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MockSimpleMappingExceptionResolverController {

      @GetMapping("/errorArithmetic")
      public Map<String,String> errorArithmetic(){
            return    Map.of("viewName","errorArithmetic.html");
      }
      @GetMapping("/errorNullPointer")
      public Map<String,String> nullPointerException(){
         return    Map.of("viewName","errorNullPointe.html");
      }
}
