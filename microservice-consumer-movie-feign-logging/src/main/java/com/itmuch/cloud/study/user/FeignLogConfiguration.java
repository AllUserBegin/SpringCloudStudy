package com.itmuch.cloud.study.user;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignLogConfiguration {
    @Bean
    Logger.Level  feignLoggerLevel()
    {
        return  Logger.Level.FULL;
    }



}
