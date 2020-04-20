package com.dzy.controller;

import com.dzy.pojo.People;
import com.dzy.service.PeopleService;
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

    @RequestMapping("/people/{id}")
    public String peopleDetail(@PathVariable("id") int id, Model model) {
        People people = peopleService.getPeopleById(id);
        model.addAttribute("people", people);
        return "peopleDetail";
    }
}
