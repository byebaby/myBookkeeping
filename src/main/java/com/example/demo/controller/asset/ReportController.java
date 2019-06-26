package com.example.demo.controller.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/asset/report")
    public String report() {
        return "/asset/report";
    }
}
