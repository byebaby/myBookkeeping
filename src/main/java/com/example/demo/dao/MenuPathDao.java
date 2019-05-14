package com.example.demo.dao;

import com.example.demo.entity.MenuPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuPathDao extends JpaRepository<MenuPath, Integer> {

    @Query(value = "select * from menu_path as m " +
            "where m.path like concat(?1,'%') and" +
            " length(m.path)-length(REPLACE(m.path,'/','')) = length(?1)-length(REPLACE(?1,'/',''))+1 ORDER BY sort ", nativeQuery = true)
    List<MenuPath> findChildNode(String path);

    @Query(value = "select * from menu_path as m where length(m.path)-length(REPLACE(m.path,'/',''))  = 1 ORDER BY sort ", nativeQuery = true)
    List<MenuPath> findRootNode();
}
