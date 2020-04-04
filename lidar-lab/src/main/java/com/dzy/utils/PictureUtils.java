package com.dzy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.dzy.utils")
public class PictureUtils {
    @Autowired
    private ProgramUtils programUtils;

    public String image2Url(String str){
        str = str.toLowerCase();
        String res = programUtils.getBaseUrl();
        String[] strs = str.split("\\.");
        if (strs.length != 2){
            throw new IllegalArgumentException("not a picture, it should be xxx.xxx");
        }
        return res + strs[1] + "/" + strs[0];
    }
}
