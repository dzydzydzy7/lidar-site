package com.dzy.service;

import com.dzy.pojo.People;

import java.util.List;

public interface PeopleService {
    void addPeople(String name, String filename, String type, String text);
    People getPeopleById(int id);
    List<People> getAllStudent();
    List<People> getAllTeacher();
}
