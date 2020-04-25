package com.dzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dzy.dao")
@SpringBootApplication
public class LidarLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LidarLabApplication.class, args);
    }

}
