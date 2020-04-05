package com.dzy.dao;

import com.dzy.pojo.Home;
import com.dzy.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HomeDaoImpl implements HomeDao {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void setValues(Home home) {
        redisUtils.set("home", home);
    }

    @Override
    public Home getValues() {
        return (Home) redisUtils.get("home");
    }
}
