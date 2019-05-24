package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class MenuPath extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String path;
    private String name;
    private int sort;
    @Transient
    private List<MenuPath> childMenuPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
