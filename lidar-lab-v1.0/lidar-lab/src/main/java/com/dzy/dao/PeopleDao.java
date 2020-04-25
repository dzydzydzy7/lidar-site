package com.dzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dzy.pojo.People;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends BaseMapper<People> {
}
