package io.springmvc.springmvcmaster;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/response/status")
public class ResponseStatusExceptionController {

      @GetMapping("/validate")
      @ResponseBody
      public String validateInput(@RequestParam(required = false) String input) {
            if (input == null || input.isEmpty()) {
                  throw new ResponseStatusException(
                              HttpStatus.BAD_REQUEST,
                              "Input is invalid");

            }
            return "valid input is " + input;
      }

}