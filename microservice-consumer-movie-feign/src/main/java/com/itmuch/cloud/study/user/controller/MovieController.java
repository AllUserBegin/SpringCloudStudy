package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

@RestController
public class MovieController {
  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    User entity= this.userFeignClient.findById(id);
    return  entity;
  }
}
