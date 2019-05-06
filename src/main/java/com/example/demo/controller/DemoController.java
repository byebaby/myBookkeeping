package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoController {

    private final UserService userService;

    @Autowired
    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String postLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            currentUser.checkPermission("test");
        } catch (UnknownAccountException uae) {
            System.out.println("1");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("2");
        } catch (LockedAccountException lae) {
            System.out.println("3");
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("4");
        } catch (AuthenticationException ae) {
            System.out.println("5");
        }
        return username + password;
    }

    @RequiresGuest
    @ResponseBody
    @GetMapping("/hello1")
    public User demo1() {
        return userService.findUserByName("1111");
    }
}
