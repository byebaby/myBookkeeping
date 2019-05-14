package com.example.demo.service.impl;

import com.example.demo.dao.MenuPathDao;
import com.example.demo.entity.MenuPath;
import com.example.demo.service.MenuPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MenuPathService")
public class MenuPathServiceImpl implements MenuPathService {
    private final MenuPathDao menuPathDao;

    @Autowired
    public MenuPathServiceImpl(MenuPathDao menuPathDao) {
        this.menuPathDao = menuPathDao;
    }

    @Override
    public List<MenuPath> findMenu() {
        List<MenuPath> menuPaths = menuPathDao.findRootNode();
        for (MenuPath menuPath : menuPaths) {
            menuPath.setChildMenuPath(findChildNode(menuPath.getPath()));
        }
        return menuPaths;
    }

    private List<MenuPath> findChildNode(String parentPath) {

        List<MenuPath> menuPaths = menuPathDao.findChildNode(parentPath);

        for (MenuPath menuPath : menuPaths) {
            menuPath.setChildMenuPath(findChildNode(menuPath.getPath()));
        }
        return menuPaths;
    }

}
