package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String role_name;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "userRole", cascade = {CascadeType.ALL})
    private List<RolePerm> rolePerms;

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

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RolePerm> getRolePerms() {
        return rolePerms;
    }

    public void setRolePerms(List<RolePerm> rolePerms) {
        this.rolePerms = rolePerms;
    }
}
