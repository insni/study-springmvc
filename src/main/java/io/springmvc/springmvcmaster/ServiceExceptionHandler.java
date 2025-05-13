package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ServiceExceptionHandler {

      @GetMapping("/ex")
      public String exception() throws IOException {
            throw new IllegalStateException("error occur");
      }
      @GetMapping("/senderror")
      public void sendError(HttpServletResponse response) throws IOException {
            response.sendError(500);
      }
}
