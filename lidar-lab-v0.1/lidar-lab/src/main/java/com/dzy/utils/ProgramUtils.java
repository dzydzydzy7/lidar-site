package com.dzy.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "dzy")
@ComponentScan(basePackages = "com.dzy.utils")
public class ProgramUtils {
    // 图片资源的存放位置
    private String picFolder;
    // 项目根目录(根url)
    private String baseUrl;
}
