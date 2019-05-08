package com.example.demo.service;

import com.example.demo.entity.User;


public interface UserService {

    User findUserByName(String username);

    User save(User user);
}
