package com.dzy.config;

import com.dzy.utils.ProgramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    @Autowired
    private ProgramUtils programUtils;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = programUtils.getPicFolder();
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/pic/**").addResourceLocations("file:" + path);
    }
}
