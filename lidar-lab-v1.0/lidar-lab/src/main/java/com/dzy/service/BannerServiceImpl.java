package com.dzy.service;

import com.dzy.dao.BannerDao;
import com.dzy.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public void addBannerPic(String picture, String text) {
        Banner banner = new Banner();
        banner.setPicture(picture);
        banner.setText(text);
        bannerDao.insert(banner);
    }

    @Override
    public List<Banner> getAllBanner() {
        List<Banner> list = bannerDao.selectList(null);
        Iterator<Banner> iter = list.iterator();
        while (iter.hasNext()){
            Banner banner = iter.next();
            banner.setPicture("/pic/" + banner.getPicture());
        }
        return list;
    }

    @Override
    public void delBannerPic(int id) {
        bannerDao.deleteById(id);
    }
}
