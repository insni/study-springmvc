package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Map;

@Controller
public class ExceptionController {
      @GetMapping("/exception")
      public Map<String, String> exception(HttpServletResponse response)
                  throws Exception {
            throw new IllegalStateException(
                        "This is a simulated exception");
      }
      @GetMapping("/error500")
      public void error500(HttpServletResponse response) throws IOException {
            response.sendError(500);
      }
      @GetMapping("/error404")
      public void error404(HttpServletResponse response) throws IOException {
            response.sendError(404);
      }
      @GetMapping("/error401")
      public void error401(HttpServletResponse response) throws IOException {
            response.sendError(401);
      }
}
