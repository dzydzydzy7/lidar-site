package com.dzy.controller;

import com.dzy.dao.HomeDao;
import com.dzy.pojo.Home;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private PictureUtils pictureUtils;

    @Autowired
    private HomeDao homeDao;

    @PostMapping(value = "/home")
    public String setHome(Home home) {
        System.out.println("进入/setting/home");
        home.setUrl(pictureUtils.image2Url(home.getUrl()));
        homeDao.setValues(home);
        System.out.println("完成设置");
        return "redirect:/LidarSet/home";
    }
}
