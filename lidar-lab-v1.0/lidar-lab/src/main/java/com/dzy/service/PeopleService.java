package com.dzy.service;

import com.dzy.pojo.People;

import java.util.List;

public interface PeopleService {
    // 添加一个人员，参数：姓名，图片的文件名，类型（学生S老师T），富文本
    void addPeople(String name, String filename, String type, String text);
    // 根据ID返回一个人员
    People getPeopleById(int id);
    // 获取所有人员
    List<People> getAllPeople();
    // 获取所有学生
    List<People> getAllStudent();
    // 获取所有老师
    List<People> getAllTeacher();
    // 根据ID删除人员
    void deletePeopleById(int id);
    // 根据ID修改人员，所以people的id属性不能为空且要确保正确
    void updatePeopleById(People people);
}
