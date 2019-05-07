package com.example.demo.service;

import com.example.demo.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findRoleByUserName(String username);
}
