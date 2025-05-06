package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ItemController {


      @PostMapping("/item")
      @ResponseBody
      public Map<String, Item> handleForm(@ModelAttribute Item item, Model model) {
            return Map.of("item", item);

      }
}
