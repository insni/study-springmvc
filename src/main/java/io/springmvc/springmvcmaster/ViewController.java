package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
      @GetMapping("/view")
      public String showView(Model model){
            model.addAttribute("pageTitle","welcome");
            return "welcome";
      }
}
