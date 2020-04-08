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
//    void contextLoads() {
//        //redisTemplate.opsForValue().set("k1", "v1");
//        System.out.println(redisUtils.get("k1"));
//
//        //User user = new User("董泽宇", "123456");
//        //redisTemplate.opsForValue().set("k2", user);
//        System.out.println(redisUtils.get("k2"));
//
//        //redisTemplate.opsForValue().set("pic1", "1.PNG");
//        System.out.println(redisUtils.get("pic1"));
//
//        //redisTemplate.opsForValue().set("k1", "v1 v2\n下一段");
//        System.out.println(redisUtils.get("k1"));
//
//        System.out.println(folderUtils.getPicFolder());
//    }

//    @Test
//    void test2(){
//        homeDao.setValues(new Home("http://localhost:8080/png/1", "a b\nc"));
//        System.out.println(homeDao.getValues().getUrl());
//        System.out.println(homeDao.getValues().getDescribe());
//    }

    @Test
    void test3() {
//        userDao.addUser(new User("dzy", "123"));
//        userDao.addUser(new User("user", "password"));
//        List<Object> list = userDao.getAllUsers();
//        Iterator<Object> iter = list.iterator();
//        while (iter.hasNext()) {
//            User user = (User) iter.next();
//            System.out.println(user.getUserName() + user.getPassword());
//        }
    }

    @Test
    void test4() {
//        System.out.println(userDao.getUser(0));
//        System.out.println(userDao.getUser(1));
//        userDao.addUser(new User("test", "text"));
//        System.out.println(userDao.getUser(2).getUserName());
//        userDao.updateUser(1, new User("user", "password"));
//        System.out.println(userDao.getUser(1));
//        userDao.remove(new User("user", "password"));
//        userDao.remove(new User("dzy", "123"));
//        userDao.remove(new User(null, null));
//        test3();
    }

//    @Test
//    void test5() {
//        AjaxController c = new AjaxController();
//        System.out.println(c.isUserExist("dzy"));
//        System.out.println(c.isUserExist(""));
//        System.out.println(c.isUserExist("admin"));
//        System.out.println(c.isUserExist("abcd"));
//    }
}
