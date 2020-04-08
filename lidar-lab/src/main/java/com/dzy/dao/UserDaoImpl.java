package com.dzy.dao;

import com.dzy.pojo.User;
import com.dzy.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private RedisUtils redisUtils;

    private final String key = "userList";

    @Override
    public List<Object> getAllUsers() {
        return redisUtils.LRange(key, 0, -1);
    }

    @Override
    public User getUser(long index) {
        return (User) redisUtils.LIndex(key, index);
    }

    @Override
    public boolean addUser(User user) {
        return redisUtils.Rpush(key, user);
    }

    @Override
    public boolean updateUser(long index, User user) {
        return redisUtils.LSet(key, index, user);
    }

    @Override
    public long remove(User user) {
        return redisUtils.LRemove(key, 1, user);
    }
}
