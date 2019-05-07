package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles_permissions")
public class RolePerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;
    private String permission;

}
