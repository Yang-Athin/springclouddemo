package com.yang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication//启动类的注解
@EnableEurekaServer//将项目作为SpringCloud中的注册中心的注解
public class EurekaServerApplication {
    public static void main(String[] args) {
        //创建SpringApplication对象；在对象初始化时保存事件监听器，容器初始化类以及判断是否为web应用，
        // 保存包含main方法的主配置类。
        //调用run方法；准备spring的上下文，完成容器的初始化，创建，加载等。会在不同的时机触发监听器的不同事件。
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
