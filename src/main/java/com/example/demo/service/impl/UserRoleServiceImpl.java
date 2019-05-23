package com.example.demo.service.impl;

import com.example.demo.dao.UserRoleDao;
import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRole> findRoleByUserName(String username) {
        return userRoleDao.findByUsername(username);
    }
}
