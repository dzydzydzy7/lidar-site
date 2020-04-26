package com.dzy.service;

import com.dzy.pojo.Research;

import java.util.List;

public interface ResearchService {
    // 添加一个研究，参数，研究名称，图片名称，富文本
    void addResearch(String name, String picture, String detail);
    // 返回所有的研究
    List<Research> getAllResearch();
    // 根据ID获得一个研究
    Research getResearchById(int id);
    // 根据ID更新研究，所以所以research的id属性不能为空且要确保正确
    void updateResearchById(Research research);
    // 根据ID删除一个研究
    void deleteResearchById(int id);
}
