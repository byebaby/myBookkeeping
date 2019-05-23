package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;       // 用户id
    @Column(unique = true)
    private String username;   // 登录名，不可改
    private String nick;    // 用户昵称，可改
    private String password;     // 已加密的登录密码
    private String password_salt;    // 加密盐值
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<UserRole> userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_salt() {
        return password_salt;
    }

    public void setPassword_salt(String password_salt) {
        this.password_salt = password_salt;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}
