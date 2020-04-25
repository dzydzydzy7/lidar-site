package com.dzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dzy.dao.UserDao;
import com.dzy.pojo.People;
import com.dzy.pojo.Research;
import com.dzy.pojo.User;
import com.dzy.service.BannerService;
import com.dzy.service.KvtableService;
import com.dzy.service.PeopleService;
import com.dzy.service.ResearchService;
import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/settings")
public class SettingController {

    @Autowired
    private ProgramUtils programUtils;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ResearchService researchService;

    @Autowired
    private KvtableService kvtableService;

    @PostMapping(value = "/addBanner")
    public String setHome(MultipartFile picture, String text) {
        String filename = uploadPicture(picture, "", "img-");
        bannerService.addBannerPic(filename, text);
        return "redirect:/LidarSet/home";
    }

    @RequestMapping(value = "/delBanner/{id}")
    public String delBanner(@PathVariable int id) {
        bannerService.delBannerPic(id);
        return "redirect:/LidarSet/home";
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user) {
        userDao.insert(user);
        return "redirect:/LidarSet/others";
    }

    @PostMapping(value = "/delUser")
    public String delUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<User> users = userDao.selectByMap(map);
        if (users.size() == 0) return "redirect:/LidarSet/others";

        User user = users.iterator().next();
        if (user.getAuth().equals("pager")) {
            userDao.deleteByMap(map);
            return "redirect:/LidarSet/others";
        } else {
            HashMap<String, Object> mapAuth = new HashMap<>();
            mapAuth.put("auth", "admin");
            List<User> admins = userDao.selectByMap(mapAuth);
            if (admins.size() > 1) {
                userDao.deleteByMap(map);
            }
        }
        return "redirect:/LidarSet/others";
    }

    @PostMapping(value = "/updUser")
    public String updUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        userDao.update(user, wrapper);
        return "redirect:/LidarSet/others";
    }

    @RequestMapping("/imageInText")
    @ResponseBody
    public JSONObject fileUPload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        String path = programUtils.getPicFolder();
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        //解决文件名字问题：我们使用uuid;
        String filename = "ks-" + UUID.randomUUID().toString().replaceAll("-", "");
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath + "/" + filename));

        //给editormd进行回调
        JSONObject res = new JSONObject();
        // res.put("url","/upload/"+month+"/"+ filename);
        res.put("url", "/pic/" + filename);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }

    @PostMapping(value = "/addPeople")
    public String addPeople(String name, MultipartFile picture, String type, String text) {
        String filename = uploadPicture(picture, "", "p-");
        peopleService.addPeople(name, filename, type, text);
        return "redirect:/LidarSet/people";
    }

    @RequestMapping("/updPeople/{id}")
    public String updPeople(@PathVariable int id, Model model) {
        People people = peopleService.getPeopleById(id);
        model.addAttribute("pp", people);
        return "speopleUpd";
    }

    @RequestMapping("/peopleUpd/{id}")
    public String peopleUdp(@PathVariable int id, String name, MultipartFile picture, String type, String text) {
        String filename = uploadPicture(picture, null, "p-");
        People p = new People();
        p.setId(id);
        p.setName(name);
        p.setPicture(filename);
        p.setType(type);
        p.setDetail(text);
        peopleService.updatePeopleById(p);
        return "redirect:/LidarSet/people";
    }

    @RequestMapping("/delPeople/{id}")
    public String delPeople(@PathVariable int id) {
        peopleService.deletePeopleById(id);
        return "redirect:/LidarSet/people";
    }

    @PostMapping(value = "/addResearch")
    public String addResearch(String name, MultipartFile picture, String text) {
        String filename = uploadPicture(picture, "", "r-");
        researchService.addResearch(name, filename, text);
        return "redirect:/LidarSet/research";
    }

    @RequestMapping("/updResearch/{id}")
    public String updResearch(@PathVariable int id, Model model) {
        Research research = researchService.getResearchById(id);
        model.addAttribute("rsh", research);
        return "sresearchUpd";
    }

    @RequestMapping("/researchUpd/{id}")
    public String researchUpd(@PathVariable int id, String name, MultipartFile picture, String text) {
        String filename = uploadPicture(picture, null, "r-");
        Research research = new Research();
        research.setId(id);
        research.setName(name);
        research.setPicture(filename);
        research.setDetail(text);
        researchService.updateResearchById(research);
        return "redirect:/LidarSet/research";
    }

    @RequestMapping("/delResearch/{id}")
    public String delResearch(@PathVariable int id) {
        researchService.deleteResearchById(id);
        return "redirect:/LidarSet/research";
    }

    @RequestMapping("/updPublication")
    public String updPublication(String text){
        kvtableService.setPublications(text);
        return "redirect:/LidarSet/publications";
    }

    @PostMapping(value = "/updProject")
    public String updProject(String text){
        kvtableService.setProject(text);
        return "redirect:/LidarSet/project";
    }

    @PostMapping(value = "/updAboutus")
    public String updAboutus(String text) {
        kvtableService.setAboutUs(text);
        return "redirect:/LidarSet/aboutUs";
    }

    @PostMapping(value = "/updHomeContent")
    public String updHomeContent(String text) {
        kvtableService.setHome(text);
        return "redirect:/LidarSet/home";
    }

    // 上传图片
    private String uploadPicture(MultipartFile picture,String defaultName, String prefix) {
        String filename = defaultName;
        if (!picture.isEmpty()) {
            String path = programUtils.getPicFolder();
            filename = prefix + UUID.randomUUID().toString().replaceAll("-", "");
            File file = new File(path, filename);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                picture.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }
}
