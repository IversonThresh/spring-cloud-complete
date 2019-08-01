package com.hejin.eurekaservercopytwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 60055233
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerCopytwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCopytwoApplication.class, args);
    }

}
