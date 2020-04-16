package com.dzy.controller;

import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Banner;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.service.BannerService;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AjaxController {
    @Autowired
    private ProgramUtils programUtils;

    @Autowired
    private PictureUtils pictureUtils;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/getPics")
    public List<Banner> getPics(){
        List<Banner> list = bannerService.getAllBanner();
        return list;
    }

    @PostMapping(value = "/getAllUsers")
    public List<User> getAllUser(){
        List<User> users = userDao.selectList(null);
        List<User> res = new ArrayList<>();
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()){
            res.add((User) iter.next());
        }
        return res;
    }

    @PostMapping(value = "/isUserExist")
    public String isUserExist(String username) {
        if (username == null || username.length() == 0) return "err";
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<User> users = userDao.selectByMap(map);
        if (users.size() == 0) return "not";
        return "exist";
    }
}
