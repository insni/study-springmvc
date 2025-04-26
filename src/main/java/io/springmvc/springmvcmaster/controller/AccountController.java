package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Account;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
@RestController
public class AccountController {
    @ModelAttribute
    public Account account(){
        return new Account("John");
    }
    @PostMapping
    public Account processAccount(@ModelAttribute Account account)  {
        return account;
    }
    @PutMapping
    public Account save(@ModelAttribute("account") Account account){
        return account;
    }
    @GetMapping
    public Account getAccount(@ModelAttribute Account account){
        return account;
    }
}
