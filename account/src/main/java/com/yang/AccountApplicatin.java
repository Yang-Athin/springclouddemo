package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.repository")
public class AccountApplicatin {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplicatin.class, args);
    }
}
