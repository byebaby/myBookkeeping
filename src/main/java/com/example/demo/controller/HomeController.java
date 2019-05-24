package com.example.demo.controller;

import com.example.demo.service.MenuPathService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final MenuPathService menuPathService;

    public HomeController(MenuPathService menuPathService) {
        this.menuPathService = menuPathService;
    }

    @GetMapping("/home")
    public String home(ModelMap map) {
        map.addAttribute("user", SecurityUtils.getSubject().getPrincipal());
        map.addAttribute("menus", menuPathService.findMenu());
        return "home";
    }
}
