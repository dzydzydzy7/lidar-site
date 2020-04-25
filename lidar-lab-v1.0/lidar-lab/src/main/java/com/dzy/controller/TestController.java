package com.dzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("title", "Thymeleaf Test");
        model.addAttribute("msg", "<h2>需要转义的内容</h2>");
        model.addAttribute("array", Arrays.asList("item1", "item2", "item3"));
        return "test";
    }
}
