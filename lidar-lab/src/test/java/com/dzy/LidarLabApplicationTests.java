package com.dzy;

import com.dzy.dao.HomeDao;
import com.dzy.pojo.Home;
import com.dzy.utils.ProgramUtils;
import com.dzy.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LidarLabApplicationTests {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ProgramUtils folderUtils;
    @Autowired
    private HomeDao homeDao;
/*
    @Test
    void contextLoads() {
        //redisTemplate.opsForValue().set("k1", "v1");
        System.out.println(redisUtils.get("k1"));

        //User user = new User("董泽宇", "123456");
        //redisTemplate.opsForValue().set("k2", user);
        System.out.println(redisUtils.get("k2"));

        //redisTemplate.opsForValue().set("pic1", "1.PNG");
        System.out.println(redisUtils.get("pic1"));

        //redisTemplate.opsForValue().set("k1", "v1 v2\n下一段");
        System.out.println(redisUtils.get("k1"));

        System.out.println(folderUtils.getPicFolder());
    }

    @Test
    void test2(){
        homeDao.setValues(new Home("http://localhost:8080/png/1", "a b\nc"));
        System.out.println(homeDao.getValues().getUrl());
        System.out.println(homeDao.getValues().getDescribe());
    }*/

}
