package com.dzy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dzy.dao.KvtableDao;
import com.dzy.pojo.Kvtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KvtableServiceImpl implements KvtableService {
    @Autowired
    private KvtableDao kvtableDao;

    @Override
    public String getPublications() {
        QueryWrapper<Kvtable> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "publications");
        Kvtable kvtable = kvtableDao.selectOne(wrapper);
        if (kvtable == null) return null;
        return kvtable.getContent();
    }

    @Override
    public void setPublications(String content) {
        Kvtable kvtable = new Kvtable();
        kvtable.setContent(content);
        UpdateWrapper<Kvtable> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "publications");
        kvtableDao.update(kvtable, wrapper);
    }

    @Override
    public String getProject() {
        QueryWrapper<Kvtable> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "projects");
        Kvtable kvtable = kvtableDao.selectOne(wrapper);
        if (kvtable == null) return null;
        return kvtable.getContent();
    }

    @Override
    public void setProject(String content) {
        Kvtable kvtable = new Kvtable();
        kvtable.setContent(content);
        UpdateWrapper<Kvtable> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "projects");
        kvtableDao.update(kvtable, wrapper);
    }

    @Override
    public String getAboutUs() {
        QueryWrapper<Kvtable> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "aboutus");
        Kvtable kvtable = kvtableDao.selectOne(wrapper);
        if (kvtable == null) return null;
        return kvtable.getContent();
    }

    @Override
    public void setAboutUs(String content) {
        Kvtable kvtable = new Kvtable();
        kvtable.setContent(content);
        UpdateWrapper<Kvtable> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "aboutus");
        kvtableDao.update(kvtable, wrapper);
    }
}
