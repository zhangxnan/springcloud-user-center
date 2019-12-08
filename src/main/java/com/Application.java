package com;

import com.deepexi.springcloud.demo.service.LoopNoticeServie;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by donh on 2018/11/5.
 * EnableDiscoveryClient 用于启动服务发现功能
 * EnableFeignClients 用于启动Fegin功能
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Map<String, LoopNoticeServie> beansOfType = context.getBeansOfType(LoopNoticeServie.class);

        System.out.println(beansOfType.size());

        for (LoopNoticeServie noticeServie : beansOfType.values()){
            new Thread(() -> {
                noticeServie.loopNotice();
            }).start();
        }

    }
}