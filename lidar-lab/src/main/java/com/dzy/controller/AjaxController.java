package com.dzy.controller;

import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RestController
public class AjaxController {
    @Autowired
    private ProgramUtils programUtils;

    @Autowired
    private PictureUtils pictureUtils;

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/homeelems")
    public Home bigPic(){
        return homeDao.getValues();
    }

    @PostMapping(value = "/getAllUsers")
    public List<User> getAllUser(){
        List<Object> users = userDao.getAllUsers();
        List<User> res = new ArrayList<>();
        Iterator<Object> iter = users.iterator();
        while (iter.hasNext()){
            res.add((User) iter.next());
        }
        return res;
    }

    @PostMapping(value = "/isUserExist")
    public String isUserExist(String userName) {
        if (userName == null || userName.length() == 0) return "err";
        HashSet<String> set = new HashSet<>();
        List<Object> users = userDao.getAllUsers();
        Iterator<Object> iter = users.iterator();
        while (iter.hasNext()){
            User u = (User) iter.next();
            set.add(u.getUserName());
        }
        if (set.contains(userName)) return "exist";
        return "not";
    }
}
