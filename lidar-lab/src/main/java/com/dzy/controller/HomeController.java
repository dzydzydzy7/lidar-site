package com.dzy.controller;

import com.dzy.dao.HomeDao;
import com.dzy.pojo.Home;
import com.dzy.utils.PictureUtils;
import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeC")
public class HomeController {
    @Autowired
    private ProgramUtils programUtils;

    @Autowired
    private PictureUtils pictureUtils;

    @Autowired
    private HomeDao homeDao;

    @PostMapping(value = "/pic")
    public Home bigPic(){
        return homeDao.getValues();
    }
}
