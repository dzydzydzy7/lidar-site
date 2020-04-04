package com.dzy.controller;

import com.dzy.pojo.Home;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingController {
    @PostMapping(value = "/home")
    public String setHome(Home home) {
        System.out.println(home.getUrl());
        System.out.println(home.getDescribe());
        return "backdoor";
    }
}
