package com.dzy.service;

import com.dzy.dao.UserDao;
import com.dzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String username) {
        List<Object> list = userDao.getAllUsers();
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            User u = (User) iter.next();
            if (username.equals(u.getUserName())){
                u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
                return u;
            }
        }
        return null;
    }
}
