package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
实际上是一个配置类，会扫描其所在包以及子包下的所有类
@Component
@Controller
@Service
@Repository
 */

@SpringBootApplication
public class CommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
        System.out.println("hello world!");
    }

}
