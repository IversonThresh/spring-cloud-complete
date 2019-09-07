package com.hejin.providerclient;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 60055233
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderclientApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //指定重试策略，随机策略
        return new RandomRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderclientApplication.class, args);
    }

}
