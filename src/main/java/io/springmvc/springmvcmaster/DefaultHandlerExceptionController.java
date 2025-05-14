package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/default/resolver")
public class DefaultHandlerExceptionController {
      @PostMapping
      public String defaultHandler() throws HttpRequestMethodNotSupportedException {
            throw new HttpRequestMethodNotSupportedException("/default/resolver");
      }
      @PostMapping(value = "/consume", consumes = "application/json")
      public String consumeJson(@RequestBody String body) throws  HttpMediaTypeNotSupportedException {
            throw new HttpMediaTypeNotSupportedException("/default/resolver/consume");
      }
}
