package com.dzy.service;

import com.dzy.dao.PeopleDao;
import com.dzy.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    public void addPeople(String name, String filename, String type, String text) {
        People people = new People();
        people.setName(name);
        people.setPicture(filename);
        people.setType(type);
        people.setDetail(text);
        peopleDao.insert(people);
    }

    @Override
    public People getPeopleById(int id) {
        return peopleDao.selectById(id);
    }

    @Override
    public List<People> getAllPeople() {
        return peopleDao.selectList(null);
    }

    @Override
    public List<People> getAllStudent() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "S");
        return peopleDao.selectByMap(map);
    }

    @Override
    public List<People> getAllTeacher() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", "T");
        return peopleDao.selectByMap(map);
    }

    @Override
    public void deletePeopleById(int id) {
        peopleDao.deleteById(id);
    }

    @Override
    public void updatePeopleById(People people) {
        peopleDao.updateById(people);
    }
}
