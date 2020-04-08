package com.dzy.dao;

import com.dzy.pojo.User;

import java.util.List;

public interface UserDao {
    List<Object> getAllUsers();
    User getUser(long index);
    boolean addUser(User user);
    boolean updateUser(long index, User user);
    long remove(User user);
}
