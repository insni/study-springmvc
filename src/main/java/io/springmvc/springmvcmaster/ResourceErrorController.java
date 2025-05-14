package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resource")
public class ResourceErrorController {

      @GetMapping("{id}")
      public String getResource(@PathVariable String id) {
            throw new ResourceNotFoundException();
      }
}
