package com.example.demo.dao;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUsername(String username);
}