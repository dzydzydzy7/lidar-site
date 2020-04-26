package com.dzy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.dzy.utils")
public class PictureUtils {
    @Autowired
    private ProgramUtils programUtils;

    // 把图片转为URL，已经弃用的方法
    public String image2Url(String str){
        String res = programUtils.getBaseUrl();
        String[] strs = str.split("\\.");
        if (strs.length != 2){
            throw new IllegalArgumentException("not a picture, it should be xxx.xxx");
        }
        return res + strs[1].toLowerCase() + "/" + strs[0];
    }
}
