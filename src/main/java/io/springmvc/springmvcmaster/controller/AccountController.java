package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Account;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AccountController {
    @GetMapping("/account")
    public HashMap<String, Object> getAccount(@ModelAttribute("account") Account account, BindingAwareModelMap modelMap){
        HashMap<String, Object> response = new HashMap<>();
        response.put("modelAttribute",account);

        Object accountInModelMap = modelMap.get("account");
        response.put("modelMap",accountInModelMap);

        BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult) modelMap.get("org.springframework.validation.BindingResult.account");
        response.put("bindingResult",bindingResult.getTarget());

        return response;
    }
}
