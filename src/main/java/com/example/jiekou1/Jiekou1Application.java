package com.example.jiekou1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/jiekou1/Mapper")
public class Jiekou1Application {

    public static void main(String[] args) {
        SpringApplication.run(Jiekou1Application.class, args);
    }

}
