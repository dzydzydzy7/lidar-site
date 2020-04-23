package com.dzy.controller;

import com.dzy.pojo.People;
import com.dzy.pojo.Research;
import com.dzy.service.KvtableService;
import com.dzy.service.PeopleService;
import com.dzy.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LidarLab")
public class PageController {
    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ResearchService researchService;

    @Autowired
    private KvtableService kvtableService;

    @RequestMapping("/home")
    public String homePage(Model model) {
        return "home";
    }

    @RequestMapping("/people")
    public String peoplePage(Model model) {
        model.addAttribute("teachers", peopleService.getAllTeacher());
        model.addAttribute("students", peopleService.getAllStudent());
        return "people";
    }

    @RequestMapping("/publications")
    public String publicationsPage(Model model) {
        model.addAttribute("content", kvtableService.getPublications());
        return "publications";
    }

    @RequestMapping("/research")
    public String researchPage(Model model) {
        model.addAttribute("researches", researchService.getAllResearch());
        return "research";
    }

    @RequestMapping("/project")
    public String galleryPage(Model model) {
        model.addAttribute("content", kvtableService.getProject());
        return "project";
    }

    @RequestMapping("/aboutUs")
    public String aboutUsPage(Model model) {
        model.addAttribute("content", kvtableService.getAboutUs());
        return "aboutUs";
    }

    @RequestMapping("/people/{id}")
    public String peopleDetail(@PathVariable("id") int id, Model model) {
        People people = peopleService.getPeopleById(id);
        model.addAttribute("people", people);
        return "peopleDetail";
    }

    @RequestMapping("/research/{id}")
    public String researchDetail(@PathVariable int id, Model model) {
        Research research = researchService.getResearchById(id);
        model.addAttribute("research", research);
        return "researchDetail";
    }
}
