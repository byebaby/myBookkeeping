package com.example.demo;

import com.example.demo.entity.AssetAllReportView;
import com.example.demo.service.AssetAllReportViewService;
import com.example.demo.service.AssetYearReportViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private AssetYearReportViewService assetYearReportViewService;
    @Autowired
    private AssetAllReportViewService assetAllReportViewService;


    @Test
    public void contextLoads() {
        List<AssetAllReportView> assetAllReportView = new ArrayList<>();

        assetAllReportView = assetAllReportViewService.findAll();
        System.out.println(assetAllReportView);
    }
}

