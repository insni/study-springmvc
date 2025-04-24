package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.dto.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class IndexController {
    @GetMapping({"/index"})
    public String index(@ModelAttribute("account") AccountDTO dto, BindingAwareModelMap modelMap){
        Object accountDTO = modelMap.get("account");
        Object bindingResult = modelMap.get("org.springframework.validation.BindingResult.account");
        return "index";
    }
}
