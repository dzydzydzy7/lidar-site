package com.dzy.service;

import com.dzy.pojo.User;

public interface UserService {
    // 根据用户名称获取用户对象
    User getUserByUserName(String username);
}
