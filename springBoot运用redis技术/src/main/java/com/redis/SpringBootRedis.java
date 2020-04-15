package com.redis;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 王阳
 * @date 2020/4/9 10:28
 */
@SpringBootApplication
@MapperScan("com.redis.*.mapper")
@EnableCaching
@EnableSwagger2
@EnableScheduling
public class SpringBootRedis {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedis.class,args);
    }
}
