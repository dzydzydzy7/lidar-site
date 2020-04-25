package com.dzy.controller;

import com.dzy.service.BannerService;
import com.dzy.service.KvtableService;
import com.dzy.service.PeopleService;
import com.dzy.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private KvtableService kvtableService;

    @RequestMapping("/home")
    public String backDoorPage(Model model) {
        model.addAttribute("pics", bannerService.getAllBanner());
        model.addAttribute("content", kvtableService.getHome());
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
        model.addAttribute("content", kvtableService.getPublications());
        return "spublications";
    }

    @RequestMapping("/research")
    public String researchPage(Model model) {
        model.addAttribute("rs", researchService.getAllResearch());
        return "sresearch";
    }

    @RequestMapping("/project")
    public String galleryPage(Model model) {
        model.addAttribute("content", kvtableService.getProject());
        return "sproject";
    }

    @RequestMapping("/aboutUs")
    public String aboutUsPage(Model model) {
        model.addAttribute("content", kvtableService.getAboutUs());
        return "saboutUs";
    }

    @RequestMapping("/others")
    public String otherPage(Model model) {
        return "sothers";
    }
}
