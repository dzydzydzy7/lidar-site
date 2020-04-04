package com.dzy.controller;

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

    @PostMapping(value = "/pic")
    public Home bigPic(){
        return new Home(pictureUtils.image2Url("thegif.gif"), "a\nb\nc");
    }
}
