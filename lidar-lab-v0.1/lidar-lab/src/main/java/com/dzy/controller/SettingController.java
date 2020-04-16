package com.dzy.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.service.BannerService;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.ProgramUtils;
import com.dzy.utils.RedisUtils;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/settings")
public class SettingController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ProgramUtils programUtils;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/addBanner")
    public String setHome(MultipartFile picture, String text) {
        String path = programUtils.getPicFolder();
        String filename = "img-" + UUID.randomUUID().toString().replaceAll("-", "");
        File file = new File(path, filename);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bannerService.addBannerPic(filename, text);
        return "redirect:/LidarSet/home";
    }

    @RequestMapping(value = "/delBanner/{id}")
    public String delBanner(@PathVariable int id){
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
}
