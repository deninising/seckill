package com.woniu.secondkill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = {"com.woniu.secondkill.dao"})
@EnableCaching
@EnableScheduling//开启任务调度
public class SecondkillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondkillApplication.class, args);
    }
}
