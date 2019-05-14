package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @RequiresAuthentication
    @GetMapping("/account/debt")
    public String getDebt() {
        return "/account/debt";
    }
}
