package com.dzy;

import com.dzy.controller.AjaxController;
import com.dzy.dao.HomeDao;
import com.dzy.dao.UserDao;
import com.dzy.pojo.Home;
import com.dzy.pojo.User;
import com.dzy.utils.ProgramUtils;
import com.dzy.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class LidarLabApplicationTests {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ProgramUtils folderUtils;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private UserDao userDao;

//    @Test
//    void test1() {
//        List<User> users = userDao.selectList(null);
//        users.forEach(System.out::println);
//    }
}
