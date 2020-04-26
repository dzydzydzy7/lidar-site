package com.dzy.service;

public interface KvtableService {
    // 获取Publication中的富文本
    String getPublications();
    // 设置Publication中的富文本
    void setPublications(String content);
    // 获取Project中的富文本
    String getProject();
    // 设置Project中的富文本
    void setProject(String content);
    // 获取AboutUs中的富文本
    String getAboutUs();
    // 设置AboutUs中的富文本
    void setAboutUs(String content);
    // 获取home轮播图下面的富文本
    String getHome();
    // 设置home轮播图下面的富文本
    void setHome(String content);
}
