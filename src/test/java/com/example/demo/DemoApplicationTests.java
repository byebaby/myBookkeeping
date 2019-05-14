package com.example.demo;

import com.example.demo.service.MenuPathService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    MenuPathService menuPathService;

    @Test
    public void contextLoads() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(111);
        mapper.writeValueAsString(menuPathService.findMenu());

    }
}

