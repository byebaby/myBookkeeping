package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class MenuPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    private String name;
    private int sort;
    @Transient
    private List<MenuPath> childMenuPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<MenuPath> getChildMenuPath() {
        return childMenuPath;
    }

    public void setChildMenuPath(List<MenuPath> childMenuPath) {
        this.childMenuPath = childMenuPath;
    }
}
