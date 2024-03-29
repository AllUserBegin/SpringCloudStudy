package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGetewayZuulFallBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGetewayZuulFallBackApplication.class, args);
    }

}

