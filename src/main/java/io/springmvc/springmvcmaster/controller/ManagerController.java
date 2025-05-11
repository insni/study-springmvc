package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Manager;
import io.springmvc.springmvcmaster.model.Member;
import io.springmvc.springmvcmaster.model.Vgroups;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {

      @PostMapping
      public Map<String, Object> addManager(
                  @Validated({Vgroups.CreateGroup.class})
                  @ModelAttribute Manager manager,
                  BindingResult result,
                  Model model,
                  Map map) {
            Map<String, Object> body = new HashMap<>();
            body.put("model", manager);
            if (result.hasErrors()) {
                  body.put("viewName", "managerAddForm");
                  return body;
            }
            body.put("viewName", "managerSuccess");
            return body;
      }
      @PatchMapping
      public Map<String, Object> updateManager(
                  @Validated({
                              Vgroups.UpdateGroup.class})
                  @ModelAttribute Manager manager,
                  BindingResult result,
                  Model model,
                  Map map) {
            Map<String, Object> body = new HashMap<>();
            body.put("model", manager);
            if (result.hasErrors()) {
                  body.put("viewName", "managerUpdateForm");
                  return body;
            }
            body.put("viewName", "managerSuccess");
            return body;
      }
}
