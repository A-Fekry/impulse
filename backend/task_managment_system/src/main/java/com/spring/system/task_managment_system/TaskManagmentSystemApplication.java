package com.spring.system.task_managment_system;

import com.spring.system.task_managment_system.sitting.TokenConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(TokenConfig.class)
@SpringBootApplication
public class TaskManagmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagmentSystemApplication.class, args);
    }

}
