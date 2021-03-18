package com.example.oright;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.oright.dao")
@SpringBootApplication
public class OrightApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrightApplication.class, args);
    }

}
