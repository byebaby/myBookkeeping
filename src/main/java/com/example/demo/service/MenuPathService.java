package com.example.demo.service;

import com.example.demo.entity.MenuPath;

import java.util.List;

public interface MenuPathService {
    //todo 待确认是否有更合适的树形菜单实现方法
    List<MenuPath> findMenu();

}
