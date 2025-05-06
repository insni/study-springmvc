package io.springmvc.springmvcmaster.controller
            ;

import io.springmvc.springmvcmaster.model.MyModel;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MyController {


      @GetMapping("/form")
      public String showForm(Model model){
            model.addAttribute("myModel",new MyModel());
            return "form";

      }

      @PostMapping("/submit")
      public ResponseEntity<Map<String, MyModel>> submit(MyModel myModel, Model model) {
            return ResponseEntity.ok(Map.of("submitReq", myModel));
      }
}
