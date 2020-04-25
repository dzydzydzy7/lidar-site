package com.dzy.service;

import com.dzy.pojo.Banner;

import java.util.List;

public interface BannerService {
    // 添加轮播图片的名称和解释文字
    void addBannerPic(String picture, String text);

    // 获取所有的轮播图片
    List<Banner> getAllBanner();

    // 根据id删除轮播图
    void delBannerPic(int id);
}
