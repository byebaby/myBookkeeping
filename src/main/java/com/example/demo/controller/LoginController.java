package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import com.example.demo.vo.Json;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Controller
public class LoginController {

    private final UserService userService;
    private final
    UserRoleService userRoleService;

    @Autowired
    public LoginController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @ResponseBody
    @PostMapping("/checkname")
    public Json checkName(String username) {
        if (userService.findUserByName(username) != null) {
            return Json.succ("checkname", "该用户名已被占用!").code(Json.DEFAULT_FAIL_CODE);
        } else {
            return Json.succ("checkname", "该用户名可用");
        }

    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @ResponseBody
    @PostMapping("/register")
    public Json postRegister(String username, String password) {
        String pattern1 = "^\\d+\\d+\\d$";  // '用户名不能全为数字';
        String pattern2 = "[A-Za-z0-9\\-\\u4e00-\\u9fa5]+";  //'用户名不能有特殊字符
        String pattern4 = "^[\\S]{6,12}$"; // '密码必须6到12位，且不能出现空格'
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                userService.findUserByName(username) != null ||
                Pattern.matches(pattern1, username) || !Pattern.matches(pattern2, username) ||
                !Pattern.matches(pattern4, password)) {
            return Json.succ("register", "注册失败").code(Json.DEFAULT_FAIL_CODE);
        }
        Date date = new Date();
        User user = new User();
        user.setUsername(username);
        user.setCreated(date);
        user.setUpdated(date);
        Map map = encrPassword(password);
        user.setPassword_salt(map.get("salt").toString());
        user.setPassword(map.get("saltPassword").toString());
        userService.save(user);
        return Json.succ("register", "注册成功").data("id", user.getId());
    }

    private Map encrPassword(String password) {
        Map<String, String> hashMap = new HashMap<>();
        String hashAlgorithmName = "MD5";//加密方式
        int hashIterations = 3;//加密3次
        String salt = ByteSource.Util.bytes(password).toBase64();
        String result = new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toHex();

        hashMap.put("salt", salt);
        hashMap.put("saltPassword", result);
        return hashMap;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public List<UserRole> postLogin(String username, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return userRoleService.findRoleByUserName(currentUser.getPrincipal().toString());
    }

    @RequiresGuest
    @ResponseBody
    @GetMapping("/hello1")
    public User demo1() {
        return userService.findUserByName("1111");
    }
}
