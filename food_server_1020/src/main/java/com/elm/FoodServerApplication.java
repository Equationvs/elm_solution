package com.elm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.elm.mapper") //因为没有配置类，MapperScan写在这里
public class FoodServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodServerApplication.class,args);
    }
}
