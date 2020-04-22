package com.dzy.service;

import com.dzy.pojo.Research;

import java.util.List;

public interface ResearchService {
    void addResearch(String name, String picture, String detail);
    List<Research> getAllResearch();
    Research getResearchById(int id);
    void updateResearchById(Research research);
    void deleteResearchById(int id);
}
