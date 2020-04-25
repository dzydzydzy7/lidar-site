package com.dzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dzy.pojo.User;
import org.springframework.stereotype.Repository;

@Repository // 表示持久层
public interface UserDao extends BaseMapper<User> {
    // 框架完成了所有crud
}
