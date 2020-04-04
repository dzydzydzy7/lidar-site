package com.dzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LidarLab")
public class PageController {
    @RequestMapping("/home")
    public String homePage(Model model) {
        return "home";
    }

    @RequestMapping("/people")
    public String peoplePage(Model model) {
        return "people";
    }

    @RequestMapping("/publications")
    public String publicationsPage(Model model) {
        return "publications";
    }

    @RequestMapping("/research")
    public String researchPage(Model model) {
        return "research";
    }

    @RequestMapping("/gallery")
    public String galleryPage(Model model) {
        return "gallery";
    }

    @RequestMapping("/aboutUs")
    public String aboutUsPage(Model model) {
        return "aboutUs";
    }

    @RequestMapping("/set")
    public String backDoorPage(Model model) {
        return "backdoor";
    }
}
