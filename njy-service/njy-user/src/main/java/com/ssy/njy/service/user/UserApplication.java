package com.ssy.njy.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户模块启动主类
 *
 * @author: mqxu
 * @date: 2021-07-26
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.ssy.njy.service.user.mapper"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}