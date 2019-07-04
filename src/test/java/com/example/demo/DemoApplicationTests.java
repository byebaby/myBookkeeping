package com.example.demo;

import com.example.demo.entity.AssetDetail;
import com.example.demo.entity.AssetMain;
import com.example.demo.service.AssetDetailService;
import com.example.demo.service.AssetReportViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private AssetReportViewService assetReportViewService;
    @Autowired
    private AssetDetailService assetDetailService;


    @Test
    public void contextLoads() {
        AssetMain assetMain=new AssetMain();
//        System.out.println(assetDetailService.findAllByAssetMain(assetMain.setUserId();));
    }
}

