package com.dzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LidarSet")
public class BackPageController {
    @RequestMapping("/home")
    public String backDoorPage(Model model) {
        return "shome";
    }

    @RequestMapping("/people")
    public String peoplePage(Model model) {
        return "speople";
    }

    @RequestMapping("/publications")
    public String publicationsPage(Model model) {
        return "spublications";
    }

    @RequestMapping("/research")
    public String researchPage(Model model) {
        return "sresearch";
    }

    @RequestMapping("/gallery")
    public String galleryPage(Model model) {
        return "sgallery";
    }

    @RequestMapping("/aboutUs")
    public String aboutUsPage(Model model) {
        return "saboutUs";
    }

    @RequestMapping("/others")
    public String otherPage(Model model) {
        return "sothers";
    }
}
