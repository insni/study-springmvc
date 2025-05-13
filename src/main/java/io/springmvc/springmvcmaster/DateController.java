package io.springmvc.springmvcmaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class DateController {
      @GetMapping("/date")
      public String testDate(@RequestParam Date date){
            return "date: " + date;
      }
}
