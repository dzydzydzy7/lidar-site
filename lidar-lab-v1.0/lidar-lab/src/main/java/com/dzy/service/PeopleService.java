package com.dzy.service;

import com.dzy.pojo.People;

import java.util.List;

public interface PeopleService {
    void addPeople(String name, String filename, String type, String text);
    People getPeopleById(int id);
    List<People> getAllPeople();
    List<People> getAllStudent();
    List<People> getAllTeacher();
    void deletePeopleById(int id);
    void updatePeopleById(People people);
}
