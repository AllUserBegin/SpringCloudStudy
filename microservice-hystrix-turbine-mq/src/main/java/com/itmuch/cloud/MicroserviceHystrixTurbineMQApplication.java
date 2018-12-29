package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class MicroserviceHystrixTurbineMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHystrixTurbineMQApplication.class, args);
    }

}

