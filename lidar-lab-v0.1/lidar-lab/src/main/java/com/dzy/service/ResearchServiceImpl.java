package com.dzy.service;

import com.dzy.dao.ResearchDao;
import com.dzy.pojo.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {
    @Autowired
    private ResearchDao researchDao;

    @Override
    public void addResearch(String name, String picture, String detail) {
        Research research = new Research();
        research.setName(name);
        research.setPicture(picture);
        research.setDetail(detail);
        researchDao.insert(research);
    }

    @Override
    public List<Research> getAllResearch() {
        return researchDao.selectList(null);
    }

    @Override
    public Research getResearchById(int id) {
        return researchDao.selectById(id);
    }

    @Override
    public void updateResearchById(Research research) {
        researchDao.updateById(research);
    }

    @Override
    public void deleteResearchById(int id) {
        researchDao.deleteById(id);
    }
}
