package com.dzy.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.RedisUtils;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private PictureUtils pictureUtils;

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/home")
    public String setHome(Home home) {
        System.out.println("进入/setting/home");
        home.setUrl(pictureUtils.image2Url(home.getUrl()));
        homeDao.setValues(home);
        System.out.println("完成设置");
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
}
