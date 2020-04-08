package com.dzy.controller;

import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        userDao.addUser(user);
        return "redirect:/LidarSet/others";
    }

    @PostMapping(value = "/delUser")
    public String delUser(String userName) {
        List<Object> users = userDao.getAllUsers();
        if (users.size() == 1)
            return "redirect:/LidarSet/others";
        Iterator<Object> iter = users.iterator();
        while (iter.hasNext()) {
            User u = (User) iter.next();
            if (userName.equals(u.getUserName())){
                userDao.remove(u);
                break;
            }
        }
        return "redirect:/LidarSet/others";
    }
}
