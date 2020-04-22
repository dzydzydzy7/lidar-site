package com.dzy.controller;

import com.dzy.pojo.People;
import com.dzy.pojo.Research;
import com.dzy.service.BannerService;
import com.dzy.service.PeopleService;
import com.dzy.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LidarSet")
public class BackPageController {
    @Autowired
    private BannerService bannerService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ResearchService researchService;

    @RequestMapping("/home")
    public String backDoorPage(Model model) {
        model.addAttribute("pics", bannerService.getAllBanner());
        return "shome";
    }

    @RequestMapping("/people")
    public String peoplePage(Model model) {
        model.addAttribute("ts", peopleService.getAllTeacher());
        model.addAttribute("ss", peopleService.getAllStudent());
        return "speople";
    }

    @RequestMapping("/publications")
    public String publicationsPage(Model model) {
        return "spublications";
    }

    @RequestMapping("/research")
    public String researchPage(Model model) {
        model.addAttribute("rs", researchService.getAllResearch());
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
