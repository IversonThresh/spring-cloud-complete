package com.hejin.employeeprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeproviderApplication.class, args);
    }

}
