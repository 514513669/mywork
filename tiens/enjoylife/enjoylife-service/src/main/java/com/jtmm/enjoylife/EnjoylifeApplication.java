package com.jtmm.enjoylife;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author liulong
 * @version 1.0
 * @date 2020/6/3 10:08 上午
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.jtmm.goodscenter.dao")
@EnableDiscoveryClient
@Slf4j
public class EnjoylifeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EnjoylifeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("启动成功");
    }
}
